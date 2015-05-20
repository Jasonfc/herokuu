package com.pit.pasteleria.venta.bean;

import java.io.File;

public class ClienteBean {
	private String idCliente;
	private String dni, nombre, apePaterno, apeMaterno, fechaNacimiento, celular, direccion, correo, sexo;
	//para la imagen
	private File filImagen;
	private String filImagenFileName;
	private String filImagenContentType;
	private byte[] filImagenBytes;
	private UsuarioBean usuario;
	private String idUsuario;
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}	

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	
}
