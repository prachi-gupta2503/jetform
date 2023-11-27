<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.adjecti.jetform.annotation.Relation"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_002dstep_002dform_002dflow_jsp");
%>

<%
	response.setHeader("Cache-Control","max-age=0");


	/*String formClassesParam = ParamUtil.getString(request, "formClasses");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String redirectPage = ParamUtil.getString(request, "redirectPage");
	
	if(StringUtils.isEmpty(formClassesParam)){
		formClassesParam=(String)request.getAttribute("formClasses");
	}
	if(StringUtils.isEmpty(formClassPK)){
		formClassPK=(String)request.getAttribute("formClassPK");
	}
	
	String[] formClasses=formClassesParam.split(",");*/
	int groupIndex=0;
	String formClass = ParamUtil.getString(request, "formClass");
	String formFlowProcessId = ParamUtil.getString(request, "formClassPK", "0");
	String title=ParamUtil.getString(request, "title");
	String subTitle=ParamUtil.getString(request, "subTitle");
	
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form=JetFormBuilderLocalServiceUtil.rendererForm(formClass);
	
	request.setAttribute("formFlow", form);
	request.setAttribute("includeScript", "no");

	HtmlFormWrapper processForm=null;
	int processFormIndex=0;
	//for(HtmlElementGroupWrapper group:form.getElementGroups()){
		
		//HtmlFormWrapper form = jetFormBuilderLocalService.getHtmlFormByClass(StringUtils.trim(formClass));
		
		/*if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass);
		}else{
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
		}*/
		
//		forms[formIndex++]=form;
//	}
	
%>
<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
		<div class="col-md-11 text-center p-0 mt-3 mb-2">
			 <div class="card px-0 pt-4 pb-0 mt-3 mb-3" style="text-align:center;">
				<h2>
					<strong><%=title %></strong>
				</h2>
				<p><%=subTitle %></p>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div id="msform">
							<ul id="progressbar">
<%
groupIndex=1;
for(HtmlElementGroupWrapper group:form.getElementGroups()){
	String liClass="";
	if(groupIndex==1){
		liClass="class=\"active\"";
	}
		
%>
								<li <%=liClass%> id="<%=group.getId()%>"><strong><%=group.getName()%></strong></li>
<%
		
	groupIndex++;
}
%>	
								<li id="confirm"><strong>Finish</strong></li>
							</ul>
