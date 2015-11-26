package com.locadora.bo;

import java.util.List;

import com.locadora.dao.CategoriaDAO;
import com.locadora.model.Categoria;

public class CategoriaBO {
	
	public static void inserir(Categoria c){
		CategoriaDAO cDAO = new CategoriaDAO();
		 cDAO.inserir(c);
	}
	
	public static void excluir(int id){
		CategoriaDAO cDAO = new CategoriaDAO();
		cDAO.excluir(id);
	}
	
	public static Categoria localizar(int id){
		CategoriaDAO cDAO = new CategoriaDAO();
		return cDAO.localizar(id);
	}
	
	public static List<Categoria> localizarAll(){
		CategoriaDAO cDAO = new CategoriaDAO();
		return cDAO.localizarAll();
	}

	
	public static void atualizar (Categoria categoria){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.atualizar(categoria);
	}
}
