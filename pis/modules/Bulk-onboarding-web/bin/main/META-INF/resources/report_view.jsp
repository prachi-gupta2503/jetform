<%@page import="com.adjecti.onboarding.web.constants.BulkOnboardingFormConstant"%>
%@page import="com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper"%>
<%@page import="com.adjecti.onboarding.web.portlet.DocumentMgtmt"%>
<%@page import="com.adjecti.pis.util.OnboardingUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.onboarding.web.dto.BulkOnboardingRecordDTO"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp"%>
<%
	String dateError = "Date format error";
	if(request.getAttribute("dateError")!=null){
		dateError=(String)request.getAttribute("dateError");
	}
%>

<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:success key="entryDeleted" message="entry-deleted" />
<liferay-ui:error key="errorUpload" message="Please uploaded data of correct unit" />
<liferay-ui:error key="unitNotMatchError"  message="Sorry data not matched with unit " />
<liferay-ui:success key="successUpload" message="Document saved successfully!" />
<liferay-ui:error key="actionError"	message="There is no valid record to process" />
<liferay-ui:error key="organizationNotFound" message="Sorry, Unit not mentioned in file" />
<liferay-ui:error key="errorUploadMultipleUnits" message="Sorry, Data of multiple units found in file" />
<liferay-ui:error key="errorInvalidRecords" message="Sorry, Invalid records found in sheet" />
<liferay-ui:error key="errorCharacterLength" message="Sorry, You are exceeding the limit of characters in data" />
<liferay-ui:error key="errorRequiredRecord" message="Please fill mandatory fields" />
<liferay-ui:error key="errorDateFormat" message="<%=dateError %>"/>

<style>

/* The Modal (background) */
.upload-registration {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	/*padding: 20px;*/
	border: 1px solid #888;
	/*width: 80%;*/
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 20px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

<%--
For Serial Number --%> body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}

tr td:first-child:before {
	counter-increment: Count-Value;
	content: counter(Count-Value);
}

.total-card{
	background-color:#6e65dd;
}
.approved-card{
	background-color:#02b061;
}
.rejected-card{
	background-color:#f39c12;
}
.deleted-card{
	background-color:#d95452;
}
.pending-card{
	background-color:#828a91;
}


.modal-header {
	height: 3.5rem !important;
	padding: 1rem !important;
}

.modal-header .modal-title {
	font-size: 1.1rem !important;
	font-weight: 500px !important;
}

.bulk-header .bulk-actions .bullet{
	padding:3px 10px;
	border-radius: 15px;
}

.bg-blue{
	border: 1px solid #00aaff; 
	background-color:#00aaff;
}
.bg-pink{
	border: 1px solid #9955dd; 
	background-color:#9955dd;
}

.bg-green{
	border: 1px solid #55dd66; 
	background-color:#55dd66;
}

</style>


<% 
List<BulkOnboardingRecordDTO> bulkOnboardingRecords =  BulkOnboardingViewHelper.getBulkOnboardingRecordsByUserId(user.getUserId());
pageContext.setAttribute("bulkOnboardingRecords", bulkOnboardingRecords);  
long totalUploads = bulkOnboardingRecords.size();
long totalRecords = bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalRecords()).sum();
long totalApproved = bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalApprovedRecords()).sum();
long totalRejected = bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalRejectedRecords()).sum();
long totalPending = bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalPendingRecords()).sum();
long totalDeleted = bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalDeletedRecords()).sum();
List<Organization> organizations = OnboardingUtil.getUnitByRoles(themeDisplay.getUserId());

String templateUrl=DocumentMgtmt.genrateDownloadLink(themeDisplay);


%>
<portlet:renderURL var="importSectionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp"/>
	<portlet:param name="formClass" value="<%=BulkOnboardingFormConstant.SECTIONIMPORTFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
 
<portlet:renderURL var="importSectionMappingRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=BulkOnboardingFormConstant.SECTIONMAPPINGIMPORTFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:actionURL var="uploadFile" name="ubload_onboarding_file"></portlet:actionURL>
		
<%@include file="/upload_registration_model.jsp"%>

<div class="card">
 	<div class="card-header bg-primary bulk-header">
		<div class="row">
			<div class="col-md-4 text-white">
				<strong>Bulk Onboarding</strong>
			</div>
			<div class="col-md-8">
				<div class="float-right bulk-actions">
					<button id="<portlet:namespace/>uploadSection" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-blue">1</span>Sections</button>
					<button id="<portlet:namespace/>uploadBtn" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-pink">2</span>Employees</button>
					<button id="<portlet:namespace/>uploadSectionMapping" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-green">3</span>Section Mappings</button>
	
