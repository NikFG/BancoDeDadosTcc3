package com.tcc.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class NoticiaService {
	@Autowired
	private NoticiaDAO db;
	
	public List<Noticia> getNoticias(){
		List<Noticia> noticias = db.getNoticia();
		return noticias;
	}
	public Noticia getNoticiaId(Long id){
		//object = db.getNoticiaById(id); 
		return db.getNoticiaById(id);
	}
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Long id){
		return db.delete(id);
	}
	public boolean save(Noticia news){
		db.saveOrUpdate(news);
		return true;
	}
	public List<Noticia> findByTitulo(String titulo){
		return db.findByTitulo(titulo);
	}
}
