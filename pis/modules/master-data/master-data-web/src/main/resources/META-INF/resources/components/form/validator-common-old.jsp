<%
if(htmlElement.isRequired()){
%>	
	<aui:validator name="required" />
<%
}
if(htmlElement.isUnique()){
%>	
	<aui:validator errorMessage="<%="Duplicate "+htmlElement.getLabel()%>" name="custom">
		function(val, fieldNode, ruleValue) {
			//alert(<portlet:namespace/><%=htmlElement.getName()%>Unique);
	    	return <portlet:namespace/><%=htmlElement.getName()%>Unique;
	    }
	</aui:validator>
<%
}
%>
