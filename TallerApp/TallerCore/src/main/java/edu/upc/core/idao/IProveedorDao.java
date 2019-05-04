package edu.upc.core.idao;

import java.util.List;


import edu.upc.core.entity.Proveedor;

public interface IProveedorDao {
	public void insertarProveedor(Proveedor a);
	public void updateProveedor(Proveedor a);
	public void deleteProveedor(Proveedor a);
	public List<Proveedor> ListarProveedor();
	public Proveedor ObtenerAsistente(int codigoProveedor);
}
