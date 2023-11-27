<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@ include file="/init.jsp"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationModeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationMode"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>

<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationClass"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="com.adjecti.mdm.liferay.constants.ScopeType"%>

<%
 List<Designation> designations = MDMUtils.getAllDesignations(); 
 List<DesignationClass> designationClasses = MDMUtils.getAllDesignationClasss();
 List<DesignationGroup> designationGroups = MDMUtils.getAllDesignationGroups();
 List<Organization> scopeOrganizationTypes = MDMUtils.getAllOrganizations();
 List<Grade> grades = MDMUtils.getAllGrades();
 List<DesignationMode> designationModes = DesignationModeLocalServiceUtil.getDesignationModes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
 List<Post> scopePosts = MDMUtils.getAllPosts();
		 
%>
 <portlet:actionURL name="saveDesignation" var="saveDesignationURL">
	
</portlet:actionURL>
<aui:container>		
		<aui:form  action="${addRequestActionURL}" name="requestForm" method="POST">
	
					<aui:input label="Code" type="text" name="code">
					</aui:input>
					<aui:input label="name_En" type="text" name="name_En">
					</aui:input>
					<aui:input label="description" type="text" name="description">
					</aui:input>
					
					<aui:input label="Sequence No." type="text" name="sequenceNo">
					</aui:input>
					
					<label for="gender">Scope Type</label>				
						<aui:field-wrapper name="Scope Type">
						
							<aui:input label="A" name="scopeType" type="radio" value="<%= ScopeType.valueOf(ScopeType.ORGANIZATION) %>">
								</aui:input>
								
									<aui:input label="B" name="scopeType" type="radio" value="<%= ScopeType.valueOf(ScopeType.ORGANIZATION_TYPE) %>">
					
								</aui:input>						
						</aui:field-wrapper>
					
				<aui:select label="Select Designation Class:" id="designationClass" name="designationClass"  showEmptyOption="true">
            			<c:forEach var="designationClass" items="<%=designationClasses%>" >			    				
            				<aui:option value="${designationClass.designationClassId}">${designationClass.name}</aui:option>
            			</c:forEach>
        			</aui:select>
        			
        			
					
					<aui:select label="Select Designation Group:" id="designationGroup" name="designationGroup"  showEmptyOption="true">
            			<c:forEach var="designationGroup" items="<%=designationGroups%>" >			    				
            				<aui:option value="${designationGroup.designationGroupId}">${designationGroup.name}</aui:option>
            			</c:forEach>
        			</aui:select>
		
			<aui:select label="Scope Organization Type:" id="scopeOrganizationType" name="scopeOrganizationType"  showEmptyOption="true">
            			<c:forEach var="scopeOrganizationType" items="<%=scopeOrganizationTypes%>" >			    				
            				<aui:option value="${scopeOrganizationType.organizationId}">${scopeOrganizationType.name}</aui:option>
            			</c:forEach>
        			</aui:select>
					
					<aui:select label="Select Grade:" id="grade" name="grade" required="true" showEmptyOption="true">
            			<c:forEach var="grade" items="<%=grades%>" >
            				<aui:option value="${grade.gradeId}">${grade.name}</aui:option>
        				</c:forEach>
        			</aui:select>

					<aui:select label="Select Designation Mode:" id="designationMode:" name="designationMode"  showEmptyOption="true">
            			<c:forEach var="designationMode" items="<%=designationModes%>" >			    				
            				<aui:option value="${designationMode.designationModeId}">${designationMode.name}</aui:option>
            			</c:forEach>
        			</aui:select>
        			
        			<aui:select label="Select Scope Post:" id="scopePost:" name="scopePost"  showEmptyOption="true">
            			<c:forEach var="scopePost" items="<%=scopePosts%>" >			    				
            				<aui:option value="${scopePost.postId}">Scope post not set</aui:option>
            			</c:forEach>
        			</aui:select>

					<aui:select label="Select Successor:" id="successor:" name="successor"  showEmptyOption="true">
            			<c:forEach var="successor" items="<%=designations%>" >			    				
            				<aui:option value="${successor.designationId}">${successor.name_En}</aui:option>
            			</c:forEach>
        			</aui:select>

				    	
					<aui:button-row>
						<aui:button name="submitButton" type="submit" value="Submit" />
						<aui:button type="button" name="close" value="close"/>
					</aui:button-row>
</aui:form>
</aui:container>
