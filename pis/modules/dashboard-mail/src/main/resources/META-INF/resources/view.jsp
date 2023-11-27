<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ include file="/init.jsp" %>
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

.card-counter .count-name {
	/*position: absolute;
	right: 35px;
	top: 65px;*/
	font-style: italic;
	text-transform: capitalize;
	opacity: 0.5;
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
.bg-gradient-success{
	background: linear-gradient(90deg,#84d9d2,#07cdae);
}
</style>
<%
	String unreadCount=(String)request.getAttribute("dashboardData");
	if(StringUtils.isBlank(unreadCount)){
		unreadCount="0";
	}
%> 

<div class="container card-img-holder card-counter bg-gradient-success text-white">
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
		<div class="col-md-12">
			<span class="count-numbers"><%=unreadCount%></span> 
			<span class="count-name">Unread</span>
		</div>
	</div>
</div>

<%--
<div class="card" style="background-color:MediumSpringGreen; height: 203px;">
  <div class="row">
  	<div class="mt-2 mb-1 ml-3 mr-1 col-sm-8">
  		<h2 style="color: white;">My Mails</h2>
  	</div>
  	<div class="col-sm-3 mt-1">
  		<svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="white" class="bi bi-envelope-fill" viewBox="0 0 16 16">
  <path d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555zM0 4.697v7.104l5.803-3.558L0 4.697zM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757zm3.436-.586L16 11.801V4.697l-5.803 3.546z"/>
</svg>
  	</div>
    
  </div>
  <div class="card-body">
    <h5 class="card-title text-white">Unread mails</h5>
  </div>
  <div class="row">
  	<div class="col-sm-9"></div>
  	<div class="col-sm-3">
  		<a href="#"  class="text-white">
			<%=unreadCount %>	
  		</a>
  	</div>
  </div>
</div>
--%>