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
	
	String elementName=ParamUtil.getString(request, "elementName");
	//String unitElementName=ParamUtil.getString(request, "unitElementName");
	//String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	String unitElementName=htmlElement.getDepends();
	
	
%>
<%--cssClass="select2-control"  --%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>">
<%-- To be filled in based on the unit selected --%>
<%@ include file="/components/form/validator-common.jsp" %>
</aui:select>

<script>
	$(document).ready(function(){
		//alert("OK 1");
		$('#<portlet:namespace/><%=unitElementName%>').change(function(){
			<portlet:namespace/>loadSections();
		});
		<portlet:namespace/>loadSections();
	});
	
	function <portlet:namespace/>loadSections(){
		//alert("OK 2");
		var unitId=$('#<portlet:namespace/><%=unitElementName%>').val();
		var employeeId=$('#<portlet:namespace/>employeeId').val();
		console.log("Unit ID : "+unitId);
		if(unitId.trim()!='' && unitId.trim()!='0'){
			AUI().use('aui-base', function(A){
				Liferay.Service( '/pis.employeeorganization/get-non-assigned-organizations-of-employee',
				{
					"parentId": unitId,
					"type": "Section",
					"employeeId": employeeId
				},
				function(response) {
					console.log(response);
					reloadListOptions($('#<portlet:namespace/><%=htmlElement.getName()%>'), response, 'organizationId', 'name','','<%=savedValue%>');
				});
			});
		}else{
			$('#<portlet:namespace/><%=htmlElement.getName()%>').empty();
		}
	}
	
</script>

