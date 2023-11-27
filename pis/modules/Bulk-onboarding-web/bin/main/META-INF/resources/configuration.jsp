<%@page import="com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig"%>
<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />
<div class="container">
<div class="row">
<div class="col-6 mx-auto">
<aui:form action="${configurationActionURL}" method="post" name="fm">

	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="redirect" type="hidden"
		value="${configurationRenderURL}" />
	<div class="row py-5">
	
	<div class="card ">
  <div class="card-header bg-primary text-white">
    Upload File
  </div>
  <div class="card-body">
    <h5 class="card-title"></h5>
    
   <aui:input type="file" name="uploadFile"  >
   <aui:validator name="required" />
   </aui:input>
					<aui:button-row>
						<aui:button type="submit"></aui:button>
					</aui:button-row>
  </div>
</div>
	</div>
</aui:form>
</div>
</div>
</div>