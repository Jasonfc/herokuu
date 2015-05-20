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
import com.pit.pasteleria.venta.bean.DetalleTortaItemBean;
import com.pit.pasteleria.venta.bean.TortaBean;
import com.pit.pasteleria.venta.service.TortaServiceImpl;
import com.pit.pasteleria.venta.util.Utilititarios;

@ParentPackage(value = "dawi")
public class TortaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private TortaServiceImpl tortaService = new TortaServiceImpl();
	private TortaBean torta;
	private DetalleTortaItemBean detalle_torta;
	private List<TortaBean> lstTorta;
	private List<DetalleTortaItemBean> lstDetalleTorta;
	private InputStream imagenTorta, documentoTorta;
	private Integer rows = 0, page = 0, total = 0, records = 0;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String idSeleccion, mensaje, idTorta, idItem;
	private int cantidad;
	private int idCodigo;
	private String tipoArchivo, nombreArchivo;	
	
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadsFileName  = new ArrayList<String>();
	
	@Action(value = "/a_mantenimientoTorta",results = {@Result(location = "t_mantenimientoTorta", name = "success" ,type="tiles")})
	public String listaTorta(){
		log.info("En listaTorta");
		List<TortaBean> data = tortaService.traeTodos();
		session.put("keyTorta", data);
		return "success";
	}
	
	@Action(value = "/listDetalleTorta", results = { @Result(name = "success", type = "json") })
	public String listDetalleTorta() {
		log.info("En lista vendedor Grid");
		try {			
			lstDetalleTorta = tortaService.traeDetalle(idTorta);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	@Action(value = "/manteListaTortaGrid", results = { @Result(name = "success", type = "json") })
	@SuppressWarnings("unchecked")
	public String listaTortaGrid() {
		log.info("En lista vendedor Grid");
		try {			
			List<TortaBean> data = (ArrayList<TortaBean>) session.get("keyTorta");
			records = data.size();

			int hasta = (rows * page);
			int desde = hasta - rows;
			if (hasta > records)
				hasta = records;

			lstTorta = data.subList(desde, hasta);

			total = (int) Math.ceil((double) records / (double) rows);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "/registraTorta",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoTorta",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoTorta",type="tiles")
			})
	public String registra(){
		log.info("En Registra");
		int i=0;
		System.out.println(uploads);
		for(File file : uploads){			
			String fileName = uploadsFileName.get(i);
			System.out.println("Cliente/screen/products/"+fileName);
			i++;
		}
	   
		try {

			if(torta!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= torta.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				torta.setFilImagenBytes(bytes);
				int cod = tortaService.ultimoCodigoTorta();
				if (cod==-1){
					cod = 1;
				}else{
					cod +=1;
				}
				torta.setIdTorta((cod)+"");
				int salida = tortaService.insertaTorta(torta);
				if (salida!=-1){
					mensaje = "Se registro correctamente el Torta";
					addActionMessage(mensaje);						
					listaTorta();
				return SUCCESS;						
			}else{
				mensaje = "Error al registrar el Rol";
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


	@Action(value = "/actualizaTorta",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoTorta",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoTorta",type="tiles")
			})
	public String actualiza(){
		log.info("En ACTUALIZA");
		try {

			if(torta!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= torta.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				torta.setFilImagenBytes(bytes);
				torta.setIdTorta(idSeleccion);
				int salida = tortaService.actualizaTorta(torta);

				if (salida!=-1){
					mensaje = "Se modifico correctamente el Torta";
					addActionMessage(mensaje);
				}else{
					mensaje = "Error al modificar el Torta";
					addActionError(mensaje);
					
				}
				listaTorta();
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
	@Action(value = "/eliminaTorta", results = {@Result(location = "t_mantenimientoTorta", name = "success",type="tiles") })
	public String eliminaVendedor() throws Exception {
		log.info("En eliminaVendedor");
		
		lstTorta =(ArrayList<TortaBean>)session.get("keyTorta");
		
		if(lstTorta== null ||  lstTorta.size()==0){
			mensaje="Se deberia haber realizado una seleccion";
			addActionError(mensaje);
			return SUCCESS;
		}
		
		if(idSeleccion == null||  idSeleccion.length()==0){
			mensaje="Se deberia haber seleccionado un registro";
			addActionError(mensaje);
			return SUCCESS;
		}
		
		tortaService.eliminaTorta(idSeleccion);
		idSeleccion = null;
		mensaje = "Se elimino la torta";
		addActionMessage(mensaje);

		listaTorta();
		return SUCCESS;
	}
	@Action(value = "/verImagenTorta", 
			results = { @Result(
							params={"inputName","imagenTorta"}, 
							name = "success", type="stream") })
	public String imagenPersonal() throws Exception {
		try {
			
			TortaBean personal = tortaService.buscaTorta(idCodigo);
			if(personal.getFilImagenBytes()!=null){
				imagenTorta= new ByteArrayInputStream(personal.getFilImagenBytes());
			}
			else{
				//Cambiar ruta !!!
				File files = new File("/home/javier/Documentos/ArrancarEclipse/dawi/Proyecto-Pit/./WebContent/Cliente/screen/products/product_12_large.jpg");
//				File files = new File("D:/dawii/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				imagenTorta = new ByteArrayInputStream(bytes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}


	public TortaServiceImpl getTortaService() {
		return tortaService;
	}


	public void setTortaService(TortaServiceImpl tortaService) {
		this.tortaService = tortaService;
	}


	public TortaBean getTorta() {
		return torta;
	}


	public void setTorta(TortaBean torta) {
		this.torta = torta;
	}


	public DetalleTortaItemBean getDetalle_torta() {
		return detalle_torta;
	}


	public void setDetalle_torta(DetalleTortaItemBean detalle_torta) {
		this.detalle_torta = detalle_torta;
	}


	public List<TortaBean> getLstTorta() {
		return lstTorta;
	}


	public void setLstTorta(List<TortaBean> lstTorta) {
		this.lstTorta = lstTorta;
	}


	public InputStream getImagenTorta() {
		return imagenTorta;
	}


	public void setImagenTorta(InputStream imagenTorta) {
		this.imagenTorta = imagenTorta;
	}


	public InputStream getDocumentoTorta() {
		return documentoTorta;
	}


	public void setDocumentoTorta(InputStream documentoTorta) {
		this.documentoTorta = documentoTorta;
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


	public String getIdTorta() {
		return idTorta;
	}


	public void setIdTorta(String idTorta) {
		this.idTorta = idTorta;
	}


	public String getIdItem() {
		return idItem;
	}


	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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


	public List<DetalleTortaItemBean> getLstDetalleTorta() {
		return lstDetalleTorta;
	}


	public void setLstDetalleTorta(List<DetalleTortaItemBean> lstDetalleTorta) {
		this.lstDetalleTorta = lstDetalleTorta;
	}

	public List<File> getUploads() {
		return uploads;
	}

	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	public List<String> getUploadsFileName() {
		return uploadsFileName;
	}

	public void setUploadsFileName(List<String> uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}


	
	
	
}
