<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationHistoryLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationHistory"%>
<%@ include file="/init.jsp"%>

<%

long id = ParamUtil.getLong(request, "id", 0);
List<OrganizationHistory> organizationHistories=OrganizationHistoryLocalServiceUtil.getByPreviousOrganizationId(id);

%>

<table class="table table-striped">
<thead>
    <tr>
      <th class="text-nowrap" scope="col">Previous Org Name</th>
      <th class="text-nowrap" scope="col">Prev parent org Name</th>
      <th class="text-nowrap" scope="col">Present Org Name</th>
      <th class="text-nowrap" scope="col">Present Parent Org Name</th>
      <th class="text-nowrap" scope="col">Create Date</th>
      <th class="text-nowrap" scope="col">Modified Date/Time</th>
    </tr>
  </thead>
  <tbody>
  <%for(OrganizationHistory organizationHistory:organizationHistories){ %>
  	<tr>
  	<td class="text-nowrap" ><%=organizationHistory.getPreviousOrganizationName() %></td>
  	<td class="text-nowrap" ><%=organizationHistory.getPreviousParentOrganizationName() %></td>
  	<td class="text-nowrap" ><%=organizationHistory.getPreviousOrganizationName() %></td>
  	<td class="text-nowrap" ><%=organizationHistory.getOrganizationName() %></td>
  	<td class="text-nowrap" ><%=organizationHistory.getCreateDate() %></td>
  	<td class="text-nowrap" ><%=organizationHistory.getModifiedDate() %></td>
  	
  	</tr>
  	<%} %>
  </tbody>

</table>