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
          <div id="col-main" class="col-md-24 login-page clearfix">
            <h1 id="page-title">Pasteleria Encantada</h1>
            <div class="row">
              <div class="col-md-12 row-left">
                <div id="customer-login">
                  <div class="wrapper-title">
                    <span class="title-3">Acceso al cliente</span>
                    <span class="line"></span>
                  </div>
                  <form method="post" action="./login.html" id="customer_login" accept-charset="UTF-8" >
                  <input name="form_type" type="hidden" value="customer_login" />
                  <input type="hidden" name="checkout_url" value="✓" />
                  <input type="hidden" name="cart" value="a67e6d1afd4788546f08d0aa6d8b8bad" />
                  <input name="utf8" type="hidden" value="✓" />
                    <ul id="login-form" class="list-unstyled">
                      <li class="clearfix"></li>
                      <li id="login_email" class="col-md-24">
                        <label class="control-label" for="customer_email">Email <span class="req">*</span></label>
                        <input type="email" value="" name="customer[email]" id="customer_email" class="form-control" />
                      </li>
                      <li class="clearfix"></li>
                      <li id="login_password" class="col-md-24">
                        <label class="control-label" for="customer_password">Contraseña <span class="req">*</span></label>
                        <input type="password" value="" name="customer[password]" id="customer_password" class="form-control password" />
                      </li>
                      <li class="col-md-24 unpadding-top">
                        <ul class="login-wrapper list-inline">
                          <li>
                            <button class="btn" type="submit">Logeo</button>
                          </li>
                          <li>
                            <a class="action" href="javascript:" onclick="showRecoverPasswordForm()">Olvidaste tu contraseña?</a>
                            or
                            <a class="return" href="a_index_cliente">Vuelve a la tienda</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </form>
                </div>
                <div id="recover-password" style="display:none">
                  <div class="wrapper-title">
                    <span class="title-3">Restablecer contaseña</span>
                    <span class="line"></span>
                  </div>
                  <p class="note">Le enviaremos un correo electrónico para restablecer su contraseña.</p>
                  <form method="post" action="./login.html" accept-charset="UTF-8" >
                    <input name="form_type" type="hidden" value="recover_customer_password" />
                    <input type="hidden" name="checkout_url" value="" />
                    <input name="utf8" type="hidden" value="✓" />
                    <ul id="recover-form" class="list-unstyled">
                      <li class="clearfix"></li>
                      <li id="recover_email" class="col-md-24">
                        <label class="control-label" for="email">Email <span class="req">*</span></label>
                        <input type="email" value="" name="email" id="recover-email" class="form-control" />
                      </li>
                      <li class="col-md-24 unpadding-top">
                        <ul class="login-wrapper list-inline">
                          <li>
                            <button class="btn" type="submit">Enviar</button>
                          </li>
                          <li>
                            <a class="action" href="javascript:" onclick="hideRecoverPasswordForm()">Vuelve a iniciar sesion?</a>
                            or
                            <a class="return" href="a_index_cliente">Vuelva a la tienda</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </form>
                </div>
              </div>
              <div class="col-md-12 row-right">
                <div id="guest">
                  <div class="wrapper-title">
                    <span class="title-3">Ingresar como invitados</span>
                    <span class="line"></span>
                  </div>
                  <p class="note">Continuar como invitado. No se requiere inscripción.</p>
                  <form method="post" action="./login.html" id="customer_login_guest" accept-charset="UTF-8" >
                    <input name="form_type" type="hidden" value="guest_login" />
                    <input type="hidden" name="guest" value="true" />
                    <input type="hidden" name="checkout_url" value="" />
                    <input type="hidden" name="cart" value="a67e6d1afd4788546f08d0aa6d8b8bad" />
                    <input name="utf8" type="hidden" value="✓" />
                    <div class="col-md-24 guest">
                      <button class="btn btn-1" type="submit">Continuar como invitado</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <script type="text/javascript">
            if(window.location.hash=="#recover"){showRecoverPasswordForm()}function showRecoverPasswordForm(){$("#recover-password").fadeIn();$("#customer-login").hide();window.location.hash="#recover";return false}function hideRecoverPasswordForm(){$("#recover-password").hide();$("#customer-login").fadeIn();window.location.hash="";return false};
          </script>
        </section>
      </div>
    </div>