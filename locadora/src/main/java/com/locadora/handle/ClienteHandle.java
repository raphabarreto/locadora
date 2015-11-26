package com.locadora.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.locadora.dao.ClienteDAO;
import com.locadora.model.Cliente;

@ManagedBean
public class ClienteHandle {

	private Cliente cliente = new Cliente();
	private Cliente cliente2 = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ClienteDAO clienteDAO = new ClienteDAO();
	

	public ClienteHandle() {
		
		clientes = clienteDAO.localizarAll();
	}

	public void inserir() {

		if (!cliente.getNome().equals("")) {
			clienteDAO.inserir(cliente);
			clientes = clienteDAO.localizarAll();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Cliente "
					+ cliente.getNome() + " adicionado!"));
			cliente = null;

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Informe o nome do cliente."));
		}

	}

	public void alterar(RowEditEvent event) {

		Cliente c = (Cliente) event.getObject();
		Cliente c2 = clienteDAO.localizar(c.getCodigoPessoa());
		c2.setNome(c.getNome());
		clienteDAO.atualizar(c2);
		clientes = clienteDAO.localizarAll();
	}

	public void excluir() {

		if (cliente2 != null){
			clienteDAO.excluir(cliente2.getCodigoPessoa());
			clientes = clienteDAO.localizarAll();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso...", "Cliente "
					+ cliente2.getNome() + " excluído!"));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Ops...","ocorreu um erro!"));
		}

		cliente = null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente2() {
		return cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
}