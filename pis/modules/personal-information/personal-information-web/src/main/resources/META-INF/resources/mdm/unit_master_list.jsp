<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>

<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("unit_master_list.jsp");
%>

<%	
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
	}
	//organizationId="123002,26";
	LOGGER.info("organizationId check : "+organizationId);
	
	String classNameId=String.valueOf(ClassNameLocalServiceUtil.getClassNameId("com.liferay.portal.kernel.model.Organization"));
%>


<portlet:renderURL var="updateAddressRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/organization/add_address_form.jsp" />
<portlet:param name="formClass" value="<%=PISFormConstant.ADDRESSFORM%>" />
	<portlet:param name="classNameId" value="<%=classNameId%>"/>
	<portlet:param name="redirectPage" value="/mdm/unit_master_list.jsp"  />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<!-- <liferay-util:param name="top.header.template" value="/mdm/master_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/mdm/master_list_top_actions.jsp" /> -->
			<liferay-util:param name="formClass" value="<%=PISFormConstant.UNITFORM%>" />
			<liferay-util:param name="redirectPage" value="/mdm/unit_master_list.jsp" />
			<liferay-util:param name="searchFilter[organizationId]" value="<%=organizationId%>" />
		</liferay-util:include>
	</div>
</div>

<% 
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

%>


<aui:script>


Liferay.provide(
		window, '<portlet:namespace/><%=form.getId()%>updateAddressHandleOnClick', function(actionSource){
	//alert("update address");
	console.log($(actionSource).attr("data-key"));
	var closeFunc='<portlet:namespace/><%=form.getId()%>closeDialog';
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
		var url= '<%=updateAddressRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key")
		url+="&<portlet:namespace/>dialogId="+dialogId;
		url+='&<portlet:namespace/>closeFunc='+closeFunc;
		
		var title ='Unit Address';
		var width = 640;
		LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}
);

function <portlet:namespace /><%=form.getId()%>removerHandleOnClick(actionSource){
	//alert("Remove accessaaa");
	var id=$(actionSource).attr("data-key");
	//alert(id+"hello ambar");
	Liferay.Service(
  '/mdm.organizationdetail/remove-organization-detail-by-organization-id',
  {
    organizationDeatailId: id
  },
  function(obj) {
  if(obj==false){
  alert("It is associated by one or more employee or section.");
  }else if(obj==true){
  alert("Deleted Successfully");
      location.reload();
  }

   
  }
);
	
}  


 </aui:script>
