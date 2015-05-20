package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.InsumoBean;
import com.pit.pasteleria.venta.bean.InsumoCategoriaBean;
import com.pit.pasteleria.venta.interfaces.InsumoDAO;
import com.pit.pasteleria.venta.factory.FabricaDao;

public class InsumoServiceImpl implements InsumoService{
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	InsumoDAO dao = factoria.getInsumoDato();
	@Override
	public int inserta(InsumoBean bean) {
		// TODO Auto-generated method stub
		return dao.inserta(bean);
	}
	@Override
	public int eliminaInsumo(int id) {
		// TODO Auto-generated method stub
		return dao.elimina(id);
	}
	@Override
	public int actualizaInsumo(InsumoBean bean) {
		// TODO Auto-generated method stub
		return dao.actualiza(bean);
	}
	@Override
	public InsumoBean obtienePorPK(int id) {
		// TODO Auto-generated method stub
		return dao.obtienePorPK(id);
	}
	@Override
	public List<InsumoBean> traeTodos() {
		// TODO Auto-generated method stub
		return dao.traertodos();
	}
	@Override
	public List<InsumoBean> insumoxCategoria(String categoria) {
		// TODO Auto-generated method stub
		return dao.InsumoxCategoria(categoria);
	}
	@Override
	public List<InsumoCategoriaBean> listaCategoria() {
		// TODO Auto-generated method stub
		return dao.listaCategoria();
	}
	
	

	
}
