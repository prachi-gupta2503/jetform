<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page
	import="com.adjecti.mdm.liferay.service.PayLevelLocalServiceUtil"%>

<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page
	import="com.adjecti.mdm.liferay.service.JoiningModeLocalServiceUtil"%>
<%@page
	import="com.adjecti.mdm.liferay.service.GradeModeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page
	import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>

<%@page import="com.adjecti.mdm.liferay.model.PayLevel"%>

<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.JoiningMode"%>
<%@page import="com.adjecti.mdm.liferay.model.GradeMode"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeJoining"%>
<%@ include file="../../init.jsp"%>


<%
	List<Organization> organizations = PISUserUtil.getUnitByRoles(user.getUserId());
	List<Designation> designationList = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	List<Grade> grades = GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<GradeMode> gradeModes = GradeModeLocalServiceUtil.getGradeModes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<JoiningMode> joiningModeList = JoiningModeLocalServiceUtil.getJoiningModes(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	List<Trade> tradeList = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	List<PayLevel> paylevelList = PayLevelLocalServiceUtil.getPayLevels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	EmployeeJoining employeeJoining = null;
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);
	if (employeeId != 0) {
		List<EmployeeJoining> employeeJoinings = EmployeeJoiningLocalServiceUtil
				.getJoiningByEmployeeId(employeeId);
		if (employeeJoinings.size() > 0)
			employeeJoining = EmployeeJoiningLocalServiceUtil.getJoiningByEmployeeId(employeeId).get(0);
		else
			employeeJoining = EmployeeJoiningLocalServiceUtil.createEmployeeJoining(0);
	} else {
		employeeJoining = EmployeeJoiningLocalServiceUtil.createEmployeeJoining(0);
	}
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
%>
<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Joining Details</h5>
	</div>
	<div class="card-body">
		<p id="JoiningErrorMessage"></p>
		<aui:form>
		
			
			
			<div class="row">
				<div class="form-group required col-md-6">
					<aui:input id="joining_employeeJoiningId" name="joining_employeeJoiningId"
						type="hidden" value="<%=employeeJoining.getEmployeeJoiningId() %>" />
					<aui:select label="Unit" class="form-control" name="joining_unit"
						id="joining_unit">
						<aui:option selected="">Select Unit</aui:option>
						<%
							for (Organization organization : organizations) {
										boolean selected = false;
										if (employeeJoining.getOrganizationId() == organization.getOrganizationId()) {
											selected = true;
										}
						%>

						<aui:option value="<%=organization.getOrganizationId()%>"
							selected="<%=selected%>"><%=organization.getName()%></aui:option>

						<%
							}
						%>
						<aui:validator errorMessage="Select a Unit" name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">


					<aui:select label="Designation" class="form-control"
						name="joining_designation" id="joining_designation">
						<aui:option selected="">Select Designation</aui:option>
						<%
							for (Designation designation : designationList) {
										boolean selected = false;
										if (employeeJoining.getDesignationId() == designation.getDesignationId()) {
											selected = true;
										}
						%>

						<aui:option value="<%=designation.getDesignationId()%>"
							selected="<%=selected%>"><%=designation.getName_En()%></aui:option>
						<%
							}
						%>
						<aui:validator errorMessage="Select a Designation" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">
				<div class="form-group required col-md-6">
					<aui:select label="Grade" class="form-control" name="joining_grade"
						id="joining_grade">
						<aui:option selected="">Select Grade</aui:option>
						<%
							for (Grade grade : grades) {
										boolean selected = false;
										if (employeeJoining.getGradeId() == grade.getGradeId()) {
											selected = true;
										}
						%>
						<aui:option value="<%=grade.getGradeId()%>"
							selected="<%=selected%>"><%=grade.getName()%></aui:option>
						<%
							}
						%>
						<aui:validator errorMessage="Select a Grade" name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">
					<aui:select label="Grade Mode" name="joining_gradeMode"
						class="form-control" id="joining_gradeMode">
						<aui:option selected="">Select Grade Mode</aui:option>
						<%
							for (GradeMode gradeMode : gradeModes) {
										boolean selected = false;
										if (employeeJoining.getGradeModeId() == gradeMode.getGradeModeId()) {
											selected = true;
										}
						%>
						<aui:option value="<%=gradeMode.getGradeModeId()%>"
							selected="<%=selected%>"><%=gradeMode.getName()%></aui:option>
						<%
							}
						%>
						<aui:validator errorMessage="Select a Grade Mode" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">


				<div class="form-group required col-md-6">
					<aui:select label="Joining Mode" name="joining_joiningMode"
						class="form-control" id="joining_joiningMode">
						<aui:option selected="">Select Joining Mode</aui:option>
						<%
							for (JoiningMode joiningMode : joiningModeList) {
										boolean selected = false;
										if (employeeJoining.getJoiningModeId() == joiningMode.getJoiningModeId()) {
											selected = true;
										}
						%>


						<aui:option value="<%=joiningMode.getJoiningModeId()%>"
							selected="<%=selected%>"><%=joiningMode.getName()%></aui:option>
						<%
							}
						%>
						<aui:validator errorMessage="Select a Joining Mode"
							name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">


					<aui:select label="Trade" class="form-control" name="joining_trade"
						id="joining_trade">
						<aui:option selected="">Select Trade</aui:option>
						<%
							for (Trade trade : tradeList) {
										boolean selected = false;
										if (employeeJoining.getTradeId() == trade.getTradeId()) {
											selected = true;
										}
						%>

						<aui:option value="<%=trade.getTradeId()%>"
							selected="<%=selected%>"><%=trade.getName()%></aui:option>
						<%
							}
						%>
						<aui:validator errorMessage="Select a Trade" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">


				
				<div class="form-group required col-md-6">
					<aui:select label="Pay Level" name="joining_payLevelId"
						class="form-control" id="joining_payLevel">
						<aui:option selected="">Select Pay Level</aui:option>
						<%
							for (PayLevel payLevel : paylevelList) {
										boolean selected = false;
										if (employeeJoining.getPayLevelId() == payLevel.getPayLevelId()) {
											selected = true;
										}
						%>

						<aui:option value="<%=payLevel.getPayLevelId()%>"
							selected="<%=selected%>"><%=payLevel.getName()%></aui:option>

						<%
							}
						%>
						<aui:validator errorMessage="Select a Pay Level" name="required" />
					</aui:select>

				</div>
				
				<div class="form-group required col-md-6">
					<aui:input label="Email Address" type="text"
						name="joining_emailAddress"
						value="<%=employeeJoining.getEmailAddress()%>"
						class="form-control" id="joining_emailAddress">
						<aui:validator errorMessage="Select a Email Address"
							name="required" />
					</aui:input>
				</div>
				

			</div>


			<div class="row">

				


				<div class="form-group  col-md-6">
					<aui:input label="Selection Date" type="date"
						value="<%=employeeJoining.getSelectionDate() != null
						? simpleDateFormat.format(employeeJoining.getSelectionDate())
						: null%>"
						name="joining_selectionDate" class="form-control"
						id="joining_selectionDate" />

				</div>
				
				<div class="form-group  col-md-6">
					<aui:input label="Confirmation Date" type="date"
						value="<%=employeeJoining.getConfirmationDate() != null
						? simpleDateFormat.format(employeeJoining.getConfirmationDate())
						: null%>"
						name="joining_confirmationDate" class="form-control"
						id="joining_confirmationDate" />
				</div>
				
			</div>
			
			<div class="row">
				
				
				<div class="form-group required col-md-6">
					<aui:input label="From Date" type="date" name="joining_fromDate"
						value="<%=employeeJoining.getFromDate() != null
							? simpleDateFormat.format(employeeJoining.getFromDate())
							: null%>"
						class="form-control" id="joining_fromDate">
						<aui:validator errorMessage="Select a From Date" name="required" />
					</aui:input>


				</div>
				
				<div class="form-group required col-md-6">
					<aui:input label="To Date" type="date" name="joining_toDate"
						value="<%=employeeJoining.getToDate() != null
							? simpleDateFormat.format(employeeJoining.getToDate())
							: null%>"
						class="form-control" id="joining_toDate">
						<aui:validator errorMessage="Select a To Date" name="required" />
					</aui:input>


				</div>
			</div>


			
			

			

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Joining Date Organization" type="date"
						value="<%=employeeJoining.getDateOfJoiningOrganization() != null
						? simpleDateFormat.format(employeeJoining.getDateOfJoiningOrganization())
						: null%>"
						name="joining_dateOfJoiningOrganization" class="form-control"
						id="joining_dateOfJoiningOrganization" />

				</div>
				 <div class="form-group  col-md-6">
					<aui:input label="Joining Date" type="date"
						value="<%=employeeJoining.getDateOfJoining() != null
						? simpleDateFormat.format(employeeJoining.getDateOfJoining())
						: null%>"
						name="joining_joiningDate" class="form-control"
						id="joining_joiningDate" />

				</div> 


				

			</div>

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Grade Confirmation Date"
						value="<%=employeeJoining.getGradeConfirmationDate() != null
						? simpleDateFormat.format(employeeJoining.getGradeConfirmationDate())
						: null%>"
						name="joining_gradeConformationDate" type="date"
						class="form-control" id="joining_gradeConfirmationDate" />


				</div>


				<div class="form-group  col-md-6">
					<aui:input label="Govt Service Date" name="joining_govtServiceDate"
						value="<%=employeeJoining.getGovtServiceDate() != null
						? simpleDateFormat.format(employeeJoining.getGovtServiceDate())
						: null%>"
						type="date" class="form-control" id="joining_govtServiceDate" />


				</div>

			</div>

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Recruitment Batch"
						name="joining_recruitmentBatch" type="input"
						value="<%=employeeJoining.getRecruitmentBatch()%>"
						class="form-control" id="joining_recruitmentBatch" />


				</div>


				<div class="form-group  col-md-6">


					<div class="custom-file">
						<aui:input label="Joining Letter" type="file"
							class="custom-file-input" name="joining_joiningLetter"
							id="joining_joiningLetter" />

					</div>

				</div>

			</div>

		</aui:form>
	</div>
