package com.pit.pasteleria.venta.factory;

import com.pit.pasteleria.venta.daos.MySqlClienteDAO;
import com.pit.pasteleria.venta.daos.MySqlEmpleadoDAO;
import com.pit.pasteleria.venta.daos.MySqlInsumoDAO;
import com.pit.pasteleria.venta.daos.MySqlItemDAO;
import com.pit.pasteleria.venta.daos.MySqlTortaDAO;
import com.pit.pasteleria.venta.daos.MySqlUsuarioDAO;
import com.pit.pasteleria.venta.daos.MySqlUtilitarioDAO;
import com.pit.pasteleria.venta.interfaces.ClienteDAO;
import com.pit.pasteleria.venta.interfaces.EmpleadoDAO;
import com.pit.pasteleria.venta.interfaces.InsumoDAO;
import com.pit.pasteleria.venta.interfaces.ItemDAO;
import com.pit.pasteleria.venta.interfaces.TortaDAO;
import com.pit.pasteleria.venta.interfaces.UsuarioDAO;
import com.pit.pasteleria.venta.interfaces.UtilitarioDAO;


public class FabricaMysql extends  FabricaDao {

	@Override
	public UsuarioDAO getUsuarioDao() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public EmpleadoDAO getEmpleadoDao() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

	@Override
	public ItemDAO getItemDao() {
		// TODO Auto-generated method stub
		return new MySqlItemDAO();
	}

	@Override
	public InsumoDAO getInsumoDato() {
		// TODO Auto-generated method stub
		return new MySqlInsumoDAO();
	}

	@Override
	public UtilitarioDAO getUtilitarioDao() {
		// TODO Auto-generated method stub
		return new MySqlUtilitarioDAO();
	}

	@Override
	public ClienteDAO getClienteDao() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

	@Override
	public TortaDAO getTortaDao() {
		// TODO Auto-generated method stub
		return new MySqlTortaDAO();
	}


	
}
