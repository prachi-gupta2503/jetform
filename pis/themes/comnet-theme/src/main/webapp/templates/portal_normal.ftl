<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
	<@liferay.css file_name = "${css_folder}/fancy-box/jquery.fancybox.min.css" />	
	
	<@liferay.css file_name="${css_folder}/icon/all.css" />
	
	<@liferay.css file_name="${css_folder}/owl-carousel/owl.theme.default.min.css" />
	
	<@liferay.css file_name="${css_folder}/owl-carousel/animate.min.css" />
	
	<@liferay.css file_name="${css_folder}/owl-carousel/owl.carousel.css" />
	
	<@liferay.css file_name="${css_folder}/fonts/stylesheet.css" />
	
	<@liferay.css file_name="${css_folder}/magnify-image-hover/jquery.jqZoom.css" />
	
	<@liferay.js file_name = "${javascript_folder}/popper.min.js" />
	
    <@liferay.js file_name = "${javascript_folder}/fancy-box/jquery.fancybox.min.js" />
    
    <@liferay.js file_name = "${javascript_folder}/owl-carousel/owl.carousel.js" />
    
    <@liferay.js file_name = "${javascript_folder}/chart/chart.min.js" />
    
    <@liferay.js file_name = "${javascript_folder}/magnify-image-hover/jquery.jqZoom.js" />
    
	
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

  <#assign roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")/>
	<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")/>
	<#assign owner = roleLocalService.getRole(company_id, "Owner")/>
	<#assign site_owner = roleLocalService.getRole(company_id, "Site Owner")/>
	<#assign site_admin = roleLocalService.getRole(company_id, "Administrator")/>
	<#assign isAdmin = userLocalService.hasRoleUser(site_admin.getRoleId(), user_id)/>
	<#if isAdmin>
		<@liferay.control_menu />
	</#if>

<div id="wrapper" class="body-wrapper">
   <div class="top-navbar">
		<div aria-level="1" class="site-title ofb_logo" role="heading">
			<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
			</a>
		</div>
		
	<div class="top-menu">
	  <div class="control-bar d-flex align-items-center mr-auto">
		   <div class="hamburger">
		       <i class="fas fa-bars font-sm"></i>
		   </div>
		   <#include "${full_templates_path}/more-services.ftl" />
	 </div>
	 
	 <div class="user-details-section">
	 	<!--@liferay.user_personal_bar /-->
        <#include "${full_templates_path}/user-details.ftl" />
	 </div>
	 
	</div>
   </div>
   
   <div class="main-container width-shrink">
      <div class="side-bar-container collapse-menu" id="side-navigation">
          <div class="sidebar">
            <#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />
            <@liferay.navigation_menu default_preferences="${preferences}" />
           </div>
      </div>
      <div class="content-container">
	    <section id="content" class="container-fluid mt-3">
		<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>
	</div>
	<div>

</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>