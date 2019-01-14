<#assign context = springMacroRequestContext.getContextPath()/>

<#--need to use freemarker version 2.3.28 -->
<#import "/spring.ftl" as spring/>

<div class="container">
    <div class="row">

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

        <div class ="col-md-offset-2 col-md-8">
            <div class ="panel panel-primary">
                <div class = "panel-heading">
                    <h4>Product Management</h4>

                </div>
                <div class="panel-body">

                    <#--Form elements-->
                    <#--@param modelAttribute will transfering in the method handleProductSubmission-->
                    <form class = "form-horizontal"
                          modelAttribute ="product"
                          action="${context}/manage/products"
                          method = "post"
                          <#--for uploading file-->
                          enctype="multipart/form-data">

                        <#--line name-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="name">
                                Enter Product Name
                            </label>
                            <div class="col-md-8">
                            <#--instead "required", the validation is used-->
                            <@spring.formInput "product.name", "class = 'form-control'","text"/>
                            <@spring.showErrors "<br/>",""/>
                            <#--<@spring.showErrors "product.name","cssClass = 'help-block' element = 'em'"/>-->
                            </div>
                        </div>

                        <#--line description-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="description">
                                Enter product description
                            </label>
                            <div class="col-md-8">
                                <#--instead "required", the validation is used-->
                            <@spring.formTextarea "product.description","class = 'form-control'"/>
                            <@spring.showErrors "<br/>",""/>
                            </div>
                        </div>

                        <#--line unitPrice-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="unitPrice">
                                Enter unit price in UAH
                            </label>
                            <div class="col-md-8">
                            <#--instead "required", the validation is used-->
                                <@spring.formInput "product.unitPrice", "class = 'form-control ' step='0.01'","number"/>
                                <@spring.showErrors "<br/>",""/>
                            </div>
                        </div>


                        <#--line upload image-->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="file">
                                    Upload image
                                </label>
                                <div class="col-md-8">
                                <#--not validating-->
                                    <@spring.formInput "product.file", "class = 'form-control' accept='image/jpeg, image/jpeg, image/png'","file"/>
                                </div>
                            </div>


                        <#--line Category choice-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for="categoryId">
                                Select category
                            </label>
                            <div class="col-md-8">

                                <#--This option does not work correctly. (not Freemarker example)-->
                                <#--<select class="form-control" id="categoryId" name="categoryId" >-->
                                    <#--<#list categories as key, value>-->
                                        <#--<option value="${value}">${key}</option>-->
                                    <#--</#list>-->
                                <#--</select>-->

                                <@spring.bind "categories"/>
                                <@spring.formSingleSelect "product.categoryId", categories, "class = 'form-control'"/>

                                <#--Button for creating a new Category-->
                                <div class = "text-right">
                                    <br/>
                                    <a href="${context}/manage/category" class="btn btn-warning btn-sm">New Category</a>
                                </div>
                            </div>
                        </div>

                        <#--btn submit-->
                            <div class="form-group">
                                <div class="col-lg-offset-4 col-md-8">
                                    <input type="submit" name ="submit" id ="submit" value="submit" class = "btn btn-primary"/>

                                <#--hidden fields for product-->
                                    <@spring.formHiddenInput "product.id",""/>
                                    <@spring.formHiddenInput "product.code",""/>
                                    <@spring.formHiddenInput "product.active",""/>
                                    <@spring.formHiddenInput "product.purchases",""/>
                                </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">

        <div class="col-lg-12">
            <h3>Available Products</h3>
            <hr/>
        </div>

        <div class="col-lg-12">
            <div style="overflow: auto">
                <#--Products table for Admin-->
                <table id="adminProductsTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Unit price</th>
                            <th>Active</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Unit price</th>
                        <th>Active</th>
                        <th>Edit</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>