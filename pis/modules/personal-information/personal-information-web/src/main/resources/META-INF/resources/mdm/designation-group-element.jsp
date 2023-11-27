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
	List<Role> userRoles = themeDisplay.getUser().getRoles();
	List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
	for(Role ur: userRoles){
		List<ResourcePermission> permissions=ResourcePermissionLocalServiceUtil.getRoleResourcePermissions(ur.getRoleId());
		for(ResourcePermission rp:permissions){
			long actionId=rp.getActionIds();
			LOGGER.info("ResourcePermission : "+rp);
		}
	}
	String elementName=ParamUtil.getString(request, "elementName");

	String formId=(String)request.getAttribute("formId");
	HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)request.getAttribute(htmlElement.getName()+ "_savedValue");
	List<DesignationGroup> desGroups=DesignationGroupLocalServiceUtil.getDesignationGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
%>
<%--cssClass="select2-control"  --%>
<aui:select type="<%=htmlElement.getControlType()%>" name="<%=form.getElementNamespace()+htmlElement.getName()%>" label="" multiple="<%=htmlElement.isControlType(HtmlElement.ControlType.multiSelect)%>">
<%
	for(DesignationGroup dg:desGroups){
		boolean selected=false;
		if(StringUtils.equalsIgnoreCase(savedValue, String.valueOf(dg.getDesignationGroupId()))){
			selected=true;
		}
		//LOGGER.info("In select-element : "+htmlElement.getName()+" - "+kv.getKey()+" - selected "+selected);
%>	
		<option value="<%=dg.getDesignationGroupId()%>" <%=selected?"selected":""%>><%=dg.getName() %></option>
<%
	}
%>
</aui:select>

