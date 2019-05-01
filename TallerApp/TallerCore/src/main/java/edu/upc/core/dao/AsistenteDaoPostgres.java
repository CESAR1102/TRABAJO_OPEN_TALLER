package edu.upc.core.dao;

import static edu.upc.core.dao.Conexion.getConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.core.entity.Asistente;
import edu.upc.core.idao.IAsistenteDao;

public class AsistenteDaoPostgres implements IAsistenteDao{
	private Connection cn=null;
	private PreparedStatement pr =null;
	private ResultSet rs =null;

	@Override
	public void insertarAsistente(Asistente a) {
		try {
			cn = getConexion();
			String sql = "INSERT INTO \"Asistente\"(nombre) VALUES(?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, a.getNombre());
			pr.executeUpdate();
			rs= pr.getGeneratedKeys();
			rs.next();
			a.setCodigoAsistente(rs.getInt(1));
			rs.close();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAsistenete(Asistente a) {
		try{
			cn= getConexion();
			String sql = "UPDATE \"Asistente\" SET nombre=? WHERE \"idAsistente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, a.getNombre());;
			pr.setInt(2,a.getCodigoAsistente());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAsistente(Asistente a) {
		try{
			cn = getConexion();
			String sql = "DELETE FROM \"Asistente\" WHERE \"idAsistente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, a.getCodigoAsistente());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Asistente> ListarAsistente() {
		
		List<Asistente> lista = new ArrayList<Asistente>();
		Asistente as=null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Asistente\"";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				as = new Asistente();
				as.setCodigoAsistente(rs.getInt("idAsistente"));

				as.setNombre(rs.getString("nombre"));
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
	public Asistente ObtenerAsistente(int codigoAsistente) {
		Asistente as = null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"Asistente\" WHERE \"idAsistente\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, codigoAsistente);
			rs = pr.executeQuery();
			while(rs.next()){
				as = new Asistente();
				as.setCodigoAsistente(rs.getInt("idAsistente"));
				as.setNombre(rs.getString("nombre"));
				
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
