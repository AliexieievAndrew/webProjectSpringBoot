<#include "shared/flows-header.ftl">

    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div class ="panel panel-primary">
                    <div class="panel-heading">
                        <h1>Registration completed successfully</h1>
                        <h3>Use email for login</h3>
                    </div>
                    <div class="panel-body">
                        <a href="${context}/login" class="btn btn-primary">
                            Start
                            <span class="fas fa-sign-in-alt"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

<#include "shared/flows-footer.ftl">