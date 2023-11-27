<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_002dstep_002dform_002dflow_jsp");%>
<%
	response.setHeader("Cache-Control", "max-age=0");

	String formClass = ParamUtil.getString(request, "formClass");
	String formFlowProcessId = ParamUtil.getString(request, "formClassPK", "0");
	int tabIndex = ParamUtil.getInteger(request, "tabIndex",0);
	String title = ParamUtil.getString(request, "title");
	String subTitle = ParamUtil.getString(request, "subTitle");
	String endTitle = ParamUtil.getString(request, "endTitle");
	String endSubTitle = ParamUtil.getString(request, "endSubTitle");
	if(formFlowProcessId==null || formFlowProcessId.equals("0")){	
		if(request.getAttribute("formFlowProcessId")!=null){
			formFlowProcessId=(String)request.getAttribute("formFlowProcessId");
		}
	}else{
		request.setAttribute("formFlowProcessId", formFlowProcessId);
	}

	LOGGER.info("formClass : "+formClass);
	//JetFormBuilderLocalService jetFormBuilderLocalService = (JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	HtmlFormWrapper form = JetFormBuilderLocalServiceUtil.getHtmlFormByClass(formClass);

	request.setAttribute("formFlow", form);
	request.setAttribute("includeScript", "no");

	HtmlFormWrapper processForm = null;
	int processFormIndex = 0;
%>
<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
		<div class="col-md-11 text-center p-0 mt-3 mb-2">
			<div class="card px-0 pt-4 pb-0 mt-3 mb-3" style="text-align: center;">
				<h2>
					<strong><%=title%></strong>
				</h2>
				<p><%=subTitle%></p>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div id="msform">
							<ul id="progressbar">
								<%
									int liIndex = 0;
									for (HtmlElementWrapper element : form.getElements()) {
										if(element.isKey()){
											continue;
										}
										String liClass = "";
										if (liIndex <= tabIndex) {
											liClass = "class=\"active\"";
										}
										
								%>
								<li <%=liClass%> id="li-tab<%=liIndex%>"><strong><%=element.getLabel()%></strong></li>
								<%
										liIndex++;
									}
								%>
								<li id="confirm"><strong>Finish</strong></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div class="card form-card" style="height: 400px; padding:30px;">
<%
							int liIndex = 0;
							for (HtmlElementWrapper element : form.getElements()) {
								if(element.isKey()){
									continue;
								}
								
							
%>						
							<liferay-util:include page="/components/list/form-add.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=element.getFormClass().getName()%>" />
<%--								<liferay-util:param name="top.header.template" value="/employee/list/employee_list_header.jsp" />
								<liferay-util:param name="top.action.template" value="/employee/list/employee_list_top_actions.jsp" />
								<liferay-util:param name="search.template" value="/employee/list/employee_list_search.jsp" />
								<liferay-util:param name="action.redirect.url" value="/employee/list/employee_list.jsp" />
								<liferay-util:param name="searchFilter[organizationId]" value="<%=organizationId%>" />
 --%>								
							</liferay-util:include>
										
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
						<%--@include file="/components/form/multi-step-next-prev.jsp"--%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

$(document).ready(function() {
<%--	
	//alert("Group Index : "+<%=groupIndex%>);
	$(".action-button-next").click(function(){	
		window.location.href='<%=transferProcessFormRenderURL.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex+1)%>';
	});
	try{
		$(".action-button-prev").click(function(){	
			window.location.href='<%=transferProcessFormRenderURL.toString()%>&<portlet:namespace/>groupIndex=<%=String.valueOf(groupIndex-1)%>';
		});
	}catch(e){}
--%>	
});
</script>
