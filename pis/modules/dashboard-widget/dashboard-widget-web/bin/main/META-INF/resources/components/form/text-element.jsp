<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%
	String elementName=ParamUtil.getString(request, "elementName");
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");


	String elementNamespace="";
	if(request.getAttribute("childHtmlForm")!=null){
		HtmlFormWrapper childForm = (HtmlFormWrapper)request.getAttribute("childHtmlForm");
		elementNamespace=childForm.getElementNamespace();
	}
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
%>

<script>
	var <portlet:namespace/><%=htmlElement.getName()%>Unique=false;
	var <portlet:namespace/><%=htmlElement.getName()%>ValidatedValue="<%=savedValue%>";
</script>

<%	
	if(htmlElement.isControlType(HtmlElement.ControlType.textarea)){
		int rows=htmlElement.getRows();
		int cols=htmlElement.getCols();
		if(rows==0){
			rows=5;
		}
		if(cols==0){
			cols=50;
		}
		
		if(readOnly){
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" rows="<%=rows%>" cols="<%=cols%>" readOnly="true">
		</aui:input>
<%
		}else{
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" rows="<%=rows%>" cols="<%=cols%>" maxLength="<%=htmlElement.getMaxLength() %>">
			<%@ include file="/components/form/validator-common.jsp"%>
		</aui:input>	
<%		
		}
	}else{
		if(readOnly){
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="true">
		</aui:input>
<%
		}else{
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=elementNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" maxLength="<%=htmlElement.getMaxLength() %>">
		<%@ include file="/components/form/validator-common.jsp"%>
		</aui:input>
		<%@ include file="/components/form/validator-unique-script.jsp"%>	
<%		
		}
	}
%>

