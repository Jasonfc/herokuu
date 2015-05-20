package com.pit.pasteleria.venta.action;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.pit.pasteleria.venta.bean.EmpleadoBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;
import com.pit.pasteleria.venta.service.EmpleadoService;
import com.pit.pasteleria.venta.service.EmpleadoServiceImpl;
import com.pit.pasteleria.venta.service.UsuarioService;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;
import com.pit.pasteleria.venta.util.MenuDinamico;


@ParentPackage(value = "dawi")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
		@RequiredStringValidator(fieldName = "username", type = ValidatorType.FIELD, message = "El usuario es requerido"),
		@RequiredStringValidator(fieldName = "password", type = ValidatorType.FIELD, message = "La clave es requerida") 

})
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 7968544374444173511L;
	private static final Log log = LogFactory.getLog(LoginAction.class);

	private UsuarioService service = new UsuarioServiceImpl();
	private EmpleadoService serviceEmpleado = new EmpleadoServiceImpl();
	private Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
	MenuDinamico menuDinamico = new MenuDinamico();
	
	
	private String username;
	private String password;
	private String mensaje;
	private boolean is_customer;

	private StringBuilder builderMenu;

	@Action(value = "/login", results = { 
			  @Result(location = "t_index_administrador", name = "successAdmin", type = "tiles"),
			  @Result(location = "t_login", name = "loginAdmin", type = "tiles"),
			  @Result(location = "t_index_cliente", name = "successCliente", type = "tiles"),
			  @Result(location = "t_loginCliente", name = "loginCliente", type = "tiles")})
	public String loginAdmin(){

		log.info("En LoginAction");	
		
		UsuarioBean operarioBean = new UsuarioBean();
		operarioBean.setUsername(username);
		operarioBean.setPassword(password);
		
		UsuarioBean operarioBeanSalida  = service.validaUsuario(operarioBean);
		if(operarioBeanSalida == null){
			mensaje ="El usuario no existe";
			addActionError(mensaje);

			if (is_customer){
				return  "loginCliente";	
				
			}else{
				return  "loginAdmin";				
			}
		}else{
			if (is_customer){
				System.out.println("EN CLIENTE");
				System.out.println(operarioBeanSalida.getUsername());
				if (operarioBeanSalida.getIdRol().equals("4")){
					session.put("objCli",operarioBeanSalida);
					return  "successCliente";					
				}else{
					mensaje ="No existe usuario";
					addActionError(mensaje);
					return  "loginCliente";					
				}
			}else{
				System.out.println(operarioBeanSalida.getIdUsuario());
				if (operarioBeanSalida.getIdRol().equals("1")||operarioBeanSalida.getIdRol().equals("2")||operarioBeanSalida.getIdRol().equals("3")){
					builderMenu = menuDinamico.cargarMenu(operarioBeanSalida.getIdUsuario());
					EmpleadoBean emp = serviceEmpleado.buscaEmpleadoxUsuario(Integer.parseInt(operarioBeanSalida.getIdUsuario()));
					session.put("objEmp",emp);
					session.put("objUsuarioMenus",builderMenu);
					return  "successAdmin";					
				}else{			
					mensaje ="El usuario no existe";
					addActionError(mensaje);
					return  "loginAdmin";		
				}
				
			}		
		}	
	}	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public StringBuilder getBuilderMenu() {
		return builderMenu;
	}

	public void setBuilderMenu(StringBuilder builderMenu) {
		this.builderMenu = builderMenu;
	}
	public boolean isIs_customer() {
		return is_customer;
	}
	public void setIs_customer(boolean is_customer) {
		this.is_customer = is_customer;
	}
}
