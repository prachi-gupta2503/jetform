<portlet:renderURL var="defaultViewRenderURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<portlet:param name="isDefault" value="true" />
	
</portlet:renderURL>

<portlet:renderURL var="customViewRenderURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<portlet:param name="isDefault" value="false" />
	</portlet:renderURL>


<aui:button-row>
    <a  href="<%=defaultViewRenderURL.toString()%>" class="btn btn-secondary">Default</a>
    <a  href="<%=customViewRenderURL.toString()%>" class="btn btn-secondary">Custom</a>
</aui:button-row>
