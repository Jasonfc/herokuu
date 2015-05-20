package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.ClienteBean;
import com.pit.pasteleria.venta.interfaces.ClienteDAO;

public class MySqlClienteDAO implements ClienteDAO{

	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClienteBean buscaCliente(int id) {
		SqlSession session = sqlMapper.openSession();
		ClienteBean bean = null;
		try {
			bean= (ClienteBean)session.selectOne("clienteMYSQL.SQL_buscaCliente", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertaCliente(ClienteBean bean) {
		System.out.println(bean.toString());
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("clienteMYSQL.SQL_registraCliente", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaCliente(String id) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("clienteMYSQL.SQL_eliminaCliente", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int actualizaCliente(ClienteBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("clienteMYSQL.SQL_actualizaCliente", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ClienteBean> traeTodos() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<ClienteBean>();
		try {
			lista =session.selectList("clienteMYSQL.SQL_listaCliente");
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
