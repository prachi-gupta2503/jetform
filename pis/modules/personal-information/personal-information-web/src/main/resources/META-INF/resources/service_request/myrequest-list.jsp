<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.pis.liferay.model.ServiceRequest"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.service-request.jsp");
%>
<% 

long employeeId=0;
long organizationId=0;

try{
	Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
	employeeId=employee.getEmployeeId();
	organizationId=employee.getOrganizationId();
}catch(Exception e){
	LOGGER.info(e.getMessage());
}
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="formClass" value="<%=PISFormConstant.MYREQUESTFORM%>" />
			<liferay-util:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
			<liferay-util:param name="organizationId" value="<%=String.valueOf(organizationId)%>" />
			<liferay-util:param name="searchFilter[employeeId]" value="<%=String.valueOf(employeeId)%>"/>
			<liferay-util:param name="redirectPage" value="/service_request/myrequest-list.jsp" />
		</liferay-util:include>
	</div>
</div>

<%
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
%>
<portlet:renderURL var="viewRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/service_request/service-request-form.jsp" />
		<portlet:param name="formClass" value="<%=form.getFormClass()%>" />
		<portlet:param name="formId" value="<%=form.getId()%>" />
		<liferay-util:param name="redirectPage" value="/service_request/myrequest-list.jsp" />
		<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
	
<aui:script>

function <portlet:namespace/><%=form.getId()%>viewHandleOnClick(actionSource){
    
	console.log($(actionSource).attr("data-key"));
	var dialogId='<portlet:namespace/>form_openDialog';
	var url= '<%=viewRenderURL.toString()%>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>cancelFunc=<portlet:namespace />form_closeDialog";
	var width = 640;
	var title ='<%=form.getTitle()%>';
	LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}


Liferay.provide(
	window,
	'<portlet:namespace />form_closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId){
			
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/>form_openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		//IDAMUserForm_123456updateTable();
	},
	['liferay-util-window']
);



</aui:script>