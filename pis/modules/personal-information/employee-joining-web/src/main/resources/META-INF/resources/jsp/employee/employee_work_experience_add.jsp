<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeePastExperienceLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePastExperience"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
<%@ include file="../../init.jsp"%>
<style>
	tbody{
		border: 1px solid #e7e7ed; 
	}
	td{
		padding:10px;
	}
	
	table {
		border-collapse: collapse;
		width: 100%;
		padding: 10px;
	}
	
</style>

<%
List<WorkArea> workAreas=WorkAreaLocalServiceUtil.getWorkAreas(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
long employeeId = ParamUtil.getLong(request, "employeeId", 0);

%>

<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Work Experience</h5>
	</div>
<div class="card-body">
<div class="form-card">
	<button type="button" class="btn btn-primary" id="btnAdd1">Add Experience</button>
	<p id="ExperienceErrorMessage"></p>
	<aui:form>
		<table id="workUser">
			<tbody id="worktbody">
				<tr>
					<td><aui:input name="employeePastExperienceId"
							id="employeePastExperienceId" type="hidden" /> <aui:input
							label="Organization" type="text" name="experience_Organization"
							class="form-control" id="experience_Organization1">
							<aui:validator
								errorMessage="The Organization is a required field"
								name="required" />
							<aui:validator name="maxLength">100</aui:validator>
						</aui:input></td>
				</tr>

				<tr>
					<td><aui:input label="Designation" type="text"
							name="experience_Designation" class="form-control"
							id="experience_Designation1">
							<aui:validator errorMessage="The Designation is a required field"
								name="required" />
							<aui:validator name="maxLength">100</aui:validator>
						</aui:input></td>

					<td><aui:select label="Work Area" class="form-control"
							name="experience_Work_Area" id="experience_Work_Area1">
							<aui:option selected="">Select Work Area</aui:option>
							<%
								for (WorkArea workArea : workAreas) {
							%>
							<aui:option value="<%=workArea.getWorkAreaId()%>"><%=workArea.getName()%>

							</aui:option>
							<%
								}
							%>
							<aui:validator errorMessage="The Work Area is a required field"
								name="required" />
						</aui:select></td>
				</tr>

				<tr>
					<td><aui:input label="From Date" type="date"
							name="experience_From_Date" class="form-control"
							id="experience_From_Date1" required="true">
							<aui:validator errorMessage="The From Date is a required field"
								name="required" />
						</aui:input></td>

					<td><aui:input label="To Date" type="date"
							name="experience_To_Date" class="form-control"
							id="experience_To_Date1">
							<aui:validator errorMessage="The To Date is a required field"
								name="required" />
						</aui:input></td>
				</tr>

				<tr>
					<td><aui:input label="Experience Letter" type="file"
							class="custom-file-input" name="experience_Experience_Letter"
							id="experience_Experience_Letter1"
							onChange="getExperienceFileId(this.id)">
							<aui:validator name="acceptFiles">'pdf'</aui:validator>
						</aui:input></td>
				</tr>


			</tbody>
		</table>
	</aui:form>
</div>
</div>
</div>

<script>

var employeePastExperienceIdArray=null;

var iCnt = 1;
var experienceList = new Array();
var experienceFileId = [];
var fileElementIdNo=-1;
var workAreasList=new Array();

$(document).ready(function(){
	var employeeId='<%=employeeId%>';
	
	Liferay.Service(
			'/pis.employeepastexperience/get-by-employee-id',
			  {
			    employeeId: employeeId
			  },
			  function(obj) {
			    console.log(obj);
			    experienceList=obj;
			    editExperience();
			    
			  }
			);
	
	
	$('#btnAdd1').click(function() {
			
		addMoreExperience();
	});
		
	 $("#workUser").on('click', '#btnRemove', function () {
                
		$(this).closest('tbody').remove();
		$('#btAdd1').attr('disabled', false);
		iCnt=iCnt-1;
	}); 
});	

function editExperience(){
	
	for(let i=0;i<experienceList.length-1;i++){
		addMoreExperience();
	}
	setValuesInExperienceField();
}


function setValuesInExperienceField(){
	var organizationArray=document.getElementsByName("<portlet:namespace/>experience_Organization");
	var designationArray=document.getElementsByName("<portlet:namespace/>experience_Designation");
	var workAreaArray=document.getElementsByName("<portlet:namespace/>experience_Work_Area");
	var fromDateArray=document.getElementsByName("<portlet:namespace/>experience_From_Date");
	var toDateArray=document.getElementsByName("<portlet:namespace/>experience_To_Date");
	employeePastExperienceIdArray=document.getElementsByName("<portlet:namespace/>employeePastExperienceId");
	for(let i=0;i<experienceList.length;i++){
		employeePastExperienceIdArray[i].value=experienceList[i].employeePastExperienceId;
		organizationArray[i].value = experienceList[i].organization;
		designationArray[i].value = experienceList[i].designation;
		workAreaArray[i].value = experienceList[i].workAreaId;
		fromDateArray[i].value = convertDateFormat(experienceList[i].fromDate);
		toDateArray[i].value = convertDateFormat(experienceList[i].toDate);
		experienceFileId[i]= experienceList[i].experienceLetterId;
	}
	
}

function convertDateFormat(date){
	var date=new Date(date);
	return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}

function addMoreExperience(){
	iCnt = iCnt + 1;
	
	if (iCnt <= 8) {
		
		var markup="<td><button type='button' class='btn btn-secondary' id='btnRemove' name='btnRemove'> Remove <button/><td>";	
		var cloneData = $('#worktbody').clone();
		cloneData.find("input").val('');
		cloneData.find('#<portlet:namespace/>experience_Experience_Letter1').prop("id","experience_Experience_Letter"+iCnt);
		cloneData.append(markup);
		$('#workUser').append(cloneData);
			workAreaOptions();
	}
	else{
		$('#btnAdd1').attr('disabled', true);
	}
}		
function getExperienceFileId(value) {
	fileElementIdNo = value.charAt(value.length - 1);
	if(experienceFileId[fileElementIdNo-1] > 0 )
		updateFile(experienceFileId[fileElementIdNo-1],document.getElementById(value).files[0], setExperienceFileId);
	else{
    	uploadFile(document.getElementById(value).files[0], setExperienceFileId);
	}
    
}

	
function setExperienceFileId(data){
			
	experienceFileId[fileElementIdNo-1]=data.fileEntryId;
	var employeeDocumentId=0;
	var title="Experience Document";
	var discription="Experience Document";
			 
		Liferay.Service(
		'/mdm.documenttype/get-document-type-id-by-name',
		 {
			name: "Experience Proof"
		},
		function(obj) {
			console.log(obj);
			this.documentTypeId=obj;
			var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,experienceFileId[fileElementIdNo-1],employeeId);
			documentList.push(empDocument);
			addDocument(documentList);
		});
}
			

		
	function saveForm(onSuccess){
				
		var organizationArray=document.getElementsByName("<portlet:namespace/>experience_Organization");
		var designationArray=document.getElementsByName("<portlet:namespace/>experience_Designation");
		var workAreaArray=document.getElementsByName("<portlet:namespace/>experience_Work_Area");
		var fromDateArray=document.getElementsByName("<portlet:namespace/>experience_From_Date");
		var toDateArray=document.getElementsByName("<portlet:namespace/>experience_To_Date");
		
		
		for(var i = 0 ; i < iCnt ; i++){
			
			var employeePastExperienceId=employeePastExperienceIdArray[i].value;
			var organization=organizationArray[i].value;
			var designation=designationArray[i].value;
			var workArea=workAreaArray[i].value;
			var fromDate=fromDateArray[i].value;
			var toDate=toDateArray[i].value;
			var experienceLetterId=experienceFileId[i];
			
			var empExperience=new EmployeeExperience(employeePastExperienceId, fromDate, toDate, designation, experienceLetterId, organization, workArea,employeeId );
			experienceList.push(empExperience);
		}
		Liferay.Service(
				'/pis.employeepastexperience/add-past-experiences',
				{
					employeeExperiences: experienceList
				},
				function(obj) {
					console.log(obj);
					this.experienceList=obj;
					if(typeof obj == "string")
					if(obj.startsWith("error")){
				    	 $("#ExperienceErrorMessage").text(obj);
				    	 validationBackendError=false;
				    }
					this.employeePastExperienceIdArray=[];
					for(i=0;i<iCnt;i++){
						this.employeePastExperienceIdArray[i]=obj[i].employeePastExperienceId;
					}
					this.experienceList=new Array();
					if(validationBackendError){
						onSuccess();
						validationBackendError=true;
					}
				});
		this.experienceList=new Array();

}
		
		class EmployeeExperience {
			constructor(employeePastExperienceId, fromDate, toDate, designation, experienceLetterId, organization, workAreaId,employeeId ) {
			this.employeePastExperienceId = employeePastExperienceId;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.designation = designation;
			this.experienceLetterId = experienceLetterId;
			this.organization = organization;
			this.workAreaId = workAreaId;
			this.employeeId=employeeId;
			}
		}

		Liferay.Service(
				'/mdm.workarea/get-work-areas',
				function(obj) {
					console.log(obj);
					for(var i=0 ; i < obj.length ; i++){
						workAreasList[i]=obj[i];
					}
				});
		function workAreaOptions() {
			for(i = 0 ; i < workAreasList.length ; i++){
				var optionName=workAreasList[i].name;
				var optionValue=workAreasList[i].workAreaId;
				$('#experience_Work_Area'+iCnt).append(new Option(optionName, optionValue));
			}
		}
</script>