<#include "shared/flows-header.ftl">
<div class="container">

    <div class="row">
        <div class="col-md-offset-2 col-md-8">


            <#--Personal details-->
            <div class ="panel panel-primary">
                <div class="panel-heading">
                    <h4>Personal details</h4>
                </div>
                <div class="panel-body">

                    <div class="text-center">
                        <h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
                        <h4> email: ${registerModel.user.email} </h4>
                        <h4>contact number: ${registerModel.user.contactNumber} </h4>
                    </div>

                </div>
            </div>

            <#--Personal address-->
            <div class ="panel panel-primary">
                <div class="panel-heading">
                    <h4>Personal address</h4>
                </div>
                <div class="panel-body">
                    <h4>Country: ${registerModel.address.country} </h4>
                    <h4>City: ${registerModel.address.city} </h4>
                    <h4>Address: ${registerModel.address.addressLine} </h4>
                    <h4>Address description: ${registerModel.address.addressDescription} </h4>
                </div>
            </div>


                <div class="panel-body">

                        <div class="form-group">
                            <div class="col-lg-offset-4 col-md-8">

                            <#--go back-->
                                <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">
                                    <span class="fas fa-chevron-left"/>
                                    Back - Billing
                                </a>

                            <#--Success / Submit-->
                                <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">
                                    Confirm
                                    <span class="fas fa-check"/>
                                </a>
                            </div>
                        </div>
                </div>
        </div>
    </div>
<#include "shared/flows-footer.ftl">