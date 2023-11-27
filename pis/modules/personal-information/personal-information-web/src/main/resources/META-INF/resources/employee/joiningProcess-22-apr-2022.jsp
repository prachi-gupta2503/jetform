<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.model.Contact"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.joiningProcess_jsp");%>
<%
	response.setHeader("Cache-Control", "max-age=0");
	Map<String, String> tabPages=new HashMap<String, String>();
	tabPages.put("Personal", "/employee/joining/employee_personal_details_add.jsp");
	tabPages.put("Address", "/employee/joining/employee_address_detail_add.jsp");
	tabPages.put("Education", "/employee/joining/employee_qualification_add.jsp");

	long employeeId = ParamUtil.getLong(request, "employeeId", 0);
	int groupIndex = ParamUtil.getInteger(request, "groupIndex",0);
%>
<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
		<div class="col-md-11 text-center p-0 mt-3 mb-2">
			<div class="card px-0 pt-4 pb-0 mt-3 mb-3" style="text-align: center;">
				<h2>
					<strong>New Joining</strong>
				</h2>
				<p>Enter all the mandatory information before going to next step!</p>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div id="msform">
							<ul id="progressbar">
								<%
									int liIndex = 0;
									for (String tab : tabPages.keySet()) {
										String liClass = "";
										if (liIndex <=groupIndex) {
											liClass = "class=\"active\"";
										}
								%>
								<li <%=liClass%> id="<%="tab"+liIndex%>"><strong><%=tab%></strong></li>
								<%
										liIndex++;
									}
								%>
								<li id="confirm"><strong>Finish</strong></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div class="card form-card" style="height: 400px; padding:30px;">
<%
						int pageIndex=0;
						for(String tabPage:tabPages.values()){
								if(pageIndex!=groupIndex){
									continue;
								}
								pageIndex++;
%>
							<liferay-util:include page="<%=tabPage%>" servletContext="<%=application%>">
							</liferay-util:include>
<%
						}
%>												
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group-autofit">
										<div class="form-group-item">
											<div class="btn-group">
												<div class="btn-group-item">
						<%
							if (groupIndex > 0) {
						%>
													<input type="button" name="previous" class="btn btn-secondary previous action-button action-button-prev mr-2" value="Previous" index="<%=groupIndex%>">
						<%
							}
						%>
													<input type="button" name="next" class="btn btn-primary next action-button action-button-next" value="Next Step" index="<%=groupIndex%>">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<portlet:renderURL var="joiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/employee/joining/joiningProcess.jsp" />
</portlet:renderURL>
<%
if(employeeId>0){	
%>
<portlet:renderURL var="joiningProcessRenderUrl">
	<portlet:param name="employeeId" value="<%=employeeId %>"/>
</portlet:renderURL>
<%
}
%>
<script>

$(document).ready(function() {
	
	alert("Group Index : "+<%=groupIndex%>);
	$(".action-button-next").click(function(){
		//validate the form -- function should be defined individual form page
		//if valid call submitForm -- function should be defined individual form page
		//if submit is successfull them goto next line.
		window.location.href='<%=joiningProcessRenderUrl.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex+1)%>';
	});
	try{
		$(".action-button-prev").click(function(){	
			window.location.href='<%=joiningProcessRenderUrl.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex-1)%>';
		});
	}catch(e){}
	
});
</script>
