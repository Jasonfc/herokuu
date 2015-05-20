package com.pit.pasteleria.venta.service;

import java.util.List;

import com.pit.pasteleria.venta.bean.DetalleTortaItemBean;
import com.pit.pasteleria.venta.bean.TortaBean;

public interface TortaService {
	
	public abstract TortaBean buscaTorta(int id);
	public abstract int insertaTorta(TortaBean bean);
	public abstract int insertaDetalleTorta(DetalleTortaItemBean bean);
    public abstract int eliminaTorta(String idTorta);
	public abstract int eliminaDetalleTorta(String idTorta);
	public abstract List<TortaBean> traeTodos();
	public abstract int actualizaTorta(TortaBean bean);
	public abstract List<DetalleTortaItemBean> traeDetalle(String idTorta);
	public abstract int ultimoCodigoTorta();
}
