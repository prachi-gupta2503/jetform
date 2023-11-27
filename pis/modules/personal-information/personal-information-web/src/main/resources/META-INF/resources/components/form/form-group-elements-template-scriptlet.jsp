<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>

<%

if(CollectionUtils.isNotEmpty(form.getElementGroups())){
	int i=0;
	for(HtmlElementGroupWrapper group: form.getElementGroups()){
		System.out.println(" "+group);
		int elementCtr=0;
		int groupColWidth = 12;
		i++;
		if(i==2){
			break;
		}
		if(group.getWidthPercentage()!=100 && group.getWidthPercentage()>1){
			groupColWidth=Math.round(12/100*group.getWidthPercentage());
		}
	
		int elementsPerRow=group.getElementsPerRow()==0? (form.getElementsPerRow()==0?1:form.getElementsPerRow()):group.getElementsPerRow();
%>
<script type="text/x-handlebars-template" id="<%=group.getId()%>-group-elements-template">
	<div class="row">
		
<%	
	
		if(groupColWidth<12 && group.getAlign()==HtmlElementGroup.Align.right.ordinal()){
%>
	<!-- This defines the left coloumn in case the group alignment=right and groupColWith<12 -->
	<div class="col-md-<%=(12-groupColWidth)%>"></div>
	
<%
		}
%>	
	<div class="col-md-<%=groupColWidth%>">
<%	
		if(elementsPerRow>1){	
%>
			<div class="row">
<%}	
	
		for (HtmlElementWrapper e : group.getElements()) {
			String value="";
			if(editMode && form.getEntity()!=null){
				try{
					Method m=formClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
					value=String.valueOf(m.invoke(model, blankParams));
				}catch(Exception ex){}
			}
			
			String elementColClass="form-group-autofit";
			if(elementsPerRow>1){	
				elementColClass="col-md-"+(12/elementsPerRow);		
			}%>
		<div class="<%=elementColClass %>">
			<div class="form-group-item">
<%if(e.isControlType(HtmlElement.ControlType.select)){%>
				<aui:select class="form-control" type="<%=e.getControlType()%>" name="<%=e.getName()%>" id="<%=e.getName()%>" label="<%=e.getLabel()%>" placeholder="<%=e.getLabel()%>" >
<%if(StringUtils.isNotEmpty(e.getPlaceHolder())){%>
							<aui:option value="0" label="<%=e.getPlaceHolder()%>"/>
<%}
				for(KeyValue kv:e.getListOptions()){
					boolean selected=false;
					if(StringUtils.equalsIgnoreCase(value, kv.getKey())){
						selected=true;
					}%>	
							<aui:option value="<%=kv.getKey() %>" label="<%=kv.getValue() %>" selected="<%=selected%>" />
<%}%>
						</aui:select>
<%}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){%>
						<label for="<%=e.getName()%>"><%=e.getLabel()%></label>
						<ul style="list-style-type:none; padding-inline-start: 5px; columns: <%=e.getListOptions().size()/10 %>; -webkit-columns: <%=e.getListOptions().size()/10 %>; -moz-columns: <%=e.getListOptions().size()/10 %>;">
<%for(KeyValue kv:e.getListOptions()){
					boolean checked=false;
					if(StringUtils.equalsIgnoreCase(value, kv.getKey())){
						checked=true;
					}%>	
							<li><aui:input type="<%=e.getControlType() %>" name="<%=e.getName()%>" id="<%=e.getName()%>"  value="<%=kv.getKey() %>" label="<%=kv.getValue() %>" checked="<%=checked %>"/></li>
<%}%>
						</ul>
<%}else{%>
						<aui:input class="form-control" type="<%=e.getControlType()%>" name="<%=e.getName()%>" id="<%=e.getName()%>" label="<%=e.getLabel()%>" placeholder="<%=e.getLabel()%>" value="<%=value%>" >
<%if(e.isRequired()){%>	
							<aui:validator name="required" />
<%}%>	
						</aui:input>
<%}%>
		</div>
	</div>

<%}%>

<%if(elementsPerRow>1){%>
			</div>
<%}%>
	</div>
<%if(groupColWidth<12 && group.getAlign()==HtmlElementGroup.Align.left.ordinal()){%>
	<!-- This defines the right coloumn in case the group alignment=left and groupColWith<12 -->
	<div class="col-md-<%=(12-groupColWidth)%>"></div>
	
<%}%>	
	</div>
	</script>	
<%
		} //End of group for loop
	}//end of if
	%>

<aui:script>
							
<%
								if(CollectionUtils.isNotEmpty(form.getElementGroups())){
								for(HtmlElementGroupWrapper group: form.getElementGroups()){
									for (HtmlElementWrapper e : group.getElements()) {
								
								String value="";
								if(editMode && form.getEntity()!=null){
									try{
										Method m=formClazz.getMethod("get"+StringUtils.capitalize(e.getAttribute()), blankTypes);
										value=String.valueOf(m.invoke(model, blankParams));
									}catch(Exception ex){}
								}
								for(HtmlEventWrapper event:e.getEvents()){
							%>
				$("#<portlet:namespace/><%=e.getName()%>").on("<%=event.getName()%>",function(){
					//alert("<%=e.getName()%>");
				}); 
<%
			}
			if(StringUtils.isNotEmpty(e.getDepends())){
				String funcName="load".concat(StringUtils.capitalize(e.getName())).concat("By").concat(e.getDependantKey());
				HtmlElementWrapper de=group.getElementByName(e.getDepends());
				if(de.isControlType(HtmlElement.ControlType.select)){
					dependingParents.put(de.getName(), funcName);
				
%>
					$("#<portlet:namespace/><%=de.getName()%>").on("change",function(){
						<%=funcName%>(this.value);
					});
				
				
					function <%=funcName%>(<%=e.getDependantKey()%>){
						AUI().use('aui-io-request', function(A){
				    		A.io.request('<%=listOptionsResourceURL%>', {
								method: 'post',
									data: {
										<portlet:namespace />elementName: '<%=e.getName()%>',
										<portlet:namespace />dependantValue: <%=e.getDependantKey() %>
									},
								on : {
									success : function() {
										var str = this.get('responseData');
										var data=$.parseJSON(str);
										reloadListOptions('#<portlet:namespace/><%=e.getName()%>',data,'key', 'value', 'Select a <%=e.getLabel() %>', '<%=value%>');
									}
								}
							});
						});
					}
<%
				}
			}
		}
	}
}
%>
</aui:script>

