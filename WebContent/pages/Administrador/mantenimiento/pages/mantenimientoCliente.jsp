<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<script type="text/javascript" >
function fotoFormatter(cellvalue,options,row) {
    return "<img src='verImagenCliente?idCodigo="+row.idCliente+"' class='img-circle' alt='60x60' style='width: 60px; height: 60px;' >";
}
function buttonFormatter(cellvalue,options,row) {
    return "<div class='btn-group btn-group-xs' role='group' aria-label='Small button group'>"+
    "<button type='button' class='btn btn-default' data-toggle='modal' data-target='#ModalClienteID' onclick='llamarVer();'>Ver</button>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalClienteID' onclick='Eliminar();'>&times;</button></div>";
}
 $.subscribe('rowselectCliente', function(event,data) {
	 alert("ENTRO AQUI!!!!!");
	var modal = window.document.getElementById('ModalClienteID');
	 modal.querySelector('[name=idSeleccion]').value= event.originalEvent.id;
	 var grid = event.originalEvent.grid; 
	 var sel_id = grid.jqGrid('getGridParam', 'selrow');
	 
	 modal.querySelector('#registraCliente_cliente_dni').value = grid.jqGrid('getCell', sel_id, 'dni');
	 modal.querySelector('#registraCliente_cliente_nombre').value = grid.jqGrid('getCell', sel_id, 'nombre');
	 modal.querySelector('#registraCliente_cliente_apePaterno').value = grid.jqGrid('getCell', sel_id, 'apePaterno');
	 modal.querySelector('#registraCliente_cliente_apeMaterno').value = grid.jqGrid('getCell', sel_id, 'apeMaterno');
	 modal.querySelector('#registraCliente_cliente_fechaIngreso').value = grid.jqGrid('getCell', sel_id, 'fechaNacimiento');
	 modal.querySelector('#registraCliente_cliente_celular').value = grid.jqGrid('getCell', sel_id, 'celular');
	 modal.querySelector('#registraCliente_cliente_direccion').value = grid.jqGrid('getCell', sel_id, 'direccion');
	 modal.querySelector('#registraCliente_cliente_username').value = grid.jqGrid('getCell', sel_id, 'usuario.username');
	 modal.querySelector('img').src = "verImagenCliente?idCodigo="+event.originalEvent.id
	 
}); 
function llamarVer(){
	var modal = window.document.getElementById('ModalClienteID');
	var list = modal.querySelectorAll('input');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).attr('disabled','disabled')}
	$(title).text('Descripcion Empleado');
	$(footer).hide();
	$(file).hide();
}
function Eliminar(){
	var modal = window.document.getElementById('ModalClienteID');
	modal.querySelector('form').action = 'eliminaCliente';
	var list = modal.querySelectorAll('input');
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){
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
  <h1>Mantenimiento de Cliente</h1>
</div>
<div class="row">
<div class="col-lg-12">
	<div class="widget-container fluid-height clearfix">
        <div class="heading"><i class="icon-adjust"></i>Lista de Clientes </div>
        <div class="widget-content padded">
          <div class="col-lg-1"></div>          
          <div class="col-lg-11">          
           	<s:actionerror value="mensaje" cssClass="alert alert-danger alert-dismissable"/>
	     	<s:actionmessage value="mensaje" cssClass="alert alert-success alert-dismissable"/>
			<s:url id="jsonDataListaCliente" action="manteListaClienteGrid" />
			<sjg:grid id="idGridExtraccionEquipos"
				 href="%{jsonDataListaCliente}"  
				 caption="Lista de Cliente" 
				 dataType="json" 
				 pager="true" 
				 gridModel="lstCliente" 
				 multiselect="false" 
				 navigator="true"
				 navigatorAdd="false"    
				 navigatorSearch="false" 
				 navigatorRefresh="false" 
				 onSelectRowTopics="rowselectCliente"
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
			<sjg:gridColumn name="fechaNacimiento"  index="fechaIngreso" editable="true" title="Fecha Ingreso" width="70" sortable="false" cssStyle="text-align: center"/>
			<sjg:gridColumn name="direccion"  index="direccion" editable="true" title="Direccion" width="70" sortable="false" cssStyle="text-align: center"/>
			<sjg:gridColumn name="usuario.username" editable="true" title="Usuario" width="70" sortable="false" cssStyle="text-align: center"/>
			<sjg:gridColumn name="name" index="name" title="" sortable="true" align="center" formatter="buttonFormatter"search="true" searchoptions="{sopt:['cn']}"/>
			
			</sjg:grid>	
          </div>
        </div>
      </div>	
</div>
</div>