
<%@page import="com.adjecti.mdm.liferay.form.constants.MDMFormConstant"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Dictionary"%>
<%@page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.ServiceRequestType"%>
<%@page import="com.adjecti.mdm.liferay.model.JoiningMode"%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationLevel"%>
<%@page import="com.liferay.portal.kernel.model.Address"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.District"%>
<%@page import="com.adjecti.mdm.liferay.model.Cadre"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkStation"%>
<%@page import="com.adjecti.mdm.liferay.model.VerificationType"%>
<%@page import="com.adjecti.mdm.liferay.model.State"%>
<%@page import="com.adjecti.mdm.liferay.model.SubjectOfQualification"%>
<%@page import="com.adjecti.mdm.liferay.model.UnitType"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationMode"%>
<%@page import="com.adjecti.mdm.liferay.model.PostOrganization"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>
<%-- <%@page import="com.adjecti.mdm.liferay.model.WorkAreaMajor"%> --%>
<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkAreaMinor"%>
<%@page import="com.adjecti.mdm.liferay.model.PostReporting"%>
<%@page import="com.adjecti.mdm.liferay.model.PostDelegation"%>
<%@page import="com.adjecti.mdm.liferay.model.Occupation"%>
<%@page import="com.adjecti.mdm.liferay.model.FamilyRelation"%>
<%@page import="com.adjecti.mdm.liferay.model.Course"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.adjecti.mdm.liferay.model.GradeMode"%>
<%@page import="com.adjecti.mdm.liferay.model.Specialization"%>
<%--@page import="com.adjecti.mdm.liferay.util.FormClassLoaderUtils"--%>
<%@page import="com.adjecti.mdm.liferay.model.QualificationGrade"%>
<%@page import="com.adjecti.mdm.liferay.model.Qualification"%>
<%@page import="com.adjecti.mdm.liferay.model.Religion"%>
<%@page import="com.adjecti.mdm.liferay.model.PhType"%>
<%@page import="com.adjecti.mdm.liferay.model.MaritalStatus"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationClass"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGrade"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.mdm.liferay.model.BloodGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.BenefitScheme"%>
<%@page import="com.adjecti.mdm.liferay.model.AccomodationType"%>
<%@page import="com.adjecti.mdm.liferay.model.Appellation"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.model.CasteCategory"%>
<%@page import="com.adjecti.mdm.liferay.model.Gender"%>
<%@page import="com.adjecti.mdm.liferay.model.SubjectOfTraining"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>

<style>
<!--
.has-search .form-control {
    padding-left: 2.375rem;
}

.has-search .form-control-feedback {
    position: absolute;
    z-index: 2;
    display: block;
    width: 2.375rem;
    height: 2.375rem;
    line-height: 2.375rem;
    text-align: center;
    pointer-events: none;
    color: #aaa;
}
//-->
</style>

<portlet:renderURL var="postListURL">
	<portlet:param name="mvcPath" value="/postList.jsp" />
</portlet:renderURL>
<%--<portlet:renderURL var="orgListURL">
	<portlet:param name="mvcPath" value="/organization/organization_list.jsp" />
</portlet:renderURL> --%>

<portlet:renderURL var="importSectionRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp"/>
	<portlet:param name="formClass" value="<%=MDMFormConstant.SECTIONIMPORTFORM%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<portlet:renderURL var="accomodationTypeListURL">
	<portlet:param name="mvcPath" value="/accomodation_type_list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="mdmListURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
</portlet:renderURL>
<portlet:renderURL var="organizationListURL">
	<portlet:param name="mvcPath" value="/organization/organization_detail_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="formListURL">
	<%--<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" /> --%>
	<portlet:param name="mvcPath" value="/master_list.jsp" />
	<portlet:param name="quickMenu" value="/master_menu.jsp" />
</portlet:renderURL>
<%-- <portlet:renderURL var="countryFormListURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
	<portlet:param name="mvcPath" value="/master_list_country.jsp" />
	<portlet:param name="quickMenu" value="/master_menu.jsp" />
</portlet:renderURL> --%>

<portlet:renderURL var="importSectionRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=MDMFormConstant.SECTIONIMPORTFORM%>" />
</portlet:renderURL>

<%--portlet:renderURL var="postListRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
	<portlet:param name="formClass" value="<%=PostForm.class.getName() %>" />
	<portlet:param name="dialogMode" value="false" />
</portlet:renderURL --%>
<%--portlet:renderURL var="postListRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
	<portlet:param name="formClass" value="<%=PostForm.class.getName() %>" />
	<portlet:param name="dialogMode" value="false" />
