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
	System.out.println("Inside the split jsp"+formClassPK+id);
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

	<div class="row">

		<div class="col-md-12 text-right">
			<button type="button" class="btn btn-primary" id="verBtnAdd">Add</button>
			<aui:form>
				<table id="splitSetionTable">
					<tbody id="splitSetionTableBody">
						<tr class="row">
						<td class="col-xs-6"><aui:input label="Split Unit" type="text"
									name="splitUnit" class="form-control" id="splitUnit1" readonly="true" value="<%=unit.getShortName()%>" /></td>
							<td class="col-xs-6"><aui:select label="Split Section" class="form-control"
									name="split_section" id="split_section">
									<%-- <%
									for (Organization organization : organizationDetails) {
								%>
									<aui:option value="<%=organization.getOrganizationId()%>"><%=organization.getName()%>

									</aui:option>
									<%
									}
								%> --%>
								</aui:select></td>
							
						</tr>
					</tbody>
				</table>
				
				<aui:button-row>
				<aui:button type="submit" name="submit" id="submit" onClick="saveForm(); return false;"></aui:button>
			</aui:button-row>
			</aui:form>
		</div>
	</div>
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

var iCnt = 1;
var verificatonList=new Array();

$('#verBtnAdd').click(function() {

	addMoreVerificaton();
});


$("#splitSetionTable").on('click', '#btnRemove', function () {
	$(this).closest('tbody').remove();
	$('#verBtnAdd').attr('disabled', false);
	iCnt=iCnt-1;
});

function addMoreVerificaton(){
	
	iCnt = iCnt + 1;
	if (iCnt <= 4) {
		var markup="<td class='col-xs-4'><button type='button' class='btn btn-secondary' id='btnRemove' name='btnRemove'> Remove <button/><td>";	
		var cloneData = $('#splitSetionTableBody').clone();
		/* cloneData.find("input").val(''); */
		/* cloneData.find('#<portlet:namespace/>verification_Document1').prop("id","verification_Document"+iCnt); */
		cloneData.append(markup);
		$('#splitSetionTable').append(cloneData);
		if(iCnt==4){
			$('#verBtnAdd').attr('disabled', true);
		}
	}
	
	
}

function saveForm(){
	
	var splitSectionArray =document.getElementsByName("<portlet:namespace/>split_section");
	var splitSectionList=new Array();
	var id="<%=id%>";
	for(var i = 0 ; i < iCnt ; i++){
		var mergeSectionId=splitSectionArray[i].value;
		splitSectionList.push(mergeSectionId);
	}
	
	Liferay.Service(
			  '/mdm.organizationhistory/save-split-organization-history',
			  {
			    organizationIds: splitSectionList,
			    originalSectionId: id,
			    status: 'Initiate Split'
			  },
			  function(obj) {
			    console.log(obj);
			    var refresh=true;
			    Liferay.Service(
			    		  '/pis.employeeorganization/update-organization',
			    		  {
			    		    themeDisplay:themeDisplay ,
			    		    status: 'Initiate Split',
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
	var message='Done'
	var data = {
		"dialogId" : dialogId,
		"refresh" : refresh,
		"message" : message
	};
	<%
	if(StringUtils.isNotBlank(closeFunc)){
%>	
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
