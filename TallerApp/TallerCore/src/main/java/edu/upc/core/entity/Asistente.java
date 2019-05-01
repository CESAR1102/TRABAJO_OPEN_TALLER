package edu.upc.core.entity;

import java.io.Serializable;

public class Asistente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoAsistente;
	private String Nombre;
	
	public Asistente() {
	
	}

	public Asistente(int codigoAsistente, String nombre) {
		super();
		this.codigoAsistente = codigoAsistente;
		Nombre = nombre;
	}

	public int getCodigoAsistente() {
		return codigoAsistente;
	}

	public void setCodigoAsistente(int codigoAsistente) {
		this.codigoAsistente = codigoAsistente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	

	@Override
	public String toString() {
		return "Asistente [codigoAsistente=" + codigoAsistente + ", Nombre=" + Nombre + "]";
	}
	
	
	



}
