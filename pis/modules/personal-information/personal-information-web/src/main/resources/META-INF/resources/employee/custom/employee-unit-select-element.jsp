<%@page import="java.net.UnknownHostException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.usersadmin.search.UserOrganizationChecker"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.unit_select_element_jsp");
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
	/*String elementName=ParamUtil.getString(request, "elementName");

	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	*/
	
	long employeeId=ParamUtil.getLong(request, "formClassPK", 0);
	boolean egovInboxEmpty=false;
	String emptyMessage="eGov inbox is not empty";
	if(employeeId!=0){
		try{
			Employee employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
			if(employee.getOrganizationId()>0){
				egovInboxEmpty=PISUserUtil.isEgovInboxEmpty(employee.getLoginId(), null);
			}else{
				egovInboxEmpty=true;
			}
		}catch (PortalException | UnknownHostException e) {
			emptyMessage="eGov inbox could not be verified.";
		}catch(Exception e){
			emptyMessage="eGov inbox could not be verified.";
			LOGGER.error(e);
		}
	}
	/*
	List<Organization> organizations=user.getOrganizations();
	try{
		Organization divOrganization = OrganizationLocalServiceUtil.getOrganization(Long.parseLong(savedValue.trim())).getParentOrganization();
		if(divOrganization!=null){
			organizations=OrganizationDetailLocalServiceUtil.getOrganizationsByParentIdAndType(divOrganization.getOrganizationId(), "Unit");
		}
	}catch(Exception e){}
	*/
	
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	try{
		boolean orgExists=false;
		long organizationId=Long.valueOf(savedValue.trim());
		for(Organization o:organizations){
			if(o.getOrganizationId()==organizationId){
				orgExists=true;
				break;
			}
		}
		if(!orgExists){
			organizations.add(0, OrganizationLocalServiceUtil.getOrganization(organizationId));
		}
	}catch(Exception e){}
	
	if(organizations==null){
		organizations=new ArrayList<Organization>();
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
<%--cssClass="select2-control"  --%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=childFormNamespace+selectElementName%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>" disabled="<%=disabled %>">
<%
	for(Organization o:organizations){
		boolean selected=false;
		
		if(!o.getType().equalsIgnoreCase("Unit")){
			continue;
		}
		
		if(StringUtils.equalsIgnoreCase(savedValue, String.valueOf(o.getOrganizationId()))){
			selected=true;
		}
		//LOGGER.info("In select-element : "+htmlElement.getName()+" - "+kv.getKey()+" - selected "+selected);
%>	
		<option value="<%=o.getOrganizationId()%>" <%=selected?"selected":""%>><%=o.getName() %></option>
<%
	}
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
	<div class="text-danger"><%=emptyMessage%></div>
<%
	}
%>
	<aui:input type="hidden" name="<%=childFormNamespace+htmlElement.getName()%>" value="<%=savedValue%>" />
<%	
}
%>

