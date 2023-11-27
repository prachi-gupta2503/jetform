<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkAreaType"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkAreaTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.liferay.workarea.hierarchy.constants.MVCCommandNames"%>
<%@include file="/init.jsp"%>
<portlet:actionURL name="<%=MVCCommandNames.WORKAREA_ADD%>" var="createWorkAreaURL"/>
<%!
List<WorkArea> parentWorkAreaList = new ArrayList<WorkArea>();
List<WorkArea> subWorkArea=new ArrayList<WorkArea>();
%>
<%
	long workAreaId = ParamUtil.getLong(request, "workAreaId", 0);
	long parentId = ParamUtil.getLong(request, "parentId", 0);

	WorkArea workArea = null;
	WorkArea parentWorkArea = null;
	
	if (workAreaId > 0) {
		
		workArea = MDMUtils.getWorkAreaById(workAreaId);
	}
	if (parentId > 0 && workAreaId==0) {
		parentWorkArea = MDMUtils.getWorkAreaById(parentId);
		parentWorkAreaList.add(parentWorkArea);
	}
	else {	
		parentWorkAreaList =MDMUtils.getAllWorkAreas();  
	  List<WorkArea> wlist=WorkAreaLocalServiceUtil.getWorkAreaByParentId(workArea.getWorkAreaId());
         subWorkArea.addAll(wlist);
	    getSubWorkArea(wlist);	 
	  parentWorkAreaList = parentWorkAreaList.stream().filter(e -> !subWorkArea.contains(e)).collect(Collectors.toList()); 
	}

	List<WorkAreaType> workAreaTypeList = MDMUtils.getAllWorkAreaTypes();;
	%>
    <%! void getSubWorkArea(List<WorkArea> waList) {
	for (WorkArea wa : waList) {		
		List<WorkArea> list=WorkAreaLocalServiceUtil.getWorkAreaByParentId(wa.getWorkAreaId());		
		if (list.size() > 0) {			
			subWorkArea.addAll(list);
			 getSubWorkArea( list);	
		}
	}

}%> 


<div class="m-4">
	<aui:form action="<%=createWorkAreaURL %>" name="<portlet:namespace />fm">
		<div class="form-group-item">
			<aui:input name="workAreaId" id="workAreaId" type="hidden" value="<%=workAreaId%>" />
		</div>

		<div class="form-group-item m-2">
			<aui:input label="Name" name="name" id="name" type="text" value="<%=workArea == null ? "" : workArea.getName()%>" required="true" />
		</div>

		<div class="form-group-item m-2">
			<aui:select class="form-control" name="workAreaTypeId" required="true" label="WorkArea Type">
				<!-- <option value="0">select parent organization</option> -->
		<%
			for (WorkAreaType data : workAreaTypeList) {
				boolean selected=false;
				if(workArea!=null && data.getWorkAreaTypeId()==workArea.getWorkAreaTypeId()){
					selected=true;
				}
		%>
				<aui:option value="<%=data.getWorkAreaTypeId()%>" selected="<%=selected%>"><%=data.getName()%></aui:option>
		<%
			}
		%>
			</aui:select>
		</div>

		<div class="form-group-item m-2">
			<aui:select class="form-control" name="parentId" label="Parent WorkArea" required="true">
		<%
			for (WorkArea pwa : parentWorkAreaList) {
				
				//The same workArea self can be shown in the parent List
				if(workArea!=null && pwa.getWorkAreaId()==workArea.getWorkAreaId()){
					continue;
				}
				
				//The children of same workArea can be shown in the parent List
				if(workArea!=null && pwa.getWorkAreaId()==workArea.getWorkAreaId()){
					continue;
				}
				
				
				boolean selected=false;
				if(workArea!=null && pwa.getWorkAreaId()==workArea.getWorkAreaId()){
					selected=true;
				}
				
				if(workArea==null && pwa.getWorkAreaId()==parentId){
					selected=true;
				}
				if(workArea!=null && pwa.getWorkAreaId()==workArea.getParentWorkAreaId() ){
					selected=true;
				}
				
				
		%>
				<aui:option value="<%=pwa.getWorkAreaId()%>" selected="<%=selected%>"> <%=pwa.getName()%></aui:option>
		<%
			}
		%>
			</aui:select>
		</div>

		<div class="btn-group mt-2 mb-2" style="margin-left: 5px;">
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-sm btn-primary rounded-0" id="addbtn" name="addbtn" type="submit"></aui:button>
			</div>
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-sm btn-dark rounded-0" id="close"  name="<portlet:namespace/>close" value="Close"></aui:button>
			</div>
		</div>

	</aui:form>
</div>
<aui:script use="aui-base">
A.one('#<portlet:namespace/>close').on('click', function(event) {
	Liferay.Util.getOpener().<portlet:namespace/>closePopUp('<portlet:namespace/>dialogId');
});
</aui:script>