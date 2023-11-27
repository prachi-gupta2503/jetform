<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.SpecializationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLevelLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationGradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Specialization"%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationLevel"%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationGrade"%>
<%@page import="com.adjecti.mdm.liferay.model.Qualification"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@ include file="../../init.jsp"%>

<style>
	tbody{
		border: 1px solid #e7e7ed; 
	}
	td{
		padding:10px;
		
	}
</style>
<%
long employeeId = ParamUtil.getLong(request, "employeeId", 0);

List<Qualification> qualifcationList=QualificationLocalServiceUtil.getQualifications(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<QualificationGrade> gradeList=QualificationGradeLocalServiceUtil.getQualificationGrades(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<QualificationLevel> levelList=QualificationLevelLocalServiceUtil.getQualificationLevels(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<Specialization> specializationList=SpecializationLocalServiceUtil.getSpecializations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);


%>
<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Education</h5>
	</div>
<div class="card-body">
<div class="form-card-inner" id="main">
	<button type="button" class="btn btn-primary" id="btAdd" >Add Education</button>
	<p id="EducationErrorMessage"></p>
	<div>
		<aui:form>
			<div style="padding: 5px">
				<table id="tbUser">
					<tbody id="qualtbody">
						<tr>
							<td>
								<aui:input name="employeeQualificationId" id="employeeQualificationId" type="hidden" /> <aui:select label="Qualification" class="form-control"
									name="educational_Qualification" id="educational_Qualification1">
									<aui:option selected="">Select Qualification</aui:option>
									<%
										for (Qualification qualification : qualifcationList) {
											String qualificationName = qualification.getName();
											System.out.println(qualificationName);
											long qualificationId = qualification.getQualificationId();
									%>
									<aui:option value="<%=qualificationId%>"><%=qualificationName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Qualification" name="required" />
								</aui:select>
							</td>
							<td>
								<aui:select label="Level" class="form-control" name="educational_Level" id="educational_Level1" required="true">
									<aui:option selected="">Select Level</aui:option>
									<%
										for (QualificationLevel qualificationLevel : levelList) {
											String levelName = qualificationLevel.getName();
											System.out.println(levelName);
											long levelId = qualificationLevel.getQualificationLevelId();
									%>
									<aui:option value="<%=levelId%>"><%=levelName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Level" name="required" />
								</aui:select>
							</td>
							<td>
								<aui:select label="Specialization" class="form-control" name="educational_Specialization" id="educational_Specialization1" required="true">
									<aui:option selected="">Select Specialization</aui:option>
									<%
										for (Specialization specialization : specializationList) {
											String specializationName = specialization.getName();
											System.out.println(specializationName);
											long specializationId = specialization.getSpecializationId();
									%>
									<aui:option value="<%=specializationId%>"><%=specializationName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Specialization" name="required" />
								</aui:select>
							</td>
							<td>
								<aui:select label="Grade" class="form-control" name="educational_Grade" id="educational_Grade1" required="true">
									<aui:option selected="">Select Grade</aui:option>
									<%
										for (QualificationGrade qualificationGrade : gradeList) {
											String gradeName = qualificationGrade.getName();
											long gradeId = qualificationGrade.getQualificationGradeId();
									%>
									<aui:option value="<%=gradeId%>"><%=gradeName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Grade" name="required" />
								</aui:select>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-check form-check-inline">
									<aui:input label="Foreign Degree" type="checkbox" name="educational_Foreign_Degree" id="educational_Foreign_Degree1" class="form-check-input" />
									<label class="form-check-label" for="exampleCheck1">Yes</label>
								</div>
							</td>
							<td>
								<aui:input label="Institution" type="text" name="educational_Institution" class="form-control" id="educational_Institution1">
									<aui:validator name="maxLength">100</aui:validator>
									<aui:validator errorMessage="The Educational Institution is a required field" name="required" />
								</aui:input>
							</td>
							<td>
								<aui:input label="From Year" type="number" name="educational_From_Year" class="form-control" id="educational_From_Year1" required="true">
									<aui:validator errorMessage="The Educational From Year is a required field" name="required" />
								</aui:input>
							</td>
							<td>
								<aui:input label="To Year" type="number" name="educational_To_Year" class="form-control" id="educational_To_Year1" required="true">
									<aui:validator errorMessage="The Educational To Year is a required field" name="required" />
								</aui:input>
							</td>
						</tr>
						<tr>
							<td>
								<aui:input label="Qualification Date" type="date" name="educational_Qualification_Date" class="form-control" id="educational_Qualification_Date1">
									<aui:validator errorMessage="The Educational Qualification Date is a required field" name="required" />
								</aui:input>
							</td>
							<td>
								<aui:input label="Marks/Percentage" type="text" name="educational_Marks_Percentage" class="form-control" id="educational_Marks_Percentage1">
									<aui:validator name="maxLength">10</aui:validator>
								</aui:input>
							</td>
							<td>
								<div class="custom-file">
									<aui:input type="file" id="educational_Certificate1" name="educational_Certificate" label="Certificate" onChange="getEducationFileId(this.id)"></aui:input>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</aui:form>
	</div>
</div>
</div>
</div>

<script>
var iCnt = 1;
var list = new Array();
var educationFileId = [];
var fileElementIdNo=-1;

$(document).ready(function(){
	
	Liferay.Service(
			  '/pis.employeequalification/get-qualification-by-employee-id',
			  {
			    employeeId: employeeId 
			  },
			  function(obj) {
			    console.log(obj);
			    this.list=obj;
			   
			    editEducation();
			  }
			);
	 

	
	$('#btAdd').click(function() {
		addMoreEducation();
	});
	
	$("#tbUser").on('click', '#btnRemove', function() {
	
	    $(this).closest('tbody').remove();
	    $('#btAdd').attr('disabled', false);
	    iCnt = iCnt - 1;
	});
});

function editEducation(){
	
	for(let i=0;i<list.length-1;i++){
		addMoreEducation();
	}
	
	setValuesInEducationField();
}

function setValuesInEducationField(){
	var qualificationArray = document.getElementsByName("<portlet:namespace/>educational_Qualification");
    var levelArray = document.getElementsByName("<portlet:namespace/>educational_Level");
    var specializationArray = document.getElementsByName("<portlet:namespace/>educational_Specialization");
    var gradeArray = document.getElementsByName("<portlet:namespace/>educational_Grade");
    var foreignDegreeArray = document.getElementsByName("<portlet:namespace/>educational_Foreign_Degree");
    var foreignInstitutionArray = document.getElementsByName("<portlet:namespace/>educational_Institution");
    var fromYearArray = document.getElementsByName("<portlet:namespace/>educational_From_Year");
    var toYearArray = document.getElementsByName("<portlet:namespace/>educational_To_Year");
    var qualificationDateArray = document.getElementsByName("<portlet:namespace/>educational_Qualification_Date");
    var marksPercentageArray = document.getElementsByName("<portlet:namespace/>educational_Marks_Percentage");
    employeeQualificationIdArray=document.getElementsByName("<portlet:namespace/>employeeQualificationId");
	for(let i=0;i<list.length;i++){
		
		employeeQualificationIdArray[i].value = list[i].employeeQualificationId;
		qualificationArray[i].value = list[i].qualificationId;
		levelArray[i].value = list[i].levelId;
		specializationArray[i].value = list[i].specializationId;
		gradeArray[i].value = list[i].gradeId;
		foreignDegreeArray[i].value = list[i].foreignDegree;
		foreignInstitutionArray[i].value = list[i].foreignInstitution;
		fromYearArray[i].value = list[i].fromYear;
		toYearArray[i].value = list[i].toYear;
		qualificationDateArray[i].value = convertDateFormat(list[i].qualificationDate);
		marksPercentageArray[i].value = list[i].marksPercentage;
		educationFileId[i]=list[i].certificateId;
	}
	
}


function convertDateFormat(date){
	var date=new Date(date);
	return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}

function addMoreEducation(){
	 iCnt = iCnt + 1;
	    if (iCnt <= 8) {
	        var markup = "<td><button type='button' id='btnRemove' name='btnRemove' class='btn btn-secondary'>Remove</button><td>";
	        var cloneData = $('#qualtbody').clone();
	        cloneData.find("input").val('');
	        cloneData.find('#<portlet:namespace/>educational_Certificate1').prop("id", "educational_Certificate" + iCnt);
	        cloneData.append(markup);
	        $('#tbUser').append(cloneData);
	
	    } else {
	        $('#btAdd').attr('disabled', true);
	    }
}


function getEducationFileId(value) {
	fileElementIdNo = value.charAt(value.length - 1);
	if(educationFileId[fileElementIdNo-1]==undefined){
		educationFileId[fileElementIdNo-1]=0;
	}
	if(educationFileId[fileElementIdNo-1] > 0 ){
		updateFile(educationFileId[fileElementIdNo-1],document.getElementById(value).files[0], setEducationFileId);
	}
	else{
    	uploadFile(document.getElementById(value).files[0], setEducationFileId);
	}
 
}

function setEducationFileId(data){
	educationFileId[fileElementIdNo - 1] = data.fileEntryId;
    var employeeDocumentId = 0;
    var title = "Education Document";
    var discription = "Education Document";

    Liferay.Service(
        '/mdm.documenttype/get-document-type-id-by-name', {
            name: "Education Proof"
        },
        function(obj) {
            console.log(obj);
            this.documentTypeId = obj;
            var empDocument = new EmployeeDocument(employeeDocumentId, title, discription, documentTypeId, educationFileId[fileElementIdNo - 1], employeeId);
            documentList.push(empDocument);
            addDocument(documentList);
        }
	);	
}
var employeeQualificationIdArray = null;

function saveForm(onSuccess) {
   

    var qualificationArray = document.getElementsByName("<portlet:namespace/>educational_Qualification");
    var levelArray = document.getElementsByName("<portlet:namespace/>educational_Level");
    var specializationArray = document.getElementsByName("<portlet:namespace/>educational_Specialization");
    var gradeArray = document.getElementsByName("<portlet:namespace/>educational_Grade");
    var foreignDegreeArray = document.getElementsByName("<portlet:namespace/>educational_Foreign_Degree");
    var foreignInstitutionArray = document.getElementsByName("<portlet:namespace/>educational_Institution");
    var fromYearArray = document.getElementsByName("<portlet:namespace/>educational_From_Year");
    var toYearArray = document.getElementsByName("<portlet:namespace/>educational_To_Year");
    var qualificationDateArray = document.getElementsByName("<portlet:namespace/>educational_Qualification_Date");
    var marksPercentageArray = document.getElementsByName("<portlet:namespace/>educational_Marks_Percentage");

    employeeQualificationIdArray=document.getElementsByName("<portlet:namespace/>employeeQualificationId");
    for (var i = 0; i < iCnt; i++) {
        var employeeQualificationId = employeeQualificationIdArray[i].value;
        
        var qualificationId = qualificationArray[i].value;
        var levelId = levelArray[i].value;
        var specializationId = specializationArray[i].value;
        var gradeId = gradeArray[i].value;
        var foreignDegree = foreignDegreeArray[i].value;
        var foreignInstitution = foreignInstitutionArray[i].value;
        var fromYear = fromYearArray[i].value;
        var toYear = toYearArray[i].value;
        var qualificationDate = qualificationDateArray[i].value;
        var marksPercentage = marksPercentageArray[i].value;
        var documentProofId = educationFileId[i];
        var emp = new EmployeeQualifications(employeeQualificationId, qualificationId, levelId, specializationId, gradeId, foreignDegree, foreignInstitution, fromYear, toYear, qualificationDate, marksPercentage, documentProofId, employeeId);
        list.push(emp);
    }
    Liferay.Service(
        '/pis.employeequalification/add-employee-qualification', {
            employeeQualification: list
        },
        function(obj) {
            console.log(obj);
            this.list = obj;
            if(typeof obj == "string")
            if (obj.startsWith("error")) {
                $("#EducationErrorMessage").text(obj);
                validationBackendError = false;
            }
            this.employeeQualificationIdArray = [];
            for (i = 0; i < iCnt; i++) {
                this.employeeQualificationIdArray[i] = obj[i].employeeQualificationId;
            }
            this.list = new Array();
            if(validationBackendError){
				onSuccess();
				validationBackendError=true;
			}
        }
    );
    this.list = new Array();

}

class EmployeeQualifications {
    constructor(employeeQualificationId, qualificationId, levelId, specializationId, gradeId, foreignDegree, foreignInstitution, fromYear, toYear, qualificationDate, marksPercentage, documentProofId, employeeId) {
        this.employeeQualificationId = employeeQualificationId;
        this.qualificationId = qualificationId;
        this.levelId = levelId;
        this.specializationId = specializationId;
        this.gradeId = gradeId;
        this.foreignDegree = foreignDegree;
        this.foreignInstitution = foreignInstitution;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.qualificationDate = qualificationDate;
        this.marksPercentage = marksPercentage;
        this.certificateId = documentProofId;
        this.employeeId = employeeId;
    }
}

</script>