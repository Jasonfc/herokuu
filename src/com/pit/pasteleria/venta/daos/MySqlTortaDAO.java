package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.DetalleTortaItemBean;
import com.pit.pasteleria.venta.bean.TortaBean;
import com.pit.pasteleria.venta.interfaces.TortaDAO;

public class MySqlTortaDAO implements  TortaDAO{

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
	public TortaBean buscaTorta(int id) {
		SqlSession session = sqlMapper.openSession();
		TortaBean bean = null;
		try {
			bean= (TortaBean)session.selectOne("tortaMYSQL.SQL_buscaTorta", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public int insertaTorta(TortaBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("tortaMYSQL.SQL_registraTorta", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public int insertaDetalleTorta(DetalleTortaItemBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("tortaMYSQL.SQL_registraDetalle", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public int eliminaTorta(String idTorta) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("tortaMYSQL.SQL_eliminaTorta", idTorta);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	@Override
	public int eliminaDetalleTorta(String idTorta) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("tortaMYSQL.SQL_eliminaDetalleTorta", idTorta);
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
	public List<TortaBean> traeTodos() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<TortaBean>();
		try {
			lista =session.selectList("tortaMYSQL.SQL_listaTorta");
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
	public List<DetalleTortaItemBean> traeDetalle(String idTorta) {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<DetalleTortaItemBean>();
		try {
			lista =session.selectList("tortaMYSQL.SQL_listaDetalle", idTorta);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public int ultimoCodigoTorta() {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = (Integer) session.selectOne("tortaMYSQL.SQL_ultimoCodigoTorta");
			session.commit();			
			return resultado;			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return resultado;
	}
	@Override
	public int actualizaTorta(TortaBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("tortaMYSQL.SQL_actualizaTorta", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}


}
