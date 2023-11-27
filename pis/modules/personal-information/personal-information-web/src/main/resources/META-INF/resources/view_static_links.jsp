<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.adjecti.pis.liferay.model.ServiceRequest"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeSeparationRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePromotionRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDeputationRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTransferRequest"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<%--
<portlet:renderURL var="createUserRenderURL">
	<portlet:param name="mvcPath" value="/create_user.jsp" />
</portlet:renderURL>
--%>


	<div class="row">
		<div class="col-md-12">
			<div id="ajaxGetUserServletResponse"></div>
			
			<div class="search-container" style="margin-top:50px;">
				<div class="input-group text-right">
			
					<input type="text" class="form-control" id="txt-search"
						placeholder="Search in option">
					<div class="input-group-append">
						<button class="btn btn-secondary" type="button">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="filter-records" class="row" style="text-align: center">
		<%--  Place holder for links--%>
		No options avaliable.
	</div>
	<%--<a href="<%=createUserRenderURL.toString()%>">Create User</a>  --%>


<portlet:renderURL var="employeeListRenderURL">
	<portlet:param name="mvcPath" value="/employee/list/employee_list.jsp" />
</portlet:renderURL>

<%--<portlet:renderURL var="employeeListRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_LIST%>"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_DETAIL_VIEW%>"/>
</portlet:renderURL>
 --%>
<portlet:renderURL var="employeeAddressRenderURL">
	<portlet:param name="mvcPath" value="/employee/employeeAddressForm.jsp" />
	<portlet:param name="employeeId" value="301" />
</portlet:renderURL>

<portlet:renderURL var="peopleListRenderURL">
	<portlet:param name="mvcPath" value="/employee/people_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeJoiningRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/employee_joining_process.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeTransferRenderURL">
	<portlet:param name="mvcPath" value="/employee/transferProcessList.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeDeputationRenderURL">
	<portlet:param name="mvcPath" value="/employee/deputationProcess.jsp" />
</portlet:renderURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeInfoRenderURL">
	<portlet:param name="mvcPath" value="/employee/employee_profile.jsp" />
	<portlet:param name="employeeId" value="301" />
</portlet:renderURL>

<script>

$(document).ready(function(){
	//console.log("$(document).ready(function()");
	var mdmEntityList =[
		{"name":"Employees","icon":"<i class='fas fa-id-card fa-3x'></i>","description":"Add or manage Employees","link":"<%=employeeListRenderURL.toString()%>"}, 
		{"name":"Bulk Onboarding","icon":"<i class='fas fa-users-cog fa-3x'></i>","description":"Manage bulk onboarding of large number of employees.","link":"/group/comnet2/pis/bulk-onboarding"},
		{"name":"New Joining","icon":"<i class='fas fa-user-edit fa-3x'></i>","description":"Add or manage new employee joining","link":"/group/comnet2/pis/joining"},
		{"name":"My Requests","icon":"<i class='fas fa-random fa-3x'></i>","description":"Raising requests for updating profile information","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=PISFormConstant.MYREQUESTFORM%>"},
		<%--{"name":"Employee Address","icon":"<i class='fas fa-random fa-3x'></i>","description":"Raising requests for updating employee address","link":"<%=employeeAddressRenderURL.toString()%>"},
		{"name":"Transfers","icon":"<i class='fas fa-random fa-3x'></i>","description":"Add or manage transfer of employees","link":"<%=employeeTransferRenderURL.toString()%>"},
		{"name":"Deputations","icon":"<i class='fas fa-recycle fa-3x'></i>","description":"Add or manage deputation of employees","link":"<%=employeeDeputationRenderURL.toString()%>"},
		{"name":"Promotions","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeePromotionRequestForm.class.getName()%>"},
		{"name":"Separations","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeSeparationRequestForm.class.getName()%>"},
		
		{"name":"Peoples","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage people","link":"<%=peopleListRenderURL.toString()%>"},
		{"name":"Employee","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeForm.class.getName()%>"},
		
		{"name":"Peoples","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage people","link":"<%=peopleListRenderURL.toString()%>"},
		{"name":"Employee","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeForm.class.getName()%>"},
		{"name":"Employee Information","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"View employee profile.","link":"<%=employeeInfoRenderURL%>"},
		{"name":"Employee Transfer","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeTransferRequestForm.class.getName()%>"},
		{"name":"Employee Deputation","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeDeputationRequestForm.class.getName()%>"},
		{"name":"Employee Promotion","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeePromotionRequestForm.class.getName()%>"},
		{"name":"Employee Separation","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeSeparationRequestForm.class.getName()%>"}--%>
		];
	
	/*{"name":"Bulk Onboarding Page 1","icon":"<i class='fas fa-users-cog fa-3x'></i>","description":"Manage bulk onboarding of large number of employees.","link":"/group/comnet2/pis/bulk-onboarding-1?formClass=com.adjecti.pis.liferay.model.BulkOnboarding"},
	*/
	
	//renderMdmEntityCta(mdmEntityList);
	
	let output = '';
	$.each(mdmEntityList, function(key, val){
		output+= htmlData(val);
		
	});
	
	$('#filter-records').html(output);
		  
	$('#txt-search').keyup(function(){
		
        let searchField = $(this).val();
        let regex = new RegExp(searchField, "i");
        let output1 = '';
        let count = 1;
		if(searchField === '')  {
			
			$.each(mdmEntityList, function(key, val){
				output1 += htmlData(val);
			});
			$('#filter-records').html(output1);
			return;
		}

<%-- var mdmData1 = '<%= participantJsonList %>'; --%>
			 
		output1 = '';
		$.each(mdmEntityList, function(key, val){
				  
			if (((val.name.search(regex) != -1))) {
				output1 += htmlData(val);
			}
		});
		$('#filter-records').html(output1);
    }); 
});
	
function htmlData(val){
	var mdmOutput="";
	mdmOutput +="<div class='c-m'>";
	mdmOutput +="	<div class='col'>";
	mdmOutput +="		<a href='"+val.link+"' class='mdm-anchor'>";
	mdmOutput +="			<p class='text-primary'>";
	mdmOutput +=val.icon;
	mdmOutput +="			</p>";
	mdmOutput +="			<h4>"+val.name+"</h4>";
	mdmOutput +="			<p>"+val.description+"</p>";
	mdmOutput +="		</a>";
	mdmOutput +="	</div>";
	mdmOutput +="</div>";
	return mdmOutput;
}

function renderMdmEntityCta(mdmList){
	//console.log("before renderMdmEntityCta");
	//console.log(mdmList);
	
	var source = $('#mdm-entity-cta-template').html();
	
	var template = Handlebars.compile(source);
	console.log("after Handlebars.compile(source)" + template);
	var resultHtml = template(mdmList);
	console.log("resultHtml"+resultHtml);
	
	$("#filter-records").html(resultHtml);
}

</script>
<%--
<script type="text/x-handlebars-template" id="mdm-entity-cta-template">
	{{#each item}}
		<div class="c-m">
			<div class="col">
				<a href="#" class="mdm-anchor">
					<p class="text-primary">
						{{icon}}
					</p>
					<h4>{{name}}</h4>
					<p>{{description}}</p>
				</a>
			</div>
		</div>
	{{/each}}
</script>
 --%>