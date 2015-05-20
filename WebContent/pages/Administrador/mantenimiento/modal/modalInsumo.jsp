<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<div id="ModalInsumoID" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <s:form action="registraInsumo" enctype="multipart/form-data"  method="post">
	 		<s:hidden id="idSeleccion" name="idSeleccion"/>
			<div class="modal-body">
                 <div class="row">  
		        	<div class="form-group col-md-6" style="margin:0px">
			    		<label class="label-control" >Fecha Ingreso</label>
			    		<s:textfield cssClass="form-control" name="insumo.strFecRegistro" id="registraInsumo_insumo_strFecRegistro"/>
			    		<label class="label-control" >Fecha Vencimiento</label>
			    		<s:textfield cssClass="form-control" name="insumo.strFecVencimiento" id="registraInsumo_insumo_strFecVencimiento"/>
			    		<label class="label-control" >Cantidad</label>
			    		<s:textfield cssClass="form-control" name="insumo.InCantidad" id="registraInsumo_insumo_InCantidad"/>
			    		<label class="label-control" >Nombre de insumo</label>
				    	<s:textfield cssClass="form-control" name="insumo.strNombre" id="registraInsumo_insumo_nombre"/>
			    	</div>
			    	<!-- window.document.querySelectorAll('input'); -->
			    	<div class="form-group col-md-6">
			    		<label class="label-control">Imagen del insumo:</label>
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
									<s:file name="insumo.filImagen" accept="text/txt"></s:file>
								</span>
								<a href="#" class="btn fileupload-exists btn-info" data-dismiss="fileupload">
									<i class="fa fa-fw fa-times"></i> Remover
								</a>
							</div>
						</div>
			    	</div>
			    	<div class="form-group col-md-12">
				    	<label class="label-control">Categoria :</label>
							<s:url id="jsonCategoria" action="cargaCategoriaInsumo"/> 
							<sj:select  href="%{jsonCategoria}"  
										name="insumo.strCategoria"  
								 		list="lstCategoria" 
								 		listKey="idCatInsumo"
							 		    listValue="desCatInsumo"  
							 		    emptyOption="false" 
										cssClass="form-control" id="registraInsumo_insumo_strCategoria"/></div>	 
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


