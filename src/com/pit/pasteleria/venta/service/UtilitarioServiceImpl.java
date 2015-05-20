package com.pit.pasteleria.venta.service;

import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.UtilitarioDAO;

public class UtilitarioServiceImpl implements UtilitarioService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	UtilitarioDAO dao = factoria.getUtilitarioDao();
	@Override
	public int ultimoCodigoUsuario() {
		// TODO Auto-generated method stub
		return dao.ultimoCodigoUsuario();
	}
	
}
