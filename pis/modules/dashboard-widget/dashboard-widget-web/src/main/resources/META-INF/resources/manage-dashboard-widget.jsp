<%@page import="com.adjecti.dashboard.widget.model.DashboardWidget"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.dashboard.widget.web.liferay.form.DashboardWidgetForm"%>
<%@ include file="/init.jsp"%>
<%
FormEntityCache.registerFormClass(DashboardWidgetForm.class);
FormEntityCache.registerFormClass(DashboardWidget.class);
%>
<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=DashboardWidgetForm.class.getName()%>" />
</liferay-util:include>
