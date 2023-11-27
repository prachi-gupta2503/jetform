<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<portlet:renderURL var="mergeRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/mdm/section_master_merge_action.jsp" />
</portlet:renderURL>

<portlet:renderURL var="splitRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/mdm/section_master_split_action.jsp" />
</portlet:renderURL>
<portlet:renderURL var="historyRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/mdm/section_master_history_action.jsp" />
</portlet:renderURL>
<portlet:renderURL var="approveRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/mdm/section-approve-alert.jsp" />
</portlet:renderURL>
<portlet:renderURL var="viewRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/mdm/sectionView.jsp" />
		<portlet:param name="formClass" value="<%=PISFormConstant.SECTIONFORM%>" />
		<portlet:param name="formId" value="SectionForm_123456" />
		<liferay-util:param name="redirectPage" value="/mdm/section_master_list.jsp" />
		<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.list.employee_002dlist_jsp");%>

<%
	/* String formId = (String) request.getAttribute("formId");
	HtmlFormWrapper form = (HtmlFormWrapper) request.getAttribute(formId); */
	List<Organization> organizations = PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	String organizationId = "-1";
	for (Organization o : organizations) {
		organizationId += "," + o.getOrganizationId();
	}
	//organizationId="123002,26";
	LOGGER.info("organizationId : " + organizationId);
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/custom/section-list.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="top.header.template"
				value="/mdm/master_list_header.jsp" />
			<liferay-util:param name="top.action.template"
				value="/mdm/master_list_top_actions.jsp" />
			<liferay-util:param name="redirectPage"
				value="/mdm/section_master_list.jsp" />
			<liferay-util:param name="searchFilter[parentOrganizationId]"
				value="<%=organizationId%>" />
			<liferay-util:param name="filterActions"
				value="true" />
				
		</liferay-util:include>
	</div>
</div>


<aui:script>

function <portlet:namespace/>SectionForm_123456viewHandleOnClick(actionSource){
    
	console.log($(actionSource).attr("data-key"));
	var dialogId='<portlet:namespace/>form_openDialog';
	var url= '<%=viewRenderURL.toString()%>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>cancelFunc=<portlet:namespace />form_closeDialog";
	var width = 640;
	var title ='Section';
	LiferayUtilOpenWindow(dialogId, title, url, true, 600, true, width);
}


function <portlet:namespace />SectionForm_123456dissolveBeforeOnClick(actionSource){
 	var id=$(actionSource).attr("data-key");
 	var title="Initiate for Dissolve";
	var message="Initiate for Dissolve ";
	showApproveAlert(title, message, false, false,actionSource,"Initiate Dissolve");
	
}

function <portlet:namespace />SectionForm_123456mergeBeforeOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="Initiate for Merge";
	var message="Initiate for Merge";
	showMergeAlert(title, message, false, false,actionSource);
	
}

function <portlet:namespace />SectionForm_123456splitBeforeOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="Initiate for Split";
	var message="Initiate for Split";
	showSplitAlert(title, message, false, false,actionSource);
	
}

function <portlet:namespace />SectionForm_123456dissolveapproverHandleOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="Approve for Dissolve";
	var message="Approve for Dissolve";
	showApproveAlert(title, message, false, false,actionSource,"Dissolved");
	
	
}
function <portlet:namespace />SectionForm_123456mergeapproverHandleOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="Approve for Merge";
	var message="Approve for Merge";
	showApproveAlert(title, message, false, false,actionSource,"Merged");
}
function <portlet:namespace />SectionForm_123456splitapproverHandleOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="Approve for Split";
	var message="Approve for Split";
	showApproveAlert(title, message, false, false,actionSource,"Splited");
}
function <portlet:namespace />SectionForm_123456historyHandleOnClick(actionSource){
	var id=$(actionSource).attr("data-key");
	var title="History";
	var message="History of Section";
	showHistoryAlert(title, message, false, false,actionSource); 
}






function showHistoryAlert(alertTitle, message, error, confirmation,actionSource){
	
	var id=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/>SectionForm_123456alertDialog';
	var closeFunc='<portlet:namespace />SectionForm_123456closeDialog';
	var url= '<%=historyRenderURL %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation+'&<portlet:namespace/>id='+id+'&<portlet:namespace/>dialogId='+dialogId+'&<portlet:namespace/>closeFunc='+closeFunc;
	var title =alertTitle;
	var height = 700;
	var width = 1100;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width,true);
}

function showMergeAlert(alertTitle, message, error, confirmation,actionSource,status){
	
	var id=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/>SectionForm_123456alertDialog';
	var closeFunc='<portlet:namespace />SectionForm_123456closeDialog';
	var url= '<%=mergeRenderURL %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation+'&<portlet:namespace/>id='+id+'&<portlet:namespace/>dialogId='+dialogId+'&<portlet:namespace/>closeFunc='+closeFunc;
	var title =alertTitle;
	var height = 500;
	var width = 660;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width,true);
}
function showSplitAlert(alertTitle, message, error, confirmation,actionSource){
	
	var id=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/>SectionForm_123456alertDialog';
	var closeFunc='<portlet:namespace />SectionForm_123456closeDialog';
	var url= '<%=splitRenderURL %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation+'&<portlet:namespace/>id='+id+'&<portlet:namespace/>dialogId='+dialogId+'&<portlet:namespace/>closeFunc='+closeFunc;
	var dialogId='<portlet:namespace/>SectionForm_123456alertDialog';
	var title =alertTitle;
	var height = 600;
	var width = 660;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width,true);
}

function showApproveAlert(alertTitle, message, error, confirmation,actionSource,status){
	
	var id=$(actionSource).attr("data-key");
	var dialogId='<portlet:namespace/>SectionForm_123456alertDialog';
	var closeFunc='<portlet:namespace />SectionForm_123456closeDialog';
	var confirmation=true;
	var url= '<%=approveRenderURL %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation+'&<portlet:namespace/>id='+id+'&<portlet:namespace/>dialogId='+dialogId+'&<portlet:namespace/>formId=SectionForm_123456'+'&<portlet:namespace/>closeFunc='+closeFunc+'&<portlet:namespace/>status='+status;
	var title =alertTitle;
	var height = 200;
	var width = 460;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width,true);
}

Liferay.provide(
	window,
	'<portlet:namespace />SectionForm_123456closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/>SectionForm_123456approve_openDialog');
		}
		dialog.destroy();
		window.location.reload();
	},
	['liferay-util-window']
);	
function <portlet:namespace />SectionForm_123456removerHandleOnClick(actionSource){
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


