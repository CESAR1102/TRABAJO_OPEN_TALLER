package edu.upc.core.dao;

import static edu.upc.core.dao.Conexion.getConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import edu.upc.core.entity.Proveedor;
import edu.upc.core.idao.IProveedorDao;

public class ProveedorDaoPostgres implements IProveedorDao {
	
	private Connection cn=null;
	private PreparedStatement pr =null;
	private ResultSet rs =null;
	
	@Override
	public void insertarProveedor(Proveedor a) {
		try {
			cn = getConexion();
			String sql = "INSERT INTO \"Proveedor\"(nombre,telefono,ciudad,confiabilidad) VALUES(?,?,?,?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pr.setString(1, a.getNombre());
			pr.setLong(2, a.getTelefono());
			pr.setString(3,a.getCiudad());
			pr.setInt(4, a.getConfiabilidad());
			pr.executeUpdate();
			rs= pr.getGeneratedKeys();
			rs.next();
			a.setRuc(rs.getInt(1));
			rs.close();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProveedor(Proveedor a) {
		try{
			cn= getConexion();
			String sql = "UPDATE \"Proveedor\" SET nombre=? WHERE \"idAsistente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, a.getNombre());
			pr.setLong(2,a.getRuc());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProveedor(Proveedor a) {
		try{
			cn = getConexion();
			String sql = "DELETE FROM \"Proveedor\" WHERE \"Ruc\"=?";
			pr = cn.prepareStatement(sql);
			pr.setLong(1, a.getRuc());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Proveedor> ListarProveedor() {
		List<Proveedor> lista = new ArrayList<Proveedor>();
		Proveedor as=null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Proveedor\"";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				as = new Proveedor();
				as.setRuc(rs.getLong("Ruc"));

				as.setNombre(rs.getString("Nombre"));
				lista.add(as);
			}
			rs.close();
			pr.close();
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Proveedor ObtenerAsistente(int codigoProveedor) {
		Proveedor as = null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Proveedor\" WHERE \"idAsistente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, codigoProveedor);
			rs = pr.executeQuery();
			while(rs.next()){
				as = new Proveedor();
				as.setRuc(rs.getLong("Ruc"));

				as.setNombre(rs.getString("Nombre"));
				
			}
			rs.close();
			pr.close();
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return as;
	}

}
