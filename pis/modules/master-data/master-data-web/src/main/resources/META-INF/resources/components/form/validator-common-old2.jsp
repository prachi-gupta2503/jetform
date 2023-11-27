<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%
//HtmlElementWrapper htmlElement;

%>

<%
if(htmlElement.isControlType(HtmlElement.ControlType.email)){
%>	
	<aui:validator name="email" />
<%
}

if(htmlElement.isControlType(HtmlElement.ControlType.number)){
%>	
	<aui:validator name="number" />
<%
}

if(htmlElement.isControlType(HtmlElement.ControlType.phone)){
%>	
	<aui:validator name="digits" />
	<aui:validator name="minLength">10</aui:validator>
	<aui:validator name="maxLength">10</aui:validator>
<%
}

if(htmlElement.isRequired()){
%>	
	<aui:validator name="required" />
<%
}
if(htmlElement.getMinLength()>0){
%>	
	<aui:validator name="minLength"><%=htmlElement.getMinLength()%></aui:validator>
<%
}

if(htmlElement.getMaxLength()>0){
%>	
	<aui:validator name="maxLength"><%=htmlElement.getMaxLength()%></aui:validator>
<%
}

if(htmlElement.getMin()>0){
%>	
	<aui:validator name="min"><%=htmlElement.getMin()%></aui:validator>
<%
}

if(htmlElement.getMax()>0){
%>	
	<aui:validator name="max"><%=htmlElement.getMax()%></aui:validator>
<%
}

if(htmlElement.isUnique()){
%>	
	<aui:validator errorMessage="<%="Duplicate "+htmlElement.getLabel()%>" name="custom">
		function(val, fieldNode, ruleValue) {
			if(val=="" || val==<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue){
				return true;
			}
			
			console.log("before func call :"+new Date());
			//checkUnique<portlet:namespace/><%=htmlElement.getName()%>(val);
	    	console.log("before return :"+new Date()+", "+ <portlet:namespace/><%=htmlElement.getName()%>Unique);
	    	if(<portlet:namespace/><%=htmlElement.getName()%>Unique){
	    		<portlet:namespace/><%=htmlElement.getName()%>ValidatedValue=val;
	    	}
	    	return <portlet:namespace/><%=htmlElement.getName()%>Unique;
	    }
	</aui:validator>
<%
}
%>
