package com.locadora.bo;

import java.util.List;

import com.locadora.dao.ClienteDAO;
import com.locadora.model.Cliente;

public class ClienteBO {
	
	public static Cliente inserir(Cliente c){
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.inserir(c);
	}
	
	public static void excluir(int id){
		ClienteDAO cDAO = new ClienteDAO();;
		cDAO.excluir(id);
	}
	
	public static Cliente localizar(int id){
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.localizar(id);
	}
	
	public static List<Cliente> localizarAll(){
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.localizarAll();
	}

}
