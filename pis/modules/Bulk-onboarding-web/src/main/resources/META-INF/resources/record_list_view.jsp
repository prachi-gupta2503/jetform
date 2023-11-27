<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper"%>
<%@page import="com.adjecti.pis.dto.RegistrationRequestSearchParameter"%>
<%@page import="com.adjecti.pis.util.OnboardingUtil"%>
<%@page import="com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil"%>
<%@page import="com.adjecti.pis.model.BulkOnbordingFile"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil"%>
<%@page	import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@page import="com.adjecti.pis.util.BulkOnboardUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="./init.jsp"%>
<style>

/* The Modal (background) */
.upload-registration {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 0px; /* Location of the box */
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
	padding: 0px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	cursor: context-menu;
	color: #aaaaaa;
	float: right;
	font-size: 10px;/* font-size: 28px; */
	/* font-weight: bold; */
	text-align: center;
}


.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	/* cursor: pointer; */
}

<%--For Serial Number --%> 
body {
	counter-reset: Count-Value;
}

table {
	border-collapse: separate;
}
th.sorting{
	height:20px;
}

</style>

<%  
	long bulkOnbordingFileId = ParamUtil.getLong(request, "bulkOnbordingFileId");
	System.out.println(bulkOnbordingFileId);
	boolean showScroll = false;

	BulkOnbordingFile bulkOnboarding = 	BulkOnbordingFileLocalServiceUtil.getBulkOnbordingFile(bulkOnbordingFileId);
	boolean hasOwnerRole = RegistrationRequestLocalServiceUtil.hasOwnerRole(user.getUserId(), user.getCompanyId());
	
	String search = ParamUtil.getString(request, "search");
	String status = ParamUtil.getString(request, "status");
	long currentOrganization = ParamUtil.getLong(request, "currentOrganization");
	
	List<RegistrationRequestDTO> requestList;
	
	if(StringUtils.isNotBlank(search)){
		RegistrationRequestSearchParameter registrationRequestSearchParameter = BulkOnboardingViewHelper.getSearchParameter(request);
		requestList = BulkOnboardingViewHelper.getRegistrationRequestList(user, registrationRequestSearchParameter);
	}else{
		requestList = BulkOnboardingViewHelper.getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
	}
	
	String backURL = ParamUtil.getString(request, "backURL");
	
	List<Designation> designations = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,	QueryUtil.ALL_POS);
	List<Trade> trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Grade> grades = GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<String> stateList = BulkOnboardingViewHelper.getRecordsViewStates(user);
	List<String> actionsList = BulkOnboardingViewHelper.getAllowedActions(user);
%>

<%if(backURL==null || backURL.equals("")){%>
		<portlet:renderURL var="backPageURL"/>
<%}else{ %>
		<c:set var="backPageURL" value='<%=backURL %>'/>
<%} %>
	
<c:set var="requestList" value='<%=requestList %>'/>
<c:set var="currentState" value='<%=status%>' />
<c:set var="states" value='<%=stateList%>' />
<c:set var="actions" value='<%=actionsList%>' />
<c:set var="bulkOnbordingFileId" value='<%=bulkOnbordingFileId %>'/>

<c:set var="submitAllStatus" value='false' />

<c:set var="errorRecords" value='${requestScope["errorRecords"]}' />

<portlet:renderURL var="searchRenderUrl">
	<portlet:param name="mvcPath" value="/record_list_view.jsp" />
</portlet:renderURL> 

<portlet:actionURL name="deleteAll" var="deleteAll">
	<portlet:param name="bulkOnbordingFileId" value="${bulkOnbordingFileId}" />
	<portlet:param name="mvcPath" value="/record_list_view.jsp" />
</portlet:actionURL>

