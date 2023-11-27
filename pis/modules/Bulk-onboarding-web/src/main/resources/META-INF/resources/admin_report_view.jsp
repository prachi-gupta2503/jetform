<%@page import="com.adjecti.onboarding.web.constants.BulkOnboardingFormConstant"%>
<%@page import="com.adjecti.onboarding.web.portlet.DocumentMgtmt"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.pis.util.OnboardingUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.adjecti.pis.model.BulkOnbordingFile"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil"%>
<%@page import="com.adjecti.onboarding.web.dto.UnitOnboardingSummary"%>
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
<liferay-ui:success key="successUpload" message="Document uploaded successfully!" />
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
For Serial Number --%> 
body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}

tr td:first-child:before {
	counter-increment: Count-Value;
	content: counter(Count-Value);
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

.has-search .form-control {
    padding-left: 2.375rem;
}

.has-search .form-control-feedback {
    position: absolute;
    z-index: 2;
    display: block;
    width: 2.375rem;
    height: 2.375rem;
    line-height: 2.375rem;
    text-align: center;
    pointer-events: none;
    color: #aaa;
}
</style>

<%
	List<UnitOnboardingSummary> unitOnboardingSummaryList = BulkOnboardingViewHelper.getOnboardingSummary(user.getUserId());
	List<Organization> organizations = OnboardingUtil.getUnitByRoles(user.getUserId());
	
	String templateUrl=DocumentMgtmt.genrateDownloadLink(themeDisplay);
%>

<%@ include file="/upload_registration_model.jsp"%>

<portlet:renderURL var="openRecordRequestURL">
    <portlet:param name="mvcPath" value="/uploads_view.jsp" />
    <portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>" />
</portlet:renderURL>

<portlet:renderURL var="importSectionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp"/>
	<portlet:param name="formClass" value="<%=BulkOnboardingFormConstant.SECTIONIMPORTFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
 
<portlet:renderURL var="importSectionMappingRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=BulkOnboardingFormConstant.SECTIONIMPORTFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>
           
<div class="card">
	<div class="card-header bg-primary text-white bulk-header">
		<div class="row">
			<div class="col-md-2">
				<h4>Bulk Onboarding</h4>
			</div>
			<div class="col-md-4">
				<div class="form-group has-search">
					<span class="fa fa-search form-control-feedback"></span>
					<input type="text" class="form-control" id="txt-search"
						placeholder="Search a unit">
					<%--div class="input-group-append">
						<button class="btn btn-secondary" type="button">
							<i class="fas fa-search"></i>
						</button>
					</div --%>
				</div>
			</div>
					
			<div class="col-md-6">
				<div class="float-right bulk-actions">
					<button id="<portlet:namespace/>uploadSection" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-blue">1</span>Sections</button>
					<button id="<portlet:namespace/>uploadBtn" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-pink">2</span>Employees</button>
					<button id="<portlet:namespace/>uploadSectionMapping" class="btn btn-sm btn-primary mb-2 mr-2"><i class="fa fa-cloud-upload mr-1" style="color:#fff;" aria-hidden="true"></i><span class="mr-1 bullet bg-green">3</span>Section Mappings</button>
				<% if (!templateUrl.equals("not found")){ %>
					<a class="btn btn-sm btn-primary float-right mb-2" href="<%=templateUrl%>"><i class="fa fa-download mr-1" style="color:#fff;" aria-hidden="true"></i>Download Template</a>
					<%	} 
					String[] superadmin={"SUPER ADMIN"};
					boolean isSuperAdmin = RoleLocalServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(), superadmin, true);
					
					if(isSuperAdmin)
					{%>
						<portlet:actionURL name="delete_all_records" var="deleteUrl" ></portlet:actionURL>
						<a class="btn btn-sm btn-primary float-right" href="<%=deleteUrl%>" onclick="return confirm('Are you sure to delete?')">Delete all records</a>
					<%}%>
					
				</div>
			</div>
		</div>
	</div>
