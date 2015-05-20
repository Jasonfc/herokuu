package com.pit.pasteleria.venta.bean;

import java.io.File;
import java.util.Arrays;

public class EmpleadoBean {
	private String idEmpleado;
	private String dni, nombre, apePaterno, apeMaterno, fechaIngreso, celular, direccion;
	//para la imagen
	private File filImagen;
	private String filImagenFileName;
	private String filImagenContentType;
	private byte[] filImagenBytes;
	private UsuarioBean usuario;
	private String idUsuario;	
	
	
	@Override
	public String toString() {
		return "EmpleadoBean [idEmpleado=" + idEmpleado + ", dni=" + dni
				+ ", nombre=" + nombre + ", apePaterno=" + apePaterno
				+ ", apeMaterno=" + apeMaterno + ", fechaIngreso="
				+ fechaIngreso + ", celular=" + celular + ", direccion="
				+ direccion + ", filImagen=" + filImagen
				+ ", filImagenFileName=" + filImagenFileName
				+ ", filImagenContentType=" + filImagenContentType
				+ ", filImagenBytes=" + Arrays.toString(filImagenBytes)
				+ ", idUsuario=" + idUsuario + "]";
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	
	
}
