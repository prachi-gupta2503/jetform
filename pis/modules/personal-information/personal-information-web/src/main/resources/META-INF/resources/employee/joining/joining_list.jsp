<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>
<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalService"%>
<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.list.employee_002dlist_jsp");
private static final int STATUS_PENDING=1;
private static final int STATUS_APPROVE=2;
private static final int STATUS_REJECT=3;
private static final int STATUS_RETURN=4;


%>

<%
	User loginUser = themeDisplay.getUser();

     String loginUserId=String.valueOf(loginUser.getUserId());
     
     String loginUserUnitId="-1";
        for(long unitId :loginUser.getOrganizationIds()){
        	loginUserUnitId+=","+unitId;
        }
        
	boolean isApprover=loginUser.getRoles().stream().anyMatch(r->r.getName().equalsIgnoreCase("PIS Approver - Regular"));
	

	//JetFormBuilderLocalServiceUtil.removeCachedForm("JoiningProcessForm_123456");
	String listViewType=ParamUtil.getString(request, "listViewType", PISMVCPortletKeys.LIST_DETAIL_VIEW);
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
	}
	 
	//organizationId="123002,26";
	//LOGGER.info("organizationId : "+organizationId);
	
	String formClass=isApprover?PISFormConstant.JOININGPROCESSAPPROVERFORM:PISFormConstant.JOININGPROCESSFORM;
	String searchFilter=isApprover?"1,3":"-1,0,1,3,4";
	String filterByUserAndUnitId=isApprover?"searchFilter[unitId]":"searchFilter[userId]";
	String searchFilterByUserAndUnitId=isApprover?loginUserUnitId:loginUserId;
	
%>

<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="top.action.template" value="/employee/joining/joining_list_top_actions.jsp" />
	<liferay-util:param name="formClass" value="<%=formClass%>" />
	<liferay-util:param name="searchFilter[processStatus]" value="<%=searchFilter%>" />
	<liferay-util:param name="<%=filterByUserAndUnitId %>" value="<%=searchFilterByUserAndUnitId%>" />
	<liferay-util:param name="dialogMode" value="true" />
	<liferay-util:param name="hideActions" value="true" />
</liferay-util:include>

<%
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
System.out.println("Joining List restfull");
%>

<portlet:renderURL var="newJoiningRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/joining_process.jsp" />
<%
	if(isApprover){
%>	
	<portlet:param name="viewOnlyMode" value="true" />
<%
	}
%>	
</portlet:renderURL>

<portlet:renderURL var="processFormRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="dialogMode" value="true" />
	<portlet:param name="unitElementName" value="unitId" />
	
</portlet:renderURL> 

<portlet:renderURL var="actionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/employee/joining/joining_list_action.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="alertRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-alert.jsp" />
	
</portlet:renderURL>

<script>	
$(document).ready(function(){
	if(<%=isApprover%>){
	    $("#<portlet:namespace/><%=formId%>NewJoining").hide();
	}
	$('#<portlet:namespace/><%=form.getId()%>NewJoining').click(function(){
		<portlet:namespace/><%=form.getId()%>createNewJoining();
	})
});
function <portlet:namespace/><%=form.getId()%>editBeforeOnClick(actionSource){
	window.location.href="<%=newJoiningRenderURL.toString()%>&<portlet:namespace/>formFlowClassPK="+$(actionSource).attr("data-key");
	return false;
}
function <portlet:namespace/><%=form.getId()%>createNewJoining(){
	 window.location.href="<%=newJoiningRenderURL.toString()%>";
}
function <portlet:namespace/><%=form.getId()%>approveJoiningHandleOnClick(actionSource){
	
	var processStatus=<%=STATUS_APPROVE%>;
	openProcessFormDialog(actionSource, processStatus);
}

function <portlet:namespace/><%=form.getId()%>rejectHandleOnClick(actionSource){
	var processStatus=<%=STATUS_REJECT%>;
	var joiningId=$(actionSource).attr("data-key");
	joiningFormSubmitRejectAction(joiningId,processStatus);
	
}

function <portlet:namespace/><%=form.getId()%>submitHandleOnClick(actionSource){
	var joiningProcessId=$(actionSource).attr("data-key");
	submitForApproval(joiningProcessId);
	
}

function <portlet:namespace/><%=form.getId()%>returnHandleOnClick(actionSource){
	var processStatus=<%=STATUS_RETURN%>;
	openProcessFormDialog(actionSource, processStatus);
}

function openProcessFormDialog(actionSource, processStatus){
	var joiningProcessId=$(actionSource).attr("data-key");
	var saveLabel=(processStatus==<%=STATUS_APPROVE%>?"Approve":"Return");
	var formClass=(processStatus==<%=STATUS_APPROVE%>?'<%=PISFormConstant.JOININGPROCESSAPPROVERFORM %>':'<%=PISFormConstant.JOININGPROCESSRETURNFORM%>');
	var title=saveLabel+" - Joining Request";
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var url= '<%=processFormRenderURL.toString()%>&<portlet:namespace/>formClassPK='+joiningProcessId;
	url+="&<portlet:namespace/>processStatus="+processStatus;
	url+="&<portlet:namespace/>submit.save.label="+saveLabel;
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>formClass="+formClass;
	url+="&<portlet:namespace/>unitElementName=unitId";
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog";
	
	var width = 500;
	var height = 400;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function joiningFormSubmitRejectAction(joiningProcessId,processStatus){
		var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
		var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
		var url= '<%=actionRenderURL.toString() %>&<portlet:namespace/>formClassPK='+joiningProcessId+'&<portlet:namespace/>formId=<%=form.getId()%>';
		url+='&<portlet:namespace/>dialogId='+dialogId;
		url+='&<portlet:namespace/>closeFunc='+closeFunc;
		url+='&<portlet:namespace/>processStatus='+processStatus;
		var label=(processStatus==<%=STATUS_REJECT%>?"Reject":"Submit");
		var title =label+" - Joining Request";
		var height = 200;
		var width = 640;
		LiferayUtilOpenWindow(dialogId, title, url, true, 200, true, width);
	
}
function submitForApproval(joiningProcessId){
	Liferay.Service(
	 '/pis.joiningprocess/current-status-by-joining-process-id',
		 {
			  joiningProcessId: joiningProcessId
		 },
	  function(obj) {
		var title;
		var message;
		 
	    if(obj==-1){
	    	//alert("Incomplete Joining details! Please complete the joining details before submitting!");
	    	title="Incomplete Joining details";
	    	message="Please complete the joining details before submitting!";
	    	showAlert(title, message, false, false);
	    } else if(obj==1){
	    	//alert("Request for approval has already been sent successfully");
	    	title="Already Submitted";
	    	message="Request for approval has already been sent successfully";
	    	showAlert(title, message, false, false);
	    }else{
	    	var processStatus=<%=STATUS_PENDING%>;
	    	
	    	joiningFormSubmitRejectAction(joiningProcessId, processStatus);
	    }
	  }
	);
}
function showAlert(alertTitle, message, error, confirmation){
	var url= '<%=alertRenderURL.toString() %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation;
	var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
	var dialogId='<portlet:namespace/><%=form.getId()%>alertDialog';
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	url+='&<portlet:namespace/>dialogId='+dialogId;
	var title =alertTitle;
	var height = 200;
	var width = 460;
	
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}


</script>

