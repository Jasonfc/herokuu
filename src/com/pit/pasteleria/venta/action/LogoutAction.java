package com.pit.pasteleria.venta.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "dawi")
public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private SessionMap session = (SessionMap)ActionContext.getContext().getSession();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private String mensaje;
	

	@Action(value = "/logoutAdmin", results = {
			@Result(location = "t_login", name = "success", type = "tiles")
			})
	public String logoutAdmin() throws Exception {
		session.remove("objEmp");
		session.remove("objUsuarioMenus");
	
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires","0");
		
		mensaje ="El usuario salio del sesion";
		addActionMessage(mensaje);
		return SUCCESS;
	}
	

	@Action(value = "/logoutCliente", results = {
			@Result(location = "t_index_cliente", name = "success", type = "tiles")
			})
	public String logoutCliente() throws Exception {
		session.remove("objCli");
	
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires","0");
		
		mensaje ="El usuario salio del sesion";
		addActionMessage(mensaje);
		return SUCCESS;
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
