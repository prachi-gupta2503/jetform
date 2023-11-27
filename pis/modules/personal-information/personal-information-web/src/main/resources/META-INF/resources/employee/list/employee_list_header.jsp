<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.employee_002dlist_header_jsp");
private static final String TOP_ACTION_TEMPLTATE="top.action.template";
private static final String TOP_ACTION_TEMPLTATE_VALUE="/components/list/list-top-actions.jsp";
%>
<%--
formTitle - is defined in the form-list-restful.jsp
--%>
<%
String topActionTemplate = ParamUtil.getString(request, TOP_ACTION_TEMPLTATE, TOP_ACTION_TEMPLTATE_VALUE);

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

String formTitle = AnnotationUtil.getItemLabel(form.getTitle());
%>
<div class="page-header">
	<div class="row align-items-center">
		<div class="col">
			<h3 class="page-title">Employee</h3>
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="/group/comnet2/pis/employees">Employee</a></li>
				<li class="breadcrumb-item active">All Employees</li>
			</ul>
		</div>
		<div class="col-auto float-right ml-auto">
			<liferay-util:include page="<%=topActionTemplate%>" servletContext="<%=application%>">
			</liferay-util:include>	
		</div>
	</div>
</div>
