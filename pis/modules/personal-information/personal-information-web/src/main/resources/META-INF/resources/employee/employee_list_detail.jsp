<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/adaptive-media-image"
	prefix="liferay-adaptive-media"%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css"
	rel="stylesheet">

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

	<div class="row">
		<div class="col-md-12">
			<table class="table" id="userTable">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">Personal No.</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Designation</th>
						<th scope="col">Division</th>
						<th scope="col">Factory/Section</th>
						<th scope="col">Action</th>
			
					</tr>
				</thead>
				<tbody>
			
					<c:set var="employees" value='${requestScope["employees"]}' />
					<c:if test="${not empty employees}">
						<c:forEach var="employee" items="${employees}">
							<tr>
								<td scope="row"><c:if test="${not empty employee.getImage()}">
										<liferay-adaptive-media:img class="img-fluid round_image_avatar"
											fileVersion="${employee.getImage().getFileVersion()}" />
									</c:if> <c:if test="${empty employee.getImage()}">
										<img class="card-img-top round_image_avatar" src="<%=request.getContextPath()%>/images/blankUser.jpg"  >
									</c:if></td>
								<td>${employee.getPersonalNo()}</td>
								<td>${employee.getName()}</td>
								<td>${employee.getEmail()}</td>
								<td>${employee.getDesignation()}</td>
								<td>${employee.getDivision()}</td>
								<td>${employee.getFactorySaction()}</td>
								
								<td>
									<liferay-ui:icon-menu>
									
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='<%=employeeProfileRenderURL%>&<portlet:namespace/>employeeId=${employee.getEmployeeId()}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />viewProfile">
										<liferay-ui:icon icon="view" message="View Profile" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />updateRank">
										<liferay-ui:icon icon="top" message="Change Rank" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />editBio">
										<liferay-ui:icon icon="edit" message="Update Bio" />
									</button>
									</liferay-ui:icon-menu>
									<%--<liferay-ui:icon-menu>
									
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${editPersonalInformationRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit personal Information" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Address" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Qualification" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Past Experience" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Verification" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Joining Details" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Documents" />
									</button>
									<button type="button" class="btn btn-link" style="color: #6b6c7e;" onclick="location.href='${employeeProfileRenderURL}';" name="<portlet:namespace />edit_btn"
									id="<portlet:namespace />edit_btn">
										<liferay-ui:icon message="Edit Permission" />
									</button>
									</liferay-ui:icon-menu> --%>
<%--<a class="btn btn-primary" href=""><img alt="<%=employeeProfileRenderURL%>&<portlet:namespace/>employeeId=${employee.getEmployeeId()}"
											width=20 src="<%=request.getContextPath()%>/images/pencil.png"></a>
								
										<a class="btn btn-primary" href="<%=employeeProfileRenderURL%>&<portlet:namespace/>employeeId=${employee.getEmployeeId()}">View</a>
										
										<a class="btn btn-primary" href="<%=employeeProfileRenderURL%>&<portlet:namespace/>employeeId=${employee.getEmployeeId()}"><i class="far fa-arrow-alt-circle-up mr-1"></i><i class="far fa-arrow-alt-circle-down"></i></a> --%>
									</td>
										
												
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
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

		$('#userTable').DataTable();/*{
			"pageLength": 10,
			
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
		});*/

	});
</script>
