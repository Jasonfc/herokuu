package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.ClienteBean;
import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.ClienteDAO;

public class ClienteServiceImpl implements ClienteService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	ClienteDAO dao = factoria.getClienteDao();
	@Override
	public ClienteBean buscaCliente(int id) {
		return dao.buscaCliente(id);
	}
	@Override
	public int insertaCliente(ClienteBean bean) {
		return dao.insertaCliente(bean);
	}
	@Override
	public int eliminaCliente(String idCliente) {
		return dao.eliminaCliente(idCliente);
	}
	@Override
	public int actualizaCliente(ClienteBean bean) {
		return dao.actualizaCliente(bean);
	}
	@Override
	public List<ClienteBean> traeTodos() {
		return dao.traeTodos();
	}
	
}
