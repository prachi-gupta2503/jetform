<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_form_add_jsp");
%>
<%
	response.setHeader("Cache-Control","max-age=0");

	int listElementCount=0;
	int childFormCount=0;
	//LOGGER.info(redirectPage);
	//formClassPK="301";
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	int tabIndex = ParamUtil.getInteger(request, "tabIndex",0);
	String formIndex = ParamUtil.getString(request, "formIndex");
	String formId = ParamUtil.getString(request, "formId");
	String formClass = ParamUtil.getString(request, "formClass");
	String formFlowClassPK = ParamUtil.getString(request, "formFlowClassPK", "0");
	String formAction = ParamUtil.getString(request, "formAction");
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	String redirectUrl = ParamUtil.getString(request, "redirectUrl");
	
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
	if(form==null){
		form = JetFormBuilderLocalServiceUtil.getHtmlFormByClass(ClassUtils.getClass(formClass));
		request.setAttribute(formId, form);
	}
%>

<portlet:renderURL var="documentBrowserURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-browser.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentScannerURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-scanner.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="documentAdderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/document-adder.jsp"/>
</portlet:renderURL>

<portlet:resourceURL id="listOptions" var="listOptionsResourceURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/json.jsp" />
</portlet:resourceURL>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<portlet:renderURL var="redirectRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="<%=redirectUrl %>" />
</portlet:renderURL>


<aui:form name="<%=form.getId()+form.getElementNamespace()%>" action="<%=saveFormActionURL%>" index="<%=formIndex%>">
	<div class="card form-card" style="height: 400px; padding:30px; margin:30px;">
		<div class="container">
			<%@ include file="/components/form/form-default-elements.jsp"%>
			<%@ include file="/components/form/form-group-elements.jsp"%>	
			<%@ include file="/components/form/hidden-elements.jsp"%>
			<aui:input type="hidden" name="tabIndex" value="<%=String.valueOf(tabIndex)%>"/>
		</div>
	</div>
	<%@include file="/components/form/multi-step-next-prev.jsp"%>
</aui:form>
<%@ include file="/components/form/multi-step-form-script-elements.jsp"%>

<script>
	
	$(document).ready(function() {
		//renderForm($("#formFieldContainer"));
		var form=$('form[name="<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>"]');
		$.each(forms, function( idx, form ) {
			var index=$(form).attr("index");
			$(form).submit(function( event ) {
				event.preventDefault();
				//alert("form is submitted with index : "+index);
				var formDataJson = $(form).serializeFormJSON();
				formDataJson['namespace']='<portlet:namespace/><%=form.getElementNamespace()%>';
				formDataJson['<portlet:namespace/><%=form.getElementNamespace()%>formClass']='<%=form.getFormClass().getName()%>';
				//alert("before submit formDataJson index : "+index);
				console.log(formDataJson);
				submitFormFlowDataJson(index, formDataJson, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnFailure);
			  	
			});
		});
<%
	if(form.isFormFlowProcess() && formFlowClassPK!=null && !formFlowClassPK.equals("0")){
%>
		var formFlowProcessKey=<%=formFlowClassPK%>;
		
		<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>PropagateFormFlowProcessKey(formFlowProcessKey);
<%
	}
%>
	});
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data, groupIndex){
		//alert("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data)");
		
		console.log(data);
<%

		if(form.isFormFlowProcess()){
%>
			var formFlowProcessKey=data["<%=form.getKeyElement().getAttribute()%>"];
			console.log("formFlowProcessKeyName   : <%=form.getKeyElement().getAttribute()%>");
			console.log("formFlowProcessKey   : "+formFlowProcessKey);
			<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>PropagateFormFlowProcessKey(formFlowProcessKey)
<%
		}
%>
		<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveSuccess(data, groupIndex);
	}
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnFailure(data, groupIndex){
		console.log("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%> form submit failed");
		console.log(data);
		<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveFailure(data, groupIndex);
	}
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveSuccess(data, groupIndex){
		//alert("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveSuccess(data, groupIndex) called");
		<%--alert("groupIndex : "+groupIndex+" , before calling populateSelectedEmployees");
		if(groupIndex==2){
			populateSelectedEmployees();
		}--%>
	}
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveFailure(data, groupIndex){
		
	}
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>PropagateFormFlowProcessKey(formFlowProcessKey){
		//alert("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>PropagateFormFlowProcessKey("+formFlowProcessKey+") called");
		try{
			$(".form-flow-key").each(function(index, flowKey){
				console.log(flowKey);
				console.log($(flowKey).attr("id"));
				$(flowKey).attr("value", formFlowProcessKey);
			});
		}catch(e){
			console.log(e);
		}
	}
</script>