</div>


<script>
	var employeeJoiningId = null;
	var joiningLetterId = '0';
	$(document).ready(function() {
		$('#<portlet:namespace />joining_joiningLetter').change(function(e) {
			
			let fileId=<%=employeeJoining.getJoiningLetterId() %>
			if(fileId == 0)
				uploadFile(e.target.files[0], setJoiningLetterId);
			else
				updateFile(fileId,e.target.files[0], setJoiningLetterId);
			

		});
	});

	function setJoiningLetterId(data) {
		joiningLetterId = data.fileEntryId;

		Liferay.Service('/mdm.documenttype/get-document-type-id-by-name', {
			name : "Joining Document"
		}, function(obj) {
			console.log(obj);
			var employeeDocumentId = 0;
			this.documentTypeId = obj;
			var title = "Joining Document";
			var discription = "Joining Document";
			var empDocument = new EmployeeDocument(employeeDocumentId, title,
					discription, documentTypeId, joiningLetterId, employeeId);
			documentList.push(empDocument);
			addDocument(documentList);
		});
	}
	function saveForm(onSuccess) {

		
		
		var employeeJoiningId = $("#<portlet:namespace/>joining_employeeJoiningId").val();
		var emailAddress = $("#<portlet:namespace/>joining_emailAddress").val();
		
		var designationId = $("#<portlet:namespace/>joining_designation").val();
		var gradeId = $("#<portlet:namespace/>joining_grade").val();
		var payLevelId = $("#<portlet:namespace/>joining_payLevel").val();
		var tradeId = $("#<portlet:namespace/>joining_trade").val();
		var organizationId = $("#<portlet:namespace/>joining_unit").val();
		var joiningModeId = $("#<portlet:namespace/>joining_joiningMode").val();
		var gradeModeId = $("#<portlet:namespace/>joining_gradeMode").val();
		var fromDate = $("#<portlet:namespace/>joining_fromDate").val();
		var toDate = $("#<portlet:namespace/>joining_toDate").val();
		var selectionDate = $("#<portlet:namespace/>joining_selectionDate")
				.val();
		var joiningDate = $("#<portlet:namespace/>joining_joiningDate").val();
		var dateOfJoiningOrganization = $("#<portlet:namespace/>joining_dateOfJoiningOrganization").val();
		var confirmationDate = $(
				"#<portlet:namespace/>joining_confirmationDate").val();
		var gradeConfirmationDate = $(
				"#<portlet:namespace/>joining_gradeConfirmationDate").val();
		var govtServiceDate = $("#<portlet:namespace/>joining_govtServiceDate")
				.val();
		var recruitmentBatch = $(
				"#<portlet:namespace/>joining_recruitmentBatch").val();
		try {

			var employeeJoining =new EmployeeJoining(employeeJoiningId,emailAddress,
					designationId,gradeId,
					payLevelId,tradeId,organizationId,
					joiningModeId,joiningLetterId,gradeModeId,fromDate,toDate ,
					selectionDate,joiningDate,confirmationDate,gradeConfirmationDate,
					govtServiceDate, recruitmentBatch,dateOfJoiningOrganization, employeeId)
			
			
			Liferay.Service(
					'/pis.employeejoining/add-employee-joining-details', {
						employeeJoining:employeeJoining
					}, function(obj) {
						console.log(obj);
						
						this.employeeJoiningId = obj.employeeJoiningId;
						if (typeof obj == "string")
							if (obj.startsWith("error")) {
								$("#JoiningErrorMessage").text(obj);
								validationBackendError = false;
							}
						if(validationBackendError){
							onSuccess();
							validationBackendError=true;
						}
					});
		} catch (error) {
			document.getElementById("JoiningErrorMessage").innerHtml = "Error= "
					+ error;
		}

	}
	
	
	class EmployeeJoining{
		constructor(employeeJoiningId, emailAddress,
			designationId,gradeId,
			payLevelId,tradeId,organizationId,
			joiningModeId,joiningLetterId,gradeModeId,fromDate,toDate ,
			selectionDate,dateOfJoining,confirmationDate,gradeConfirmationDate,
			govtServiceDate, recruitmentBatch,dateOfJoiningOrganization, employeeId){
			
			this.employeeJoiningId=employeeJoiningId;
			
			this.emailAddress=emailAddress;
			
			this.designationId=designationId;
			this.gradeId=gradeId;
			this.payLevelId=payLevelId;
			
			this.tradeId=tradeId;
			this.organizationId=organizationId;
			
			this.joiningModeId=joiningModeId;
			this.joiningLetterId=joiningLetterId;
			this.gradeModeId=gradeModeId;
			this.fromDate=fromDate;
			this.toDate=toDate;
			this.selectionDate=selectionDate;
			this.dateOfJoining=dateOfJoining;
			this.dateOfJoiningOrganization=dateOfJoiningOrganization;
			this.confirmationDate=confirmationDate;
			this.gradeConfirmationDate=gradeConfirmationDate;
			this.govtServiceDate=govtServiceDate;
			this.recruitmentBatch=recruitmentBatch;
			this.employeeId=employeeId;
			
			}
		}
	
</script>
