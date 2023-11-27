
<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePermission"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeJoining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeVerification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePastExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.model.Contact"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>

<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.joining_process_finish_jsp");
private static final int STATUS_PENDING=1;
private static final int STATUS_APPROVE=2;
private static final int STATUS_REJECT=3;
private static final int STATUS_RETURN=4;
%>

<%
	String endTitle = "";
	String endSubTitle = "";

	long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);
	String flowFormId = (String) request.getAttribute("flowFormId");
	HtmlFormWrapper formFlow = (HtmlFormWrapper) request.getAttribute(flowFormId);
	User loginuser = themeDisplay.getUser();
	boolean isApprover = loginuser.getRoles().stream()
			.anyMatch(r -> r.getName().equalsIgnoreCase("PIS Approver - Regular"));
	JoiningProcess jp = null;
	EmployeePermission employeePermission=null;
	
	try {
		jp = JoiningProcessLocalServiceUtil.getJoiningProcess(formFlowClassPK);
	} catch (Exception e) {
	}
	
	try {
		employeePermission = EmployeePermissionLocalServiceUtil.getEmployeePermissionsByJoiningProcessId(jp.getJoiningProcessId()).get(0);
	} catch (Exception e) {
	}
	
	if (jp == null) {
		endTitle = "Error!";
		endSubTitle = "No joining process found!";
	} else if (jp.getProcessStatus() <= 0 && !isApprover) {
		if(jp.getProcessStatus() == -1){
			jp.setProcessStatus(0);
			JoiningProcessLocalServiceUtil.updateJoiningProcess(jp);
			LOGGER.info("The joining status for  JoiningProcess["+formFlowClassPK+"] was updated to 0.");
					
			if(employeePermission!=null){
				employeePermission.setPisAccess(true);
				EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
				LOGGER.info("EmployeePermission pisAccess was updated to 1.");
			}
		}
		
		endTitle = "Completed!";
		endSubTitle = "The joining information has been filled in successfully. <br>Now you can submit for approval!";
	} else if (jp.getProcessStatus() == 1 && !isApprover) {
		endTitle = "Submitted!";
		endSubTitle = "The joining information has already been submitted for approval.";
	} else if (jp.getProcessStatus() == 4 && !isApprover) {
		endTitle = "Correction!";
		endSubTitle = "The joining information was returned for correction. <br>If the correction has already been made, now you can re-submit for approval!";
	} else if (jp.getProcessStatus() == 1 && isApprover) {
		endTitle = "Submitted!";
		endSubTitle = "The joining information has already been submitted for approval. Now you approve the joining request.";
	} 
	
%>


<portlet:renderURL var="joiningListRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/joining_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="processFormRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL> 

<portlet:renderURL var="actionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/employee/joining/joining_list_action.jsp" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL> 

<div class="card mx-5 py-5">
	<div class="card-body text-center">
		<div class="row text-center">
			<div class="col-md-12">
				<h2 class="fs-title text-center"><%=endTitle%></h2>
				<h6><%=endSubTitle%></h6>
			</div>
		</div>

		<div class="row text-center">
			<div class="col-md-12">
				<div class="btn-group my-5">

					<div class="btn-group-item">
						<%
						LOGGER.info("checking why message not coming  "+formFlowClassPK+""+jp.getProcessStatus());
							if (jp!=null && formFlowClassPK != 0) {
								if ((jp.getProcessStatus() == 0 || jp.getProcessStatus() == 4) && !isApprover) {
						%>
							<input type="button" class="btn btn-primary action-button mr-2" value="Submit" id="<portlet:namespace/><%=formFlow.getId() + "submit"%>" />
						<%
								} else if (jp.getProcessStatus() == 1 && isApprover) {
						%>
							<input type="button" class="btn btn-primary action-button mr-2" value="Approve" id="<portlet:namespace/><%=formFlow.getId() + "approve"%>" /> 
							<input type="button" class="btn btn-danger action-button mr-2" value="Reject" id="<portlet:namespace/><%=formFlow.getId() + "reject"%>" />
							<input type="button" class="btn btn-warning action-button mr-2" value="Return" id="<portlet:namespace/><%=formFlow.getId() + "return"%>" />
						<%
								}
							}
						%>
						<input type="button" class="btn btn-secondary action-button" value="Close" id="<portlet:namespace/><%=formFlow.getId() + "close"%>" />

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="liferay-util-window">
	$("#<portlet:namespace/><%=formFlow.getId()%>close").on("click",function(){
		window.location.href="<%=joiningListRenderURL%>";	
	})
	
	$("#<portlet:namespace/><%=formFlow.getId()%>approve").on("click",function(){
		var processStatus=<%=STATUS_APPROVE%>;
		openProcessFormDialog(<%=formFlowClassPK%>, processStatus);
		
		 
	})
	
	$("#<portlet:namespace/><%=formFlow.getId()%>reject").on("click",function(){
		var processStatus=<%=STATUS_REJECT%>;
		joiningFormSubmitRejectAction(<%=formFlowClassPK%>, processStatus);
		
	})
	
	$("#<portlet:namespace/><%=formFlow.getId()%>return").on("click",function(){
		var processStatus=<%=STATUS_RETURN%>;
		openProcessFormDialog(<%=formFlowClassPK%>, processStatus);
		
	})
	
	$("#<portlet:namespace/><%=formFlow.getId()%>submit").on("click",function(){
		
		var processStatus=<%=STATUS_PENDING%>;
		joiningFormSubmitRejectAction(<%=formFlowClassPK%>, processStatus);
		
	})


