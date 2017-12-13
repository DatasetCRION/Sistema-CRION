package br.com.medaula.model;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import br.com.medaula.entity.Usuario;

public class UsuarioCorrente extends User {

	private static final long serialVersionUID = -2854909573492022906L;
	private Usuario pessoa;
	
   public UsuarioCorrente(Usuario usuario) {
	   
        super(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.createAuthorityList("ADM"));
        this.pessoa = usuario;
    }

	public Usuario getUsuario() {
		return pessoa;
	}

	public void setUsuario(Usuario pessoa) {
		this.pessoa = pessoa;
	}
	
}
