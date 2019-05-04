package edu.upc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import edu.upc.core.entity.Vehiculo;
import edu.upc.core.idao.IVehiculoDao;

@Named("VehiculoController")
@ViewScoped
public class VehiculoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Vehiculo> vehiculos;
	private Vehiculo vehiculo;
	private IVehiculoDao vehiculoDAO;
	
	public String guardarVehiculo(){
		String rpta="";
		try {
			vehiculoDAO.insertVehiculo(vehiculo);
			this.getVehiculos();
			rpta="ListadoVehiculo?faces-redirect=true";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;
	}
	public String editarVehiculo(){
		String rpta="";
		try {
			vehiculoDAO.updateVehiculo(vehiculo);
			this.getVehiculos();
			rpta="ListadoVehiculo?faces-redirect=true";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;
	}
	
	
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public IVehiculoDao getVehiculoDAO() {
		return vehiculoDAO;
	}
	public void setVehiculoDAO(IVehiculoDao vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}
}
