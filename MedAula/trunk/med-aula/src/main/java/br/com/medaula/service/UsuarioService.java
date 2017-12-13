package br.com.medaula.service;

import com.google.inject.ImplementedBy;

import br.com.medaula.entity.Usuario;
import br.com.medaula.entity.vo.UsuarioVO;
import br.com.medaula.service.base.BaseService;
import br.com.medaula.service.impl.UsuarioServiceImpl;

@ImplementedBy(UsuarioServiceImpl.class)
public interface UsuarioService extends BaseService<Usuario> {

	public UsuarioVO getUsuarioLogado();
	public Usuario findByLogin(String login);
	
}
