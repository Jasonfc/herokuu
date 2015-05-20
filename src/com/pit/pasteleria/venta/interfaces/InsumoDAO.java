package com.pit.pasteleria.venta.interfaces;

import java.util.List;

import com.pit.pasteleria.venta.bean.InsumoBean;
import com.pit.pasteleria.venta.bean.InsumoCategoriaBean;

public interface InsumoDAO {
	
	public abstract int inserta(InsumoBean bean) ;
	public abstract int elimina(int id);
	public abstract int actualiza ( InsumoBean bean);
	public abstract InsumoBean obtienePorPK(int id);
	public abstract List<InsumoBean> traertodos();
	public List<InsumoBean> InsumoxCategoria(String estado);
	public List<InsumoCategoriaBean> listaCategoria();
	
}
