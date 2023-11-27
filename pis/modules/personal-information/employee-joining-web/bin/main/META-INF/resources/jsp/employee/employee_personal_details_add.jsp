<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.PhType"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.CasteCategory"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.MaritalStatus"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.Gender"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.model.BloodGroup"%>
<%@page import="com.adjecti.mdm.liferay.service.PhTypeLocalServiceUtil"%>
<%@page
	import="com.adjecti.mdm.liferay.service.ReligionLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.adjecti.pis.liferay.service.PeopleLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page
	import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalService"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page
	import="com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Religion"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.AppellationEnum"%>
<%@page import="java.util.EnumSet"%>
<%@ include file="../../init.jsp"%>

<%
	List<BloodGroup> bloodGroupList = EnumerationEntityServiceUtil.getBloodGroups();
	List<MaritalStatus> maritalStatusList = EnumerationEntityServiceUtil.getMaritalStatuses();
	List<CasteCategory> casteCategoryList = EnumerationEntityServiceUtil.getCasteCategorys();
	List<Gender> genderList = EnumerationEntityServiceUtil.getGenders();
	List<Religion> religionList = ReligionLocalServiceUtil.getReligions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<PhType> phTypeList = PhTypeLocalServiceUtil.getPhTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Country> countryList = CountryServiceUtil.getCountries();
	Employee employee = null;
	People people = null;
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);
	if (employeeId != 0) {
		employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		people = PeopleLocalServiceUtil.getPeople(employee.getPeopleId());

	} else {
		employee = EmployeeLocalServiceUtil.createEmployee(employeeId);
		people = PeopleLocalServiceUtil.createPeople(0);
	}
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
%>



<div class="card form-card m-4">
<div class="card-header bg-primary text-white">
	<h5>Personal Information</h5>
