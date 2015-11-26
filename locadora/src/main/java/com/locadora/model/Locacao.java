package com.locadora.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoLocacao;
	@OneToOne
	@JoinColumn(name="codigoPessoa")
	private Cliente cliente;
	@ManyToMany
	@JoinTable(name="locacao_filme", joinColumns={@JoinColumn(name="codigoLocacao", referencedColumnName="codigoLocacao") }, inverseJoinColumns={@JoinColumn(name="codigoFilme", referencedColumnName="codigoFilme") } )
	private List<Filme> filmes;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_emprestimo")
	private Date dataEmprestimo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_devolucao")
	private Date dataDevolucao;

	public Locacao() {

	}

	public Locacao(Cliente cliente, List<Filme> filmes,
			Date dataEmprestimo, Date dataDevolucao) {
		this.cliente = cliente;
		this.filmes = filmes;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}



	public int getCodigoLocacao() {
		return codigoLocacao;
	}

	public void setCodigoLocacao(int codigoLocacao) {
		this.codigoLocacao = codigoLocacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "Locacao [codigoLocacao=" + codigoLocacao + ", cliente="
				+ cliente + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucao=" + dataDevolucao + "]";
	}
}