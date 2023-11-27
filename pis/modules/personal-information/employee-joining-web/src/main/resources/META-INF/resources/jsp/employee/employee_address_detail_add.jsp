<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.mdm.liferay.enumeration.AccomodationTypeEnum"%>
<%@page import="com.adjecti.pis.liferay.service.AddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.StateLocalServiceUtil"%>

<%@page import="com.adjecti.mdm.liferay.model.State"%>

<% 
Address permanentAddress=AddressLocalServiceUtil.createAddress(0);
Address residenceAddress=AddressLocalServiceUtil.createAddress(0);;
try{
	AccomodationTypeEnum permanent=AccomodationTypeEnum.PARMANENT;
	AccomodationTypeEnum residence=AccomodationTypeEnum.RESIDENCE;
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);
	if(employeeId!=0){
		List<EmployeeAddress> employeeAddresses =EmployeeAddressLocalServiceUtil.getEmployeeAddressByEmpId(employeeId);
/* 		employeeAddresses.forEach((employeeAddress) ->{ */
		for(EmployeeAddress employeeAddress:employeeAddresses){
			Address address=AddressLocalServiceUtil.getAddress(employeeAddress.getAddressId());
			if(address.getAccomodationType()==permanent.getAccomodationTypeCode())
				permanentAddress=address;
			if(address.getAccomodationType()==residence.getAccomodationTypeCode())
				residenceAddress=address;
		}
	}
}catch(Exception e){
	
}
%>

<%@ page import="java.util.List"%>
<%@ include file="../../init.jsp"%>

<%
	int countryLength = CountryServiceUtil.getCountries().size();
	List<Country> countryList = CountryServiceUtil.getCountries();
%>

<div class="card form-card m-4">
	<div class="card-header bg-primary text-white">
		<h5>Address</h5>
	</div>
<div class="card-body">

