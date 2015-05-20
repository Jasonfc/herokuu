package com.pit.pasteleria.venta.interfaces;

import java.util.List;

import com.pit.pasteleria.venta.bean.CategoriaItemBean;
import com.pit.pasteleria.venta.bean.ItemBean;

public interface ItemDAO {
	
	public abstract ItemBean buscaItem(int id);
	public abstract int insertaItem(ItemBean bean);
	public abstract int eliminaItem(String idItem);
	public abstract int actualizaItem(ItemBean bean);
	public abstract List<ItemBean> traeTodos();
	public abstract List<CategoriaItemBean> listaCategorias();
	
}
