<style>
.nav-list-item{
    border-bottom: 1px solid #7a8da0;
    padding-bottom: 20px;"
}    
</style>
<#assign loginUser = themeDisplay.getUser()/>
<#assign digitalSigning = false />
 <#attempt>
	<#assign employeeLocalService = serviceLocator.findService("com.adjecti.pis.liferay.service.EmployeeLocalService")/>
	
    <#if employeeLocalService??>
             <#if employeeLocalService.getEmployeeByEmailId(loginUser.getEmailAddress())?has_content >
	    <#assign employee= employeeLocalService.getEmployeeByEmailId(loginUser.getEmailAddress())/>
	    <#assign registrationRequestLocalService = serviceLocator.findService("com.adjecti.pis.service.RegistrationRequestLocalService")/>
	    <#assign registrationRequest=registrationRequestLocalService.getRegistrationRequestByPersonalNo(employee.personalNo?number) />
	    <#assign digitalSigning=registrationRequest.digitalSigning/>
            </#if>
    	
    </#if>
<#recover>
        <#assign digitalSigning = false />
</#attempt>
<ul>
<#if entries?has_content>
    <#list entries as leftNavigationEntry>
        <#if leftNavigationEntry.hasChildren()>
        	<li class="submenu mb-4 nav-list-item">
        	    <a href="#" class="active subdrop">
            	     <span class="icon"><img src="${leftNavigationEntry.iconURL()}" alt="" style="filter: brightness(0) invert(1)"/></span>
                     <span class="title ml-2">${leftNavigationEntry.getName()}</span>
                     <span class="title menu-arrow"></span>
        	     </a>
            	<ul class="child-nav-left ml-2">
            	    <#list leftNavigationEntry.getChildren() as innerChild>
                	    <li title="${innerChild.getName()}">
                	        <a href="${innerChild.getURL()}">
                	            <span>${innerChild.getName()}</span>
                	        </a>
                	    </li>
            	    </#list>
            	</ul>
        	</li>
        <#else>
	  <#if leftNavigationEntry.getName()=='DSC' && digitalSigning>
            <li title="${leftNavigationEntry.getName()}" class="mb-4 nav-list-item">
                <a href="${leftNavigationEntry.getURL()}"> 
            		<span class="icon"><img src="${leftNavigationEntry.iconURL()}" alt="" style="filter: brightness(0) invert(1)"/></span>
                    <span class="title ml-2">${leftNavigationEntry.getName()}</span>
        		</a>
    		</li>
	 <#elseif leftNavigationEntry.getName()!='DSC'>
	<li title="${leftNavigationEntry.getName()}" class="mb-3 nav-list-item">
                <a href="${leftNavigationEntry.getURL()}"> 
            		<span class="icon"><img src="${leftNavigationEntry.iconURL()}" alt="" style="filter: brightness(0) invert(1)"/></span>
                    <span class="title ml-2">${leftNavigationEntry.getName()}</span>
        		</a>
    		</li>
	</#if>
        </#if>
    </#list>
</#if>
</ul>
