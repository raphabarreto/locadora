package com.locadora.bo;

import java.util.List;

import com.locadora.dao.LocacaoDAO;
import com.locadora.model.Locacao;

public class LocacaoBO {
	
	public static Locacao inserir(Locacao l){
		LocacaoDAO lDAO = new LocacaoDAO();
		return lDAO.inserir(l);		
	}

	public static void excluir(int id){
		LocacaoDAO lDAO = new LocacaoDAO();
		lDAO.excluir(id);
	}
	
	public static Locacao localizar(int id){
		LocacaoDAO lDAO = new LocacaoDAO();
		return lDAO.localizar(id);
	}
	
	public static List<Locacao> localizarAll(){
		LocacaoDAO lDAO = new LocacaoDAO();
		return lDAO.localizarAll();
	}
	
	public static void atualizar (Locacao locacao){
		LocacaoDAO lDAO = new LocacaoDAO();
		lDAO.atualizar(locacao);
	}

}
