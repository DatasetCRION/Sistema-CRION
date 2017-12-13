package br.com.medaula.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import br.com.medaula.config.Constantes;
import br.com.medaula.entity.Lugar;
import br.com.medaula.service.LugarService;
import br.com.medaula.util.Util;

@Path(value = "/lugar")
@Produces("application/json; charset=UTF-8")
public class LugarResource {

    @Inject
    private LugarService lugarService;

    @GET
    @Transactional
    public List<Lugar> getLugars() {

        try {
            return lugarService.findAll();

        } catch (Exception e) {
            Response response = Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            throw new WebApplicationException(response);
        }

    }

    @GET
    @Transactional
    @Path("{id}")
    public Lugar getLugar(@PathParam("id") Long id) {

        try {
            return lugarService.findById(id);
        } catch (Exception e) {
            Response response = Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            throw new WebApplicationException(response);
        }
    }

    @POST
    @Transactional
    public Lugar salvarLugar(Lugar lugar) {
        try {
            return lugarService.saveOrUpdate(lugar);
        } catch (Exception e) {
            Response response = Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            throw new WebApplicationException(response);
        }
    }

    @DELETE
    @Transactional
    @Path(value = "{id}")
    public Response remover(@PathParam("id") Long id) {

        try {
            lugarService.deleteById(id);
            return Response.ok(new Object() {
                @SuppressWarnings("unused")
                public String msg = Constantes.REGISTRO_REMOVIDO_SUCESSSO;
                @SuppressWarnings("unused")
                public int status = Response.Status.OK.getStatusCode();
            }).build();

        } catch (Exception e) {
            ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST.getStatusCode());
            rb = rb.entity(new Object() {
                @SuppressWarnings("unused")
                public String msg = Constantes.REGISTRO_POSSUI_DEPENDENCIAS;
            });
            return rb.build();
        }
    }
}
