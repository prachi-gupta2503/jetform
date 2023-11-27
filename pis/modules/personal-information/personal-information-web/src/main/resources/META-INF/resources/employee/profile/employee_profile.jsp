<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.PeopleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>


<%@ include file="/init.jsp"%>

<style>
.profile-img img {
  border: 2px solid #c3c3c3;
}

.profile-img:hover .overlay {
  opacity: 1;
}

.profile-img .overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: .5s ease;
  /*background-color: #008CBA;*/
}

.profile-img .overlay .text {
  color: white;
  font-size: 20px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  text-align: center;
}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
	
<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css"
	rel="stylesheet">
 
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.employee_profile_jsp");%>
<%
	//PISUserUtil.setIdamAPIEndPoint("http://172.20.115.26:8095/user");
	
	PISUserUtil.setIdamAPIEndPoint("");
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);

	Employee employee = null;
	try {
		if(employeeId>0){
			employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		}else{
			employee=EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
			employeeId=employee.getEmployeeId();
		}
	} catch (Exception e) {
		LOGGER.info("Error : "+e.getMessage());
	}
	
	People people = null;
	try {
		people = PeopleLocalServiceUtil.getPeople(employee.getPeopleId());
	} catch (Exception e) {
	}
	
	LOGGER.info("employeeId : "+employeeId+", "+user.getEmailAddress());
%>
<div class="page-wrapper">
	<div class="content container-fluid">
	<%----####################################################################-----%>
		<div class="page-header">
			<div class="row">
				<div class="col-sm-12">
					<h3 class="page-title">Profile</h3>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Employee</a></li>
						<li class="breadcrumb-item active">Profile</li>
					</ul>
				</div>
			</div>
		</div>
<%	
	if(employee==null || people==null){
%>
		<div class="card mb-0">
			<div class="card-body">
				<div class="row">
					<div class="col-md-12">
						<h5>The profile does not exists.</h5>
					</div>
				</div>
			</div>
		</div>
<%		
	}else{
%>
		<%@ include file="/employee/profile/employee_profile_detail.jsp"%>
<%	
	}
%>
	</div>
</div>


