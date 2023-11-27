
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDsc"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeDscLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("employee-dsc.jsp");
%>
<portlet:renderURL var="approveRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/custom/employee-dsc-form-alert.jsp" />
</portlet:renderURL>
<%
User loginUser = themeDisplay.getUser();
Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(loginUser.getEmailAddress());
long employeeDscId=0;
try{
EmployeeDsc employeeDsc=EmployeeDscLocalServiceUtil.getEmployeeDscByEmployeeId(employee.getEmployeeId());
employeeDscId=employeeDsc.getEmployeeDscId();
}catch(Exception e)
{
 	LOGGER.info("Employee DSC does not exist");
}

%>
<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=EmployeeDscForm.class.getName()%>" />
	<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeDscId)%>" />
	<liferay-util:param name="employeeId" value="<%=String.valueOf(employee.getEmployeeId())%>" />
	<liferay-util:param name="redirectPage" value="/dsc/employee-dsc.jsp" />
</liferay-util:include>

<aui:script>
function  beforeSubmit<portlet:namespace/>EmployeeDscForm_123456(){
var title ="Employee DSC";
var message ="Are you sure to subscribe?";


showApproveAlert(title, message, false, true);
}

function showApproveAlert(alertTitle, message, error, confirmation){
	var dialogId='<portlet:namespace/>EmployeeDscForm_123456alertDialog';
	
	
	var employeeDscId = $("#<portlet:namespace />employeeDscId").val();
    var employeeId = $("#<portlet:namespace />employeeId").val();
    var ofbDSCRevocationStatus = $("#<portlet:namespace />ofbDSCRevocationStatus").prop('checked');
    var ofbDSCReissueStatus = $("#<portlet:namespace />ofbDSCReissueStatus").prop('checked');
    
    var employeeDsc='&<portlet:namespace/>employeeDscId='+employeeDscId;
    employeeDsc=employeeDsc+'&<portlet:namespace/>employeeId='+employeeId;
    employeeDsc=employeeDsc+'&<portlet:namespace/>ofbDSCRevocationStatus='+ofbDSCRevocationStatus;
    employeeDsc=employeeDsc+'&<portlet:namespace/>ofbDSCReissueStatus='+ofbDSCReissueStatus;
    
	var url= '<%=approveRenderURL %>&<portlet:namespace/>message='+message+'&<portlet:namespace/>error='+error+'&<portlet:namespace/>confirmation='+confirmation+'&<portlet:namespace/>dialogId='+dialogId+'&<portlet:namespace/>formId=EmployeeDscForm_123456'+employeeDsc;
	var title =alertTitle;
	var height = 200;
	var width = 460;
	
	
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
	

}

Liferay.provide(
	window,
	'<portlet:namespace />EmployeeDscForm_123456closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId!=''){
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/>EmployeeDscForm_123456alertDialog');
		}
		dialog.destroy();
		window.location.reload();
	},
	['liferay-util-window']
);

</aui:script>


