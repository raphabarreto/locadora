package com.locadora.handle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.bo.ClienteBO;
import com.locadora.bo.LocacaoBO;
import com.locadora.model.Cliente;
import com.locadora.model.Filme;
import com.locadora.model.Locacao;

@ManagedBean
public class LocacaoHandle {

	private Filme filme = new Filme();
	private Cliente cliente = new Cliente();
	private Locacao locacao = new Locacao();
	private Locacao locacao2 = new Locacao();
	private List<Locacao> locacoes = new ArrayList<Locacao>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	

	public LocacaoHandle() {
		locacoes = LocacaoBO.localizarAll();
		clientes = ClienteBO.localizarAll();
	}



	public void inserir() {

		List<Filme> lista = new ArrayList<Filme>();
		lista.add(filme);
		locacao.setCliente(cliente);
		locacao.setFilmes(lista);
		locacao.setDataEmprestimo(Calendar.getInstance().getTime());

		LocacaoBO.inserir(locacao);
		locacoes = LocacaoBO.localizarAll();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Locação realizada!"));
		locacao = null;

	}

	public void alterar(RowEditEvent event) {

		Locacao l = (Locacao) event.getObject();

		Locacao l2 = LocacaoBO.localizar(l.getCodigoLocacao());

		List<Filme> lista = new ArrayList<Filme>();
		lista.add(filme);
		
		l2.setCliente(cliente);
		l2.setFilmes(lista);

		LocacaoBO.atualizar(l2);
		locacoes = LocacaoBO.localizarAll();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Devolução realizada!"));
		locacao = null;

	}
	

	public void excluir() {

		LocacaoBO.excluir(locacao2.getCodigoLocacao());
		locacoes = LocacaoBO.localizarAll();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Locação Excluída"));

	}

	
	public void devolver() {

	
		Locacao loc = LocacaoBO.localizar(locacao2.getCodigoLocacao());
		
		loc.setDataDevolucao(Calendar.getInstance().getTime());
		LocacaoBO.atualizar(loc);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Locação Devolvida!"));
	
		locacoes = LocacaoBO.localizarAll();
	

	}


	public Filme getFilme() {
		return filme;
	}



	public void setFilme(Filme filme) {
		this.filme = filme;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Locacao getLocacao() {
		return locacao;
	}



	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}



	public Locacao getLocacao2() {
		return locacao2;
	}



	public void setLocacao2(Locacao locacao2) {
		this.locacao2 = locacao2;
	}



	public List<Locacao> getLocacoes() {
		return locacoes;
	}



	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}