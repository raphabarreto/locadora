package com.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	@Column(name="razao_social")
	private String razaoSocial;
	private String ie;

	public Fornecedor() {}

	public Fornecedor(String cnpj, String razaoSocial, String ie) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.ie = ie;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial
				+ ", ie=" + ie + "]";
	}
}
