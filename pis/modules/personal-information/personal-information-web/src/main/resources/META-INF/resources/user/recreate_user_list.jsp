<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.user.recreate_user_002dlist_jsp");
%>

<%
	
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
	}
	//organizationId="123002,26";
	LOGGER.info("organizationId : "+organizationId);
	
	String idamUserCreated=ParamUtil.getString(request, "idamUserCreated");
	
	if(StringUtils.isBlank(idamUserCreated)){
		idamUserCreated="true";
	}
    
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		  <liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="formClass" value="<%=PISFormConstant.IDAMUSERFORM%>" />
			 <liferay-util:param name="top.header.template" value="/user/recreate_user_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/user/recreate_user_list_top_actions.jsp" />
			 <liferay-util:param name="action.redirect.url" value="/user/recreate_user_list.jsp" />
			 <liferay-util:param name="exportExcel" value="true" />
			<liferay-util:param name="searchFilter[idamUserCreated]" value="<%=idamUserCreated %>" />
		</liferay-util:include>
	</div>
</div> 
 
<%
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
%>
<portlet:renderURL var="createUserConfirmRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/user/recreate-user-confirm.jsp" />
</portlet:renderURL>

<portlet:renderURL var="updatePermissionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.PISIDAMUSERPERMISSIONFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<aui:script>
function <portlet:namespace/><%=form.getId()%>recreateUserHandleOnClick(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var url= '<%=createUserConfirmRenderURL.toString()%>&<portlet:namespace/>employeePermissionId='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog";
	
	var title ='Create User Confirmation';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}

function <portlet:namespace/><%=form.getId()%>updatePermissionHandleOnClick(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var url= '<%=updatePermissionRenderURL.toString()%>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog";
	
	var title ='Update Permission';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 500, true, width);
}

Liferay.provide(
	window,
	'<portlet:namespace /><%=form.getId()%>closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		<%=form.getId()%>updateTable();
	},
	['liferay-util-window']
);	
</aui:script>
