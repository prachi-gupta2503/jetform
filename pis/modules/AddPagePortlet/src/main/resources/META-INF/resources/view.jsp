<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<style>
.ui-dialog{
	width:600px !important;
	height:400px !important;
}
</style>

<portlet:actionURL var="addPage" name="addPageAction"></portlet:actionURL>

<portlet:renderURL var="viewURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<%
	String portalUrl = themeDisplay.getURLPortal(); // "http://localhost:8080"
	String currentUrl = themeDisplay.getURLCurrent(); // "/web/ordnance-factory-board/downloads"
	String siteName = layout.getGroup().getFriendlyURL(); // "/ofb"
	String status = (String)request.getAttribute("status");
	boolean isUserDashboardExists = false;
	long groupId = themeDisplay.getScopeGroupId();
	long userId = themeDisplay.getUserId();
	try {
		Layout userDashboardLayout = LayoutLocalServiceUtil.getLayoutByFriendlyURL(groupId, true,
				"/dashboard-template_" + userId);

		if (userDashboardLayout != null) {
			isUserDashboardExists = true;
		}
	} catch (Exception e) {
	}
	if(isUserDashboardExists){
%>
<div>
	<div class="card">
		<div class="card-body">
			<span class="error">You already have a customized dashboard.</span>
		</div>
	</div>
</div>
<% }else{ %>
<div>
	<div class="card">
		<div class="card-body">
			<div class="addPageDiv">
				<aui:form action="<%=addPage%>" name="<portlet:namespace />fm">
					<aui:fieldset>
						<aui:input name="title" />
						<aui:input name="description" />
					</aui:fieldset>

					<aui:button-row>
						<aui:button type="submit" value="Add Page" style="float:right;"></aui:button>
						<aui:button type="cancel" onClick="closeDialog();"
							style="float:right; margin-right:20px;"></aui:button>
					</aui:button-row>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<% } %>
<script>
$(document).ready(function(){
	var status = "<%=status%>";
	var redirectUrl = '<%=portalUrl+"/group"+siteName+"/dashboard-template_"+userId%>';
	if(status=="success"){
		console.log(redirectUrl);
		window.parent.location.href=redirectUrl;
	}
})
		

$("#add-page").click(function(){
	Liferay.Util.openWindow(
			{
				dialog: {
					//cssClass: 'aui-popup-example',
					destroyOnHide: true,
					height: 350,
					width: 600
				},
				dialogIframe: {
					bodyCssClass: 'custom-css-class'
				},
				title: 'Create Personalized Dashboard',
				uri: '<%=viewURL.toString()%>'
			}
		); 
});

function closeDialog(){
	$("btn-toolbar-button.close.close-content.yui3-widget.aui-button.yui3-aui-button.yui3-aui-button-content").click();
}

</script>
