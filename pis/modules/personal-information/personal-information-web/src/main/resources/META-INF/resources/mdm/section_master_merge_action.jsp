<%@page import="java.util.List"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page
	import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%
	String formClass = ParamUtil.getString(request, "formClass");
	long formClassPK = ParamUtil.getLong(request, "formClassPK", 0);
	long id = ParamUtil.getLong(request, "id", 0);
	HtmlFormWrapper form = (HtmlFormWrapper) request.getAttribute(formClass);
	String dialogId = ParamUtil.getString(request, "dialogId");
	String closeFunc = ParamUtil.getString(request, "closeFunc");
	int processStatus = ParamUtil.getInteger(request, "status", 0);
	System.out.println("Inside the merge jsp"+formClassPK+id);
	OrganizationDetail organizationDetail = OrganizationDetailLocalServiceUtil
			.getOrganizationDetail(id);
	OrganizationDetail unit = OrganizationDetailLocalServiceUtil
			.getOrganizationDetail(organizationDetail.getParentId());
	List<Organization> organizationDetails = OrganizationDetailLocalServiceUtil
			.getOrganizationsByType("Section");
%>

<div class="container" style="margin-top: 25px;">
	<div class="row">
		<div class="col-xs-6 text-bold">Original Section</div>
		<div class="col-xs-6"><%=organizationDetail.getShortName()%></div>
	</div>
	<div class="row">
		<div class="col-xs-6 text-bold">Original Unit</div>
		<div class="col-xs-6"><%=unit.getShortName()%></div>
	</div>

	<aui:form>
		<div class="row">
			<div class="col-xs-6">
				<aui:input label="Merge Unit" type="text" name="mergeSection"
					class="form-control" id="mergeSection" readonly="true"
					value="<%=unit.getShortName()%>" />
			</div>
			<div class="col-xs-6">
				<aui:select label="Merge Section" class="form-control"
					name="merge_section" id="merge_section1">
					<%
									for (Organization organization : organizationDetails) {
								%>
					<aui:option value="<%=organization.getOrganizationId()%>"><%=organization.getName()%>

					</aui:option>
					<%
									}
								%>
				</aui:select>
			</div>

		</div>
		<aui:button-row>
			<aui:button type="submit" name="submit" id="submit"
				onClick="saveForm(); return false;"></aui:button>
		</aui:button-row>
	</aui:form>

</div>
<script type="text/javascript">
$(document).ready(function(){
	var unitId="<%=unit.getOrganizationId()%>";
	var sectionId="<%=organizationDetail.getOrganizationId()%>";
Liferay.Service(
		  '/mdm.organizationdetail/get-organizations-by-parent-id-and-type',
		  {
		    parentId: unitId,
		    type: 'Section'
		  },
		  function(obj) {
		    console.log(obj);
		    console.log(obj.length);
		    
		    for(var i=0;i<obj.length;i++){
		    
		    	if( obj[i].organizationId!=sectionId){
			    	optionText = obj[i].name;
		            optionValue = obj[i].organizationId;
		            $('#<portlet:namespace/>split_section').append(new Option(optionText, optionValue))
				  
			    }
		    }
		  }
		);
});

function saveForm(){
	
	var mergeSectionArray =document.getElementsByName("<portlet:namespace/>merge_section");
	var mergeSectionList=new Array();
	var id="<%=id%>";
	
	
	
	for(var i = 0 ; i < 1 ; i++){
		var verificationTypeId=mergeSectionArray[i].value;
		mergeSectionList.push(verificationTypeId);
	}
	
	Liferay.Service(
			  '/mdm.organizationhistory/save-split-organization-history',
			  {
			    organizationIds: mergeSectionList,
			    originalSectionId: id,
			    status: 'Initiate Merge'
			     
			  },
			  function(obj) {
			    console.log(obj);
			    var refresh=true;
			    Liferay.Service(
			    		  '/pis.employeeorganization/update-organization',
			    		  {
			    		    themeDisplay:themeDisplay ,
			    		    status: 'Initiate Merge',
			    		    organizationId:id 
			    		  },
			    		  function(obj) {
			    		    console.log(obj);
			    		    closeDialog('<%=dialogId%>', refresh);
			    		  }
			    		);
			    
			    
			  }
			  
			);
}

function closeDialog(dialogId, refresh){
	var message='Done';
	var data = {
		"dialogId" : dialogId,
		"refresh" : refresh,
		"message" : message
	};
	<%
	if(StringUtils.isNotBlank(closeFunc)){
		
%>	
alert(StringUtils.isNotBlank(closeFunc));
	Liferay.Util.getOpener().<%=closeFunc%>(data);
	<%
	}else{
%>	

Liferay.Util.getOpener().<portlet:namespace/>SectionForm_123456closeDialog(data);
<%
	}
%>	
}

</script>

