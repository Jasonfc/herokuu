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
import com.pit.pasteleria.venta.bean.InsumoBean;
import com.pit.pasteleria.venta.bean.InsumoCategoriaBean;
import com.pit.pasteleria.venta.service.InsumoServiceImpl;
import com.pit.pasteleria.venta.service.UsuarioServiceImpl;
import com.pit.pasteleria.venta.util.Utilititarios;




@ParentPackage(value="dawi")
public class InsumoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private InsumoServiceImpl insumoService = new InsumoServiceImpl();
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	private InsumoBean insumo;
	private List<InsumoBean> lstInsumo;
	private List<InsumoCategoriaBean> lstCategoria;
	private InputStream imagenInsumo, documentoInsumo;
	private Integer rows = 0, page = 0, total = 0, records = 0;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String idSeleccion, mensaje;
	

	private int idCodigo;
	private String tipoArchivo, nombreArchivo;	
	
	@Action(value = "/cargaCategoriaInsumo", results = { @Result(name = "success", type="json") })
	public String cargaVendedor() {
		System.out.println("Carga combo Categoria Item");
		try {
			lstCategoria = insumoService.listaCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
		@Action(value = "/a_mantenimientoInsumo",results = {@Result(location = "t_mantenimientoInsumo", name = "success" ,type="tiles")})
		public String listaInsumo() throws Exception{
			log.info("En listaInsumo");
			List<InsumoBean> data = insumoService.traeTodos();
			session.put("keyInsumo",data);
			return "success";
		}
		
		@Action(value = "/manteListaInsumoGrid", results = { @Result(name = "success", type = "json") })
		@SuppressWarnings("unchecked")
		public String listaInsumoGrid() {
			log.info("En lista Insumo Grid");
			try {			
				List<InsumoBean> data = (ArrayList<InsumoBean>) session.get("keyInsumo");
				records = data.size();

				int hasta = (rows * page);
				int desde = hasta - rows;
				if (hasta > records)
					hasta = records;

				lstInsumo = data.subList(desde, hasta);

				total = (int) Math.ceil((double) records / (double) rows);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
		
		
		@Action(value = "/registraInsumo",
				results = { 
				@Result( name = "success" ,location = "t_mantenimientoInsumo",type="tiles") ,
				@Result( name = "error" ,location = "t_mantenimientoInsumo",type="tiles")
				})
		public String registra(){
			log.info("En Registra");
			try {

				if(insumo!= null){
					//Recibe File por el Struts y se convierte a byte[]
					File files= insumo.getFilImagen();
					byte[] bytes =Utilititarios.getBytesFromFile(files);
					insumo.setFilImagenBytes(bytes);
					
					int salida = insumoService.inserta(insumo);
					if (salida!=-1){
						mensaje = "Se registro correctamente el Insumo";
						addActionMessage(mensaje);
					}else{
						mensaje = "Error al registrar el Insumo";
						addActionError(mensaje);
						
					}
					return listaInsumo();
				}else{
					return ERROR;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		@Action(value = "/actualizaInsumo",
				results = { 
				@Result( name = "success" ,location = "t_mantenimientoEmpleado",type="tiles") ,
				@Result( name = "error" ,location = "t_mantenimientoEmpleado",type="tiles")
				})
		public String actualiza(){
			log.info("En ACTUALIZA");
			try {

				if(insumo!= null){
					//Recibe File por el Struts y se convierte a byte[]
					File files= insumo.getFilImagen();
					byte[] bytes =Utilititarios.getBytesFromFile(files);
					insumo.setFilImagenBytes(bytes);
					insumo.setIntCodigo(idSeleccion);
					int salida = insumoService.actualizaInsumo(insumo);

					if (salida!=-1){
						mensaje = "Se modifico correctamente el Insumo";
						addActionMessage(mensaje);
					}else{
						mensaje = "Error al modificar el Insumo";
						addActionError(mensaje);
						
					}
					listaInsumo();
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
		@Action(value = "/eliminaInsumo", results = {@Result(location = "t_mantenimientoEmpleado", name = "success",type="tiles") })
		public String eliminaVendedor() throws Exception {
			log.info("En eliminaVendedor");
			
			lstInsumo =(ArrayList<InsumoBean>)session.get("keyInsumo");
			
			if(lstInsumo== null ||  lstInsumo.size()==0){
				mensaje="Se deber�a haber realizado una selecci�n";
				return SUCCESS;
			}
			
			if(idSeleccion == null||  idSeleccion.length()==0){
				mensaje="Se deber�a haber seleccionado un registro";
				return SUCCESS;
			}
			
			insumoService.eliminaInsumo(Integer.parseInt(idSeleccion));
			idSeleccion = null;

			listaInsumo();
			return SUCCESS;
		}
		@Action(value = "/verImagenInsumo", 
				results = { @Result(
								params={"inputName","imagenInsumo"}, 
								name = "success", type="stream") })
		public String imagenInsumo() throws Exception {
			try {
				
				InsumoBean insum = insumoService.obtienePorPK(idCodigo);
				if(insum.getFilImagenBytes()!=null){
					imagenInsumo= new ByteArrayInputStream(insum.getFilImagenBytes());
				}
				else{
					//Cambiar ruta !!!
//					File files = new File("/home/javier/Documentos/ArrancarEclipse/dawi/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
					File files = new File("D:/dawii/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
					byte[] bytes =Utilititarios.getBytesFromFile(files);
					imagenInsumo = new ByteArrayInputStream(bytes);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
		//GEt - set 
		public InsumoServiceImpl getInsumoService() {
			return insumoService;
		}

		public void setInsumoService(InsumoServiceImpl insumoService) {
			this.insumoService = insumoService;
		}

		public UsuarioServiceImpl getUsuarioService() {
			return usuarioService;
		}

		public void setUsuarioService(UsuarioServiceImpl usuarioService) {
			this.usuarioService = usuarioService;
		}
		public InsumoBean getInsumo() {
			return insumo;
		}

		public void setInsumo(InsumoBean insumo) {
			this.insumo = insumo;
		}
		public List<InsumoBean> getlstInsumo() {
			return lstInsumo;
		}

		public void setlstInsumo(List<InsumoBean> lstInsumo) {
			this.lstInsumo = lstInsumo;
		}

		public InputStream getImagenInsumo() {
			return imagenInsumo;
		}

		public void setImagenInsumo(InputStream imagenInsumo) {
			this.imagenInsumo = imagenInsumo;
		}

		public InputStream getDocumentoInsumo() {
			return documentoInsumo;
		}

		public void setDocumentoInsumo(InputStream documentoInsumo) {
			this.documentoInsumo = documentoInsumo;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public static Log getLog() {
			return log;
		}

		public List<InsumoBean> getLstInsumo() {
			return lstInsumo;
		}

		public void setLstInsumo(List<InsumoBean> lstInsumo) {
			this.lstInsumo = lstInsumo;
		}

		public List<InsumoCategoriaBean> getLstCategoria() {
			return lstCategoria;
		}

		public void setLstCategoria(List<InsumoCategoriaBean> lstCategoria) {
			this.lstCategoria = lstCategoria;
		}


}
