package br.com.medaula.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.medaula.dao.UsuarioDAO;
import br.com.medaula.dao.base.BaseDAOImpl;
import br.com.medaula.entity.Usuario;

public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

	public Usuario findByLogin(String login) {
		if (login != null) {
			Session session = (Session) getEntityManager().getDelegate();
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("email", login));
			Usuario pessoa = (Usuario) criteria.uniqueResult();
			return pessoa;
		} else {
			return null;
		}
	}
}
