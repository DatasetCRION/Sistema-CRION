package br.com.medaula.dao;

import com.google.inject.ImplementedBy;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.UsuarioDAOImpl;
import br.com.medaula.entity.Usuario;

@ImplementedBy(UsuarioDAOImpl.class)
public interface UsuarioDAO extends BaseDAO<Usuario> {
	
	public Usuario findByLogin(String login);
	
}
