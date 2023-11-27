<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.list.employee_002dlist_jsp");
%>

<%	
LOGGER.info("DIVISION UPDATED________------------------------");
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
	}
	//organizationId="123002,26";
	LOGGER.info("organizationId : "+organizationId);
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="top.header.template" value="/mdm/master_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/mdm/master_list_top_actions.jsp" />
			<liferay-util:param name="redirectPage" value="/mdm/division_master_list.jsp" />
			<%-- <liferay-util:param name="searchFilter[parentOrganizationId]" value="<%=organizationId%>" /> --%>
		</liferay-util:include>
	</div>
</div>
<% 
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId); 
%>
<portlet:renderURL var="showHierarchyRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/organization/organization_hierarchy1.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<aui:script>
Liferay.provide(
		window, '<portlet:namespace/><%=form.getId()%>showHierarchyHandleOnClick', function(actionSource){
console.log(actionSource);
  var dialogId='<portlet:namespace/>orgaizationOpenDialog';
		var url= '<%=showHierarchyRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key")
		url+="&<portlet:namespace/>dialogId="+dialogId;
		url+="&<portlet:namespace/>cancelFunc=<portlet:namespace />orgaizationCloseDialog";
		
		var title ='Organization Hierarchy';
		var width = 640;
		//LiferayUtilOpenWindow(dialogId, title, url, true, 500, true, width);
		window.open(url);

});



Liferay.provide(
		window,
		'<portlet:namespace />orgaizationCloseDialog',
		function(data) {
		alert("close")
			if(data){
				console.log(data);	
			}
			var dialog;
			if(data.dialogId!=''){
				dialog = Liferay.Util.Window.getById(data.dialogId);
			}else{
				dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId()%>openDialog');
			}
			
			dialog.destroy();
			
			//Update table has been temporarily commented due to slowness issue
			//IDAMUserForm_123456updateTable();
		},
		['liferay-util-window']
	);	
	
	function <portlet:namespace /><%=form.getId()%>removerHandleOnClick(actionSource){
	//alert("Remove access");
	var id=$(actionSource).attr("data-key");
   //alert(id);
	Liferay.Service(
  '/mdm.organizationdetail/remove-organization-detail-by-organization-id',
  {
    organizationDeatailId: id
  },
  function(obj) {
     if(obj==false){
  alert("It is associated by one or more employee.");
  }else if(obj==true){
  alert("Deleted Successfully");
      location.reload();
  }
  }
);
	
}
	
</aui:script>