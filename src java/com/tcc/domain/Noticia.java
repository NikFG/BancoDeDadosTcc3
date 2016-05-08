package com.tcc.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "noticias")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idnoticia",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length=50)
	private String textoNoticia;
	@Column(nullable=false, length=100)
	private String chamada;
	@Column(nullable=false, length=50)
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
		return "Noticia [ idnoticia=" + id + " , textoNoticia=" + textoNoticia + " , chamada=" + chamada + " ,titulo="
				+ titulo + " ]";
	}
}
