package com.pit.pasteleria.venta.bean;

import java.io.File;

public class TortaBean {
	
	private String idTorta, nombre, fechaRegistro, descripcion;
	private int cantPisos, stock, cantPersonas;
	private double precio;
	//para la imagen
	private File filImagen;
	private String filImagenFileName;
	private String filImagenContentType;
	private byte[] filImagenBytes;
	
	
	public String getIdTorta() {
		return idTorta;
	}
	public void setIdTorta(String idTorta) {
		this.idTorta = idTorta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantPisos() {
		return cantPisos;
	}
	public void setCantPisos(int cantPisos) {
		this.cantPisos = cantPisos;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
}
