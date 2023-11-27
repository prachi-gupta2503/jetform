<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePermission"%>

<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
long employeePermissionId= ParamUtil.getLong(request, "employeePermissionId", 0);
String dialogId= ParamUtil.getString(request, "dialogId");
String closeFunc= ParamUtil.getString(request, "closeFunc");
String instanceId= themeDisplay.getPortletDisplay().getInstanceId(); 
//dialogMode=true;
%>
<div class="container" style="margin-top:25px;">
	<div class="row">
		<div class="col-md-12">
<%
	if(employeePermissionId>=1){
%>		
	<i class="fas fa-exclamation-triangle" style="color:black;"></i>
		Are you sure you want to re-create the user with the following permissions?
		<div class="mt-4">
		
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		    <liferay-util:param name="formClass" value="<%=PISFormConstant.IDAMUSERPERMISSIONFORM %>" />
		   <%--  <liferay-util:param name="formClassPK" value="<%=String.valueOf(employeePermissionId) %>" /> --%>
		</liferay-util:include>
		</div>
<%
	}else{ 
%>		
	<i class="fas fa-exclamation-triangle" style="color:red;"></i>
		No valid request found to re-create the user!
<%
	}
%>	
		</div>
	</div>
	<div class="row">
	<aui:input name="checkAll"  type="checkbox" ></aui:input>
		<div class="col-md-12">
			<div class="form-group-autofit" style="margin-top:25px;">
				<div class="form-group-item">
					<div class="btn-group">
<%
	if(employeePermissionId>=1){
%>				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="button" name="confrimYes" value="Yes" />
						</div>
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="confrimNo" value="No" />
						</div>
<%
	}else{
%>		
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="confrimNo" value="Ok" />
						</div>
<%
	}
%>				
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
    
	$('.card.bg-primary.text-white.mt-2').remove();
	$('.card.form-card').attr('style','100% !important');
	$('hr').remove();
	$('.card').removeClass('card');
	$('#<portlet:namespace/>IDAMUserPermissionForm_123456save').hide();
	$('#<portlet:namespace/>IDAMUserPermissionForm_123456cancel').hide();
	
	$('#<portlet:namespace/>confrimYes').on('click', function(event) {
	
	 
		 recreateUser('<%=employeePermissionId%>'); 
		
	});
	
	$('#<portlet:namespace/>confrimNo').on('click', function(event) {
		closeDialog('<%=dialogId%>');
	});
	
});

function recreateUser(employeePermissionId){

    let  emailAccess = $('#<portlet:namespace/>IDAMUserPermissionForm_123456emailAccess_checkbox').prop('checked');
	let digitalSigning = $('#<portlet:namespace/>IDAMUserPermissionForm_123456digitalSigning_checkbox').prop('checked');
	let eGovAccess = $('#<portlet:namespace/>IDAMUserPermissionForm_123456eGovAccess_checkbox').prop('checked');
	let pisAccess = $('#<portlet:namespace/>IDAMUserPermissionForm_123456pisAccess_checkbox').prop('checked');
	<%
	 EmployeePermission employeePermission=EmployeePermissionLocalServiceUtil.getEmployeePermission(employeePermissionId);
	long registrationRequestId=employeePermission.getRegistrationRequestId();
	if(registrationRequestId>0){
	%>
	recreateUserForRegistrationRequest(<%=registrationRequestId%>,emailAccess,digitalSigning,eGovAccess,pisAccess);
	<%} else {%>
	recreateUserForSingleUserOnboardingAndNewJoining(employeePermissionId,emailAccess,digitalSigning,eGovAccess,pisAccess);	  
		<%} %>	  
}

function recreateUserForRegistrationRequest(registrationRequestId,emailAccess,digitalSigning,eGovAccess,pisAccess){
	Liferay.Service(
			  
	        '/ofb.registrationrequest/create-user-with-permission',
	        
	      {
	      
			    registrationRequestId:registrationRequestId ,
			    
			    emailAccess: emailAccess,
			    
			    digitalSigning: digitalSigning,
			    
			    eGovAccess: eGovAccess,
			    
			    pisAccess: pisAccess
	    
	  },
       function(response) {	  
       
		var refresh=false;
		
		if(response=="success"){
			alert("User created successfully with the selected application permissions.");
			refresh=true;
		}else{
			alert("User creation failed.");
			
		}
		
		closeDialog('<%=dialogId%>', refresh);
		
	}
);
	
	
}

function recreateUserForSingleUserOnboardingAndNewJoining(employeePermissionId,emailAccess,digitalSigning,eGovAccess,pisAccess){
	Liferay.Service(
			  '/pis.employeepermission/update-permission',
			  {
			    employeePermissionId: employeePermissionId,
			    emailAccess: emailAccess,
			    digitalSigning: digitalSigning,
			    eGovAccess: eGovAccess,
			    pisAccess: pisAccess
			  },
			  function(obj) {
				  var refresh=false;
				<%
			boolean idamUserCreated=EmployeePermissionLocalServiceUtil.getEmployeePermission(employeePermissionId).getIdamUserCreated();
				
				%>
					if(<%=idamUserCreated%>){
						alert("User created successfully with the selected application permissions.");
						refresh=true;
					}else{
						alert("User creation failed.");
						
					}
					
					closeDialog('<%=dialogId%>', refresh);
					
				}
			  
			);

	
}

function closeDialog(dialogId, refresh){

	var data = {
		"dialogId" : dialogId,
		"refresh" : refresh
	};
	
	Liferay.Util.getOpener().<%=closeFunc%>(data);
	
}

console.log(<portlet:namespace/>IDAMUserPermissionForm_123456pisAccess);
$("#<portlet:namespace/>IDAMUserPermissionForm_123456pisAccess_checkbox").prop( "checked", true );
$("#<portlet:namespace/>IDAMUserPermissionForm_123456pisAccess_checkbox").prop("disabled", true);
$("#<portlet:namespace/>checkAll").on('click',function(){

let isChecked = $('#<portlet:namespace/>checkAll').prop('checked');
if(isChecked){
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456emailAccess_checkbox").prop("checked", true); 
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456digitalSigning_checkbox").prop("checked", true); 
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456eGovAccess_checkbox").prop("checked", true); 
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456pisAccess_checkbox").prop("checked", true); 
 
  } else {
   $("#<portlet:namespace/>IDAMUserPermissionForm_123456emailAccess_checkbox").prop("checked", false); 
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456digitalSigning_checkbox").prop("checked", false); 
  $("#<portlet:namespace/>IDAMUserPermissionForm_123456eGovAccess_checkbox").prop("checked", false); 
  
  }
});

</script>