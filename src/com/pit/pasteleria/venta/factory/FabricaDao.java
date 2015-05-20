package com.pit.pasteleria.venta.factory;

import com.pit.pasteleria.venta.interfaces.ClienteDAO;
import com.pit.pasteleria.venta.interfaces.EmpleadoDAO;
import com.pit.pasteleria.venta.interfaces.InsumoDAO;
import com.pit.pasteleria.venta.interfaces.ItemDAO;
import com.pit.pasteleria.venta.interfaces.TortaDAO;
import com.pit.pasteleria.venta.interfaces.UsuarioDAO;
import com.pit.pasteleria.venta.interfaces.UtilitarioDAO;

public abstract class FabricaDao {

	public static final int MYSQL = 1;
	
	public abstract UsuarioDAO getUsuarioDao();
	public abstract EmpleadoDAO getEmpleadoDao();
	public abstract ItemDAO getItemDao();
	public abstract InsumoDAO getInsumoDato();
	public abstract UtilitarioDAO getUtilitarioDao();
	public abstract ClienteDAO getClienteDao();
	public abstract TortaDAO getTortaDao();
	
	public static FabricaDao getFactory(int bd) {
		switch (bd) {
			case MYSQL:
				return new FabricaMysql();
		}
		return null;
	}

}
