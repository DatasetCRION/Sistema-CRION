package br.com.medaula.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;

import br.com.medaula.entity.vo.UsuarioVO;
import br.com.medaula.service.UsuarioService;

@Path(value = "/commons")
@Produces("application/json; charset=UTF-8")
public class CommonsResource {
	
	@Inject private UsuarioService usuarioService;
	
	@Path("usuario")
	@GET
	public UsuarioVO getUsuarioLogado() {
		return usuarioService.getUsuarioLogado();
	}
}
