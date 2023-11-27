<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%

//HtmlFormWrapper form=(HtmlFormWrapper)pageContext.getAttribute("htmlForm");
for(HtmlElementWrapper htmlElement:form.getElements()){
	if(htmlElement.isControlType(HtmlElement.ControlType.hidden) || htmlElement.isKey()){
		String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+"_savedValue");
%>
		<aui:input type="hidden" name="<%=htmlElement.getName()%>" value="<%=savedValue%>" />

<%
	}
}
for(HtmlElementGroupWrapper htmlGroup:form.getElementGroups()){
	for(HtmlElementWrapper htmlElement:htmlGroup.getElements()){
		if(htmlElement.isControlType(HtmlElement.ControlType.hidden)){
			String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+"_savedValue");
%>
		<aui:input type="hidden" name="<%=htmlElement.getName()%>" value="<%=savedValue%>" />
<%
	}
	}
}

if(form.getPrimaryKey()!=null && !String.valueOf(form.getPrimaryKey()).isEmpty()){
%>
	<aui:input type="hidden" name="<%=form.getKeyElement().getName()%>" value="<%=form.getPrimaryKey()%>"/>
	<aui:input type="hidden" name="formClassPK" value="<%=form.getPrimaryKey()%>"/>		
<%
}
%>	

<aui:input type="hidden" name="formClass" value="<%=form.getFormClass().getName()%>"/>
<%--<aui:input type="hidden" name="entityClass" value="<%=form.getEntityClass()%>"/> --%>	 