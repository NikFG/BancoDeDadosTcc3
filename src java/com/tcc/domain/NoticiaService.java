package com.tcc.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticiaService {
	private NoticiaDAO db = new NoticiaDAO();
	
	public List<Noticia> getNoticias(){
		try{
			List<Noticia> noticias = db.getNoticia();
			return noticias;
		}catch(SQLException e){
			e.printStackTrace();
			return new ArrayList<Noticia>();
		}
	}
	public Noticia getNoticiaId(Long id){
		try{
			//object = db.getNoticiaById(id); 
			return db.getNoticiaById(id);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	public boolean delete(Long id){
		try {
			return db.delete(id);
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean save(Noticia news){
		try{
			db.save(news);
			return true;		
		}catch (SQLException e) {
			return false;
		}
	}
	public List<Noticia> findByTitulo(String titulo){
		try {
			return db.findByTitulo(titulo);
		} catch (SQLException e) {
			return null;
		}
	}
	public List<Noticia>findByTipo(Long tipo){
		try{
			return db.findByTipo(tipo);
		}catch(SQLException e){
			return null;
		}
	}
	public boolean UpdateFalaMais(Noticia news){
		try{
			db.UpdateFalaMais(news);
			return true;		
		}catch (SQLException e) {
			return false;
		}
	}
	public boolean UpdateFalaMenos(Noticia news){
		try{
			db.UpdateFalaMenos(news);
			return true;		
		}catch (SQLException e) {
			return false;
		}
	}
	public boolean UpdateReport(Noticia news){
		try{
			db.UpdateReport(news);
			return true;		
		}catch (SQLException e) {
			return false;
		}
	}
}
