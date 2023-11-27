<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@ include file="/init.jsp"%>
<%
	String elementName=ParamUtil.getString(request, "elementName");

	HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("htmlForm");	
	HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute("htmlElement_"+elementName);
	String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
%>

<script>
	var <portlet:namespace/><%=htmlElement.getName()%>Unique=false;
</script>

<aui:input type="<%=htmlElement.getControlType()%>" name="<%=htmlElement.getName()%>" id="<%=htmlElement.getName()%>" label="" placeholder="<%=htmlElement.getLabel()%>" value="<%=savedValue%>" >
<%
if(htmlElement.isRequired()){
%>	
	<aui:validator name="required" />
<%
}
if(htmlElement.isUnique()){
%>	
	<aui:validator errorMessage="<%="Duplicate "+htmlElement.getLabel()%>" name="unique">
		function(val, fieldNode, ruleValue) {
	    	return <portlet:namespace/><%=htmlElement.getName()%>Unique;
	    }
	</aui:validator>
<%
}
%>

</aui:input>
<%
if(htmlElement.isUnique()){
%>
<script>	
	$(document).ready(function(){
		$('#<portlet:namespace/><%=htmlElement.getName()%>').blur(function(){
			AUI().use('aui-base', function(A){
				Liferay.Service('/jetform.jetformbuilder/is-unique', 
				{
					"className":"<%=form.getEntityClass().getName()%>",
					"id": <%=form.getPrimaryKey() %>,
					"fieldName": "<%=htmlElement.getName()%>",
					"fieldValue": $('#<portlet:namespace/><%=htmlElement.getName()%>').val()
				},
				function(response) {
					<portlet:namespace/><%=htmlElement.getName()%>Unique=response;
				});
			});
		})
	})
</script>
<%
}
%>	