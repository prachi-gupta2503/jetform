<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>

<link href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/select.dataTables.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.select.min.js"></script>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.list.json_data_002dlist_jsp");
%>
<%
	String apiUrl=ParamUtil.getString(request, "apiUrl");
	String excludeAttributes=ParamUtil.getString(request, "excludeAttributes");
	
	JSONArray list=(JSONArray)request.getAttribute("list");
	JSONObject row1=list.getJSONObject(0);
	List<String> excludes=Arrays.asList(excludeAttributes.split(","));
	
%>
<div class="card">
	<div class="card-body" style="overflow:scroll;">
		<table id="<portlet:namespace/>dataTable" class="stripe mb-5 pt-2">
			<thead>
			<tr>
<%
			for(String s:row1.keySet()){
				if(excludes.contains(s.toLowerCase())){
					continue;
				}
%>				
				<th><%=AnnotationUtil.getItemLabel(s)%></th>
<%
			}
%>				
			</tr>
			</thead>
			<tbody>
<%
			Iterator itr=list.iterator();
			while(itr.hasNext()){
				JSONObject row=(JSONObject)itr.next();
				
%>
				<tr>
<%
				for(String s:row.keySet()){
					if(excludes.contains(s.toLowerCase())){
						continue;
					}
					String strValue="";
					Object value=row.get(s);
					if(value instanceof JSONArray){
						JSONArray arrValue=(JSONArray)value;
						Iterator itr1=arrValue.iterator();
						while(itr1.hasNext()){
							strValue=strValue+itr1.next()+",";
						}
						if(strValue.endsWith(",")){
							strValue=strValue.substring(0,strValue.length()-1);
						}
					}else{
						strValue=String.valueOf(value);
					}
%>			
					<td><%=strValue%></td>
<%
				}
%>						
				</tr>
<%				
			}
%>				
			
			</tbody>
		</table>
	</div>
</div>
<aui:script>
$(document).ready(function() {
	$('#<portlet:namespace/>dataTable').DataTable();
<%--	//AUI().use('aui-base', function(A){
		Liferay.Service(
			'<%=apiUrl%>',
			function(response) {
				console.log("service response ================");
			    
			    console.log(response);
			    var rows=[];
			    $(response).each(function(i, d){
			    	rows[i]=d;
			    });
			    var columns=Object.keys(rows[0]);
			    console.log(columns);
			    
			    
			    var table= $('#<portlet:namespace/>dataTable').DataTable({
					data: rows,
					columns: columns
				});
				
			}
		);
	//});--%>
});
</aui:script>
 
