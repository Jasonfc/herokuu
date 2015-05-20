package com.pit.pasteleria.venta.interfaces;

import java.util.List;

import com.pit.pasteleria.venta.bean.ClienteBean;

public interface ClienteDAO {
	
	public abstract ClienteBean buscaCliente(int id);
	public abstract int insertaCliente(ClienteBean bean);
	public abstract int eliminaCliente(String idCliente);
	public abstract int actualizaCliente(ClienteBean bean);
	public abstract List<ClienteBean> traeTodos();
	
}