</div>
<div class="card-body">
<aui:form>
	
	<div class="text-right" style="width: 100%;">

		<img alt="Profile image" id="profileImage"
			style="width: 100px; height: 100px;"
			src="<%=request.getContextPath()%>/image/employee-image.png">


	</div>
	<div class="text-right" style="width: 100%;">

		<aui:input label="Update Profile Image" name="imageUpload"
			id="imageUpload" style="display: none;" type="file">
		</aui:input>

	</div>
	<p id="PersonalErrorMessage"></p>

	<div class="row">
		<div class="form-group required col-md-6">

			<aui:select label="Appellation" class="form-control"
				name="appellationId">
				<aui:option value="">Select Appellation</aui:option>
				<%
					for (AppellationEnum appellation : AppellationEnum.values()) {
								boolean selected = false;
								if (people.getAppellationId() == appellation.getAppellation()) {
									selected = true;
								}
				%>
				<aui:option value="<%=appellation.getAppellation()%>"
					selected="<%=selected%>"><%=appellation.name()%></aui:option>
				<%
					}
				%>
				<aui:validator errorMessage="Select an appellation" name="required" />
			</aui:select>

		</div>



	</div>

	<div class="row">


		<div class="form-group  col-md-6">

			<aui:input label="First Name( English)" name="firstName_En"
				type="text" value="<%=people.getFirstName_En()%>">
				<aui:validator errorMessage="The first name is a required field"
					name="required" />
				<aui:validator name="maxLength">20</aui:validator>
				<aui:validator errorMessage="Allows (A-Z) characters only"
					name="alpha" />
			</aui:input>
		</div>

		<div class="form-group  col-md-6">
			<aui:input label="First Name( Hindi)" name="firstName_Hi" type="text"
				value="<%=people.getFirstName_Hi()%>">
				<aui:validator errorMessage="The first name is a required field"
					name="required" />
				<aui:validator name="maxLength">20</aui:validator>
				
			</aui:input>
		</div>




	</div>

	<div class="row">

		<div class="form-group  col-md-6">
			<aui:input label="Middle Name( English)" name="middleName_En"
				type="text" value="<%=people.getMiddleName_En()%>">
				<aui:validator name="maxLength">20</aui:validator>
				<aui:validator errorMessage="Allows (A-Z) characters only"
					name="alpha" />
			</aui:input>

		</div>

		<div class="form-group  col-md-6">
			<aui:input label="Middle Name( Hindi)" name="middleName_Hi"
				id="middleName_Hi" type="text"
				value="<%=people.getMiddleName_Hi()%>">
				<aui:validator name="maxLength">20</aui:validator>
				
			</aui:input>

		</div>






	</div>

	<div class="row">


		<div class="form-group  col-md-6">
			<aui:input label="Last Name( English)" name="lastName_En" type="text"
				value="<%=people.getLastName_En()%>">

				<aui:validator errorMessage="The Last Name is a required field"
					name="required" />
				<aui:validator name="maxLength">20</aui:validator>
				<aui:validator errorMessage="Allows (A-Z) characters only"
					name="alpha" />

			</aui:input>
		</div>
		<div class="form-group  col-md-6">
			<aui:input label="Last Name( Hindi)" name="lastName_Hi" type="text"
				value="<%=people.getLastName_Hi()%>">
				<aui:validator errorMessage="The Last Name is a required field"
					name="required" />
				<aui:validator name="maxLength">20</aui:validator>
				

			</aui:input>
		</div>




	</div>

	<div class="row">



		<div class="form-group  col-md-6">
			<aui:input label="Father Name( English)" name="fatherName_En"
				id="fatherName_En" type="text"
				value="<%=people.getFatherName_En()%>">
				
				<aui:validator name="maxLength">50</aui:validator>

			</aui:input>

		</div>


		<div class="form-group  col-md-6">
			<aui:input label="Father Name( Hindi)" name="fatherName_Hi"
				id="fatherName_Hi" type="text" value="<%=people.getFirstName_Hi()%>">
				
				<aui:validator name="maxLength">50</aui:validator>
			</aui:input>
		</div>

	</div>


	<div class="row">


		<div class="form-group required col-md-6">
			<aui:input label="Date of Birth" name="dateOfBirth" id="dateOfBirth"
				type="date"
				value="<%=people.getDateOfBirth() != null ? simpleDateFormat.format(people.getDateOfBirth()) : null%>">
				<aui:validator errorMessage="Please select a valid date of birth."
					name="required" />
			</aui:input>
		</div>
		<div class="form-group required col-md-6">
			<aui:input label="Ex Service Man" type="checkbox" name="exServiceMan"
				class="form-control" id="exServiceMan"
				value="<%=people.getExServiceMan()%>" />

		</div>
	</div>

	<div class="row">


		<div class="form-group required col-md-6">
			<aui:input label="Aadhaar No" name="aadhaarNo" id="aadhaarNo"
				type="text" value="<%=people.getAadhaarNo()%>">
				<aui:validator errorMessage="The Aadhaar No is a required field"
					name="required" />
				<aui:validator errorMessage="Allows (0-9) characters only"
					name="number" />
				<aui:validator name="maxLength">12</aui:validator>

			</aui:input>
		</div>


		<div class="form-group required col-md-6">
			<aui:input label="Pan No" name="panNo" id="panNo" type="text"
				value="<%=people.getPanNo()%>">
				<aui:validator errorMessage="The Pan No is a required field"
					name="required" />
				<aui:validator errorMessage="Allows (A-Z,0-9) characters only"
					name="alphanum" />
				<aui:validator name="maxLength">10</aui:validator>

			</aui:input>
		</div>

	</div>

	<div class="row">

		<div class="form-group required col-md-6">
			<aui:select label="Religion" class="form-control" name="religion"
				value="<%=people.getReligionId()%>">
				<aui:option selected="">Select Religion</aui:option>
				<%
					for (Religion religion : religionList) {
								boolean selected = false;
								if (people.getReligionId() == religion.getReligionId()) {
									selected = true;
								}
				%>

				<aui:option value="<%=religion.getReligionId()%>"
					selected="<%=selected%>"><%=religion.getName()%></aui:option>
				<%
					}
				%>
				<aui:validator errorMessage="Select a religion." name="required" />
			</aui:select>

		</div>
