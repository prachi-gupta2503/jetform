<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
	<@liferay.css file_name="${css_folder}/style.css"/>
	
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />



<div class="container-fluid" id="wrapper">
	<@liferay.control_menu />
	<div class="header">

		<div class="header-left">
			<a class="logo" href="${site_default_url}" title="<@liferay.language_format arguments=" ${site_name}" key="go-to-x" />"> <img alt="${logo_description}"
				height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" /> </a>
		</div>

		<a id="toggle_btn" href="javascript:void(0);"> <span class="bar-icon"> <span></span> <span></span> <span></span>
		</span>
		</a>

		<div class="page-title-box">
			<h3>
				<#if show_site_name> ${site_name} </#if>
			</h3>
		</div>

		<a id="mobile_btn" class="mobile_btn" href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/profile.html#sidebar"><i class="fa fa-bars"></i></a>

		<ul class="nav user-menu">

			<li class="nav-item dropdown has-arrow main-drop"><a href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/profile.html#"
				class="dropdown-toggle nav-link" data-toggle="dropdown"> <span class="user-img"><img src="./Employee Profile - HRMS admin template_files/avatar-21.jpg" alt="">
				<span class="status online"></span></span> <span>Admin</span>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/profile.html">My Profile</a> <a class="dropdown-item"
						href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/settings.html">Settings</a> <a class="dropdown-item"
						href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/login.html">Logout</a>
				</div>
			</li>
			
			<li><button type="button" id="configure-page">Configure</button></li>
		</ul>

		<div class="dropdown mobile-user-menu">
			<a href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/profile.html#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
				class="fa fa-ellipsis-v"></i></a>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/profile.html">My Profile</a> <a class="dropdown-item"
					href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/settings.html">Settings</a> <a class="dropdown-item"
					href="https://smarthr.dreamguystech.com/smarthr-laravel/html-template/blue/login.html">Logout</a>
			</div>
		</div>		
	</div>
	
	<#include "${full_templates_path}/navigation.ftl" />
	
	<div id="content" class="page-wrapper" style="min-height: 637px;">

		<#--  <div class="content container-fluid">-->
		
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
		<#--  </div>-->
	</div>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />

<@liferay.js file_name = "${javascript_folder}/jquery.slimscroll.min.js"/>
<@liferay.js file_name = "${javascript_folder}/app.js"/>

<script>
	$(document).ready(function(){
		$('#configure-page').click(function(){
			alert("Clicked");
			$('.header').css('position','relative');
			
			$('.portal-navigation').css('display','none');
		});
	});
</script>
</body>

</html>