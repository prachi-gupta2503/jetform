<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.employee_profile_jsp");
%>
<%
long employeeId=ParamUtil.getLong(request, "employeeId");
LOGGER.info("employeeId : "+employeeId);
%>
<div class="container">
	<div class="row">
		<div class="col-md-12" style="background-image: url(&#39;images/bg-color.png&#39;); padding-top: 15px;">
			<h6>PIS / Employee / 990032</h6>
		</div>

	</div>
	<div class="mt-2"></div>
	<div class="row" style="background-color: #edf6ff;">
		<div class="col-md-4">
			<div class="card-header header-primary text-center">
				<h4>990032</h4>
			</div>
		</div>
		<div class="col-md-8 card-header header-primary">
			<h4>Dr. Vinay Kumar Khosla</h4>
		</div>
	</div>

	<div class="row" style="background-color: #edf6ff;">
		<div class="col-md-4">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div style="background-color: #8b8bff; padding-bottom: 20px;">
							<div class="text-center" style="width: 100%; padding-top: 20px;">
								<img src="./Use Case - Employee Profile View_files/photo.png" style="width: 50%;">
							</div>
							<div style="width: 100%; text-align: center;">
								<label style="font-weight: bold;">Dr. Vinay Kumar Khosla</label>
								<p class="data">990032</p>
								<p class="data">General Manager (AFK)</p>
								<p class="data">vinay.khosla@ofb.in</p>
							</div>
						</div>
						<div class="section-content">
							<h5>
								<i class="fa fa-address-card"></i>Official
							</h5>
							<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
								<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;" class="fa fa-times fa-action"></i>
							</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
								class="fa fa-hand-paper-o fa-action"></i>
							</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
								class="fa fa-check fa-action"></i>
							</span>
							<hr>

							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEEFORM%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-8" style="padding-left: 0px;">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="section-content">
							<div>
								<h5>
									<i class="fa fa-user-plus"></i>Personal
								</h5>
								<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
									<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;"
									class="fa fa-times fa-action"></i>
								</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
									class="fa fa-hand-paper-o fa-action"></i>
								</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
									class="fa fa-check fa-action"></i>
								</span>
							</div>
							<hr>
<%--
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=EmployeeForm.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>
--%>
						</div>
						<div class="section-content">
							<div>
								<h5>
									<i class="fa fa-graduation-cap"></i>Qualification
								</h5>
								<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
									<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;"
									class="fa fa-times fa-action"></i>
								</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
									class="fa fa-hand-paper-o fa-action"></i>
								</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
									class="fa fa-check fa-action"></i>
								</span>
							</div>
							<hr>
<%--							
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=EmployeeForm.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>
--%>
						</div>
					</div>
					<div class="col-md-6">
						<div class="section-content">
							<div>
								<h5>
									<i class="fa fa-home"></i>Address
								</h5>
								<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
									<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;"
									class="fa fa-times fa-action"></i>
								</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
									class="fa fa-hand-paper-o fa-action"></i>
								</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
									class="fa fa-check fa-action"></i>
								</span>
							</div>
							<hr>
<%--
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=EmployeeForm.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>
--%>
						</div>
						<div class="section-content">
							<div>
								<h5>
									<i class="fa fa-phone-square"></i>Contact
								</h5>
								<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
									<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;"
									class="fa fa-times fa-action"></i>
								</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
									class="fa fa-hand-paper-o fa-action"></i>
								</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
									class="fa fa-check fa-action"></i>
								</span>
							</div>
							<hr>
<%--
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=EmployeeForm.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>
--%>
						</div>
						<div class="section-content">
							<h5>
								<i class="fa fa-desktop"></i> Workstation
							</h5>
							<span class="float-right fa-actions-top admin-role"> <i style="color: blue;" class="fa fa-edit fa-action"></i>
								<i style="color: green;" class="fa fa-share fa-action"></i> <i style="color: red;" class="fa fa-times fa-action"></i>
							</span> <span class="float-right fa-actions-top user-role"> <i style="color: blue;"
								class="fa fa-hand-paper-o fa-action"></i>
							</span> <span class="float-right fa-actions-top approver-role"> <i style="color: #ff8306;"
								class="fa fa-check fa-action"></i>
							</span>
							<hr>
<%--
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=EmployeeForm.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>
--%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 section-content" style="background-color: #edf6ff;">
			<!-- Relation.jsp -->

			<!--Accordion wrapper-->
		</div>
	</div>
</div>