<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.editor_element_jsp");
%>
<%
	String elementName=ParamUtil.getString(request, "elementName");

	boolean viewOnlyMode= false;
	if(request.getAttribute("viewOnlyMode")!=null){
		viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
	}
	
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
	if(savedValue==null){
		savedValue="";
	}
	
	boolean readOnly=StringUtils.trim(htmlElement.getReadOnly()).equalsIgnoreCase("readonly")?true:false;
	
	if(viewOnlyMode){
		readOnly=true;
	}
	
	if(readOnly){
%>
	<textarea class="form-control form-field" name="<portlet:namespace/><%=htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" rows="10" cols="100" readOnly="true">
		<%=savedValue%>
	</textarea>
<%
	}else{
%>	

	<div class="alloy-editor-container">
	    <liferay-ui:input-editor
	    		contents="<%=savedValue%>"
	    		initMethod="<%="init"+elementName+"Editor"%>"
	    		name="<%=form.getElementNamespace()+htmlElement.getName()%>"
	    		placeholder="<%=htmlElement.getPlaceHolder()%>"
	    		showSource="true" width="100" height="600" resizable="true"></liferay-ui:input-editor> 
	    		
	    		<%--<liferay-ui:input-editor name="content" initMethod="initEditor" width="100" height="400" 
		  resizable="true" cssClass="my-alloy-editor"
	    		editorName="alloyeditor"></liferay-ui:input-editor> --%>
	</div>
	<aui:script>
	 function <portlet:namespace/><%="init"+elementName+"Editor"%>(){
	 	return "<%=UnicodeFormatter.toString(savedValue)%>";
	 }
	</aui:script>
<%
	}
%>	