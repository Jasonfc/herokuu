package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.CategoriaItemBean;
import com.pit.pasteleria.venta.bean.ItemBean;
import com.pit.pasteleria.venta.factory.FabricaDao;
import com.pit.pasteleria.venta.interfaces.ItemDAO;

public class ItemServiceImpl implements ItemService {
	FabricaDao factoria = FabricaDao.getFactory(FabricaDao.MYSQL);
	ItemDAO dao = factoria.getItemDao();
	@Override
	public ItemBean buscaItem(int id) {
		return dao.buscaItem(id);
	}
	@Override
	public int insertaItem(ItemBean bean) {
		return dao.insertaItem(bean);
	}
	@Override
	public int eliminaItem(String idItem) {
		return dao.eliminaItem(idItem);
	}
	@Override
	public int actualizaItem(ItemBean bean) {
		return dao.actualizaItem(bean);
	}
	@Override
	public List<ItemBean> traeTodos() {
		return dao.traeTodos();
	}
	@Override
	public List<CategoriaItemBean> listaCategorias() {
		// TODO Auto-generated method stub
		return dao.listaCategorias();
	}
	
}
