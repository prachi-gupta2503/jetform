<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
	String classNameId=String.valueOf(ClassNameLocalServiceUtil.getClassNameId("com.adjecti.mdm.liferay.model.OrganizationDetail"));
		
%>
<portlet:renderURL var="updateAddressRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/organization/add_address_form.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.ORGANIZATIONADDRESSFORM%>" />
	<portlet:param name="classNameId" value="<%=classNameId%>"/>
	<portlet:param name="redirectPage" value="/mdm/unit_master_list.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="showHierarchyRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/organization/organization_hierarchy.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>


<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
		<liferay-util:param name="formClass" value="<%=PISFormConstant.UNITFORM %>" />
		<portlet:param name="action.redirect.url" value="/organization/organization_detail_list.jsp" />
		</liferay-util:include>
	</div>
</div>

<%

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute("form");
%>
<aui:script use="liferay-util-window">  
$(document).ready(function(){
 
  $(".row-action.row-action-approve.active").style.diaplay="none"
});                           
Liferay.provide(
		window, '<portlet:namespace/><%=form.getId()%>updateAddressHandleOnClick', function(actionSource){
	console.log($(actionSource).attr("data-key"));
	
	 var dialogId='<portlet:namespace/>orgaizationOpenDialog';
		var url= '<%=updateAddressRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key")
		url+="&<portlet:namespace/>dialogId="+dialogId;
		url+="&<portlet:namespace/>cancelFunc=<portlet:namespace />orgaizationCloseDialog";
		
		var title ='Unit Address';
		var width = 640;
		LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}
);

Liferay.provide(
		window, '<portlet:namespace/><%=form.getId()%>showHierarchyHandleOnClick', function(actionSource){
console.log(actionSource);
  var dialogId='<portlet:namespace/>orgaizationOpenDialog';
		var url= '<%=showHierarchyRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key")
		url+="&<portlet:namespace/>dialogId="+dialogId;
		url+="&<portlet:namespace/>cancelFunc=<portlet:namespace />orgaizationCloseDialog";
		
		var title ='Unit Hierarchy';
		var width = 640;
		LiferayUtilOpenWindow(dialogId, title, url, true, 500, true, width);

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
	
	Liferay.provide(
		window,
		'<portlet:namespace />AddressForm_123456addeditcloseDialog', function(data) {
		
			
			var dialog;
			if(data && data.dialogId && data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
			}else{
				dialog = Liferay.Util.Window.getById('<portlet:namespace/>orgaizationOpenDialog');
			}
			
			dialog.destroy();
		},
		['liferay-util-window']
	);
		
		
		
</aui:script>