function openProcessFormDialog(joiningProcessId, processStatus){
	var saveLabel=(processStatus==<%=STATUS_APPROVE%>?"Approve":"Return");
	var formClass=(processStatus==<%=STATUS_APPROVE%>?'<%=PISFormConstant.JOININGPROCESSAPPROVERFORM%>':'<%=PISFormConstant.JOININGPROCESSRETURNFORM%>');
	var title=saveLabel+" - Joining Request";
	var dialogId='<portlet:namespace/><%=formFlow.getId()%>openDialog';
	var url= '<%=processFormRenderURL.toString()%>&<portlet:namespace/>formClassPK='+joiningProcessId;
	url+="&<portlet:namespace/>processStatus="+processStatus;
	url+="&<portlet:namespace/>submit.save.label="+saveLabel;
	url+="&<portlet:namespace/>dialogId="+dialogId;
	url+="&<portlet:namespace/>formClass="+formClass;
	url+="&<portlet:namespace/>unitElementName=unitId";
	url+="&<portlet:namespace/>closeFunc=<portlet:namespace /><%=formFlow.getId()%>closeDialog";
	
	var width = 500;
	var height = 300;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function joiningFormSubmitRejectAction(joiningProcessId,processStatus){
		var dialogId='<portlet:namespace/><%=formFlow.getId()%>openDialog';
		var closeFunc='<portlet:namespace /><%=formFlow.getId()%>closeDialog';
		var url= '<%=actionRenderURL.toString() %>&<portlet:namespace/>formClassPK='+joiningProcessId+'&<portlet:namespace/>formId=<%=formFlow.getId()%>';
		url+='&<portlet:namespace/>dialogId='+dialogId;
		url+='&<portlet:namespace/>closeFunc='+closeFunc;
		url+='&<portlet:namespace/>processStatus='+processStatus;
		var label=(processStatus==<%=STATUS_REJECT%>?"Reject":"Submit");
		var title =label+" - Joining Request";
		var width = 640;
		LiferayUtilOpenWindow(dialogId, title, url, true, 240, true, width);
	
}

Liferay.provide(window,"LiferayUtilOpenWindow", function(id, title, uri, centered, height, modal, width){
	Liferay.Util.openWindow({
		dialog: {
			centered: centered,
			height: height,
			modal: modal,
			width: width
		},
		id: id,
		title: title,
		uri: uri
	});
});
Liferay.provide(
	window,
	'<portlet:namespace /><%=formFlow.getId()%>closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/><%=formFlow.getId()%>openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		window.location.reload();
	},
	['liferay-util-window']
);	
</aui:script>

<%--
<liferay-util:include page="/components/form/multi-step-form-flow.jsp" servletContext="<%=application%>">
	<liferay-util:param name="title" value="<%=title %>"/>
	<liferay-util:param name="subTitle" value="<%=subTitle %>"/>
	<liferay-util:param name="formClass" value="<%=formClass%>" />
</liferay-util:include>
 --%>