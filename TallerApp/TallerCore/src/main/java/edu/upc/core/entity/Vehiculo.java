package edu.upc.core.entity;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idVehiculo;
	private String num_placa;
	private String modelo;
	private String marca;
	private int anio;
	private String color;
	private String cliente;
	private String tipo_vehiculo;
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(int idVehiculo, String num_placa, String modelo, String marca, int anio, String color,
			String cliente, String tipo_vehiculo) {
		super();
		this.idVehiculo = idVehiculo;
		this.num_placa = num_placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anio = anio;
		this.color = color;
		this.cliente = cliente;
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getNum_placa() {
		return num_placa;
	}

	public void setNum_placa(String num_placa) {
		this.num_placa = num_placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", num_placa=" + num_placa + ", modelo=" + modelo + ", marca="
				+ marca + ", anio=" + anio + ", color=" + color + ", cliente=" + cliente + ", tipo_vehiculo="
				+ tipo_vehiculo + "]";
	}
	
	
	
	
}