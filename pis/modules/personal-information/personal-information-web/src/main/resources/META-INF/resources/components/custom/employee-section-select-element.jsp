<%@page import="java.net.UnknownHostException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ResourcePermission"%>
<%@page import="com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.ResourcePermissionCheckerUtil"%>
<%@page import="com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ResourceAction"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroupRole"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.select_element_jsp");
%>

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

	/*
	String elementName=ParamUtil.getString(request, "elementName");
	//String unitElementName=ParamUtil.getString(request, "unitElementName");
	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	*/
	String unitElementName=htmlElement.getDepends();
	
	long employeeId=ParamUtil.getLong(request, "formClassPK", 0);
	boolean egovInboxEmpty=false;
	String emptyMessage="Clear inbox in ooffice to change unit/section.";
	
	Employee employee=null;
	OrganizationDetail orgDetail=null;
	
	if(employeeId!=0){
		try{
			employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
			orgDetail=OrganizationDetailLocalServiceUtil.getOrganizationDetail(employee.getSubOrganizationId());
			if(orgDetail!=null && StringUtils.isNotBlank(orgDetail.getOrganizationCode())){
				egovInboxEmpty=PISUserUtil.isEgovInboxEmpty(employee.getLoginId(), orgDetail.getOrganizationCode());
			}else{
				egovInboxEmpty=true;
			}
		}catch (PortalException | UnknownHostException e) {
			LOGGER.error(e);
			emptyMessage="Ooffice inbox could not be verified.";
		}catch(Exception e){
			LOGGER.error(e);
			emptyMessage="Ooffice inbox could not be verified.";
		}
	}
	
	if(orgDetail==null){
		egovInboxEmpty=true;
		if(employee.getSubOrganizationId()>0){
			emptyMessage="No section is not available with id ["+employee.getSubOrganizationId()+"]";
		}else{
			emptyMessage="";
		}
	}
	
	//egovInboxEmpty=true;
	boolean disabled=false;
	//String selectElementName=form.getElementNamespace()+htmlElement.getName();
	String selectElementName=elementName;
	if(readOnly || !egovInboxEmpty){
		selectElementName+="_readonly";
		disabled=true;
	}
%>
<%--cssClass="select2-control" > --%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+selectElementName%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" disabled="<%=disabled %>" >
<%-- To be filled in based on the unit selected --%>
<%
	if(!disabled){
%>
<%@ include file="/components/form/validator-common.jsp" %>
<%
	}
%>
</aui:select>
<%
if(disabled){
	if(!egovInboxEmpty){
%>
<div class="text-primary"><%=emptyMessage%></div>
<%
	}
%>
<aui:input type="hidden" name="<%=childFormNamespace+htmlElement.getName()%>" value="<%=savedValue%>" />
<%	
}
%>
<div id="<portlet:namespace/><%=selectElementName%>exists" style="z-index:9999;"></div>
<aui:script use="aui-modal,aui-overlay-manager">
	var <portlet:namespace/><%=childFormNamespace+selectElementName%>_lastValue='<%=savedValue%>';
	$(document).ready(function(){
		//alert("OK 1");
		console.log("Currently selected Section ====   <%=savedValue%>");
		
		$('#<portlet:namespace/><%=unitElementName%>').change(function(){
		console.log(':: inside the unitElementName change ::');
		console.log('#<portlet:namespace/><%=unitElementName%>');
			<portlet:namespace/>loadSections();
		});

		<portlet:namespace/>loadSections();

		$('#<portlet:namespace/><%=childFormNamespace+selectElementName%>').change(function(){
		console.log(':: inside the selectElementName change ::');
			<portlet:namespace/>checkDuplicateSections();
		});
		
	});
	
	function <portlet:namespace/>loadSections(){
		//alert("OK 2");
		var unitId=$('#<portlet:namespace/><%=unitElementName%>').val();
		console.log("Unit ID : "+unitId);
		if(unitId.trim()!='' && unitId.trim()!='0'){
		console.log(':: inside if the loadSections() ::');
			AUI().use('aui-base', function(A){
				Liferay.Service('/mdm.organizationdetail/get-organizations-by-parent-id-and-type', 
				{
					"parentId": unitId,
					"type": "Section"
				},
				function(response) {
					console.log(response);
					reloadListOptions($('#<portlet:namespace/><%=childFormNamespace+selectElementName%>'), response, 'organizationId', 'name', 'Select a section', '<%=savedValue%>');
				});
			});
		}else{
		
		    console.log(':: inside else the loadSections() ::');
		    reloadListOptions($('#<portlet:namespace/><%=childFormNamespace+selectElementName%>'), response, 'organizationId', 'name', 'Select a section', '<%=savedValue%>');
			$('#<portlet:namespace/><%=childFormNamespace+selectElementName%>').empty();
		}
	}
	
	function <portlet:namespace/>checkDuplicateSections(){
		var section=$('#<portlet:namespace/><%=childFormNamespace+selectElementName%>');
		
		console.log(section);
		
		var sectionId = $(section).val();
		console.log("Section ID : "+sectionId+", employee id : <%=employeeId%>");
		if(sectionId!=null && sectionId.trim()!='' && sectionId.trim()!='0'){
			AUI().use('aui-base', function(A){
				Liferay.Service('/pis.employeeorganization/exists-employee-sub-organization', 
				{
					"employeeId": <%=employeeId%>,
					"subOrganizationId": sectionId
				},
				function(response) {
					console.log("exists-employee-sub-organization - response : "+response);
					console.log(response && response=='false');
					if(response && response == true){
					console.log('calling the if showSectionExistsAlert()');
						showSectionExistsAlert();
					
					}
				});
			});
		}
	}
	function showSectionExistsAlert(){
	console.log(':: inside the showSectionExistsAlert ::');
	 let selectedSectionText = $('#<portlet:namespace/><%=childFormNamespace+selectElementName%>').select2('data')[0].text;
		
		let dialogMessage = "The "+selectedSectionText +" section already assigned as additional section!";
		
		var dialog = new A.Modal({
			title: "Assign Section",
			bodyContent: dialogMessage,
			headerContent: 'Section Change Error!',
			centered: true,
			modal: true,
			height: 200,
			width:350,
			render: '#<portlet:namespace/><%=childFormNamespace+selectElementName%>exists',
			close: true
		});
		dialog.render();
		$('#<portlet:namespace/><%=childFormNamespace+selectElementName%>').val(1).trigger('change.select2');
	}
</aui:script>