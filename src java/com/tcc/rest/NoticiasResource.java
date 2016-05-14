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
	public List<Noticia> get(){
		List<Noticia> noticias = noticiaService.getNoticias();
		return noticias;
	}
	
	@GET
	@Path("{id}")
	public Noticia get(@PathParam("id") long id){
		Noticia n = noticiaService.getNoticiaId(id);
		return n;
		
	}
	@GET
	@Path("/titulo/{titulo}")
	public List<Noticia> getByTitulo(@PathParam("titulo") String titulo){
		List<Noticia>noticias = noticiaService.findByTitulo(titulo);
		return noticias;
	}
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("idnoticia") long id){
		noticiaService.delete(id);
		return Response.Ok("Deletado");
	}
	@POST
	public Response post(Noticia n){
		noticiaService.save(n);
		return Response.Ok("Salvo");
	}
	@PUT
	public Response put(Noticia n){
		noticiaService.save(n);
		return Response.Ok("Atualizado");
	}
}

/*
 * @Path("/carros")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CarrosResource {
	private CarroService carroService = new CarroService();

	@GET
	public List<Carro> get() {
		List<Carro> carros = carroService.getCarros();
		return carros;
	}

	@GET
	@Path("{id}")
	public Carro get(@PathParam("id") long id) {
		Carro c = carroService.getCarro(id);
		return c;
	}

	@GET
	@Path("/tipo/{tipo}")
	public List<Carro> getByTipo(@PathParam("tipo") String tipo) {
		List<Carro> carros = carroService.findByTipo(tipo);
		return carros;
	}

	@GET
	@Path("/nome/{nome}")
	public List<Carro> getByNome(@PathParam("nome") String nome) {
		List<Carro> carros = carroService.findByName(nome);
		return carros;
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		carroService.delete(id);
		return Response.Ok("Carro deletado com sucesso");
	}

	@POST
	public Response post(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro salvo com sucesso");
	}

	@PUT
	public Response put(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro atualizado com sucesso");
	}
}
 */
 