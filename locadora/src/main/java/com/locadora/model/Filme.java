package com.locadora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoFilme;
	private String titulo;
	private String sinopse;
	private double valor;
	@OneToOne
	@JoinColumn(name="codigoCategoria")
	private Categoria categoria;
	
	public Filme() {
		
	}

	public Filme(String titulo, String sinopse, double valor,
			Categoria categoria) {
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.valor = valor;
		this.categoria = categoria;
	}

	
	public int getCodigoFilme() {
		return codigoFilme;
	}

	public void setCodigoFilme(int codigoFilme) {
		this.codigoFilme = codigoFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Filme [codigoFilme=" + codigoFilme + ", titulo=" + titulo
				+ ", sinopse=" + sinopse + ", valor=" + valor + ", categoria="
				+ categoria + "]";
	}
}
