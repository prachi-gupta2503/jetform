<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/handlebars.min.js"></script> --%>
<%


%>
<%
	List<MasterEntity> entities = MasterEntityLocalServiceUtil.getMasterEntities(QueryUtil.ALL_POS, QueryUtil.ALL_POS );
	//JSONArray jsonArray=JSONFactoryUtil.createJSONArray(entities);
	//String entitiesJson=JSONFactoryUtil.serialize(entities);
%>
<%--
	String mdmData1 = "[{\"name\":\"Grade\",\"icon\":\"<i class='fas fa-th-large fa-3x'></i>\",\"description\":\"Add or manage Grade\",\"link\":\"#\"}, "
			+ "{\"name\":\"Employee\",\"icon\":\"<i class='fas fa-user fa-3x'></i>\",\"description\":\"Add or manage Employee\",\"link\":\"#\"}, "
			+ "{\"name\":\"Designation\",\"icon\":\"<i class='fas fa-users fa-3x'></i>\",\"description\":\"Add or manage Designation\",\"link\":\"#\"}, "
			+ "{\"name\":\"Organizational Units\",\"icon\":\"<i class='fas fa-project-diagram fa-3x'></i>\",\"description\":\"Add or manage Organizational Units\",\"link\":\"http://localhost:8080/group/ordnance-factory-board/organization\"}, "
			+ "{\"name\":\"Accommodation\",\"icon\":\"<i class='fas fa-city fa-3x'></i>\",\"description\":\"Add or manage Accommodation\",\"link\":\"#\"}, "
			+ "{\"name\":\"Qualification\",\"icon\":\"<i class='fas fa-laptop fa-3x'></i>\",\"description\":\"Add or manage Qualification\",\"link\":\"#\"}, "
			+ "{\"name\":\"Location\",\"icon\":\"<i class='fas fa-map-marker-alt fa-3x'></i>\",\"description\":\"Add or manage Location\",\"link\":\"#\"}, "
			+ "{\"name\":\"Permission\",\"icon\":\"<i class='fas fa-shield-alt fa-3x'></i>\",\"description\":\"Add or manage Permission\",\"link\":\"#\"}, "
			+ "{\"name\":\"Report\",\"icon\":\"<i class='fas fa-chart-area fa-3x'></i>\",\"description\":\"Add or manage Report\",\"link\":\"#\"}, "
			+ "{\"name\":\"Post\",\"icon\":\"<i class='fas fa-copy fa-3x'></i>\",\"description\":\"Add or manage Post\",\"link\":\"#\"}, "
			+ "{\"name\":\"Saving Scheme\",\"icon\":\"<i class='fas fa-cogs fa-3x'></i>\",\"description\":\"Add or manage Saving Scheme\",\"link\":\"#\"}, "
			+ "{\"name\":\"Roles\",\"icon\":\"<i class='fas fa-user-lock fa-3x'></i>\",\"description\":\"Add or manage Roles\",\"link\":\"#\" "
			+ "}]"	;

	ObjectMapper mapper = new ObjectMapper();

	List<MasterEntity> participantJsonList = mapper.readValue(mdmData1,
			new TypeReference<List<MasterEntity>>() {
			});
--%>

<div id="ajaxGetUserServletResponse"></div>

<div class="search-container">
	<div class="input-group text-right">

		<input type="text" class="form-control" id="txt-search"
			placeholder="Search in option">
		<div class="input-group-append">
			<button class="btn btn-secondary" type="button">
				<i class="fa fa-search"></i>
			</button>
		</div>
		<div class="input-group-append">
			<a href="/group/comnet2/form?formClass=com.adjecti.mdm.liferay.model.MasterEntity&formAction=add&redirectPage=/web/guest/master">
				<i class="fa fa-plus-square fa-button" aria-hidden="true" style="color:#007bff !important; font-size:24px;"></i>
			</a>
		</div>
	</div>

</div>
<div>
	<div id="filter-records" class="row" style="text-align: center">
		<%--  Place holder for links--%>
		No options avaliable.
	</div>
</div>

<script>
<%
	boolean notEmpty=false;
	String entitiesJson="";
	for(MasterEntity entity:entities){
		entitiesJson+="{\"name\":"+"\""+entity.getName()+"\",";
		if(entity.getIcon()==null || entity.getIcon().trim().isEmpty()){
			entitiesJson+="\"icon\":"+"\"<i class=\\'fas fa-users fa-3x\\'></i>\",";
		}else{
			entitiesJson+="\"icon\":"+"\""+entity.getIcon()+"\",";
		}
		
		if(entity.getDescription()==null || entity.getDescription().trim().isEmpty()){
			entitiesJson+="\"description\":"+"\"Adding, modifying and deleting "+entity.getName()+".\",";
		}else{
			entitiesJson+="\"description\":"+"\""+entity.getDescription()+"\",";
		}
		
		entitiesJson+="\"link\":"+"\""+entity.getLink()+"\"},";
	}
	if(!entitiesJson.isEmpty()){
		notEmpty=true;
		entitiesJson=entitiesJson.substring(0, entitiesJson.length()-1);
	}
%>
<%--var entitiesJson='[<%=entitiesJson%>]';--%>

//console.log(entitiesJson);
var mdmEntityList=$.parseJSON('[<%=entitiesJson%>]')
//console.log(mdmEntityList);

$(document).ready(function(){
	console.log("$(document).ready(function()");
<%--	var mdmEntityList =[{"name":"Grade","icon":"<i class='fas fa-th-large fa-3x'></i>","description":"Add or manage Grade","link":"#"}, 
		 {"name":"Employee","icon":"<i class='fas fa-user fa-3x'></i>","description":"Add or manage Employee","link":"#"}, 
		 {"name":"Designation","icon":"<i class='fas fa-users fa-3x'></i>","description":"Add or manage Designation","link":"#"}, 
		 {"name":"Organizational Units","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage Organizational Units","link":"http://localhost:8080/group/ordnance-factory-board/organization"},
		{"name":"Accommodation","icon":"<i class='fas fa-city fa-3x'></i>","description":"Add or manage Accommodation","link":"#"}, 
		{"name":"Qualification","icon":"<i class='fas fa-laptop fa-3x'></i>","description":"Add or manage Qualification","link":"#"}, 
		{"name":"Location","icon":"<i class='fas fa-laptop fa-3x'></i>","description":"Add or manage Location","link":"#"}, 
		{"name":"Permission","icon":"<i class='fas fa-shield-alt fa-3x'></i>","description":"Add or manage Permission","link":"#"}, 
		{"name":"Report","icon":"<i class='fas fa-chart-area fa-3x'></i>","description":"Add or manage Report","link":"#"}, 
		{"name":"Post","icon":"<i class='fas fa-copy fa-3x'></i>","description":"Add or manage Post","link":"#"}, 
		{"name":"Saving Scheme","icon":"<i class='fas fa-cogs fa-3x'></i>","description":"Add or manage Saving Scheme","link":"#"}, 
		{"name":"Roles","icon":"<i class='fas fa-user-lock fa-3x'></i>","description":"Add or manage Roles","link":"#"
		}];--%>
	
	//renderMdmEntityCta(mdmEntityList);
	let output = '';
	$.each(mdmEntityList, function(key, val){
		output+= htmlData(val);
		
	});
	console.log(output);
	
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
	console.log("before renderMdmEntityCta");
	console.log(mdmList);
	
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
