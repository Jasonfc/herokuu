<?xml version="1.0" encoding="utf-8"?>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<sj:head locale="es" jqueryui="true" jquerytheme="pepper-grinder"/>
<title><s:text  name="global.titulo" /></title>	
<!-- MODIFICAR ESTO -->
<link href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/application.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/isotope.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/normalize.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/fullcalendar.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/datatables.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/prettify.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/classyscroll.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/jquery.fancybox.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/select2.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/bootstrap.min.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/fontawesome.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/style.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/color/green.css" media="all" rel="alternate stylesheet" title="green-theme"/>
<link href="Administrador/stylesheets/color/orange.css" media="all" rel="alternate stylesheet" title="orange-theme"/>
<link href="Administrador/stylesheets/color/magenta.css" media="all" rel="alternate stylesheet" title="magenta-theme"/>
<link href="Administrador/stylesheets/color/gray.css" media="all" rel="alternate stylesheet" title="gray-theme"/>
<link href="Administrador/stylesheets/bootstrap-fileupload.min.css" rel="stylesheet" type="text/css" />
<!-- MODIFICAR ESTO -->

<meta http-equiv="Content-Type" content="text/html"; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid" />
<meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin" />

<script type="text/javascript">
var x=window.history.length; 
if (window.history[x]!=window.location) 
{ 
    window.history.forward(); 
} 
</script>	
</head>
<body>
<div class="navbar navbar-fixed-top">
	<div class="container-fluid top-bar">
		<tiles:insertAttribute	name="cabecera" />		
	</div>
	<div class="container-fluid main-nav clearfix">
		<tiles:insertAttribute name="menu" />	
	</div>
</div>
<div class="container-fluid">
	<tiles:insertAttribute name="central" />
	<tiles:insertAttribute name="modal" />	
</div>

<!-- MODIFICAR ESTO -->
<script src="Administrador/javascripts/modernizr.custom.js"></script>
<script src="Administrador/javascripts/bootstrap.min.js"></script>
<script src="Administrador/javascripts/fullcalendar.min.js"></script>
<script src="Administrador/javascripts/gcal.js"></script>
<script src="Administrador/javascripts/prettify.js"></script>
<script src="Administrador/javascripts/excanvas.min.js"></script>
<script src="Administrador/javascripts/select2.js"></script>
<script src="Administrador/javascripts/styleswitcher.js"></script>
<script src="Administrador/javascripts/main.js"></script>
<script src="Administrador/javascripts/bootstrap-fileupload.min.js"></script>
<!-- MODIFICAR ESTO -->
</body>
</html>

