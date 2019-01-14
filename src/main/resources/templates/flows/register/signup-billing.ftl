<#include "shared/flows-header.ftl">

    <div class="container">

        <div class="row">
            <div class="col-md-offset-2 col-md-8">

                <div class ="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Registering address</h4>
                    </div>

                    <div class="panel-body">
                        <#--billing  its address from signup_flow.xml-->
                        <#-- modelAttribute ="billing" goiing to RegisterModel.class-->
                        <form class="form-horizontal" method="post" id="billingForm" modelAttribute ="billing">

                        <#--line country -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="country">
                                    Your country
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "billing.country", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line city -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="city">
                                    Your city
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "billing.city", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line addres line-->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="addressLine">
                                    Your address
                                </label>
                                <div class="col-md-8">
                                    <@spring.formInput "billing.addressLine", "class = 'form-control'","text"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--line address description -->
                            <div class="form-group">
                                <label class = "control-label col-md-4" for="addressDescription">
                                    Your address description
                                </label>
                                <div class="col-md-8">
                                    <@spring.formTextarea "billing.addressDescription", "class = 'form-control'"/>
                                    <@spring.showErrors "<br/>",""/>
                                </div>
                            </div>

                        <#--btn submit-->
                            <div class="form-group">
                                <div class="col-lg-offset-4 col-md-8">

                                <#--go back-->
                                    <button type="submit" name ="_eventId_personal"  class = "btn btn-primary">
                                        <span class="fas fa-chevron-left"/>
                                        Back - Personal
                                    </button>

                                    <button type="submit" name ="_eventId_confirm"  class = "btn btn-primary">
                                        Next - Confirm
                                        <span class="fas fa-chevron-right"/>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



    </div>

<#include "shared/flows-footer.ftl">