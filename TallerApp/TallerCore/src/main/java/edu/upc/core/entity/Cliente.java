package edu.upc.core.entity;

import java.io.Serializable;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int codigoCliente;
	private String  DNI;
	private String Nombre;
	private String Ciudad ;
	private String Telefono;
	
	public Cliente() {
	}

	public Cliente(int codigoCliente, String dNI, String nombre, String ciudad, String telefono) {
	
		this.codigoCliente = codigoCliente;
		this.DNI = dNI;
		this.Nombre = nombre;
		this.Ciudad = ciudad;
		this.Telefono = telefono;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI= dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		this.Ciudad = ciudad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Ciudad=" + Ciudad
				+ ", Telefono=" + Telefono + "]";
	}
	
	
	
	
	

}
