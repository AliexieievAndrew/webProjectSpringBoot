<#assign context = springMacroRequestContext.getContextPath()/>

<div class="container">

<#--Added Breadcrump omponent-->
    <div class="row">
        <div class="col-lg-12">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${context}/home">Home</a>
                </li>
                <li class="breadcrumb-item">
                    <a href="${context}/show/all/products">Products</a>
                </li>
                <li>
                <li class="breadcrumb-item active"></li>
                <li class="breadcrumb-item active">${product.name}</li>
                </li>
            </ol>
        </div>
    </div>

    <div class="row">
    <#--Disdplay the product image-->
        <div class="col-xs-12 col-sm-5">
            <div class="thumbnail">
                <img src="${images}/${product.code}.jpg" class="img-fluid" style="width:400px;height:400px;">
            </div>
        </div>


    <#--Display the product description-->


        <div class="col-xs-12 col-sm-4">
            <h3>${product.name}</h3>
            <hr/>
            <p>${product.description}</p>
            <hr/>
            <h4>Price:
                <strong>${product.unitPrice}</strong>
                UAH
            </h4>
            <hr/>

            <a href="${context}/cart/add/${product.id}/product" class="btn btn-success">
                <span class="fas fa-shopping-cart"></span>
                Add to cart
            </a>
            <a href="${context}/show/all/products" class="btn btn-success">
                Back
            </a>
        </div>
    </div>
</div>