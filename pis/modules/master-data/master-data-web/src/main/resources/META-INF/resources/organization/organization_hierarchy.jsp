
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.net.URLEncoder"%>
<%@ include file="/init.jsp" %>


<script src="<%=request.getContextPath()%>/js/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/js/sankey.js"></script>
<script src="<%=request.getContextPath()%>/js/organization.js"></script>
<script src="<%=request.getContextPath()%>/js/exporting.js"></script>
<script src="<%=request.getContextPath()%>/js/accessibility.js"></script> 

<style>
.highcharts-figure {
    min-width: 360px; 
    max-width: 800px;
    margin: 1em auto;
}

</style>
 
<figure class="highcharts-figure">
    <div id="container"></div>
</figure>

<%
long organizationId = ParamUtil.getLong(request, "classPK",0);
%>

 <script>
 $(function(){
	 organizationChart();
 })
 
 
 function organizationChart(){
	 
 var data=[]; 
 Liferay.Service(
		 '/mdm.organizationdetail/get-organization-hierarchy-by-organization-id',
		  {
		    organizationId: <%=organizationId%>
		  },
		  function(obj) {
		   console.log(obj)
		   var k=0;
		   obj.forEach(function(organization){
			   
			   var datavalue=[];
			   datavalue[0]=organization.parentOrganizationId ;
			   datavalue[1]=organization.organizationId;
			   data[k++]=datavalue;
		   })
		   
		 data.shift();
		 var levels=getLevel(data);
		
		 var nodes=getNodes(obj);
		 var series=organizationJson(data,levels,nodes);
		 createOrganizationChart(series); 
		 
		  }
		  
	);
 	
 }

 function getLevel(data){
 	 var colors=["#808000",'#980104','#359154','#FF5733','#CD5C5C','#FA8072','#FFBF00'];
 	 var color;
 	 const set = new Set()
 	
 	 for (var i = 0; i <data.length; i++) {
 		 set.add(data[i][0]);
 	 } 
 	 var levels=[];
 	 for(var j=0;j<=set.size;j++)
 		{
 			 if(j > colors.length-1)
 			{
 				 color="#0000FF";
 			}
 			 else{
 				 color=colors[j]
 			 }
 				var level={
 				level: j,
 			    color: color,
 			    dataLabels: {
 			        color: 'white'
 			      },
 			}
 			levels[j]=level;
 		}
 	
 	 return levels
  }
 
 function getNodes(data){
	 var nodes=[];
	 var i=0;
	 
	 data.forEach(function(organization){
		  
		 
		var node= {
		      id:organization.organizationId,
		      name: organization.name,
		      parentsId:organization.parentOrganizationId,
		      type:organization.type,
		    }
		
		nodes[i++]=node;
	   })
	 
	return nodes;
 }
 

 function organizationJson(data,levels,nodes){
	 
  var series=[{

  	 type:"organization",
  	 name:'Highsoft',
  	keys:['from','to'],

  	data:data,
  	levels:levels,
  	nodes:nodes,

  	colorByPoint: false,
  	  
  	    borderColor: 'white',
  	    nodeWidth: 50
  	    
  	 

  	}]
  
  return series;
 	
 }

 function createOrganizationChart(series){
	 
	 Highcharts.chart('container', {
    	  chart: {
    	    height: 400,
    	    inverted: true
    	  },

    	  title: {
    	    text: "Organization Chart"
    	  },

    	  accessibility: {
    	    point: {
    	      descriptionFormatter: function(point) {
    	        var nodeName = point.toNode.name;
    	       
    	          nodeId = point.toNode.id,
    	          nodeDesc = nodeName === nodeId ? nodeName : nodeName + ', ' + nodeId,
    	          parentDesc = point.fromNode.id;
    	        
    	        return point.index + '. ' + nodeDesc + ', reports to ' + parentDesc + '.';
    	      }
    	    }
    	  },
    	 
    	  series:series,
    	  tooltip: {
    	    outside: true
    	  },
    	  exporting: {
    	    allowHTML: true,
    	    sourceWidth: 800,
    	    sourceHeight: 400
    	  },
    	  credits: {
    		    enabled: false
    		  }

    	});
	 
 }

</script> 
  