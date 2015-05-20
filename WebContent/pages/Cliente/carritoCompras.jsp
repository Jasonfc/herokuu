<div id="content-wrapper">
      <div id="content" class="container clearfix">

        <section class="row content">
          <div id="col-main" class="col-md-24 cart-page content">
            <div id="page-header">
              <h1 id="page-title">Carrito de Compras</h1>
            </div>
            <form action="./cart.html" method="post" id="cartform" class="clearfix" >
              <div class="row-fluid">
                <div class="wrap-table">
                  <table class="cart-items haft-border">
                    <colgroup>
                      <col class="checkout-image" />
                      <col class="checkout-info" />
                      <col class="checkout-price" />
                      <col class="checkout-quantity" />
                      <col class="checkout-totals" />
                      <col class="checkout-delete" />
                    </colgroup>
                    <thead>
                      <tr class="top-labels">
                        <th>Product name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>SubTotal</th>
                        <th>Remove</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr class="item suspendisse-tortor-lacus">
                        <td class="title">
                          <ul class="list-inline">
                            <li class="image">
                              <a href="./product.html">
                                <img src="Cliente/screen/products/product_02_smallest.jpg" alt="Suspendisse tortor lacus" />
                              </a>
                            </li>
                            <li class="link">
                              <a href="./product.html">
                                <span class="block">Suspendisse tortor lacus<i class="fa fa-caret-right"></i></span>
                              </a>
                              <span class="variant_title">Small / Blue</span>
                            </li>
                          </ul>
                        </td>
                        <td class="title-1"><span class="money">$370.00</span></td>
                        <td>
                          <input class="form-control input-1" type="number" maxlength="5" size="5" id="updates_402645725" name="updates[]" value="1" />
                        </td>
                        <td class="total title-1"><span class="money">$370.00</span></td>
                        <td class="action">
                          <button class="btn-7 btooltip" type="button" onclick="window.location='#'" data-toggle="tooltip" data-placement="top" title="" data-original-title="Remove"><i class="fa fa-times"></i></button>
                        </td>
                      </tr>
                      <tr class="item palm-treo-pro">
                        <td class="title">
                          <ul class="list-inline">
                            <li class="image">
                              <a href="./product.html">
                                <img src="Cliente/screen/products/product_11_smallest.jpg" alt="Palm Treo Pro" />
                              </a>
                            </li>
                            <li class="link">
                              <a href="./product.html">
                                <span class="block">Palm Treo Pro<i class="fa fa-caret-right"></i></span>
                              </a>
                              <span class="variant_title">White</span>
                            </li>
                          </ul>
                        </td>
                        <td class="title-1"><span class="money">$320.00</span></td>
                        <td>
                          <input class="form-control input-1" type="number" maxlength="5" size="5" id="updates_402645681" name="updates[]" value="1" />
                        </td>
                        <td class="total title-1"><span class="money">$320.00</span></td>
                        <td class="action">
                          <button class="btn-7 btooltip" type="button" onclick="window.location='#'" data-toggle="tooltip" data-placement="top" title="" data-original-title="Remove"><i class="fa fa-times"></i></button>
                        </td>
                      </tr>
                    </tbody>
                    <tfoot>
                      <tr class="bottom-summary">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td class="update-quantities"><button type="submit" id="update-cart" class="btn btn-1" name="update">Actualiza cantidad</button></td>
                        <td class="subtotal title-1"><span class="money">$690.00</span></td>
                        <td>&nbsp;</td>
                      </tr>
                    </tfoot>
                  </table>
                </div>
              </div>
              <div class="row">
                <div id="checkout-proceed" class="last1 text-right">
                  <button class="btn btn-2 large" type="submit" id="update-cart" name="checkout">Proceso de pago</button>
                </div>
              </div>
              <div class="row">
                <div id="checkout-addnote" class="col-md-10 last">
                  <div class="wrapper-title">
                    <span class="title-3">Agregar nota al vendedor</span>
                    <span class="line"></span>
                  </div>
                  <textarea id="note" rows="5" class="form-control" name="note"></textarea>
                </div>
              </div>
            </form>
            <div id="shipping-calculator">
              <div class="row">
                <div class="col-md-10">
                  <div class="wrapper-title">
                    
                    <span class="line"></span>
                  </div>
                  <div class="row">
                   
                    
                    <p class="col-md-24 last1">
                      <button class="btn small get-rates">Calcular Envio</button>
                    </p>
                  </div>
                </div>
                <div id="wrapper-response" class="col-md-14"></div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>