<%
	groupIndex=1;
	int formIndex=0;
	for(HtmlElementGroupWrapper group:form.getElementGroups()){
%>
							<fieldset id="step<%=group.getId()%>">
								<div class="card form-card" style="padding:30px;">
<%		
		request.setAttribute("groupIndex", String.valueOf(groupIndex));
		boolean nameSpace=(group.getElements().size()>1);
		for(HtmlElementWrapper element:group.getElements()){
			if(element.isControlType(HtmlElement.ControlType.form)){
				formIndex++;
				String formId="form".concat(String.valueOf(formIndex));
				HtmlFormWrapper stepForm = jetFormBuilderLocalService.getHtmlFormByClass(element.getFormClass());
				if(stepForm.isFormFlowProcess()){
					processForm=stepForm;
					processFormIndex=formIndex;
					if(formFlowProcessId!=null && !formFlowProcessId.equals("0")){
						Object entity=jetFormBuilderLocalService.readObject(stepForm.getEntityClass(), formFlowProcessId);
						stepForm.setEntity(entity);
						stepForm.setPrimaryKey(formFlowProcessId);
					}
				}
				if(nameSpace){
					stepForm.setElementNamespace(element.getName());
				}else{
					stepForm.setElementNamespace("");
				}
				//stepForm.setElementNamespace(stepForm.getId());
				request.setAttribute(formId, stepForm);
				//request.setAttribute("form", stepForm);
				request.setAttribute("formElement", element);
				
				String formPage="/components/form/multi-step-form-add.jsp";
				if(StringUtils.isNotEmpty(stepForm.getTemplate())){
					formPage="/components/form/multi-step-form-add-template.jsp";
				}
				
				if(nameSpace){
%>
				<%--<div class="pl-2 mb-3 mt-2"> --%>
				<div class="container"><div class="row"><div class="col-md-6">
					<h3 style="border-bottom: 1px solid #e7e7ed;"><%=element.getLabel() %></h3></div></div></div>
<%
				}
%>
<%--				
				if(StringUtils.isNotEmpty(element.getLabel())){
%>
									<div class="card-header">
										<h3><%= element.getLabel()%></h3>
									</div>
<%
				}
--%>

									<liferay-util:include page="<%=formPage%>" servletContext="<%=application%>">
										<liferay-util:param name="formIndex" value="<%=String.valueOf(groupIndex)%>" />
										<liferay-util:param name="formId" value="<%=formId%>" />
										<liferay-util:param name="formFlowProcessId" value="<%=formFlowProcessId%>" />
										<%--<liferay-util:param name="formClass" value="<%=stepForm.getFormClass().getName()%>" /> --%>
										<liferay-util:param name="formFlow" value="true" />
									</liferay-util:include>
<%				
			}else if(element.isControlType(HtmlElement.ControlType.list)){
				formIndex++;
				String formId="form".concat(String.valueOf(formIndex));
				HtmlFormWrapper stepForm=null;
				
				if(element.isValidFormClass()){
					stepForm = jetFormBuilderLocalService.getHtmlFormByClass(element.getFormClass());
				}else if(element.getRelation().isValidModelClass()){
					stepForm = jetFormBuilderLocalService.getHtmlFormByClass(element.getRelation().getModelClass());
				}
				//stepForm.setElementNamespace(stepForm.getId());
				request.setAttribute(formId, stepForm);
				//request.setAttribute("form", stepForm);
				request.setAttribute("formElement", element);
				
				HtmlFormWrapper mappingForm=null;
				if(element.getRelation().isValidModelClass() && element.getRelation().isValidMappingClass()){
					mappingForm=jetFormBuilderLocalService.getHtmlFormByClass(element.getRelation().getMappingClass());
				}
				
				String mappingField="";
				String mappingFieldWithNamespace="";
				if(mappingForm!=null){
					if(StringUtils.isNotEmpty(element.getRelation().getMappingField())){
						mappingField=element.getRelation().getMappingField();
					}else{
						mappingField=stepForm.getKeyElement().getName();
					}
					mappingForm.setElementNamespace(mappingForm.getId());
					mappingFieldWithNamespace=mappingForm.getElementNamespace()+mappingField;
				}
						
				String formPage="/components/form/multi-step-form-list.jsp";
				
				if(StringUtils.isNotEmpty(element.getCustomTemplate())){
					formPage=element.getCustomTemplate();
				}
%>
									<liferay-util:include page="<%=formPage%>" servletContext="<%=application%>">
										<liferay-util:param name="formIndex" value="<%=String.valueOf(groupIndex)%>" />
										<liferay-util:param name="formId" value="<%=formId%>" />
										<liferay-util:param name="formClass" value="<%=stepForm.getFormClass().getName()%>" />
										<liferay-util:param name="minLength" value="<%=String.valueOf(element.getMinLength())%>" />
										<liferay-util:param name="maxLength" value="<%=String.valueOf(element.getMaxLength())%>" />
										<liferay-util:param name="selectedValueField" value="<%=mappingFieldWithNamespace%>" />
										<liferay-util:param name="formFlowProcessId" value="<%=formFlowProcessId%>" />
										<liferay-util:param name="formFlow" value="true" />
									</liferay-util:include>
<%							
				if(mappingForm!=null){				
					formIndex++;
					formId="form".concat(String.valueOf(formIndex));
					request.setAttribute(formId, mappingForm);
					//mappingForm.setElementNamespace("");
%>
				<liferay-util:include page="/components/form/multi-step-mapping-form.jsp" servletContext="<%=application%>">
					<liferay-util:param name="formIndex" value="<%=String.valueOf(groupIndex)%>" />
					<liferay-util:param name="formId" value="<%=formId%>" />
					<liferay-util:param name="formFlowProcessId" value="<%=formFlowProcessId%>" />
					<%--<liferay-util:param name="formClass" value="<%=mappingForm.getFormClass().getName()%>" /> --%>
					<liferay-util:param name="mappingField" value="<%=mappingField%>" />
				</liferay-util:include>
<%		
				}
			}else if(element.isControlType(HtmlElement.ControlType.custom)){
				String template=element.getCustomTemplate();
				formIndex++;
				String formId="form".concat(String.valueOf(formIndex));
				HtmlFormWrapper stepForm = null;
				if(element.isValidFormClass()){
					stepForm = jetFormBuilderLocalService.getHtmlFormByClass(element.getFormClass());
				}else if(element.getRelation().isValidModelClass()){
					stepForm = jetFormBuilderLocalService.getHtmlFormByClass(element.getRelation().getModelClass());
				}
				request.setAttribute(formId, stepForm);
%>
				<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
					<liferay-util:param name="formIndex" value="<%=String.valueOf(groupIndex)%>" />
					<liferay-util:param name="formId" value="<%=formId%>" />
					<liferay-util:param name="formFlowProcessId" value="<%=formFlowProcessId%>" />
					<%--<liferay-util:param name="formClass" value="<%=element.getFormClass().getName()%>" /> --%>
				</liferay-util:include>
<%				
			}
		}
%>
		<%@include file="/components/form/multi-step-next-prev.jsp"%>								
								</div>
							</fieldset>
<%	
		groupIndex++;	
	}
