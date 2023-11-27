<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.util.OrganizationUtils"%>
<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp"%>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/admin_view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="updateRequest" var="updateRequestActionURL" />

<%
	long registrationRequestId = ParamUtil.getLong(renderRequest, "registrationId");
	RegistrationRequest registrationRequest = null;
	if (registrationRequestId > 0) {
		registrationRequest = RegistrationRequestLocalServiceUtil.getRegistrationRequest(registrationRequestId);
	}
	Organization organization = OrganizationLocalServiceUtil.getOrganization(registrationRequest.getUnitId());
	List<OrganizationDetail> sections = OrganizationDetailLocalServiceUtil.getSections(registrationRequest.getUnitId());
	
	boolean editFlag = ParamUtil.getBoolean(renderRequest, "editFlag");
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	//Genders
	List<Gender> genders = GenderLocalServiceUtil.getGenders(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	//Designation
	List<Designation> designations = DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,	QueryUtil.ALL_POS);
	//Trade
	List<Trade> trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	//Grade
	List<Grade> grades = GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	//Category
	List<CasteCategory> categories = CasteCategoryLocalServiceUtil.getCasteCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<script>
 $(document).ready(function() {         
	 $(<portlet:namespace/><%=registrationRequest.getGender()%>).prop( "checked", true );
	 $(<portlet:namespace/><%=registrationRequest.getCasteCategory()%>).prop( "checked", true ); 
 });
 </script>

<script>
 $(document).ready(function (){
		 var errorMessageStr = "<%=registrationRequest.getErrorMessage()%>";
		 if(errorMessageStr!=null && errorMessageStr.length >0){
		 	var errorMsg = errorMessageStr.split("#");
	     	var messageHtml = "";	    
	    	errorMsg.forEach(function (message) {
	    		if(message.indexOf(":") > -1 ) {
	    			var msgMap=message.split(":");
	    			var errorField = $.trim(msgMap[0])+"Error";
		    		if($("#"+errorField) != null){
		    			$("#"+errorField).html(msgMap[1]);
		    		}else{
		    			messageHtml += "<li>" + msgMap[1] + "</li>";
		    		}
		    		
	    		}else{
	    			messageHtml += "<li>" + message + "</li>";
	    		}
	    		
	    	});
	    	document.getElementById("error").innerHTML = messageHtml; 
		}else{
			$("#errorMessage").attr('disabled','disabled');
		}
		
}); 
</script>



<style>
#permission {
	color: black;
}

.required:after {
	content: " *";
	color: red;
}

