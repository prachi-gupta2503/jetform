
<div class="form-card">
	<input type="button" id="docBtnAdd" value="More Documents" class="bt" />
	<h2 class="fs-title">Documents</h2>
	<p id="documentErrorMessage"></p>
	<div style="border: 1px solid black; padding: 5px">
		<table id="doctable">
			<tbody id="doctbody">
				<tr>
					<td>
					<aui:input name="employeeDocumentId" id="employeeDocumentId" type="hidden"/>
					<aui:input label="Title" type="text"
							name="document_title" class="form-control"
							id="document_title1">
							<aui:validator errorMessage="The Title field is a required field"
								name="required" />

						</aui:input></td>
						
						<td><aui:input label=" Document Description" type="text"
							name="document_discription" class="form-control"
							id="document_discription1" /></td></tr>

				<tr><td><aui:select label="Document Type" class="form-control"
							name="document_type" id="document_type1">
							<aui:option selected="">Document Type</aui:option>
							<%
								for (DocumentType documentType : documentTypes) {
							%>
							<aui:option value="<%=documentType.getDocumentTypeId()%>"><%=documentType.getName()%>

							</aui:option>
							<%
								}
							%> 

						</aui:select></td>
							<td><aui:input type="file" label="Document"
							class="custom-file-input" name="employee_document"
							id="employee_document1"
							onchange="getDocumentFileId(this.id)">
							<aui:validator
								errorMessage="The Document is a required field"
								name="required" />
						</aui:input></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<style>
#doctbody {
	border: 1px solid black;
	margin: 10px;
	width: 100%;
}

#doctable {
	border-collapse: collapse;
	width: 100%;
	padding: 10px;
	border: 1px solid black;
}

td {
	padding: 10px;
}
</style>