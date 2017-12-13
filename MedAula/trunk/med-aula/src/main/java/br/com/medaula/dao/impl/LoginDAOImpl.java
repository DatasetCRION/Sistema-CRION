package br.com.medaula.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.medaula.dao.LoginDAO;
import br.com.medaula.dao.base.BaseDAOImpl;
import br.com.medaula.entity.Usuario;

public class LoginDAOImpl extends BaseDAOImpl<Usuario> implements LoginDAO {
	
	public Usuario findByLogin(String login) {
		if(login != null){
			Session session = 	(Session) getEntityManager().getDelegate();
			Criteria criteria = session.createCriteria(Usuario.class); 
			criteria.add(Restrictions.eq("email",login));
			Usuario pessoa = (Usuario) criteria.uniqueResult();
			return pessoa;
		}
		else{
			return null;
		}
	}
	
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medaula");
		EntityManager em = emf.createEntityManager();
		return em;
		
	}
	
}
