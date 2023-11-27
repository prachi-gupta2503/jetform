<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>

<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletResponseUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>


<%@ include file="/components/list/form-list-restful.jsp"%>

<%-- <% 
boolean profileEditor=false;
profileEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));

%>
<%@ include file="/components/list/form-list-restful.jsp"%>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
		<liferay-util:param name="top.header.template" value="/employee/profile/employee_other_info_list_header.jsp" />
		<liferay-util:param name="profileEditor" value="<%=String.valueOf(profileEditor)%>" />
						
		<portlet:param name="action.redirect.url" value="/employee/profile/employee_other_info-list-restful.jsp" />
		</liferay-util:include>
	</div>
</div> --%>

<script>
var <%=form.getId()%>addActionHtml = "";
$(document).ready(function() {
	<%=form.getId()%>addActionHtml=$("#<portlet:namespace/><%=form.getId()%>dataTable_addAction").html();
	$("#<portlet:namespace/><%=form.getId()%>dataTable_addAction").html("");

});
function <%=form.getId()%>afterRenderTable(){
	 <%=form.getId()%>initAddButton();
}

function <%=form.getId()%>initAddButton(){
	
	var tableParentDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable").parent("div:last");//.closest('div');
	$(tableParentDiv).css("width", "100%");
	$(tableParentDiv).css("overflow", "auto");
	$(tableParentDiv).css("max-height", "50vh");
	
	var tableFilterDiv = $("#<portlet:namespace/><%=form.getId()%>dataTable_filter");//.closest('div');
	console.log(tableFilterDiv);
	console.log(<%=form.getId()%>addActionHtml);
	$(tableFilterDiv).append(<%=form.getId()%>addActionHtml);
	<%=form.getId()%>initAddAction();
}

function <%=form.getId()%>beforeInitRowActions(){
	 alert("bef"+isSuperAdmin)
	 if(idamFailedCount > 0 || !isSuperAdmin ){
	        alert("alert")  
	     var editLink=$("a[name='<portlet:namespace/><%=form.getId()%>edit']");
		//editLink.removeClass("active");
		editLink.children("i").addClass("inactive");
		
		var deleteLink=$("a[name='<portlet:namespace/><%=form.getId()%>delete']");
		//deleteLink.removeClass("active");
		deleteLink.children("i").addClass("inactive");
		
		var approveLink=$("a[name='<portlet:namespace/><%=form.getId()%>approve']");
		//approveLink.removeClass("active");
		approveLink.children("i").addClass("inactive");
	    return false;
	    
	   }
	 else {
	 	return true;
	 }
	     	
	   
		
	} 
</script>