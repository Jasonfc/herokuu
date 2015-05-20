<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script type="text/javascript">
function soloNumeros(e) {	
	   if(event.shiftKey)
	   {
	        event.preventDefault();
	   }
	 
	   if (event.keyCode == 46 || event.keyCode == 8)    {
	   }
	   else {
	        if (event.keyCode < 95) {
	          if (event.keyCode < 48 || event.keyCode > 57) {
	                event.preventDefault();
	          }
	        } 
	        else {
	              if (event.keyCode < 96 || event.keyCode > 105) {
	                  event.preventDefault();
	              }
	        }
	      }
}
$(document).ready(function(){ 
	$("#registraTorta_torta_stock").keydown(soloNumeros);
	$("#registraTorta_torta_cantPersonas").keydown(soloNumeros);
	$("#registraTorta_torta_cantPisos").keydown(soloNumeros);
	
});
</script>
<div id="ModalTortaID" class="modal fade bs-example-modal-lg">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <s:form id="formEmpleado" action="registraTorta" enctype="multipart/form-data"  method="post" autocomplete="off">
	 		<s:hidden id="idSeleccion" name="idSeleccion"/>
			<div class="modal-body">
                 <div class="row">  
                 <div>
	                 <div class="row">  
			        	<div class="form-group col-md-6">
				    		<label class="label-control" >Nombre de Torta</label>
				    		<s:textfield cssClass="form-control" name="torta.nombre" id="registraTorta_torta_nombre" ></s:textfield>			    		
			    		</div>
			    		
			        	<div class="form-group col-md-6">
			        		<label class="label-control" >Stock de Torta</label>
				    		<s:textfield cssClass="form-control" name="torta.stock" id="registraTorta_torta_stock" ></s:textfield>
				    		
			        	</div>
			        </div>
		        </div>
                 <div>
                 	<div class="row">  
	                 	<div class="form-group col-md-6">
			        		<label class="label-control" >Fecha de Registro</label>
					    	<sj:datepicker id="registraTorta_torta_fechaRegistro" showOn="focus" displayFormat="yy/mm/dd" cssClass="form-control"  name="torta.fechaRegistro"/>
				    		
			        	</div>
			        	<div class="form-group col-md-6">
			        		<label class="label-control" >Precio</label>
				    		<s:textfield cssClass="form-control" name="torta.precio" id="registraTorta_torta_precio"></s:textfield>
				    	</div>
                 	</div>
                 </div>
                 <div>
                 	<div class="row"> 
	                 	<div class="form-group col-md-6">
			    			<label class="label-control" >Cantidad de Porciones</label>
			    			<s:textfield cssClass="form-control" name="torta.cantPersonas" id="registraTorta_torta_cantPersonas"></s:textfield></div>	    	
		    			    	
				    	<div class="form-group col-md-6">
				    		<label class="label-control" >Cantidad de Pisos</label>
				    		<s:textfield cssClass="form-control" name="torta.cantPisos" id="registraTorta_torta_cantPisos"></s:textfield>
				    	</div>
                 	
                 	</div>
		        </div> 
		    		
		    	<div class="form-group col-md-12" style="padding: 0;">
		    		<label class="label-control">Descripcion de Torta</label>
	    			<s:textarea cssClass="form-control" name="torta.descripcion" id="registraTorta_torta_descripcion" ></s:textarea>
		    	</div> 
		    	<div>
                 	<div class="row">  
                 		<div class="form-group col-md-5">
                 			<label class="label-control">Foto de la Torta :</label>
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
										<s:file name="torta.filImagen" accept="text/txt"/>
									</span>
									<a href="#" class="btn fileupload-exists btn-info" data-dismiss="fileupload">
										<i class="fa fa-fw fa-times"></i> Remover
									</a>
								</div>
							</div>
                 		</div>
                 		<div class="form-group col-md-7">
                 			<div class="form-group col-md-12">
                 				<label class="label-control">Foto extra:</label>
	                 			<s:file label="File One" name="uploads" cssClass="form-control"/>
                 			</div>
                 			<div class="form-group col-md-12">
                 				<label class="label-control">Foto extra:</label>
								<s:file label="File Two" name="uploads" cssClass="form-control" />
                 			</div>
                 			<div class="form-group col-md-12">
                 				<label class="label-control">Foto extra:</label>
								<s:file label="FIle Three" name="uploads" cssClass="form-control" />  
                 			</div>          		
                 		
                 		</div>
                 	
                 	</div>
		    		
		    	</div>	  	
		    </div>
			</div>
			<div class="modal-footer">	
		        <s:submit  cssClass="btn btn-primary"  value="Guardar Cambios" button="true" 		        		
					   validateFunction="customeValidation" onBeforeTopics="removeErrors" 
					   onSuccessTopics="removeErrors" indicator="indicator" id="SubmitEmpleado"  validate="true"></s:submit>
			        <button class="btn btn-danger" data-dismiss="modal" aria-label="Close">CANCELAR</button>		
	        </div>  
        </s:form>   
    </div>
  </div>
</div>


