<#assign context = springMacroRequestContext.getContextPath()/>

<div class="container">
    <div class="row">

        <#--Would be to display sidebar-->
        <div class="col-lg-3">

        <#-- Side bar-->
            <#include "shared/sidebar.ftl">

        </div>

        <#--to display the actual products-->
        <div class = "col-lg-9">

            <#--Added breadcrumb component-->
            <div class="row">
                <div class="col-lg-12">

                    <#--category if exist-->
                <#if  category ??>

                    <#--to get product by id in myapp.js-->
                    <script>
                        window.categoryId = '${category.id}';
                    </script>

                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${context}/home">Home</a>
                        </li>
                        <li class="breadcrumb-item active">Category</li>
                        <li class="breadcrumb-item active">${category.name}</li>
                    </ol>
                    <#else>

                    <#--to get all products-->
                    <script>
                        window.categoryId = '';
                    </script>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${context}/home">Home</a>
                        </li>
                        <li class="breadcrumb-item active">All Products</li>
                    </ol>
                </#if>
                </div>
            </div>

            <#--Data Tables-->
            <div class="row">
                <div class="col-lg-12">
                    <#--id for DataTable plugin-->
                    <table id = "productListTable" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Operation</th>
                            </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th></th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Operation</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>