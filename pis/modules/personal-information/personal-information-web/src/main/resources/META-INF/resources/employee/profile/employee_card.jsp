<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/adaptive-media-image"
	prefix="liferay-adaptive-media"%>

<style>

.round_image_avatar {
	border-radius: 50%;
	width: 50px;
	height: 50px;
}

.emptydiv {
	margin-top: 10px;
}
</style>


<div class="container">
	<div class="row">

		<div class="col-sm-3">Employee | Showing All Employee</div>
		<div class="col-sm-3">
			<a href="">New Employee Joining</a>
		</div>
		<div class="col-sm-3">
			<a href="">Bulk Employee Onboarding</a>
		</div>
		<div class="col-sm-3">
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Employee Search</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li>
						<form>
							<div class="mt-2 mb-2 ml-2 mr-2">
								<div class="form-group">
									<label for="Name">Name</label> <input type="text"
										class="form-control" id="Name" placeholder="Enter Name">
								</div>
								<div class="form-group">
									<label for="Division">Division</label> <input type="text"
										class="form-control" id="Division"
										placeholder="Enter Division">
								</div>
								<div class="form-group">
									<label for="Factory-Section">Factory / Section</label> <input
										type="text" class="form-control" id="Factory-Section"
										placeholder="Enter Factory / Section">
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>

					</li>

				</ul>
			</div>
		</div>
	</div>
</div>
<div class="row">

	<portlet:renderURL var="employeeListURL">
		<portlet:param name="mvcRenderCommandName"
			value="view_employee_list" />
	</portlet:renderURL>
	<a class="btn btn-primary" href="${employeeListURL}">List View</a>

</div>
<br>
<br>

<div class="container">
	<table class="table" id="userTable" hidden>
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Personal No.</th>
				<th scope="col">Name</th>
				<th scope="col">Designation</th>
				<th scope="col">Division</th>
				<th scope="col">Factory/Section</th>
				<th scope="col">Email</th>
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>

			<c:set var="employees" value='${requestScope["employees"]}' />
			<c:if test="${not empty employees}">
				<c:forEach var="employee" items="${employees}">

					<portlet:renderURL var="employeeDetailsURL">
						<portlet:param name="employeeId"
							value="${employee.getEmployeeId()}" />
						<portlet:param name="mvcRenderCommandName"
							value="view_employee_details" />
					</portlet:renderURL>


					<tr>
						<td scope="row"><c:if test="${not empty employee.getImage()}">
								<liferay-adaptive-media:img class="img-fluid round_image_avatar"
									fileVersion="${employee.getImage().getFileVersion()}" />
							</c:if> <c:if test="${empty employee.getImage()}">
								<div style=>
									<liferay-ui:icon image="user_icon"  />
								</div>
							</c:if></td>
						<td>${employee.getPersonalNo()}</td>
						<td>${employee.getName()}</td>
						<td>${employee.getDesignation()}</td>
						<td>${employee.getDivision()}</td>
						<td>${employee.getFactorySaction()}</td>
						<td>${employee.getEmail()}</td>
						<td><a class="btn btn-primary" href=""><img alt=""
								width=20 src="<%=request.getContextPath()%>/images/pencil.png"></a>&nbsp;
							<a class="btn btn-primary" href="${employeeDetailsURL}">View</a></td>

					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>




<div class="card-columns">
	<c:set var="employees" value='${requestScope["employees"]}' />
	<c:if test="${not empty employees}">
		<c:forEach var="employee" items="${employees}">

			<portlet:renderURL var="employeeDetailsURL">
				<portlet:param name="employeeId" value="${employee.getEmployeeId()}" />
				<portlet:param name="mvcRenderCommandName"
					value="view_employee_details" />
			</portlet:renderURL>
			<div class="card" style="width: 20rem;">
				<c:if test="${not empty employee.getImage()}">
					<liferay-adaptive-media:img class="img-fluid card-img-top imgSize"
						fileVersion="${employee.getImage().getFileVersion()}" style="height: 20.3rem;"/>

				</c:if>
				<c:if test="${empty employee.getImage()}">
					 <img class="card-img-top imgSize" src="<%=request.getContextPath()%>/images/blankUser.jpg" alt="Card image cap" >
				</c:if>
				<div class="card-body">
					<h6 class="card-title" style="font-size: 20px;">
						<b>${employee.getName()}</b>
					</h6>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">Personal No</th>
								<th scope="col">${employee.getPersonalNo()}</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Designation</th>
								<td>${employee.getDesignation()}</td>
							</tr>
							<tr>
								<th scope="row">Division</th>
								<td>${employee.getDivision()}</td>
							</tr>
							<tr>
								<th scope="row">Factory/Section</th>
								<td>${employee.getFactorySaction()}</td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td>${employee.getEmail()}</td>
							</tr>
						</tbody>
					</table>
					<br> <a class="btn btn-primary" href=""><img alt=""
						width=30 src="<%=request.getContextPath()%>/images/pencil.png"></a>&nbsp;
					<a class="btn btn-danger" href="${employeeDetailsURL}"><img
						alt="" width=30
						src="<%=request.getContextPath()%>/images/book.png"></a>
				</div>
			</div>



			<%-- ${employee.getPersonalNo()}
					${employee.getName()}
					${employee.getDesignation()}
					${employee.getDivision()}
					${employee.getFactorySaction()}
					${employee.getEmail()} --%>


		</c:forEach>
	</c:if>
</div>
<script>
	var buttonCommon = {
		exportOptions : {
			format : {
				body : function(data, row, column, node) {
					// if it is select
					if (column == 2) {
						return $(data).find("option:selected").text()
					} else
						return data
				}
			}
		}
	};
	$(document).ready(function() {

		$('#userTable').DataTable({
			"lengthChange": false,
			"bPaginate": false,
			"searching" : false,
			"pageLength" : 10,
			dom : 'Bfrtip',
			buttons : [

			$.extend(true, {}, buttonCommon, {
				extend : "excel",
				exportOptions: {
					columns: [ 1, 2, 3, 4, 5, 6 ]
				}
			}), $.extend(true, {}, buttonCommon, {
				extend : "pdf",
				exportOptions: {
					columns: [ 1, 2, 3, 4, 5, 6 ]
				}
			}) ]
		});

	});
</script>
