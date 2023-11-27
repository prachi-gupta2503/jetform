<%@page import="com.adjecti.mdm.liferay.model.Application"%>
<%@page import="com.adjecti.mdm.liferay.service.ApplicationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.OEMLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.mdm.liferay.model.OEM"%>

 <div class="form-card" >
 <h2 class="fs-title">Permissions</h2>
 <% 
 for(int i=0;i<(oemList.size()+1)/2;i++){
	%>
	<div class="row" style="margin:15px;padding:10px;">
	<%for(int j=i;j<i+2;j++){ 	
		if(j+i<oemList.size()){
			applications=ApplicationLocalServiceUtil.getApplicationByOemId(oemList.get(i+j).getOemId());
	%>
	<div class="form-group required col-md-6">
					<div style="magrin:10px" >
<input name="oem" type="checkbox"  id="checkall<%=i+j+1%>" onchange="checkAll(this.id);"/>
					<label><%=oemList.get(i+j).getName() %></label>
					
					<%
					if(applications.size()!=0){
						for(Application app:applications){
						%>
							<div style="margin-left: 15px;padding:10px;">
						<input name="appl" class="exampleCheck<%=i+j+1%>" type="checkbox" id="exampleCheck<%=i+j+1%>" value="<%=app.getApplicationId()%>"/>
					    <label><%=app.getName() %></label>
				</div>
						<%}
					} %>
					</div>
				</div>
	
	<% }
	}%>
	</div>
 <% } %> 
	</div>

<script>

 function checkAll(value1){
	 var value2=document.getElementById(value1);
	 var lastChar=value1.charAt(value1.length-1);
	  if(value2.checked){
		  var val="exampleCheck"+lastChar;
		var options=document.getElementsByClassName(val);
		   for(var i=0; i<options.length; i++){  
               if(options[i].type=='checkbox')  
            	   options[i].checked=true;  
           }  
	     
	  }
	  else{
		  var val="exampleCheck"+lastChar;
		   var options=document.getElementsByClassName(val);  
           for(var i=0; i<options.length; i++){  
               if(options[i].type=='checkbox')  
            	   options[i].checked=false;  
                 
           }  
	     }	 
 }

</script>

 