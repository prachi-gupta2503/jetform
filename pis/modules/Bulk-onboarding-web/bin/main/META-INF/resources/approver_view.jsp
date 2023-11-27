<%@page import="com.adjecti.pis.dto.RegistrationRequestSearchParameter"%>
<%@page import="com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper"%>
<%@page import="com.adjecti.pis.util.OnboardingUtil"%>
<%@page import="com.adjecti.pis.model.BulkOnbordingFile"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@page import="com.adjecti.pis.util.BulkOnboardUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="./init.jsp"%>

<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:error key="errorUpload" message="Sorry, Admin can upload record for his organization only" />
<liferay-ui:success key="successUpload" message="Record saved successfully!" />
<liferay-ui:error key="actionError" message="There is no valid record to process" />
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
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

<%--For Serial Number --%> 
body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}

<%--tr td:first-child:before {
	counter-increment: Count-Value;
	content: counter(Count-Value);
}--%>

table.dataTable thead th, table.dataTable tfoot th {
    font-weight: 600 !important;
}

th.sorting{
	height:20px;
}
<%--tbdata{width="150px";}--%>
</style>

<%
    long onboardingId = ParamUtil.getLong(request, "bulkOnbordingFileId");

	String search = ParamUtil.getString(request, "search");
	String status = ParamUtil.getString(request, "status");
	long currentOrganization = ParamUtil.getLong(request, "currentOrganization");
	
	List<RegistrationRequestDTO> requestList;
	
	if(search !=null){
		RegistrationRequestSearchParameter registrationRequestSearchParameter = BulkOnboardingViewHelper.getSearchParameter(request);
		requestList = BulkOnboardingViewHelper.getRegistrationRequestList(user, registrationRequestSearchParameter);
	}else{
		requestList = BulkOnboardingViewHelper.getRegistrationRequestList(user);
	}
	
	List<Organization> organizations = OnboardingUtil.getUnitByRoles(user.getUserId());
	
	List<Designation> designations = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,	QueryUtil.ALL_POS);
	List<Trade> trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Grade> grades = GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<String> stateList = BulkOnboardingViewHelper.getRecordsViewStates(user);
	List<String> actionsList = BulkOnboardingViewHelper.getAllowedActions(user);
%>

<portlet:actionURL name="findByOrganization" var="findByOrganizationURL" />
<portlet:actionURL name="approve_registration"	var="approveURL"/>
<portlet:renderURL var="searchRenderUrl"></portlet:renderURL> 

<c:set var="requestList" value='<%=requestList %>' />
<c:set var="currentState" value='<%=status%>' />
<c:set var="organizations" value='<%=organizations%>' />
<c:set var="states" value='<%=stateList%>' />
<c:set var="actions" value='<%=actionsList%>' />
<c:set var="currentOrganization" value='<%=currentOrganization%>' />


<c:set var="errorRecords" value='${requestScope["errorRecords"]}' />

<div id="myModal1" class="upload-registration">
	<div class="modal-content">
		<div>
			<span class="close">&times;</span>
		</div>
		<div title="Dialog box">
			<aui:form name="myForm" action="${approveURL}" >
				<div class="row">
				<div class="col">
					<aui:input type="checkbox"  name="disclaimer" id="disclaimer" cssClass="mb-0"><aui:validator name="required"/></aui:input>
					<span class="mt-0">I confirm that, I have read, understand and agreed to the submission guidelines, 
						policies and submission declaration of the document.</span>
					</div>
				</div>
				<aui:input type="textarea" name="remarks" label="Remark"></aui:input>
				<aui:input type="hidden" name="requestId" id = "requestId"></aui:input>
				<aui:input type="hidden" name="action" id ="currentAction"></aui:input>
				<aui:input type="hidden" name="taskId" id="taskId"></aui:input>
				<aui:button type="submit" value="Submit"></aui:button>
				<aui:button type="cancel" id="cancelBtn" ></aui:button>
			</aui:form>
		</div>
	</div>