<div class="card">
	<div class="card-header bg-primary text-white">
		<div class="row">
  				<div class="col-md-8 text-white">
  					<strong>Bulk onboarding details of:  <%=bulkOnboarding.getTitle() %></strong>
  				</div>
			</div>
	</div>
	<aui:form action="<%=searchRenderUrl%>" name="search-form" id="search-form">
	<div class="card-body">
		<div class="row">
			<div class="col-md-2">
				<aui:input  name="search" value="search" type="hidden"/>
				<aui:input name="bulkOnbordingFileId" type="hidden" value="<%=bulkOnbordingFileId%>" />
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
			<div class="col-md-2">
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
	</aui:form>
	<div class="card-footer">
		<div class="row">
			<div class="col-md-12">
				
				
				<a href=${backPageURL} class="btn btn-sm btn-secondary"><liferay-ui:icon image="back" message ="Back" /></a>
			
				<portlet:renderURL var="viewURL">
					<portlet:param name="bulkOnbordingFileId" value="${bulkOnbordingFileId}" />
					<portlet:param name="mvcPath" value="/record_list_view.jsp"/>
				</portlet:renderURL>
				
				<a href=${viewURL} class="btn btn-sm btn-secondary"><liferay-ui:icon  icon="reload" markupView="lexicon" message="Refresh"/></a>
				
		
				<c:forEach items="${actions}" var="action">
											
					<portlet:renderURL var="actionUrl" >
						<portlet:param name="bulkOnbordingFileId" value="${bulkOnbordingFileId}" />
						<portlet:param name="mvcPath" value="/action_process_view.jsp" />
						<portlet:param name="targetAction" value="${action}" />
					</portlet:renderURL>
						
					<button type="button" cssClass="btn btn-sm btn-primary" onClick='viewActionPage("${action}","${actionUrl}")'>${action} All</button>
				
				</c:forEach>
		
				<%
					if (hasOwnerRole) {
				%>
				<a href="${deleteAll}" class="btn btn-sm btn-secondary"	onclick="return deleteConfirm()">Delete All</a>
				<%
					}
				%>
			
			</div>

		</div>
	</div>
</div>
	

<div class="card">
	<div class="row">
		<div class="col-md-12">
			<table id="userTable" class="display table table-striped nowrap" cellspacing="0" width="100%">
				<thead>
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
					<%
					if(requestList.size()>8){
						showScroll=true;
					}
					%>
						<c:forEach items="${requestList}" var="requestDto" varStatus="loop">
							<c:if test="${requestDto.errorMessage==''}">
								<c:remove var="submitAllStatus" />
								<c:set var="submitAllStatus" value='true' />
							</c:if>
							<portlet:actionURL name="deleteRequest" var="deleteURL">
								<portlet:param name="requestId"	value="${requestDto.registrationRequestId}" />
								<portlet:param name="bulkOnbordingFileId" value="${bulkOnbordingFileId}" />
								<portlet:param name="mvcPath" value="/record_list_view.jsp" />
							</portlet:actionURL>
		
							<portlet:renderURL var="editEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
								<portlet:param name="mvcPath" value="/edit_entry.jsp" />
								<portlet:param name="registrationId" value="${requestDto.registrationRequestId}" />
							</portlet:renderURL>
							<portlet:renderURL var="detailEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
								<portlet:param name="mvcPath" value="/detail_entry.jsp" />
								<portlet:param name="detailRegistrationId" value="${requestDto.registrationRequestId}" />
							</portlet:renderURL>
							
							<tr id='${requestDto.registrationRequestId}'>
								<td class="tbdata"> ${loop.count}</td>
								<td class="tbdata" id='${requestDto.registrationRequestId}unit'>${requestDto.unit}</td>
								<td class="tbdata" id='${requestDto.registrationRequestId}personalNo'>${requestDto.personalNo}</td>
								<td class="tbdata">
									<c:if test="${ not requestDto.editable }">
										<button id='${requestDto.registrationRequestId}name' type="button" class="btn btn-link"
											onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")'>${requestDto.fullName}</button>
									</c:if> 
									<c:if test="${requestDto.editable }">
										<button id='${requestDto.registrationRequestId}name' type="button" class="btn btn-link"
											onclick='viewActionPopup("${editEntryURL}","Edit registration request","${requestDto.registrationRequestId}","EDIT")'>${requestDto.fullName}</button>
									</c:if>
								</td>
								<td id='${requestDto.registrationRequestId}email'>${requestDto.emailAddress}</td>
								<td id='${requestDto.registrationRequestId}mobile'>${requestDto.mobile}</td>
								
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
                        								
								<td><fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value = "${requestDto.modifiedDate}" /></td>
								
								<c:choose>
			    					<c:when test="${not empty requestDto.errorMessage}">
											<td class="tbdata"  id='${requestDto.registrationRequestId}status'>
												<input type="hidden" id='${requestDto.registrationRequestId}errorRecord' value="${requestDto.errorMessage}"> 
												<c:if test="${not empty requestDto.errorMessage}">
													<panel id='${requestDto.registrationRequestId}srNo'>
													 <span data-toggle="tooltip" data-placement="top" data-container="body" data-html="true" id="${requestDto.registrationRequestId}errorRecordtoolTip"
														style="color: red ; cursor: pointer;"  onmouseover='errorMessage("${requestDto.registrationRequestId}errorRecord")'>
														Error in Data</span> 
													</panel>
												</c:if></td>
									</c:when>    
						    		<c:otherwise>
						         		<td id='${requestDto.registrationRequestId}status'>${requestDto.status}</td>
						    		</c:otherwise>
								</c:choose>
														
		
								<td class="text-center" id='${requestDto.registrationRequestId}actions' style="width: 50px">
									<liferay-ui:icon-menu>
										<%
											if (hasOwnerRole) {
										%>
										<c:if test="${requestDto.editable}">
											<liferay-ui:icon image="delete" message="Delete" url="${deleteURL}" />
										</c:if>
										<%
											}
										%>
										<c:if test="${empty requestDto.errorMessage}">
											<c:forEach items="${requestDto.actions}" var="taskAction">
												<c:if test="${requestDto.assignable}">
													<button type="button" class="btn btn-link" style="color: #6b6c7e;" id="<portlet:namespace/>approveBtn" name="<portlet:namespace />approveBtn" 
														onclick='approverPopup("${requestDto.registrationRequestId}", "${taskAction}","${requestDto.taskId}","${bulkOnbordingFileId}" )'>
													<liferay-ui:icon image="submit" message="${taskAction}" />
													</button>
													<br>
												</c:if>
											</c:forEach>
										</c:if>
										<c:if test="${requestDto.editable}">
											<button type="button" class="btn btn-link" style="color: #6b6c7e;" name="<portlet:namespace />edit_btn" id="<portlet:namespace />edit_btn"
												onclick='viewActionPopup("${editEntryURL}","Edit entry request","${requestDto.registrationRequestId}","EDIT")' >
												<liferay-ui:icon image="edit" message="Edit entry" />
											</button>
											<br>
										</c:if>
										
										<button type="button" class="btn btn-link" name="<portlet:namespace />view_btn" id="<portlet:namespace />view_btn" style="color: #6b6c7e;"
											onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")' >
											<liferay-ui:icon image="view" message="View" />
										</button>
									</liferay-ui:icon-menu></td>
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
							<td></td>
							<td></td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<input type="hidden" id="submitId" value="${submitAllStatus}">
		</div>
	</div>
