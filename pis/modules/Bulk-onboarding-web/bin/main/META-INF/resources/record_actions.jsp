<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper"%>
<%@page import="com.adjecti.pis.dto.RegistrationRequestSearchParameter"%>
<%@page import="com.adjecti.pis.util.OnboardingUtil"%>
<%@page import="com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil"%>
<%@page import="com.adjecti.pis.model.BulkOnbordingFile"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil"%>
<%@page	import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@page import="com.adjecti.pis.util.BulkOnboardUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="./init.jsp"%>
<%  
	long bulkOnbordingFileId = ParamUtil.getLong(request, "bulkOnbordingFileId");	
	long registrationRequestId = ParamUtil.getLong(request, "requestId");
		
	boolean hasOwnerRole = RegistrationRequestLocalServiceUtil.hasOwnerRole(user.getUserId(), user.getCompanyId());
	
	RegistrationRequestDTO requestDtoObj =  RegistrationRequestLocalServiceUtil.getRegistration(registrationRequestId);
%>
<c:set var="requestDto" value='<%=requestDtoObj %>'/>
<portlet:actionURL name="deleteRequest" var="deleteURL">
	<portlet:param name="requestId"	value="${requestDto.registrationRequestId}" />
	<portlet:param name="bulkOnbordingFileId" value="${bulkOnbordingFileId}" />
	<portlet:param name="mvcPath" value="/record_list_view.jsp" />
</portlet:actionURL>

<portlet:renderURL var="editEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/edit_entry.jsp" />
	<portlet:param name="registrationId" value="${requestDto.registrationRequestId}" />
</portlet:renderURL>
<portlet:renderURL var="detailEntryURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/detail_entry.jsp" />
	<portlet:param name="detailRegistrationId" value="${requestDto.registrationRequestId}" />
</portlet:renderURL>
<liferay-ui:icon-menu>
	
	<%
		if (hasOwnerRole) {
	%>
	<c:if test="${requestDto.editable}">
		<liferay-ui:icon image="delete" message="Delete" url="${deleteURL}" />
	</c:if>
	<%
		}
	%>
	<c:if test="${empty requestDto.errorMessage}">
		<c:forEach items="${requestDto.actions}" var="taskAction">
			<c:if test="${requestDto.assignable}">
				<button type="button" class="btn btn-link" style="color: #6b6c7e;" id="<portlet:namespace/>approveBtn" name="<portlet:namespace />approveBtn" 
					onclick='approverPopup("${requestDto.registrationRequestId}", "${taskAction}","${requestDto.taskId}","${bulkOnbordingFileId}" )'>
				<liferay-ui:icon image="submit" message="${taskAction}" />
				</button>
				<br>
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${requestDto.editable}">
		<button type="button" class="btn btn-link" style="color: #6b6c7e;" name="<portlet:namespace />edit_btn" id="<portlet:namespace />edit_btn"
			onclick='viewActionPopup("${editEntryURL}","Edit entry request","${requestDto.registrationRequestId}","EDIT")' >
			<liferay-ui:icon image="edit" message="Edit entry" />
		</button>
		<br>
	</c:if>
	
	<button type="button" class="btn btn-link" name="<portlet:namespace />view_btn" id="<portlet:namespace />view_btn" style="color: #6b6c7e;"
		onclick='viewActionPopup("${detailEntryURL}","${requestDto.fullName}","${requestDto.registrationRequestId}","VIEW")' >
		<liferay-ui:icon image="view" message="View" />
	</button>
	
</liferay-ui:icon-menu>
