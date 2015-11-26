package com.locadora.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	@ManyToMany
	@JoinTable(name="cliente_categoria", joinColumns={@JoinColumn(name="codigo_cliente", referencedColumnName="codigoPessoa") }, inverseJoinColumns={@JoinColumn(name="codigo_categoria", referencedColumnName="codigoCategoria") } )
	private List<Categoria> preferencias;

	public Cliente() {

	}	

	public Cliente(String cpf, List<Categoria> preferencias) {
		this.cpf = cpf;
		this.preferencias = preferencias;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Categoria> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Categoria> preferencias) {
		this.preferencias = preferencias;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", getCodigoPessoa()="
				+ getCodigoPessoa() + ", getNome()=" + getNome() + "]";
	}
}
