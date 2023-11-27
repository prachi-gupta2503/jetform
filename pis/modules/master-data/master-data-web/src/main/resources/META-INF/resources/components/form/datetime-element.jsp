<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
%>
<aui:input type="<%=HtmlElement.ControlType.date.name()%>" name="<%=htmlElement.getName()%>" id="<%=htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
<%
	if(htmlElement.isRequired()){
%>	
		<aui:validator name="required" />
<%
	}
%>	
</aui:input>