<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.number_element_jsp");
%>
<%
	String elementName=ParamUtil.getString(request, "elementName");

	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
	if(htmlElement!=null){
		savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");	
	}
%>
<script>
	var <portlet:namespace/><%=htmlElement.getName()%>Unique=false;
	var <portlet:namespace/><%=htmlElement.getName()%>ValidatedValue="<%=savedValue%>";	
</script>

<aui:input type="<%=htmlElement.getControlType()%>" name="<%=htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
<%@ include file="/components/form/validator-common.jsp" %>
</aui:input>
<%@ include file="/components/form/validator-unique-script.jsp" %>