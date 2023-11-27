<%@page import="com.adjecti.jetform.list.model.FieldDef"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.adjecti.jetform.liferay.util.DataListUtils"%>
<%@page import="com.adjecti.jetform.list.model.ListDef"%>
<%@page import="com.adjecti.jetform.list.model.ListConfig"%>
<%@page import="com.adjecti.jetform.list.model.ActionControl"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp"%>

<%
DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy hh:mm a");
ListConfig listConfig = ListConfig.getInstance();

String listConfigKey=(String)request.getAttribute("listConfig");
String assetType=(String)request.getAttribute("assetType");

if(listConfigKey==null){
	listConfigKey=ParamUtil.get(request,"listConfig", "select-employee-list");
}

/*if(assetType==null){
	assetType=ParamUtil.get(request,"assetType", "employee");
}*/

ListDef listDef = listConfig.getListDefinition("config/list/" + listConfigKey);

Class entityClass=ClassUtils.getClass(listDef.getObjectClass());

ThemeDisplay themeDisplay =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

List list=DataListUtils.getListItem(entityClass, themeDisplay.getCompanyId(), themeDisplay.getUserId());

if(list==null){
	list=new ArrayList();
}
listDef.setDataList(list);

%>

	<table id="dataTable" class="display table-striped" style="width: 100%;">
		<thead class="toobar-background">
			<tr>
<%
			if(listDef.isRowIndex()){
%>
				<th>#</th>
<%
			}
			for(FieldDef field:listDef.getFields()){		
%>
				<th><%=field.getLabel()%></th>
<%
			}
%>
			</tr>
		</thead>
		<tbody>
<%
if(listDef.getDataList()!=null && !listDef.getDataList().isEmpty()){
	Class clazz=listDef.getDataList().get(0).getClass();
	Map<String, Method> methods=new HashMap<String, Method>();
	int i=1;
	for(Object item:listDef.getDataList()){
%>
			<tr>
<%
			if(listDef.isRowIndex()){
%>
				<td><%=i++%></td>
<%
			}
			for(FieldDef field:listDef.getFields()){
			
				String value="";
				Method method=null;
				try{
					if(StringUtils.isNotEmpty(field.getName())){
						method=methods.get(field.getName());
						if(method==null){
							if(StringUtils.isNotEmpty(field.getData())){
								method=ReflectionUtil.getAccessorMethodByFieldName(clazz, field.getData());
								methods.put(field.getName(), method);
							}
						}
					}
					if(method!=null){
						Object objValue=method.invoke(item, new Object[]{});
					
						if(objValue!=null){
							if(objValue.getClass()==Date.class){
								value=dateFormat.format((Date)objValue);
							}else{
								value=String.valueOf(objValue);
							}	
						}
					}
				}catch(Exception e){}
%>
				<td>
<%					
				if(field.getControls()==null || field.getControls().size()==0){	
%> 
					<%=value %> 
<%
				}else if(field.getControls().size()>0){
					for(ActionControl control:field.getControls()){
						String caption=ReflectionUtil.getParameterizedString(control.getCaption(), item);
						String eventAction=ReflectionUtil.getParameterizedString(control.getEventAction(), item);
						boolean isEnabled=ReflectionUtil.evaluateToBoolean(control.getEnable(), item, true);
						boolean isVisible=ReflectionUtil.evaluateToBoolean(control.getVisible(), item, true);
						if(!isVisible){
							continue;
						}
						
						if("button".equalsIgnoreCase(control.getType())){
%>
							<button class="btn-primary" name="<%=control.getName()%>" id="" <%=control.getCss()%> <%=control.getEvent()%>="<%=eventAction%>" <%=(!isEnabled?"disabled":"")%>><%=caption%></button> <%
						}else if("tool-button".equalsIgnoreCase(control.getType())){
%>
							<button <%=control.getEvent()%>="<%=eventAction%>" title="<%=caption%>" class="btn-primary" <%=(!isEnabled?"disabled":"")%>>
								<i class="<%=control.getIcon()%>"></i>
							</button> <%						
						}else if("link".equalsIgnoreCase(control.getType())){
							String hrefAction="javascript:void(0)";
							if("href".equalsIgnoreCase(control.getEvent())){
								hrefAction=eventAction;
%> 
								<a href="<%=hrefAction %>" id="" <%=control.getCss()%> <%=(!isEnabled?"disabled":"")%>><%=caption%></a> 
<%
							}else{
%> 
								<a href="<%=hrefAction %>" id=" " <%=control.getCss()%> <%=control.getEvent()%>="<%=eventAction%>" <%=(!isEnabled?"disabled":"")%>><%=caption%></a> 
<%						
							}					
						}else if("checkbox".equalsIgnoreCase(control.getType())){
%> 
							<input type="checkbox" id=" " <%=control.getCss()%> <%=control.getEvent()%>="<%=eventAction%>" <%=(!isEnabled?"disabled":"")%>><%=caption%> 
<%						
						}else if("radio".equalsIgnoreCase(control.getType())){
						
%>
							<div class="radio">
								<label class="radio-inline"> <input type="radio" id=" " <%=control.getCss()%> <%=control.getEvent()%>="<%=eventAction%>" <%=(!isEnabled?"disabled":"")%>><%=caption%></label>
							</div> 
<%						
						}else if("text".equalsIgnoreCase(control.getType())){
%>
							<div>
								<input type="text" id=" " <%=control.getCss()%> <%=control.getEvent()%>="<%=eventAction%>" value="<%=value%>" place-holder="<%=field.getLabel()%>" <%=(!isEnabled?"disabled":"")%>>
							</div> 
<%
						}
%> 
						&nbsp; 
<%						
					}
				}
%>
				</td>
<%
			}
%>
			</tr>
<%
		}
	}
