<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.hidden-element_jsp");
%>
<%--<div class="row">
	<div class="col-md-12"> --%>
<%
long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
%>	
<div id="<%=form.getId() %>hidden-elements-<%=new Date().getTime()%>">
<%
for(HtmlElementWrapper htmlElement:form.getElements()){
	/** This to check if the field values are set in paramater 
	 ** and element is set as hidden **/
	 
	String presetHiddenField = ParamUtil.getString(request, htmlElement.getName()+".hidden");
	boolean isPresetHidden=(StringUtils.equalsIgnoreCase(presetHiddenField, "true") || StringUtils.equalsIgnoreCase(presetHiddenField, "yes"));
	
/*
	if(htmlElement.isFormFlowKey()){
		continue;
	}
*/
	if(htmlElement.isControlType(HtmlElement.ControlType.hidden) || htmlElement.isKey() || isPresetHidden){
		/* LOGGER.info("htmlElement.getName() : "+htmlElement.getName()+", htmlElement.getValue(): "+htmlElement.getValue()+", pageContext: "+pageContext.getAttribute(htmlElement.getName()+"_savedValue")+
				", request : "+request.getAttribute(htmlElement.getName()+"_savedValue")); */
		String savedValue=htmlElement.getValue();
		//String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+"_savedValue");
		
		if(StringUtils.isEmpty(savedValue)){
			savedValue=(String)request.getAttribute(htmlElement.getName()+"_savedValue");
			//LOGGER.info("hidden-elements_savedValue : "+savedValue);
		}
	
		String keyCssClass="";
		if(htmlElement.isKey()){
			keyCssClass="form-key";
		}
		
		if(form.getFormFlowKeyElement()!=null && htmlElement.getName().equals(form.getFormFlowKeyElement().getName())){
			LOGGER.info("Hidden-elements - form.getFormFlowKeyElement() : "+htmlElement.getName()+" savedValue : "+savedValue +", formFlowClassPK : "+formFlowClassPK);
			if((StringUtils.isBlank(savedValue) || savedValue.equals("0") || savedValue.equals("null")) && formFlowClassPK>0){
				savedValue=String.valueOf(formFlowClassPK);
			}
			keyCssClass+=(StringUtils.isEmpty(keyCssClass)?"form-flow-key": " form-flow-key");
		}
			
/*		if(htmlElement.isFormFlowKey()){
			if(StringUtils.isBlank(keyCssClass)){
				keyCssClass="form-flow-key";
			}else{
				keyCssClass+=" form-flow-key";
			}
		}
		if(form.isFormFlowProcess() && htmlElement.isKey()){
			keyCssClass="form-flow-process-key form-flow-key";
		}
		if(htmlElement.isKey()){
			keyCssClass=formFlowKeyCssClass+" form-key-"+htmlElement.getName();
		}*/
		
%>
		<aui:input type="hidden" name="<%=form.getElementNamespace()+htmlElement.getName()%>" value="<%=savedValue%>" cssClass="<%=keyCssClass%>"/>
<%
	}
}
for(HtmlElementGroupWrapper htmlGroup:form.getElementGroups()){
	for(HtmlElementWrapper htmlElement:htmlGroup.getElements()){
		String presetHiddenField = ParamUtil.getString(request, htmlElement.getName()+".hidden");
		boolean isPresetHidden=(StringUtils.equalsIgnoreCase(presetHiddenField, "true") || StringUtils.equalsIgnoreCase(presetHiddenField, "yes"));
		
		if(htmlElement.isControlType(HtmlElement.ControlType.hidden) || isPresetHidden){
			String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+"_savedValue");
%>
		<aui:input type="hidden" name="<%=form.getElementNamespace()+htmlElement.getName()%>" value="<%=savedValue%>" />
<%
		}
	}
}

if(form.getPrimaryKey()!=null && !String.valueOf(form.getPrimaryKey()).isEmpty()){
%>
<%--	<aui:input type="hidden" name="<%=form.getElementNamespace()+form.getKeyElement().getName()%>" value="<%=form.getPrimaryKey()%>"/> --%>
	<aui:input type="hidden" name="<%=form.getElementNamespace()+"formClassPK"%>" value="<%=form.getPrimaryKey()%>"/>		
<%
}
%>	

<aui:input type="hidden" name="<%=form.getElementNamespace()+"formClass"%>" value="<%=form.getFormClass().getName()%>"/>


</div>
<%--<aui:input type="hidden" name="entityClass" value="<%=form.getEntityClass()%>"/> --%>
<%--	</div>
</div> --%>	 