package com.pit.pasteleria.venta.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pit.pasteleria.venta.bean.EnlaceBean;
import com.pit.pasteleria.venta.service.UsuarioService;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;


public class MenuDinamico {

	private UsuarioService service = new UsuarioServiceImpl();


	public void listaEnlace(List<EnlaceBean> list, StringBuilder builderMenu){
		Random r = new Random();
		List<EnlaceBean> hijos = null;
		EnlaceBean e = null, m = null;
		while(list.size()!=0){
			hijos = new ArrayList<EnlaceBean>();
			e = list.get(r.nextInt(list.size()));
			if (e.getIdPadre() !=null){	
				m = service.traeEnlace(e.getIdPadre());
				builderMenu.append("<li class='"+m.getRuta()+"'>").append("\n");
				builderMenu.append("<a data-toggle='dropdown'><span></span>").append("\n");
				builderMenu.append(m.getDescripcion()).append("\n");
				builderMenu.append("<b class='caret'></b>").append("\n");
				builderMenu.append("</a>").append("\n");	
				builderMenu.append("<ul class='dropdown-menu'>").append("\n");
				for (EnlaceBean enlaceBean : list) {
					if(enlaceBean.getIdPadre()!=null){
						if(enlaceBean.getIdPadre().equals(e.getIdPadre())){
							builderMenu.append("<li>").append("\n");
							builderMenu.append("<a href='/Proyecto-pit/"+enlaceBean.getRuta()+"'>"+enlaceBean.getDescripcion()+"</a>").append("\n");
							builderMenu.append("</li>").append("\n");
							hijos.add(enlaceBean);					
						}
					}
					
				}
				for(EnlaceBean em:hijos){
					list.remove(em);
				}
				builderMenu.append("</ul>").append("\n");	
				builderMenu.append("</li>").append("\n");	
			}else{			
				builderMenu.append("<li class='"+e.getRuta()+"'>").append("\n");
				builderMenu.append("<a href='#'><span></span>"+e.getDescripcion()+"</a>").append("\n");
				builderMenu.append("</li>").append("\n");
				list.remove(e);
			}
		}
		
	}
	public StringBuilder cargarMenu(String id){
		UsuarioService service = new UsuarioServiceImpl();
		List<EnlaceBean> list= service.traerEnlacesDeUsuario(id);
		StringBuilder builderMenu = new StringBuilder();
		listaEnlace(list,builderMenu);
		return builderMenu;
	}
	public static void main(String[] args) {

		File file = new File(".");
		File newfile = new File(new File("."),"WebContent/Administrador/images/avatar-female.png");
		System.out.println("=============================");
		System.out.println(file.getPath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(newfile.getAbsolutePath());
		System.out.println("=============================");
	}
	

}
