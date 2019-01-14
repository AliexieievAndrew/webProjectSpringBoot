<#assign context = springMacroRequestContext.getContextPath()/>

<#--need to use freemarker version 2.3.28 -->
<#import "/spring.ftl" as spring/>

<div class="container">
    <div class="row">


        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">

                <#--header-->
                <div class="panel-heading">
                    <h4>New Category</h4>
                </div>

                <#--body-->
                <div class="panel-body">
                    <form class="form-horizontal" modelAttribute = "category" action = "${context}/manage/category" method = "post">

                        <#--line name-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for = "name">
                                Enter Category Name
                            </label>
                            <div class="col-md-8">
                                <@spring.formInput "category.name", "class = 'form-control'", "text"/>
                                <@spring.showErrors "<br/>",""/>
                            </div>
                        </div>

                        <#--line description-->
                        <div class="form-group">
                            <label class = "control-label col-md-4" for = "name">
                                Enter Category Description
                            </label>
                            <div class="col-md-8">
                                <@spring.formTextarea "category.description", "class = 'form-control'"/>
                            </div>
                        </div>

                        <#--btn submit-->
                        <div class="form-group">
                            <div class="col-lg-offset-4 col-md-8">
                                <input type="submit" name ="submit" id ="submit" value="submit" class = "btn btn-primary"/>

                                <#--hidden fields for Category-->
                                <@spring.formHiddenInput "category.active",""/>
                                <@spring.formHiddenInput "category.imageURL",""/>
                            </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>