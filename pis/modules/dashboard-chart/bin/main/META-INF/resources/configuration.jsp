
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />
<html>
<body>
	<div class = "row">
		<div class="col lfr-form-content">
			<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
				<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
				<aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />
			
				<aui:input type="text" name="name" label="Chart Name"	required="true"></aui:input>
				<aui:fieldset>
					<aui:select label="Chart" name="chart" value="<%=chart%>">
						<aui:option value="bar">Bar Chart</aui:option>
						<aui:option value="donut">Donut Chart</aui:option>
						<aui:option value="pie">Pie Chart</aui:option>
					</aui:select>
				</aui:fieldset>
				<aui:input type="text" name="labels" label="Labels"	required="true"></aui:input>
				<aui:input type="text" name="values" label="Values"	required="true"></aui:input>
			
				<aui:button-row>
					<aui:button type="submit"></aui:button>
				</aui:button-row>
			</aui:form>
			</div>
	</div>
</body>
</html>
