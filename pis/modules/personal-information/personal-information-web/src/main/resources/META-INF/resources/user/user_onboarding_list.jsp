<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.liferay.model.EntityWorkflow"%>
<%@page import="com.adjecti.pis.liferay.model.SingleUserOnboarding"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.user.recreate_user_002dlist_jsp");
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

	
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
		
	}
	
	
	String formClass=isApprover?PISFormConstant.SINGLEUSERONBOARDINGAPPROVERFORM:PISFormConstant.SINGLEUSERONBOARDINGFORM;
	String searchFilter=isApprover?"1,3":"-1,0,1,3,4";
	String filterByUserAndUnitId=isApprover?"searchFilter[unitId]":"searchFilter[userId]";
	String searchFilterByUserAndUnitId=isApprover?loginUserUnitId:loginUserId;
	
%>

		<portlet:renderURL var="singleOnboardListRenderURL">
			<portlet:param name="mvcPath" value="/user/user_onboarding_list.jsp" />
		</portlet:renderURL>

	 <div class="page-wrapper">
		<div class="content container-fluid">
		
			<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
				<liferay-util:param name="formClass" value="<%=formClass%>" />
				<liferay-util:param name="searchFilter[status]" value="<%=searchFilter%>" />
				<liferay-util:param name="hideActions" value="true" />
	            <liferay-util:param name="<%=filterByUserAndUnitId %>" value="<%=searchFilterByUserAndUnitId%>" />
			</liferay-util:include>
			
		</div>
	</div>

<%

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);





%>
<portlet:renderURL var="singleUserOnboardingRenderURL">
	<portlet:param name="mvcPath" value="/user/user_onboarding_process.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SINGLEUSERONBOARDINGFORM%>" />
	<portlet:param name="redirectPage" value="/user/user_onboarding_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="actionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/user/user_onboarding_action.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="processFormRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="dialogMode" value="true" />
	
</portlet:renderURL> 

<%-- <portlet:renderURL var="submitOnboardRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=EntityWorkflowForm.class.getName()%>" />
	<portlet:param name="className" value="<%=SingleUserOnboarding.class.getName()%>" />
	<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>" />
	<portlet:param name="status" value="1" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="approveOnboardRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=EntityWorkflowForm.class.getName()%>" />
	<portlet:param name="className" value="<%=SingleUserOnboarding.class.getName()%>" />
	<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>" />
	<portlet:param name="status" value="2" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="rejectOnboardRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=EntityWorkflowForm.class.getName()%>" />
	<portlet:param name="className" value="<%=SingleUserOnboarding.class.getName()%>" />
	<portlet:param name="status" value="-1" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL> --%>

<portlet:renderURL var="addOnboardRenderURL" >
	<portlet:param name="mvcPath" value="/user/user_onboarding_process.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SINGLEUSERONBOARDINGFORM%>" />
	<portlet:param name="formId" value="<%=formId%>" />
	<portlet:param name="redirectPage" value="/user/user_onboarding_list.jsp" />
	<portlet:param name="unitElementName" value="unitId" />
</portlet:renderURL>

<portlet:renderURL var="alertRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-alert.jsp" />
</portlet:renderURL>


<aui:script>

$(document).ready(function(){
	if(<%=isApprover%>){
	    $("#<portlet:namespace/><%=formId%>add").hide();
	}
	
	
});
function <portlet:namespace/><%=form.getId()%>editBeforeOnClick(actionSource){

	window.location.href="<%=singleUserOnboardingRenderURL.toString()%>&<portlet:namespace/>formClassPK="+$(actionSource).attr("data-key");
	return false;
}
function <portlet:namespace/><%=form.getId()%>approveHandleOnClick(actionSource){
	
	var processStatus=<%=STATUS_APPROVE%>;
	var singleUserOnboardingId=$(actionSource).attr("data-key");
	singleUserOnboardingApproveSubmitRejectAction(singleUserOnboardingId,processStatus);
	
}

