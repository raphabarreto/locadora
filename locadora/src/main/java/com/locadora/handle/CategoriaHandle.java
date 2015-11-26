package com.locadora.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.dao.CategoriaDAO;
import com.locadora.model.Categoria;

public class CategoriaHandle {
	
	private Categoria categoria = new Categoria();
	private Categoria categoria2 = new Categoria();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private CategoriaDAO categoriaDAO = new CategoriaDAO();


	public void inserir() {

		if (!categoria.getDescricao().equals("")) {
			categoriaDAO.inserir(categoria);
			categorias= categoriaDAO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Categoria "
					+ categoria.getDescricao() + " adicionada!"));
			categoria = null;

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Informe a descrição da categoria."));
		}

	}

	public void alterar(RowEditEvent event) {

		Categoria c = (Categoria) event.getObject();

		Categoria c2 = categoriaDAO.localizar(c.getCodigoCategoria());

		c2.setDescricao(c.getDescricao());

		categoriaDAO.atualizar(c2);
		categorias= categoriaDAO.localizarAll();

	}

	public void excluir() {
		
		
		if (categoria2 != null){

		categoriaDAO.excluir(categoria2.getCodigoCategoria());
		categorias= categoriaDAO.localizarAll();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso...", "Categoria "
				+ categoria2.getDescricao() + " excluída!"));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Ops...","ocorreu um erro!"));
		}
		
		categoria = null;
			
	}
	
	
	public CategoriaHandle () {
		categorias = categoriaDAO.localizarAll();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria2() {
		return categoria2;
	}

	public void setCategoria2(Categoria categoria2) {
		this.categoria2 = categoria2;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
}