</div>
<div class="row">

	<div class="col-md-12">
	<aui:form action="<%=searchRenderUrl%>" name="search-form" id="search-form">
		<div class="card">
		    <div class="card-header bg-primary text-white">
			    <div class="row">
			        <div class="col-md-4">
			            <h3>Bulk Employee Onboarding</h3>
			            <aui:input  name="search" value="search" type="hidden"/>
			        </div>
			        <div class="col-md-8">
							<c:if test="${fn:length(organizations) > 1}">
								<select name="<portlet:namespace/>currentOrganization" class="btn btn-sm btn-secondary float-right">
									<option value="0">Select Unit</option>
									<c:forEach var="organization" items="${organizations}">
										<option value="${organization.organizationId}" ${organization.organizationId == currentOrganization ? 'selected' : ''}>${organization.name}</option>
									</c:forEach>
								</select>
							</c:if>
			        </div>
			    </div>
		    </div>
		    <div class="card-body">
		    
		        	<div class="row">
						<div class="col-md-2">
							<aui:select label="Designation" class="form-control" name="designation">
								<aui:option selected="">Select Designation</aui:option>
								<%
									for (Designation designation : designations) {
								%>
				
								<aui:option value="<%=designation.getDesignationId()%>"><%=designation.getName_En()%></aui:option>
								<%
									}
								%>
				
							</aui:select>
						</div>
						<div class="col-md-2">
				
							<aui:select label="Grade" class="form-control" name="grade">
								<aui:option selected="">Select Grade</aui:option>
								<%
									for (Grade grade : grades) {
								%>
								<aui:option value="<%=grade.getGradeId()%>"><%=grade.getName()%></aui:option>
								<%
									}
								%>
				
							</aui:select>
				
						</div>
						<div class="col-md-2">
							<aui:select label="Trade" class="form-control" name="trade">
								<aui:option selected="">Select Trade</aui:option>
								<%
									for (Trade trade : trades) {
								%>
				
								<aui:option value="<%=trade.getTradeId()%>"><%=trade.getName()%></aui:option>
								<%
									}
								%>
				
							</aui:select>
						</div>
						<div class="col-md-2">
							<span class="aui-search-bar"> <aui:input inlineField="<%=true%>" label="Search Keyword" id="keywords" name="keywords" size="30" title="search-entries" type="text"
									placeholder="Search Keyword" />
							</span>
						</div>
						<div class="col">
							<aui:select label="Status" class="form-control" name="status">
								<option value="">Select All</option>
								<c:if test="${fn:length(states) > 0}">
									<c:forEach var="state" items="${states}">
										<option value="${state}" ${state == currentState ? 'selected' : ''}>${state}</option>
									</c:forEach>
								</c:if>
							</aui:select>
						</div>
						<div class="col-md-2">
							<aui:button type="submit" cssClass="form-control fa fa-search bg-primary text-white mt-4" value="Search"></aui:button>
						</div>
				</div>
		    </div>
		  
		    <div class="card-footer">
			    <div class="row">
					<div class="col-md-12">
					
						<portlet:renderURL var="refreshURL"></portlet:renderURL>
												
						<a class="btn btn-sm btn-secondary" href=${refreshURL} ><liferay-ui:icon  icon="reload" markupView="lexicon" message="Refresh" /></a>
				
						<c:forEach items="${actions}" var="action">
							
						<portlet:renderURL var="actionUrl" >
							<portlet:param name="mvcPath" value="/action_process_view.jsp" />
							<portlet:param name="targetAction" value="${action}" />
						</portlet:renderURL>
						
						<button type="button" cssClass="btn btn-sm btn-primary" onClick='viewActionPage("${action}","${actionUrl}")'>${action} All</button>
							
						</c:forEach>
					</div>
				</div>
		    </div>
		</div>
	</aui:form>
	</div>
	
</div>

