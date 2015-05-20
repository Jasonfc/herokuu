package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.EnlaceBean;
import com.pit.pasteleria.venta.bean.RolBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;
import com.pit.pasteleria.venta.interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO{

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
	public UsuarioBean validaUsuario(UsuarioBean usuarioBean) {
		SqlSession session = sqlMapper.openSession();
		UsuarioBean bean = null;
		try {
			bean = (UsuarioBean) session.selectOne("loginMYSQL.SQL_login", usuarioBean);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertaUsuario(UsuarioBean bean) {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = session.insert("loginMYSQL.SQL_insertaUsuario",bean);
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
	public int generaClave(UsuarioBean bean) {
		SqlSession session = sqlMapper.openSession();
		int resultado = 0;		
		try {			
			resultado = session.update("loginMYSQL.SQL_generaClave",bean);
			session.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return resultado;
	}

	@Override
	public int eliminaUsuario(String idUsuario) {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = session.insert("loginMYSQL.SQL_eliminaUsuario",idUsuario);
			session.commit();			
			return resultado;			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}	
		return resultado;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<EnlaceBean> traerEnlacesDeUsuario(String idUsuario) {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<EnlaceBean>();
		try {
			lista = session.selectList("loginMYSQL.SQL_traerEnlacesDeUsuario", idUsuario);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<EnlaceBean> traeHijosEnlace(String idPadre) {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<EnlaceBean>();
		try {
			lista = session.selectList("loginMYSQL.SQL_traerEnlacesDePadre", idPadre);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int insertaRol(RolBean bean) {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = session.insert("loginMYSQL.SQL_insertaUsuarioRol",bean);
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
	public EnlaceBean traeEnlace(String idPadre) {
		SqlSession session = sqlMapper.openSession();
		EnlaceBean bean = null;
		try {
			bean = (EnlaceBean) session.selectOne("loginMYSQL.SQL_traerEnlace", idPadre);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}

	@Override
	public int ultimoCodigoUsuario() {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = (Integer) session.selectOne("loginMYSQL.SQL_ultimoCodigoUsuario");
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
	public String validaUsername(String username) {
		String resultado = null;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = (String)session.selectOne("loginMYSQL.SQL_validaUsername",username);
			session.commit();			
			return resultado;			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return resultado;
	}


}
