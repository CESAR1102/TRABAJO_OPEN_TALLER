package edu.upc.core.idao;

import java.util.List;

import edu.upc.core.entity.Vehiculo;

public interface IVehiculoDao {
	public void insertVehiculo(Vehiculo c);
	public void updateVehiculo(Vehiculo c);
	public void deleteVehiculo(Vehiculo c);
	public List<Vehiculo> listarVehiculos();
	public Vehiculo ObtenerVehiculo(int codigoVehiculo);

}
