
package com.locadora.bo;

import java.util.List;

import com.locadora.dao.EstoqueDAO;
import com.locadora.model.Estoque;

public class EstoqueBO {

	public static Estoque inserir(Estoque e){
		EstoqueDAO eDAO = new EstoqueDAO();
		return eDAO.inserir(e);		
	}

	public static void excluir(int id){
		EstoqueDAO eDAO = new EstoqueDAO();
		eDAO.excluir(id);
	}
	
	public static Estoque localizar(int id){
		EstoqueDAO eDAO = new EstoqueDAO();
		return eDAO.localizar(id);
	}
	
	public static List<Estoque> localizarAll(){
		EstoqueDAO eDAO = new EstoqueDAO();
		return eDAO.localizarAll();
	}

}