%>
							<fieldset id="step<%=groupIndex%>">
								<%@ include file="/components/form/multi-step-form-finish.jsp"%>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

$(document).ready(function() {
	
	
	$(".action-button-next").click(function(){
		var index=$(this).attr("index");
		//alert(index);	
		var submitForm=true;
		try{
			submitForm=<portlet:namespace/><%=form.getId()%>flowBeforeFormSubmit(index);
		}catch(e){
			submitForm=true;
			console.log(e)
		}
		
		//alert(submitForm);
		if(submitForm){
			var forms=$("form[index='" + index +"']");
			
			//console.log(forms);
			$.each(forms, function( idx, form ) {
				
				$( form ).submit();
			});
		}
		
		try{
			<portlet:namespace/><%=form.getId()%>flowAfterFormSubmit(index);
		}catch(e){
			console.log(e)
		}
	});
});

function submitFormFlowDataJson(formIndex, formDataJson, onSuccess, onFailure){
	//alert("submitFormFlowDataJson(formIndex, formDataJson, onSuccess, onFailure) called.");
	AUI().use('aui-base', function(A){
		Liferay.Service(
			'/jetform.jetformbuilder/save-form',
			{
				params: formDataJson
			},
			function(response) {
				console.log("response =========================");
				console.log(response);
				//alert(response);
				try{
					onSuccess($.parseJSON(response), formIndex);
				}catch(e){
					onFailure(response, formIndex);
				}
			}
		);
	});	
}
<%--
function <portlet:namespace/><%=form.getId()%>flowBeforeFormSubmit(groupIndex){
	alert("<portlet:namespace/><%=form.getId()%>flowBeforeFormSubmit(groupIndex) : "+groupIndex);
	return true;
}

function <portlet:namespace/><%=form.getId()%>flowAfterFormSubmit(groupIndex){
	alert("<portlet:namespace/><%=form.getId()%>flowAfterFormSubmit(groupIndex) : "+groupIndex);
	/*if(groupIndex==2){
		populateSelectedEmployees();
	}*/
	return true;
}

function populateSelectedEmployees(){
	alert("populateSelectedEmployees");
	//TransferProcessRequestForm_123456updateTableWithFormFlowKeyFilter();
	
}
--%>
</script>
