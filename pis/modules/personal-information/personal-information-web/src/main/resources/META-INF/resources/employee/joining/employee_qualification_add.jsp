



	<div class="form-card">
		<input type="button" id="btAdd" value="Add Qualification" class="bt" />


		<h2 class="fs-title">Add Education</h2>
		<p id="EducationErrorMessage"></p>
		<div >
			<div style="border: 1px solid black; padding: 5px">
				<table id="tbUser">

					<tbody id="qualtbody">
						<tr>
							<td>
							<aui:input name="employeeQualificationId" id="employeeQualificationId" type="hidden"/>
							
							<aui:select label="Qualification" class="form-control"
									name="educational_Qualification"
									id="educational_Qualification1">
									<aui:option selected="">Select Qualification</aui:option>
									<%
										for (Qualification qualification : qualifcationList) {
													String qualificationName = qualification.getName();
													System.out.println(qualificationName);
													long qualificationId = qualification.getQualificationId();
									%>
									<aui:option value="<%=qualificationId%>"><%=qualificationName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Qualification"
										name="required" />
								</aui:select></td>
							<td><aui:select label="Level" class="form-control"
									name="educational_Level" id="educational_Level1"
									required="true">
									<aui:option selected="">Select Level</aui:option>
									<%
										for (QualificationLevel qualificationLevel : levelList) {
													String levelName = qualificationLevel.getName();
													System.out.println(levelName);
													long levelId = qualificationLevel.getQualificationLevelId();
									%>
									<aui:option value="<%=levelId%>"><%=levelName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Level" name="required" />
								</aui:select></td>
							<td><aui:select label="Specialization" class="form-control"
									name="educational_Specialization"
									id="educational_Specialization1" required="true">
									<aui:option selected="">Select Specialization</aui:option>
									<%
										for (Specialization specialization : specializationList) {
													String specializationName = specialization.getName();
													System.out.println(specializationName);
													long specializationId = specialization.getSpecializationId();
									%>
									<aui:option value="<%=specializationId%>"><%=specializationName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Specialization"
										name="required" />
								</aui:select></td>
							<td><aui:select label="Grade" class="form-control"
									name="educational_Grade" id="educational_Grade1"
									required="true">
									<aui:option selected="">Select Grade</aui:option>
									<%
										for (QualificationGrade qualificationGrade : gradeList) {
													String gradeName = qualificationGrade.getName();

													long gradeId = qualificationGrade.getQualificationGradeId();
									%>
									<aui:option value="<%=gradeId%>"><%=gradeName%></aui:option>
									<%
										}
									%>
									<aui:validator errorMessage="Select a Grade" name="required" />
								</aui:select></td>
						</tr>
						<tr>
							<td><div class="form-check form-check-inline">
									<aui:input label="Educational Foreign Degree" type="checkbox"
										name="educational_Foreign_Degree"
										id="educational_Foreign_Degree1" class="form-check-input" />

									<label class="form-check-label" for="exampleCheck1">Yes</label>
								</div></td>
							<td><aui:input label="Educational Institution" type="text"
									name="educational_Institution" class="form-control"
									id="educational_Institution1">
									<aui:validator name="maxLength">100</aui:validator>
									<aui:validator
										errorMessage="The Educational Institution is a required field"
										name="required" />
								</aui:input></td>
							<td><aui:input label="Educational From Year" type="number"
									name="educational_From_Year" class="form-control"
									id="educational_From_Year1" required="true">
									<aui:validator
										errorMessage="The Educational From Year is a required field"
										name="required" />
								</aui:input></td>
							<td><aui:input label="Educational To Year" type="number"
									name="educational_To_Year" class="form-control"
									id="educational_To_Year1" required="true">
									<aui:validator
										errorMessage="The Educational To Year is a required field"
										name="required" />
								</aui:input></td>
						</tr>
						<tr>
							<td><aui:input label="Educational Qualification Date"
									type="date" name="educational_Qualification_Date"
									class="form-control" id="educational_Qualification_Date1">
									<aui:validator
										errorMessage="The Educational Qualification Date is a required field"
										name="required" />
								</aui:input></td>
							<td><aui:input label="Educational Marks Percentage"
									type="text" name="educational_Marks_Percentage"
									class="form-control" id="educational_Marks_Percentage1">
									<aui:validator name="maxLength">10</aui:validator>
								</aui:input></td>
							<td><div class="custom-file">
									<aui:input type="file" id="educational_Certificate1"
										name="educational_Certificate" label="Educational Certificate"
										onChange="getEducationFileId(this.id)"></aui:input>
								</div></td>
						</tr>

					</tbody>
			</div>
			</table>
		</div>

	</div>

</div>