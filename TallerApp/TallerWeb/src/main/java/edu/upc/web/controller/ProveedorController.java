package edu.upc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import edu.upc.core.entity.Proveedor;

import edu.upc.core.idao.IProveedorDao;

@Named("ProveedorController")
@ViewScoped
public class ProveedorController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Proveedor> proveedores;
	private Proveedor proveedor;
	private IProveedorDao proveedorDAO;
	
	public String guardarProveedor(){
		String rpta="";
		try {
			proveedorDAO.insertarProveedor(proveedor);
			this.getProveedor();
			rpta="ListadoProveedores?faces-redirect=true";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public IProveedorDao getProveedorDAO() {
		return proveedorDAO;
	}

	public void setProveedorDAO(IProveedorDao proveedorDAO) {
		this.proveedorDAO = proveedorDAO;
	}
	
	
	
	
	
	
}
