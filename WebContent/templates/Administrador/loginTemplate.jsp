<?xml version="1.0" encoding="utf-8"?>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<title><s:text  name="global.titulo" /></title>
<link href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/bootstrap.min.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/fontawesome.css" media="all" rel="stylesheet"/>
<link href="Administrador/stylesheets/style.css" media="all" rel="stylesheet"/>
<meta content="width=device-width, initial-scale=1.0" charset="utf-8" name="viewport"/>
</head>
<body>
<div class="container-fluid">
  <div class="login">
	<tiles:insertAttribute	name="central" />  
  </div>
</div>	
<script type="text/javascript">

		$(document).ready( function() {
			$.subscribe('removeErrors', function(event,data) {
				$('.errorLabel').html('').removeClass('errorLabel');
				$('#formerrors').html('');
			});
		});	
		
		function customeValidation(form, errors) {
			
			//List for errors
			var list = $('#formerrors');
			
			//Handle non field errors 
			if (errors.errors) {
				$.each(errors.errors, function(index, value) { 
					list.append(''+value+'\n');
				});
			}
			
			//Handle field errors 
			if (errors.fieldErrors) {
				$.each(errors.fieldErrors, function(index, value) { 
					index = index.charAt(0).toUpperCase() + index.slice(1);
					var elem = $('#'+index+'Error');
					if(elem)
					{
						elem.html(index+": "+value[0]);
						elem.parent().addClass('has-error');
					}
				});
			}
		}
	  
</script>
<script src="Administrador/javascripts/modernizr.custom.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="Administrador/javascripts/bootstrap.min.js"></script>
</body>
</html>