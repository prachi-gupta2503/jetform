<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.myapproval-list.jsp");
%>

<% 
long organizationId=0;

try{
	Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
	organizationId=employee.getOrganizationId();
 
}catch(Exception e){
	LOGGER.info(e.getMessage());
}
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="formClass" value="<%=PISFormConstant.MYAPPROVALFORM%>" />
			<liferay-util:param name="searchFilter[organizationId]" value="<%=String.valueOf(organizationId)%>"/>
			<liferay-util:param name="formAction[add]" value="false"/>
			
			<liferay-util:param name="redirectPage" value="/service_request/myapproval-list.jsp" />
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
		<portlet:param name="redirectPage" value="/service_request/myapproval-list.jsp" />
		<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="approvalRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/service_request/myapproval-form.jsp" />
		<portlet:param name="formClass" value="<%=form.getFormClass()%>" />
		<portlet:param name="formId" value="<%=form.getId()%>" />
		<portlet:param name="redirectPage" value="/service_request/myapproval-list.jsp" />
		<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<aui:script>
function <portlet:namespace/><%=form.getId()%>viewHandleOnClick(actionSource){
    
	console.log($(actionSource).attr("data-key"));
	var formClassPK=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace/><%=form.getId()%>closeDialog';
	
	var url= '<%=viewRenderURL.toString()%>';
	
	url+='&<portlet:namespace/>formClassPK='+formClassPK;
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	
	var width = 640;
	var title ='<%=form.getTitle()%>';
	LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}


function <portlet:namespace/><%=form.getId()%>approveHandleOnClick(actionSource){
	console.log($(actionSource).attr("data-key"));
	var formClassPK=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace/><%=form.getId()%>closeDialog';
	
	var url= '<%=approvalRenderURL.toString()%>';
	
	url+='&<portlet:namespace/>formClassPK='+formClassPK;
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	
	var width = 640;
	var title ='<%=form.getTitle()%>';
	LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}
<%--
Liferay.provide(
	window,
	'<portlet:namespace /><%=formId%>closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=formId%>_openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		<%=form.getId()%>updateTable();
	},
	['liferay-util-window']
);
 --%>
</aui:script>