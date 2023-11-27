<div class="dashboard-layout" id="main-content" role="main">
	<div class="row">
		<div class="col-md-11 pt-2">
			<div class="portlet-layout row">
				<div class="col-md-6 portlet-column portlet-column-first" id="column-1">
					${processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-3 portlet-column" id="column-2">
					${processor.processColumn("column-2", "portlet-column-content")}
				</div>
				
				<div class="col-md-3 portlet-column portlet-column-last" id="column-3">
					${processor.processColumn("column-3", "portlet-column-content")}
				</div>
			</div>	
			<div class="portlet-layout row">
				<div class="col-md-6 portlet-column portlet-column-first" id="column-4">
					${processor.processColumn("column-4", "portlet-column-content portlet-column-content-first")}
				</div>
		
				
				<div class="col-md-6 portlet-column" id="column-5">
					${processor.processColumn("column-5", "portlet-column-content ")}
				</div>
			</div>
			
			<div class="portlet-layout row">
				<div class="col-md-4 portlet-column portlet-column-first" id="column-6">
					${processor.processColumn("column-6", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-4 portlet-column" id="column-7">
					${processor.processColumn("column-7", "portlet-column-content ")}
				</div>
				
				<div class="col-md-4 portlet-column portlet-column-last" id="column-8">
					${processor.processColumn("column-8", "portlet-column-content ")}
				</div>
			</div>
			
			<div class="portlet-layout row">
				<div class="col-md-3 portlet-column portlet-column-first" id="column-9">
					${processor.processColumn("column-9", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-3 portlet-column" id="column-10">
					${processor.processColumn("column-10", "portlet-column-content")}
				</div>
				
				<div class="col-md-6 portlet-column portlet-column-last" id="column-11">
					${processor.processColumn("column-11", "portlet-column-content")}
				</div>
			</div>	
			
			<div class="portlet-layout row">
				<div class="col-md-3 portlet-column portlet-column-first" id="column-12">
					${processor.processColumn("column-12", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-6 portlet-column" id="column-13">
					${processor.processColumn("column-13", "portlet-column-content")}
				</div>
				
				<div class="col-md-3 portlet-column portlet-column-last" id="column-14">
					${processor.processColumn("column-14", "portlet-column-content")}
				</div>
			</div>	
			
			<div class="portlet-layout row">
				<div class="col-md-3 portlet-column portlet-column-first" id="column-15">
					${processor.processColumn("column-15", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-3 portlet-column" id="column-16">
					${processor.processColumn("column-16", "portlet-column-content")}
				</div>
				
				<div class="col-md-3 portlet-column" id="column-17">
					${processor.processColumn("column-17", "portlet-column-content")}
				</div>
				
				<div class="col-md-3 portlet-column portlet-column-last" id="column-18">
					${processor.processColumn("column-18", "portlet-column-content portlet-column-content-last")}
				</div>
				
			</div>
		
			<div class="portlet-layout row">
				<div class="col-md-6 portlet-column portlet-column-first" id="column-19">
					${processor.processColumn("column-19", "portlet-column-content portlet-column-content-first")}
				</div>
		
				<div class="col-md-6 portlet-column portlet-column-last" id="column-20">
					${processor.processColumn("column-20", "portlet-column-content portlet-column-content-last")}
				</div>
			</div>
		</div>
		<div class="col-md-1">
			<div id="right-panel" class="float-right" style="width:5%; transition: all 1s ease-in-out;margin-right:-12px;">
				<aside class="newSideBarRight float-right">            
					<ul class="profile list-unstyled">
						<li id="control-menu-right" class="mt-2 mb-2" style="display:none;" title="Show/Hide Contol Menu">                 
		                    <a id="control-panel" class="list-item text-white"><i class="fa fa-window-maximize" aria-hidden="true" style='color: white'></i></a>
			            </li>
						<li class="mt-2 mb-2" title="View Dashboard Widgets">
							<a id="portlet-list" class="list-item text-white"><i class="fa fa-cog" aria-hidden="true" style='color: white'></i></i></a>
						</li>
						<li class="mt-2 mb-2" title="Add Custom Dashboard Page">
							<a id="add-page" class="list-item text-white"><i class="fa fa-plus" aria-hidden="true" style='color: white'></i></a>
	                    </li>                 
					</ul>
				</aside>
			</div>
			<div id="application-view" style="position: absolute;right: 70px;width: 280px;mt-2; display: none;" class="overlay">
			    ${processor.processPortlet("com_adjecti_dashboard_widget_web_DashboardWidgetPortlet_INSTANCE_application")}
			    ${processor.processColumn("column-21", "portlet-column-content portlet-column-content-last")}
			</div>
				 
			<div id="addpage-view" style="display:none">
		   		${processor.processPortlet("com_adjecti_dashboard_widget_web_DashboardPageCreatorPortlet_INSTANCE_addpage")}
				${processor.processColumn("column-22", "portlet-column-content portlet-column-content-last")}
			</div>
		</div>
	</div>
</div>
<script>

$("#control-panel").click(function(){
	var sideNavWidth = $(".sidenav-menu").width();
	$(".control-menu-container").toggle();
	if($(".sidenav-fixed.sidenav-menu-slider.open").is(":visible") || $(".lfr-add-panel.open-admin-panel.sidenav-menu-slider").is(":visible")){
		$(".product-menu").toggle(function(){
			var isSideNavVisible = $(this).is(":visible");
			if(isSideNavVisible){
	        	$("#content").attr("style","margin-left:"+sideNavWidth+"px !important; transition: all 0.3s ease;");
	        	$("#custom-control-menu").find(".theme-header").attr("style","margin-left:"+sideNavWidth+"px !important; transition: all 0.3s ease;");
	        } else{
	        	$("#content").attr("style","margin-left:0px !important; transition: all 0.3s ease;");
	        	$("#custom-control-menu").find(".theme-header").attr("style","margin-left:0px !important; transition: all 0.3s ease;");
	        }
		});
	}
})
$("#portlet-list").click(function(){
	$("#application-view").toggle();
})
$("#application-widget-close").click(function(){
	$("#application-view").hide();
});
setTimeout(function() {
	var removeLink = '<a onclick="removeWidget(this)"><i class="fa fa-remove"></i></a>';
	$(".dashboard-layout").find(".portlet-topper-toolbar").html(removeLink);
}, 5000);
</script>