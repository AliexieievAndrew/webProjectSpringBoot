<#import "/spring.ftl" as spring/>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class = "container">
        <div class="navbar-header">

            <#--Link Home-->
            <#--When click on to "Home" - to link will be adding &_eventId_home -->
            <#--&_eventId_home - home var will be sending to signup-flow.ftl -->
            <#--eventId - param-->
            <#-- home - value-->
            <a class = "navbar-brand" href="${flowExecutionUrl}&_eventId_home">Home</a>
        </div>
    </div>
</div>