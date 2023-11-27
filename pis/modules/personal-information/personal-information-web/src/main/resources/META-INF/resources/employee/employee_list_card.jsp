<%@ include file="/init.jsp"%>

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
				<c:set var="employees" value='${requestScope["employees"]}' />
				<c:if test="${not empty employees}">
					<c:forEach var="employee" items="${employees}">
						<div class="card">
							<!---->
							<!---->
							<div class="card-body">
								<!---->
								<!---->
								<div class="row">
									<div class="d-flex justify-content-between flex-column col-xl-12 col-21">
										<div class="d-flex justify-content-start">
											<span class="b-avatar badge-light-danger rounded" style="width: 125px; height: 104px;"> <span class="b-avatar-img"> <c:if
														test="${not empty employee.getImage()}">
														<liferay-adaptive-media:img fileVersion="${employee.getImage().getFileVersion()}" />

													</c:if> <c:if test="${empty employee.getImage()}">
														<img src="<%=request.getContextPath()%>/images/blankUser.jpg" alt="No image" style="width: 100px; background-color: #a5a5a5;">
													</c:if>
											</span>
											</span>

											<div class="d-flex flex-column ml-1">
												<div class="mb-1">
													<h4 class="mb-1">${employee.getName()}</h4>
													<h4 class="mb-1" style="color: #0b5fff;">${employee.getPersonalNo()}</h4>
													<h5 class="card-text mb-1">${employee.getDesignation()}</h5>
												</div>
												<div class="d-flex flex-wrap">
													<a class="btn btn-primary" href="<%=employeeProfileRenderURL%>&<portlet:namespace/>employeeId=${employee.getEmployeeId()}"><img alt="" width=30 src="<%=request.getContextPath()%>/images/pencil.png"></a>
													<%--<button type="button" class="btn ml-1 btn-outline-danger">Delete</button> --%>
												</div>
											</div>
										</div>
									</div>

									<div class="col-xl-12 col-12 pt-3 mt-3" style="border-top:1px solid #f1f2f5;">
										<table class="mt-5 mt-xl-0 w-100 pt-3">
											<tr>
												<th class="mb-2">
													<span class="font-weight-bold">Email</span>
												</th>
												<td class="mb-2">${employee.getEmail()}</td>
											</tr>
											<tr>
												<th class="mb-2">
													<span class="font-weight-bold">Division</span>
												</th>
												<td class="mb-2">${employee.getDivision()}</td>
											</tr>
											<tr>
												<th class="mb-2">
													<span class="font-weight-bold">Factory/Section</span>
												</th>
												<td class="mb-2">${employee.getFactorySaction()}</td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>