</div>

<portlet:actionURL name="approve_registration"	var="approveURL"/>

<div id="actonModal" class="upload-registration" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered modal-lg" role="document" style="max-width: 100%;">
    <div class="modal-content">
    <aui:form name="myForm" action="${approveURL}">
      <div class="modal-header bg-primary text-white">
        <h5 class="modal-title">Disclaimer</h5>
        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
	            <aui:field-wrapper name="disclaimer" cssClass="d-inline-block">
	            	   <aui:input type="checkbox" name="disclaimer" id="disclaimer" cssClass="d-inline" label=""><aui:validator name="required"/></aui:input>
						<label for="disclaimer">
						<span class="reference-mark text-warning">
						  <svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
						      <svg id="asterisk" viewBox="0 0 512 512">
	                               <path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
                              </svg>
						  </svg>
						 </span>
						I confirm that, I have read, understand and agreed to the submission guidelines, 
						policies and submission declaration of the document.</label>
	            </aui:field-wrapper>
					<aui:field-wrapper name="remarks">
					    <aui:input type="textarea" name="remarks" label="Remark" ></aui:input>
					</aui:field-wrapper>
					<aui:input type="hidden" name="requestId" id = "requestId"></aui:input>
				<aui:input type="hidden" name="action" id ="currentAction"></aui:input>
				<aui:input type="hidden" name="taskId" id="taskId"></aui:input>
				<aui:input type="hidden" name="bulkOnbordingFileId" id="bulkOnbordingFileId"></aui:input>
		   
      </div>
      <div class="modal-footer">
        <!-- <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
        <aui:button type="submit" value="Submit" cssClass="ml-auto"></aui:button>
	    <aui:button type="cancel" id="cancelBtn" ></aui:button>
      </div>
      </aui:form>
    </div>
  </div>
</div>

<portlet:actionURL name="get_record_actions" windowState="exclusive"	var="recordActionsURL"/>

