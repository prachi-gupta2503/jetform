
<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>

<%@ include file="/init.jsp"%>

<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEEADDRESSFORM%>" />
</liferay-util:include>