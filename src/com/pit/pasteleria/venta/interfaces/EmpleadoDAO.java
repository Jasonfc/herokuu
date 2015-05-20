package com.pit.pasteleria.venta.interfaces;

import java.util.List;

import com.pit.pasteleria.venta.bean.EmpleadoBean;

public interface EmpleadoDAO {

	public abstract EmpleadoBean buscaEmpleado(int id);
	public abstract EmpleadoBean buscaEmpleadoxUsuario(int id);
	public abstract int insertaEmpleado(EmpleadoBean bean);
	public abstract int eliminaEmpleado(String idEmpleado);
	public abstract int actualizaEmpleado(EmpleadoBean bean);
	public abstract List<EmpleadoBean> traeTodos();
	public abstract String validaDNI(String dni);
	
}
