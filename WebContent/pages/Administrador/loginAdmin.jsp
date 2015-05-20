<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<head>
<sj:head locale="es" jqueryui="true" />
</head>
<div class="login-container">
	<img alt="Logo login@2x" height="30" src="Administrador/images/logo-login_2x.png" width="100"/>
    <s:form   id="validationForm"  action="login" method="POST">
      <div class="form-group">
        <div class="input-group">
        	<span class="input-group-addon">
        		<i class="icon-envelope"></i>
        	</span>
          <s:textfield name="username" cssClass="form-control" placeholder="User ID" value="hetaki" />
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
        	<span class="input-group-addon">
        		<i class="icon-lock"></i>
        	</span>
          <s:password name="password" cssClass="form-control" />	  
        </div>
      </div>       
      <sj:submit cssClass="btn btn-lg btn-primary login-submit"
			   validateFunction="customeValidation" onBeforeTopics="removeErrors" 
			   onSuccessTopics="removeErrors" indicator="indicator"  validate="true" 
   					value="Ingresar al Sistema"/>		
   	  <div class="widget-content padded">
   	  	<s:actionerror value="mensaje" cssClass="alert alert-danger" />
   		<s:actionmessage value="mensaje" cssClass="alert alert-success"/>
   	  </div>   	
    </s:form>
    <a href="#">Forgot password?</a>
</div>


