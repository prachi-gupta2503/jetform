<%@page import="java.util.Calendar"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
if(StringUtils.isEmpty(savedValue)){
	Calendar calendar=Calendar.getInstance();
	savedValue=String.valueOf(calendar.get(Calendar.YEAR));
}
%>
<aui:input type="text" name="<%=form.getElementNamespace()+htmlElement.getName()%>" value="<%=savedValue%>" label="" readonly="true" />