<div class="form-card">

	<h4>Permanent Address</h4>

	<p id="AddressErrorMessage"></p>
	<aui:form>
		<div class="form-row">

			<div class="form-group required col-md-6">

				<input type="hidden" id="permanentAddressId"
				value="<%=permanentAddress.getAddressId()%>" />
				<aui:input name="AddressLine1" class="form-control" id="permanent-addressLine1"
				value="<%=permanentAddress.getAddressLine1()%>"
				 label="Address Line1">
					
					<aui:validator name="required" errorMessage="Please Enter Your Address"></aui:validator>
				</aui:input>
			</div>

			<div class="form-group required col-md-6">
				<aui:input name="AddressLine2" class="form-control" id="permanent-addressLine2" label="Address Line2"
				value="<%=permanentAddress.getAddressLine2()%>"
				>
					
					<aui:validator name="required" />
				</aui:input>
			</div>
		</div>

		<div class="form-row">

			<div class="form-group  col-md-6">
				<aui:input name="AddressLine3" class="form-control" id="permanent-addressLine3" label="Address Line3"
				value="<%=permanentAddress.getAddressLine3()%>">
					
				</aui:input>

			</div>

			<div class="form-group required col-md-6">
				<aui:input name="permanentCity" class="form-control" id="permanent-city" label="City"
				value="<%= permanentAddress.getCity()%>">
					<aui:validator name="alphanum" />
					<aui:validator name="required" />
				</aui:input>
			</div>
		</div>

		<div class="form-row">

			<div class="form-group required col-md-6">

				<aui:select class="form-control" id="permanent-country" label="Country" name="pernament-country" onChange="getPermanentStates(this.value)">
					<aui:option value=''>Select Country</aui:option>

					<%
						for (Country country : countryList) {
									String countryName = country.getName();
									long countryId = country.getCountryId();
					%>
					<aui:option value="<%=countryId%>"><%=countryName%></aui:option>
					<%
						}
					%>
					<aui:validator name="required"></aui:validator>
				</aui:select>

			</div>

			<div class="form-group required col-md-6">

				<aui:select class="form-control" id="permanent-state" name="permanent-state" label="State" onChange="getPermanentDistricts(this.value)">
					<aui:option value=''>Select State</aui:option>
					<aui:validator name="required" />

				</aui:select>

			</div>

		</div>

		<div class="form-row">

			<div class="form-group required col-md-6">

				<aui:select class="form-control" id="permanent-district" name="permanentDistrict" label="District">
					<aui:option value=''>Select District</aui:option>
					<aui:validator name="required" />
				</aui:select>

			</div>




			<div class="form-group required col-md-6">
				<aui:input name="permanentPincode" class="form-control" id="permanent-pinCode" label="Pin Code"
				value="<%=permanentAddress.getPinCode()%>">
					<aui:validator name="required" />

					<aui:validator name="maxLength">6</aui:validator>
				</aui:input>
			</div>

		</div>

		<div class="form-row">

			<div class="form-group  col-md-6">
				
				<div class="custom-file">
					<aui:input type="file" id="permanentFile" name="permanentFile" label="Address Proof"></aui:input>

				</div>

			</div>
		</div>




		<div class="mt-3 mb-3"><hr style="width:100%"/></div>

		<h4>Residence Address</h4>



		<div class="form-row">

			<input type="hidden" id="residenceAddressId" 
			value="<%=residenceAddress.getAddressId()%>"/>
			<div class="form-group required col-md-6">
				<aui:input name="residenceAddressLine1" class="form-control" id="residence-addressLine1" label="Address Line1"
				value="<%=residenceAddress.getAddressLine1()%>">
				
					
					<aui:validator name="required" />
				</aui:input>

			</div>

			<div class="form-group required col-md-6">
				<aui:input name="residenceAddressLine2" class="form-control" id="residence-addressLine2" label="Address Line2"
				value="<%=residenceAddress.getAddressLine2()%>">
					
					<aui:validator name="required" />
				</aui:input>

			</div>

		</div>

		<div class="form-row">


			<div class="form-group  col-md-6">
				<aui:input name="residenceAddressLine3" class="form-control" id="residence-addressLine3" label="Address Line3"
				value="<%=residenceAddress.getAddressLine3()%>">
					
				</aui:input>

			</div>

			<div class="form-group required col-md-6">
				<aui:input name="residenceCity" class="form-control" id="residence-city" label="City"
				value="<%=residenceAddress.getCity()%>">
					<aui:validator name="alphanum" />
					<aui:validator name="required" />
				</aui:input>
			</div>

		</div>

		<div class="form-row">

			<div class="form-group required col-md-6">

				<aui:select class="form-control" id="residence-country" label="Country" name="residenceCountry" onchange="getResidenceStates(this.value)">
					<aui:option value="">Select Country</aui:option>

					<%
						for (Country country : countryList) {
									String countryName = country.getName();
									long countryId = country.getCountryId();
					%>
					<aui:option value="<%=countryId%>"><%=countryName%></aui:option>
					<%
						}
					%>
					<aui:validator name="required" />
				</aui:select>

			</div>

			<div class="form-group required col-md-6">
				<aui:select class="form-control" id="residence-state" name="residenceState" label="State" onChange="getResidenceDistricts(this.value)">
					<aui:option value="">Select State</aui:option>
					<aui:validator name="required" />
				</aui:select>
			</div>
		</div>

		<div class="form-row">

			<div class="form-group required col-md-6">
				<aui:select class="form-control" id="residence-district" name="resisdenceDistrict" label="District">
					<aui:option value="">Select District</aui:option>
					<aui:validator name="required" />
				</aui:select>

			</div>

			<div class="form-group required col-md-6">
				<aui:input name="residencePinCode" class="form-control" id="residence-pinCode" label="Pin Code"
				value="<%=residenceAddress.getPinCode()%>">
					<aui:validator name="required" />

					<aui:validator name="maxLength">6</aui:validator>
				</aui:input>
			</div>

		</div>

		<div class="form-row">


			<div class="form-group  col-md-6">

				<div class="custom-file">
					<aui:input type="file" id="residencefile" name="residencefile" label="Address Proof"></aui:input>

				</div>

			</div>

		</div>


	</aui:form>
</div>
</div>
</div>

