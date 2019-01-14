<#assign context = springMacroRequestContext.getContextPath()/>

<div class="container">
    <div class="row">

        <#--showing alert-->
        <#--configured in myapp.js-->
        <#if message??>
            <div class = "col-lg-12">
                <div class="alert alert-danger alert-dismissible">
                <#--data-dismiss = "alert"-->
                    <button type="button" class="close"></button>
                    ${message}
                </div>
            </div>
        </#if>

            <#--id will using in the myapp.js-->
            <form class="form-signin" method="post" action="${context}/login" id="loginForm">
                <h2 class="form-signin-heading">Sign in</h2>
                <p>
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Email"  autofocus>
                </p>
                <p>
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password" >
                </p>
                <#--generatin csrf tokken-->
                <#--<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />-->
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        <#--</body>-->
    <#--</div>-->
</div>