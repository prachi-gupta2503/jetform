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

<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_step_form_add_jsp");
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
	boolean formFlow = ParamUtil.getBoolean(request, "formFlow", false);
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);
	
	
	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute(formId);
	if(form==null && StringUtils.isNotEmpty(formClass)){
		JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
		form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
		//request.setAttribute(formId, form);
	}
	request.setAttribute("formId", form.getId());
	request.setAttribute(form.getId(), form);
	
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

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>
<!-- ============================================================== -->

	<div class="container">
		<jsp:include page="/components/list/form-list-restful.jsp"/>
	</div>
	
	<%--@ include file="/components/form/multi-step-next-prev.jsp"--%>		
<script>
<%--	
	$(document).ready(function() {
		//renderForm($("#formFieldContainer"));
		var forms=$('form[name="<portlet:namespace/><%=form.getId()%>"]');
		$.each(forms,  function( index, form ) {
			$(form).submit(function( event ) {
				var formDataJson = $(form).serializeFormJSON();
				formDataJson['namespace']='<portlet:namespace/>';
				formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
				console.log(formDataJson);
				submitFormDataJson(formDataJson);
			  	event.preventDefault();
			});
		});
		
		
		/*$("#<portlet:namespace/><%=form.getId()%>").submit(function( event ) {
		  alert( "Handler for .submit() called." );
			var formDataJson = $(this).serializeFormJSON();
			formDataJson['namespace']='<portlet:namespace/>';
			formDataJson['<portlet:namespace/>formClass']='<%=form.getFormClass().getName()%>';
			console.log(formDataJson);
			submitFormDataJson(formDataJson);
		  	event.preventDefault();
		});*/
		
	});
	function submitFormDataJson(formDataJson, onSuccess, onFailure){
		AUI().use('aui-base', function(A){
			Liferay.Service(
				'/jetform.jetformbuilder/save-form',
				{
					params: formDataJson
				},
				function(obj) {
					try{
						onSuccess(obj);
					}catch(e){}
				}
			);
		});	
	}--%>
</script>
