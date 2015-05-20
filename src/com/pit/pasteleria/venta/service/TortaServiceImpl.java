package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.DetalleTortaItemBean;
import com.pit.pasteleria.venta.bean.TortaBean;
import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.TortaDAO;

public class TortaServiceImpl implements TortaService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	TortaDAO dao = factoria.getTortaDao();
	@Override
	public TortaBean buscaTorta(int id) {
		 
		return dao.buscaTorta(id);
	}
	@Override
	public int insertaTorta(TortaBean bean) {
		 
		return dao.insertaTorta(bean);
	}
	@Override
	public int insertaDetalleTorta(DetalleTortaItemBean bean) {
		 
		return dao.insertaDetalleTorta(bean);
	}
	@Override
	public int eliminaTorta(String idTorta) {
		 
		return dao.eliminaTorta(idTorta);
	}
	@Override
	public int eliminaDetalleTorta(String idTorta) {
		 
		return dao.eliminaDetalleTorta(idTorta);
	}
	@Override
	public List<TortaBean> traeTodos() {
		 
		return dao.traeTodos();
	}
	@Override
	public List<DetalleTortaItemBean> traeDetalle(String idTorta) {
		 
		return dao.traeDetalle(idTorta);
	}
	@Override
	public int ultimoCodigoTorta() {
		 
		return dao.ultimoCodigoTorta();
	}
	@Override
	public int actualizaTorta(TortaBean bean) {
		return dao.actualizaTorta(bean);
	}
	
	
}
