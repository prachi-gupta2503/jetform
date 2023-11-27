<%@page import="com.adjecti.pis.dto.RegistrationRequestDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.pis.service.RegistrationRequestLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<% boolean isApprover= RegistrationRequestLocalServiceUtil.isApprover(user.getUserId());
// List<RegistrationRequestDTO> registrationRequestList = RegistrationRequestLocalServiceUtil.getAllRegistrations(user);
//pageContext.setAttribute("requestList", registrationRequestList); 
if(isApprover){
%>
  	<jsp:include page="admin_view.jsp" flush="true" >
  	<jsp:param name="name" value="" />  
  	
  	</jsp:include>
  <%}else{%>
    <jsp:include page="reportView.jsp" flush="true" />
  <%}%>