%>
		</tbody>
	</table>
		


<script type="text/javascript">
//<![CDATA[
	
	$(document).ready(function() {
		var table= $('#dataTable').DataTable();
	});
	
<%--	function editFile(id){
		//alert("id : "+id);
		var url="<%=editFileURL%>&<portlet:namespace/>processFileId="+id+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function openFile(movementId){
		var url="<%=whiteWallRenderURL%>&<portlet:namespace/>movementId="+movementId;
		location.href=url;
	}
	
	function createNote(movementId){
		var url="<%=createNoteURL%>&<portlet:namespace/>movementId="+movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function sendFile(movementId){
		var url="<%=sendFileURL%>&<portlet:namespace/>movementId="+movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		Liferay.Util.openWindow({
		    dialog: {
		        centered: true,
		        height: 600,
		        modal: true,
		        width: 800,
		        cssClass: "ui-model",
		        destroyOnHide: true,
                resizable: false
		    },
		    id: '<portlet:namespace />dialog',
		    title: '<liferay-ui:message key="Movement" />',
		    uri: url
		});
		//location.href=url;
	}
	
	function attachReceipt(movementId) {
		var url="<%=attachReceiptURL%>&<portlet:namespace/>movementId="+movementId;
		Liferay.Util.openWindow({
		    dialog: {
		        centered: true,
		        height: 500,
		        modal: true,
		        width: 500,
		        cssClass: "ui-model",
		        destroyOnHide: true,
                resizable: false
		    },
		    id: '<portlet:namespace />dialog',
		    title: '<liferay-ui:message key="Add Attachment" />',
		    uri: url
		});
		//location.href=url;
	}
	function <portlet:namespace/>closePopup(data,dialogId){ 
		console.log("closePopup called");
		var dialog = Liferay.Util.Window.getById(dialogId);
		dialog.destroy();
		location.reload();
	}
	function editReceipt(id){
		var url="<%=editReceiptURL%>&<portlet:namespace/>receiptId="+id+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function closeReceipt(movementId){
		//alert("closeReceipt Id :"+id);
		let url = "<%=createClosedFileRecordDetailUrl%>&<portlet:namespace/>movementId=" + movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function sendReceipt(movementId){
		var url="<%=sendReceiptURL%>&<portlet:namespace/>movementId="+movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function closeFile(movementId) {
		let url = "<%=createClosedFileRecordDetailUrl%>&<portlet:namespace/>movementId=" + movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function listRecordDetails(){
		let url = "<%=listClosedRecordDetailUrl%>";
		location.href=url;
	}
	
	function editDraft(id){
		//alert("Edit draft : "+id);
		var url="<%=editDraftURL%>&<portlet:namespace/>draftId="+id+"&<portlet:namespace/>listConfig=<%= listConfigKey %>";
		location.href=url;
	}
	
	function dispatchDraft(movementId){
		var url="<%=sendFileURL%>&<portlet:namespace/>movementId="+movementId+"&<portlet:namespace/>listConfig=<%= listConfigKey %>&<portlet:namespace/>movementType=Dispatch";
			Liferay.Util.openWindow({
			    dialog: {
			        centered: true,
			        height: 600,
			        modal: true,
			        width: 800,
			        cssClass: "ui-model",
			        destroyOnHide: true,
	                resizable: false
			    },
			    id: '<portlet:namespace />dialog',
			    title: '<liferay-ui:message key="Dispatch" />',
			    uri: url
			});
			//location.href=url;
		}
	
	
	function sendDispatch(id){
		let url = "<%=sendDispatchURL%>&<portlet:namespace/>id=" + id;
		location.href=url;
	}
	

	function pullbackFile(movementId)
	{
		 var url="<%=pullback%>&<portlet:namespace/>movementId=" + movementId+"&<portlet:namespace/>pullbackType=file";
		 location.href=url;
		
		
	}
	function pullbackReceipt(movementId)
	{
		 var url="<%=pullback%>&<portlet:namespace/>movementId=" + movementId+"&<portlet:namespace/>pullbackType=receipt";
		 location.href=url;
		
		
	}
	function pullbackDraft(movementId)
	{
		 var url="<%=pullback%>&<portlet:namespace/>movementId=" + movementId+"&<portlet:namespace/>pullbackType=draft";
		 location.href=url;
		
		
	}
	
	function movementSummary(movementId){
		alert("movement Id : "+movementId)
		var url="<%=movementSummaryURL%>
	&<portlet:namespace/>movementId="
				+ movementId;
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 600,
				modal : true,
				width : 800,
				cssClass : "ui-model",
				destroyOnHide : true,
				resizable : false
			},
			id : '<portlet:namespace />dialog',
			title : '<liferay-ui:message key="Movement Summary" />',
			uri : url
		});
	}
--%>
	//]]>
</script>

<style>
.ui-model .modal-header {
	background: #336cbd;
	color: #fff;
}

.ui-model .close {
	color: #fff;
}
</style>