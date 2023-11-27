<#assign user = themeDisplay.getUser() />
<#assign notificationService = serviceLocator.findService("com.liferay.portal.kernel.service.UserNotificationEventLocalService")/>
<#assign notificationCount = notificationService.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(),false)/>
<ul class="d-flex align-items-center mb-0">
   <li>
	   <#if notificationCount == 0>
	   		<i class="far fa-bell font-sm">
				<span class="badge badge-pill badge-danger badge-up badge-glow"></span>
		   	</i>
	   <#else> 
		   	<a href="${site_default_url}/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet&p_p_lifecycle=0">
				<i class="far fa-bell font-sm">
			   		<span class="badge badge-pill badge-danger badge-up badge-glow">${notificationCount}</span>
			   	</i>
		   	</a>
	   </#if>
   </li>
   <li><a href="#"><i class="far fa-envelope font-sm"></i></a></li>
   <#if is_signed_in>
    <li class="dropdown">
      <a class="dropdown-toggle" href="#" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	   <span class="mr-1 user-name text-bold-700">${user_name}</span>
	   <span class="avatar"><img src="${user.getPortraitURL(themeDisplay)}" alt="avatar"><i></i></span>
	  </a>
		<div class="dropdown-menu dropdown-menu-right width-50" aria-labelledby="dropdownMenuLink">
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />

	        <@liferay.navigation_menu
	          default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
	          instance_id="profile_navigation_menu"
	        />
		    <div class="dropdown-divider"></div>
		    <a class="dropdown-item" href="${sign_out_url}"><i class="fas fa-power-off mr-1"></i> Logout</a>
		 </div>
     </li>
     <#else>
      <li><a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow" class="text-white">${sign_in_text} <i class="ml-1 fas fa-sign-in-alt"></i></a></li>
     
     </#if>
</ul>

