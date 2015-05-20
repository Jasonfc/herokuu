package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.CategoriaItemBean;
import com.pit.pasteleria.venta.bean.ItemBean;
import com.pit.pasteleria.venta.interfaces.ItemDAO;

public class MySqlItemDAO implements ItemDAO{

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
	public ItemBean buscaItem(int id) {
		SqlSession session = sqlMapper.openSession();
		ItemBean bean = null;
		try {
			bean= (ItemBean)session.selectOne("itemMYSQL.SQL_buscaItem", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertaItem(ItemBean bean) {
		System.out.println(bean.toString());
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("itemMYSQL.SQL_registraItem", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaItem(String id) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("itemMYSQL.SQL_eliminaItem", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int actualizaItem(ItemBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("itemMYSQL.SQL_actualizaItem", bean);
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
	public List<ItemBean> traeTodos() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<ItemBean>();
		try {
			lista =session.selectList("itemMYSQL.SQL_listaItem");
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<CategoriaItemBean> listaCategorias() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<CategoriaItemBean>();
		try {
			lista =session.selectList("itemMYSQL.SQL_listaCategoriaItem");
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
