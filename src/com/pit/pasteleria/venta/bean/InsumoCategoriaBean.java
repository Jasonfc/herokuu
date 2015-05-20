package com.pit.pasteleria.venta.bean;

public class InsumoCategoriaBean {
	private String idCatInsumo,desCatInsumo;
	
	public InsumoCategoriaBean() {
		super();
	}
	
	public InsumoCategoriaBean(String idCatInsumo, String desCatInsumo) {
		super();
		this.idCatInsumo = idCatInsumo;
		this.desCatInsumo = desCatInsumo;
	}
	
	public String getFormato(){
		return idCatInsumo + " -> "  + desCatInsumo;
	}
	
	public String getIdCatInsumo() {
		return idCatInsumo;
	}

	public void setIdCatInsumo(String idCatInsumo) {
		this.idCatInsumo = idCatInsumo;
	}

	public String getDesCatInsumo() {
		return desCatInsumo;
	}

	public void setDesCatInsumo(String desCatInsumo) {
		this.desCatInsumo = desCatInsumo;
	}

	

}
