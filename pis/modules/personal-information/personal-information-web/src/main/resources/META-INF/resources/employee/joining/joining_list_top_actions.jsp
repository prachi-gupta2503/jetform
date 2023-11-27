<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormActionWrapper"%>
<%@ include file="/init.jsp"%>
<%--
bulkActions - The list is defined in the form-list-restful.jsp
actionsParamMap - The map is defined in the form-list-restful.jsp
--%>	
<%! 
 private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.master_list_top_actions_jsp");
%>
<portlet:renderURL var="cardViewRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_LIST%>"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_CARD_VIEW%>"/>
</portlet:renderURL>

<portlet:renderURL var="listViewRenderURL">
	<portlet:param name="mvcPath" value="/employee/list/employee_list.jsp"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_DETAIL_VIEW%>"/>
</portlet:renderURL>

<%--portlet:renderURL var="joiningRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/employee_joining_process.jsp" />
</portlet:renderURL --%>

<%
	String listViewType=ParamUtil.getString(request, "listViewType", PISMVCPortletKeys.LIST_DETAIL_VIEW);
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

%>
<a title="Add" class="text-white float-right" id="<portlet:namespace/><%=form.getId()%>NewJoining"><i class="fas fa-plus-circle" style="font-size: 1.5em;" aria-hidden="true"></i> New Joining</a>
<%--
<a href="<%=listViewType.equals(PISMVCPortletKeys.LIST_DETAIL_VIEW)?"#": listViewRenderURL.toString() %>" class="btn btn-secondary mr-1">
	<i class="fas fa-align-justify view-icon"></i>
</a>

<a href="<%=listViewType.equals(PISMVCPortletKeys.LIST_CARD_VIEW)?"#": cardViewRenderURL.toString() %>" class="btn btn-primary mr-1" disabled="true">
	<i class="fas fa-border-all view-icon"></i>
</a>
 
<a class="btn btn-primary mr-1" href="/group/comnet2/pis/joining" title="New Joining" id="<portlet:namespace/><%=form.getId()%>joining">
	<i class="fa fa-plus mr-1" aria-hidden="true"></i>New Joining
</a>
--%>
