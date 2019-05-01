package edu.upc.core.idao;

import java.util.List;

import edu.upc.core.entity.TipoPago;

public interface ITipoPagoDao {
	
	public void insertarTipoPago(TipoPago tp);
	public void updateTipoPago(TipoPago tp);
	public void deleteTipoPago(TipoPago tp );
	public List<TipoPago> ListarTipoPago();
	public TipoPago ObtenerTipoPago(int codigoTipoPago);

}
