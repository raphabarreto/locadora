package com.locadora.bo;

import java.util.List;

import com.locadora.dao.FilmeDAO;
import com.locadora.model.Filme;

public class FilmeBO {
	
	public static Filme inserir(Filme f){
		FilmeDAO fDAO = new FilmeDAO();
		return fDAO.inserir(f);		
	}

	public static void excluir(int id){
		FilmeDAO fDAO = new FilmeDAO();
		fDAO.excluir(id);
	}
	
	public static Filme localizar(int id){
		FilmeDAO fDAO = new FilmeDAO();
		return fDAO.localizar(id);
	}
	
	public static List<Filme> localizarAll(){
		FilmeDAO fDAO = new FilmeDAO();
		return fDAO.localizarAll();
	}

}
