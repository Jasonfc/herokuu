package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.InsumoBean;
import com.pit.pasteleria.venta.bean.InsumoCategoriaBean;


public interface InsumoService {

	public abstract int inserta(InsumoBean  bean) ;
	public abstract int eliminaInsumo(int id) ;
	public abstract int actualizaInsumo(InsumoBean bean);
	public abstract InsumoBean obtienePorPK(int id) ;
	public abstract List<InsumoBean> traeTodos() ;
	public List<InsumoBean> insumoxCategoria(String categoria) ;
	public List<InsumoCategoriaBean> listaCategoria();
}
