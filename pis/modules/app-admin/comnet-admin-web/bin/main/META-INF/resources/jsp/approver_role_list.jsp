<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ include file="/jsp/nav_tabs.jsp" %>
<table class="table" id="applicationUserTable" class="display">
  <thead>
    <tr>
      <th scope="col">Personal No.</th>
      <th scope="col">Section</th>
      <th scope="col">Unit</th>
      <th scope="col">Name</th>
    </tr>
  </thead>
  <tbody> 
	<c:forEach items="${employees}" var="employee">	
		<th>${employee.personalNo}</th>
		<td>Unit</td>
		<td>Section</td>
      	<td>${employee.fullName}</td>
	</c:forEach>
  </tbody>
</table>


