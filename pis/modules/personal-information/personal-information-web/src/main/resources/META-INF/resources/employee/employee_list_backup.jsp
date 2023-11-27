<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@ include file="/init.jsp"%>

<style>
.view-icon{
	font-size: 1.3rem !important;
}

/* The Modal (background) */
.search-container {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	overflow: auto; /* Enable scroll if needed */
	
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 100%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

</style>

<portlet:renderURL var="employeeListCardViewRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_LIST%>"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_CARD_VIEW%>"/>
</portlet:renderURL>
<portlet:renderURL var="employeeListDetailViewRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_LIST%>"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_DETAIL_VIEW%>"/>
</portlet:renderURL>
<portlet:renderURL var="employeeJoiningRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/employee_joining_process.jsp" />
</portlet:renderURL>
<portlet:renderURL var="employeeProfileRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_PROFILE%>" />
</portlet:renderURL>
<portlet:renderURL var="employeeListURL"> 
	<portlet:param name="mvcPath" value="/employee/employee_list.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="editPersonalInformationRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/employee_personal_details_add.jsp" />

</portlet:renderURL>

<%
	String listViewType=ParamUtil.getString(request, "listViewType", PISMVCPortletKeys.LIST_DETAIL_VIEW);
%>
<div class="card mt-2">
	<div class="card-header bg-primary text-white ">
		<h5>Employees</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-8">
				<strong>Employee |</strong> All Employees <a href="<%=employeeJoiningRenderURL.toString() %>" style="margin-left:15px;">New Employee Joining</a> <a href="/group/comnet2/pis/bulk-onboarding"  style="margin-left:15px;">Bulk Employee Onboarding</a>
			</div>
		
			<div class="col-md-4">
				<div style="float:right">
					<aui:button id="showSearch" class="btn btn-sm btn-primary float-right mb-2" value="Search"/><a href="<%=listViewType.equals(PISMVCPortletKeys.LIST_DETAIL_VIEW)?"#": employeeListDetailViewRenderURL.toString() %>" style="margin-right:15px" class="btn btn-secondary"><i class="fas fa-align-justify view-icon"></i></a><a href="<%=listViewType.equals(PISMVCPortletKeys.LIST_CARD_VIEW)?"#": employeeListCardViewRenderURL.toString() %>" class="btn btn-primary"><i class="fas fa-border-all view-icon"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="card">
	
<div class="card-body">

<%
	if(listViewType.equals(PISMVCPortletKeys.LIST_CARD_VIEW)){
%>
	<%@ include file="/employee/employee_list_card.jsp"%>
	
<%
	}else{
%>
	<%@ include file="/employee/employee_list_detail.jsp"%>
<%
	}
%>	
</div>
</div>
<div id="search-modal" class="search-container">
	<div class="modal-header">
		<div>Search Employee</div>
		<div><span class="close"><a id="closeDialog"></a></span></div>
	</div>
	<div class="modal-content">
		
		<div id="search-container-dialog" title="Dialog box">
				<%@ include file="/employee/employee_search_form.jsp"%>
		</div>
	</div>
</div>

<%--
<div id="search-modal-content">
	<%@ include file="/employee/employee_search_form.jsp"%>
</div>

<!-- AUI Script For Modal Dialog POPUP -->
<aui:script use="aui-modal,aui-overlay-manager">
A.one("#<portlet:namespace />showSearchBtn").on('click',function(event){
	var dialog = new A.Modal({
		title: "Search Employee",
		bodyContent: A.one("#search-modal-content").html(),
		headerContent: '',
		centered: true,
		modal: true,
		height: 300,
		width:500,
		render: '#search-modal-content',
		close: true
	});
	dialog.render();
});
</aui:script>
 --%>

<script>
	$(document).ready(function(){
		$("#<portlet:namespace/>showSearch").click(function(){
			$("#search-modal").show();
		});
		$("#<portlet:namespace/>closeDialog").click(function(){
			$("#search-modal").hide();
		})
		$("#<portlet:namespace/>cancelSearch").click(function(){
			$("#search-modal").hide();
		})
		
	});
	/*var modal = document.getElementById("search-modal");
	var btn = document.getElementById("<portlet:namespace/>showSearchBtn");
	var cancelBtn = document.getElementById("<portlet:namespace/>cancelBtn");
	var span = document.getElementsByClassName("close")[0];
	btn.onclick = function() {
		modal.style.display = "block";
	}
	span.onclick = function() {
		modal.style.display = "none";
	}
	try{
	cancelBtn.onclick = function() {
		modal.style.display = "none";
	}
	}catch(e){}
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}*/
</script>
 