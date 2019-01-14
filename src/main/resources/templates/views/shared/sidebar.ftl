<#assign context = springMacroRequestContext.getContextPath()/>

<h1 class="my-4">Delivery food</h1>
<#list categories as category>

<div class="list-group">
    <a href="${context}/show/category/${category.id}/products" class="list-group-item" id = "a_${category.name}">${category.name}</a>
</div>
</#list>