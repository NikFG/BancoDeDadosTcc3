package com.tcc.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "noticias")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String textoNoticia;
	private String chamada;
	private String titulo;

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return textoNoticia;
	}

	public void setTexto(String textoNoticia) {
		this.textoNoticia = textoNoticia;

	}

	public String getChamada() {
		return chamada;
	}

	public void setChamada(String chamada) {
		this.chamada = chamada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "noticia [ idnoticia=" + id + " , textoNoticia=" + textoNoticia + " , chamada=" + chamada + " ,titulo="
				+ titulo + " ]";
	}
}