<div class="mt-2">
	<table id="userTable" class="display table table-striped nowrap" style="width:100%"	cellspacing="10">
		<thead >
			<tr style="height:20px !important">
				<th >Sr No</th>
				<th >Unit</th>
				<th >Personal No</th>
				<th >Name</th>
				<th >Email Address</th>
				<th >Mobile</th>
				<th >Designation</th>
				<th >Trade</th>
				<th >Grade</th>
				<th >Gender</th>
				<th >Category</th>
				<th >Date Of Birth</th>
				<th >Date Of Joining</th>
				<th >GPF/NPS Type</th>
				<th >GPF/NPS Number</th>
				<th >Section</th>
				<th >Login Id</th>
				<th >Post Box</th>
				<th >Rank</th>
				<th >Updated On</th>
				<th >Status</th>
				<th >Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty requestList}">
				<c:forEach items="${requestList}" var="requestDto" varStatus="loop" >
					<portlet:renderURL var="editEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
						<portlet:param name="mvcPath" value="/edit_entry.jsp" />
						<portlet:param name="registrationId" value="${requestDto.registrationRequestId}" />
					</portlet:renderURL>
					<portlet:renderURL var="detailEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
						<portlet:param name="mvcPath" value="/detail_entry.jsp" />
						<portlet:param name="detailRegistrationId" value="${requestDto.registrationRequestId}" />
					</portlet:renderURL>
					<tr id='${requestDto.registrationRequestId}'>
						<td class="tbdata"> ${loop.count}
							<input type="hidden" id='${requestDto.registrationRequestId}errorRecord'	value="${requestDto.errorMessage }"> 
						</td>
						<td class="tbdata"  id='${requestDto.registrationRequestId}unit'>${requestDto.unit}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}personalNo'>${requestDto.personalNo}</td>
						<td class="tbdata">
							<c:if test="${ not requestDto.editable }">
								<button id='${requestDto.registrationRequestId}name' type="button" class="btn btn-link" style="padding:0"
									onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")'>${requestDto.fullName}
								</button>
							</c:if> 
							<c:if test="${requestDto.editable }">
								<button id='${requestDto.registrationRequestId}name' type="button" class="btn btn-link" style="padding:0"
									onclick='viewActionPopup("${editEntryURL}","Edit registration request","${requestDto.registrationRequestId}","EDIT")'>${requestDto.fullName}</button>
							</c:if>
						</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}email'>${requestDto.emailAddress}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}mobile'>${requestDto.mobile}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}designationName'>${requestDto.designationName}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}trade'>${requestDto.trade}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}grade'>${requestDto.grade}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}genderName'>${requestDto.genderName}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}castCategory'>${requestDto.castCategory}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}dob'><fmt:formatDate pattern = "dd-MM-yyyy" type="both" dateStyle="short" timeStyle="short" value = "${requestDto.dateOfBirth}" /></td>
						<td class="tbdata" id='${requestDto.registrationRequestId}doj'><fmt:formatDate pattern = "dd-MM-yyyy" type="both" dateStyle="short" timeStyle="short" value = "${requestDto.dateOfJoiningUnit}" /></td>
						<td class="tbdata" id='${requestDto.registrationRequestId}gpfnpsType'>${requestDto.gpfnpsType}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}gpfnpsNumber'>${requestDto.gpfnpsNumberView}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}section'>${requestDto.section}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}loginId'>${requestDto.loginId}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}postBox'>${requestDto.postBox}</td>
						<td class="tbdata" id='${requestDto.registrationRequestId}rank'>${requestDto.rank}</td>
						
                        <td><fmt:formatDate pattern = "dd-MM-yyyy HH:mm" type="both" dateStyle="short" timeStyle="short" value = "${requestDto.modifiedDate}" /></td>        
						<td class="tbdata" id='${requestDto.registrationRequestId}status'>${requestDto.status}</td>
						<td class="text-center" >
							<liferay-ui:icon-menu  markupView="lexicon" direction="left-side"   showWhenSingleIcon="<%= true %>">
								<c:if test="${empty requestDto.errorMessage}">
									<c:forEach items="${requestDto.actions}" var="taskAction">
										<c:if test="${requestDto.assignable}">
											<%-- <liferay-ui:icon image="${taskAction}" message="${taskAction}" url="${approveURL}"  /> --%>
										<button type="button" class="btn btn-link" style="color: #6b6c7e;" id="<portlet:namespace/>approveBtn" name="<portlet:namespace />approveBtn" 
												onclick='approverPopup("${requestDto.registrationRequestId}", "${taskAction}","${requestDto.taskId}" )'	>
											<liferay-ui:icon image="submit" message="${taskAction}" />
										</button>
										<br>
										</c:if>
									</c:forEach>
								</c:if>
								<c:if test="${requestDto.editable }">
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" id="<portlet:namespace />edit_btn" name="<portlet:namespace />edit_btn" 
										onclick='viewActionPopup("${editEntryURL}","Edit entry request","${requestDto.registrationRequestId}","EDIT")' >
										<liferay-ui:icon image="edit" message="Edit entry" />
									</button>
									<br>
								</c:if>
								<%-- <liferay-ui:icon image="view" message="View" url="${detailEntryURL}" useDialog="true" /> --%>
								<button type="button" class="btn btn-link"  style="color: #6b6c7e;" name="<portlet:namespace />view_btn" id="<portlet:namespace />view_btn"
									onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")' >
									<liferay-ui:icon image="view" message="View" />
								</button>
							</liferay-ui:icon-menu>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty requestList}">
				<tr id="1">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td style="text-align: center;color: red;">No records to process.</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>

