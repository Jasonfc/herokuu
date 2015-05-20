<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<div id="ModalClienteID" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <s:form id="formEmpleado" action="registraEmpleado" enctype="multipart/form-data"  method="post">
	 		<s:hidden id="idSeleccion" name="idSeleccion"/>
			<div class="modal-body">
                 <div class="row">  
                 <div class="form-group col-md-12"> 
                 	<div class="row">
	                 	<div class="form-group col-md-6" style="margin:0px">
				    		<label class="label-control" >Numero de DNI</label>
				    		<s:textfield id="registraCliente_cliente_dni" cssClass="form-control"/>
				    		<label class="label-control" >Nombre completo</label>
				    		<s:textfield id="registraCliente_cliente_nombre" cssClass="form-control" ></s:textfield>
				    		<label class="label-control" >Apellido paterno</label>
				    		<s:textfield id="registraCliente_cliente_apePaterno"cssClass="form-control"></s:textfield>
				    		<label class="label-control" >Apellido materno</label>
				    		<s:textfield  id="registraCliente_cliente_apeMaterno" cssClass="form-control"></s:textfield>
				    	</div>
				    	<div class="form-group col-md-6">
				    		<label class="label-control">Foto del Empleado :</label>
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
										<s:file name="" accept="text/txt"></s:file>
									</span>
									<a href="#" class="btn fileupload-exists btn-info" data-dismiss="fileupload">
										<i class="fa fa-fw fa-times"></i> Remover
									</a>
								</div>
							</div>
				    	</div>
			    	</div>        
                 
                 </div>
                 	
		        	
			    	<div class="form-group col-md-12" style="padding:0px; margin:0px">
				    	<div class="form-group col-md-6">
				    		<label class="label-control">Fecha de nacimiento</label>
				    		<sj:datepicker id="registraCliente_cliente_fechaIngreso" showOn="focus" displayFormat="yy/mm/dd" cssClass="form-control"  />
				    		</div>
				    	<div class="form-group col-md-6">
				    		<label class="label-control" >Numero de celular</label>
				    		<s:textfield id="registraCliente_cliente_celular" cssClass="form-control"></s:textfield></div>	    	
			    	
			    	</div>			    	
			    	<div class="form-group col-md-6">
			    		<label class="label-control" >Direccion</label>
			    		<s:textfield id="registraCliente_cliente_direccion" cssClass="form-control"></s:textfield>
			    	</div>  
			    		
			    	<div class="form-group col-md-6">
			    		<label class="label-control" >Rol en el Sistema</label> 
			    		<s:textfield id="registraCliente_cliente_rol" cssClass="form-control"></s:textfield>
			    	</div>
			    	<div class="col-lg-11"></div>
			    	<div class="col-lg-10">
			          <div class="heading"><i class="icon-quote-left"></i>Registrar Usuario </div>
			          <div class="widget-content padded">
			            <div class="row">		    	
					    	<div class="form-group col-md-12">
					    		<label class="label-control" >Usuario</label>
					    		<s:textfield cssClass="form-control" name="usuario.username" id="registraCliente_usuario_username"></s:textfield>
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


