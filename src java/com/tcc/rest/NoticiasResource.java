package com.tcc.rest;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.tcc.domain.*;

@Path("/noticias")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class NoticiasResource {
	private NoticiaService noticiaService = new NoticiaService();

	@GET
	public List<Noticia> get() {
		List<Noticia> noticias = noticiaService.getNoticias();
		return noticias;
	}

	@GET
	@Path("{idnoticia}")
	public Noticia get(@PathParam("idnoticia") long idnoticia) {
		Noticia n = noticiaService.getNoticiaId(idnoticia);
		return n;
	}

	@GET
	@Path("/titulo/{titulo}")
	public List<Noticia> getByTitulo(@PathParam("titulo") String titulo) {
		List<Noticia> noticias = noticiaService.findByTitulo(titulo);
		return noticias;
	}

	@GET
	@Path("/tipo/{tipoNoticia}")
	public List<Noticia> findByTipo(@PathParam("tipoNoticia") Long tipo) {
		List<Noticia> noticias = noticiaService.findByTipo(tipo);
		return noticias;
	}

	@DELETE
	@Path("/delete/{idnoticia}")
	public Response delete(@PathParam("idnoticia") long idnoticia) {
		noticiaService.delete(idnoticia);
		return Response.Ok("Deletado");
	}

	@POST
	public Response post(Noticia n) {
		noticiaService.save(n);
		return Response.Ok("Salvo");
	}

	@PUT
	public Response put(Noticia n) {
		noticiaService.save(n);
		return Response.Ok("Atualizado");
	}
}
