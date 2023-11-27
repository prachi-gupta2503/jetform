<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/init.jsp"%>

<style>
.card-counter {
	box-shadow: 2px 2px 10px #DADADA;
	margin: 5px;
	/*padding: 20px 10px;*/
	background-color: #fff;
	height: 200px;
	border-radius: 5px;
	transition: .3s linear all;
}

.card-counter:hover {
	box-shadow: 4px 4px 20px #DADADA;
	transition: .3s linear all;
}

.card-counter.primary {
	background-color: #007bff;
	color: #FFF;
}

.card-counter.danger {
	background-color: #ef5350;
	color: #FFF;
}

.card-counter.success {
	background-color: #66bb6a;
	color: #FFF;
}

.card-counter.info {
	background-color: #26c6da;
	color: #FFF;
}

.card-counter i {
	font-size: 5em;
	opacity: 0.2;
}

.card-counter .title {
	font-weight: 600;
	font-size: 20px;
	margin-top:15px;
	margin-bottom:15px;
	display: block;
}

.card-counter .count-numbers {
	/*position: absolute;
	right: 35px;*/
	top: 50px;
	font-weight: 600;
	font-size: 20px;
	display: block;
}

.card-counter .egov-count-name {
	/*position: absolute;
	right: 35px;
	top: 65px;*/
	font-style: italic;
	text-transform: capitalize;
	opacity: 1;
	display: block;
	font-size: 14px;
}

.container.card-img-holder .card-img-absolute {
    position: absolute;
    top: 0;
    right: 0;
    height: 100%;
}
img, svg {
    vertical-align: middle;
}

.bg-gradient-danger{
	background: linear-gradient(90deg,#ffbf96,#fe7096);
}

</style>
<%
	JSONObject dashboardData = (JSONObject) request.getAttribute("dashboardData");
	int cc = 0, file = 0, note = 0, dak = 0, actionables=0, agenda=0,mom=0, committee=0, cng=0;
	if (dashboardData != null) {
		cc = dashboardData.getInt("CC");
		file = dashboardData.getInt("File");
		note = dashboardData.getInt("Note");
		dak = dashboardData.getInt("DAK");
		actionables = dashboardData.getInt("Actionables");
		agenda = dashboardData.getInt("Agenda");
		mom = dashboardData.getInt("MOM");
		committee = dashboardData.getInt("Committee");
		cng = dashboardData.getInt("CNG");
	}
	
%>
<div class="container card-counter card-img-holder bg-gradient-danger text-white">
	<img src="<%=request.getContextPath()%>/images/circle.svg" class="card-img-absolute" alt="circle">
	<div class="row">
		<div class="col-md-6">
			<span class="title">
			<liferay-ui:message key="dashboard.title" />
			</span>
		</div>
		<div class="col-md-6">
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<span class="count-numbers"><%=dak%></span> 
			<span class="egov-count-name">DAK(s)</span>
		</div>
		
		<div class="col-md-3">
			<span class="count-numbers"><%=file%></span> 
			<span class="egov-count-name">File(s)</span>
		</div>
		
		<div class="col-md-2">
			<span class="count-numbers"><%=note%></span> 
			<span class="egov-count-name">Note(s)</span>
		</div>
		
		<div class="col-md-2">
			<span class="count-numbers"><%=cc%></span> 
			<span class="egov-count-name">CC(s)</span>
		</div>
		
		<div class="col-md-2">
			<span class="count-numbers"><%=mom%></span> 
			<span class="egov-count-name">MOM(s)</span>
		</div>
	</div>
	
	<div class="row mt-3">

		<div class="col-md-3">
			<span class="count-numbers"><%=actionables%></span> 
			<span class="egov-count-name">Actionables</span>
		</div>
		
		<div class="col-md-3">
			<span class="count-numbers"><%=agenda%></span> 
			<span class="egov-count-name">Agenda(s)</span>
		</div>
		
		<div class="col-md-3">
			<span class="count-numbers"><%=committee%></span> 
			<span class="egov-count-name">Committee(s)</span>
		</div>
		
		<div class="col-md-3">
			<span class="count-numbers"><%=cng%></span> 
			<span class="egov-count-name">CNG(s)</span>
		</div>
	</div>
</div>
<%--
<div class="card card-counter primary">
	<div class="row">
		<div class="mt-2 mb-1 ml-3 mr-1 col-sm-8">
			<h2 style="color: white;">eGov</h2>
		</div>
		<div class="col-sm-3 mt-1" style="text-align: right;">
			<img src="<%=request.getContextPath()%>/images/email.png" alt="No image" style="width: 50px; height = 50px; color: white;">
		</div>

	</div>
	<div class="row">
		<div class="card-body text-center">
			<div class="container">
				<div class="row">
					<div class="col-md-3 count-numbers"><%=dak%></div>
					<div class="col-md-3 count-numbers"><%=file%></div>
					<div class="col-md-3 count-numbers"><%=note%></div>
					<div class="col-md-3 count-numbers"><%=cc%></div>
				</div>

				<div class="row">
					<div class="col-md-3 count-name">DAKs</div>
					<div class="col-md-3 count-name">Files</div>
					<div class="col-md-3 count-name">Notes</div>
					<div class="col-md-3 count-name">CCs</div>
				</div>
			</div>
		</div>
	</div>
</div>

 --%>