<script>
var recordTable;
$(document).ready( function() {
	recordTable=$('#userTable').DataTable({
	     "pageLength": 250,
	     "scrollX": true, 
	     "lengthMenu": [[10, 25, 50,100,250, -1], [10, 25, 50,100,250, "All"]],
	     fixedColumns:   {
	         leftColumns: 3,
	         rightColumns: 0
	     }
    });
} );


	function errorMessage(errorRecord) {
		var errors = $("#" + errorRecord).val();
		$("#" + errorRecord + "toolTip").tooltip({
			title : errors,
			trigger : 'click'
		});
		$("#" + errorRecord + "toolTip").mouseleave(function() {
			var _this = this;
			$(_this).tooltip('destroy');
		});
	}

	
	function findByOrganization() {
		var x = document.getElementById("organizationId");
		var organizationId = x.options[x.selectedIndex].value
		window.location.href = '${findByOrganizationURL}&<portlet:namespace />organizationId='
				+ organizationId;
	}
	
	function actionConfirm(action) {
		var txt;
		var flag = confirm("Do you want to " + action + " all valid records?");
		return flag;
	}
	
	
	function viewActionPage(action,actionUrl){
		var searchForm = document.getElementById("<portlet:namespace/>search-form");
		$("#<portlet:namespace/>search-form").attr('action', actionUrl);
		$("#<portlet:namespace/>search-form").submit();
		//searchForm.attr('action', actionUrl);
		//searchForm.submit();

	}
	
	function actionPerform(action){
		
		
	/*	Liferay.Util.openWindow({
			dialog: {
    	        centered: true,
    	        height: 600,
    	        modal: true,
    	        width: 800,
    	        cssClass: "ui-model",
    	        destroyOnHide: true,
                resizable: false,
                
    	    },
			id : '<portlet:namespace />dialog',
			title : 'title',
			uri : "${viewRequestByStatusURL}&status"+status
		});
		  Liferay.provide(window, '<portlet:namespace />closePopup', function(popUpId , id) {
	             Liferay.Util.Window.getById(popUpId).destroy();
	             location.reload();
	         },
	         ['liferay-util-window']
	         ); */

	         
	}

	function viewActionPopup(url, title, requestId, mode) {
		Liferay.Util.openWindow({
			dialog : {
				destroyOnHide : true,
				centered : true,
				height : 600,
				cache : false,
				modal : true,
				width : 900,
				cssClass : "ui-model",
				destroyOnHide : true,
				resizable : false,
				on : {
					close : function(event) {
					},
					destroy : function(event) {
						if (editFlag && requestId != 0) {
							getRecordById(requestId);
						}
						if (editFlag && requestId == 0) {
							location.reload();
						}
					}
				}
			},
			id : '<portlet:namespace />dialog',
			title : title,
			uri : url
		})
		
		
	}
	
	function approverPopup(requestId, action, taskId) {
		document.getElementById("<portlet:namespace />requestId").value = requestId;
		document.getElementById("<portlet:namespace />currentAction").value = action;
		document.getElementById("<portlet:namespace />taskId").value = taskId;

		var modalV = document.getElementById("myModal1");
		
		modalV.style.display = "block";
		
	}
	

	var modalV = document.getElementById("myModal1");
	var cancelBtn = document.getElementById("<portlet:namespace/>cancelBtn");
	var span = document.getElementsByClassName("close")[0];

	span.onclick = function() {
		modalV.style.display = "none";
	}
	cancelBtn.onclick = function() {
		modalV.style.display = "none";
	}
	

	window.onclick = function(event) {
		if (event.target == modalV) {
			modalV.style.display = "none";
		}
	}


