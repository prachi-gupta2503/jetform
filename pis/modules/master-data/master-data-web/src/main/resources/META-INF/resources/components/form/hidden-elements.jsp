<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%

//HtmlFormWrapper form=(HtmlFormWrapper)pageContext.getAttribute("htmlForm");
for(HtmlElementWrapper htmlElement:form.getElements()){
	if(htmlElement.isControlType(HtmlElement.ControlType.hidden) || htmlElement.isKey() || htmlElement.getName().equalsIgnoreCase("status") || htmlElement.getName().equalsIgnoreCase("deleted")){
		String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+"_savedValue");

		if(StringUtils.isEmpty(savedValue)){
			savedValue=htmlElement.getValue();
		}
		
		String formKeyCssClass="";
		if(htmlElement.isFormFlowKey()){
			formKeyCssClass="form-flow-key";
		}
		if(form.isFormFlowProcess() && htmlElement.isKey()){
			formKeyCssClass="form-flow-process-key form-flow-key";
		}
		if(htmlElement.isKey()){
			formKeyCssClass=formKeyCssClass+" form-key-"+htmlElement.getName();
		}
		
%>
		<aui:input type="hidden" name="<%=htmlElement.getName()%>" value="<%=savedValue%>"  cssClass="<%=formKeyCssClass%>"/>

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
	<%--<aui:input type="hidden" name="<%=form.getKeyElement().getName()%>" value="<%=form.getPrimaryKey()%>"/> --%>
	<aui:input type="hidden" name="formClassPK" value="<%=form.getPrimaryKey()%>"/>		
<%
}
%>	

<aui:input type="hidden" name="formClass" value="<%=form.getFormClass()%>"/>
<aui:input type="hidden" name="companyId" value="<%=themeDisplay.getCompanyId()%>"/>
<aui:input type="hidden" name="userId" value="<%=user.getUserId()%>"/>
<aui:input type="hidden" name="userName" value="<%=user.getFullName()%>"/>

	 