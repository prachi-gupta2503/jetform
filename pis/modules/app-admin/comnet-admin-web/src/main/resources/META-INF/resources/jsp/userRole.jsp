
<portlet:actionURL name="getUserByScreenName" var="screenNameUrl"></portlet:actionURL>

<portlet:actionURL name="selectedData" var="comnetAdminActionUrl"></portlet:actionURL>
<portlet:renderURL var="applicationUserByScreenName">
	<portlet:param name="mvcRenderCommandName"  value="<%=MVCCommandNames.PERMISSION_BY_SCREEN_NAME %>" />
</portlet:renderURL>


<aui:form action="<%=comnetAdminActionUrl%>" method="post" name="<portlet:namespace />selectedOptionForm">
	<div class="row mt-2">
		<div class="col-sm-10">
			<aui:input type="text" label="" id="screenName" name="screenName" placeholder="Enter User Screen Name" />
		</div>
		<div class="col-sm-2">
			<aui:input type="button" label="" value="Search" id="search" onClick="searchUserByScreenName()" name="Search"/>
		</div>
	</div>
		<div class="row">
			<div class="col-sm-5 col-lg-5">
				<aui:select label="Regular Role" id="defaultRegularRole" name="defaultRegularRoleId" class="selectBox" multiple="true">
  					<c:forEach items="${regularRole}" var="role">
  						<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
					</c:forEach>
				</aui:select>
				<aui:select label="Organizational" id="defaultOrganizationRole" name="defaultOrganizationRoleId" class="selectBox" multiple="false" >
  					<c:forEach items="${organizationRole}" var="role">
  						<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
					</c:forEach>
				</aui:select>
				<aui:select label="Organizational Role" id="defaultOrganizationRole" name="defaultOrganizationRoleId" class="selectBox" multiple="true" >
  					<c:forEach items="${organizationRole}" var="role">
  						<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
					</c:forEach>
				</aui:select>
				<aui:select label="Site Role" id="defaultSiteRole" name="defaultSiteRoleId" class="selectBox"  multiple="true">	
  					<c:forEach items="${siteRole}" var="role">
  						<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
					</c:forEach>
				</aui:select>
				<aui:select  label="Unit Type Organization" id="defaultOrgnizationTypeUnit" name="defaultOrgnizationTypeUnitId" class="selectBox" multiple="true" >
  					<c:forEach items="${orgnizationTypeUnit}" var="organization">
  						<aui:option value="${organization.getOrganizationId()}">${organization.getName()}</aui:option>
					</c:forEach> 
				</aui:select>
			</div>
			<div class="col-sm-2 col-lg-2">
				<aui:input type="button" label="" id="add" onClick="add()" class="btn btn-primary" value="Add" name="add"/>
				<aui:input type="button" label="" id="remove" onClick="remove()" class="btn btn-primary" value="Remove" name="remove"/>
			</div>
			<div class="col-sm-5 col-lg-5">
					<aui:select label="Selected Regular Role" name="regularRoleId" id="selectedRegularRole" class="selectBox"  multiple="true" >
						<c:forEach items="${regularRolesSelected}" var="role">
  							<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
						</c:forEach>
					</aui:select>
					<aui:select label="Selected Organization Role" name="organizationRoleId" id="selectedOrganizationRole" class="selectBox" multiple="true">
						<c:forEach items="${organizationSelectedRoles}" var="role">
  							<aui:option value="${role.getRoleId()}">${role.getName()}</aui:option>
						</c:forEach>
					</aui:select>
					<aui:select label="Selected Site Role" name="siteRoleId"  id="selectedSiteRole" class="selectBox" multiple="true"></aui:select>
					<aui:select label="Selected Organization Type unit" name="organizationTypeUnitId"  id="selectedOrgnizationTypeUnit" class="selectBox" multiple="true"></aui:select>
			</div>
	</div>
	<aui:button-row>
			<aui:button type="submit" name="submit" id="submit"></aui:button>
		</aui:button-row>
</aui:form>

<script>

	function add() { 
	  	 $("#<portlet:namespace/>defaultRegularRole option:selected").remove().appendTo("#<portlet:namespace/>selectedRegularRole");
	  	 $("#<portlet:namespace/>defaultOrganizationRole option:selected").remove().appendTo("#<portlet:namespace/>selectedOrganizationRole");
	  	 $("#<portlet:namespace/>defaultSiteRole option:selected").remove().appendTo("#<portlet:namespace/>selectedSiteRole");
	  	 $("#<portlet:namespace/>defaultOrgnizationTypeUnit option:selected").remove().appendTo("#<portlet:namespace/>selectedOrgnizationTypeUnit");
		
	}

	 function remove(){  
		 $("#<portlet:namespace/>selectedRegularRole option:selected").remove().appendTo("#<portlet:namespace/>defaultRegularRole");
	  	 $("#<portlet:namespace/>selectedOrganizationRole option:selected").remove().appendTo("#<portlet:namespace/>defaultOrganizationRole");
	  	 $("#<portlet:namespace/>selectedSiteRole option:selected").remove().appendTo("#<portlet:namespace/>defaultSiteRole");
	  	 $("#<portlet:namespace/>selectedOrgnizationTypeUnit option:selected").remove().appendTo("#<portlet:namespace/>defaultOrgnizationTypeUnit");  
		
	 } 
	 
	 function searchUserByScreenName(){
		var screenName=$("#<portlet:namespace/>screenName").val();
		var url= "<%=applicationUserByScreenName%>&<portlet:namespace/>screenName="+screenName;
		window.location.href = url;
	 }
</script>