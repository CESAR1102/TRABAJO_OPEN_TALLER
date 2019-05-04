package edu.upc.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.core.entity.Vehiculo;
import edu.upc.core.idao.IVehiculoDao;
import static edu.upc.core.dao.Conexion.getConexion;

public class VehiculoDaoPostgres implements IVehiculoDao{
	private Connection cn = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;
	
	@Override
	public void insertVehiculo(Vehiculo c) {
		try {
			cn = getConexion();
			String sql = "INSERT INTO \"Vehiculo\"(num_placa,modelo,marca,anio,color,cliente,tipo_vehiculo) VALUES(?,?,?,?,?,?,?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, c.getNum_placa());
			pr.setString(2, c.getModelo());
			pr.setString(3, c.getMarca());
			pr.setInt(4, c.getAnio());
			pr.setString(5, c.getColor());
			pr.setString(6, c.getCliente());
			pr.setString(7, c.getTipo_vehiculo());
			pr.executeUpdate();
			rs= pr.getGeneratedKeys();
			rs.next();
			c.setIdVehiculo(rs.getInt(1));
			rs.close();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateVehiculo(Vehiculo c) {
		try{
			cn= getConexion();
			String sql = "UPDATE \"Vehiculo\" SET num_placa=?,modelo=?,marca=?,anio=?,color=?,cliente=?,tipo_vehiculo=? WHERE \"idVehiculo\"=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, c.getNum_placa());
			pr.setString(2, c.getModelo());
			pr.setString(3, c.getMarca());
			pr.setInt(4, c.getAnio());
			pr.setString(5, c.getColor());
			pr.setString(6, c.getCliente());
			pr.setString(7, c.getTipo_vehiculo());
			pr.setInt(8,c.getIdVehiculo());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVehiculo(Vehiculo c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> listarVehiculos() {
		List<Vehiculo> lista = new ArrayList<Vehiculo>();
		Vehiculo cat=null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Vehiculo\"";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				cat = new Vehiculo();
				cat.setIdVehiculo(rs.getInt("idVehiculo"));
				cat.setNum_placa(rs.getString("num_placa"));
				cat.setModelo(rs.getString("modelo"));
				cat.setMarca(rs.getString("marca"));
				cat.setAnio(rs.getInt("anio"));
				cat.setColor(rs.getString("color"));
				cat.setCliente(rs.getString("cliente"));
				cat.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
				lista.add(cat);
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
	public Vehiculo ObtenerVehiculo(int codigoVehiculo) {
		Vehiculo cat = null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Vehiculo\" WHERE \"idVehiculo\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, codigoVehiculo);
			rs = pr.executeQuery();
			while(rs.next()){
				cat = new Vehiculo();
				cat.setIdVehiculo(rs.getInt("idVehiculo"));
				cat.setNum_placa(rs.getString("num_placa"));
				cat.setModelo(rs.getString("modelo"));
				cat.setMarca(rs.getString("marca"));
				cat.setAnio(rs.getInt("anio"));
				cat.setColor(rs.getString("color"));
				cat.setCliente(rs.getString("cliente"));
				cat.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
			}
			rs.close();
			pr.close();
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cat;
	}

}
