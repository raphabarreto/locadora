package com.locadora.bo;

import java.util.List;

import com.locadora.dao.FornecedorDAO;
import com.locadora.model.Fornecedor;

public class FornecedorBO {

	public static Fornecedor inserir(Fornecedor f){
		FornecedorDAO fDAO = new FornecedorDAO();
		return fDAO.inserir(f);		
	}

	public static void excluir(int id){
		FornecedorDAO fDAO = new FornecedorDAO();
		fDAO.excluir(id);
	}

	public static Fornecedor localizar(int id){
		FornecedorDAO fDAO = new FornecedorDAO();
		return fDAO.localizar(id);
	}

	public static List<Fornecedor> localizarAll(){
		FornecedorDAO fDAO = new FornecedorDAO();
		return fDAO.localizarAll();
	}

}
