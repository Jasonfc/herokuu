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
import com.pit.pasteleria.venta.bean.CategoriaItemBean;
import com.pit.pasteleria.venta.bean.ItemBean;
import com.pit.pasteleria.venta.service.ItemServiceImpl;
import com.pit.pasteleria.venta.util.Utilititarios;

@ParentPackage(value = "dawi")
public class ItemAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private ItemServiceImpl itemService = new ItemServiceImpl();
	private ItemBean item;
	private List<ItemBean> lstItem;
	private List<CategoriaItemBean> lstCategoria;
	private InputStream imagenItem, documentoItem;
	private Integer rows = 0, page = 0, total = 0, records = 0;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String idSeleccion, mensaje, stock;


	private int idCodigo;
	private String tipoArchivo, nombreArchivo;	
	
	@Action(value = "/cargaCategoria", results = { @Result(name = "success", type="json") })
	public String cargaVendedor() {
		System.out.println("Carga combo Categoria Item");
		try {
			lstCategoria = itemService.listaCategorias();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "/a_mantenimientoItem",results = {@Result(location = "t_mantenimientoItem", name = "success" ,type="tiles")})
	public String listaItem(){
		log.info("En listaItem");
		List<ItemBean> data = itemService.traeTodos();
		session.put("keyItem", data);
		return "success";
	}
	
	
	@Action(value = "/manteListaItemGrid", results = { @Result(name = "success", type = "json") })
	@SuppressWarnings("unchecked")
	public String listaItemGrid() {
		log.info("En lista vendedor Grid");
		try {			
			List<ItemBean> data = (ArrayList<ItemBean>) session.get("keyItem");
			records = data.size();

			int hasta = (rows * page);
			int desde = hasta - rows;
			if (hasta > records)
				hasta = records;

			lstItem = data.subList(desde, hasta);

			total = (int) Math.ceil((double) records / (double) rows);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "/registraItem",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoItem",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoItem",type="tiles")
			})
	public String registra(){
		log.info("En Registra");
		try {

			if(item!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= item.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				item.setFilImagenBytes(bytes);
				item.setStock(Integer.parseInt(stock));				
				int salida = itemService.insertaItem(item);
				if (salida!=-1){
					mensaje = "Se registro correctamente el Item";
					addActionMessage(mensaje);
				}else{
					mensaje = "Error al registrar el Item";
					addActionError(mensaje);
					
				}
				return listaItem();
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	@Action(value = "/actualizaItem",
			results = { 
			@Result( name = "success" ,location = "t_mantenimientoItem",type="tiles") ,
			@Result( name = "error" ,location = "t_mantenimientoItem",type="tiles")
			})
	public String actualiza(){
		log.info("En ACTUALIZA");
		try {

			if(item!= null){
				//Recibe File por el Struts y se convierte a byte[]
				File files= item.getFilImagen();
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				item.setFilImagenBytes(bytes);
				
				item.setIdItem(idSeleccion);
				item.setStock(Integer.parseInt(stock));
				int salida = itemService.actualizaItem(item);

				if (salida!=-1){
					mensaje = "Se modifico correctamente el Item";
					addActionMessage(mensaje);
				}else{
					mensaje = "Error al modificar el Item";
					addActionError(mensaje);
					
				}
				return listaItem();
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	@SuppressWarnings("unchecked")
	@Action(value = "/eliminaItem", results = {@Result(location = "t_mantenimientoItem", name = "success",type="tiles") })
	public String elimina() throws Exception {
		log.info("En eliminaVendedor");
		
		lstItem =(ArrayList<ItemBean>)session.get("keyItem");
		
		if(lstItem== null ||  lstItem.size()==0){
			mensaje="Se debería haber realizado una selección";
			addActionError(mensaje);
			return SUCCESS;
		}
		
		if(idSeleccion == null||  idSeleccion.length()==0){
			mensaje="Se debería haber seleccionado un registro";
			addActionError(mensaje);
			return SUCCESS;
		}
		
		itemService.eliminaItem(idSeleccion);
		mensaje = "Se elimino correctamente";
		addActionMessage(mensaje);
		idSeleccion = null;
		
		return listaItem();
	}
	@Action(value = "/verImagenItem", 
			results = { @Result(
							params={"inputName","imagenItem"}, 
							name = "success", type="stream") })
	public String imagen() throws Exception {
		try {
			
			ItemBean item = itemService.buscaItem(idCodigo);
			if(item.getFilImagenBytes()!=null){
				imagenItem= new ByteArrayInputStream(item.getFilImagenBytes());
			}
			else{
				//Cambiar ruta !!!
//				File files = new File("/home/javier/Documentos/ArrancarEclipse/dawi/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
				File files = new File("D:/dawii/Proyecto-Pit/./WebContent/Administrador/images/Icon-user.png");
				byte[] bytes =Utilititarios.getBytesFromFile(files);
				imagenItem = new ByteArrayInputStream(bytes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}


	public ItemServiceImpl getItemService() {
		return itemService;
	}


	public void setItemService(ItemServiceImpl itemService) {
		this.itemService = itemService;
	}


	public ItemBean getItem() {
		return item;
	}


	public void setItem(ItemBean item) {
		this.item = item;
	}


	public List<ItemBean> getLstItem() {
		return lstItem;
	}


	public void setLstItem(List<ItemBean> lstItem) {
		this.lstItem = lstItem;
	}


	public InputStream getImagenItem() {
		return imagenItem;
	}


	public void setImagenItem(InputStream imagenItem) {
		this.imagenItem = imagenItem;
	}


	public InputStream getDocumentoItem() {
		return documentoItem;
	}


	public void setDocumentoItem(InputStream documentoItem) {
		this.documentoItem = documentoItem;
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
	

	public List<CategoriaItemBean> getLstCategoria() {
		return lstCategoria;
	}

	public void setLstCategoria(List<CategoriaItemBean> lstCategoria) {
		this.lstCategoria = lstCategoria;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	
	
	
	
	
}
