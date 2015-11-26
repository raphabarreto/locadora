package com.locadora.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.locadora.bo.CategoriaBO;
import com.locadora.bo.ClienteBO;
import com.locadora.bo.EnderecoBO;
import com.locadora.bo.EstoqueBO;
import com.locadora.bo.FilmeBO;
import com.locadora.bo.FornecedorBO;
import com.locadora.bo.LocacaoBO;
import com.locadora.model.Categoria;
import com.locadora.model.Cliente;
import com.locadora.model.Endereco;
import com.locadora.model.Estoque;
import com.locadora.model.Filme;
import com.locadora.model.Fornecedor;
import com.locadora.model.Locacao;

public class Teste {

	public static void main(String[] args) {

		// Inserir Categorias
		Categoria c = new Categoria("Terror");
		CategoriaBO.inserir(c);
		Categoria c2 = new Categoria("Romance");
		CategoriaBO.inserir(c2);
		Categoria c3 = new Categoria("Comedia");
		CategoriaBO.inserir(c3);

		// Inserir Endereco
		Endereco end1 = new Endereco();
		end1.setCep("999999");
		end1.setLogradouro("Rua Teste");
		EnderecoBO.inserir(end1);
		Endereco end2 = new Endereco();
		end2.setCep("11111");
		end2.setLogradouro("Avenida Teste 2");
		EnderecoBO.inserir(end2);



		// Inserir Fornecedor
		Fornecedor f = new Fornecedor("11.444.777/0001-XX", "Filmes Brasil LTDA", "110.042.490.114");
		f.setNome("Fornecedor");
		FornecedorBO.inserir(f);

		// Inserir Filme
		Filme film = new Filme("A casa de cera", "Filme sobre uma casa de cera", 5.50, CategoriaBO.localizar(1));
		FilmeBO.inserir(film);


		// Inserir Estoque
		Estoque estq = new Estoque("Filmes Terror", FilmeBO.localizar(1), FornecedorBO.localizar(1),5);
		EstoqueBO.inserir(estq);


		// Inserir Cliente
		List<Categoria> prefs = new ArrayList<Categoria>();
		prefs.add(CategoriaBO.localizar(1));
		prefs.add(CategoriaBO.localizar(2));
		prefs.add(CategoriaBO.localizar(3));

		Cliente cli = new Cliente("384.290.158-50", prefs);
		cli.setNome("Guilherme Mastria");

		List<Endereco> ends = new ArrayList<Endereco>();
		ends.add(EnderecoBO.localizar(1));
		ends.add(EnderecoBO.localizar(2));
		cli.setEnderecos(ends);
		ClienteBO.inserir(cli);

		// Inserir Locacao
		List<Filme> filmes = new ArrayList<Filme>();
		filmes.add(FilmeBO.localizar(1));
		Locacao loc = new Locacao(ClienteBO.localizar(2), filmes, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		LocacaoBO.inserir(loc);



		// Listar tudo
		System.out.println("------------------------------");
		System.out.println(ClienteBO.localizarAll());
		System.out.println("------------------------------");
		System.out.println(LocacaoBO.localizarAll());
		System.out.println("------------------------------");
		System.out.println(FilmeBO.localizarAll());
		System.out.println("------------------------------");
		System.out.println(FornecedorBO.localizarAll());
		System.out.println("------------------------------");
		System.out.println(EstoqueBO.localizarAll());
		System.out.println("------------------------------");
		System.out.println(CategoriaBO.localizarAll());
		System.out.println("------------------------------");




		// Listar por codigo
		System.out.println("------------------------------");
		System.out.println(LocacaoBO.localizar(1));
		System.out.println("------------------------------");
		System.out.println(CategoriaBO.localizar(3));
		System.out.println("------------------------------");
		System.out.println(FilmeBO.localizar(1));
		System.out.println("------------------------------");
		System.out.println(ClienteBO.localizar(2));
		System.out.println("------------------------------");
		System.out.println(EstoqueBO.localizar(1));
		System.out.println("------------------------------");
		System.out.println(FornecedorBO.localizar(1));
		System.out.println("------------------------------");
		System.out.println(EnderecoBO.localizar(2));
		System.out.println("------------------------------");

		// Exclus�o
		EstoqueBO.excluir(1);
		LocacaoBO.excluir(1);
		FilmeBO.excluir(1);
		FornecedorBO.excluir(1);
		ClienteBO.excluir(2);
		CategoriaBO.excluir(1);
		EnderecoBO.excluir(1);

		
		// Atualizar
		Categoria categoria = new Categoria();
		categoria.setCodigoCategoria(3);
		categoria.setDescricao("Atualizar est� funcionando !");
		CategoriaBO.atualizar(categoria);
		
	}
}