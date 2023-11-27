<%@page import="java.util.List"%>
<%@page import="com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Religion"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.AppellationEnum"%>
<%@page import="java.util.EnumSet"%>

<div class="form-card">
	<h2 class="fs-title">Personal Information</h2>
	<div class="text-right"  style="width: 100%;">
		
			<img id="profileImage" style="width: 150px; height: 150px;" src="<%=request.getContextPath()%>/image/user.JPG">
		
		
	</div>
	<div class="text-right" style="width: 100%;">
		
				<aui:input label="Select Profile Image" name="imageUpload" id="imageUpload" style="display: none;"
					type="file" >
				</aui:input>
       	
	</div>
	<p id="PersonalErrorMessage"></p>
	
		<div class="row">
			<div class="form-group required col-md-6">

				<aui:select  label="Appellation" class="form-control" name="appellation" id="appellation" >
					<aui:option selected="">Select Appellation</aui:option>
					<%
						for (AppellationEnum appellation : AppellationEnum.values()) {
					%>
					<aui:option value="<%=appellation.getAppellation()%>"><%=appellation.name()%>

					</aui:option>
					<%
						}
					%>
					 <aui:validator errorMessage="Select a Appellation" name="required" />
				</aui:select>

			</div>

			<div class="form-group  col-md-6">

				<aui:input label="First Name( English)" name="firstName_English_"
					id="firstName_English_" type="text" >
					 <aui:validator  errorMessage="The first name is a required field"
					   name="required" />
						<aui:validator name="maxLength">20</aui:validator>
					 <aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					</aui:input>

			</div>

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="First Name( Hindi)" name="firstName_Hindi_"
					id="firstName_Hindi_" type="text"  >
					 <aui:validator  errorMessage="The first name is a required field"
					   name="required" />
					   <aui:validator name="maxLength">20</aui:validator>
					 <aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					</aui:input>
			</div>


			<div class="form-group  col-md-6">
				<aui:input label="Middle Name( English)" name="middleName_English_"
					id="middleName_English_" type="text">
					<aui:validator name="maxLength">20</aui:validator>
					<aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
				</aui:input>

			</div>

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="Middle Name( Hindi)" name="middleName_Hindi_"
					id="middleName_Hindi_" type="text"  >
					<aui:validator name="maxLength">20</aui:validator>
					<aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
				</aui:input>

			</div>


			<div class="form-group  col-md-6">
				<aui:input label="Last Name( English)" name="lastName_English_"
					id="lastName_English_" type="text"  >
					
					 <aui:validator  errorMessage="The Last Name is a required field"
					   name="required" />
					   <aui:validator name="maxLength">20</aui:validator>
					 <aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					
				</aui:input>
					
			</div>

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="Last Name( Hindi)" name="lastName_Hindi_"
					id="lastName_Hindi_" type="text" >
					<aui:validator  errorMessage="The Last Name is a required field"
					   name="required" />
					   <aui:validator name="maxLength">20</aui:validator>
					 <aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					
					</aui:input>
			</div>


			<div class="form-group required col-md-6">
				<aui:input label="Date of Birth" name="dateOfBirth" id="dateOfBirth"
					type="Date"  >
					<aui:validator errorMessage="Please select a valid date of birth." name="required" />
					</aui:input>

			</div>

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="Father Name( English)" name="fatherName_English_"
					id="fatherName_English_" type="text" >
					<aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					<aui:validator name="maxLength">50</aui:validator>
					
				</aui:input>

			</div>


			<div class="form-group  col-md-6">
				<aui:input label="Father Name( Hindi)" name="fatherName_Hindi_"
					id="fatherName_Hindi_" type="text">
					<aui:validator errorMessage="Allows (A-Z) characters only" 
					name="alpha" />
					<aui:validator name="maxLength">50</aui:validator>
				</aui:input>
			</div>

		</div>

		<div class="row">


			<div class="form-group required col-md-6">
				<aui:input label="Aadhaar No" name="aadhaarNo" id="aadhaarNo"
					type="text" >
					<aui:validator  errorMessage="The Aadhaar No is a required field"
					   name="required" />
					 <aui:validator errorMessage="Allows (0-9) characters only" 
					name="number" />
					<aui:validator name="maxLength">12</aui:validator>
					
				</aui:input>
			</div>


			<div class="form-group required col-md-6">
				<aui:input label="Pan No" name="panNo" id="panNo" type="text">
				<aui:validator  errorMessage="The Pan No is a required field"
					   name="required" />
				 <aui:validator errorMessage="Allows (A-Z,0-9) characters only" 
					name="alphanum" />
					<aui:validator name="maxLength">10</aui:validator>
					
				</aui:input>
			</div>

		</div>

		<div class="row">


			<div class="form-group required col-md-6">
				<aui:select label="Religion" class="form-control" name="religion" id="religion">
					<aui:option selected="">Select Religion</aui:option>
					<%
						for (Religion religion : religionList) {
					%>
					<aui:option value="<%=religion.getReligionId()%>"><%=religion.getName()%>

					</aui:option>
					<%
						}
					%>
					<aui:validator  errorMessage="Select a religion."
					   name="required" />
				</aui:select>

			</div> 


			 <div class="form-group required col-md-6">
				<aui:select label="Physical Handicap Type" class="form-control" name="phTypeId" id="phTypeId">
					<aui:option selected="">Select Physical Handicap Type</aui:option>
				<%
					for (PhType phType : phTypeList) {
				%>
					<aui:option value="<%=phType.getPhTypeId()%>"><%=phType.getName()%>

					</aui:option>
					<%
						}
					%>
					<aui:validator  errorMessage="Select a physical handicap type."
					   name="required" />
					   
				</aui:select>

			</div>

		</div>

		<div class="row">


			<div class="form-group required col-md-6">
				<aui:select class="form-control" label="Blood Group" name="bloodGroup" id="bloodGroup">
					<aui:option selected="">Select Blood Group</aui:option>
					<%
						for (BloodGroup bloodGroup : bloodGroupList) {
					%>
					<aui:option value="<%=bloodGroup.getId()%>"><%=bloodGroup.getName()%>

					</aui:option>
					<%
						}
					%>
					<aui:validator  errorMessage="Select a blood group."
					   name="required" />
				</aui:select>

			</div>


		 	 <div class="form-group required col-md-6">
		 	 <aui:input label="Ex Service Man" type="checkbox"
				name="experience_Ex_Service_Man" class="form-control"
				id="ex_Service_Man" />
				<%-- <aui:select class="form-control" label="Citizen" name="citizen" id="citizen">
					<aui:option selected="">Select Citizen</aui:option>
					<%
						for (PhType phType : phTypeList) {
					%>
					<aui:option value="<%=phType.getPhTypeId()%>"><%=phType.getName()%>

					</aui:option>
					<%
						}
					%>
					
					<
					<aui:validator  errorMessage="Select a citizen."
					   name="required" />
				</aui:select>
 --%>
			</div>  

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="Height" name="height" id="height" type="number"
					/>


			</div>


			<div class="form-group  col-md-6">
				<aui:input label="Color" name="color" id="color" type="text"
					 />

			</div>

		</div>

		<div class="row">


			<div class="form-group  col-md-6">
				<aui:input label="Identification Mark" name="identificationMark"
					id="identificationMark" type="text" />
			</div>


			<div class="form-group required col-md-6">
				<label class="control-label" for="exampleInputEmail1">Gender</label>

				<%
					for (Gender gender : genderList) {
				%>

				<div>
					<div class="form-check form-check-inline">
						<aui:input label="<%=gender.getName()%>" name="inlineRadio1"
							id="inlineRadio1" type="radio"
							value="<%=gender.getId()%>" />

					</div>
				</div>
				<%
					}
				%>


			</div>

		</div>

		<div class="row">


			<div class="form-group required col-md-6">
				<label class="control-label">Caste
					Category</label>


				<%
					for (CasteCategory casteCategory : casteCategoryList) {
				%>

				<div>
					<div class="form-check form-check-inline">
						<aui:input label="<%=casteCategory.getName()%>" name="inlineRadio2"
							id="inlineRadio2" type="radio"
							value="<%=casteCategory.getId()%>" />

					</div>
				</div>
				<%
					}
				%>

			</div>


			<div class="form-group required col-md-6">
				<label class="control-label" >Marital
					Status</label>


				<%
					for (MaritalStatus maritalStatus : maritalStatusList) {
				%>
				<div>
					<div class="form-check form-check-inline">
						<aui:input label="<%=maritalStatus.getName()%>" name="inlineRadio3"
							id="inlineRadio3" type="radio"
							value="<%=maritalStatus.getId()%>" />

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
					type="file" >
					<aui:validator name="acceptFiles">'pdf,jpeg,png'</aui:validator>
			</aui:input>
			</div>

		</div>

	


</div>