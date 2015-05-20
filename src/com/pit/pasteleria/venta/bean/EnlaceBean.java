package com.pit.pasteleria.venta.bean;

public class EnlaceBean {
	
	private String idEnlace, descripcion, ruta, idPadre;

	@Override
	public String toString() {
		return "EnlaceBean [idEnlace=" + idEnlace + ", descripcion="
				+ descripcion + ", ruta=" + ruta + ", idPadre=" + idPadre + "]";
	}

	public String getIdEnlace() {
		return idEnlace;
	}

	public void setIdEnlace(String idEnlace) {
		this.idEnlace = idEnlace;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}

	
	
	
}
