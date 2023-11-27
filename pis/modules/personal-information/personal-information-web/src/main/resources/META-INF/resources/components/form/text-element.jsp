<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%
	
	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	
	boolean childForm=false;
	String formId=(String)request.getAttribute("childFormId");
	if(StringUtils.isBlank(formId)){
		formId=(String)request.getAttribute("formId");
	}else{
		childForm=true;
	}
	
	String childFormNamespace="";
	if(childForm){
		childFormNamespace=(String)request.getAttribute("childFormNamespace");
	}

	String elementName=(String)request.getAttribute(childFormNamespace+"elementName");
	
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(childFormNamespace+elementName+ "_savedValue");
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
%>

<script>
	var <portlet:namespace/><%=childFormNamespace%><%=htmlElement.getName()%>Unique=false;
	var <portlet:namespace/><%=childFormNamespace%><%=htmlElement.getName()%>ValidatedValue="<%=savedValue%>";
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
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" rows="<%=rows%>" cols="<%=cols%>" readOnly="true">
		</aui:input>
<%
		}else{
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" rows="<%=rows%>" cols="<%=cols%>" maxLength="<%=htmlElement.getMaxLength() %>">
			<%@ include file="/components/form/validator-common.jsp"%>
		</aui:input>	
<%		
		}
	}else{
		if(readOnly){
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" readOnly="true">
		</aui:input>
<%
		}else{
%>
		<aui:input type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" maxLength="<%=htmlElement.getMaxLength() %>">
		<%@ include file="/components/form/validator-common.jsp"%>
		</aui:input>
		<%@ include file="/components/form/validator-unique-script.jsp"%>	
<%		
		}
	}
%>

