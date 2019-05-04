package edu.upc.core.dao;

import static edu.upc.core.dao.Conexion.getConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.core.entity.Cliente;
import edu.upc.core.idao.IClienteDao;


public class ClienteDaoPostgres implements IClienteDao {
	private Connection cn = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;

	@Override
	public void insertCliente(Cliente c) {
		try {
			
			
			cn = getConexion();
			String sql = "INSERT INTO \"Cliente\"(DNI,Nombre,Ciudad,Telefono) VALUES(?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, c.getDNI());
			pr.setString(1, c.getNombre());
			pr.setString(1, c.getCiudad());
			pr.setString(1, c.getTelefono());
			pr.executeUpdate();
			rs= pr.getGeneratedKeys();
			rs.next();
			c.setCodigoCliente(rs.getInt(1));
			rs.close();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCliente(Cliente c) {
		try{
			cn= getConexion();
			String sql = "UPDATE \"Cliente\" SET Nombre=? WHERE \"idCliente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, c.getNombre());;
			pr.setInt(2,c.getCodigoCliente());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCliente(Cliente c) {
		try{
			cn = getConexion();
			String sql = "DELETE FROM \"Cliente\" WHERE \"idCliente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1,c.getCodigoCliente());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente cli=null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Cliente\"";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				cli = new Cliente();
				cli.setCodigoCliente(rs.getInt("idCliente"));
				cli.setDNI(rs.getString("DNI"));
				cli.setNombre(rs.getString("Nombre"));
				cli.setCiudad(rs.getString("Ciudad"));
				cli.setTelefono(rs.getString("Telefono"));
				lista.add(cli);
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
	public Cliente ObtenerCliente(int codigoCliente) {
		Cliente cli = null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Categoria\" WHERE \"idCliente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, codigoCliente);
			rs = pr.executeQuery();
			while(rs.next()){
				cli = new Cliente();
				cli.setCodigoCliente(rs.getInt("idCliente"));
				cli.setDNI(rs.getString("DNI"));
				cli.setNombre(rs.getString("Nombre"));
				cli.setCiudad(rs.getString("Ciudad"));
				cli.setTelefono(rs.getString("Telefono"));
			}
			rs.close();
			pr.close();
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cli;
	}
	

}
