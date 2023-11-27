<%@page import="com.adjecti.mdm.liferay.model.OrganizationType"%>
<%@page import="com.adjecti.mdm.liferay.model.PostOrganization"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
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
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>

<portlet:renderURL var="postListURL">
	<portlet:param name="mvcPath" value="/postList.jsp" />
</portlet:renderURL>

<div class="container">

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
</div>
<script>
$(document).ready(function(){
	//console.log("$(document).ready(function()");
	var mdmEntityList =[
		{"name":"Accomodation Type","icon":"<i class='fas fa-home fa-3x'></i>","description":"Add or manage Accomodation Types","link":"/group/comnet2/mdm/form?formClass=<%=AccomodationType.class.getName()%>"},
		{"name":"Appellation","icon":"<i class='fas fa-user-plus fa-3x'></i>","description":"Add or manage Appellations","link":"/group/comnet2/mdm/form?formClass=<%=Appellation.class.getName()%>"},
		{"name":"Benefit Scheme","icon":"<i class='fas fa-shopping-bag fa-3x' style='color:yellow;'></i>","description":"Add or manage Benefit Schemes","link":"/group/comnet2/mdm/form?formClass=<%=BenefitScheme.class.getName()%>"},
		{"name":"BooldGroup","icon":"<i class='fas fa-heart fa-3x' style='color:red;'></i>","description":"Add or manage Blood Groups","link":"/group/comnet2/mdm/form?formClass=<%=BloodGroup.class.getName()%>"},
		{"name":"Caste Category","icon":"<i class='fas fa-boxes fa-3x'></i>","description":"Add or manage cast categories","link":"/group/comnet2/mdm/form?formClass=<%=CasteCategory.class.getName()%>"},
		{"name":"Course","icon":"<i class='fas fa-book fa-3x'></i>","description":"Add or manage education courses","link":"/group/comnet2/mdm/form?formClass=<%=Course.class.getName()%>"},
		{"name":"Family Relation","icon":"<i class='fas fa-people-arrows fa-3x'></i>","description":"Add or manage family relation","link":"/group/comnet2/mdm/form?formClass=<%=FamilyRelation.class.getName()%>"},
		{"name":"Gender","icon":"<i class='fas fa-venus-mars fa-3x'></i>","description":"Add or manage genders","link":"/group/comnet2/mdm/form?formClass=<%=Gender.class.getName()%>"},		
		{"name":"Marital Status","icon":"<i class='fas fa-comments fa-3x'></i>","description":"Add or manage Marital Status","link":"/group/comnet2/mdm/form?formClass=<%=MaritalStatus.class.getName()%>"},
		{"name":"Occupation","icon":"<i class='fas fa-tools fa-3x'></i>","description":"Add or manage occupation types","link":"/group/comnet2/mdm/form?formClass=<%=Occupation.class.getName()%>"},
		{"name":"Physical Handicap Type","icon":"<i class='fas fa-wheelchair fa-3x'></i>","description":"Add or manage Physical Handicap Types","link":"/group/comnet2/mdm/form?formClass=<%=PhType.class.getName()%>"},
		{"name":"Grade","icon":"<i class='fas fa-th-large fa-3x'></i>","description":"Add or manage employee grades","link":"/group/comnet2/mdm/form?formClass=<%=Grade.class.getName()%>"}, 
		{"name":"Grade Mode","icon":"<i class='fas fa-chess-rook fa-3x'></i>","description":"Add or manage employee grade modes","link":"/group/comnet2/mdm/form?formClass=<%=GradeMode.class.getName()%>"},
		{"name":"Trade","icon":"<i class='fas fa-toolbox fa-3x'></i>","description":"Add or manage employee trades","link":"/group/comnet2/mdm/form?formClass=<%=Trade.class.getName()%>"}, 
		{"name":"Designation Group","icon":"<i class='fas fa-user-friends fa-3x'></i>","description":"Add or manage Designation Groups","link":"/group/comnet2/mdm/form?formClass=<%=DesignationGroup.class.getName()%>"},
		{"name":"Designation Class","icon":"<i class='fas fa-star fa-3x'></i>","description":"Add or manage Designation Class","link":"/group/comnet2/mdm/form?formClass=<%=DesignationClass.class.getName()%>"},
		{"name":"Designation","icon":"<i class='fas fa-crown fa-3x'></i>","description":"Add or manage Designation","link":"/group/comnet2/mdm/form?formClass=<%=DesignationForm.class.getName()%>"},
		{"name":"Organizational Type","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage Organization Types","link":"/group/comnet2/mdm/form?formClass=<%=OrganizationType.class.getName()%>"},
		{"name":"Organizational Units","icon":"<i class='fas fa-building fa-3x'></i>","description":"Add or manage Organizational Units","link":"/group/comnet2/mdm/form/organization"},
		{"name":"Qualification","icon":"<i class='fas fa-book-reader fa-3x'></i>","description":"Add or manage Qualification","link":"/group/comnet2/mdm/form?formClass=<%=Qualification.class.getName()%>"},
		{"name":"Qualification Grade","icon":"<i class='fas fa-user-graduate fa-3x'></i>","description":"Add or manage Qualification Grades","link":"/group/comnet2/mdm/form?formClass=<%=QualificationGrade.class.getName()%>"},
		{"name":"Religion","icon":"<i class='fas fa-praying-hands fa-3x'></i>","description":"Add or manage Religion","link":"/group/comnet2/mdm/form?formClass=<%=Religion.class.getName()%>"},
		{"name":"Post","icon":"<i class='fas fa-user-shield fa-3x'></i>","description":"Add or manage employee posts","link":"<%=postListURL.toString()%>"},
		{"name":"Post Delegation","icon":"<i class='fas fa-people-carry fa-3x'></i>","description":"Add or manage employee posts","link":"/group/comnet2/mdm/form?formClass=<%=PostDelegation.class.getName()%>"},
		{"name":"Post Reporting","icon":"<i class='fas fa-sitemap fa-3x'></i>","description":"Add or manage employee posts","link":"/group/comnet2/mdm/form?formClass=<%=PostReporting.class.getName()%>"},
		{"name":"Specialization","icon":"<i class='fas fa-medal fa-3x'></i>","description":"Add or manage Specialization","link":"/group/comnet2/mdm/form?formClass=<%=Specialization.class.getName()%>"}
		];
	
	let output = '';
	$.each(mdmEntityList, function(key, val){
		output+= htmlData(val);
		
	});
	//console.log(output);
	
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