package com.locadora.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.dao.EnderecoDAO;
import com.locadora.model.Endereco;


@ManagedBean
public class EnderecoHandle {

	
	private Endereco endereco = new Endereco();
	private Endereco endereco2 = new Endereco();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();

	
	public void inserir() {

		if (!endereco.getCep().equals("")) {
			enderecoDAO.inserir(endereco);
			enderecos = enderecoDAO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Endereco "
					+ endereco.getLogradouro() + " adicionado!"));
			endereco = null;

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Informe o cep do Endereço."));
		}

	}

	public void alterar(RowEditEvent event) {

		Endereco e = (Endereco) event.getObject();

		Endereco e2 = enderecoDAO.localizar(e.getCodigoEndereco());

		e2.setCep(e.getCep());
		e2.setLogradouro(e.getLogradouro());

		enderecoDAO.atualizar(e2);
		enderecos = enderecoDAO.localizarAll();

	}

	public void excluir() {
		
		
		if (endereco2 != null){

		enderecoDAO.excluir(endereco2.getCodigoEndereco());
		enderecos = enderecoDAO.localizarAll();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Endereço "
				+ endereco.getLogradouro() + " excluído!"));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Ops...","ocorreu um erro!"));
		}
		
		endereco = null;
			
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco2() {
		return endereco2;
	}

	public void setEndereco2(Endereco endereco2) {
		this.endereco2 = endereco2;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
}
