package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.EnlaceBean;
import com.pit.pasteleria.venta.bean.RolBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;
import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.UsuarioDAO;

public class UsuarioServiceImpl implements UsuarioService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	UsuarioDAO dao = factoria.getUsuarioDao();
	@Override
	public UsuarioBean validaUsuario(UsuarioBean bean) {
		// TODO Auto-generated method stub
		return dao.validaUsuario(bean);
	}
	@Override
	public int insertaUsuario(UsuarioBean bean) {
		// TODO Auto-generated method stub
		return dao.insertaUsuario(bean);
	}
	@Override
	public int eliminaUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		return dao.eliminaUsuario(idUsuario);
	}
	@Override
	public int generaClave(UsuarioBean bean) {
		// TODO Auto-generated method stub
		return dao.generaClave(bean);
	}
	@Override
	public List<EnlaceBean> traerEnlacesDeUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		return dao.traerEnlacesDeUsuario(idUsuario);
	}
	@Override
	public List<EnlaceBean> traeHijosEnlace(String idPadre) {
		// TODO Auto-generated method stub
		return dao.traeHijosEnlace(idPadre);
	}
	@Override
	public int insertaRol(RolBean bean) {
		// TODO Auto-generated method stub
		return dao.insertaRol(bean);
	}
	@Override
	public EnlaceBean traeEnlace(String idPadre) {
		// TODO Auto-generated method stub
		return dao.traeEnlace(idPadre);
	}
	@Override
	public int ultimoCodigoUsuario() {
		// TODO Auto-generated method stub
		return dao.ultimoCodigoUsuario();
	}
	@Override
	public String validaUsername(String username) {
		// TODO Auto-generated method stub
		return dao.validaUsername(username);
	}
}
