package com.tcc.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "noticias")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idnoticia;
	private String textoNoticia;
	private String chamada;
	private String titulo;
	private Long falaMais;
	private Long falaMenos;
	private Long report;
	
	public Long getID() {
		return idnoticia;
	}

	public void setID(Long idnoticia) {
		this.idnoticia = idnoticia;
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
	public Long getFalaMais() {
		return falaMais;
	}

	public void setFalaMais(Long falaMais) {
		this.falaMais = falaMais;
	}

	public Long getFalaMenos() {
		return falaMenos;
	}

	public void setFalaMenos(Long falaMenos) {
		this.falaMenos = falaMenos;
	}

	public Long getReport() {
		return report;
	}

	public void setReport(Long report) {
		this.report = report;
	}
	
	@Override
	public String toString() {
		return "[idnoticia=" + idnoticia + " , textoNoticia=" + textoNoticia + " , chamada=" + chamada +
				" ,titulo=" + titulo +" , falaMais=" +falaMais+ " , falaMenos=" +falaMenos +", report="+ report+" ]";
	}


}