<script>
	function errorMessage(errorRecord) {
		var errors = $("#" + errorRecord).val();
		var messageHtml = "";	    
		 if(errors.length != 0){
			 	var errorMsg = new Array();
		 	 	var errorMsg = errors.split("#");
		 	 	for (const val of errorMsg) {
		 	 	  messageHtml += "<p class='my-0 text-left'>" + val + "</p>";
		 	 	}
		 }

		$("#" + errorRecord + "toolTip").tooltip({
			title : messageHtml,
			trigger : 'hover'
		});

	}
	
	$(document).ready(function(){
		$("#subButton").hide();
		var status=$("#submitId").val();
		if(status=="true"){
			$("#subButton").show();
			}
		
	});

var recordTable;
	$(document).ready( function() {
	
	    recordTable=$('#userTable').DataTable({
	     "pageLength": 50,
	     "scrollX": true, 
	   <% if(showScroll){%>
	     "scrollY": 400,
	     <%} %>
	     fixedColumns:   {
	            leftColumns: 4,
	            rightColumns: 0
	        }
	   
	    });
	} );


	// Get the modal

	var editFlag = false;
	var modal = document.getElementById("myModal");
	var btn = document.getElementById("<portlet:namespace/>uploadBtn");
	var span = document.getElementsByClassName("close")[0];
	if(btn != null){
		btn.onclick = function() {
			modal.style.display = "block";
		}
	}
	span.onclick = function() {
		modal.style.display = "none";
	}

	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	
	function actionConfirm(action) {
		var txt;
		var flag = confirm("Do you want to " + action + " all valid records?");
		return flag;
	}
	function deleteConfirm() {
		var flag = confirm("Do you want to delete all pending records?");
		return flag;
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
</script>

<aui:script>
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
				if (requestDto.errorMessage == ""
						|| requestDto.errorMessage == null) {
					$("#" + requestDto.registrationRequestId + "srNo").hide();
				} else {
					$("#" + requestDto.registrationRequestId + "srNo").show();
				}

				$("#" + requestDto.registrationRequestId + "errorRecord").val(requestDto.errorMessage);
				/* $("#" + requestDto.registrationRequestId + "recordNo").html(requestDto.recordNo); */
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
				
				$("#" + requestDto.registrationRequestId + "status").html(requestDto.status);
				
				recordTable.fixedColumns().update();
				updateActions(requestId);
			},
			async : false,
		});
	}
	
	function updateActions(requestId){
		jQuery.ajax({
			type : "POST",
			url : "${recordActionsURL}",
			data : ({
				<portlet:namespace/>requestId : requestId,
				<portlet:namespace/>bulkOnbordingFileId:"<%=bulkOnbordingFileId%>",
				<portlet:namespace/>resource : "registrationRequest"
			}),
			success : function(res) {
				$("#" + requestId + "actions").html(res);
			},
			async : false,
		});
	}

	
var modalV = document.getElementById("actonModal");
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

function approverPopup(requestId, action, taskId, bulkOnbordingFileId) {
	document.getElementById("<portlet:namespace />requestId").value = requestId;
	document.getElementById("<portlet:namespace />currentAction").value = action;
	document.getElementById("<portlet:namespace />taskId").value = taskId;
	document.getElementById("<portlet:namespace />bulkOnbordingFileId").value = bulkOnbordingFileId;

	var modalV = document.getElementById("actonModal");
	
	modalV.style.display = "block";
	
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


function viewActionPage(action,actionUrl){
	var searchForm = document.getElementById("<portlet:namespace/>search-form");
	$("#<portlet:namespace/>search-form").attr('action', actionUrl);
	$("#<portlet:namespace/>search-form").submit();
	//searchForm.attr('action', actionUrl);
	//searchForm.submit();

}

</script>

<%-- <script type="text/javascript">
function submit(action) {
	var requestIds = [];
	$('input[name="<portlet:namespace/>requestIds"]:checked').each(function() {
	   requestIds.push($(this).val());
	});
		"<%=approveFormURL%>&<portlet:namespace/>formId="+formId;
		'<%=detachDraftURL%>&<portlet:namespace />attachmentId='+attachmentId+'&<portlet:namespace />parentMovementId='+parentMovementId;
	window.location.href = '${selectedProcessed}&<portlet:namespace />requestIds='+requestIds+'&<portlet:namespace />action='+action;
}
</script> --%>
