<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript" >
function fotoFormatter(cellvalue,options,row) {
    return "<img src='verImagenTorta?idCodigo="+row.idTorta+"' class='img-circle' alt='60x60' style='width: 60px; height: 60px;' >";
}
function buttonFormatter(cellvalue,options,row) {
    return "<div class='btn-group btn-group-xs' role='group' aria-label='Small button group'>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalTortaID' onclick='llamarModificar();'>Modificar</button>"+
    "<button type='button' class='btn btn-default' data-toggle='modal' data-target='#ModalTortaID' onclick='llamarVer();'>Ver</button>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalTortaID' onclick='Eliminar();'>&times;</button></div>";
}
 $.subscribe('rowselectTorta', function(event,data) {
	var modal = window.document.getElementById('ModalTortaID');
	 modal.querySelector('[name=idSeleccion]').value= event.originalEvent.id;
	 var grid = event.originalEvent.grid; 
	 var sel_id = grid.jqGrid('getGridParam', 'selrow');
	 
	 modal.querySelector('#registraTorta_torta_nombre').value = grid.jqGrid('getCell', sel_id, 'nombre');
	 modal.querySelector('#registraTorta_torta_stock').value = grid.jqGrid('getCell', sel_id, 'stock');
	 modal.querySelector('#registraTorta_torta_fechaRegistro').value = grid.jqGrid('getCell', sel_id, 'fechaRegistro');
	 modal.querySelector('#registraTorta_torta_precio').value = grid.jqGrid('getCell', sel_id, 'precio');
	 modal.querySelector('#registraTorta_torta_descripcion').value = grid.jqGrid('getCell', sel_id, 'descripcion');
	 modal.querySelector('#registraTorta_torta_cantPersonas').value = grid.jqGrid('getCell', sel_id, 'cantPersonas');
	 modal.querySelector('#registraTorta_torta_cantPisos').value = grid.jqGrid('getCell', sel_id, 'cantPisos');
	 modal.querySelector('img').src = "verImagenTorta?idCodigo="+event.originalEvent.id
	 
}); 
 function llamarIngresar(){
		var modal = window.document.getElementById('ModalTortaID');
		modal.querySelector('form').action = 'registraTorta';
		var list = modal.querySelectorAll('input');
		footer = modal.getElementsByClassName('modal-footer');
		body = modal.getElementsByClassName('modal-body');
		title = modal.getElementsByClassName('modal-title')[0];
		file = modal.getElementsByClassName('btn-file');
		var i;
		for(i=0; i< list.length; i++){
			$(list[i]).removeAttr('disabled');
			if ($(list[i]).attr('type') != 'submit'){
				$(list[i]).attr('value','');			
			}
		}
		
		$(title).text('Registrar Torta');
		$(footer).show();
		$(body).show();
		$(file).show();
		modal.querySelector('img').src = "http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image";
	}
 function llamarModificar(){
		var modal = window.document.getElementById('ModalTortaID');
		modal.querySelector('form').action = 'actualizaTorta';
		var list = modal.querySelector("form").elements;
		footer = modal.getElementsByClassName('modal-footer');
		body = modal.getElementsByClassName('modal-body');
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
	var modal = window.document.getElementById('ModalTortaID');
	var list =modal.querySelector("form").elements;
	footer = modal.getElementsByClassName('modal-footer');
	body = modal.getElementsByClassName('modal-body');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).attr('disabled','disabled')}
	$(title).text('Descripcion Torta');
	$(footer).hide();
	$(body).show();
	$(file).hide();
}
function Eliminar(){
	var modal = window.document.getElementById('ModalTortaID');
	modal.querySelector('form').action = 'eliminaTorta';
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
	$(title).text('Desea eliminar la torta?');
	$(footer).show();
	$(body).hide();
	$(file).hide();
}
</script>
<div class="page-title">
  <h1>Mantenimiento de Tortas</h1>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="widget-container fluid-height clearfix">
			<div class="heading"><i class="icon-adjust"></i>Listado de Tortas </div>
        	<div class="widget-content padded">
          		<div class="col-lg-1"></div>          
          		<div class="col-lg-11">	          		
	           		<s:actionerror value="mensaje" cssClass="alert alert-danger alert-dismissable"/>
		     		<s:actionmessage value="mensaje" cssClass="alert alert-success alert-dismissable"/>
          			Agregar Torta : &nbsp;<button type='button' class='btn btn-primary'  data-toggle="modal" data-target="#ModalTortaID" onclick='llamarIngresar();'>&nbsp;+&nbsp;</button>
					<s:url id="jsonDataListaTorta" action="manteListaTortaGrid" />
					<sjg:grid id="idGridExtraccionEquipos"
						 href="%{jsonDataListaTorta}"  
						 caption="Lista de Tortas" 
						 dataType="json" 
						 pager="true" 
						 gridModel="lstTorta" 
						 multiselect="false" 
						 navigator="true"
						 navigatorAdd="false"    
						 navigatorSearch="false" 
						 navigatorRefresh="false" 
						 onSelectRowTopics="rowselectTorta"
						 navigatorDelete="false"
						 navigatorEdit="false"
						 rowNum="8"
						 scroll="false"
						 width="980" >
						<sjg:gridColumn  name="name" index="name" title="" sortable="true" align="center" formatter="fotoFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						<sjg:gridColumn name="nombre"  index="nombre" editable="true" title="Nombre" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="descripcion"  index="descripcion" editable="true" title="Descripcion" width="90" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="precio"  index="precio" editable="true" title="Precio" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="stock"  index="stock" editable="true" title="Stock" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="fechaRegistro"  index="fechaRegistro" editable="true" title="Fecha de Registro" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="cantPersonas"  index="cantPersonas" editable="true" title="Cant. Personas" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="cantPisos"  index="cantPisos" editable="true" title="Cant. Pisos" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="name" index="name" title="" sortable="true" align="center" formatter="buttonFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						
					</sjg:grid>	
          		</div>
          	</div>	
		</div>
	</div>
</div>