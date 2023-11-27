<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.adjecti.pis.liferay.config.PISMVCPortletConfig"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp"%>
<%
String portletView = portletPreferences.getValue(PISMVCPortletConfig.PORTLET_VIEW, PISMVCPortletConfig.MENU);
%>
<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
			
				<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
			
				<aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />
			
				<aui:fieldset>
					<aui:select name="portletView" label="Select View Type" value="<%=portletView%>">
						<aui:option value="<%=PISMVCPortletConfig.MENU%>">Choose View Type</aui:option>
						<aui:option value="<%=PISMVCPortletConfig.EMPLOYEE_LIST%>"><%=PISMVCPortletConfig.EMPLOYEE_LIST %></aui:option>
						<aui:option value="<%=PISMVCPortletConfig.PROFILE_VIEW%>"><%=PISMVCPortletConfig.PROFILE_VIEW%></aui:option>
						<aui:option value="<%=PISMVCPortletConfig.PROFILE_CHANGE_REQUEST%>"><%=PISMVCPortletConfig.PROFILE_CHANGE_REQUEST%></aui:option>
					    <aui:option value="<%=PISMVCPortletConfig.DSC_VIEW%>"><%=PISMVCPortletConfig.DSC_VIEW%></aui:option>
					</aui:select>
				</aui:fieldset>
				<aui:button-row>
					<aui:button type="submit"></aui:button>
				</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>