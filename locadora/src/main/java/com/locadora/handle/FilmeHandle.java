package com.locadora.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.bo.FilmeBO;
import com.locadora.bo.LocacaoBO;
import com.locadora.dao.FilmeDAO;
import com.locadora.model.Categoria;
import com.locadora.model.Filme;

@ManagedBean
public class FilmeHandle {

	private Filme filme = new Filme();
	private Filme filme2 = new Filme();
	private Categoria categoria = new Categoria();
	private List<Filme> filmes = new ArrayList<Filme>();
	private FilmeDAO dao = new FilmeDAO();

	public FilmeHandle() {

		filmes= dao.localizarAll();

	}

	public void inserir() {

		if (!filme.getTitulo().equals("")) {

			filme.setCategoria(categoria);

			dao.inserir(filme);
			filmes= dao.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Filme "
					+ filme.getTitulo() + " adicionado!"));
			filme = null;

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Informe o título do filme."));
		}

	}

	public void alterar(RowEditEvent event) {

		Filme f = (Filme) event.getObject();

		Filme f2 = dao.localizar(f.getCodigoFilme());

		f2.setTitulo(f.getTitulo());
		f2.setSinopse(f.getSinopse());
		f2.setValor(f.getValor());

		dao.atualizar(f2);
		filmes = dao.localizarAll();

	}

	public void excluir() {

		if (LocacaoBO.localizar(filme2.getCodigoFilme()) == null){

			FilmeBO.excluir(filme2.getCodigoFilme());
			filmes = FilmeBO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Filme "
					+ filme2.getTitulo() + " excluído!"));
		} else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Este filme não pode ser excluído pois está locado!"));
		}
	}
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Filme getFilme2() {
		return filme2;
	}

	public void setFilme2(Filme filme2) {
		this.filme2 = filme2;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public FilmeDAO getDao() {
		return dao;
	}

	public void setDao(FilmeDAO dao) {
		this.dao = dao;
	}
}