<div class="form-group required col-md-6">
	 <aui:select class="form-control" label="Citizen" name="citizen"  value="<%=people.getCitizenshipId()%>">
					<aui:option selected="">Select Citizen</aui:option>
					<%
						for (Country country : countryList) {
							boolean selected = false;
							if (people.getCitizenshipId() == country.getCountryId()) {
								selected = true;
							}
					%>
					<aui:option value="<%=country.getCountryId()%>"  selected="<%=selected%>"><%=country.getName()%></aui:option>
					<%
						}
					%>
					
					<aui:validator  errorMessage="Select a citizen."
					   name="required" />
				</aui:select>
 
</div>

	</div>

	<div class="row">


		<div class="form-group required col-md-6">
			<aui:select class="form-control" label="Blood Group"
				name="bloodGroup" value="<%=people.getBloodGroupId()%>">
				<option selected="">Select Blood Group</option>
				<%
					for (BloodGroup bloodGroup : bloodGroupList) {
								boolean selected = false;
								if (people.getBloodGroupId() == bloodGroup.getId()) {
									selected = true;
								}
				%>

				<aui:option value="<%=bloodGroup.getId()%>" selected="<%=selected%>"><%=bloodGroup.getName()%></aui:option>
				<%
					}
				%>
				<aui:validator errorMessage="Select a blood group." name="required" />
			</aui:select>

		</div>


		
		<div class="form-group required col-md-6">
			<aui:select label="Physical Handicap Type" class="form-control"
				name="phTypeId" id="phTypeId" value="<%=people.getPhTypeId()%>">
				<option selected="">Select Physical Handicap Type</option>
				<%
					for (PhType phType : phTypeList) {
								boolean selected = false;
								if (people.getBloodGroupId() == phType.getPhTypeId()) {
									selected = true;
								}
				%>
				<aui:option value="<%=phType.getPhTypeId()%>"
					selected="<%=selected%>"><%=phType.getName()%></aui:option>
				<%
					}
				%>
				<aui:validator errorMessage="Select a physical handicap type."
					name="required" />

			</aui:select>

		</div>

		


	</div>

	<div class="row">


		<div class="form-group  col-md-6">
			<aui:input label="Height" name="height" id="height" type="number"
				value="<%=people.getHeight()%>" />


		</div>


		<div class="form-group  col-md-6">
			<aui:input label="Color" name="color" id="color" type="text"
				value="<%=people.getColor()%>" />

		</div>

	</div>

	<div class="row">


		<div class="form-group  col-md-6">
			<aui:input label="Identification Mark" name="identificationMark"
				id="identificationMark" type="text"
				value="<%=people.getIdentificationMark()%>" />
		</div>


		<div class="form-group required col-md-6">
			<label class="control-label" for="exampleInputEmail1">Gender<span class="text-danger"> *</span></label>

			<%
				for (Gender gender : genderList) {
						boolean checked = false;
						if (people.getGenderId() == gender.getId()) {
							checked = true;
						}
			%>

			<div>
				<div class="form-check form-check-inline">

					<aui:input type="radio" value="<%=gender.getId()%>"
						label="<%=gender.getName()%>" name="gender" checked="<%=checked%>">
					</aui:input>
				</div>
			</div>
			<%
				}
			%>


		</div>

	</div>

	<div class="row">


		<div class="form-group required col-md-6">
			<label class="control-label">Caste Category<span class="text-danger">*</span></label>


			<%
				for (CasteCategory casteCategory : casteCategoryList) {
						boolean checked = false;
						if (people.getCasteCategoryId() == casteCategory.getId()) {
							checked = true;
						}
			%>

			<div>
				<div class="form-check form-check-inline">

					<aui:input type="radio" value="<%=casteCategory.getId()%>"
						label="<%=casteCategory.getName()%>" name="castCategory"
						checked="<%=checked%>">
					</aui:input>
				</div>
			</div>
			<%
				}
			%>

		</div>


		<div class="form-group required col-md-6">
			<label class="control-label">Marital Status<span class="text-danger">*</span></label>


			<%
				for (MaritalStatus maritalStatus : maritalStatusList) {
						boolean checked = false;
						if (people.getMaritalStatusId() == maritalStatus.getId()) {
							checked = true;
						}
			%>
			<div>
				<div class="form-check form-check-inline">
					<aui:input type="radio" value="<%=maritalStatus.getId()%>"
						label="<%=maritalStatus.getName()%>" name="maritalStatus"
						checked="<%=checked%>">
					</aui:input>


				</div>
			</div>
			<%
				}
			%>

		</div>

	</div>

	<div class="row">


		<div class="form-group  col-md-6">
			<aui:input label="Identity Proof" name="customFile" id="customFile"
				type="file">
				<aui:validator name="acceptFiles">'pdf,jpeg,png'</aui:validator>
			</aui:input>
		</div>

	</div>
