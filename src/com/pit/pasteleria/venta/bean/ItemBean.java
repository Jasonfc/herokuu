package com.pit.pasteleria.venta.bean;

import java.io.File;

public class ItemBean {
	
	private String idItem, nombreItem, descripcionItem, fechaIngreso, idCategoria;
	private int stock;
	//para la imagen
	private File filImagen;
	private String filImagenFileName;
	private String filImagenContentType;
	private byte[] filImagenBytes;
	
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	public String getDescripcionItem() {
		return descripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public File getFilImagen() {
		return filImagen;
	}
	public void setFilImagen(File filImagen) {
		this.filImagen = filImagen;
	}
	public String getFilImagenFileName() {
		return filImagenFileName;
	}
	public void setFilImagenFileName(String filImagenFileName) {
		this.filImagenFileName = filImagenFileName;
	}
	public String getFilImagenContentType() {
		return filImagenContentType;
	}
	public void setFilImagenContentType(String filImagenContentType) {
		this.filImagenContentType = filImagenContentType;
	}
	public byte[] getFilImagenBytes() {
		return filImagenBytes;
	}
	public void setFilImagenBytes(byte[] filImagenBytes) {
		this.filImagenBytes = filImagenBytes;
	}

	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
}
