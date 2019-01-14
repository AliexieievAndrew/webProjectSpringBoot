<#--Example-->
<#--was taken here-->
<#-- https://bootsnipp.com/snippets/featured/responsive-shopping-cart -->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">

    <#--showing alert-->
    <#--configured in myapp.js-->
        <#if message??>
            <div class = "col-lg-12">
                <div class="alert alert-success alert-dismissible">
                <#--data-dismiss = "alert"-->
                    <button type="button" class="close"></button>
                    ${message}
                </div>
            </div>
        </#if>

    <#if cartLines?has_content>

        <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:30%">Product</th>
            <th style="width:20%">Description</th>
            <th style="width:10%">Price</th>
            <th style="width:8%">Quantity</th>
            <th style="width:22%" class="text-center">Subtotal</th>
            <th style="width:10%"></th>
        </tr>
        </thead>

        <tbody>
        <#list cartLines as cartLine>

            <tr>
                <td data-th="Product">
                    <div class="row">
                        <div class="col-sm-2 hidden-xs">
                            <a href="${context}/show/${cartLine.product.id}/product">
                                <img src="${context}/assets/images/${cartLine.product.code}.jpg" style="width:100px;height:100px;"  class="img-responsive"/>
                            </a>
                        </div>
                    </div>
                </td>
                <td data-th="Description">
                    <div class="col-sm-10">
                        <a href="${context}/show/${cartLine.product.id}/product">
                            <h4 class="nomargin">${cartLine.product.name}</h4>
                        </a>
                        <p>${cartLine.product.description}</p>
                    </div>
                </td>

                <td data-th="Price">${cartLine.product.unitPrice}</td>

                <td data-th="Quantity">

                    <input type="number" id="count_${cartLine.id}" class="form-control text-center" min="1" max="20" value="${cartLine.productCount}">
                </td>
                <td data-th="Subtotal" class="text-center">${cartLine.total}</td>
                <td class="actions" data-th="">

                    <#--Button Refresh quaintity of product-->
                    <#--attr value sending to myapp.js-->
                    <button class="btn btn-info btn-sm" name="refreshCart" value="${cartLine.id}"><span class="fa fa-refresh"></span></button>

                    <#--Delete cartline from cart-->
                    <a href="${context}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><span class="fa fa-trash-o"></span></a>
                </td>
            </tr>
        </#list>
        </tbody>
        <tfoot>
        <tr>
            <td><a href="${context}/show/all/products" class="btn btn-warning"><span class="fa fa-angle-left"></span> Continue Shopping</a></td>
            <td colspan="2" class="hidden-xs"></td>

            <td class="hidden-xs text-center">
                <strong>${userModel.cart.total}</strong>
            </td>
            <td><a href="${context}/cart/checkout" class="btn btn-success btn-block">Checkout <span class="fa fa-angle-right"></span></a></td>
        </tr>
        </tfoot>
    </table>
    </#if>
</div>