<%@page import="com.adjecti.mdm.liferay.service.AccomodationTypeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.AccomodationType"%>
<%@page import="com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.District"%>
<%@page import="com.adjecti.mdm.liferay.service.StateLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.State"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.service.AddressLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="/init.jsp"%>
<%-- script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>--%>
<script>
	//var $=jQuery.noConflict();
</script>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.info_card_jsp");%>

<%
	response.setHeader("Cache-Control", "max-age=0");

	//String formClass = ParamUtil.getString(request, "formClass");
	String employeeId = ParamUtil.getString(request, "formClassPK");
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);

	List<EmployeeAddress> employeeAddresses=new ArrayList<EmployeeAddress>();
	try{
		employeeAddresses=EmployeeAddressLocalServiceUtil.getEmployeeAddressByEmpId(Long.parseLong(employeeId));
	}catch(Exception e){}
	
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<%
	if (!dialogMode) {
%>
<div class="card info-card mb-2 mt-2">
	<div class="card-header header-primary">
		<div class="row">
			<div class="col-md-12">
				<h5>
					<%=form.getTitle()%>
				</h5>
			</div>
			<%--<div class="col-md-6 text-right" >
				<i style="color: blue;" class="fa fa-edit fa-action fa-actions-top admin-role"></i> <i style="color: green;" class="fa fa-share fa-action fa-actions-top admin-role"></i>
				<i style="color: red;" class="fa fa-times fa-action fa-actions-top admin-role"></i>
				<i style="color: blue;" class="fa fa-hand-paper-o fa-action fa-actions-top user-role"></i>
				<i style="color: #ff8306;" class="fa fa-check fa-action fa-actions-top approver-role"></i>
			</div> --%>
		</div>
	</div>
	
	<div class="card-body">
		<%
			}
		%>
		<div class="container">
			<%
				for (EmployeeAddress empAdd : employeeAddresses) {
					Address address=AddressLocalServiceUtil.getAddress(empAdd.getAddressId());
					AccomodationType addressType=null;
					
					if(address.getAccomodationTypeId()>0){
						addressType=AccomodationTypeLocalServiceUtil.getAccomodationType(address.getAccomodationTypeId());
					}
					
					District district=null;
					if(address.getDistrictId()>0){
						district=DistrictLocalServiceUtil.getDistrict(address.getDistrictId());
					}
					
					State state=null;
					if(address.getStateId()>0){
						state=StateLocalServiceUtil.getState(address.getStateId());
					}
					
			%>
			<div class="row">
				<div class="col-md-12">
					<p style="text-decoration: underline;"><strong><%=(addressType!=null?addressType.getName():"")%></strong></p>
					<p>
						<%=address.getAddressLine1()%>,<br/>
						<%=address.getAddressLine2()%>,<br/>
						<%=address.getAddressLine3()%>,<br/>
						<%=address.getCity()%>,<%=district!=null?district.getName():""%><br/>
						<%=state!=null?state.getName():""%>,<%=address.getPinCode()%>
					</p>
				</div>
			</div>
			<%
				}
			%>
		</div>
<%
	if (!dialogMode) {
%>		
	</div>
</div>
<%
	}
%>
<%--
	<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
		<%@ include file="/components/form/hidden-elements.jsp"%>
	</aui:form>
 --%>

