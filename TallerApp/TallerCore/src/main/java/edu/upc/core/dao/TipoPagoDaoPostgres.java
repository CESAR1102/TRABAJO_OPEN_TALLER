package edu.upc.core.dao;

import static edu.upc.core.dao.Conexion.getConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.core.entity.TipoPago;
import edu.upc.core.idao.ITipoPagoDao;

public class TipoPagoDaoPostgres implements ITipoPagoDao{

	private Connection cn = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;
	
	@Override
	public void insertarTipoPago(TipoPago tp) {
		try {
			cn = getConexion();
			String sql = "INSERT INTO \"TipoPago\"(descripcion) VALUES(?)";
			pr = cn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, tp.getDescripcion());
			pr.executeUpdate();
			rs= pr.getGeneratedKeys();
			rs.next();
			tp.setCodigoTipoPago(rs.getInt(1));
			rs.close();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTipoPago(TipoPago tp) {
		try{
			cn= getConexion();
			String sql = "UPDATE \"TipoPago\" SET descripcion=? WHERE \"idTipoPago\"=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1,tp.getDescripcion());;
			pr.setInt(2,tp.getCodigoTipoPago());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTipoPago(TipoPago tp) {
		try{
			cn = getConexion();
			String sql = "DELETE FROM \"TipoPago\" WHERE \"idTipoPago\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1,tp.getCodigoTipoPago());
			pr.executeUpdate();
			pr.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TipoPago> ListarTipoPago() {
		
		List<TipoPago> lista = new ArrayList<TipoPago>();
		TipoPago tip=null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"TipoPago\"";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				tip = new TipoPago();
				tip.setCodigoTipoPago(rs.getInt("idTipoPago"));
				tip.setDescripcion(rs.getString("descripcion"));
				lista.add(tip);
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
	public TipoPago ObtenerTipoPago(int codigoTipoPago) {
		TipoPago tip = null;
		try {
			cn=getConexion();
			String sql = "SELECT * FROM \"TipoPago\" WHERE \"idCategoria\"=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, codigoTipoPago);
			rs = pr.executeQuery();
			while(rs.next()){
				tip = new TipoPago();
				tip.setCodigoTipoPago(rs.getInt("idTipoPago"));
				tip.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			pr.close();
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return tip;
	}

}
