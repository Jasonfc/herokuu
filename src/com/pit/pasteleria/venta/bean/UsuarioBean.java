package com.pit.pasteleria.venta.bean;

public class UsuarioBean {

	private String idUsuario;
	private String username, password, idRol;
	private RolBean rol;

	public UsuarioBean() {
		super();
	}	
	
	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RolBean getRol() {
		return rol;
	}

	public void setRol(RolBean rol) {
		this.rol = rol;
	}
	
	
	
	
	
	
}