<% if (!templateUrl.equals("not found")){ %>
				<a class="btn btn-sm btn-primary float-right mb-2" href="<%=templateUrl%>"><i class="fa fa-download mr-1" style="color:#fff;" aria-hidden="true"></i>Download Template</a>

<% } %>				
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header bg-primary">
  				<p class="card-text h4 text-white" style="">Total Uploads<br></p>
  			</div>
    		<div class="card-body text-center">
      			<p class="h2"><%= totalUploads %></p>
    		</div>
  		</div>
	</div>
  	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header total-card">
  				<p class="card-text h4 text-white">Total Records<br></p>
  			</div>
    		<div class="card-body text-center">
    			<p class="h2"><%= totalRecords %></p>
    		</div>
  		</div>
  	</div>
  	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header appeoved-card" style="background-color:#02b061;">
  				<p class="card-text h4 text-white">Total Approved<br></p>
  			</div>
    		<div class="card-body text-center">
    			<p class="h2"><%= totalApproved %></p>
    		</div>
  		</div>
  	</div>
  	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header rejected-card" style="background-color:#eb9710;">
  				<p class="card-text h4 text-white">Total Rejected<br></p>
  			</div>
    		<div class="card-body text-center">
    			<p class="h2"><%= totalRejected %></p>
    		</div>
  		</div>
  	</div>
  	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header pending-card">
  				<p class="card-text h4 text-white">Total Pending<br></p>
  			</div>
    		<div class="card-body text-center">
    			<p class="h2"><%= totalPending %></p>
    		</div>
  		</div>
  	</div>
  	<div class="col-md-2">
  		<div class="card">
  			<div class="card-header deleted-card">
  				<p class="card-text font-weight-bold h4 text-white">Total Deleted<br></p>
  			</div>
    		<div class="card-body text-center">
    			<p class="h2"><%= totalDeleted %></p>
    		</div>
  		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<table
			id="userTable" class="display table table-striped" cellspacing="0" width="100%">
			<thead>
				<tr>
				    <th>Sr no.</th>
					<th>Uploaded By</th>
					<th>Title</th>
					<th>Remarks</th>
					<th>Upload Date</th>
					<th>Total Records</th>
					<th>Approved Records</th>
					<th>Rejected Records</th>
					<th>Deleted Records</th>
					<th>Pending Records</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bulkOnboarding" items="${bulkOnboardingRecords}">
					<portlet:renderURL var="viewRequestsURL">
						<portlet:param name="bulkOnbordingFileId" value="${bulkOnboarding.onboardingId}" />
						<portlet:param name="mvcPath" value="/record_list_view.jsp" />
						 <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/> 
					</portlet:renderURL>
				
					<tr>
					    <td></td>
						<td>${bulkOnboarding.userName}</td>
						<td><a href="<%=viewRequestsURL.toString()%>">${bulkOnboarding.tittle}</a></td>
						<c:choose>
						  <c:when test="${fn:length(bulkOnboarding.remarks) gt 40}">
						   <c:set var="shortRemark" value="${fn:substring(bulkOnboarding.remarks, 0, 40)}" />
						   <td title="${bulkOnboarding.remarks}">${shortRemark}...</td>
						  </c:when>
						  <c:otherwise>
						    <td>${bulkOnboarding.remarks}</td>
						  </c:otherwise>
						</c:choose>
						<td><span style="display:none;"><fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${bulkOnboarding.createDate}" /></span><fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value = "${bulkOnboarding.createDate}" /></td>
						<td>${bulkOnboarding.totalRecords}</td>
						<td>${bulkOnboarding.totalApprovedRecords}</td>
						<td>${bulkOnboarding.totalRejectedRecords}</td>
						<td>${bulkOnboarding.totalDeletedRecords}</td>
						<td>${bulkOnboarding.totalPendingRecords}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<aui:script>

$(document).ready(function() {
	var table=$('#userTable').DataTable({
     "pageLength": 10,
     "aaSorting": [[4, 'desc']]
    });
    
	$('#<portlet:namespace/>uploadSection').click(function(e){
		var dialogId='<portlet:namespace/>importDialog';
		var title='Upload Sections';
		var url='<%=importSectionRenderURL.toString()%>&<portlet:namespace />cancelFunc=<portlet:namespace />closeDialog&<portlet:namespace />dialogId='+dialogId;
		LiferayUtilOpenWindow(dialogId, title, url, true, 300, true, 900);
	})
	
	$('#<portlet:namespace/>uploadSectionMapping').click(function(e){
		var dialogId='<portlet:namespace/>importDialog';
		var title='Upload Sections Mapping';
		var url='<%=importSectionMappingRenderURL.toString()%>&<portlet:namespace />cancelFunc=<portlet:namespace />closeDialog&<portlet:namespace />dialogId='+dialogId;
		LiferayUtilOpenWindow(dialogId, title, url, true, 300, true, 900);
	})
});

function LiferayUtilOpenWindow(id, title, uri, centered, height, modal, width){
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
}

Liferay.provide(
	window,
	'<portlet:namespace />closeDialog',
	function(data) {
		
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById(data.dialogId);
		dialog.destroy();
	},
	['liferay-util-window']
);	
</aui:script>