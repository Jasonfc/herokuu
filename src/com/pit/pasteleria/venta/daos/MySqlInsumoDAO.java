package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.bean.InsumoBean;
import com.pit.pasteleria.venta.bean.InsumoCategoriaBean;
import com.pit.pasteleria.venta.interfaces.InsumoDAO;

public class MySqlInsumoDAO implements InsumoDAO {
	
	//Mapper
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
	public int inserta(InsumoBean bean){
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.insert("MantInsumos.SQL_insertainsumo", bean);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return salida;
	}

	@Override
	public int elimina(int id) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {
			salida = session.delete("MantInsumos.SQL_eliminainsumo", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int actualiza(InsumoBean bean) {
		SqlSession session = sqlMapper.openSession();
		int salida = -1;
		try {

			salida = session.update("MantInsumos.SQL_actualizainsumo", bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	
	@Override@SuppressWarnings({"unchecked","rawtypes"})
	public List<InsumoBean> traertodos() {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<InsumoBean>();
		try {
			lista = session.selectList("MantInsumos.SQL_traeTodosinsumo");
			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		
 		return null;
	}

	@Override
	public InsumoBean obtienePorPK(int id) {
		SqlSession session = sqlMapper.openSession();
		InsumoBean bean = null;
		try {
			bean= (InsumoBean)session.selectOne("MantInsumos.SQL_buscainsumo", id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<InsumoBean> InsumoxCategoria(String estado) {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<InsumoCategoriaBean>();
		try {
			lista =session.selectList("MantInsumos.SQL_InsumoXEstado", estado);
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
	public List<InsumoCategoriaBean> listaCategoria() {
		SqlSession session = sqlMapper.openSession();
		List lista = new ArrayList<InsumoCategoriaBean>();
		try {
			lista =session.selectList("MantInsumos.SQL_listaCategoriaInsumo");
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;	
	}
}
