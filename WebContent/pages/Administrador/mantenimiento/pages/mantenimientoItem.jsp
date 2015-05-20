<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript" >
function fotoFormatter(cellvalue,options,row) {
    return "<img src='verImagenItem?idCodigo="+row.idItem+"' class='img-circle' alt='60x60' style='width: 60px; height: 60px;' >";
}
function buttonFormatter(cellvalue,options,row) {
    return "<div class='btn-group btn-group-xs' role='group' aria-label='Small button group'>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalItemID' onclick='llamarModificar();'>Modificar</button>"+
    "<button type='button' class='btn btn-default' data-toggle='modal' data-target='#ModalItemID' onclick='llamarVer();'>Ver</button>"+
    "<button type='button' class='btn btn-default'  data-toggle='modal' data-target='#ModalItemID' onclick='Eliminar();'>&times;</button></div>";
}
 $.subscribe('rowselectItem', function(event,data) {
	var modal = window.document.getElementById('ModalItemID');
	 modal.querySelector('[name=idSeleccion]').value= event.originalEvent.id;
	 var grid = event.originalEvent.grid; 
	 var sel_id = grid.jqGrid('getGridParam', 'selrow');

	 modal.querySelector('#registraItem_item_nombreItem').value = grid.jqGrid('getCell', sel_id, 'dni');
	 modal.querySelector('#registraItem_item_descripcionItem').value = grid.jqGrid('getCell', sel_id, 'nombre');
	 modal.querySelector('#registraItem_item_fechaIngreso').value = grid.jqGrid('getCell', sel_id, 'apePaterno');
	 modal.querySelector('#registraItem_item_stock').value = grid.jqGrid('getCell', sel_id, 'apeMaterno');
	 modal.querySelector('img').src = "verImagenItem?idCodigo="+event.originalEvent.id
	 
}); 
function llamarIngresar(){
	var modal = window.document.getElementById('ModalItemID');
	modal.querySelector('form').action = 'registraItem';
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
	
	$(title).text('Registrar Item');
	$(footer).show();
	$(file).show();
	$(body).show();
	modal.querySelector('img').src = "http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image";
}
function llamarModificar(){
	var modal = window.document.getElementById('ModalItemID');
	modal.querySelector('form').action = 'actualizaItem';
	var list = modal.querySelectorAll('input');
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
	var modal = window.document.getElementById('ModalItemID');
	var list = modal.querySelectorAll('input');
	body = modal.getElementsByClassName('modal-body');
	footer = modal.getElementsByClassName('modal-footer');
	title = modal.getElementsByClassName('modal-title')[0];
	file = modal.getElementsByClassName('btn-file');
	var i;
	for(i=0; i< list.length; i++){$(list[i]).attr('disabled','disabled')}
	$(title).text('Descripcion Item');
	$(footer).hide();
	$(body).show();
	$(file).hide();
}
function Eliminar(){
	var modal = window.document.getElementById('ModalItemID');
	modal.querySelector('form').action = 'eliminaItem';
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
	$(title).text('Desea eliminar el item?');
	$(footer).show();
	$(body).hide();
	$(file).hide();
}
</script>
<div class="page-title">
  <h1>Mantenimiento de Items</h1>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="widget-container fluid-height clearfix">
			<div class="heading"><i class="icon-adjust"></i>Listado de Insumos </div>
        	<div class="widget-content padded">
          		<div class="col-lg-1"></div>          
          		<div class="col-lg-11">	          		
	           		<s:actionerror value="mensaje" cssClass="alert alert-danger alert-dismissable"/>
		     		<s:actionmessage value="mensaje" cssClass="alert alert-success alert-dismissable"/>
        			Agregar Item : &nbsp;<button type='button' class='btn btn-primary'  data-toggle="modal" data-target="#ModalItemID" onclick='llamarIngresar();'>&nbsp;+&nbsp;</button>
					<s:url id="jsonDataListaItem" action="manteListaItemGrid" />
					<sjg:grid id="idGridExtraccionEquipos"
						 href="%{jsonDataListaItem}"  
						 caption="Lista de Items" 
						 dataType="json" 
						 pager="true" 
						 gridModel="lstItem" 
						 multiselect="false" 
						 navigator="true"
						 navigatorAdd="false"    
						 navigatorSearch="false" 
						 navigatorRefresh="false" 
						 onSelectRowTopics="rowselectItem"
						 navigatorDelete="false"
						 navigatorEdit="false"
						 rowNum="8"
						 scroll="false"
						 width="980" >
						<sjg:gridColumn  name="name" index="name" title="" sortable="true" align="center" formatter="fotoFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						<sjg:gridColumn name="nombreItem"  index="nombreItem" editable="true" title="Nombre Item" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="descripcionItem"  index="descripcionItem" editable="true" title="Descripcion Item" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="fechaIngreso"  index="fechaIngreso" editable="true" title="Fecha Registro" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="stock"  index="stock" editable="true" title="Stock" width="70" sortable="false" cssStyle="text-align: center"/>
						<sjg:gridColumn name="name" index="name" title="" sortable="true" align="center" formatter="buttonFormatter"search="true" searchoptions="{sopt:['cn']}"/>
						
					</sjg:grid>	
		  		
          		</div>
          	</div>	
		</div>
	</div>
</div>