<script>
var permanentAddressId = '0';
var residenceAddressId = '0';
var addressList = new Array();
var permanentFileId = '0';
var residenceFileId = '0';

$(document).ready(function(){
	
	permanentFileId=<%=permanentAddress.getAddressProofId() %>
	residenceFileId=<%=residenceAddress.getAddressProofId() %>
	$('#<portlet:namespace />permanentFile').change(function(e) {
		let fileId=<%=permanentAddress.getAddressProofId() %>
		if(fileId == 0)
			uploadFile(e.target.files[0], setPermanentAddressFileId);
		else
			updateFile(fileId,e.target.files[0], setPermanentAddressFileId);
		
	});


	$('#<portlet:namespace />residencefile').change(function(e) {
		let fileId=<%=residenceAddress.getAddressProofId() %>
		if(fileId == 0)
			 uploadFile(e.target.files[0], setResidenceAddressFileId);
		else
			updateFile(fileId,e.target.files[0], setResidenceAddressFileId);
	   
	});
})

function populateSelect(selectElement, serviceUrl, filterName, filterValue, valueField, textField, defaultText) {
    $(selectElement).empty();
    $(selectElement).append(new Option(defaultText, ''));
    var data = {};
    data[filterName] = filterValue;
    Liferay.Service(
        serviceUrl,
        data,
        function(values) {
            for (var i = 0; i < values.length; i++) {
                var id = values[i][valueField];
                var name = values[i][textField];

                $(selectElement).append(new Option(name, id));
            }
        }
    );
}

function getPermanentStates(value) {
    $("#<portlet:namespace />permanent-state").empty();
    $('#<portlet:namespace />permanent-state').append(new Option('Select State', ''));
    Liferay.Service(
        '/mdm.state/get-states', {
            countryId: value
        },
        function(currentStates) {
            for (var i = 0; i < currentStates.length; i++) {
                var id = currentStates[i]['stateId'];
                var name = currentStates[i]['name'];

                $('#<portlet:namespace />permanent-state').append(new Option(name, id));
            }
        }
    );
}

function getPermanentDistricts(value) {
    $("#<portlet:namespace />permanent-district").empty();
    $('#<portlet:namespace />permanent-district').append(new Option('Select District', ''));
    Liferay.Service(
        '/mdm.district/get-district-list', {
            stateId: value
        },


        function(permanentDistricts) {
            for (var i = 0; i < permanentDistricts.length; i++) {
                var id = permanentDistricts[i]['districtId'];
                var name = permanentDistricts[i]['name'];
                $('#<portlet:namespace />permanent-district').append(new Option(name, id));
            }
        }
    );
}



function getResidenceStates(value) {
    $("#<portlet:namespace />residence-state").empty();
    $('#<portlet:namespace />residence-state').append(new Option('Select State', ''));
    Liferay.Service(
        '/mdm.state/get-states', {
            countryId: value
        },
        function(currentStates) {
            for (var i = 0; i < currentStates.length; i++) {
                var id = currentStates[i]['stateId'];
                var name = currentStates[i]['name'];
                $('#<portlet:namespace />residence-state').append(new Option(name, id));
            }
        }
    );
}

function getResidenceDistricts(value) {
    $("#<portlet:namespace />residence-district").empty();
    $('#<portlet:namespace />residence-district').append(new Option('Select District', ''));
    Liferay.Service(
        '/mdm.district/get-district-list', {
            stateId: value
        },

        function(residenceDistricts) {
            for (var i = 0; i < residenceDistricts.length; i++) {
                var id = residenceDistricts[i]['districtId'];
                var name = residenceDistricts[i]['name'];
                $('#<portlet:namespace />residence-district').append(new Option(name, id));
            }
        }
    );
}


class Address {
    constructor(addressId, addressLine1, addressLine2, addressLine3, city, pinCode, countryId, stateId, districtId, addressProofId) {
        this.addressId = addressId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.pinCode = pinCode;
        this.countryId = countryId;
        this.stateId = stateId;
        this.districtId = districtId;
        this.addressProofId = addressProofId;
    }
}

