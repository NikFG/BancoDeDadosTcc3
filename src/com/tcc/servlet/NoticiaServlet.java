package com.tcc.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcc.servlet.*;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.tcc.util.RegexUtil;
import com.tcc.util.ServletUtil;
import com.tcc.domain.*;

@WebServlet("/noticias/*")
public class NoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticiaService noticiaService = new NoticiaService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI();
		Long id = RegexUtil.matchId(requestUri);
		if (id != null) {
			Noticia noticia = noticiaService.getNoticiaId(id);
			if (noticia != null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(noticia);
				ServletUtil.writeJSON(resp, json);
			} else {
				resp.sendError(404, "Noticia não encontrada");
			}
		} else {
			// Lista de noticias
			List<Noticia> noticias = noticiaService.getNoticias();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(noticias);
			ServletUtil.writeJSON(resp, json);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// cria a noticia
		Noticia noticia = getNoticiaFromRequest(req);
		// salva a noticia
		noticiaService.save(noticia);
		// Escreve o json da noticia
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(noticia);
		ServletUtil.writeJSON(resp, json);
	}

	private Noticia getNoticiaFromRequest(HttpServletRequest req) {
		Noticia n = new Noticia();
		String id = req.getParameter("idnoticia");
		if (id != null) {
			// se informou o id ele busca do banco
			n = noticiaService.getNoticiaId(Long.parseLong(id));
		}
		n.setChamada(req.getParameter("chamada"));
		n.setTitulo(req.getParameter("titulo"));
		n.setTexto(req.getParameter("textoNoticia"));
		return n;
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String requestUri = req.getRequestURI();
			Long id = RegexUtil.matchId(requestUri);
			if (id!=null){
				noticiaService.delete(id);
				Response r = Response.Ok("Carro excluído com sucesso");
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(r);
				ServletUtil.writeJSON(resp, json);
			}
			else{
				resp.sendError(404,"URL inválida");
			}
	}
}
