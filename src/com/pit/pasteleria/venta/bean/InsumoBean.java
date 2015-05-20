package com.pit.pasteleria.venta.bean;

import java.io.File;

public class InsumoBean {
	
	private String intCodigo;
	private String strFecRegistro;
	private String strFecVencimiento;
	private double InCantidad;
	//Para la imagen
	private File filImagen;
	private String filImagenFileName;
	private String filImagenContentType;
	private byte[] filImagenBytes; //Fin imagen
	private String strCategoria;
	private String strNombre;
	
	
	public String getIntCodigo() {
		return intCodigo;
	}
	public void setIntCodigo(String intCodigo) {
		this.intCodigo = intCodigo;
	}
	public String getStrFecRegistro() {
		return strFecRegistro;
	}
	public void setStrFecRegistro(String strFecRegistro) {
		this.strFecRegistro = strFecRegistro;
	}
	public String getStrFecVencimiento() {
		return strFecVencimiento;
	}
	public void setStrFecVencimiento(String strFecVencimiento) {
		this.strFecVencimiento = strFecVencimiento;
	}
	public double getInCantidad() {
		return InCantidad;
	}
	public void setInCantidad(double inCantidad) {
		InCantidad = inCantidad;
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
	public String getStrCategoria() {
		return strCategoria;
	}
	public void setStrCategoria(String strCategoria) {
		this.strCategoria = strCategoria;
	}
	public String getStrNombre() {
		return strNombre;
	}
	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}
	
}
