<script>
$(document).ready( function() {
   	var modal = document.getElementById("myModal");
	var btn = document.getElementById("<portlet:namespace/>uploadBtn");
	var cancelBtn = document.getElementById("<portlet:namespace/>cancelBtn");
	var span = document.getElementsByClassName("close")[0];
	btn.onclick = function() {
		modal.style.display = "block";
	}
	span.onclick = function() {
		modal.style.display = "none";
	}
	cancelBtn.onclick = function() {
		modal.style.display = "none";
	}
/**
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	*/
	

});


</script>

	
<div id="myModal" class="upload-registration">
	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
	</portlet:renderURL>
	<div class="modal-content" style="width:80%; padding:40px;">
<c:set var="currentUnit" value='<%=selectedUnit.getOrganizationId() %>' />
		<div>
			<span class="close" style="font-weight: 500 !important; font-size:40px !important;">&times;</span>
		</div>
		<div id="upload-registration-dialog" title="Dialog box">
			<aui:form name="myForm" enctype="multipart/form-data" action="${uploadFile}">
				<aui:input type="text" name="popUpFileTitle" label="Title" required="true">
					<aui:validator name="maxLength">50</aui:validator>
				</aui:input>
				<aui:input type="textarea" name="popUpFileRemark" label="Remark" required="true"></aui:input>
				<aui:select label="Select Organization:" id="organization" name="organization" required="true" >
					<c:forEach var="organization" items="<%=organizations%>">
						<%-- <aui:option value="${organization.organizationId}">${organization.name}</aui:option> --%>
						<option value="${organization.organizationId}" ${organization.organizationId == currentUnit ? 'selected' : ''}>${organization.name}</option>
					</c:forEach>
				</aui:select>
				<aui:input type="file" name="pisDocument" label="Select File"  required="true" >
				<aui:validator name="acceptFiles">'xls, xlsx, csv'</aui:validator>
				</aui:input>
				<aui:button type="submit" name="btnUploadFile" value="Upload File"></aui:button>
				<aui:button type="cancel" id="cancelBtn" ></aui:button>
			</aui:form>
		</div>
	</div>
</div>