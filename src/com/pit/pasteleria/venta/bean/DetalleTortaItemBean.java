package com.pit.pasteleria.venta.bean;

public class DetalleTortaItemBean {

	private String idTorta, idInsumos;
	private int cantidad;
	private InsumoBean insumo;
	
	
	public String getIdTorta() {
		return idTorta;
	}
	public void setIdTorta(String idTorta) {
		this.idTorta = idTorta;
	}
	public String getIdInsumos() {
		return idInsumos;
	}
	public void setIdInsumos(String idInsumos) {
		this.idInsumos = idInsumos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public InsumoBean getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoBean insumo) {
		this.insumo = insumo;
	}
	
	
	
	
}
