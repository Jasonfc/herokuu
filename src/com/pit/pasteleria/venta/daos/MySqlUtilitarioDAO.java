package com.pit.pasteleria.venta.daos;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pit.pasteleria.venta.interfaces.UtilitarioDAO;

public class MySqlUtilitarioDAO implements UtilitarioDAO{

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
	public int ultimoCodigoUsuario() {
		int resultado = -1;
		SqlSession session = sqlMapper.openSession();		
		try {			
			resultado = (Integer) session.selectOne("utilitario.SQL_ultimoCodigoUsuario");
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
