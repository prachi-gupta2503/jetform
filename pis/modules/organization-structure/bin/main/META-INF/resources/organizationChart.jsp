<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONSerializer"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>

<%@page import="java.util.List"%>
    
<%@ include file="/init.jsp"%>
<style>
	.node{
		width:130px;
		height:100px;
	}
</style>

<%@ include file="/organizationUrl.jsp"%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<div class="page-header">
			<div class="row align-items-center">
				<div class="col">
					<h3 class="page-title">Organization</h3>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Master Data</a></li>
						<li class="breadcrumb-item active">Organization</li>
					</ul>
				</div>
			</div>
		</div>
	   <div id="orgChartContainer">
	      <div id="orgChart"></div>
	    </div>
    </div>
</div>
<%!
	JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
%>
<% 
	List<Organization> subOrganizations=OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	String testData= jsonSerializer.serialize(subOrganizations);
%>
 
<script type="text/javascript">
   
    $(function(){
    	orgChart = $('#orgChart').orgChart({
            data: <%=testData%>,
            showControls: false,
            allowEdit: false,
        });
    });
    
    
    function addOrganization(id,parentId){
    	 var url="<%=addOrganizationURL%>&<portlet:namespace />id="+id+"&<portlet:namespace />parentId="+parentId;
    	Liferay.Util.openWindow({
    	    dialog: {
    	        centered: true,
    	        height: 600,
    	        modal: true,
    	        width: 800,
    	        cssClass: "ui-model",
    	        destroyOnHide: true,
                resizable: false,
                
    	    },
    	    id: "<portlet:namespace />popUpId",
    	    title: "Add Organization",
    	    uri: url
    	}); 
    	  Liferay.provide(window, '<portlet:namespace />closePopup', function(popUpId , id) {
             Liferay.Util.Window.getById(popUpId).destroy();
             location.reload();
         },
         ['liferay-util-window']
         ); 
    	 
    	 
    }
    $(document).ready( function () {
    	closePopup();
    });

    function closePopup() {
		Liferay.Util.getOpener().<portlet:namespace/>closePopup(
				'<portlet:namespace />popUpId', '');
	}
    function deleteOrganization(organizationId){
    	Liferay.Service(
    			  '/organization/delete-organization',
    			  {
    			    organizationId: organizationId
    			  },
    			  function(obj) {
    			    location.reload();
    			  });
    }
    
    </script>
    <aui:script>
    Liferay.provide(window,'<portlet:namespace/>closeYourPopUp',
    	    function(data, dialogId) {
    	    <!-- alert("second"); -->
    		var A = AUI();
    		var dialog = Liferay.Util.Window.getById(dialogId);
    		dialog.destroy();
    	},
    	['liferay-util-window']
    );
    </aui:script>