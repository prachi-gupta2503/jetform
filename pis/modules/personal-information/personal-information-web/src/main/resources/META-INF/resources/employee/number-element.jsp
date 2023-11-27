<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>

<%
	String elementName=ParamUtil.getString(request, "elementName");

	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
%>
<script>
	var <portlet:namespace/><%=htmlElement.getName()%>Unique=false;
</script>

<aui:input type="<%=htmlElement.getControlType()%>" name="<%=htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
	<%@ include file="/components/form/validator-common.jsp"%>
</aui:input>

<%@ include file="/components/form/validator-unique-script.jsp"%>