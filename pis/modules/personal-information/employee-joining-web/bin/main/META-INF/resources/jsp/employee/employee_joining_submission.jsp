<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../../init.jsp"%>
<portlet:renderURL var="viewJoiningList">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>
<%long employeeId = ParamUtil.getLong(request, "employeeId", 0); %>

<div class="card form-card m-4">
<div class="card-header bg-primary text-white">
	<h5>Submit for Approval</h5>
</div>
<div class="card-body text-center">
	<div class="mt-5 mb-5"><p>I hereby declare that all the joining information filled in as per the documents provided and verified by me.</p></div>
	<button type="button" name="submit" class="btn btn-primary action-button-submit mr-2">Submit</button>
</div>
</div>
<script>
$(document).ready(function() {
	var employeeId='<%=employeeId%>';
$(".action-button-submit").click(function() {
    
	Liferay.Service(
			  '/pis.employee/submit-employee-joining',
			  {
			    employeeId:employeeId 
			  },
			  function(obj) {
			    console.log(obj);
	 			window.location.href = '<%=viewJoiningList.toString()%>'
			    
			  }
			);
});
});
</script>