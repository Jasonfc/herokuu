<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="content-wrapper">
      <div id="content" class="container clearfix">
        <div id="breadcrumb" class="row breadcrumb">
          <div class="col-md-24" itemprop="breadcrumb">
            <a href="a_index_cliente" class="homepage-link" title="Back to the frontpage">Home</a>
            <i class="angle-right">/</i>
            <span class="page-title">Account</span>
          </div>
        </div>

        <section class="row content">
          <div id="col-main" class="col-md-24 register-page clearfix">
            <h1 id="page-title" class="large">Register</h1>
            <form method="post" action="registraCliente" id="create_cliente" accept-charset="UTF-8" >
              <input name="form_type" type="hidden" value="create_cliente" /><input name="utf8" type="hidden" value="✓" />
              <ul id="register-form" class="row list-unstyled">              
                <li class="clearfix"></li>
                <li id="dni" class="col-md-6">
                  <label class="control-label" for="dni">Numero de DNI <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.dni" id="dni" maxlength="8" />			    		
                </li>
                <li class="clearfix"></li>
                <li id="name" class="col-md-12">
                  <label class="control-label" for="name">Nombre <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.nombre" id="name" />	
                </li>
                <li class="clearfix"></li>            
                <li id="father_name" class="col-md-6">
                  <label class="control-label" for="father_name">Apellido Paterno <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.apePaterno" id="father_name" />	
                </li>                  
                <li id="mother_name" class="col-md-6">
                  <label class="control-label" for="mother_name">Apellido Materno <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.apeMaterno" id="mother_name" />	
                </li>
                <li class="clearfix"></li>
                <li id="email" class="col-md-6">
                  <label class="control-label" for="email">Email <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.correo" id="email" />	
                </li>
                <li id="phone" class="col-md-6">
                  <label class="control-label" for="phone">Celular <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="cliente.celular" id="phone" />	
                </li>
                <li class="clearfix"></li>
                <li id="username" class="col-md-12">
                  <label class="control-label" for="username">Usuario <span class="req">*</span></label>
                  <s:textfield cssClass="form-control" name="usuario.username" id="username" />	
                </li>
                <li class="clearfix"></li>
                <li id="password" class="col-md-12">
                  <label class="control-label" for="password">Password <span class="req">*</span></label>
                  <s:password cssClass="form-control password" name="usuario.password" id="password" />	
                </li>
                <li class="clearfix"></li>
                <li class="col-md-12 unpadding-top">
		        <s:submit  cssClass="btn"  value="Crear cuenta"/>
                </li>
              </ul>
              <s:hidden name="usuario.idRol" value="4" />	
            </form>
          </div>
        </section>
      </div>
    </div>