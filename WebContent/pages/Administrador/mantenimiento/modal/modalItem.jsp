<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<div id="ModalItemID" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <s:form action="registraItem" enctype="multipart/form-data"  method="post">
	 		<s:hidden id="idSeleccion" name="idSeleccion"/>
			<div class="modal-body">
                 <div class="row">  
		        	<div class="form-group col-md-6" style="margin:0px">
			    		<label class="label-control" id="registraItem_item_nombreItem" >Numero de Item</label>
			    		<s:textfield cssClass="form-control" name="item.nombreItem"></s:textfield>
			    		<label class="label-control" id="registraItem_item_descripcionItem" >Descripción de Item</label>
			    		<s:textfield cssClass="form-control" name="item.descripcionItem"></s:textfield>
			    		<label class="label-control" id="registraItem_item_fechaIngreso">Fecha de Registro</label>
				    	<sj:datepicker id="registraItem_item_fechaIngreso" showOn="focus" displayFormat="yy/mm/dd" cssClass="form-control"  name="item.fechaIngreso"/>
			    		<label class="label-control" id="registraItem_item_stock">Stock</label>
			    		<s:textfield cssClass="form-control" name="stock"></s:textfield>			    		
			    	</div>
			    	<!-- window.document.querySelectorAll('input'); -->
			    	<div class="form-group col-md-6">
			    		<label class="label-control">Foto del Item :</label>
				        <div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image" alt="">
							</div>
							<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
							<div>
								<span class="btn btn-info btn-file ">
									 <span class="fileupload-new">
									 <i class="fa fa-fw fa-camera"></i>
										 Seleccione
									</span> 
									<span class="fileupload-exists"><i class="fa fa-fw fa-camera"></i> Cambiar</span>
									<s:file name="item.filImagen" accept="text/txt"></s:file>
								</span>
								<a href="#" class="btn fileupload-exists btn-info" data-dismiss="fileupload">
									<i class="fa fa-fw fa-times"></i> Remover
								</a>
							</div>
						</div>
			    	</div>
			    	<div class="form-group col-md-12" style="padding:0px; margin:0px">
				    	<div class="form-group col-md-6">
			    			<label class="label-control">Categoria :</label>
							<s:url id="jsonCategoria" action="cargaCategoria"/> 
							<sj:select  href="%{jsonCategoria}"  
										name="item.idCategoria"  
								 		list="lstCategoria" 
								 		listKey="idCategoriaItem"
							 		    listValue="nombreCategoria"  
							 		    emptyOption="false" 
										cssClass="form-control"/></div>	  	
			    	
			    	</div>		    	
			   </div>
			</div>
			<div class="modal-footer">	
		        <s:submit cssClass="btn btn-primary"  value="Guardar Cambios" button="true" 
					   validateFunction="customeValidation" onBeforeTopics="removeErrors" 
					   onSuccessTopics="removeErrors" indicator="indicator"  validate="true"></s:submit>
			        <button class="btn btn-danger" data-dismiss="modal" aria-label="Close">CANCELAR</button>		
	        </div>  
        </s:form>   
    </div>
  </div>
</div>