h2.flex-container {
	display: flex;
	background-color: silver;
	text-align: center;
	font-size: 30px;
}
</style>
<div class=" p-3">
	<div class="mb-3 text-danger" id="errorMessage">
		<ul id="error">
		</ul>
	</div>
	<!-- onSubmit="myFunction()" -->
	<aui:form action="${updateRequestActionURL}" name="requestForm" method="POST">

		<aui:input name="registrationId" type="hidden" 	value="<%=registrationRequest.getRegistrationRequestId()%>" />
		<aui:input name="unitId" type="hidden" 	value="<%=registrationRequest.getUnitId()%>" />

		<aui:input label="Unit" name="unit" type="text" placeholder="Unit"	value="<%=registrationRequest.getUnit()%>" readonly="true" />
		
		<div class="mb-2 text-danger" id="UnitError"></div>
		

		<aui:input label="Personal Number" name="personalNo" type="number" 	placeholder="Personal Number" min="1" 	value="<%=registrationRequest.getPersonalNo()%>">
			<aui:validator name="min">1</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="PersonalNoError"></div>

		<aui:input label="First Name" name="firstName" type="text" 	placeholder="First Name" value="<%=registrationRequest.getFirstName()%>">
			<aui:validator name="required" />
			<aui:validator errorMessage="Please Enter Correct First Name." name="custom">
                			function(val, fieldNode, ruleValue) {
	                        	var regex =  new RegExp(/^[a-z][a-z\s]*$/i);
		                        return regex.test(val);
               			 	}
    			    	</aui:validator>	
    		<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="FirstNameError"></div>

		<aui:input label="Middle Name" name="middleName" type="text" placeholder="Middle Name"  value="<%=registrationRequest.getMiddleName()%>">
			<aui:validator errorMessage="Please Enter Correct Middle Name." name="custom">
    			function(val, fieldNode, ruleValue) {
       				var regex =  new RegExp(/^[a-z][a-z\s]*$/i);
              		return regex.test(val);
   			 	}
    		</aui:validator>
    		<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="MiddleNameError"></div>

		<aui:input label="Last Name" name="lastName" type="text" placeholder="Last Name"  value="<%=registrationRequest.getLastName()%>">
			<aui:validator errorMessage="Please Enter Correct Last Name." name="custom">
       			function(val, fieldNode, ruleValue) {
                	var regex =  new RegExp(/^[a-z][a-z\s]*$/i);
                	return regex.test(val);
      			}
    		</aui:validator>
    		<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="LastNameError"></div>
        <aui:select label="Select Gender" name="gender" required="true">
			<%-- <c:forEach var="designation" items="<%=designations%>">
				<aui:option value="${designation.name_En}">${designation.name_En}</aui:option>
			</c:forEach> --%>
			<aui:option value="" >Select Gender</aui:option>
			<%
			      for(Gender gender:genders){
			    	  
			    	  if(gender.getName().equalsIgnoreCase(registrationRequest.getGender())){
			    		  %>
			    		  <aui:option selected="true" value="<%=gender.getName()%>"><%=gender.getName()%></aui:option>
			    		  <% 
			    	  }else{
			    		  
			    		 %>
			    		  <aui:option value="<%=gender.getName()%>"><%=gender.getName()%></aui:option>
			    		 <% 
			    	  }
			      }
			%>
		</aui:select>
		<div class="mb-2 text-danger" id="GenderError"></div>
		
		<aui:select label="Select Designation:" id="designation" name="designation" required="true" >
			<%-- <c:forEach var="designation" items="<%=designations%>">
				<aui:option value="${designation.name_En}">${designation.name_En}</aui:option>
			</c:forEach> --%>
			<aui:option value="" >Select Designation</aui:option>
			<%
			      for(Designation designation:designations){
			    	  
			    	  if(designation.getCode().equalsIgnoreCase(registrationRequest.getDesignationCode())){
			    		  %>
			    		  <aui:option selected="true" value="<%=designation.getDesignationId()%>"><%=designation.getName_En()%></aui:option>
			    		  <% 
			    	  }else{
			    		  
			    		 %>
			    		  <aui:option value="<%=designation.getDesignationId()%>"><%=designation.getName_En()%></aui:option>
			    		 <% 
			    	  }
			      }
			%>
		</aui:select>
		<div class="mb-2 text-danger" id="DesignationError"></div>

		<aui:select label="Select Trade:" id="trade" name="trade"	required="true" >
			<%-- <c:forEach var="trade" items="<%=trades%>">
				<aui:option value="${trade.name}">${trade.name}</aui:option>
			</c:forEach> --%>
			<aui:option value="">Select Trade</aui:option>
			<%
			      for(Trade trade:trades){
			    	  
			    	  if(trade.getCode().equalsIgnoreCase(registrationRequest.getTradeCode())){
			    		  %>
			    		  <aui:option selected="true" value="<%=trade.getTradeId()%>"><%=trade.getName()%></aui:option>
			    		  <% 
			    	  }else{
			    		  
			    		 %>
			    		  <aui:option value="<%=trade.getTradeId()%>"><%=trade.getName()%></aui:option>
			    		 <% 
			    	  }
			      }
			%>
		</aui:select>
		<div class="mb-2 text-danger" id="TradeError"></div>

		<aui:select label="Select Grade:" id="grade" name="grade" 	required="true" >
			<%-- <c:forEach var="grade" items="<%=grades%>">
				<aui:option value="${grade.name}">${grade.name}</aui:option>
			</c:forEach> --%>
			<aui:option value="">Select Grade</aui:option>
			<%
			      for(Grade grade:grades){
			    	  
			    	  if(grade.getCode().equalsIgnoreCase(registrationRequest.getGradeCode())){
			    		  %>
			    		  <aui:option selected="true" value="<%=grade.getGradeId()%>"><%=grade.getName()%></aui:option>
			    		  <% 
			    	  }else{
			    		  
			    		 %>
			    		  <aui:option value="<%=grade.getGradeId()%>"><%=grade.getName()%></aui:option>
			    		 <% 
			    	  }
			      }
			%>
		</aui:select>
		<div class="mb-2 text-danger" id="GradeError"></div>

		<div class="form-group">
			<label for="dateOfBirth">Date of Birth</label>
				<input required="required" class="form-control" type="date"	max="<%=simpleDateFormat.format(new Date())%>"	name="<portlet:namespace/>dateOfBirth"
					value="<%=registrationRequest.getDateOfBirth() != null ? simpleDateFormat.format(registrationRequest.getDateOfBirth()) : null%>" />
		</div>
		<div class="mb-2 text-danger" id="DateOfBirthError"></div>

		<aui:field-wrapper name="casteCategory" cssClass="mb-0">
		<%
	      for(CasteCategory casteCategory:categories){
	    	  
	    	  if(casteCategory.getName().equalsIgnoreCase(registrationRequest.getCasteCategory())){
	    		  %>
	    		  	<aui:input label="<%=casteCategory.getName()%>" name="casteCategory" type="radio" id="<%=casteCategory.getName()%>"
			 			value="<%=casteCategory.getName()%>" checked="true" onChange="updateCasteCategoryField('<%=casteCategory.getName()%>')">
					</aui:input>
	    		  <% 
	    	  }else{
	    		 %>
	    		  	<aui:input label="<%=casteCategory.getName()%>" name="casteCategory" type="radio" id="<%=casteCategory.getName()%>"
						 value="<%=casteCategory.getName()%>" onChange="updateCasteCategoryField('<%=casteCategory.getName()%>')">
					</aui:input>
	    		 <% 
	    	  }
	      }
		%>
		</aui:field-wrapper>
		<aui:input name="category" label="" value="<%=registrationRequest.getCasteCategory()%>"  type="text" id="h-castecategory" style="display:none;margin-top:-1rem;">
				<aui:validator name="required" />
		</aui:input>
		<div class="mb-2 text-danger" id="CasteCategoryError"></div>
		<aui:input label="Mobile Number" name="mobile" type="number" value="<%=registrationRequest.getMobile()%>" placeholder="Mobile Number">
			<aui:validator name="digits" />
			<aui:validator name="required" />
			<aui:validator errorMessage="Enter Valid Mobile Number" name="custom">
          			function(val, fieldNode, ruleValue) {
                   		var regex =  new RegExp(/^(\+91-|\+91|0)?\d{10}$/i);
                    	return regex.test(val);
         			}
	    	</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="MobileError"></div>

		<aui:input label="Email Address" name="emailAddress" type="email" placeholder="Email Address" value="<%=registrationRequest.getEmailAddress()%>">
			<aui:validator name="email" />
			<aui:validator errorMessage="Enter Valid Email Address" name="custom">
          		function(val, fieldNode, ruleValue) {
                   	var regex = new RegExp(/(.+)@(.+){2,}\.(.+){2,}/i);
                    return regex.test(val);	                        
         		}
	    	</aui:validator>
		</aui:input>
		<div class="mb-2 text-danger" id="EmailAddressError"></div>

		<aui:input label="Date of Joining Unit" name="dateOfJoiningUnit" type="date"
			value="<%=registrationRequest.getDateOfJoiningUnit() != null ? simpleDateFormat.format(registrationRequest.getDateOfJoiningUnit()): null%>">
			<aui:validator name="required" />
		</aui:input>
		<div class="mb-2 text-danger" id="DateOfJoiningError"></div>

		<aui:select label="GPF/NPS Type:" id="type" name="type" required="true">
			<aui:option value="" >Select GPF/NPS Type</aui:option>
			<aui:option id="typeGPF" value="GPF" selected="<%="GPF".equalsIgnoreCase(registrationRequest.getGpfnpsType())%>">GPF</aui:option>
			<aui:option id="typeNPS" value="NPS" selected="<%="NPS".equalsIgnoreCase(registrationRequest.getGpfnpsType())%>">NPS</aui:option>
		</aui:select>
		<div class="mb-2 text-danger" id="GpfnpsTypeError"></div>

		<div id=type_number>
			<aui:input name="type_number" label="GPF/NPS Number:" id="type_number" value="<%=registrationRequest.getGpfnpsNumber()!=0?registrationRequest.getGpfnpsNumber():""%>">
				<aui:validator name="digits"errorMessage="Please Enter Only Number" /> 
				<aui:validator name="min" errorMessage="Invalid Number">1</aui:validator>
				<aui:validator name="maxLength">16</aui:validator>
			</aui:input>
		</div>
		<div class="mb-2 text-danger" id="GpfnpsNumberError"></div>