</portlet:renderURL --%>
<div class="container">

	<div class="row">
		<div class="col-md-12">
			<div id="ajaxGetUserServletResponse"></div>
			<div class="search-container" style="margin-top:50px;">
				<div class="form-group has-search">
					<span class="fa fa-search form-control-feedback"></span>
					<input type="text" class="form-control" id="txt-search"
						placeholder="Search an option">
				</div>
			</div>
		</div>
	</div>
	
	<div id="filter-records" class="row" style="text-align: center">
		<%--  Place holder for links--%>
		No options avaliable.
	</div>
</div>
<script>
$(document).ready(function(){
	//console.log("$(document).ready(function()");
	var menuItems =[
		{"name":"Accomodation Type","icon":"fas fa-home","description":"Add or manage Accomodation Types","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.ACCOMODATIONTYPEFORM%>"},
		{"name":"Appellation","icon":"fas fa-user-plus","description":"Add or manage Appellations","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.APPELLATIONFORM%>"},
		{"name":"Benefit Scheme","icon":"fas fa-shopping-bag fa-3x' style='color:yellow;'></i>","description":"Add or manage Benefit Schemes","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.BENEFITSCHEMEFORM%>"},
		{"name":"Blood Group","icon":"fas fa-heart fa-3x' style='color:red;'></i>","description":"Add or manage Blood Groups","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.BLOODGROUPFORM%>"},
		{"name":"Caste Category","icon":"fas fa-boxes","description":"Add or manage cast categories","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.CASTECATEGORYFORM%>"},

		 {"name":"Country","icon":"fas fa-flag","description":"List of countries","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.COUNTRYFORM%>"},
	 
		{"name":"District","icon":"fas fa-city","description":"Add or manage districts","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.DISTRICTFORM%>"},
		{"name":"Family Relation","icon":"fas fa-users","description":"Add or manage family relation","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.FAMILYRELATIONFORM%>"},
		{"name":"Gender","icon":"fas fa-venus-mars","description":"Add or manage genders","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.GENDERFORM%>"},		
		{"name":"Marital Status","icon":"fas fa-comments","description":"Add or manage Marital Status","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.MARITALSTATUSFORM%>"},
		{"name":"Occupation","icon":"fas fa-tools","description":"Add or manage occupation types","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.OCCUPATIONFORM%>"},
		{"name":"Physical Handicap Type","icon":"fas fa-wheelchair","description":"Add or manage Physical Handicap Types","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.PHTYPEFORM%>"},
		{"name":"Grade","icon":"fas fa-th-large","description":"Add or manage employee grades","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.GRADEFORM%>"}, 
		{"name":"Grade Mode","icon":"fas fa-chess-rook","description":"Add or manage employee grade modes","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.GRADEMODEFORM%>"},
		{"name":"Joining Mode","icon":"fas fa-handshake","description":"Add or manage employee joining modes","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.JOININGMODEFORM%>"},
		
		{"name":"Trade","icon":"fas fa-toolbox","description":"Add or manage employee trades","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.TRADEFORM%>"},
		{"name":"Cadre","icon":"fas fa-user-shield","description":"Add or manage employee cadre","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.CADREFORM%>"},
		{"name":"Designation Group","icon":"fas fa-user-friends","description":"Add or manage Designation Groups","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.DESIGNATIONGROUPFORM%>"},
<%--
		{"name":"Designation Class","icon":"fas fa-star","description":"Add or manage Designation Class","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=DesignationClass.class.getName()%>"},
--%>
		<%-- {"name":"Designation Mode","icon":"fas fa-angle-double-up","description":"Add or manage Designation Modes","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=DesignationModeForm.class.getName()%>"},
		 --%>
		{"name":"Designation","icon":"fas fa-crown","description":"Add or manage Designation","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.DESIGNATIONFORM%>"},
		{"name":"Qualification","icon":"fas fa-book-reader","description":"Add or manage Qualification","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.QUALIFICATIONFORM%>"},
		{"name":"Qualification Grade","icon":"fas fa-user-graduate","description":"Add or manage Qualification Grades","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.QUALIFICATIONGRADEFORM%>"},
		{"name":"Qualification Level","icon":"fas fa-user-graduate","description":"Add or manage Qualification Level","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.QUALIFICATIONLEVELFORM%>"},
		
		{"name":"Religion","icon":"fas fa-praying-hands","description":"Add or manage Religion","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.RELIGIONFORM%>"},
		<%-- {"name":"Organization","icon":"fas fa-city","description":"Add or manage Organization","link":"<%=organizationListURL.toString()%>&<portlet:namespace/>formClass=<%=OrganizationForm.class.getName()%>"},
		 
		 

{"name":"Post","icon":"fas fa-user-shield","description":"Add or manage employee posts","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=PostForm.class.getName()%>"},
		{"name":"Post Delegation","icon":"fas fa-people-carry","description":"Add or manage employee posts","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=PostDelegation.class.getName()%>"},
		{"name":"Post Reporting","icon":"fas fa-sitemap","description":"Add or manage employee posts","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=PostReporting.class.getName()%>"},
		--%>
		{"name":"Service Request Type","icon":"fa fa-rocket","description":"Add or manage service request type","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.SERVICEREQUESTTYPEFORM%>"},
		
		{"name":"Specialization","icon":"fas fa-medal","description":"Add or manage Specialization","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.SPECIALIZATIONFORM%>"},
		{"name":"State","icon":"fas fa-map","description":"Add or manage states","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.STATEFORM%>"},
		{"name":"Subject Of Training","icon":"fas fa-map","description":"Add or manage Subject Of Training","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.SUBJECTOFTRAININGFORM%>"},
		{"name":"Subject Of Qualification","icon":"fas fa-map","description":"Add or manage Subject Of Qualification","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.SUBJECTOFQUALIFICATIONFORM%>"},
		
		{"name":"Unit Type","icon":"fas fa-map","description":"Add or manage Unit Type","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.UNITTYPEFORM%>"},
		 	
		<%-- 	{"name":"Unit Form","icon":"fas fa-map","description":"Add or manage Subject Of Training","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=UnitForm.class.getName()%>"},
	 	
		--%>
		{"name":"Training Course","icon":"fas fa-book","description":"Add or manage education courses","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.TRAININGCOURCEFORM%>"},
		{"name":"Verification Type","icon":"fas fa-check-double","description":"Add or manage verification types","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.VARIFICATIONTYPEFORM%>"},
		
		{"name":"Work Area","icon":"fas fa-tools","description":"Add or manage work areas","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=MDMFormConstant.WORKAREAFORM%>"},
		
		<%--{"name":"Work Area","icon":"fas fa-tools","description":"Add or manage work areas","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=WorkAreaMajorForm.class.getName()%>"},
		
		{"name":"Work Area Minor","icon":"fas fa-tools","description":"Add or manage work areas","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=WorkAreaMinorForm.class.getName()%>"},
		
				{"name":"Workstation","icon":"fas fa-desktop","description":"Add or manage work station","link":"<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=WorkStationForm.class.getName()%>"},
		{"name":"Import Section","icon":"fas fa-file-import","description":"Import sections from excel.","link":"<%=importSectionRenderURL.toString()%>"},--%>
		];
	
	$('#txt-search').keyup(function(){
		
        let searchField = $(this).val();
        let regex = new RegExp(searchField, "i");
		if(searchField === '')  {
			renderMenu(menuItems);
			return;
		}

		var menuFilterList=[]; 
		var ctr=0;
		$.each(menuItems, function(index, item){
				  
			if (((item.name.search(regex) != -1))) {
				menuFilterList[ctr++]=item;
			}
		});
		renderMenu(menuFilterList);
    });
	
	renderMenu(menuItems);
<%-- <%
	int reloadedPage=ParamUtil.getInteger(request, "reloaded", 0);	
	if(reloadedPage==0){
%>
		reloadPage();
<%
	}
%> --%>
});

function renderMenu(menuRenderList){

	var source = $('#menu-cta-template').html();
	var template = Handlebars.compile(source);
	var resultHtml = template(menuRenderList);

	$("#filter-records").html(resultHtml);
}
/* function reloadPage(){
	var loc=window.location.href;
	if(loc.indexOf("<portlet:namespace/>reloaded=1")>0){
		return;
	}
	if(loc.indexOf("&")>0){
		window.location.href=window.location.href+"&<portlet:namespace/>reloaded=1";
	}else{
		window.location.href=window.location.href+"?<portlet:namespace/>reloaded=1";
	}
} */
</script>

<script type="text/x-handlebars-template" id="menu-cta-template">
	{{#each []}}
		<div class="c-m">
			<div class="col">
			
				<a href="{{link}}" class="mdm-anchor">
					<p class="text-primary">
						<i class='{{icon}} fa-3x'></i>
						
					</p>
					<h4>{{name}}</h4>
					<p>{{description}}</p>
				</a>
			</div>
		</div>
	{{/each}}
</script>