</aui:form>
</div>
</div>
<script>
	var profileImageId = '0';
	var identityProofId = '0';
	

	
	$(document).ready(function() {
		var fileEntryId=<%= people.getProfileImageId()%>
		identityProofId=<%=people.getIdentityProofId() %>
		profileImageId=fileEntryId;
		if(fileEntryId > 0){
			
			Liferay.Service(
					  '/dlapp/get-file-entry',
					  {
					    fileEntryId: fileEntryId
					  },
					  function(obj) {
					    console.log(obj);
					    var fileEntry=obj;
					    $('#profileImage').attr('src',
								'/documents/'+fileEntry.repositoryId+fileEntry.treePath+fileEntry.fileName);
					  }
					);
			
		}
		
		$('#<portlet:namespace />imageUpload').change(function(e) {
			
			let fileId=<%=people.getProfileImageId() %>
			if(fileId == 0)
				uploadFile(e.target.files[0], setProfileImageId);
			else
				updateFile(fileId,e.target.files[0], setProfileImageId);
			fasterPreview(this);
		});

		$('#<portlet:namespace />customFile').change(function(e) {
			let fileId=<%=people.getIdentityProofId() %>
			if(fileId == 0)
				uploadFile(e.target.files[0], setIdentityProofId);
			else
				updateFile(fileId,e.target.files[0], setIdentityProofId);
			

		});

		$("#profileimg").click(function(e) {
			$("#imageUpload").click();
		});

		$('#<portlet:namespace />bloodGroup').change(function(e) {
			console.log($("#<portlet:namespace/>bloodGroup").val());
		});

	});

	function setProfileImageId(data) {
		profileImageId = data.fileEntryId;
	}

	function setIdentityProofId(data) {
		identityProofId = data.fileEntryId;
	}

	function getRadioButtonValue(ele) {
		for (i = 0; i < ele.length; i++) {
			if (ele[i].checked)
				return ele[i].value;
		}
	}
	function saveForm(onSuccess) {

		if (this.employeeId == null) {
			this.employeeId = 0;
		}

		let employeeId = this.employeeId;
		let dateOfBirth = $("#<portlet:namespace/>dateOfBirth").val();
		let citizenId = $("#<portlet:namespace/>citizen").val();
		let phTypeId = $("#<portlet:namespace/>phTypeId").val();
		let religionId = $("#<portlet:namespace/>religion").val();
		let aadhaarNo = $("#<portlet:namespace/>aadhaarNo").val();
		let panNo = $("#<portlet:namespace/>panNo").val();

		let color = $("#<portlet:namespace/>color").val();
		let height = $("#<portlet:namespace/>height").val();
		let identificationMark = $("#<portlet:namespace/>identificationMark")
				.val();
		let firstName_Hi = $("#<portlet:namespace/>firstName_Hi").val();
		let lastName_Hi = $("#<portlet:namespace/>lastName_Hi").val();
		let middleName_Hi = $("#<portlet:namespace/>middleName_Hi").val();
		let firstName_En = $("#<portlet:namespace/>firstName_En").val();
		let fatherName_Hi = $("#<portlet:namespace/>fatherName_Hi").val();
		let fatherName_En = $("#<portlet:namespace/>fatherName_En").val();
		let lastName_En = $("#<portlet:namespace/>lastName_En").val();
		let middleName_En = $("#<portlet:namespace/>middleName_En").val();
		let appellation = $("#<portlet:namespace/>appellationId").val();
		let bloodGroup = $("#<portlet:namespace/>bloodGroup").val();
		let gender = $("input[name='<portlet:namespace/>gender']:checked")
				.val();
		let casteCategory = $(
				"input[name='<portlet:namespace/>castCategory']:checked").val();
		let maritalStatus = $(
				"input[name='<portlet:namespace/>maritalStatus']:checked")
				.val();
		let exServiceMan = $("#<portlet:namespace/>exServiceMan").val();

		var people=new People(dateOfBirth,citizenId,phTypeId,religionId,
				aadhaarNo,panNo,identityProofId,color,height,identificationMark,
				firstName_Hi,lastName_Hi,middleName_Hi,firstName_En,fatherName_Hi,fatherName_En,
				lastName_En,middleName_En,appellation,bloodGroup,gender,
				casteCategory,maritalStatus,exServiceMan,profileImageId);
	
		try {
			console.log(this.identityProofId);
			Liferay
					.Service(
							'/pis.people/add-people',
							{
								people:people ,
								employeeId : employeeId,
								
							},
							function(obj) {
								console.log(obj);
								this.employeeId = obj;
								employeeId = obj;
								if (typeof obj == "string")
									if (obj.startsWith("error")) {
										$("#PersonalErrorMessage").text(obj);
										validationBackendError = false;
									}

								var employeeDocumentId = 0;
								var title = "Personal Document";
								var discription = "Personal Document";

								Liferay
										.Service(
												'/mdm.documenttype/get-document-type-id-by-name',
												{
													name : "Identity Proof"
												},
												function(obj) {
													console.log(obj);
													this.documentTypeId = obj;
													var empDocument = new EmployeeDocument(
															employeeDocumentId,
															title, discription,
															documentTypeId,
															identityProofId,
															employeeId);
													documentList
															.push(empDocument);
													addDocument(documentList);
												});
								//profileImageId
								Liferay
										.Service(
												'/mdm.documenttype/get-document-type-id-by-name',
												{
													name : "Profile Image"
												},
												function(obj) {
													console.log(obj);
													this.documentTypeId = obj;
													var title = "Profile Image";
													var discription = "Profile Image";
													var empDocument = new EmployeeDocument(
															employeeDocumentId,
															title, discription,
															documentTypeId,
															profileImageId,
															employeeId);
													documentList
															.push(empDocument);
													addDocument(documentList);
												});
								if(validationBackendError){
									
									
									onSuccess();
									validationBackendError=true;
								}
									
							});
		} catch (error) {
			document.getElementById("PersonalErrorMessage").innerHtml = "Error= "
					+ error;
		}
	}

	function fasterPreview(uploader) {
		if (uploader.files && uploader.files[0]) {
			$('#profileImage').attr('src',
					window.URL.createObjectURL(uploader.files[0]));
		}
	}
	class People{
		constructor(dateOfBirth,citizenshipId,phTypeId,religionId,
				aadhaarNo,panNo,identityProofId,color,height,identificationMark,
				firstName_Hi,lastName_Hi,middleName_Hi,firstName_En,fatherName_Hi,fatherName_En,
				lastName_En,middleName_En,appellationId,bloodGroupId,genderId,
				casteCategoryId,maritalStatusId,exServiceMan,profileImageId){
			
			
			this.dateOfBirth=dateOfBirth;
			this.citizenshipId=citizenshipId;
			this.phTypeId=phTypeId;
			this.religionId=religionId;
			this.aadhaarNo=aadhaarNo;
			this.panNo=panNo;
			this.identityProofId=identityProofId;
			this.color=color;
			this.height=height;
			this.identificationMark=identificationMark;
			this.firstName_Hi=firstName_Hi;
			this.lastName_Hi=lastName_Hi;
			this.middleName_Hi=middleName_Hi;
			this.firstName_En=firstName_En;
			this.fatherName_Hi=fatherName_Hi;
			this.fatherName_En=fatherName_En;
			this.lastName_En=lastName_En;
			this.middleName_En=middleName_En;
			this.appellationId=appellationId;
			this.bloodGroupId=bloodGroupId;
			this.genderId=genderId;
			this.casteCategoryId=casteCategoryId;
			this.maritalStatusId=maritalStatusId;
			this.exServiceMan=exServiceMan;
			this.profileImageId=profileImageId;
		}
	}
	
	class FileEntry{
		constructor(repositoryId,treePath,fileName){
			this.repositoryId=repositoryId;
			this.treePath=treePath;
			this.fileName=fileName;
		}
	}
	
</script>
