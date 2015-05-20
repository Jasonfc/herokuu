package com.pit.pasteleria.venta.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pit.pasteleria.venta.service.EmpleadoServiceImpl;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;

@ParentPackage(value = "dawi")
public class ValidateAction extends ActionSupport  {
	private static final long serialVersionUID = 1L;
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	private EmpleadoServiceImpl empleadoService = new EmpleadoServiceImpl();
	private String empuser, dni;
	
	@Action(value = "/validaUsername",results = { @Result(name = "success", type = "json") })
	public String validaUsername() throws Exception{
		
		String valida = usuarioService.validaUsername(empuser);
		System.out.println(valida);
		if(valida!=null){
			System.out.println(valida);
			throw new Exception();
		}
		System.out.println(valida);
		return SUCCESS;				
		
	}
	
	@Action(value = "/validaDNI",results = { @Result(name = "success", type = "json") })
	public String validaDNI() throws Exception{
		
		String valida = empleadoService.validaDNI(dni);
		System.out.println(valida);
		if(valida!=null){
			System.out.println(valida);
			throw new Exception();
		}
		System.out.println(valida);
		return SUCCESS;				
		
	}

	public UsuarioServiceImpl getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getEmpuser() {
		return empuser;
	}

	public void setEmpuser(String empuser) {
		this.empuser = empuser;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public EmpleadoServiceImpl getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoServiceImpl empleadoService) {
		this.empleadoService = empleadoService;
	}
	

}
