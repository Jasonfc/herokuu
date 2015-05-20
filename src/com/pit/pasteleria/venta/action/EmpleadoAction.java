package com.pit.pasteleria.venta.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pit.pasteleria.venta.bean.EmpleadoBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;
import com.pit.pasteleria.venta.service.EmpleadoServiceImpl;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;
import com.pit.pasteleria.venta.util.Utilititarios;

@ParentPackage(value = "dawi")
public class EmpleadoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private EmpleadoServiceImpl empleadoService = new EmpleadoServiceImpl();
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	private EmpleadoBean empleado;
	private UsuarioBean usuario;
	private List<EmpleadoBean> lstEmpleado;
	private InputStream imagenEmpleado, documentoEmpleado;
	private Integer rows = 0, page = 0, total = 0, records = 0;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String idSeleccion, mensaje;
	


	private int idCodigo;
	private String tipoArchivo, nombreArchivo;	
	
	@Action(value = "/a_mantenimientoEmpleado",results = {@Result(location = "t_mantenimientoEmpleado", name = "success" ,type="tiles")})
	public String listaEmpleado(){
		log.info("En listaEmpleado");
		List<EmpleadoBean> data = empleadoService.traeTodos();
		session.put("keyEmpleado", data);
		return "success";
	}
	
	
	@Action(value = "/manteListaEmpleadoGrid", results = { @Result(name = "success", type = "json") })
	@SuppressWarnings("unchecked")
	public String listaEmpleadoGrid() {
		log.info("En lista vendedor Grid");
		try {			
			List<EmpleadoBean> data = (ArrayList<EmpleadoBean>) session.get("keyEmpleado");
			records = data.size();

			int hasta = (rows * page);
			int desde = hasta - rows;
			if (hasta > records)
				hasta = records;

			lstEmpleado = data.subList(desde, hasta);

			total = (int) Math.ceil((double) records / (double) rows);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "/registraEmpleado",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoEmpleado",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoEmpleado",type="tiles")
			})
	public String registra(){
		log.info("En Registra");
		try {

			if(empleado!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= empleado.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				empleado.setFilImagenBytes(bytes);
				usuario.setIdUsuario((usuarioService.ultimoCodigoUsuario()+1)+"");
				int salidaUsuario = usuarioService.insertaUsuario(usuario);
				if(salidaUsuario !=-1){						
					empleado.setIdUsuario(usuario.getIdUsuario());
					int salida = empleadoService.insertaEmpleado(empleado);
					if (salida!=-1){
						mensaje = "Se registro correctamente el Empleado";
						addActionMessage(mensaje);						
					listaEmpleado();
					return SUCCESS;						
				}else{
					mensaje = "Error al registrar el Rol";
					addActionError(mensaje);
					return ERROR;						
				}
				}else{
					mensaje = "Error al registrar el Usuario";
					addActionError(mensaje);
					return ERROR;
				}				
				
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	@Action(value = "/actualizaEmpleado",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoEmpleado",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoEmpleado",type="tiles")
			})
	public String actualiza(){
		log.info("En ACTUALIZA");
		try {

			if(empleado!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= empleado.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				empleado.setFilImagenBytes(bytes);
				empleado.setIdEmpleado(idSeleccion);
				int salida = empleadoService.actualizaEmpleado(empleado);

				if (salida!=-1){
					mensaje = "Se modifico correctamente el Empleado";
					addActionMessage(mensaje);
				}else{
					mensaje = "Error al modificar el Empleado";
					addActionError(mensaje);
					
				}
				listaEmpleado();
				return SUCCESS;
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	@SuppressWarnings("unchecked")
	@Action(value = "/eliminaEmpleado", results = {@Result(location = "t_mantenimientoEmpleado", name = "success",type="tiles") })
	public String eliminaVendedor() throws Exception {
		log.info("En eliminaVendedor");
		
		lstEmpleado =(ArrayList<EmpleadoBean>)session.get("keyEmpleado");
		
		if(lstEmpleado== null ||  lstEmpleado.size()==0){
			mensaje="Se deber�a haber realizado una selecci�n";
			return SUCCESS;
		}
		
		if(idSeleccion == null||  idSeleccion.length()==0){
			mensaje="Se deber�a haber seleccionado un registro";
			return SUCCESS;
		}
		
		empleadoService.eliminaEmpleado(idSeleccion);
		idSeleccion = null;

		listaEmpleado();
		return SUCCESS;
	}
	@Action(value = "/verImagenEmpleado", 
			results = { @Result(
							params={"inputName","imagenEmpleado"}, 
							name = "success", type="stream") })
	public String imagenPersonal() throws Exception {
		try {
			EmpleadoBean personal = empleadoService.buscaEmpleado(idCodigo);
			if(personal.getFilImagenBytes()!=null){
				imagenEmpleado = new ByteArrayInputStream(personal.getFilImagenBytes());
			}
			else{
				//Cambiar ruta !!!
				File files = new File("/home/javier/Documentos/ArrancarEclipse/dawi/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
//				File files = new File("D:/dawii/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				imagenEmpleado = new ByteArrayInputStream(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public EmpleadoServiceImpl getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoServiceImpl empleadoService) {
		this.empleadoService = empleadoService;
	}

	public EmpleadoBean getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}

	public List<EmpleadoBean> getLstEmpleado() {
		return lstEmpleado;
	}

	public void setLstEmpleado(List<EmpleadoBean> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}

	public InputStream getImagenEmpleado() {
		return imagenEmpleado;
	}

	public void setImagenEmpleado(InputStream imagenEmpleado) {
		this.imagenEmpleado = imagenEmpleado;
	}

	public InputStream getDocumentoEmpleado() {
		return documentoEmpleado;
	}

	public void setDocumentoEmpleado(InputStream documentoEmpleado) {
		this.documentoEmpleado = documentoEmpleado;
	}

	public int getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	
	public String getIdSeleccion() {
		return idSeleccion;
	}

	public void setIdSeleccion(String idSeleccion) {
		this.idSeleccion = idSeleccion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public UsuarioServiceImpl getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}


	public UsuarioBean getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	
	
	
}
