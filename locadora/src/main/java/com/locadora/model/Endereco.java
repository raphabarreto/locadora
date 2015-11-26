package com.locadora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoEndereco;
	private String logradouro;
	private String cep;

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [codigoEndereco=" + codigoEndereco + ", logradouro="
				+ logradouro + ", cep=" + cep + "]";
	}
}
