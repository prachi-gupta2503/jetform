<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>

<%@ include file="/menu.jsp"%>