<!-- 
		<aui:input label="Section" id="section" name="section" value="<%=registrationRequest.getSection()%>">
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		-->
		
		<aui:select label="Section" id="section" name="section" required="true">
			<aui:option value="" >Select Section</aui:option>
			<%
			   
			for(OrganizationDetail section:sections){
			    	  
			    	  if(StringUtils.equalsIgnoreCase(registrationRequest.getSectionCode(), section.getOrganizationCode())){
			    		  %>
			    		  <aui:option selected="true" value="<%=section.getOrganizationId()%>"><%=section.getShortName()%></aui:option>
			    		  <% 
			    	  }else{
			    		  
			    		 %>
			    		  <aui:option value="<%=section.getOrganizationId()%>"><%=section.getShortName()%></aui:option>
			    		 <% 
			    	  }
			      }
			%>
		</aui:select>
		<div class="mb-2 text-danger" id="SectionError"></div>
		
		<aui:input label="Post Box" id="postBox" name="postBox" value="<%=registrationRequest.getPostBox()%>">
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		
		<aui:input label="Rank" id="rank" name="rank" value="<%=registrationRequest.getRank()%>">
			<aui:validator name="maxLength">75</aui:validator>
			<aui:validator name="digits"errorMessage="Please Enter Only Numbers" /> 
			<aui:validator name="min" errorMessage="Invalid Number">0</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>
		
		<aui:fieldset label="Permissions">
			<aui:input label="Idam User" name="is_idam" id="idamUser" value="" type="checkbox"  checked="<%=registrationRequest.isIdamUser()%>"/>
			<aui:input label="Email Access" name="is_email_access" id="emailAccess" value="" type="checkbox" checked="<%=registrationRequest.isEmailAccess()%>"/>
			<aui:input label="Digital Signing" name="is_digital_signing" id="digitalSigning" value="" type="checkbox" checked="<%=registrationRequest.isDigitalSigning()%>" />
			<aui:input label="eGov Access" name="is_egov_access" value="" id="eGovAccess" type="checkbox"  checked="<%=registrationRequest.isEGovAccess()%>"/>
			<aui:input label="Pis Access" name="is_pis_access" value="" id="pisAccess" type="checkbox" checked="<%=registrationRequest.isPisAccess()%>" />
		</aui:fieldset>

		<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
		<aui:button type="button" name="close" value="close" />
	</aui:form>
</div>


<aui:script>
$(document).ready( function() {
	var editFlag = <%=editFlag%>;
	Liferay.Util.getOpener().<portlet:namespace />isEdit(editFlag);
});

function updateCasteCategoryField(value){
    $("#<portlet:namespace />h-castecategory").val(value);
 }
</aui:script>

<aui:script use="aui-base">
A.one('#<portlet:namespace />close').on('click', function(event) {
	Liferay.Util.getOpener().<portlet:namespace />closePopUp('<portlet:namespace />dialog');
});
</aui:script>
