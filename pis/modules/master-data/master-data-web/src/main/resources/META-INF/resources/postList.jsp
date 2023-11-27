<%@page import="com.adjecti.mdm.liferay.form.constants.MDMFormConstant"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryPos"%>
<%@page import="com.adjecti.mdm.liferay.service.PostLocalServiceUtil"%>
<%@page import="java.lang.reflect.Modifier"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>

<%@ include file="/init.jsp"%>
<liferay-util:include page="/components/list/form-list.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=MDMFormConstant.POST%>" />
</liferay-util:include>
