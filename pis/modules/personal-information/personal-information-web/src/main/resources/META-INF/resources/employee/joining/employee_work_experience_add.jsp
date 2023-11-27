
<div class="form-card">
<input type="button" id="btnAdd1" value="Add Experience" class="bt" />
	<h2 class="fs-title">Work Experience</h2>
	<table id="workUser">
	<tbody id="worktbody">
	<tr>
		<td>
		<aui:input name="employeePastExperienceId" id="employeePastExperienceId" type="hidden" />
		
		<aui:input label="Organization" type="text"
						name="experience_Organization" class="form-control"
						id="experience_Organization1">
						<aui:validator errorMessage="The Organization is a required field"
							name="required" />
						<aui:validator name="maxLength">100</aui:validator>
					</aui:input></td>
		</tr>
		
		<tr><td><aui:input label="Designation" type="text"
						name="experience_Designation" class="form-control"
						id="experience_Designation1">
						<aui:validator errorMessage="The Designation is a required field"
							name="required" />
						<aui:validator name="maxLength">100</aui:validator>
					</aui:input></td>
					
					<td>	<aui:select label="Work Area" class="form-control"
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
					</aui:select></td></tr>
					
					<tr><td>
					<aui:input label="From Date" type="date"
						name="experience_From_Date" class="form-control"
						id="experience_From_Date1" required="true">
						<aui:validator errorMessage="The From Date is a required field"
							name="required" />
					</aui:input></td>
					
					<td>
					<aui:input label="To Date" type="date" name="experience_To_Date"
						class="form-control" id="experience_To_Date1">
						<aui:validator errorMessage="The To Date is a required field"
							name="required" />
					</aui:input></td></tr>
					
					<tr><td>	<aui:input label="Experience Letter" type="file"
							class="custom-file-input" name="experience_Experience_Letter"
							id="experience_Experience_Letter1" onChange="getExperienceFileId(this.id)">
							<aui:validator name="acceptFiles">'pdf'</aui:validator>
						</aui:input></td></tr>
						
	
	</tbody>
	</table>
</div>
<style>
#worktbody{
  border: 1px solid black;
  margin: 10px;
}
table {
 border-collapse: collapse;
  width: 100%;
    padding: 10px;
  border: 1px solid black;
}
td{
  padding: 10px;
}
</style>