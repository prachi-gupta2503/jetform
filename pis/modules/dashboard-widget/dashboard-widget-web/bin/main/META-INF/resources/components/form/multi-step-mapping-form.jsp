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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_mapping_form_jsp");
%>

<%
	response.setHeader("Cache-Control","max-age=0");

	
	//LOGGER.info(redirectPage);
	//formClassPK="301";
	//formKey = "com.adjecti.jetform.liferay.service.model.State";
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	String formIndex = ParamUtil.getString(request, "formIndex");
	String formId = ParamUtil.getString(request, "formId");
	String formClass=ParamUtil.getString(request, "formClass");
	String formAction = ParamUtil.getString(request, "formAction");
	String mappingField = ParamUtil.getString(request, "mappingField");
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	
	
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
	if(form==null){
		JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
		form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
		//request.setAttribute(formId, form);
	}
	
	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
	
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<!-- ============================================================== -->

<aui:form name="<%=form.getId()+form.getElementNamespace()%>" action="<%=saveFormActionURL%>" index="<%=formIndex%>">
	<div class="container">
		<%@ include file="/components/form/hidden-elements.jsp"%>
		<aui:input type="hidden" name="<%=form.getElementNamespace()+"mappingField"%>" value="<%=mappingField%>"/>
	</div>
</aui:form>

<script>

$(document).ready(function() {
	//renderForm($("#formFieldContainer"));
	var forms=$('form[name="<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>"]');
	$.each(forms, function( idx, form ) {
		var index=$(form).attr("index");
		$(form).submit(function( event ) {
			//alert("form is submitted with index : "+index);
			var formDataJson = $(form).serializeFormJSON();
			formDataJson['namespace']='<portlet:namespace/><%=form.getElementNamespace()%>';
			formDataJson['<portlet:namespace/><%=form.getElementNamespace()%>formClass']='<%=form.getFormClass().getName()%>';
			console.log("before submit formDataJson: "+formDataJson);
			submitFormFlowDataJson(index, formDataJson, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnFailure);
		  	event.preventDefault();
		});
	});
});

function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data, groupIndex){
	console.log("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data)");
	
	console.log(data);
<%

	if(form.isFormFlowProcess()){
%>
		var formFlowProcessKey=data["<%=form.getKeyElement().getAttribute()%>"];
		console.log("formFlowProcessKeyName   : <%=form.getKeyElement().getAttribute()%>");
		console.log("formFlowProcessKey   : "+formFlowProcessKey);
		try{
			$(".form-flow-key").each(function(index, flowKey){
				console.log(flowKey);
				console.log($(flowKey).attr("id"));
				$(flowKey).attr("value", formFlowProcessKey);
			});
		}catch(e){
			console.log(e);
		}
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
	//alert("groupIndex : "+groupIndex+" , before calling populateSelectedEmployees");
	if(groupIndex==2){
		populateSelectedEmployees();
	}
}

function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>OnSaveFailure(data, groupIndex){
	
}

<%--
	$(document).ready(function() {
		//renderForm($("#formFieldContainer"));
		var forms=$('form[name="<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>"]');
		$.each(forms,  function( index, form ) {
			$(form).submit(function( event ) {
				var formDataJson = $(form).serializeFormJSON();
				formDataJson['namespace']='<portlet:namespace/><%=form.getElementNamespace()%>';
				formDataJson['<portlet:namespace/><%=form.getElementNamespace()%>formClass']='<%=form.getFormClass().getName()%>';
				console.log(formDataJson);
				submitFormFlowDataJson(formDataJson, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess, <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnFailure);
			  	event.preventDefault();
			});
		});
	});
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data){
		console.log("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnSuccess(data)");
		
		console.log(data);
<%

		if(form.isFormFlowProcess()){
%>
			var formFlowProcessKey=data["<%=form.getKeyElement().getAttribute()%>"];
			console.log("formFlowProcessKeyName   : <%=form.getKeyElement().getAttribute()%>");
			console.log("formFlowProcessKey   : "+formFlowProcessKey);
			try{
				$(".form-flow-key").each(function(index, flowKey){
					console.log(flowKey);
					console.log($(flowKey).attr("id"));
					$(flowKey).attr("value", formFlowProcessKey);
				});
			}catch(e){
				console.log(e);
			}
<%
		}
%>
	}
	
	function <portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%>SubmitOnFailure(data){
		console.log("<portlet:namespace/><%=form.getId()%><%=form.getElementNamespace()%> form submit failed");
		console.log(data);
	}--%>
</script>
