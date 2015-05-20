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
import com.pit.pasteleria.venta.bean.ClienteBean;
import com.pit.pasteleria.venta.bean.UsuarioBean;
import com.pit.pasteleria.venta.service.ClienteServiceImpl;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;
import com.pit.pasteleria.venta.util.Utilititarios;

@ParentPackage(value = "dawi")
public class ClienteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private ClienteServiceImpl clienteService = new ClienteServiceImpl();
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	private ClienteBean cliente;
	private UsuarioBean usuario;
	private List<ClienteBean> lstCliente;
	private InputStream imagenCliente, documentoCliente;
	private Integer rows = 0, page = 0, total = 0, records = 0;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String idSeleccion, mensaje;
	

	private int idCodigo;
	private String tipoArchivo, nombreArchivo;	
	
	@Action(value = "/a_mantenimientoCliente",results = {@Result(location = "t_mantenimientoCliente", name = "success" ,type="tiles")})
	public String listaCliente(){
		log.info("En listaCliente");
		List<ClienteBean> data = clienteService.traeTodos();
		session.put("keyCliente", data);
		return "success";
	}
	
	
	@Action(value = "/manteListaClienteGrid", results = { @Result(name = "success", type = "json") })
	@SuppressWarnings("unchecked")
	public String listaClienteGrid() {
		log.info("En lista vendedor Grid");
		try {			
			List<ClienteBean> data = (ArrayList<ClienteBean>) session.get("keyCliente");
			records = data.size();

			int hasta = (rows * page);
			int desde = hasta - rows;
			if (hasta > records)
				hasta = records;

			lstCliente = data.subList(desde, hasta);

			total = (int) Math.ceil((double) records / (double) rows);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "/registraCliente",
			results = { 
			@Result( name = "success" ,location = "t_loginCliente",type="tiles") ,
			@Result( name = "error" ,location = "t_register",type="tiles")
			})
	public String registra(){
		log.info("En Registra");
		try {

			if(cliente!= null){
				File files= cliente.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				cliente.setFilImagenBytes(bytes);
				usuario.setIdUsuario((usuarioService.ultimoCodigoUsuario()+1)+"");
				int salidaUsuario = usuarioService.insertaUsuario(usuario);
				if(salidaUsuario !=-1){						
					cliente.setIdUsuario(usuario.getIdUsuario());
					int salida = clienteService.insertaCliente(cliente);
					if (salida!=-1){
						mensaje = "Se registro correctamente el Cliente";
						addActionMessage(mensaje);						
					listaCliente();
					return SUCCESS;						
						}else{
							mensaje = "Error al registrar el cliente";
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


	@Action(value = "/actualizaCliente",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoCliente",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoCliente",type="tiles")
			})
	public String actualiza(){
		log.info("En ACTUALIZA");
		try {

			if(cliente!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= cliente.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				cliente.setFilImagenBytes(bytes);
				cliente.setIdUsuario("1");
				cliente.setIdCliente(idSeleccion);
				int salida = clienteService.actualizaCliente(cliente);

				if (salida!=-1){
					mensaje = "Se modifico correctamente el Cliente";
					addActionMessage(mensaje);
				}else{
					mensaje = "Error al modificar el Cliente";
					addActionError(mensaje);
					
				}
				listaCliente();
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
	@Action(value = "/eliminaCliente", results = {@Result(location = "t_mantenimientoCliente", name = "success",type="tiles") })
	public String eliminaVendedor() throws Exception {
		log.info("En eliminaCliente");
		
		lstCliente =(ArrayList<ClienteBean>)session.get("keyCliente");
		
		if(lstCliente== null ||  lstCliente.size()==0){
			mensaje="Se deber�a haber realizado una selecci�n";
			return SUCCESS;
		}
		
		if(idSeleccion == null||  idSeleccion.length()==0){
			mensaje="Se deber�a haber seleccionado un registro";
			return SUCCESS;
		}
		
		clienteService.eliminaCliente(idSeleccion);
		idSeleccion = null;

		listaCliente();
		return SUCCESS;
	}
	@Action(value = "/verImagenCliente", 
			results = { @Result(
							params={"inputName","imagenCliente"}, 
							name = "success", type="stream") })
	public String imagenPersonal() throws Exception {
		try {
			
			ClienteBean personal = clienteService.buscaCliente(idCodigo);
			if(personal.getFilImagenBytes()!=null){
				imagenCliente = new ByteArrayInputStream(personal.getFilImagenBytes());
			}
			else{
				//Cambiar ruta !!!
				File files = new File("D:/dawii/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				imagenCliente = new ByteArrayInputStream(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}


	public ClienteServiceImpl getClienteService() {
		return clienteService;
	}


	public void setClienteService(ClienteServiceImpl clienteService) {
		this.clienteService = clienteService;
	}


	public UsuarioServiceImpl getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}


	public ClienteBean getCliente() {
		return cliente;
	}


	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}


	public UsuarioBean getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


	public List<ClienteBean> getLstCliente() {
		return lstCliente;
	}


	public void setLstCliente(List<ClienteBean> lstCliente) {
		this.lstCliente = lstCliente;
	}


	public InputStream getImagenCliente() {
		return imagenCliente;
	}


	public void setImagenCliente(InputStream imagenCliente) {
		this.imagenCliente = imagenCliente;
	}


	public InputStream getDocumentoCliente() {
		return documentoCliente;
	}


	public void setDocumentoCliente(InputStream documentoCliente) {
		this.documentoCliente = documentoCliente;
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


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	
	
	
	
}
