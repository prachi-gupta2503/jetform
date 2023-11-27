<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.model.SingleUserOnboarding"%>
<%@page import="com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
String formClass = ParamUtil.getString(request, "formClass");
long formClassPK = ParamUtil.getLong(request, "formClassPK", 0);
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formClass);
String dialogId= ParamUtil.getString(request, "dialogId");
String closeFunc= ParamUtil.getString(request, "closeFunc");
int processStatus = ParamUtil.getInteger(request, "status", 0);
%>
<%
Employee employee=null;
boolean duplicatePersonalNo=false;

if(processStatus==2){
SingleUserOnboarding singleUserOnboarding=SingleUserOnboardingLocalServiceUtil.getSingleUserOnboarding(formClassPK);
 employee=EmployeeLocalServiceUtil.getEmployeeByPersonalNo(String.valueOf(singleUserOnboarding.getPersonalNo()));
 if(employee!=null){
 boolean isDuplicateUnitId=employee.getOrganizationId()==singleUserOnboarding.getUnitId()?true:false;
 boolean isDuplicatePersonalNo=employee.getPersonalNo().equalsIgnoreCase(Long.toString(singleUserOnboarding.getPersonalNo()))?true:false;
	 if(isDuplicateUnitId && isDuplicatePersonalNo){
		 duplicatePersonalNo=true;
	 }
	 
 }
}
%>
<div class="container" style="margin-top:25px;">
	<div class="row">
		<div class="col-md-12">
<%
	if(processStatus==0 ||processStatus== 1){
%>		
	<i class="fas fa-exclamation-triangle" style="color:black;"></i>
		Are you sure you want to sent request for approve this SingleUserOnboarding Request ?
<%
	}else if(processStatus==2){
%>			
	<i class="fas fa-exclamation-triangle" style="color:black;"></i>
		Are you sure you want to  approved this SingleUserOnboarding Request ?
<%
	}else{
%>				
	<i class="fas fa-exclamation-triangle" style="color:red;"></i>
		Are you sure you want to reject this SingleUserOnboarding Request ?
<%
	}
%>	
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="form-group-autofit" style="margin-top:25px;">
				<div class="form-group-item">
					<div class="btn-group">
				
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="button" name="deleteYes" value="Yes" />
						</div>
						<div class="btn-group-item">
							<aui:button cssClass="btn btn-primary" type="reset" name="deleteNo" value="No" />
						</div>
			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<aui:script>
$(document).ready(function() {
	
	$('#<portlet:namespace/>deleteYes').on('click', function(event) {
	if(<%=!duplicatePersonalNo %>){
		updateStatus(<%=formClassPK %>, <%=processStatus%>)
		}else{
		closeDialog('<%=dialogId%>', "  Duplicate Personal No !! Please enter again ", false, false);
		}
	});
	
	$('#<portlet:namespace/>deleteNo').on('click', function(event) {
		closeDialog('<%=dialogId%>');
	});
});

function updateStatus(singleuseronboardingId, status){
				Liferay.Service(
                    '/pis.singleuseronboarding/update-status-by-single-user-onboarding-id',
                              {
                             SingleUserOnboardingId:singleuseronboardingId ,
                                             status: status
                              },
		function(response) {	
		
			var message=response;
			var error=false;
			var refresh=true;
			if(response=="failure"){
				message=" failed !! ";
				error=true;
				refresh=false;
			}else{
				message=(status==1?"Request for approval has been sent successfully.":(status==2?"SingleUserOnboarding Request has been approved successfully.":"SingleUserOnboarding Request has been rejected."));
				refresh=true;
			}
			
			closeDialog('<%=dialogId%>', message, error, refresh);
		}
	);	
}

function closeDialog(dialogId, message, error, refresh){
	var data = {
		"dialogId" : dialogId,
		"message" : message,
		"error" : error,
		"refresh" : refresh
	};
<%
	if(StringUtils.isNotBlank(closeFunc)){
%>	
		Liferay.Util.getOpener().<%=closeFunc%>(data);
<%
	}else{
%>	
		Liferay.Util.getOpener().<portlet:namespace/><%=form.getId()%>closeDialog(data);
<%
	}
%>		
}

</aui:script>