<%@page import="com.adjecti.onboarding.web.dto.BulkOnboardingRecordDTO"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="./init.jsp"%>
<style>

table.dataTable thead th, table.dataTable tfoot th {
    font-weight: 600 !important;
}
</style>
	<!-- bulkOnboardingList -->

	<%
	List<BulkOnboardingRecordDTO> bulkOnboardingRecordDTOList= (List<BulkOnboardingRecordDTO>)request.getAttribute("bulkOnboardingList");
	%>
			<button id="<portlet:namespace/>uploadBtn"
				class="btn btn-sm btn-primary float-right mb-2 ml-2">Upload XLS</button>
	<table id="userTable" class="display table table-striped"
		cellspacing="0" width="100%">
		<thead>
		<tr>
					    <th>Sr no.</th>
						<th>Uploaded By</th>
						<th>Title</th>
						<th>Remarks</th>
						<th>Upload Date</th>
						<th>Total Records</th>
						<th>Approved Records</th>
						<th>Rejected Records</th>
						<th>Deleted Records</th>
						<th>Pending Records</th>
					</tr>
		</thead>
		<tbody>
		     <c:forEach var="bulkOnboardingRecordDTO" items="<%=bulkOnboardingRecordDTOList%>" varStatus="index">
		          <tr>
		             <td>${index.index + 1 }</td>
		             <td>${bulkOnboardingRecordDTO.userName}</td>
		             <td>${bulkOnboardingRecordDTO.tittle}</td>
		             <td>${bulkOnboardingRecordDTO.remarks}</td>
		             <td><fmt:formatDate value="${bulkOnboardingRecordDTO.createDate}" pattern="dd-MM-yyyy"/></td>
		             <td>${bulkOnboardingRecordDTO.totalRecords}</td>
		             <td>${bulkOnboardingRecordDTO.totalApprovedRecords}</td>
		             <td>${bulkOnboardingRecordDTO.totalRejectedRecords}</td>
		             <td>${bulkOnboardingRecordDTO.totalDeletedRecords}</td>
		             <td>${bulkOnboardingRecordDTO.totalPendingRecords}</td>
		          </tr>
		     </c:forEach>
		</tbody>
		</table>
	
<aui:script>
$(document).ready( function() {
    var table=$('#userTable').DataTable({
     "pageLength": 50
    });
} );
</aui:script>