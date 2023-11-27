<%@page import="com.adjecti.pis.liferay.constants.MVCCommandNames"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="com.adjecti.mdm.liferay.util.OrganizationUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<portlet:resourceURL id="<%=MVCCommandNames.SUB_ORGANIZATIONS %>" var="getOrganizationURL" />
<portlet:actionURL name="<%=MVCCommandNames.EMPLOYEE_SEARCH %>"  var="searchEmployeeURL" >
	<portlet:param name="jspPage" value="/employee/employee_list.jsp"/>
</portlet:actionURL>
	
<% List<Organization> units=OrganizationUtils.getRecursiveSubOrganizationsByUser(user);
   System.out.println(units.size());
   List<Grade> grades=MDMUtils.getAllGrades();
   List<Trade> trades=MDMUtils.getAllTrades();
   List<Designation> designations=MDMUtils.getAllDesignations();
   List<DesignationGroup> groups=MDMUtils.getAllDesignationGroups();
   /*   List<Organization> sections=new ArrayList<>();
   for(Organization organization:units){
	   Organization org=OrganizationUtils.getOrgnizationByType(organization.getOrganizationId(), "Section");
	    if(org!=null)	   {
		   sections.add(organization);
	   } 
   }  */
   
%>

<aui:form name="employeeSearchForm" action="${searchEmployeeURL}">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label">Unit</label>
				<select class="form-control" id="unit" name="<portlet:namespace />unitId">
					<option value="0">All Units</option>
					<% 
						for(Organization unit:units) {
					%>
						<option value="<%=unit.getOrganizationId() %>"><%=unit.getName() %></option>
					<%
						} 
					%>
				</select>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label">Section</label>
				<select class="form-control" id="section" name="<portlet:namespace />selectionId">
					<option value="0">All Sections</option>
					<%--  <% for(Organization section:sections) {%>
					<option value="<%=section.getOrganizationId() %>"><%=section.getName() %></option>
					<%} %>  --%>
				</select>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group required" style="margin-top: 2rem;">
				<div class="form-group  form-check">
					<input type="checkbox" class="form-check-input" id="onDeputation" name="<portlet:namespace />deputationId"> 
					<label class="form-check-label">On Deputation</label>
				</div>
			</div>
		</div>							
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label" >Group</label>
				<select class="form-control" id="group" name="<portlet:namespace />groupId">
					<option value="0">All Groups</option>
					<% 
						for(DesignationGroup group:groups) {
					%>
						<option value="<%=group.getDesignationGroupId() %>"><%=group.getName() %></option>
					<%
						} 
					%>
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label" >Grade</label>
				<select class="form-control" id="grade" name="<portlet:namespace />gradeId">
					<option value="0">All Grades</option>
					
				 	<% 
				 		for(Grade grade:grades) {
				 	%>
						<option value="<%=grade.getGradeId() %>"><%=grade.getName() %></option>
					<%
						} 
					%> 
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group required" style="margin-top: 2rem;">
					<div class="form-group  form-check">
						<input type="checkbox" class="form-check-input" id="retired" name="<portlet:namespace />retiredId"> 
							<label class="form-check-label">Retired</label>
					</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label">Trade</label>
				<select class="form-control" id="trade" name="<portlet:namespace />tradeId">
					<option value="0">All Trades</option>
					
					<% 
						for(Trade trade:trades) {
					%>
						<option value="<%=trade.getTradeId() %>"><%=trade.getName() %></option>
					<%
						}
					%>	
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group required">
				<label class="control-label" >Designation</label>
				<select class="form-control" id="designation" name="<portlet:namespace />designationId">
					<option value="0">All Designation</option>
					
					<% 
						for(Designation designation:designations) {
					%>
						<option value="<%=designation.getDesignationId() %>"><%=designation.getName_En() %></option>
					<%
						}
					%>
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group required" style="margin-top: 2rem;">
				<div class="form-group  form-check">
					<input type="checkbox" class="form-check-input" id="onProbation" name="<portlet:namespace />probationId"> 
					<label class="form-check-label">On Probation</label>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" id="<portlet:namespace/>startSearch">Search</button>
		<button type="button" class="btn btn-secondary" data-dismiss="modal" id="<portlet:namespace/>cancelSearch">Cancel</button>
	</div>
</aui:form>
		
<script>
				
$('#unit').on('change', function() {
    var unitId = $(this).find('option:selected').val();
    jQuery.ajax({
        type: "POST",
        url: "<%=getOrganizationURL%>",
        /* url : "<portlet:resourceURL />", */

        data: ({
            "<portlet:namespace/>unitId": unitId,

        }),
        success: function(data) {
            $("#section").empty();
            $('#section').append('<option value="0">' + "All Sections" + '</option>');
            $.each(data, function(key, value) {
                $('#section').append('<option value="' + value.organizationId + '">' + value.name + '</option>');
            });

        },
        async: false,
    });
});

</script>
				
				