</div>
<%--
<div class="row">
	<div class="col-md-12">
		<div id="ajaxGetUserServletResponse"></div>
		<div class="search-container" style="margin-top:20px; margin-bottom:20px; width:50% !important;">
			<div class="input-group text-right">
		
				<input type="text" class="form-control" id="txt-search"
					placeholder="Search units">
				<div class="input-group-append">
					<button class="btn btn-secondary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
</div> --%>
<div id="filter-records" class="row">
	No units avaliable.
<%--
	<c:forEach items="<%=unitOnboardingSummaryList%>" var="unitOnboardingSummary">
		
		   <div class="col-sm-3">
		   <a href="${openRecordRequestURL.toString()}&<portlet:namespace/>unitId=${unitOnboardingSummary.unitId}" style="text-decoration: none;color: black;">
		      <div class="card">
				<div class="card-header bg-primary text-white">${unitOnboardingSummary.unitName}</div>
				<div class="card-body">
					<p class="card-text my-0">Total Files Uploaded :
						${unitOnboardingSummary.totalUploads }</p>
					<p class="card-text my-0">Total Records :
						${unitOnboardingSummary.totalRecords }</p>
					<p class="card-text my-0">Total Approved Records :
						${unitOnboardingSummary.totalApprovedRecords}</p>
					<p class="card-text my-0">Total Pending Records :
						${unitOnboardingSummary.totalPendingRecords}</p>
					<p class="card-text my-0">Total Deleted Records :
						${unitOnboardingSummary.totalDeletedRecords}</p>
				</div>
			 </div>
		   </a>
		</div>
	</c:forEach>
 --%>	
</div>

<aui:script>
$(document).ready(function() {
	
	var menuItems=initMenuItem();
	renderMenu(menuItems);
	$('#txt-search').keyup(function(){
		
        let searchField = $(this).val();
        let regex = new RegExp(searchField, "i");
		if(searchField === '')  {
			renderMenu(menuItems);
			return;
		}

		var menuFilterList=[]; 
		var ctr=0;
		$.each(menuItems, function(index, item){
				  
			if (((item.name.search(regex) != -1))) {
				menuFilterList[ctr++]=item;
			}
		});
		renderMenu(menuFilterList);
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

<script>

function initMenuItem(){
	var menuItems =[];
<%
	int ousCtr=0;
	for(UnitOnboardingSummary uos:unitOnboardingSummaryList){
%>
		menuItems[<%=ousCtr++%>]={"unitId":"<%=uos.getUnitId()%>", "name":"<%=uos.getUnitName()%>","files":"<%=uos.getTotalUploads()%>","records":"<%=uos.getTotalRecords()%>","approved":"<%=uos.getTotalApprovedRecords()%>", "pending":"<%=uos.getTotalPendingRecords()%>", "deleted":"<%=uos.getTotalDeletedRecords()%>"};
<%
	}
%>
	return menuItems;
}

function renderMenu(menuRenderList){
	console.log("renderMenu called");
	console.log(menuRenderList);
	var source = $('#menu-cta-template').html();
	var template = Handlebars.compile(source);
	var resultHtml = template(menuRenderList);

	$("#filter-records").html(resultHtml);
}
</script>

<script type="text/x-handlebars-template" id="menu-cta-template">	
	{{#each []}}
		<div class="col-sm-3">
			<a href="${openRecordRequestURL.toString()}&<portlet:namespace/>unitId={{unitId}}" style="text-decoration: none;color: black;">
				<div class="card">
					<div class="card-header bg-primary text-white"><h5>{{name}}</h5></div>
					<div class="card-body">
						<p class="card-text my-0">Total Files Uploaded :
							{{files}}</p>
						<p class="card-text my-0">Total Records :
							{{records}}</p>
						<p class="card-text my-0">Total Approved Records :
							{{approved}}</p>
						<p class="card-text my-0">Total Pending Records :
							{{pending}}</p>
						<p class="card-text my-0">Total Deleted Records :
							{{deleted}}</p>
					</div>
				</div>
			</a>
		</div>
	{{/each}}
</script>
