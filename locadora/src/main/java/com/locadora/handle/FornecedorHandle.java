package com.locadora.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.dao.FornecedorDAO;
import com.locadora.model.Endereco;
import com.locadora.model.Fornecedor;

@ManagedBean
public class FornecedorHandle {

	private Fornecedor fornecedor = new Fornecedor();
	private Fornecedor fornecedor2 = new Fornecedor();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private FornecedorDAO fornecedorDAO = new FornecedorDAO();
	private Endereco endereco = new Endereco();
	
	
	public FornecedorHandle() {		
		fornecedores = fornecedorDAO.localizarAll();
	}

	public void inserir() {

		if (!fornecedor.getRazaoSocial().equals("")) {
			fornecedorDAO.inserir(fornecedor);
			fornecedores = fornecedorDAO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Fornecedor "
					+ fornecedor.getRazaoSocial() + " adicionado!"));
			fornecedor = null;

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Informe o nome do cliente."));
		}

	}

	public void alterar(RowEditEvent event) {

		Fornecedor f = (Fornecedor) event.getObject();

		Fornecedor f2 = fornecedorDAO.localizar(f.getCodigoPessoa());

		f2.setRazaoSocial(f.getRazaoSocial());
		f2.setNome(f.getNome());
		f2.setIe(f.getIe());

		fornecedorDAO.atualizar(f2);
		fornecedores = fornecedorDAO.localizarAll();

	}

	public void excluir() {


		if (fornecedor2 != null){

			fornecedorDAO.excluir(fornecedor2.getCodigoPessoa());
			fornecedores = fornecedorDAO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Fornecedor "
					+ fornecedor2.getRazaoSocial() + " excluído!"));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Ops...","ocorreu um erro!"));
		}

		fornecedor = null;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor2() {
		return fornecedor2;
	}

	public void setFornecedor2(Fornecedor fornecedor2) {
		this.fornecedor2 = fornecedor2;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public FornecedorDAO getFornecedorDAO() {
		return fornecedorDAO;
	}

	public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}