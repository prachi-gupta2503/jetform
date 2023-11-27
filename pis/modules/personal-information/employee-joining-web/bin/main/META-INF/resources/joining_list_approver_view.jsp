<%@page import="com.adjecti.pis.liferay.dto.EmployeeDTO"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="java.util.List"%>



<%
	request.setAttribute("employees", employees);
%>

<div class="row">
	<div class="col-md-12">
		<table class="table" id="userTable">
			<thead class="bg-primary text-white ">
				<tr>
					<th scope="col">Unit</th>
					<th scope="col">Full Name</th>
					<th scope="col">Gender</th>
					<th scope="col">Designation</th>
					<th scope="col">Trade</th>
					<th scope="col">Grade</th>
					<th scope="col">Date of Birth</th>
					<th scope="col">Date of Joining</th>
					<th scope="col">Caste Category</th>
					<th scope="col">Email ID</th>
					<th scope="col">Status</th>

					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<portlet:renderURL var="editJoiningProcessRenderUrl">
						<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
						<portlet:param name="employeeId" value="${employee.employeeId}" />
					</portlet:renderURL>

					<tr>
						<td>${employee.unit}</td>
						<td>${employee.fullName}</td>
						<td>${employee.gender}</td>
						<td>${employee.designation}</td>
						<td>${employee.trade}</td>
						<td>${employee.grade}</td>
						<td><fmt:formatDate type="date" value="${employee.dateOfBirth}" /></td>
						<td><fmt:formatDate type="date" value="${employee.dateOfJoining}" /></td>
						<td>${employee.casteCategory}</td>
						<td>${employee.emailId}</td>
						<td>${employee.state}</td>
						<td>
							<liferay-ui:icon-menu>
								<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${editJoiningProcessRenderUrl}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
									<liferay-ui:icon message="Edit" />
								</button>
								<br>
								<c:forEach items="${employee.actions}" var="action">

									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick='performWorkflow(${employee.employeeId},'
										${action}')'
								name="<portlet:namespace />performWorkflow_btn" id="<portlet:namespace />performWorkflow_btn">
										<liferay-ui:icon message="${action}" />

									</button>
									<br>
								</c:forEach>
							</liferay-ui:icon-menu>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>

function performWorkflow(employeeId,action){

	Liferay.Service(
			'/pis.employee/perform-work-flow-action',
			  {
			    employeeId: employeeId,
			    action: action
			  },
			  function(obj) {
			    console.log(obj);
				document.location.reload(true);
			  }
			);
}

</script>

