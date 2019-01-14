<#--Get the request context in a freemaker template in spring-->
<#assign context = springMacroRequestContext.getContextPath()/>

<#--Include Spring security tag library on top of freemarker file -->
<#-- example https://stackoverflow.com/questions/28347589/checking-spring-security-roles-and-logged-username-in-freemarker-template-->
<#--https://vorba.ch/2018/spring-boot-freemarker-security-jsp-taglib.html-->
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${context}/home">Delivery food</a>
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id = "home">
                    <a class="nav-link" href="${context}/home">Home</a>
                </li>
                <li id = "about">
                    <a class="nav-link" href="${context}/about">About</a>
                </li>
                <li id = "allproducts">
                    <a class="nav-link" href="${context}/show/all/products">All Products</a>
                </li>
                <li id = "contact">
                    <a class="nav-link" href="${context}/contact">Contact</a>
                </li>

                <@security.authorize access="hasAuthority('ADMIN')">
                    <#if userModel?has_content && userModel.role == "ADMIN">
                        <li id = "manageproducts">
                            <a class="nav-link" href="${context}/manage/products">Manage Products</a>
                        </li>
                    </#if>
                </@security.authorize>
            </ul>

            <#--when user not login-->
            <ul class = "nav navbar-nav navbar-right">
                <@security.authorize access = "isAnonymous()">
                    <li id = "register">
                        <#--  /register - FLOW ID !!!!!!!!!!!!!!!!! -->
                        <a class="nav-link" href="${context}/register">
                            <span class="fas fa-user-plus"/>
                        </a>
                    </li>
                    <li id = "login">
                        <a class="nav-link" href="${context}/login">
                            <span class="fas fa-sign-in-alt"/>
                        </a>
                    </li>
                </@security.authorize>
            </ul>
                <#--when user login-->
                <#if userModel?has_content >
                    <@security.authorize access="isAuthenticated()">
                        <ul class = "nav navbar-nav navbar-right">

                            <#--user info-->
                            <li id = "userInfo">
                                <a class="nav-link" href="${context}/userInfo">${userModel.fullName}</a>
                            </li>

                            <#--cart-->
                            <li id = "cart">
                                <a class="nav-link" href="${context}/cart/show">
                                    <span class="fas fa-shopping-cart"/>
                                </a>
                            </li>

                            <#--Logout-->
                            <li id = "logout">
                                <a class="nav-link" href="${context}/logout">
                                    <span class="fas fa-sign-out-alt"/>
                                </a>
                            </li>
                        </ul>
                    </@security.authorize>
                </#if>
        </div>
    </div>
</nav>