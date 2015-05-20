package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.EmpleadoBean;
import com.pit.pasteleria.venta.interfaces.EmpleadoDAO;

public class MySqlEmpleadoDAO implements EmpleadoDAO{

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
	public EmpleadoBean buscaEmpleado(int id) {
		SqlSession session = sqlMapper.openSession();
		EmpleadoBean bean = null;
		try {
			bean= (EmpleadoBean)session.selectOne("empleadoMYSQL.SQL_buscaEmpleado", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertaEmpleado(EmpleadoBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("empleadoMYSQL.SQL_registraEmpleado", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaEmpleado(String id) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("empleadoMYSQL.SQL_eliminaEmpleado", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int actualizaEmpleado(EmpleadoBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.insert("empleadoMYSQL.SQL_actualizaEmpleado", bean);
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
	public List<EmpleadoBean> traeTodos() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<EmpleadoBean>();
		try {
			lista =session.selectList("empleadoMYSQL.SQL_listaEmpleado");
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String validaDNI(String dni) {
		String resultado = null;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = (String)session.selectOne("empleadoMYSQL.SQL_validaDNI",dni);
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
	public EmpleadoBean buscaEmpleadoxUsuario(int id) {
		SqlSession session = sqlMapper.openSession();
		EmpleadoBean bean = null;
		try {
			bean= (EmpleadoBean)session.selectOne("empleadoMYSQL.SQL_buscaEmpleadoxUsuario", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
