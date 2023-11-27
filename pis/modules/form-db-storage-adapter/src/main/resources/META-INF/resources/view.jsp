<%@ include file="/init.jsp" %>


    <aui:fieldset>
        <aui:select label="Select Form:" id="options" name="country" required="true" showEmptyOption="false">
            <c:forEach items="${formMap}" var="form">
          	  <aui:option value="${form.key}">${form.value}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>



<c:forEach items="${formMap}" var="form">
	<portlet:renderURL var="viewFormURL">
		<portlet:param name="formInstanceId" value="${form.key}" />
		<portlet:param name="mvcRenderCommandName" value="view_form" />
	</portlet:renderURL>
	
	<a href="<%=viewFormURL.toString()%>">${form.value}</a>
</c:forEach>