function saveForm(onSuccess) {
    var permanentAddressId = $("#<portlet:namespace />permanentAddressId").val();
    var residenceAddressId = $("#<portlet:namespace />permanentAddressId").val();
    var permanentAddress1 = $("#<portlet:namespace />permanent-addressLine1").val();
    var permanentAddress2 = $("#<portlet:namespace />permanent-addressLine2").val();
    var permanentAddress3 = $("#<portlet:namespace />permanent-addressLine3").val();
    var permanentCity = $("#<portlet:namespace />permanent-city").val();
    var permanentCountry = $("#<portlet:namespace />permanent-country").val();
    var permanentState = $("#<portlet:namespace />permanent-state").val();
    var permanentDistrict = $("#<portlet:namespace />permanent-district").val();
    var permanentPinCode = $("#<portlet:namespace />permanent-pinCode").val();
    var residenceAddress1 = $("#<portlet:namespace />residence-addressLine1").val();
    var residenceAddress2 = $("#<portlet:namespace />residence-addressLine2").val();
    var residenceAddress3 = $("#<portlet:namespace />residence-addressLine3").val();
    var residenceCity = $("#<portlet:namespace />residence-city").val();
    var residenceCountry = $("#<portlet:namespace />residence-country").val();
    var residenceState = $("#<portlet:namespace />residence-state").val();
    var residenceDistrict = $("#<portlet:namespace />residence-district").val();
    var residencePinCode = $("#<portlet:namespace />residence-pinCode").val();

    
    var permanentAddressDetails = new Address(permanentAddressId, permanentAddress1, permanentAddress2, permanentAddress3, permanentCity, permanentPinCode, permanentCountry, permanentState, permanentDistrict, permanentFileId);
    var residenceAddressDetails = new Address(residenceAddressId, residenceAddress1, residenceAddress2, residenceAddress3, residenceCity, residencePinCode, residenceCountry, residenceState, residenceDistrict, residenceFileId);
    addressList.push(permanentAddressDetails);
    addressList.push(residenceAddressDetails);
    console.log(addressList);

    

    Liferay.Service(
        '/pis.address/add-address', {
            addressDetails: addressList,
            employeeId: employeeId
        },
        function(obj) {
            console.log(obj);
            this.addressList = obj;
            if(typeof obj == "string")
            if (obj.startsWith("error")) {
                $("#AddressErrorMessage").text(obj);
                validationBackendError = false;
                
            }
            address1 = addressList[0];
            address2 = addressList[1];
            this.permanentAddressId = address1.addressId;
            this.residenceAddressId = address2.addressId;
            this.addressList = new Array();
            if(validationBackendError){
				onSuccess();
				validationBackendError=true;
			}
        }
    );
    this.addressList = new Array();
}

function setPermanentAddressFileId(data) {
	console.log("setPermanentAddressFileId");
	console.log(data);
    permanentFileId = data.fileEntryId;
    var employeeDocumentId = 0;
    var title = "Permanent Address Document";
    var discription = "Permanent Address Document";
    Liferay.Service(
        '/mdm.documenttype/get-document-type-id-by-name', {
            name: "Address Proof"
        },
        function(obj) {
            console.log(obj);
            this.documentTypeId = obj;
            var empDocument = new EmployeeDocument(employeeDocumentId, title, discription, documentTypeId, permanentFileId, employeeId);
            documentList.push(empDocument);
            addDocument(documentList);
        });
}


function setResidenceAddressFileId(data) {
	console.log("setResidenceAddressFileId");
	console.log(data);
    residenceFileId = data.fileEntryId;
    var employeeDocumentId = 0;
    var title = "Residence Address Document";
    var discription = "Residence Address Document";
    
    Liferay.Service(
        '/mdm.documenttype/get-document-type-id-by-name', {
            name: "Address Proof"
        },
        function(obj) {
            console.log(obj);
            this.documentTypeId = obj;
            var empDocument = new EmployeeDocument(employeeDocumentId, title, discription, documentTypeId, residenceFileId, employeeId);
            documentList.push(empDocument);
            addDocument(documentList);
        }
    );
}

</script>

