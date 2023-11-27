
<div class="form-card">
	<h2 class="fs-title">Joining Details</h2>

	<div class="mt-3 mb-3"></div>
	<div class="form-card-inner">
	<p id="JoiningErrorMessage"></p>

			<div class="row">

				<div class="form-group required col-md-6">
					<aui:input id="employeeJoiningId" name="employeeJoiningId" type="hidden"/>
					<aui:select label="Unit" class="form-control" name="joining_unit"
						id="joining_unit">
						<aui:option selected="">Select Unit</aui:option>
						<%
						for (Organization organization : organizations) {
					%>
					<aui:option value="<%=organization.getOrganizationId()%>"><%=organization.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Unit" name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">


					<aui:select label="Designation" class="form-control" name="joining_designation"
						id="joining_designation">
						<aui:option selected="">Select Designation</aui:option>
						<%
						for (Designation designation : designationList) {
					%>
					<aui:option value="<%=designation.getDesignationId()%>"><%=designation.getName_En()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Designation" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">


				<div class="form-group required col-md-6">


					<aui:select label="Grade"  class="form-control" name="joining_grade"
						id="joining_grade">
						<aui:option selected="">Select Grade</aui:option>
					<%
						for (Grade grade : grades) {
					%>
					<aui:option value="<%=grade.getGradeId()%>"><%=grade.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Grade" name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">
					<aui:select label="Grade Mode" name="joining_gradeMode" class="form-control"
						id="joining_gradeMode">
						<aui:option selected="">Select Grade Mode</aui:option>
						<%
						for (GradeMode gradeMode : gradeModes) {
					%>
					<aui:option value="<%=gradeMode.getGradeModeId()%>"><%=gradeMode.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Grade Mode" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">


				<div class="form-group required col-md-6">
					<aui:select label="Joining Mode" name="joining_joiningMode" class="form-control"
						id="joining_joiningMode">
						<aui:option selected="">Select Joining Mode</aui:option>
						<%
						for (JoiningMode joiningMode : joiningModeList) {
					%>
					<aui:option value="<%=joiningMode.getJoiningModeId()%>"><%=joiningMode.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Joining Mode"
							name="required" />
					</aui:select>

				</div>


				<div class="form-group required col-md-6">


					<aui:select label="Trade" class="form-control" name="joining_trade"
						id="joining_trade">
						<aui:option selected="">Select Trade</aui:option>
						<%
						for (Trade trade : tradeList) {
					%>
					<aui:option value="<%=trade.getTradeId()%>"><%=trade.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Trade" name="required" />
					</aui:select>

				</div>

			</div>

			<div class="row">


				<div class="form-group required col-md-6">
					<aui:select label="Post" name="joining_post" class="form-control"
						id="joining_post">
						<aui:option selected="">Select Post</aui:option>
						<%
						for (Post employeePost : posts) {
					%>
					<aui:option value="<%=employeePost.getPostId()%>"><%=employeePost.getName_En()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Post" name="required" />
					</aui:select>

				</div>
				<div class="form-group required col-md-6">
					<aui:select label="Pay Level" name="joining_payLevelId" class="form-control"
						id="joining_payLevel">
						<aui:option selected="">Select Pay Level</aui:option>
						<%
						for (PayLevel payLevel : paylevelList) {
					%>
					<aui:option value="<%=payLevel.getPayLevelId()%>"><%=payLevel.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Pay Level" name="required" />
					</aui:select>

				</div>

			</div>
			
			<div class="row">


				<div class="form-group required col-md-6">
					<aui:select label="Designation Class" name="joining_designationClassId" class="form-control"
						id="joining_designationClass">
						<aui:option selected="">Select Designation Class</aui:option>
						<%
						for (DesignationClass designationClass : designationClasseList) {
					%>
					<aui:option value="<%=designationClass.getDesignationClassId()%>"><%=designationClass.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Designation Class"
							name="required" />
					</aui:select>

				</div>
				<div class="form-group required col-md-6">
					<aui:select label="Designation Group" name="joining_designationGroupId" class="form-control"
						id="joining_designationGroup">
						<aui:option selected="">Select Designation Group</aui:option>
						<%
						for (DesignationGroup designationGroup : designationGroupList) {
					%>
					<aui:option value="<%=designationGroup.getDesignationGroupId()%>"><%=designationGroup.getName()%>

					</aui:option>
					<%
						}
					%>
						<aui:validator errorMessage="Select a Designation Group"
							name="required" />
					</aui:select>

				</div>

			</div>
			<div class="row">
				<div class="form-group required col-md-6">
					<aui:input label="Aadhaar No" type="text" name="joining_aadhaarNo"
						class="form-control" id="joining_aadhaarNo">
						<aui:validator errorMessage="Select a Trade" name="required" />
					</aui:input>
				</div>
				<div class="form-group required col-md-6">
					<aui:input label="Pan No" type="text" name="joining_panNo" class="form-control"
						id="joining_panNo">

						<aui:validator errorMessage="Select a Trade" name="required" />
					</aui:input>


				</div>
			</div>
			<div class="row">
				<div class="form-group required col-md-6">
					<aui:input label="Email Address" type="text" name="joining_emailAddress"
						class="form-control" id="joining_emailAddress">
						<aui:validator errorMessage="Select a Email Address" name="required" />
					</aui:input>
				</div>
				<div class="form-group required col-md-6">
					<aui:input label="Personal No" type="number" name="joining_personalNo"
						class="form-control" id="joining_personalNo" required="true">
						<aui:validator errorMessage="Select a Personal No." name="required" />
					</aui:input>

				</div>
			</div>
			
			<div class="row">
				
				<div class="form-group required col-md-6">
					<aui:input label="From Date" type="date" name="joining_fromDate" class="form-control"
						id="joining_fromDate">
						<aui:validator errorMessage="Select a From Date" name="required" />
					</aui:input>


				</div>

			</div>
			<div class="row">

				<div class="form-group required col-md-6">
					<aui:input label="People" type="number" name="joining_people" class="form-control"
						id="joining_people" />


				</div>


				<div class="form-group  col-md-6">
					<aui:input label="Full Name" type="text" name="joining_fullName" class="form-control"
						id="joining_fullName" />


				</div>

			</div>

			<div class="row">

				<div class="form-group required col-md-6">
					<aui:input label="To Date" type="date" name="joining_toDate" class="form-control"
						id="joining_toDate">
						<aui:validator errorMessage="Select a To Date" name="required" />
						</aui:input>


				</div>


				<div class="form-group  col-md-6">
					<aui:input label="Selection Date" type="date" name="joining_selectionDate"
						class="form-control" id="joining_selectionDate" />

				</div>

			</div>

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Joining Date" type="date" name="joining_joiningDate"
						class="form-control" id="joining_joiningDate" />


				</div>


				<div class="form-group  col-md-6">
					<aui:input label="Confirmation Date" type="date" name="joining_confirmationDate"
						class="form-control" id="joining_confirmationDate" />
				</div>

			</div>

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Grade Confirmation Date" name="joining_gradeConformationDate" type="date"
						class="form-control" id="joining_gradeConfirmationDate" />


				</div>


				<div class="form-group  col-md-6">
					<aui:input label="Govt Service Date" name="joining_govtServiceDate" type="date"
						class="form-control" id="joining_govtServiceDate" />


				</div>

			</div>

			<div class="row">


				<div class="form-group  col-md-6">
					<aui:input label="Recruitment Batch" name="joining_recruitmentBatch" type="input"
						class="form-control" id="joining_recruitmentBatch" />


				</div>


				<div class="form-group  col-md-6">


					<div class="custom-file">
						<aui:input label="Joining Letter" type="file" class="custom-file-input"
							name="joining_joiningLetter" id="joining_joiningLetter" />

					</div>

				</div>

			</div> 
	

	</div>
</div>
