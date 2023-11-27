<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%
String elementName=ParamUtil.getString(request, "elementName");

HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");

%>
<aui:input type="text" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
	<aui:validator name="digits" />
	<aui:validator name="maxLength">10</aui:validator>
<%
if(htmlElement.isRequired()){
%>	
	<aui:validator name="required" />
	
<%
}
%>	
</aui:input>