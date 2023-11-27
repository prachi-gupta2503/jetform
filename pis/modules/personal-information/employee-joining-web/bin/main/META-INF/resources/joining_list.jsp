		
<%
if(employeePortletView.equals("employee")) {
%>
	<%@ include file="/jsp/employees_view.jsp"%>
<%
}else{
%>
	<%@include file="/jsp/employee_list_detail.jsp"%>	
<%
}
%>