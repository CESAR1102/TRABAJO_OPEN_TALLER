package edu.upc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import edu.upc.core.dao.ClienteDaoPostgres;
import edu.upc.core.entity.Cliente;
import edu.upc.core.idao.IClienteDao;
@Named("ClienteController")
@ViewScoped
public class ClienteController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private Cliente cliente;
	private IClienteDao clienteDAO;
	
	public ClienteController(){
		clienteDAO = new ClienteDaoPostgres();
		cliente= new Cliente();
		clientes= clienteDAO.listarClientes();
	}
	
	
	public String guardarCliente(){
		String rpta="";
		try {
			clienteDAO.insertCliente(cliente);
			this.getCliente();
			rpta="ListadoClientes?faces-redirect=true";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;
	}
	
	
	
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public IClienteDao getClienteDAO() {
		return clienteDAO;
	}
	public void setClienteDAO(IClienteDao clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	
	
	
	

}
