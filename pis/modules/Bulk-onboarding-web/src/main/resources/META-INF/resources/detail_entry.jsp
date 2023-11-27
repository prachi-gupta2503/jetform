<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="./init.jsp"%>


<%
	long detailRegistrationId = ParamUtil.getLong(renderRequest, "detailRegistrationId");
	 
	RegistrationRequest registrationRequest = null;
	if (detailRegistrationId > 0) {
		 registrationRequest = RegistrationRequestLocalServiceUtil.getRegistrationRequest(detailRegistrationId);     
	}
	 
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
 %>

<script>
 $(document).ready(function (){
		 var str = "<%=registrationRequest.getErrorMessage()%>";
		 if(str.length !=0){
	 	var errorMsg = new Array();
 	 	var errorMsg = str.split("#");
	  
     	var messageHtml = "";	    
    	errorMsg.forEach(function (message) {
        messageHtml += "<li>" + message + "</li>";
    	});
    	document.getElementById("error").innerHTML = messageHtml; 
		}
    	else{$("#errorMessage").attr('disabled','disabled');}
}); 
</script>
<script>
 $(document).ready(function() {         
	if(<%=registrationRequest.getGpfnpsType().equalsIgnoreCase("GPF")%> ){ 
          $('#<portlet:namespace/>type').val('GPF');        
    }else{
    	  $('#<portlet:namespace/>type').val('NPS');
   	}
            
 });
</script>

<div class="p-4">
	<div class="mb-3 text-danger" id="errorMessage">
		<ul id="error"> </ul>
	</div>
	<h2 class="flex-container">Request Detail</h2>

	<aui:input label="Unit" name="unit" type="text" placeholder="Unit" 	value="<%=registrationRequest.getUnit()%>" readonly="true" />

	<aui:input label="Personal Number" name="personalNo" type="number" 	placeholder="Personal Number" value="<%=registrationRequest.getPersonalNo()%>" readonly="true" />

	<aui:input label="First Name" name="firstName" type="text" 	placeholder="First Name" value="<%=registrationRequest.getFirstName()%>" readonly="true" />

	<aui:input label="Middle Name" name="middleName" type="text" placeholder="Middle Name" value="<%=registrationRequest.getMiddleName()%>" readonly="true" />

	<aui:input label="Last Name" name="lastName" type="text" placeholder="Last Name" value="<%=registrationRequest.getLastName()%>" readonly="true" />

	<aui:input label="Gender" name="gender" type="text" placeholder="Gender" value="<%=registrationRequest.getGender()%>" readonly="true" />

	<aui:input label="Designation" name="designation" type="text" placeholder="Designation" value="<%=registrationRequest.getDesignation()%>" readonly="true" />

	<aui:input label="Trade" name="trade" type="text" placeholder="Trade" value="<%=registrationRequest.getTrade()%>" readonly="true" />

	<aui:input label="Grade" name="grade" type="text" placeholder="Grade" value="<%=registrationRequest.getGrade()%>" readonly="true" />

	<aui:input label="Date of Birth" name="dateOfBirth" type="date"  
		value="<%= registrationRequest.getDateOfBirth() != null?simpleDateFormat.format(registrationRequest.getDateOfBirth()):null%>" readonly="true" />

	<%-- <aui:input label="Date of Joining Organization" name="dateOfJoiningOrganization" type="date" value=<%= registrationRequest.getDateOfJoiningOrganization() != null?simpleDateFormat.format(registrationRequest.getDateOfJoiningOrganization()):null%> readonly="true" />--%>

	<aui:input name="mobile" label="Mobile Number" value="<%=registrationRequest.getMobile()%>" readonly="true" />

	<aui:input label="Category" name="category" type="text" placeholder="Category" 	value="<%=registrationRequest.getCasteCategory()%>" readonly="true" />

	<aui:input label="Email Address" name="emailAddress" type="email" placeholder="emailAddress" value="<%=registrationRequest.getEmailAddress()%>" readonly="true" />

	<aui:input label="Date of Joining Unit" name="dateOfJoiningUnit"  type="date"
		value="<%= registrationRequest.getDateOfJoiningUnit() != null?simpleDateFormat.format(registrationRequest.getDateOfJoiningUnit()):null%>" readonly="true" />

	<aui:field-wrapper name="type">
		<aui:input name="type" label="GPF/NPS Type:" id="type" readonly="true" />
		<aui:input name="type_number" label="GPF/NPS Number:" id="type_number" readonly="true" value="<%=registrationRequest.getGpfnpsNumber()!=0?registrationRequest.getGpfnpsNumber():""%>"/>
	</aui:field-wrapper>

	<aui:input label="Section" name="section" type="text" value="<%=registrationRequest.getSection()%>"  placeholder="Section" readonly="true" />
		
	<aui:input label="Login Id" name="loginId" type="text"  value="<%=registrationRequest.getLoginId()%>" placeholder="Login Id" readonly="true" />
	
	<aui:input label="Post Box" name="postBox" type="text"  value="<%=registrationRequest.getPostBox()%>"  readonly="true" />
	<aui:input label="Rank" name="rank" type="text"  value="<%=registrationRequest.getRank()%>"  readonly="true" />
	
	<%-- <aui:fieldset label="Permissions">
						<aui:input label="Idam User" name="is_idam" id="idamUser" value="<%=registrationRequest.getIdamUser() %>" type="checkbox" readonly="true"/>
						<aui:input label="Email Access" name="is_email_access" id="emailAccess" value="<%=registrationRequest.getEmailAccess() %>" type="checkbox" readonly="true" />
						<aui:input label="Digital Signing" name="is_digital_signing" id="digitalSigning" value="<%=registrationRequest.getDigitalSigning() %>" type="checkbox" readonly="true" />
						<aui:input label="eGov Access" name="is_egov_access" value="" id="eGovAccess" value="<%=registrationRequest.getEGovAccess() %>" type="checkbox" readonly="true"/>
						<aui:input label="Pis Access" name="is_pis_access" value="" id="pisAccess" value="<%=registrationRequest.getPisAccess() %>" type="checkbox" readonly="true" />					
						</aui:fieldset>
			 			--%>
			 			
	<aui:fieldset label="Permissions">
			<aui:input label="Idam User" name="is_idam" id="idamUser" value="" type="checkbox"  checked="<%=registrationRequest.isIdamUser()%>" disabled="true"/>
			<aui:input label="Email Access" name="is_email_access" id="emailAccess" value="" type="checkbox" checked="<%=registrationRequest.isEmailAccess()%>" disabled="true"/>
			<aui:input label="Digital Signing" name="is_digital_signing" id="digitalSigning" value="" type="checkbox" checked="<%=registrationRequest.isDigitalSigning()%>" disabled="true" />
			<aui:input label="eGov Access" name="is_egov_access" value="" id="eGovAccess" type="checkbox"  checked="<%=registrationRequest.isEGovAccess()%>" disabled="true"/>
			<aui:input label="Pis Access" name="is_pis_access" value="" id="pisAccess" type="checkbox" checked="<%=registrationRequest.isPisAccess()%>" disabled="true" />
		</aui:fieldset>
	<aui:button type="button" name="close" value="close" />
</div>

<aui:script use="aui-base">
A.one('#<portlet:namespace />close').on('click', function(event) {
	Liferay.Util.getOpener().<portlet:namespace />closePopUp('<portlet:namespace />dialog');
});
</aui:script>