</script>
	
	
<aui:script>
var editFlag;
	Liferay.provide(window, '<portlet:namespace />closePopUp',
			function(dialogId) {
				var dialog = Liferay.Util.Window.getById(dialogId);
				dialog.destroy();
			}, [ 'liferay-util-window' ]);

	Liferay.provide(window, '<portlet:namespace />isEdit', function(data) {
		editFlag = data;
	}, [ 'liferay-util-window' ]);
</aui:script>


<script>
function getRecordById(requestId) {
		jQuery.ajax({
			type : "POST",
			url : "<portlet:resourceURL />",
			data : ({
				<portlet:namespace/>requestId : requestId,
				<portlet:namespace/>resource : "registrationRequest"

			}),
			success : function(requestDto) {
				
				$("#" + requestDto.registrationRequestId + "errorRecord").val(requestDto.errorMessage);
				
				$("#" + requestDto.registrationRequestId + "unit").html(requestDto.unit);
				$("#" + requestDto.registrationRequestId + "personalNo").html(requestDto.personalNo);
				$("#" + requestDto.registrationRequestId + "name").html(requestDto.fullName);
				$("#" + requestDto.registrationRequestId + "email").html(requestDto.emailAddress);
				$("#" + requestDto.registrationRequestId + "mobile").html(requestDto.mobile);
				
				$("#" + requestDto.registrationRequestId + "designationName").html(requestDto.designationName);
				$("#" + requestDto.registrationRequestId + "trade").html(requestDto.trade);
				$("#" + requestDto.registrationRequestId + "grade").html(requestDto.grade);
				$("#" + requestDto.registrationRequestId + "genderName").html(requestDto.genderName);
				$("#" + requestDto.registrationRequestId + "castCategory").html(requestDto.castCategory);
				var dateOfBirth = getViewDate(requestDto.dateOfBirth);
				$("#" + requestDto.registrationRequestId + "dob").html(dateOfBirth);
				var dateOfJoining = getViewDate(requestDto.dateOfJoiningUnit);
				$("#" + requestDto.registrationRequestId + "doj").html(dateOfJoining);
				$("#" + requestDto.registrationRequestId + "gpfnpsType").html(requestDto.gpfnpsType);
				$("#" + requestDto.registrationRequestId + "gpfnpsNumber").html(requestDto.gpfnpsNumber);
				$("#" + requestDto.registrationRequestId + "section").html(requestDto.section);
				$("#" + requestDto.registrationRequestId + "loginId").html(requestDto.loginId);
				$("#" + requestDto.registrationRequestId + "postBox").html(requestDto.postBox);
				$("#" + requestDto.registrationRequestId + "rank").html(requestDto.rank);
				
				//$("#" + requestDto.registrationRequestId + "status").html(requestDto.status);
				recordTable.fixedColumns().update();
			
			},
			async : false,
		});
	}
function getViewDate(date){
	var today = new Date(date);
	var dd = today.getDate();

	var mm = today.getMonth()+1; 
	var yyyy = today.getFullYear();
	if(dd<10) 
	{
	    dd='0'+dd;
	} 

	if(mm<10) 
	{
	    mm='0'+mm;
	} 
	today = mm+'-'+dd+'-'+yyyy;
	return today;
}
</script>

