package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.EnlaceBean;
import com.pit.pasteleria.venta.bean.RolBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;

public interface UsuarioService {
	
	public abstract UsuarioBean validaUsuario(UsuarioBean bean);
	public abstract int insertaUsuario(UsuarioBean bean);
	public abstract int eliminaUsuario(String idUsuario);
	public abstract int generaClave(UsuarioBean bean);	
	public abstract int insertaRol(RolBean bean);
	public abstract List<EnlaceBean> traerEnlacesDeUsuario(String idUsuario);
	public abstract List<EnlaceBean> traeHijosEnlace(String idPadre);
	public abstract EnlaceBean traeEnlace(String idPadre);
	public abstract int ultimoCodigoUsuario();
	public abstract String validaUsername(String username);
}
