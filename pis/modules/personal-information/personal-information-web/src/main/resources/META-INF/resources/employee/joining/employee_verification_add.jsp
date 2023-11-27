
<div class="form-card">
	<input type="button" id="verBtnAdd" value="Add Verification" class="bt" />
	<h2 class="fs-title">Background Verification</h2>
	<p id="VerificationErrorMessage"></p>
	<div style="border: 1px solid black; padding: 5px">
		<table id="vertable">
			<tbody id="vertbody">
				<tr>
					<td>
					<aui:input id="employeeVerificationId" name="employeeVerificationId" type="hidden"/> 
					<aui:input label="Document No" type="text"
							name="verification_Document_No" class="form-control"
							id="verification_Document_No1">
							<aui:validator errorMessage="The Document No is a required field"
								name="required" />

						</aui:input></td>

					<td><aui:select label="Verification Type" class="form-control"
							name="verification_Type" id="verification_Type1">
							<aui:option selected="">Select Verification Type</aui:option>
							<%
								for (VerificationType verificationType : verificationTypes) {
							%>
							<aui:option value="<%=verificationType.getVerificationTypeId()%>"><%=verificationType.getName()%>

							</aui:option>
							<%
								}
							%>

						</aui:select></td>
				</tr>

				<tr>
					<td><aui:input label=" Verification Date" type="date"
							name="verification_Date" class="form-control"
							id="verification_Date1" /></td>
					<td><aui:input label="Verification Authority" type="text"
							name="verification_Authority" class="form-control"
							id="verification_Authority1" /></td>
				</tr>

				<tr>
					<td><aui:input label="Verification Remarks" type="text"
							name="verification_Remarks" class="form-control"
							id="verification_Remarks1" /></td>

					
					<td><aui:input type="file" label="Verification Document"
							class="custom-file-input" name="verification_Document"
							id="verification_Document1"
							onchange="getVerificationFileId(this.id)">
							<aui:validator
								errorMessage="The Verification Document is a required field"
								name="required" />
						</aui:input></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<style>
#vertbody {
	border: 1px solid black;
	margin: 10px;
}

#vertable {
	border-collapse: collapse;
	width: 100%;
	padding: 10px;
	border: 1px solid black;
}

td {
	padding: 10px;
}
</style>