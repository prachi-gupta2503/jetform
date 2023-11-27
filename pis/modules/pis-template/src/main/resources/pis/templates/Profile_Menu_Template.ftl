<#if entries?has_content>
    <#list entries as leftNavigationEntry>
        <a class="dropdown-item" href="${leftNavigationEntry.getURL()}">
            <img src="${leftNavigationEntry.iconURL()}" alt="" style="width:12px; height:12px;"/> 
            ${leftNavigationEntry.getName()}
        </a>
    </#list>
</#if>