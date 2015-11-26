package com.locadora.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoPessoa;
	private String nome;
	@ManyToMany
	@JoinTable(name="pessoa_endereco", joinColumns={@JoinColumn(name="codigo_pessoa", referencedColumnName="codigoPessoa") }, inverseJoinColumns={@JoinColumn(name="codigo_endereco", referencedColumnName="codigoEndereco") } )
	private List<Endereco> enderecos;


	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
