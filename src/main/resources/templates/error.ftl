<!DOCTYPE html>
<html lang="en">

<#assign context = springMacroRequestContext.getContextPath()/>

<#assign css = "/assets/css"/>
<#assign js = "/assets/js"/>
<#assign images = "/assets/images"/>

<!DOCTYPE html>
<html lang="en">

<head>
<#--glyph Font Awesome-->
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
            integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
            crossorigin="anonymous">


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Delivery food - error</title>


    <#--<script>-->
        <#--&lt;#&ndash;for lights buttons&ndash;&gt;-->
        <#--window.menu = '${title}';-->

        <#--window.contextRoot = '${context}';-->

    <#--</script>-->

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap minty theme -->
    <link href="${css}/bootstrap-minty-theme.css" rel="stylesheet">

<#--Bootstrap DataTables-->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
    <!-- Navigation -->
    <#include "views/shared/navbar.ftl">

<#--Page content-->
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="jumbotron">
                        <#if errorTitle?has_content>
                            <h1>${errorTitle}</h1>
                        <#else>
                            <h1>Page is not constructed(404)</h1>
                        </#if>
                        <hr/>
                        <blockquote style="word-wrap: break-word">
                            <#if errorDescription?has_content>
                                ${errorTitle}
                            <#else>
                            The page you are looking for is not available now :(
                            </#if>
                        </blockquote>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <#include "views/shared/footer.ftl">

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>


<#--Self coded javascript (lights buttons)-->
    <script src="${js}/myapp.js"></script>

</div>
</body>

</html>
