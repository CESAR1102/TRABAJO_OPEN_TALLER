package edu.upc.core.entity;

import java.io.Serializable;

public class Proveedor implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private long Ruc;
	private String Nombre;
	private long Telefono;
	private String Ciudad;
	private int Confiabilidad;
	
	
	public Proveedor() {
		
	}
	public Proveedor(long ruc, String nombre, long telefono, String ciudad, int confiabilidad) {
		
		Ruc = ruc;
		Nombre = nombre;
		Telefono = telefono;
		Ciudad = ciudad;
		Confiabilidad = confiabilidad;
	}
	
	@Override
	public String toString() {
		return "Proveedor [Ruc=" + Ruc + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Ciudad=" + Ciudad
				+ ", Confiabilidad=" + Confiabilidad + "]";
	}
	public long getRuc() {
		return Ruc;
	}
	public void setRuc(long ruc) {
		Ruc = ruc;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public long getTelefono() {
		return Telefono;
	}
	public void setTelefono(long telefono) {
		Telefono = telefono;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public int getConfiabilidad() {
		return Confiabilidad;
	}
	public void setConfiabilidad(int confiabilidad) {
		Confiabilidad = confiabilidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
