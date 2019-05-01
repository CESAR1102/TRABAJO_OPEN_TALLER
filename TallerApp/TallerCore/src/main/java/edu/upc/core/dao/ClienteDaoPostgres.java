package edu.upc.core.dao;

import static edu.upc.core.dao.Conexion.getConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql = "INSERT INTO \"Cliente\"(DNI,nombre,Ciudad,Telefono) VALUES(?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, c.getDNI());
			pr.setString(1, c.getNombre());
			pr.setString(1, c.getCiudad());
			pr.setLong(1, c.getTelefono());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCliente(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente ObtenerCliente(int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
