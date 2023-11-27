<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@ include file="/init.jsp"%>
<%
	String formClass=ParamUtil.getString(request, "formClass");

	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	//List<Organization> organizations=OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Designation> designations=DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Grade> grades=GradeLocalServiceUtil.getGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Trade> trades=TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<aui:form name="employeeSearchForm">
	<div class="row">
		<div class="col">
			<aui:input type="hidden" name="objectClass" value="<%=formClass%>"/>
			
			<aui:select label="Unit" class="form-control" name="organizationId">
				<aui:option value=''>Select Unit</aui:option>
<%
				for(Organization o:organizations){
%>	
				<aui:option value='<%=o.getOrganizationId()%>'><%=o.getName()%></aui:option>
<%
				}
%>			
			</aui:select>
		</div>
		<div class="col">
			<aui:select label="Designation" class="form-control" name="designationId">
				<aui:option value=''>Select Designation</aui:option>
<%
				for(Designation d:designations){
%>	
				<aui:option value='<%=d.getDesignationId()%>'><%=d.getName_En()%></aui:option>
<%
				}
%>	
			</aui:select>
		</div>
		<div class="col">

			<aui:select label="Grade" class="form-control" name="gradeId">
				<aui:option value=''>Select Grade</aui:option>
<%
				for(Grade g:grades){
%>	
				<aui:option value='<%=g.getGradeId()%>'><%=g.getName()%></aui:option>
<%
				}
%>
			</aui:select>
		</div>
		<div class="col">
			<aui:select label="Trade" class="form-control" name="tradeId">
				<aui:option value=''>Select Trade</aui:option>
<%
				for(Trade t:trades){
%>	
				<aui:option value='<%=t.getTradeId()%>'><%=t.getName()%></aui:option>
<%
				}
%>
			</aui:select>
		</div>
		<%--div class="col">
			<span class="aui-search-bar"> <aui:input
					inlineField="<%=true%>" label="Keyword" id="keywords"
					name="keywords" size="30" title="search-entries" type="text"
					placeholder="Search Keyword" />
			</span>
		</div--%>
		<div class="col mt-4">
			<button type="button" id="<portlet:namespace/>doSearchBtn"
				class="form-control bg-primary text-white"><i class="fas fa-search mr-2"></i>Search</button>
			<button type="reset" id="<portlet:namespace/>clearSearchBtn"
				class="form-control bg-primary text-white"
				 style="display:none;"><i class="fas fa-times mr-2"></i>Clear</button>

		</div>
	</div>
</aui:form>
<script type="text/javascript">
<!--
/***The related script for search is defined in employee_list.jsp***/
//-->
</script>
