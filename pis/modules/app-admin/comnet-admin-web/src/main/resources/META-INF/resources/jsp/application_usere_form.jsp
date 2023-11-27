<%@page import="net.ayudh.comnet.admin.constants.MVCCommandNames"%>
<%@include file="../init.jsp" %>
<div class="container mt-1">
	<div>
		<portlet:actionURL name="updateApplicationUser" var="comnetAdminActionUrl"></portlet:actionURL>
		<div class="container">
		<%-- 	<div class="card" hidden>
        		<div class="card-header">Current Permission</div>
        		<div class="card-body">
					<div class="row">
								<c:if test="${applicationUserDto.idamUser}">
									<h5 class="mr-2 ml-3">IdamUser</h5>
								</c:if>
								<c:if test="${applicationUserDto.emailAccess}">	
									<h5 class="mr-2 ml-3">Email Access</h5>
								</c:if>
								<c:if test="${applicationUserDto.digitalSigning}">
									<h5 class="mr-2 ml-3">Digital Signing</h5>
								</c:if>
								<c:if test="${applicationUserDto.eGovAccess}">
									<h5 class="mr-2 ml-3">eGov Access</h5>
								</c:if>
								<c:if test="${applicationUserDto.pisAccess}">
									<h5 class="mr-2 ml-3">Pis Access</h5>
								</c:if>			
					</div>	
				</div>
			</div>		 --%>
			<div class="card">
        		
        		<div class="card-body pb-0 pl-5 pr-5" >
					<aui:form action=""  method="post" name="<portlet:namespace />applicationUserForm">
						
						
						<aui:input lable="" id="applicationUserId" name="applicationUserId" type="hidden" value="${applicationUserDto.applicationUserId}"/>
						<div class="row">
							<div class="col-sm-6">
								<c:if test = "${applicationUserDto.idamUser==false}">       	
									<aui:row>
										<aui:input type="checkbox" id="idamUser" name="idamUser" label="" value="${applicationUserDto.idamUser}" onClick="checkBoxEditable()" />
										<h5 class="mr-2 ml-3">IdamUser</h5>
									</aui:row>
								</c:if>	
								<c:if test = "${applicationUserDto.idamUser==true}">       	
									<aui:row>
										<aui:input lable="" id="idamUser" name="idamUser" type="hidden" value="${applicationUserDto.idamUser}"/>
									</aui:row>
								</c:if>	
							</div>
							<div class="col-sm-6">
							</div>
							<hr/>
						</div>
						<div class="row mt-2"></div>
						
						
						
						
						<div class="row">
							<div class="col-sm-6">
				
								<aui:row>
									<aui:input type="checkbox" id="emailAccess" class="chkBox" name="emailAccess" label="" value="${applicationUserDto.emailAccess}"/>	
									<h5 class="mr-2 ml-3 ">Email Access</h5>
								</aui:row>
								<aui:row>
									<aui:input type="checkbox" id="digitalSigning" class="chkBox" name="digitalSigning" label="" value="${applicationUserDto.digitalSigning}"/>
									<h5 class="mr-2 ml-3">Digital Signing</h5>
								</aui:row>
							</div>
							<div class="col-sm-6">
								<aui:row>	
									<aui:input type="checkbox" id="eGovAccess" class="chkBox" name="eGovAccess" label="" value="${applicationUserDto.eGovAccess}"/>
									<h5 class="mr-2 ml-3">eGov Access</h5>
								</aui:row>
								<aui:row>
									<aui:input type="checkbox" id="pisAccess" class="chkBox" name="pisAccess" label="" value="${applicationUserDto.pisAccess}"/>
									<h5 class="mr-2 ml-3">Pis Access</h5>
								</aui:row>
							</div> 		
						</div>
						<aui:button-row>
							<aui:button type="submit" value="submit" name="submit" onclick="javascript:submitApplicationUserForm();"></aui:button>
						</aui:button-row>
					</aui:form>
        		</div>
     		</div>
     <%-- 		<div>
     		<c:if test = "${applicationUserDto.idamServiceStatus}">
				<h4>Idam Service Status: <b style=color:green;>Success</b></h4>
			</c:if>
			<c:if test = "${!applicationUserDto.idamServiceStatus}">
				<h4>Idam Service Status: <b style=color:red;>Fail</b></h4>				
			</c:if>
			<c:if test = "${!applicationUserDto.idamServiceStatus}">
				<div class="alert alert-danger" role="alert">
  					<h4 class="alert-heading">Error !</h4>
  					<p> ${applicationUserDto.idamServiceMessage}</p>
				</div>					
			</c:if>
		</div> --%>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#<portlet:namespace/>idamUser").prop('checked', true);
	
})
function checkBoxEditable(){
	idamUser=$("#<portlet:namespace/>idamUser").is(":checked");
	if(idamUser){
		$("#<portlet:namespace/>emailAccess").removeAttr('disabled');
		$("#<portlet:namespace/>digitalSigning").removeAttr('disabled');
		$("#<portlet:namespace/>eGovAccess").removeAttr('disabled');
		$("#<portlet:namespace/>pisAccess").removeAttr('disabled');
	}
	else{
		$("#<portlet:namespace/>emailAccess").prop('checked', false);
		$("#<portlet:namespace/>digitalSigning").prop('checked', false);
		$("#<portlet:namespace/>eGovAccess").prop('checked', false);
		$("#<portlet:namespace/>pisAccess").prop('checked', false);
		
		$("#<portlet:namespace/>emailAccess").attr('disabled', true);
		$("#<portlet:namespace/>digitalSigning").attr('disabled', true);
		$("#<portlet:namespace/>eGovAccess").attr('disabled', true);
		$("#<portlet:namespace/>pisAccess").attr('disabled', true);
	}
}
function submitApplicationUserForm()
{	
	var applicationUserId=$("#<portlet:namespace/>applicationUserId").val();
	var idamUserTxt=$("#<portlet:namespace/>idamUser").val();
	var idamUserChk=$("#<portlet:namespace/>idamUser").is(":checked");
	var emailAccess=$("#<portlet:namespace/>emailAccess").is(":checked");
	var digitalSigning=$("#<portlet:namespace/>digitalSigning").is(":checked");
	var eGovAccess=$("#<portlet:namespace/>eGovAccess").is(":checked");
	var pisAccess=	$("#<portlet:namespace/>pisAccess").is(":checked");
	var idamUser;
	if(idamUserTxt){
		idamUser=true;
	}
	if(idamUserChk){
		idamUser=true;
	}
	var url= "<%=comnetAdminActionUrl%>&<portlet:namespace/>applicationUserId="+applicationUserId+"&<portlet:namespace/>idamUser="+idamUser+"&<portlet:namespace/>emailAccess="+emailAccess+"&<portlet:namespace/>digitalSigning="+digitalSigning+"&<portlet:namespace/>eGovAccess="+eGovAccess+"&<portlet:namespace/>pisAccess="+pisAccess;
	$.get(url,function(){

	})
}
</script>
