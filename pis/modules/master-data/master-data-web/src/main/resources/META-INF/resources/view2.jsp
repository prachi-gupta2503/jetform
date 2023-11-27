<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>
	
	<script
	src="<%=request.getContextPath()%>/js/Backbone.js"></script>
	<script
	src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>

<%
	String mdmData1 = "[{\"name\":\"Grade\",\"icon\":\"<i class='fas fa-th-large fa-3x'></i>\",\"description\":\"Add or manage Grade\",\"link\":\"#\"}, "
			+ "{\"name\":\"Employee\",\"icon\":\"<i class='fas fa-user fa-3x'></i>\",\"description\":\"Add or manage Employee\",\"link\":\"#\"}, "
			+ "{\"name\":\"Designation\",\"icon\":\"<i class='fas fa-users fa-3x'></i>\",\"description\":\"Add or manage Designation\",\"link\":\"#\"}, "
			+ "{\"name\":\"Organizational Units\",\"icon\":\"<i class='fas fa-project-diagram fa-3x'></i>\",\"description\":\"Add or manage Organizational Units\",\"link\":\"#\"}, "
			+ "{\"name\":\"Accommodation\",\"icon\":\"<i class='fas fa-city fa-3x'></i>\",\"description\":\"Add or manage Accommodation\",\"link\":\"#\"}, "
			+ "{\"name\":\"Qualification\",\"icon\":\"<i class='fas fa-laptop fa-3x'></i>\",\"description\":\"Add or manage Qualification\",\"link\":\"#\"}, "
			+ "{\"name\":\"Location\",\"icon\":\"<i class='fas fa-map-marker-alt fa-3x'></i>\",\"description\":\"Add or manage Location\",\"link\":\"#\"}, "
			+ "{\"name\":\"Permission\",\"icon\":\"<i class='fas fa-shield-alt fa-3x'></i>\",\"description\":\"Add or manage Permission\",\"link\":\"#\"}, "
			+ "{\"name\":\"Report\",\"icon\":\"<i class='fas fa-chart-area fa-3x'></i>\",\"description\":\"Add or manage Report\",\"link\":\"#\"}, "
			+ "{\"name\":\"Post\",\"icon\":\"<i class='fas fa-copy fa-3x'></i>\",\"description\":\"Add or manage Post\",\"link\":\"#\"}, "
			+ "{\"name\":\"Saving Scheme\",\"icon\":\"<i class='fas fa-cogs fa-3x'></i>\",\"description\":\"Add or manage Saving Scheme\",\"link\":\"#\"}, "
			+ "{\"name\":\"Roles\",\"icon\":\"<i class='fas fa-user-lock fa-3x'></i>\",\"description\":\"Add or manage Roles\",\"link\":\"#\" "
			+ "}]"	;

//	ObjectMapper mapper = new ObjectMapper();

	//List<MasterEntity> participantJsonList = mapper.readValue(mdmData1,
//			new TypeReference<List<MasterEntity>>() {
//			});
	
//	System.err.println("--------" + participantJsonList.size());
%>

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

	</div>

</div>
<div class="">
	<div id="filter-records" class="row" style="text-align: center">
		<%-- <%
			for (MasterEntity masterEntity : participantJsonList) {
		%>
		<div class="c-m">
			<div class="col">

				<a href="#" class="mdm-anchor">
					<p class="text-primary">
						<%=masterEntity.getIcon()%>
					</p>
					<h4><%=masterEntity.getName()%></h4>
					<p><%=masterEntity.getDescription()%></p>
				</a>
			</div>
		</div>
		<%
			}
		%> --%>
	</div>
</div>

<script>
var mdmDataList =[{"name":"Grade","icon":"<i class='fas fa-th-large fa-3x'></i>","description":"Add or manage Grade","link":"#"}, 
	 {"name":"Employee","icon":"<i class='fas fa-user fa-3x'></i>","description":"Add or manage Employee","link":"#"}, 
	 {"name":"Designation","icon":"<i class='fas fa-users fa-3x'></i>","description":"Add or manage Designation","link":"#"}, 
	 {"name":"Organizational Units","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage Organizational Units","link":"#"},
	{"name":"Accommodation","icon":"<i class='fas fa-city fa-3x'></i>","description":"Add or manage Accommodation","link":"#"}, 
	{"name":"Qualification","icon":"<i class='fas fa-laptop fa-3x'></i>","description":"Add or manage Qualification","link":"#"}, 
	{"name":"Location","icon":"<i class='fas fa-laptop fa-3x'></i>","description":"Add or manage Location","link":"#"}, 
	{"name":"Permission","icon":"<i class='fas fa-shield-alt fa-3x'></i>","description":"Add or manage Permission","link":"#"}, 
	{"name":"Report","icon":"<i class='fas fa-chart-area fa-3x'></i>","description":"Add or manage Report","link":"#"}, 
	{"name":"Post","icon":"<i class='fas fa-copy fa-3x'></i>","description":"Add or manage Post","link":"#"}, 
	{"name":"Saving Scheme","icon":"<i class='fas fa-cogs fa-3x'></i>","description":"Add or manage Saving Scheme","link":"#"}, 
	{"name":"Roles","icon":"<i class='fas fa-user-lock fa-3x'></i>","description":"Add or manage Roles","link":"#"
	}];
	
$(document).ready(function(){
	
	renderMdmEntityCta(mdmDataList);
	
	$('#txt-search').keyup(function(){

            let searchField = $(this).val();
            let regex = new RegExp(searchField, "i");
           	let count = 0;
			if(searchField === '')  {
				renderMdmEntityCta(mdmDataList);
				return;
			}
			 <%-- var mdmData1 = '<%= participantJsonList %>'; --%>
			 
			 let filteredMdmDataList=[];
			  
			 $.each(mdmDataList, function(key, mdmData){
				 
				if (( (mdmData.name.search(regex) != -1))) {
					filteredMdmDataList[count++]=mdmData;
				}
			  });
			  renderMdmEntityCta(mdmDataList);
        }); 
		
	});
	
	function renderMdmEntityCta(mdmEntityList){
		console.log("before renderMdmEntityCta");
		console.log(mdmEntityList);
		
		var source = $('#mdm-entity-cta-template').html();
		var template = Handlebars.compile(source);
		console.log("after Handlebars.compile(source)");
		var resultHtml = template(mdmEntityList);
		$("#filter-records").html(resultHtml);
	}	
</script>
<script type="text/x-handlebars-template" id="mdm-entity-cta-template">
	{{#each elements}}
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