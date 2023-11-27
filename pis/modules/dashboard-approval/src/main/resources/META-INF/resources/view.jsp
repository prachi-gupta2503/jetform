<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
  
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>

<div class="card" style="background-color:red; height: 203px">
  <div class="row">
  	<div class="mt-2 mb-1 ml-3 mr-1 col-sm-8">
  		<h2 style="color: white;">Approvals</h2>
  	</div>
  	<div class="col-sm-3 mt-1">
  		<svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="white" class="bi bi-clipboard-check" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
  <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
  <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
</svg>
  	</div>
    
  </div>
  <div class="card-body">
    <h5 class="card-title text-white">
    
    <%!private static final Log LOGGER = LogFactoryUtil.getLog("menu.jsp"); %>
    <%
    
    long employeeId=0;
    long pendingServiceRequest=0;
    try{
    	LOGGER.info(user.getEmailAddress());
    	Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
    	
    	LOGGER.info(employee);
    	if(employee!=null){
    	employeeId=employee.getEmployeeId();
    	pendingServiceRequest=ServiceRequestLocalServiceUtil.getServiceRequestByStatusAndOrganization(1, employee.getOrganizationId()).stream().count();
    	}
    	//out.println(employee.getOrganizationId());
    
    }catch(Exception e){
    	LOGGER.info(e.getMessage());
    }
    
 	 
    %>
    <%
    long pendingJoiningProcess=0;
//out.print("user "+user);
    boolean isApprover=user.getRoles().stream().anyMatch(r->r.getName().equalsIgnoreCase("PIS Approver - Regular"));
   if(isApprover==true){
    pendingJoiningProcess=JoiningProcessLocalServiceUtil.getJoiningProcesses(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream().filter(joiningProcess->joiningProcess.getProcessStatus()==1).count();
    //out.println("pendingJoiningProcess "+pendingJoiningProcess);
   }
    %>
   
    <h4 style="color: white;">
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
   </svg>
    
    <%= pendingJoiningProcess%> New Joining</h4>    
   <h4 style="color: white;">
   
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
</svg>
   <%= pendingServiceRequest %> My Requests</h4>
 </h5> 
  </div>
  <div class="row">
  	<div class="col-sm-9"></div>
  	<div class="col-sm-3">
  		<%--<a href="#"  class="text-white">view all</a> --%>
  	</div>
  </div>
</div>


