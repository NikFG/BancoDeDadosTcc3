package com.tcc.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="noticias")
public class ListaNoticias implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Noticia> noticias;
	
	@XmlElement(name="noticia")
	public List<Noticia> getNoticia(){
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias){
		this.noticias = noticias;
	}
	@Override
	public String toString(){
		return "ListaNoticias [noticias= "+ noticias + "]";
	}
}
