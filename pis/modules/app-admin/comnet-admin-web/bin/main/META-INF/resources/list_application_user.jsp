<%@page import="java.util.ArrayList"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="net.ayudh.comnet.admin.model.ApplicationUser"%>
<%@page import="net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil"%>
<%@include file="/init.jsp" %>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="net.ayudh.comnet.admin.dto.ApplicationUserDto"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="net.ayudh.comnet.admin.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
					
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<portlet:renderURL var="editAppUserPermissions " windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"  value="applicationUserForm" />
</portlet:renderURL>
<portlet:renderURL var="assignRole " windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"  value="assignRoleForm" />
</portlet:renderURL>

<portlet:actionURL name="disableApplicationUser" var="disableApplicationUserUrl" ></portlet:actionURL>
<portlet:actionURL name="enableApplicationUser" var="enableApplicationUserUrl"></portlet:actionURL>
<portlet:actionURL name="deleteEmployee" var="deleteEmployeeUrl"></portlet:actionURL>

<!-- <portlet:renderURL var="searchApplicationUserUrl" >
    <portlet:param name="mvcPath" value="/list_application_user.jsp"></portlet:param>
</portlet:renderURL>
 -->
 <portlet:actionURL name="<%=MVCCommandNames.APPLICATION_USER_LIST%>" var="searchApplicationUserUrl"></portlet:actionURL>
 

<%@ include file="/jsp/nav_tabs.jsp" %>

<nav class="navbar navbar-light bg-light justify-content-between">
  <div class="navbar-brand"></div>
  <div class="form-inline">
  	<aui:form class="form-inline" action="<%=searchApplicationUserUrl%>">
  			<div class="row">
  				<div class="col-sm-8">
  					<aui:input class="form-control mr-sm-2" label="" id="personalNo" placeholder="Search By Personal.No" name="personalNo" type="text" ></aui:input>
  				</div>
  				<div class="col-sm-4">
  					<aui:button class="btn btn-outline-success my-2 my-sm-0" name="submitButton" type="submit" value="Submit" onclick="searchApplicationUser()"></aui:button>
  				</div>
  			</div>
  	</aui:form>
  </div>
</nav>
<div style="height:10px;"></div>
	<table class="table" id="applicationUserTable" class="display">
  <thead>
    <tr>
      <th scope="col">Personal No</th>
      <th scope="col">Full Name</th>
      <th scope="col">Email</th>
      <th scope="col">LoginId</th>
      <th scope="col">IDAM User</th>
      <th scope="col">Email Access</th>
      <th scope="col">Digital Signing</th>
      <th scope="col">eGov Access</th>
      <th scope="col">PIS Access</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
	 
  	<c:forEach items="${applicationUserDtos}" var="applicationUserDto">				
    		<tr>
      			<td scope="row">${applicationUserDto.personalNo}</td>
      			<td>${applicationUserDto.fullName}</td>
      			<td>${applicationUserDto.email}</td>
      			<td>${applicationUserDto.loginId}</td>
      			<td>${applicationUserDto.idamUser}</td>
      			<td>${applicationUserDto.emailAccess}</td>
      			<td>${applicationUserDto.digitalSigning}</td>
      			<td>${applicationUserDto.eGovAccess}</td>
      			<td>${applicationUserDto.pisAccess}</td>
      			<td>
					<liferay-ui:icon-menu>
        				<c:if test = "${applicationUserDto.idamUser==false}">       	
        					<liferay-ui:icon  message="Create IDAM User" url="javascript:setModalView('${applicationUserDto.applicationUserId}','${applicationUserDto.personalNo}','add')"  />
        				</c:if>
        				<c:if test = "${applicationUserDto.idamUser==true}">       	
        					<liferay-ui:icon  message="Update IDAM User" url="javascript:setModalView('${applicationUserDto.applicationUserId}','${applicationUserDto.personalNo}','update')"  />
        				</c:if>
        				<c:if test = "${applicationUserDto.status==0}">       	
        					<liferay-ui:icon  message="Disable" url="javascript:disableApplicationUser('${applicationUserDto.applicationUserId}')" />
        				</c:if>
        				<liferay-ui:icon  message="Assign Role" url="javascript:setModalView('${applicationUserDto.applicationUserId}','${applicationUserDto.personalNo}','role')" />
        				<c:if test = "${applicationUserDto.status==1}">
        					<liferay-ui:icon  message="Enable" url="javascript:enableApplicationUser('${applicationUserDto.applicationUserId}')" />
        					<liferay-ui:icon  message="Delete" url="javascript:checkAndDelete('${applicationUserDto.applicationUserId}')" />
        				</c:if>
    				</liferay-ui:icon-menu>
      			</td>     			
    		</tr>
    </c:forEach>
  </tbody>
</table>


<script type="text/javascript">

function searchApplicationUser(){
	
	var personalNo=$("#<portlet:namespace/>personalNo").val();
	if(personalNo==""){
		alert("Please Enter Personal.No in Search Box!");	
	}
}
$(document).ready(function(){
	

			 $('#applicationUserTable').DataTable({
			     "pageLength": 50,
			     "scrollX": true, 
			     "searching": false
			
			    });
			
			
		});
		
function setModalView(applicationUserId, personalNumber, operation){ 
	var url="";
	var title="";
	var height=""
	var width="";
	if(operation=="add" || operation=="update"){
		url= "<%=editAppUserPermissions %>&<portlet:namespace/>applicationUserId="+applicationUserId;  
		if(operation=="add"){
			title='Create IDAM User - '+personalNumber;
		}
		if(operation=="update"){
			title='Update Permissions - '+personalNumber;
		}
		width=600;
		height=270;
	}
	if(operation=="role"){
		url= "<%=assignRole%>&<portlet:namespace/>applicationUserId="+applicationUserId;
		title='Assign Role - '+personalNumber;
		width=600;
		height=400;	
		
	}
	
  	Liferay.Util.openWindow({
		dialog: {
		    cssClass: 'aui-popup-example',
			destroyOnHide: true,
			height:height,
			width:width,
			resizable:false
		},
		title: title,
		id:"appUserDialog",
		uri: url

	});	
}
Liferay.provide(
		window,
		'<portlet:namespace />closeDialog',
		function(data) {
			
			if(data){
				console.log(data);	
			}
			var dialog = Liferay.Util.Window.getById(appUserDialog);
			dialog.destroy();
		},
		['liferay-util-window']
);	


	function checkAndDelete(applicationUserId){
		 var decision=confirm("Are you sure you want to delete Employee ?");
		if(decision){
		 	url="<%=deleteEmployeeUrl%>&<portlet:namespace/>applicationUserId="+applicationUserId;
		 	
		 	$.get(url,function(){
				window.location.reload();
				alert("Employee Delete")
			})	
		}
		else{
			// Do Not Delete Employee
		}
		
	} 
	
	function disableApplicationUser(applicationUserId)
	{
		var url= "<%=disableApplicationUserUrl%>&<portlet:namespace/>applicationUserId="+applicationUserId;
		$.get(url,function(){
			window.location.reload();
		})
	}
	
	function enableApplicationUser(applicationUserId)
	{
		var url= "<%=enableApplicationUserUrl%>&<portlet:namespace/>applicationUserId="+applicationUserId;
		$.get(url,function(){
			window.location.reload();
		})
	}
    function closePopup() {
		Liferay.Util.getOpener().<portlet:namespace/>closePopup(
				'<portlet:namespace />popUpId', '');
	}
	
</script>
<aui:script>
	
</aui:script>