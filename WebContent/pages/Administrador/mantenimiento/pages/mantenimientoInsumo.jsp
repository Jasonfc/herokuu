<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<script type="text/javascript" >
function fotoFormatter(cellvalue,options,row) {
    return "<img src='verImagenInsumo?idCodigo="+row.intCodigo+"' class='img-circle' alt='60x60' style='width: 60px; height: 60px;' >";
}
function buttonFormatter(cellvalue,options,row) {
    return "<div class='btn-group btn-group-xs' role='group' aria-label='Small button group'>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalInsumoID' onclick='llamarModificar();'>Modificar</button>"+
    "<button type='button' class='btn btn-default' data-toggle='modal' data-target='#ModalInsumoID' onclick='llamarVer();'>Ver</button>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalInsumoID' onclick='Eliminar();'>&times;</button></div>";
}
 $.subscribe('rowselectInsumo', function(event,data) {
	var modal = window.document.getElementById('ModalInsumoID');
	 modal.querySelector('[name=idSeleccion]').value= event.originalEvent.id;
	 var grid = event.originalEvent.grid; 
	 var sel_id = grid.jqGrid('getGridParam', 'selrow');

	 modal.querySelector('#registraInsumo_insumo_nombre').value = grid.jqGrid('getCell', sel_id, 'strNombre');
	 modal.querySelector('#registraInsumo_insumo_strFecRegistro').value = grid.jqGrid('getCell', sel_id, 'strFecRegistro');
	 modal.querySelector('#registraInsumo_insumo_strFecVencimiento').value = grid.jqGrid('getCell', sel_id, 'strFecVencimiento');
	 modal.querySelector('#registraInsumo_insumo_InCantidad').value = grid.jqGrid('getCell', sel_id, 'InCantidad');
	 modal.querySelector('#registraInsumo_insumo_strCategoria').value = grid.jqGrid('getCell', sel_id, 'strCategoria');
	 modal.querySelector('img').src = "verImagenInsumo?idCodigo="+event.originalEvent.id
	 
}); 
function llamarIngresar(){
	var modal = window.document.getElementById('ModalInsumoID');
	modal.querySelector('form').action = 'registraInsumo';
	var list = modal.querySelectorAll('input');
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
	
	$(title).text('Registrar Insumo');
	$(footer).show();
	$(body).show();
	$(file).show();
	modal.querySelector('img').src = "http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image";
}
function llamarModificar(){
	var modal = window.document.getElementById('ModalInsumoID');
	modal.querySelector('form').action = 'actualizaInsumo';
	var list = modal.querySelectorAll('input');
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).removeAttr('disabled');}
	$(title).text('Actualizar Insumo');
	$(footer).show();
	$(body).show();
	$(file).show();
}
function llamarVer(){
	var modal = window.document.getElementById('ModalInsumoID');
	var list = modal.querySelectorAll('input');
	footer = modal.getElementsByClassName('modal-footer');
	body = modal.getElementsByClassName('modal-body');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).attr('disabled','disabled')}
	$(title).text('Descripcion Insumo');
	$(footer).hide();
	$(body).show();
	$(file).hide();
}
function Eliminar(){
	var modal = window.document.getElementById('ModalInsumoID');
	modal.querySelector('form').action = 'eliminaInsumo';
	var list = modal.querySelectorAll('input');
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
	$(title).text('Desea eliminar el Insumo?');
	$(footer).show();
	$(body).hide();
	$(file).hide();
}
</script>
<div class="page-title">
  <h1>Mantenimiento de Insumos</h1>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="widget-container fluid-height clearfix">
			<div class="heading"><i class="icon-adjust"></i>Listado de Insumos</div>
        	<div class="widget-content padded">
          		<div class="col-lg-1"></div>          
          		<div class="col-lg-11">	          		
	           		<s:actionerror value="mensaje" cssClass="alert alert-danger alert-dismissable"/>
		     		<s:actionmessage value="mensaje" cssClass="alert alert-success alert-dismissable"/>
          			Agregar Insumos : &nbsp;<button type='button' class='btn btn-primary'  data-toggle="modal" data-target="#ModalInsumoID" onclick='llamarIngresar();'>&nbsp;+&nbsp;</button>
					<s:url id="jsonDataListaInsumos" action="manteListaInsumoGrid" />
					<sjg:grid id="idGridExtraccionEquipos"
						 href="%{jsonDataListaInsumos}"  
						 caption="Lista de Insumos" 
						 dataType="json" 
						 pager="true" 
						 gridModel="lstInsumo" 
						 multiselect="false" 
						 navigator="true"
						 navigatorAdd="false"    
						 navigatorSearch="false" 
						 navigatorRefresh="false" 
						 onSelectRowTopics="rowselectInsumo"
						 navigatorDelete="false"
						 navigatorEdit="false"
						 rowNum="8"
						 scroll="false"
						 width="980" >
						<sjg:gridColumn  name="name" index="name" title="" sortable="true" align="center" formatter="fotoFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						<sjg:gridColumn name="strNombre"  index="strNombre" editable="true" title="Nombre" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="strFecRegistro"  index="strFecRegistro" editable="true" title="Fecha Registro" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="strFecVencimiento"  index="strFecVencimiento" editable="true" title="Fecha Vencimiento" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="InCantidad"  index="InCantidad" editable="true" title="Cantidad" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="strCategoria"  index="strCategoria" editable="true" title="Categoria" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="name" index="name" title="" sortable="true" align="center" formatter="buttonFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						
					</sjg:grid>	
          		</div>
          	</div>	
		</div>
	</div>
</div>