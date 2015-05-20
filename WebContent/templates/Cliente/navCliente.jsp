
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<head>
<sj:head locale="es" jqueryui="true" />
</head>
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
<div id="top-other">
        <div class="container">
          <div class="row">
            <div class="col-md-16 text-left">
              <ul id="messages" class="list-inline">
                <li>
                  <a href="./collection.html">Buscar Torta </a>
                </li>
                <li>
                  <form id="header-search" class="search-form" action="./index.html" method="get" />
                  <button type="submit" class="search-submit" title="Search">
                    <i class="fa fa-search"></i>
                  </button>
                  <input type="text" class="input-block-level" name="q" value="" accesskey="4" autocomplete="off" placeholder="" />
                </form>
              </li>
            </ul>
            </div>
            <div class="col-md-8 text-right hidden-xs">
              <ul id="accounts" class="list-inline">
                <li class="welcome">
                  Bienvenidos
                </li>
                <s:if test="%{#session.objCli ==null}">                              
                <li class="login">
                  <span id="loginButton" class="dropdown-toggle" data-toggle="dropdown">
                    Iniciar Sesion
                    <i class="sub-dropdown1"></i>
                    <i class="sub-dropdown"></i>
                  </span>
                  <div id="loginBox" class="dropdown-menu text-left">
                    <s:form method="post" action="login" id="customer_login" accept-charset="UTF-8" >
 						<s:hidden name="is_customer" value="true"/>
                    	<input name="form_type" type="hidden" value="customer_login" />
                    	<input name="utf8" type="hidden" value="✓" />
                      <div id="bodyBox">
                        <ul class="control-container customer-accounts list-unstyled">
                          <li class="clearfix">
                            <label for="customer_email_box" class="control-label" id="UsernameError">Username <span class="req">*</span></label>
         					<s:textfield name="username" cssClass="form-control" placeholder="User ID"  />
                          </li>
                          <li class="clearfix">
                            <label for="customer_password_box" class="control-label" id="PasswordError">Contraseña <span class="req">*</span></label>
                  			<s:password cssClass="form-control password" name="password" id="password" />	
                          </li>
                          <li class="clearfix last1">
		        			<sj:submit cssClass="btn"
								   validateFunction="customeValidation" onBeforeTopics="removeErrors" 
								   onSuccessTopics="removeErrors" indicator="indicator"  validate="true" 
			     					value="Ingresar"/>
                          </li>
                        </ul>
                      </div>
                    </s:form>
                  </div>
                </li>
                <li>o</li>
                <li class="register">
                  <a href="a_register" id="customer_register_link">Crear una Cuenta</a>
                </li>                
                </s:if>
				<s:else>
				    <li class="bienvenido">
				    	<s:property value="#session.objCli.username"/>
				    </li>
					<li>/</li>
				    <li class="logout">
				    	<a href="${pageContext.request.contextPath}/logoutCliente">Salir</a>
				    </li>
				</s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>