package br.com.medaula.dao;

import com.google.inject.ImplementedBy;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.LoginDAOImpl;
import br.com.medaula.entity.Usuario;

@ImplementedBy(LoginDAOImpl.class)
public interface LoginDAO extends BaseDAO<Usuario> {
	public Usuario findByLogin(String login);

}
