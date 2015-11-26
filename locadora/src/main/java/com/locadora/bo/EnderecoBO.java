package com.locadora.bo;

import java.util.List;

import com.locadora.dao.EnderecoDAO;
import com.locadora.model.Endereco;

public class EnderecoBO {
	
	public static Endereco inserir(Endereco e){
		EnderecoDAO eDAO = new EnderecoDAO();
		return eDAO.inserir(e);
	}
	
	public static void excluir(int id){
		EnderecoDAO eDAO = new EnderecoDAO();
		eDAO.excluir(id);
	}
	
	public static Endereco localizar(int id){
		EnderecoDAO eDAO = new EnderecoDAO();
		return eDAO.localizar(id);
	}
	
	public static List<Endereco> localizarAll(){
		EnderecoDAO eDAO = new EnderecoDAO();
		return eDAO.localizarAll();
	}

}
