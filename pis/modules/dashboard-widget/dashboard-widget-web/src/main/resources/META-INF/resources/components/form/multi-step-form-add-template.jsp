<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
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
	private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_form_add_template_jsp");
	int alignLeft=HtmlElementGroup.Align.left.ordinal();
	int alignRight=HtmlElementGroup.Align.right.ordinal();
%>
<%
int listElementCount=0;
int childFormCount=0;
	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String formIndex =   ParamUtil.getString(request, "formIndex");
	String formId =   ParamUtil.getString(request, "formId");
	String formAction = ParamUtil.getString(request, "formAction");
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
	if(form==null){
		JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
		form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
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
	<portlet:param name="mvcPath" value="/components/form/form-list.jsp" />
</portlet:actionURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/form/form-list.jsp" />
</portlet:renderURL>

<aui:form name="<%=form.getId()+form.getElementNamespace()%>" action="<%=saveFormActionURL%>" index="<%=formIndex%>">
	<jsp:include page="<%=form.getTemplate()%>"/>
	<div class="container">
		<%@ include file="/components/form/form-default-elements-template.jsp"%>
		<%@ include file="/components/form/form-group-elements-template.jsp"%>	
		<%@ include file="/components/form/hidden-elements.jsp"%>
	</div>
</aui:form>
<%--@ include file="/components/form/multi-step-next-prev.jsp"--%>
<%@ include file="/components/form/script-elements.jsp"%>


<script>
	
<%--	$(document).ready(function() {
		//renderForm($("#formFieldContainer"));
		var forms=$('form[name="<portlet:namespace/><%=form.getId()%>"]');
		$.each(forms,  function( index, form ) {
			$(form).submit(function( event ) {
				var formDataJson = $(form).serializeFormJSON();
				formDataJson['namespace']='<portlet:namespace/>';
				formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
				console.log(formDataJson);
				submit_<portlet:namespace/><%=form.getId()%>(formDataJson);
			  	event.preventDefault();
			});
		});
--%>		
<%--		
		$("#<portlet:namespace/><%=form.getId()%>").submit(function( event ) {
		  alert( "Handler for .submit() called." );
			var formDataJson = $(this).serializeFormJSON();
			formDataJson['namespace']='<portlet:namespace/>';
			formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
			console.log(formDataJson);
			submit_<portlet:namespace/><%=form.getId()%>(formDataJson);
		  	event.preventDefault();
		});
		
	});
	function submit_<portlet:namespace/><%=form.getId()%>(formDataJson){
		AUI().use('aui-base', function(A){
			Liferay.Service(
				'/jetform.jetformbuilder/save-form',
				{
					params: formDataJson
				},
				function(obj) {
				    console.log(obj);
				}
			);
		});	
	}--%>
</script>
<script>
	
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
	}
</script>
