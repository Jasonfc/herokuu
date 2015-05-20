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
	$("#registraEmpleado_empleado_dni").keydown(soloNumeros);
	$("#registraEmpleado_usuario_username").on("blur", function () {
		var empuser="", seleccion="";
		empuser = $(this).val();
		seleccion = $('#idSeleccion').val();
		if (seleccion == ""){
		    $.ajax({		    	
		    	type	: "post",
		    	url		: "validaUsername",
		    	data	: {empuser : empuser}
		    }).success(function(){
				$("#SubmitEmpleado").attr("disabled", false);
		    	$('#registraEmpleado_usuario_username').popover('destroy');
			}).fail(function(){

				$("#registraEmpleado_usuario_username").popover({
		    		html	: true,
		    		content : 'El usuario ya esta registrado.'
		    	});
				
				$("#registraEmpleado_usuario_username").popover("show");
		    	
		    	$("#SubmitEmpleado").attr("disabled", "disabled");	 
		    	});
			}
		    });

	$("#registraEmpleado_empleado_dni").on("blur", function () {
		var dni="", seleccion="";
		dni = $(this).val();
		seleccion = $('#idSeleccion').val();
		if (seleccion == ""){
			$.ajax({		    	
		    	type	: "post",
		    	url		: "validaDNI",
		    	data	: {dni : dni}
		    }).success(function(){
				$("#SubmitEmpleado").attr("disabled", false);
		    	$('#registraEmpleado_empleado_dni').popover('destroy');
			}).fail(function(){

				$("#registraEmpleado_empleado_dni").popover({
		    		html	: true,
		    		content : 'El dni ya esta registrado.'
		    	});
				
				$("#registraEmpleado_empleado_dni").popover("show");
		    	
		    	$("#SubmitEmpleado").attr("disabled", "disabled");	 
		    	});			
		   
		}
	 });	   
	
});
</script>
<div id="ModalEmpleadoID" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <s:form id="formEmpleado" action="registraEmpleado" enctype="multipart/form-data"  method="post" autocomplete="off">
	 		<s:hidden id="idSeleccion" name="idSeleccion"/>
			<div class="modal-body">			
                 <div class="row"> 
                 <div class="form-group col-md-12"> 
                 	<div class="row">
			        	<div class="form-group col-md-6" style="padding:0px">
				    		<label class="label-control" >Numero de DNI</label>
				    		<s:textfield cssClass="form-control" name="empleado.dni" id="registraEmpleado_empleado_dni" maxlength="8"></s:textfield>
				    		<label class="label-control" >Nombre completo</label>
				    		<s:textfield cssClass="form-control" name="empleado.nombre" id="registraEmpleado_empleado_nombre" ></s:textfield>
				    		<label class="label-control" >Apellido paterno</label>
				    		<s:textfield cssClass="form-control" name="empleado.apePaterno" id="registraEmpleado_empleado_apePaterno" ></s:textfield>
				    		<label class="label-control" >Apellido materno</label>
				    		<s:textfield cssClass="form-control" name="empleado.apeMaterno" id="registraEmpleado_empleado_apeMaterno"></s:textfield>
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
										<s:file name="empleado.filImagen" accept="text/txt"></s:file>
									</span>
									<a href="#" class="btn fileupload-exists btn-info" data-dismiss="fileupload">
										<i class="fa fa-fw fa-times"></i> Remover
									</a>
								</div>
							</div>
				    	</div>
			    	</div>
					</div>
			    	<div class="form-group col-md-6" style="padding:0px">
			    		<label class="label-control">Fecha de ingreso</label>
			    		<sj:datepicker id="registraEmpleado_empleado_fechaIngreso" showOn="focus" displayFormat="yy/mm/dd" cssClass="form-control"  name="empleado.fechaIngreso"/>
			    		</div>
			    	<div class="form-group col-md-6">
			    		<label class="label-control" >Numero de celular</label>
			    		<s:textfield cssClass="form-control" name="empleado.celular" id="registraEmpleado_empleado_celular"></s:textfield></div>	    	
		    			    	
			    	<div class="form-group col-md-6" style="padding:0px">
			    		<label class="label-control" >Direccion</label>
			    		<s:textfield cssClass="form-control" name="empleado.direccion" id="registraEmpleado_empleado_direccion"></s:textfield>
			    	</div>  
			    		
			    	<div class="form-group col-md-6">
			    		<label class="label-control" >Rol en el Sistema</label>
						<s:select list="#{'1':'Administrador',
										  '2':'Gerente',
										  '3':'Pastelero'}" 
								  name="usuario.idRol" id="registraEmpleado_usuario_rol" cssClass="form-control"/> 
			    	</div>
			    	<div class="col-lg-11"></div>
			    	<div class="col-lg-10">
			          <div class="heading"><i class="icon-quote-left"></i>Registrar Usuario </div>
			          <div class="widget-content padded">
			            <div class="row">		    	
					    	<div class="form-group col-md-12">
					    		<label class="label-control" >Usuario</label>
					    		<s:textfield cssClass="form-control" name="usuario.username" id="registraEmpleado_usuario_username"></s:textfield>
					    	</div>  		    	
					    	<div class="form-group col-md-12">
					    		<label class="label-control" >Password</label>
					    		<s:textfield cssClass="form-control" name="usuario.password"></s:textfield>
					    	</div>		    	
					    	<div class="form-group col-md-12">
					    		<label class="label-control" >Repita Password</label>
					    		<s:textfield cssClass="form-control" name="repeat_password"></s:textfield>
					    	</div>
                        </div>
			          </div>
			        </div>			    	      
			</div>
			</div>
			<div class="modal-footer">	
		        <s:submit  cssClass="btn btn-primary"  value="Guardar Cambios" button="true" ></s:submit>
			        <button class="btn btn-danger" data-dismiss="modal" aria-label="Close">CANCELAR</button>		
	        </div>  
        </s:form>   
    </div>
  </div>
</div>