function <portlet:namespace/><%=form.getId()%>rejectHandleOnClick(actionSource){
	var processStatus=<%=STATUS_REJECT%>;
	var singleUserOnboardingId=$(actionSource).attr("data-key");
	singleUserOnboardingApproveSubmitRejectAction(singleUserOnboardingId,processStatus);
	
}

function <portlet:namespace/><%=form.getId()%>submitHandleOnClick(actionSource){
	var singleUserOnboardingId=$(actionSource).attr("data-key");
	submitForApproval(singleUserOnboardingId);
	
}

<%-- function <portlet:namespace /><%=form.getId() %>approveHandleOnClick(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId() %>approve_openDialog';
	var url= '<%=approveOnboardRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId() %>closeDialog";
	
	var title ='Approve User';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 240, true, width);
} --%>


	
	

function <portlet:namespace/><%=form.getId()%>returnHandleOnClick(actionSource){
	var joiningProcessId=$(actionSource).attr("data-key");
	var processStatus=<%=STATUS_RETURN%>;
	var saveLabel="Return";
	var formClass='<%=PISFormConstant.SINGLEUSERONBOARDINGAPPROVERFORM%>';
	var title=saveLabel+" - SingleUserOnboarding Request";
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var url= '<%=processFormRenderURL.toString()%>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>status="+processStatus;
	url+="&<portlet:namespace/>submit.save.label="+saveLabel;
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>formClass="+formClass;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId()%>closeDialog";
	
	var width = 500;
	var height = 400;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}


<%-- function <portlet:namespace /><%=form.getId() %>submitHandleOnClick(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId() %>submit_openDialog';
	var url= '<%=submitOnboardRenderURL.toString()%>&<portlet:namespace/>classPK='+$(actionSource).attr("data-key");
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=form.getId() %>closeDialog";
	
	var title ='Submit User';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 500, true, width);
} --%>

 function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_ADD%>BeforeOnClick(actionSource){
    var url  ='<%=addOnboardRenderURL.toString() %>';
             window.location=url;
    
           return false;
 }
 
 
function submitForApproval(singleUserOnboardingId){
	Liferay.Service(
	      '/pis.singleuseronboarding/current-status-by-single-user-onboarding-id',
           {
              singleUserOnboardingId: singleUserOnboardingId
            },
	  function(obj) {
		var title;
		var message;
		 
	     if(obj==1){
	    	
	    	title="Already Submitted";
	    	message="Request for approval has already been sent successfully";
	    	showAlert(title, message, false, false);
	    }else{
	    	var processStatus=<%=STATUS_PENDING%>;
	    	
	    	singleUserOnboardingApproveSubmitRejectAction(singleUserOnboardingId, processStatus);
	    }
	  }
	);
}
function showAlert(alertTitle, message, error, confirmation){
	var url= '<%=alertRenderURL.toString() %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation;
	var dialogId='<portlet:namespace/><%=form.getId()%>alertDialog';
	var title =alertTitle;
	var height = 200;
	var width = 460;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function singleUserOnboardingApproveSubmitRejectAction(singleUserOnboardingId,processStatus){
		var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
		var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
		var url= '<%=actionRenderURL.toString() %>&<portlet:namespace/>formClassPK='+singleUserOnboardingId+'&<portlet:namespace/>formId=<%=form.getId()%>';
		url+='&<portlet:namespace/>dialogId='+dialogId;
		url+='&<portlet:namespace/>closeFunc='+closeFunc;
		url+='&<portlet:namespace/>status='+processStatus;
		var label=(processStatus==<%=STATUS_REJECT%>?"Reject":(processStatus==<%=STATUS_APPROVE%>?"Approve":"Submit"));
		var title =label+" - SingleUserOnboarding Request";
		var height = 200;
		var width = 700;
		LiferayUtilOpenWindow(dialogId, title, url, true, 200, true, width);
	
}

Liferay.provide(
	window,
	'<portlet:namespace /><%=form.getId() %>closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=form.getId() %>approve_openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		//SingleUserOnboardingForm_123456updateTable();
	},
	['liferay-util-window']
);	

</aui:script>