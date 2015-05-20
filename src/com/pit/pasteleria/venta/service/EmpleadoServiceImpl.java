package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.EmpleadoBean;
import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.EmpleadoDAO;

public class EmpleadoServiceImpl implements EmpleadoService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	EmpleadoDAO dao = factoria.getEmpleadoDao();
	@Override
	public EmpleadoBean buscaEmpleado(int id) {
		return dao.buscaEmpleado(id);
	}
	@Override
	public int insertaEmpleado(EmpleadoBean bean) {
		return dao.insertaEmpleado(bean);
	}
	@Override
	public int eliminaEmpleado(String idEmpleado) {
		return dao.eliminaEmpleado(idEmpleado);
	}
	@Override
	public int actualizaEmpleado(EmpleadoBean bean) {
		return dao.actualizaEmpleado(bean);
	}
	@Override
	public List<EmpleadoBean> traeTodos() {
		return dao.traeTodos();
	}
	@Override
	public String validaDNI(String dni) {
		// TODO Auto-generated method stub
		return dao.validaDNI(dni);
	}
	@Override
	public EmpleadoBean buscaEmpleadoxUsuario(int id) {
		// TODO Auto-generated method stub
		return dao.buscaEmpleadoxUsuario(id);
	}
	
}
