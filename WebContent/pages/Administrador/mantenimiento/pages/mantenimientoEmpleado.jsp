<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<head>

</head>

<script type="text/javascript" >
function fotoFormatter(cellvalue,options,row) {
    return "<img src='verImagenEmpleado?idCodigo="+row.idEmpleado+"' class='img-circle' alt='60x60' style='width: 60px; height: 60px;' >";
}
function buttonFormatter(cellvalue,options,row) {
    return "<div class='btn-group btn-group-xs' role='group' aria-label='Small button group'>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalEmpleadoID' onclick='llamarModificar();'>Modificar</button>"+
    "<button type='button' class='btn btn-default' data-toggle='modal' data-target='#ModalEmpleadoID' onclick='llamarVer();'>Ver</button>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalEmpleadoID' onclick='Eliminar();'>&times;</button></div>";
}
$.subscribe('rowselectEmpleado', function(event,data) {
	 var modal = window.document.getElementById('ModalEmpleadoID');
	 modal.querySelector('[name=idSeleccion]').value= event.originalEvent.id;
	 var grid = event.originalEvent.grid; 
	 var sel_id = grid.jqGrid('getGridParam', 'selrow');
	 
	 modal.querySelector('#registraEmpleado_empleado_dni').value = grid.jqGrid('getCell', sel_id, 'dni');
	 modal.querySelector('#registraEmpleado_empleado_nombre').value = grid.jqGrid('getCell', sel_id, 'nombre');
	 modal.querySelector('#registraEmpleado_empleado_apePaterno').value = grid.jqGrid('getCell', sel_id, 'apePaterno');
	 modal.querySelector('#registraEmpleado_empleado_apeMaterno').value = grid.jqGrid('getCell', sel_id, 'apeMaterno');
	 modal.querySelector('#registraEmpleado_empleado_fechaIngreso').value = grid.jqGrid('getCell', sel_id, 'fechaIngreso');
	 modal.querySelector('#registraEmpleado_empleado_celular').value = grid.jqGrid('getCell', sel_id, 'celular');
	 modal.querySelector('#registraEmpleado_empleado_direccion').value = grid.jqGrid('getCell', sel_id, 'direccion');
	 modal.querySelector('#registraEmpleado_usuario_username').value = grid.jqGrid('getCell', sel_id, 'usuario.username');
	 modal.querySelector('#registraEmpleado_usuario_rol').value = grid.jqGrid('getCell', sel_id, 'usuario.rol.idRol');	 
	 modal.querySelector('img').src = "verImagenEmpleado?idCodigo="+event.originalEvent.id
	 
}); 
function llamarIngresar(){
	var modal = window.document.getElementById('ModalEmpleadoID');
	modal.querySelector('form').action = 'registraEmpleado';
	var list = modal.querySelector("form").elements;
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){
		$(list[i]).removeAttr('disabled');
		if (list[i].type != 'submit'){
			$(list[i]).attr('value','');			
		}
	}
	
	$(title).text('Registrar Empleado');
	$(footer).show();
	$(body).show();
	$(file).show();
	modal.querySelector('img').src = "http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image";
}
function llamarModificar(){
	var modal = window.document.getElementById('ModalEmpleadoID');
	modal.querySelector('form').action = 'actualizaEmpleado';
	var list =modal.querySelector("form").elements;
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).removeAttr('disabled');}
	$(title).text('Actualizar Empleado');
	$(footer).show();
	$(body).show();
	$(file).show();
}
function llamarVer(){
	var modal = window.document.getElementById('ModalEmpleadoID');
	var list = modal.querySelector("form").elements;
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).attr('disabled','disabled')}
	$(title).text('Descripcion Empleado');
	$(footer).hide();
	$(body).show();
	$(file).hide();
}
function Eliminar(){
	var modal = window.document.getElementById('ModalEmpleadoID');
	modal.querySelector('form').action = 'eliminaEmpleado';
	var list = modal.querySelector("form").elements;
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){
		$(list[i]).removeAttr('disabled');
		if ($(list[i]).attr('type') != 'submit'){
			$(list[i]).attr('value','');			
		}
		}
	$(title).text('Desea eliminar el empleado?');
	$(footer).show();
	$(body).hide();
	$(file).hide();
}
</script>
<div class="page-title">
  <h1>Mantenimiento de Empleados</h1>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="widget-container fluid-height clearfix">
			<div class="heading"><i class="icon-adjust"></i>Listado de Empleado </div>
        	<div class="widget-content padded">
          		<div class="col-lg-1"></div>          
          		<div class="col-lg-11">	          		
	           		<s:actionerror value="mensaje" cssClass="alert alert-danger alert-dismissable"/>
		     		<s:actionmessage value="mensaje" cssClass="alert alert-success alert-dismissable"/>
        			Agregar Empleado : &nbsp;<button type='button' class='btn btn-primary'  data-toggle="modal" data-target="#ModalEmpleadoID" onclick='llamarIngresar();'>&nbsp;+&nbsp;</button>
					<s:url id="jsonDataListaEmpleado" action="manteListaEmpleadoGrid" />
					<sjg:grid id="idGridExtraccionEquipos"
						 href="%{jsonDataListaEmpleado}"  
						 caption="Lista de Empleados" 
						 dataType="json" 
						 pager="true" 
						 gridModel="lstEmpleado" 
						 multiselect="false" 
						 navigator="true"
						 navigatorAdd="false"    
						 navigatorSearch="false" 
						 navigatorRefresh="false" 
						 onSelectRowTopics="rowselectEmpleado"
						 navigatorDelete="false"
						 navigatorEdit="false"
						 rowNum="8"
						 scroll="false"
						 width="980" >
						<sjg:gridColumn  name="name" index="name" title="" sortable="true" align="center" formatter="fotoFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						<sjg:gridColumn name="nombre"  index="nombre" editable="true" title="Nombre" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="apePaterno"  index="apePaterno" editable="true" title="apePaterno" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="apeMaterno"  index="apeMaterno" editable="true" title="apeMaterno" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="dni"  index="dni" editable="true" title="DNI" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="celular"  index="celular" editable="true" title="Celular" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="fechaIngreso"  index="fechaIngreso" editable="true" title="Fecha Ingreso" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="direccion"  index="direccion" editable="true" title="Direccion" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="usuario.username" editable="true" title="Usuario" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="usuario.rol.idRol" editable="true" title="Rol" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="usuario.rol.descripcion" editable="true" title="Rol" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="name" index="name" title="" sortable="true" align="center" formatter="buttonFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						
					</sjg:grid>	
		  		
          		</div>
          	</div>	
		</div>
	</div>
</div>