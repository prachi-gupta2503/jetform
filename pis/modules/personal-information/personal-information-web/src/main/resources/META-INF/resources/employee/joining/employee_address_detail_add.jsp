<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.StateLocalServiceUtil"%>

<%@page import="com.adjecti.mdm.liferay.model.State"%>


<%@ page import="java.util.List"%>

<%
	int countryLength = CountryServiceUtil.getCountries().size();
	List<Country> countryList = CountryServiceUtil.getCountries();
%>

	<div class="form-card">

		<h2 class="fs-title">Permanent Address</h2>

		<div class="form-row">

			<div class="form-group required col-md-6">
			
				<input type="hidden" id="permanentAddressId" />
				<aui:input name="AddressLine1" class="form-control"
					id="permanent-addressLine1" label="Address Line1">
					<aui:validator name="alphanum" />
					<aui:validator name="required"
						errorMessage="Please Enter Your Address"></aui:validator>
				</aui:input>
			</div>

			<div class="form-group required col-md-6">
				<aui:input name="AddressLine2" class="form-control"
					id="permanent-addressLine2" label="Address Line2">
					<aui:validator name="alpha" />
					<aui:validator name="required" />
				</aui:input>
			</div>
		</div>

		<div class="form-row">

			<div class="form-group  col-md-6">
				<aui:input name="AddressLine3" class="form-control"
					id="permanent-addressLine3" label="Address Line3">
					<aui:validator name="alpha" />
				</aui:input>

			</div>

			<div class="form-group required col-md-6">
				<aui:input name="permanentCity" class="form-control"
					id="permanent-city" label="City">
					<aui:validator name="alphanum" />
					<aui:validator name="required" />
				</aui:input>

			</div>

		</div>

		<div class="form-row">

			<div class="form-group required col-md-6">
				<!-- <label class="control-label">Country</label> -->
				<aui:select class="form-control" id="permanent-country"
					label="Country" name="pernament-country"
					onChange="getPermanentStates(this.value)">
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

				<aui:select class="form-control" id="permanent-state"
					name="permanent-state" label="State"
					onChange="getPermanentDistricts(this.value)">
					<aui:option value=''>Select State</aui:option>
					<aui:validator name="required" />

				</aui:select>

			</div>

		</div>
	
		<div class="form-row">

			<div class="form-group required col-md-6">

				<aui:select class="form-control" id="permanent-district"
					name="permanentDistrict" label="District">
					<aui:option value=''>Select District</aui:option>
					<aui:validator name="required" />
				</aui:select>

			</div>




			<div class="form-group required col-md-6">
				<aui:input name="permanentPincode" class="form-control"
					id="permanent-pinCode" label="Pin Code">
					<aui:validator name="required" />
				
				<aui:validator name="maxLength">6</aui:validator>
				</aui:input>
			</div>

		</div>

		<div class="form-row">

			<div class="form-group  col-md-6">
				<!-- <label class="control-label" >Address
				Proof</label> -->
				<div class="custom-file">
					<aui:input type="file" id="file" name="file" label="Address Proof"></aui:input>

				</div>

			</div>
		</div>



		
			<div class="mt-3 mb-3"></div>

			<h2 class="fs-title">Residence Address</h2>



			<div class="form-row">
				
				<input type="hidden" id="residenceAddressId" />
				<div class="form-group required col-md-6">
					<aui:input name="residenceAddressLine1" class="form-control"
						id="residence-addressLine1" label="Address Line1">
						<aui:validator name="alphanum" />
						<aui:validator name="required" />
					</aui:input>

				</div>

				<div class="form-group required col-md-6">
					<aui:input name="residenceAddressLine2" class="form-control"
						id="residence-addressLine2" label="Address Line2">
						<aui:validator name="alpha" />
						<aui:validator name="required" />
					</aui:input>

				</div>

			</div>

			<div class="form-row">


				<div class="form-group  col-md-6">
					<aui:input name="residenceAddressLine3" class="form-control"
						id="residence-addressLine3" label="Address Line3">
						<aui:validator name="alpha" />
					</aui:input>

				</div>

				<div class="form-group required col-md-6">
					<aui:input name="residenceCity" class="form-control"
						id="residence-city" label="City">
						<aui:validator name="alphanum" />
						<aui:validator name="required" />
					</aui:input>
				</div>

			</div>

			<div class="form-row">

				<div class="form-group required col-md-6">
					<!-- <label class="control-label" >Country</label> -->
					<aui:select class="form-control" id="residence-country"
						label="Country" name="residenceCountry"
						onchange="getResidenceStates(this.value)">
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
					<aui:select class="form-control" id="residence-state"
						name="residenceState" label="State"
						onChange="getResidenceDistricts(this.value)">
						<aui:option value="">Select State</aui:option>
						<aui:validator name="required" />
					</aui:select>
				</div>
			</div>

			<div class="form-row">

				<div class="form-group required col-md-6">
					<aui:select class="form-control" id="residence-district"
						name="resisdenceDistrict" label="District">
						<aui:option value="">Select District</aui:option>
						<aui:validator name="required" />
					</aui:select>

				</div>

				<div class="form-group required col-md-6">
					<aui:input name="residencePinCode" class="form-control"
						id="residence-pinCode" label="Pin Code">
						<aui:validator name="required" />
					
					<aui:validator name="maxLength">6</aui:validator>
					</aui:input>
				</div>

			</div>

			<div class="form-row">


				<div class="form-group  col-md-6">
					<!-- <label class="control-label" for="exampleInputEmail1">Address
				Proof</label> -->
					<div class="custom-file">
						<aui:input type="file" id="residencefile" name="residencefile"
							label="Address Proof" onchange="getResidenceFileId()"></aui:input>

					</div>

				</div>

			</div>


		</div>



