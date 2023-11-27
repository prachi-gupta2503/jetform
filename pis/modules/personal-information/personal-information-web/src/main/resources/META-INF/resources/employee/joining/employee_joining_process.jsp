<%@ include file="/init.jsp"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ include file="/employee/joining/init_ext.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/multistep.form.js"></script>

<link href="<%=request.getContextPath()%>/css/multistep.form.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<portlet:resourceURL id="<%=PISMVCPortletKeys.DOC_UPLOAD_RESOURCE %>" var="fileUploadUrl">
	
</portlet:resourceURL>
<div class="row justify-content-center mt-0">
	<div class="col-md-11 text-center p-0 mt-3 mb-2">
		<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
			<h2>
				<strong>New Joining</strong>
			</h2>
			<p>Fill all form field to go to next step</p>
			<div class="row">
				<div class="col-md-12 mx-0">
					<div id="msform">
					<aui:form name="employee-msform">
					
						<ul id="progressbar">
							<li class="active" id="personal"><strong>Personal</strong></li>
							<li id="address"><strong>Address</strong></li>
							<li id="education"><strong>Education</strong></li>
							<li id="work"><strong>Past Experience</strong></li>
							<li id="verification"><strong>Verification</strong></li>
							<li id="joining"><strong>Joining Details</strong></li>
							<li id="document"><strong>Documents</strong></li>
							<li id="permission"><strong>Permission</strong>
							
							<li id="confirm"><strong>Finish</strong></li>

						</ul>

						  <fieldset id="fs1">

							  <%@include file="/employee/joining/employee_personal_details_add.jsp"%>   
							<input type="button" name="next"
								onClick="savePersonalInformation()"
								class="btn btn-primary next action-button" value="Next" />
						</fieldset>  
						
						  <fieldset id="fs2">
							  <%@include file="/employee/joining/employee_address_detail_add.jsp"%>  
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button" name="next"
								onClick="addAddress()"
								class="btn btn-primary next action-button" value="Next Step">
						</fieldset>  
						 
						  <fieldset id="fs3">
							  <%@include file="/employee/joining/employee_qualification_add.jsp"%>  
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button" name="next"
								onClick="addQualification()"
								class="btn btn-primary next action-button" value="Next Step">
						
						</fieldset> 
						
						   <fieldset id="fs4">

							 <%@include file="/employee/joining/employee_work_experience_add.jsp"%>  
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button" name="next"
								onClick="addExperience()"
								class="btn btn-primary next action-button" value="Next Step">

						</fieldset> 
						

						 <fieldset id="fs5">

							 <%@include file="/employee/joining/employee_verification_add.jsp"%>  
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button" name="next"
								onClick="addEmployeeVerifications()"
								class="btn btn-primary next action-button" value="Next Step">

						</fieldset>
						<fieldset id="fs6">

							  <%@include file="/employee/joining/employee_joining_details_add.jsp"%>
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button"
								 name="next" onClick="saveJoiningDetail()"
								class="btn btn-primary next action-button" value="Next Step">
						</fieldset> 
						<fieldset id="fs7">
						<%@include file="/employee/joining/employee_documents_add.jsp"%>
						<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button"
								 name="next"
								class="btn btn-primary next action-button" value="Next Step" onclick=" addDocuments()">
						</fieldset>  
					 	 
						
						<fieldset id="fs8">
						
						 <%@include file="/employee/joining/employee_permission_add.jsp"%>
							<input type="button" name="previous"
								class="btn btn-secondary previous action-button-previous"
								value="Previous"> <input type="button"
								 name="next" onClick="addEmployeePermission()"
								class="btn btn-primary next action-button" value="Next Step">
						</fieldset>
						
						 
						
						
					</aui:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


 <script>
  
 	
	var identityProofId = null;
	var joiningLetterId = null;
	var certificate = null;
	var experience_Letter = null;
	var documentId = null;
	var permanentFileId=null;
	var residenceFileId=null;
	var employeeId=null;
	var experienceList=new Array();
	var workCnt=1;
	var workAreasList=new Array();
	var experienceFileId=[];
	var addressList=new Array();
	var permanentAddressId=null;
	var residenceAddressId=null;
	var documentTypeId=null;
	var profileImageId=null;
	function savePersonalInformation() {
		
		var firstName_English_ = $("#<portlet:namespace/>firstName_English_").val();
		var firstName_Hindi_ = $("#<portlet:namespace/>firstName_Hindi_").val();
		var middleName_English_ = $("#<portlet:namespace/>middleName_English_").val();
		var middleName_Hindi_ = $("#<portlet:namespace/>middleName_Hindi_").val();
		var lastName_English_ = $("#<portlet:namespace/>lastName_English_").val();
		var lastName_Hindi_ = $("#<portlet:namespace/>lastName_Hindi_").val();
		var dateOfBirth = $("#<portlet:namespace/>dateOfBirth").val();
		var fatherName_English_ = $("#<portlet:namespace/>fatherName_English_").val();
		var fatherName_Hindi_ = $("#<portlet:namespace/>fatherName_Hindi_").val();
		var aadhaarNo = $("#<portlet:namespace/>aadhaarNo").val();
		var panNo = $("#<portlet:namespace/>panNo").val();
		var height = $("#<portlet:namespace/>height").val();
		var color = $("#<portlet:namespace/>color").val();
		var identificationMark = $("#<portlet:namespace/>identificationMark").val();
		var gender = $("#<portlet:namespace/>inlineRadio1").val();
		var casteCategory = $("#<portlet:namespace/>inlineRadio2").val();
		var maritalStatus = $("#<portlet:namespace/>inlineRadio3").val();
		/* var citizenId = $("#<portlet:namespace/>citizen").val(); */
		var phTypeId = $("#<portlet:namespace/>phTypeId").val();
		var religionId = $("#<portlet:namespace/>religion").val();
		var bloodGroup = $("#<portlet:namespace/>bloodGroup").val();
		var appellation = $("#<portlet:namespace/>appellation").val();
		var exServiceMan = $("#<portlet:namespace/>ex_Service_Man").val();
		if(employeeId==null){
			this.employeeId=0;
		}
		try{
			console.log(identityProofId);
		 Liferay.Service(
				 '/pis.people/add-people',
				  {
					employeeId:employeeId,
				    dateOfBirth: dateOfBirth,
				    citizenId: 1 ,
				    phTypeId:phTypeId ,
				    religionId: religionId,
				    aadhaarNo: aadhaarNo,
				    panNo: panNo,
				    identityProofId: identityProofId,
				    color: color,
				    height: height,
				    identificationMark: identificationMark,
				    firstName_Hi: firstName_Hindi_,
				    lastName_Hi: lastName_Hindi_,
				    middleName_Hi: middleName_Hindi_,
				    firstName_En: firstName_English_,
				    fatherName_Hi: fatherName_Hindi_,
				    fatherName_En: fatherName_English_,
				    lastName_En: lastName_English_,
				    middleName_En: middleName_English_,
				    appellation: appellation,
				    bloodGroup: bloodGroup,
				    gender: gender,
				    castCategory: casteCategory,
				    maritalStatus: maritalStatus,
				    exServiceMan:exServiceMan
				  },
				  function(obj) {
				    console.log(obj);
				    this.employeeId=obj;
				    var employeeDocumentId=0;
					 var title="Personal Document";
					 var discription="Personal Document";
					 
					 Liferay.Service(
							 '/mdm.documenttype/get-document-type-id-by-name',
							  {
								 name: "Identity Proof"
							  },
							  function(obj) {
							    console.log(obj);
							    this.documentTypeId=obj;
							    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,identityProofId,employeeId);
								 documentList.push(empDocument);
								 addDocument(documentList);
							  });profileImageId
					Liferay.Service(
							 '/mdm.documenttype/get-document-type-id-by-name',
							  {
								 name: "Profile Image"
							  },
							  function(obj) {
							    console.log(obj);
							    this.documentTypeId=obj;
							    var title="Profile Image";
								 var discription="Profile Image";
							    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,profileImageId,employeeId);
								documentList.push(empDocument);
								addDocument(documentList);
							  });
				 
				  }
				);
		 
		}catch(error){
			document.getElementById("PersonalErrorMessage").innerHtml="Error= "+error;
		}
		
	}
	
	$(document).on('change', '#<portlet:namespace />customFile', function(){
	
	  var form_data = new FormData();
	 
	  form_data.append("file", document.getElementById('<portlet:namespace />customFile').files[0]);
	 $.ajax({
		    url:"<%=fileUploadUrl%>",
		    method:"POST",
		    data: form_data,
		    contentType:false,
		    cache: false,
		    processData: false,  
		    async:false,
		    success:function(data)
		    {
		    identityProofId=data; 		    
		    }
		   }); 
	 
});
	function getPermanentStates(value){
		  $("#<portlet:namespace />permanent-state").empty();
		  $('#<portlet:namespace />permanent-state').append(new Option('Select State', ''));
		Liferay.Service(
				'/mdm.state/get-states',
				  {
				    countryId:value 
				  },
				  
				  function(currentStates) {
					 
					  for (var i = 0; i < currentStates.length; i++) {
						   var id = currentStates[i]['stateId'];
		                    var name = currentStates[i]['name'];
	                    
						    $('#<portlet:namespace />permanent-state').append(new Option(name,id)); 
						   
		 
						}
				  }
				);
	}

	 

	 

	function getPermanentDistricts(value){
		  $("#<portlet:namespace />permanent-district").empty();
		  $('#<portlet:namespace />permanent-district').append(new Option('Select District', ''));
		Liferay.Service(
				'/mdm.district/get-district-list',
				  {
				    stateId: value
				  },
				  
				  
				  function(permanentDistricts) {
					  for (var i = 0; i < permanentDistricts.length; i++) {
						   var id = permanentDistricts[i]['districtId'];
		                    var name = permanentDistricts[i]['name'];
						   $('#<portlet:namespace />permanent-district').append(new Option(name,id));
						}
				  }
				);
	}



	function getResidenceStates(value){
		 $("#<portlet:namespace />residence-state").empty();
		  $('#<portlet:namespace />residence-state').append(new Option('Select State', ''));
		Liferay.Service(
				'/mdm.state/get-states',
				  {
				    countryId:value 
				  },
				  
				  
				  function(currentStates) {
					  for (var i = 0; i < currentStates.length; i++) {
						
						   var id = currentStates[i]['stateId'];
		                    var name = currentStates[i]['name'];
		              	  $('#<portlet:namespace />residence-state').append(new Option(name,id));
						}
				  }
				);
	}

	function getResidenceDistricts(value){
		 $("#<portlet:namespace />residence-district").empty();
		  $('#<portlet:namespace />residence-district').append(new Option('Select District', ''));
		Liferay.Service(
				'/mdm.district/get-district-list',
				  {
				    stateId: value
				  },
				  	  
				  function(residenceDistricts) {
					  for (var i = 0; i < residenceDistricts.length; i++) {
						   var id = residenceDistricts[i]['districtId'];
		                    var name = residenceDistricts[i]['name'];
							  $('#<portlet:namespace />residence-district').append(new Option(name,id));
						}
				  }
				);
	}

		 
	class Address{
		constructor(addressId,addressLine1,addressLine2,addressLine3,city,pinCode,countryId,stateId,districtId,addressProofId){
		this.addressId=addressId;
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.addressLine3=addressLine3;
		this.city=city;
		this.pinCode=pinCode;
		this.countryId=countryId;
		this.stateId=stateId;
		this.districtId=districtId;
		this.addressProofId=addressProofId;
		}
	}
	function addAddress(){
		var permanentAddress1=$("#<portlet:namespace />permanent-addressLine1").val();
		var permanentAddress2=$("#<portlet:namespace />permanent-addressLine2").val();
		var permanentAddress3=$("#<portlet:namespace />permanent-addressLine3").val();
		var permanentCity=$("#<portlet:namespace />permanent-city").val();
		var permanentCountry=$("#<portlet:namespace />permanent-country").val();
		var permanentState=$("#<portlet:namespace />permanent-state").val();
		var permanentDistrict=$("#<portlet:namespace />permanent-district").val();
		var permanentPinCode=$("#<portlet:namespace />permanent-pinCode").val();
	 	var residenceAddress1=$("#<portlet:namespace />residence-addressLine1").val();
		var residenceAddress2=$("#<portlet:namespace />residence-addressLine2").val();
		var residenceAddress3=$("#<portlet:namespace />residence-addressLine3").val();
		var residenceCity=$("#<portlet:namespace />residence-city").val();
		var residenceCountry=$("#<portlet:namespace />residence-country").val();
		var residenceState=$("#<portlet:namespace />residence-state").val();
		var residenceDistrict=$("#<portlet:namespace />residence-district").val();
		var residencePinCode=$("#<portlet:namespace />residence-pinCode").val();
		if(permanentAddressId==null){
			permanentAddressId=0;
			residenceAddressId=0;
		}
		
		var permanentAddressDetails=new Address(permanentAddressId,permanentAddress1,permanentAddress2,permanentAddress3,permanentCity,permanentPinCode,permanentCountry,permanentState,permanentDistrict,permanentFileId);
		var residenceAddressDetails=new Address(residenceAddressId,residenceAddress1,residenceAddress2,residenceAddress3,residenceCity,residencePinCode,residenceCountry,residenceState,residenceDistrict,residenceFileId);
		addressList.push(permanentAddressDetails);
		addressList.push(residenceAddressDetails);
		Liferay.Service(
				  '/pis.address/add-address',
				  {
				    addressDetails: addressList,
				    employeeId: employeeId
				  },
				  function(obj) {
				    console.log(obj);
				    this.addressList=obj;
				    address1=addressList[0];
				    address2=addressList[1];
				    this.permanentAddressId=address1.addressId;
					this.residenceAddressId=address2.addressId;
					this.addressList=new Array();
				  }
				);
		this.addressList=new Array();
	}
	
	
	 $(document).on('change', '#<portlet:namespace />file', function(){
			
		  var form_data = new FormData();
		  
		  form_data.append("file", document.getElementById('<portlet:namespace />file').files[0]);
		  
		 $.ajax({
			    url:"<%=fileUploadUrl%>",
			    method:"POST",
			    data: form_data,
			    contentType:false,
			    cache: false,
			    processData: false,  
			    async:false,
			    success:function(data)
			    {
			    permanentFileId=data;
			    var employeeDocumentId=0;
				 var title="Permanent Address Document";
				 var discription="Permanent Address Document";
				 
				 Liferay.Service(
						 '/mdm.documenttype/get-document-type-id-by-name',
						  {
							 name: "Address Proof"
						  },
						  function(obj) {
						    console.log(obj);
						    this.documentTypeId=obj;
						    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,permanentFileId,employeeId);
							 documentList.push(empDocument);
							 addDocument(documentList);
						  });
				 
			    }
			   }); 
		 
	});

			 function getResidenceFileId(){
		  var form_data = new FormData();
		  form_data.append("file", document.getElementById('<portlet:namespace />residencefile').files[0]);  
		 $.ajax({
			    url:"<%=fileUploadUrl%>",
			    method:"POST",
			    data: form_data,
			    contentType:false,
			    cache: false,
			    processData: false,  
			    async:false,
			    success:function(data)
			    {
			   
			    residenceFileId=data;
			    var employeeDocumentId=0;
				 var title="Residence Address Document";
				 var discription="Residence Address Document";
				 
				 Liferay.Service(
						 '/mdm.documenttype/get-document-type-id-by-name',
						  {
							 name: "Address Proof"
						  },
						  function(obj) {
						    console.log(obj);
						    this.documentTypeId=obj;
						    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,residenceFileId,employeeId);
							 documentList.push(empDocument);
							 addDocument(documentList);
						  });
				 
			    }
			   }); 
		 
			 }

		/*--------------Education------------------------------*/	 

			 var iCnt = 1;
			 var list=new Array();
			 var educationFileId=[];

			 
			 function getEducationFileId(value){
			 var Idno=value.charAt(value.length-1);
			 var form_data = new FormData();
			 form_data.append("file",document.getElementById(value).files[0]);
			 $.ajax({
			 url:"<%=fileUploadUrl%>",
			 method:"POST",
			 data: form_data,
			 contentType:false,
			 cache: false,
			 processData: false,
			 async:false,
			 success:function(data)
			 {
			 educationFileId[Idno-1]=data;
			 var employeeDocumentId=0;
			 var title="Education Document";
			 var discription="Education Document";
			 
			 Liferay.Service(
					 '/mdm.documenttype/get-document-type-id-by-name',
					  {
						 name: "Education Proof"
					  },
					  function(obj) {
					    console.log(obj);
					    this.documentTypeId=obj;
					    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,educationFileId[Idno-1],employeeId);
						 documentList.push(empDocument);
						 addDocument(documentList);
					  });
			 
		 
			 }
			 });

			 }
			 var employeeQualificationIdArray=null;
			 function addQualification(){
				 if(employeeQualificationIdArray==null){
					 
					 employeeQualificationIdArray=[];
						for(i=0;i<iCnt;i++){
							employeeQualificationIdArray[i]=0;	
						}
					}
					
					var qualificationArray=document.getElementsByName("<portlet:namespace/>educational_Qualification");
					var levelArray=document.getElementsByName("<portlet:namespace/>educational_Level");
					var specializationArray=document.getElementsByName("<portlet:namespace/>educational_Specialization");
					var gradeArray=document.getElementsByName("<portlet:namespace/>educational_Grade");
					var foreignDegreeArray=document.getElementsByName("<portlet:namespace/>educational_Foreign_Degree");
					var foreignInstitutionArray=document.getElementsByName("<portlet:namespace/>educational_Institution");
					var fromYearArray=document.getElementsByName("<portlet:namespace/>educational_From_Year");
					var toYearArray=document.getElementsByName("<portlet:namespace/>educational_To_Year");
					var qualificationDateArray=document.getElementsByName("<portlet:namespace/>educational_Qualification_Date");
					var marksPercentageArray=document.getElementsByName("<portlet:namespace/>educational_Marks_Percentage");
				
					
					for(var i = 0 ; i < iCnt ; i++){
						var employeeQualificationId=employeeQualificationIdArray[i];
						var documentProofId=educationFileId[i];
						var qualificationId=qualificationArray[i].value;
						var levelId=levelArray[i].value;
						var specializationId=specializationArray[i].value;
						var gradeId=gradeArray[i].value;
						var foreignDegree=foreignDegreeArray[i].value;
						var foreignInstitution=foreignInstitutionArray[i].value;
						var fromYear=fromYearArray[i].value;
						var toYear=toYearArray[i].value;
						var qualificationDate=qualificationDateArray[i].value;
						var marksPercentage=marksPercentageArray[i].value;
						var documentProofId=educationFileId[i];
					 var emp=new EmployeeQualifications(employeeQualificationId,qualificationId, levelId, specializationId, gradeId, foreignDegree, foreignInstitution, fromYear, toYear, qualificationDate, marksPercentage,documentProofId,employeeId);
					 list.push(emp);
					}
					 Liferay.Service(
								'/pis.employeequalification/add-employee-qualification',
								 {
								 employeeQualification:list
								 },
								 function(obj) {
								 console.log(obj);
								 this.list=obj;
									this.employeeQualificationIdArray=[];
									for(i=0;i<iCnt;i++){
										this.employeeQualificationIdArray[i]=obj[i].employeeQualificationId;
									}
									this.list=new Array();
								 
								    alert("Successfully added");
								 }
								 );
					 this.list=new Array();
		
			 }
			 
			 
			 

			 $('#btAdd').click(function() {
				 
			 iCnt = iCnt + 1;

			 if (iCnt <= 8) {

			 var markup="<td><input type='button' id='btnRemove' name='btnRemove' value='Remove' class='bt'/><td>";	
			 var cloneData = $('#qualtbody').clone();
			 cloneData.find("input").val('');
			 cloneData.find('#<portlet:namespace/>educational_Certificate1').prop("id","educational_Certificate"+iCnt);
			 cloneData.append(markup);
			$('#tbUser').append(cloneData);

			 }
			 else{
			 $('#btAdd').attr('disabled', true);
			 }
			 });
			 $("#tbUser").on('click', '#btnRemove', function () {

			 $(this).closest('tbody').remove();
			 $('#btAdd').attr('disabled', false);
			 iCnt=iCnt-1;
			 });

	


			 class EmployeeQualifications {
			 constructor(employeeQualificationId,qualificationId, levelId, specializationId, gradeId, foreignDegree, foreignInstitution, fromYear, toYear, qualificationDate, marksPercentage,documentProofId,employeeId) {
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
			 this.certificateId=documentProofId;
			 this.employeeId=employeeId;
			 }
			 }

			 
			 /*----------------experience--------------*/
			 Liferay.Service(
				'/mdm.workarea/get-work-areas',
				function(obj) {
					console.log(obj);
					for(var i=0 ; i < obj.length ; i++){
						workAreasList[i]=obj[i];
					}
				});
				
				$('#btnAdd1').click(function() {
					
					workCnt = workCnt + 1;
					
					if (workCnt <= 8) {
					
					var markup="<td><input type='button' id='btnRemove' name='btnRemove' value='Remove' class='bt'/><td>";	
					 var cloneData = $('#worktbody').clone();
					 cloneData.find("input").val('');
					 cloneData.find('#<portlet:namespace/>experience_Experience_Letter1').prop("id","experience_Experience_Letter"+workCnt);
					 cloneData.append(markup);
					$('#workUser').append(cloneData);
						workAreaOptions();
					}
					else{
						$('#btnAdd1').attr('disabled', true);
					}
				});
				
				 $("#workUser").on('click', '#btnRemove', function () {
                         
						 $(this).closest('tbody').remove();
						 $('#btAdd1').attr('disabled', false);
						 workCnt=workCnt-1;
						 }); 
				

				function workAreaOptions() {
					for(i = 0 ; i < workAreasList.length ; i++){
						var optionName=workAreasList[i].name;
						var optionValue=workAreasList[i].workAreaId;
						$('#experience_Work_Area'+workCnt).append(new Option(optionName, optionValue));
					}
				}


			
				function getExperienceFileId(value){
					
					var Idno=value.charAt(value.length-1);
					 
					var form_data = new FormData();
					form_data.append("file",document.getElementById(value).files[0]);
					

					$.ajax({
						url:"<%=fileUploadUrl%>",
						method:"POST",
						data: form_data,
						contentType:false,
						cache: false,
						processData: false,
						async:false,
						success:function(data)
						{
							
							experienceFileId[Idno-1]=data;
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
									    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,experienceFileId[Idno-1],employeeId);
										 documentList.push(empDocument);
										 addDocument(documentList);
									  });
							 
						 
							
						}
					});

				} 

				var employeePastExperienceIdArray=null;
			function addExperience(){
				
			
				if(employeePastExperienceIdArray==null){
					employeePastExperienceIdArray=[];
					
					for(i=0;i<workCnt;i++){
						employeePastExperienceIdArray[i]=0;	
					}
				
				}
				
				
				var organizationArray=document.getElementsByName("<portlet:namespace/>experience_Organization");
				var designationArray=document.getElementsByName("<portlet:namespace/>experience_Designation");
				var workAreaArray=document.getElementsByName("<portlet:namespace/>experience_Work_Area");
				var fromDateArray=document.getElementsByName("<portlet:namespace/>experience_From_Date");
				var toDateArray=document.getElementsByName("<portlet:namespace/>experience_To_Date");
				
				
				for(var i = 0 ; i < workCnt ; i++){
					
					var employeePastExperienceId=employeePastExperienceIdArray[i];
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
							this.employeePastExperienceIdArray=[];
							for(i=0;i<workCnt;i++){
								this.employeePastExperienceIdArray[i]=obj[i].employeePastExperienceId;
							}
							this.experienceList=new Array();
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
			 
				/*-----------------joining Letter-----------------*/
				
			 $(document).on('change', '#<portlet:namespace />joining_joiningLetter', function(){
					
				  var form_data = new FormData();
				  
				  form_data.append("file", document.getElementById('<portlet:namespace />joining_joiningLetter').files[0]);
				  
				 $.ajax({
					    url:"<%=fileUploadUrl%>",
					    method:"POST",
					    data: form_data,
					    contentType:false,
					    cache: false,
					    processData: false,  
					    async:false,
					    success:function(data)
					    {
					    
					    joiningLetterId=data;
					    var employeeDocumentId=0;
						 var title="Joining Document";
						 var discription="Joining Document";
						 
						 var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,joiningLetterId,employeeId);
						 documentList.push(empDocument);
						 addDocument(documentList);
					    }
					   }); 
			});

			 var employeeJoiningId
			 function saveJoiningDetail() {
					
				 	if(this.employeeJoiningId==null){
				 		this.employeeJoiningId=0;
				 	}
					var aadhaarNo = $("#<portlet:namespace/>joining_aadhaarNo").val();
					var emailAddress = $("#<portlet:namespace/>joining_emailAddress").val();
					var panNo = $("#<portlet:namespace/>joining_panNo").val();
					var personalNo = $("#<portlet:namespace/>joining_personalNo").val();
					var peopleId = $("#<portlet:namespace/>joining_people").val();
					var fullName = $("#<portlet:namespace/>joining_fullName").val();
					var designationId = $("#<portlet:namespace/>joining_designation").val();
					var gradeId = $("#<portlet:namespace/>joining_grade").val();
					var payLevelId = $("#<portlet:namespace/>joining_payLevel").val();
					var postId = $("#<portlet:namespace/>joining_post").val();
					var tradeId = $("#<portlet:namespace/>joining_trade").val();
					var organizationId = $("#<portlet:namespace/>joining_unit").val();
					var designationClassId = $("#<portlet:namespace/>joining_designationClass").val();
					var designationGroupId = $("#<portlet:namespace/>joining_designationGroup").val();
					var joiningModeId = $("#<portlet:namespace/>joining_joiningMode").val();
					
					var gradeModeId = $("#<portlet:namespace/>joining_gradeMode").val();
					var fromDate = $("#<portlet:namespace/>joining_fromDate").val();
					var toDate = $("#<portlet:namespace/>joining_toDate").val();
					var selectionDate = $("#<portlet:namespace/>joining_selectionDate").val();
					var joiningDate = $("#<portlet:namespace/>joining_joiningDate").val();
					var confirmationDate = $("#<portlet:namespace/>joining_confirmationDate").val();
					var gradeConfirmationDate = $("#<portlet:namespace/>joining_gradeConfirmationDate").val();
					var govtServiceDate = $("#<portlet:namespace/>joining_govtServiceDate").val();
					var recruitmentBatch = $("#<portlet:namespace/>joining_recruitmentBatch").val();
					try{
						
					
					Liferay.Service(
							'/pis.employeejoining/add-employee-joining-details',
							  {
								employeeJoiningId:employeeJoiningId,
							    aadhaarNo: aadhaarNo,
							    emailAddress: emailAddress,
							    panNo: panNo,
							    personalNo: personalNo,
							    peopleId : peopleId ,
							    fullName : fullName,
							    designationId : designationId,
							    gradeId : gradeId ,
							    payLevelId : payLevelId,
							    postId : postId,
							    tradeId :tradeId,
							    organizationId : organizationId,
							    designationClassId : designationClassId,
							    designationGroupId : designationGroupId,
							    joiningModeId : joiningModeId,
							    joiningLetterId : joiningLetterId,
							    gradeModeId : gradeModeId,
							    fromDate : fromDate,
							    toDate : toDate,	
							    selectionDate : selectionDate ,
							    joiningDate : joiningDate,
							    confirmationDate : confirmationDate ,
							    gradeConfirmationDate : gradeConfirmationDate ,
							    govtServiceDate : govtServiceDate ,
							    recruitmentBatch: recruitmentBatch,
							    employeeId: employeeId
							  },
							  function(obj) {
							    console.log(obj);
							    this.employeeJoiningId=obj.employeeJoiningId;
							  }
							);
					}catch(error){
						document.getElementById("JoiningErrorMessage").innerHtml="Error= "+error;
					}
					
			}


			 /* Verification */


			 var verificatonList=new Array();
			 var verCnt=1;


			 $('#verBtnAdd').click(function() {
			 
			 verCnt = verCnt + 1;
			 
			 if (verCnt <= 8) {
			

			 var markup="<td><input type='button' id='btnRemove' name='btnRemove' value='Remove' class='bt'/><td>";	
			 var cloneData = $('#vertbody').clone();
			 cloneData.find("input").val('');
			 cloneData.find('#<portlet:namespace/>verification_Document1').prop("id","verification_Document"+verCnt);
			 cloneData.append(markup);
			$('#vertable').append(cloneData);

			 }
			 else{
			 $('#verBtnAdd').attr('disabled', true);
			 }
			 });
			 $("#vertable").on('click', '#btnRemove', function () {

			 $(this).closest('tbody').remove();
			 $('#verBtnAdd').attr('disabled', false);
			 verCnt=verCnt-1;
			 });

			 var verificationFileId=[];
			 function getVerificationFileId(value){
			 
			 var Idno=value.charAt(value.length-1);
			 
			 var form_data = new FormData();
			 form_data.append("file",document.getElementById(value).files[0]);
			 $.ajax({
			 url:"<%=fileUploadUrl%>",
			 method:"POST",
			 data: form_data,
			 contentType:false,
			 cache: false,
			 processData: false,
			 async:false,
			 success:function(data)
			 {
			 
			 verificationFileId[Idno-1]=data;
			 var employeeDocumentId=0;
			 var title="Verification Document";
			 var discription="Verification Document";
			 
			 Liferay.Service(
					 '/mdm.documenttype/get-document-type-id-by-name',
					  {
						 name: "Verification Proof"
					  },
					  function(obj) {
					    console.log(obj);
					    this.documentTypeId=obj;
					    var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId, verificationFileId[Idno-1],employeeId);
						 documentList.push(empDocument);
						 addDocument(documentList);
					  });
			
			 }
			 });

			 }

			 var employeeVerificationIdArray =null;
			 function addEmployeeVerifications(){
			
				 if(employeeVerificationIdArray==null){
					 employeeVerificationIdArray=[];
						
						for(i=0;i<verCnt;i++){
							employeeVerificationIdArray[i]=0;	
						}
					
					}
				 var documentNoArray = document.getElementsByName("<portlet:namespace/>verification_Document_No");
				 
				 var verificationTypeIdArray =document.getElementsByName("<portlet:namespace/>verification_Type");
				 
				 var verificationDateArray = document.getElementsByName("<portlet:namespace/>verification_Date");
				 var authorityArray = document.getElementsByName("<portlet:namespace/>verification_Authority");
				 var remarksArray = document.getElementsByName("<portlet:namespace/>verification_Remarks");
				 
				 for(var i = 0 ; i < verCnt ; i++){
					var employeeVerificationId= employeeVerificationIdArray[i];
					
					var documentNo=documentNoArray[i].value;
					 
					var verificationTypeId=verificationTypeIdArray[i].value;
					var verificationDate=verificationDateArray[i].value;
					var authority=authorityArray[i].value;
					var remarks=remarksArray[i].value;
					var documentId=verificationFileId[i];
				 var empVerification=new EmployeeVerification(employeeVerificationId,documentNo,verificationTypeId,verificationDate,authority,remarks,documentId,employeeId);
				 verificatonList.push(empVerification);
				 console.log(empVerification);
				 }
			 Liferay.Service(
			 '/pis.employeeverification/add-employee-verifications',
			 {
			 employeeVerifications: verificatonList
			 },
			 function(obj) {
			 console.log(obj);
			 this.verificatonList=obj;
				this.employeeVerificationIdArray=[];
				for(i=0;i<verCnt;i++){
					this.employeeVerificationIdArray[i]=obj[i].employeeVerificationId;
					
				}
				this.verificatonList=new Array();
			 alert("successfully added");
			 }
			 );
			 this.verificatonList=new Array();
			 }

			 class EmployeeVerification {
			 constructor(employeeVerificationId,documentNo,verificationTypeId,verificationDate,authority,remarks,documentId,employeeId){
			 
				 this.employeeVerificationId=employeeVerificationId;
				 this.documentNo = documentNo;
			 this.verificationTypeId = verificationTypeId;
			 this.verificationDate = verificationDate;
			 this.authority = authority;
			 this.remarks = remarks;
			 this.documentId = documentId;
			 this.employeeId=employeeId;
			 }
			 }

			

			 
			 /* Documents */

			 var documentList=new Array();
			 var documentCnt=1;
			 var documentTypeList=new Array();

		
			 $('#docBtnAdd').click(function() {
			 
			 documentCnt = documentCnt + 1;
			 
			 if (documentCnt <= 8) {
			 

		

			 var markup="<td><input type='button' id='btnRemove' name='btnRemove' value='Remove' class='bt'/><td>";	
			 var cloneData = $('#doctbody').clone();
			 cloneData.find("input").val('');
			 cloneData.find('#<portlet:namespace/>employee_document1').prop("id","employee_document"+documentCnt);
			 cloneData.append(markup);
			$('#doctable').append(cloneData);
	
			 }
			 else{
			 $('#docBtnAdd').attr('disabled', true);
			 }
			 });
			 $("#doctable").on('click', '#btnRemove', function () {

			 $(this).closest('tbody').remove();
			 $('#docBtnAdd').attr('disabled', false);
			 documentCnt=documentCnt-1;
			 });


			 var documentFileId=[];
			 function getDocumentFileId(value){
			 
			 var Idno=value.charAt(value.length-1);
			 
			 var form_data = new FormData();
			 form_data.append("file",document.getElementById(value).files[0]);
			 $.ajax({
			 url:"<%=fileUploadUrl%>",
			 method:"POST",
			 data: form_data,
			 contentType:false,
			 cache: false,
			 processData: false,
			 async:false,
			 success:function(data)
			 {
			 
			 documentFileId[Idno-1]=data;
			 
			 }
			 });

			 }

			 var employeeDocumentIdArray=null;
			 function addDocuments(){
			 
			 if(employeeDocumentIdArray==null){
				 employeeDocumentIdArray=[];
					
					for(i=0;i<documentCnt;i++){
						employeeDocumentIdArray[i]=0;	
					}
				
				}
			 var titleArray = document.getElementsByName("<portlet:namespace/>document_title");
			 var discriptionArray = document.getElementsByName("<portlet:namespace/>document_discription");
			 var documentTypeIdArray = document.getElementsByName("<portlet:namespace/>document_type");
			 for(var i = 0 ; i < documentCnt ; i++){
				 
				 var employeeDocumentId=employeeDocumentIdArray[i];
				 var title=titleArray[i].value;
				 var discription=discriptionArray[i].value;
				 var documentTypeId=documentTypeIdArray[i].value;
				 var documentId=documentFileId[i];
				 var empDocument=new EmployeeDocument(employeeDocumentId,title,discription,documentTypeId,documentId,employeeId);
				 documentList.push(empDocument);
			 
			 }
			 Liferay.Service(
					 '/pis.employeedocument/add-employee-document',
					  {
					    employeeDocument: documentList
					  },
					  function(obj) {
					    console.log(obj);
					    this.documentList=obj;
						this.employeeDocumentIdArray=[];
						for(i=0;i<documentCnt;i++){
							this.employeeDocumentIdArray[i]=obj[i].employeeDocumentId;
						}
						this.documentList=new Array();
					 
					    alert("Successfully added");
					  }
					);
			 this.documentList=new Array();
			 }

			 class EmployeeDocument {
			 constructor(employeeDocumentId,title,discription,documentTypeId,documentId,employeeId){
			 this.employeeDocumentId = employeeDocumentId;
			 this.title = title;
			 this.discription = discription;
			 this.documentTypeId = documentTypeId;
			 this.documentId = documentId;
			 this.employeeId =employeeId;
			 }
			 }
			 
			function addDocument(documentList){
				 Liferay.Service(
						 '/pis.employeedocument/add-employee-document',
						  {
						    employeeDocument: documentList
						  },
						  function(obj) {
						    console.log(obj);
						    this.documentList=obj;
							this.documentList=new Array();
						 
						    alert("Successfully added");
						  }
						);
				 this.documentList=new Array();
			 }

			 /*----------permission---------------*/

			 var applicationIds=[];
			 var applicationList=new Array();
			function addEmployeePermission(){
				
					  var markedCheckbox = document.getElementsByName('appl');
					  alert(markedCheckbox.length);
					  for (var checkbox of markedCheckbox) {  
					    if (checkbox.checked)  
					    	applicationIds.push(checkbox.value);
					       
					  }  
					  console.log(applicationIds);
				 for(var i=0;i<applicationIds.length;i++){
						 var applicationId=applicationIds[i];
				 
				 var employeeApplication=new EmployeeApplication(applicationId,employeeId);
						console.log(employeeApplication);
						applicationList.push(employeeApplication); 
						 
					 }
					  Liferay.Service(
							  '/pis.employeeapplication/add-employee-applications',
							  {
							    employeeApplications: applicationList
							  },
							  function(obj) {
							    console.log(obj);
							    alert("successfully added");
							  }
							); 
					 
					 
					} 
			
			
			
			 class EmployeeApplication{
				 constructor(applicationId,employeeId){
					 this.applicationId=applicationId;
					 this.employeeId=employeeId;
				 }
			 }
			 
			 
			 $("#profileimg").click(function(e) {
				    $("#imageUpload").click();
				});

				function fasterPreview( uploader ) {
				    if ( uploader.files && uploader.files[0] ){
				          $('#profileImage').attr('src', 
				             window.URL.createObjectURL(uploader.files[0]) );
				    }
				}
				$(document).on('change', '#<portlet:namespace />imageUpload', function(){
					  var form_data = new FormData();
						 
					  form_data.append("file", document.getElementById('<portlet:namespace />imageUpload').files[0]);
					 $.ajax({
						    url:"<%=fileUploadUrl%>",
						    method:"POST",
						    data: form_data,
						    contentType:false,
						    cache: false,
						    processData: false,  
						    async:false,
						    success:function(data)
						    {
						    	profileImageId=data; 		    
						    }
						   }); 
				    fasterPreview( this );
				});
			
</script> 