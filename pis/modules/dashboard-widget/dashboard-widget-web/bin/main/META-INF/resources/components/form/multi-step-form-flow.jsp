<%@page import="java.util.List"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%-- <%@page import="com.adjecti.pis.liferay.form.TransferProcessFlow"%> --%>
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
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_002dstep_002dform_002dflow_jsp");
%>

<%
	response.setHeader("Cache-Control", "max-age=0");

	int tabIndex = ParamUtil.getInteger(request, "tabIndex",0);
	String title = ParamUtil.getString(request, "title");
	String subTitle = ParamUtil.getString(request, "subTitle");
	String endTitle = ParamUtil.getString(request, "endTitle");
	String endSubTitle = ParamUtil.getString(request, "endSubTitle");
	
	//String finishPage = ParamUtil.getString(request, "finishPage");
	
	String formFlowClass = ParamUtil.getString(request, "formFlowClass");
	long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);

	HtmlFormWrapper formFlow = JetFormBuilderLocalServiceUtil.getHtmlFormByClass(formFlowClass);

	request.setAttribute("flowFormId", formFlow.getId());
	request.setAttribute(formFlow.getId(), formFlow);
	request.setAttribute("includeScript", "no");

	HtmlFormWrapper processForm = null;
	int processFormIndex = 0;
	
	int liIndex = 0;
	
	HtmlElementWrapper element=null;
	for (HtmlElementWrapper e : formFlow.getElements()) {
		if(e.isKey()){
			continue;
		}
		if(liIndex==tabIndex){
			element=e;
			//Do not break as liIndex is used for styling
		}
		liIndex++;
	}
	
	String tabWidth="";
					
	if(liIndex>=10){
		tabWidth="10%";
	}else{
		tabWidth=Math.round(100/(liIndex+1))+"%";
	}
	
	if(element!=null){
		request.setAttribute("formFlowElement", element);
	}
	

	boolean viewOnlyMode= false;
	if(ParamUtil.getString(request, "viewOnlyMode")!=null){
		viewOnlyMode=ParamUtil.getBoolean(request, "viewOnlyMode");
	}
	
	request.setAttribute("viewOnlyMode", viewOnlyMode);
	//LOGGER.info("formClass : "+formFlowClass+", formFlowClassPK : "+formFlowClassPK+", tabIndex : "+tabIndex);

	//LOGGER.info("===========================liIndex : "+liIndex);
	
%>	

<style>
<!--
.flow-tab.current .fas {
    padding: 10px 10px 10px 10px;
    border: 1px solid #00c5fb;
    font-size: 24px;
    color: #fff;
    border-radius: 22px;
    background: #00c5fb;
}

.flow-tab .fas {
    padding: 10px 10px 10px 10px;
    border: 1px solid #cdced9;
    font-size: 24px;
    color: #616274;
    border-radius: 22px;
    background: #cdced9;
}

.flow-tab.active .fas:hover{
	background: #00c5fb;
	border: 1px solid #00c5fb;
	color: #fff;
}
#progressbar li{
	width: <%=tabWidth%> !important;
}

#progressbar{
	margin-left:10px;
	margin-right:10px;
}

.container-peopleform_123456 .form-group-appellationid{
	position: absolute !important;
	bottom: 0px !important;
}
-->
</style>
<portlet:renderURL var="tabItemURL" >
	<portlet:param name="formFlowClass" value="<%=formFlowClass%>" />
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
</portlet:renderURL>

<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
<%--	<div class="col-md-11 text-center p-0 mt-3 mb-2"> --%>
		<div class="col-md-11">
<%--			<div class="card px-0 pt-4 pb-0 mt-3 mb-3" style="text-align: center;"> --%>
			<div class="card">
				 <div class="row">
					<div class="col-md-12 px-0 pt-4 pb-0 mt-3 mb-3" style="text-align: center;">
						<h2>
							<strong><%=title%></strong>
						</h2>
						<p><%=subTitle%></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div id="msform" style="text-align: center;">
							<ul id="progressbar">
						<%
							liIndex=0;
							int linkableCount=0;
							for (HtmlElementWrapper e : formFlow.getElements()) {
								if(e.isKey()){
									continue;
								}
								String liClass = "";
								if (liIndex == tabIndex) {
									liClass = "current";
								}
								boolean linkable=false;
								if(formFlowClassPK>0){
									if(e.isControlType(HtmlElement.ControlType.form) || e.isControlType(HtmlElement.ControlType.list)){
										//LOGGER.info(e.getFormClass());
										HtmlFormWrapper liForm = JetFormBuilderLocalServiceUtil.getHtmlFormByClass(e.getFormClass());
										List<Object> liResults=JetFormBuilderLocalServiceUtil.findAll(liForm.getEntityClass(), liForm.getFormFlowKeyElement().getName(), String.valueOf(formFlowClassPK));
										if(CollectionUtils.isNotEmpty(liResults)){
											linkable=true;
											linkableCount++;
										}
									}
								}
								if(linkable){
									liClass=(StringUtils.isBlank(liClass)? "active":liClass);
						%>
								<li class="flow-tab <%=liClass%>" id="li-tab<%=liIndex%>"><a href="<%=tabItemURL.toString()%>&<portlet:namespace/>formFlowClassPK=<%=formFlowClassPK%>&<portlet:namespace/>tabIndex=<%=liIndex%>"><%=e.getLabel()%></a></li>
						<%
								}else{
						%>
								<li class="flow-tab <%=liClass%>" id="li-tab<%=liIndex%>"><%=e.getLabel()%></li>
						<%									
								}
								liIndex++;
							}
						%>
								<%--li id="confirm"><strong>Finish</strong></li>
								<li class="flow-tab <%=(tabIndex == liIndex )?"active":"" %>" id="li-tab<%=liIndex%>"><i class="fas fa-circle"></i><p>Finish</p></li>
								--%>								 
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mx-0">
<%--
					if(tabIndex == liIndex ){
%>
						<liferay-util:include page="<%=finishPage%>" servletContext="<%=application%>">
						</liferay-util:include>						
<%						
					}else
--%>

<%						
				LOGGER.info("Multi step form flow - tabIndex : "+tabIndex+", liIndex : "+liIndex+", linkableCount : "+linkableCount);
					
					if(element.isControlType(HtmlElement.ControlType.form)){
						String template="/components/form/multi-step-form-add.jsp";
						if(StringUtils.isNotBlank(element.getCustomTemplate())){
							template=element.getCustomTemplate();
						}
%>						
						<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
<%
						if(StringUtils.isBlank(element.getCustomTemplate())){
%>						
							<liferay-util:param name="formClass" value="<%=element.getFormClass().getName()%>" />
<%
						}
%>							
						</liferay-util:include>
<%
					}else if(element.isControlType(HtmlElement.ControlType.list)){
						String template="/components/list/form-flow-child-list-restful.jsp";
						if(StringUtils.isNotBlank(element.getCustomTemplate())){
							template=element.getCustomTemplate();
						}
%>					
						<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
<%
						if(StringUtils.isBlank(element.getCustomTemplate())){
%>								
							<liferay-util:param name="formClass" value="<%=element.getFormClass().getName()%>" />
							<liferay-util:param name="dialogMode" value="true" />
<%
						}
%>							
						</liferay-util:include>	
<%
					}
%>
					</div>
				</div>
<%				
			if(tabIndex < liIndex-1 ){	
%>
				<div class="row">
					<div class="col-md-12 mx-0">
						<liferay-util:include page="/components/form/multi-step-next-prev.jsp" servletContext="<%=application%>" />
					</div>
				</div>
<%
			}
%>				
			</div>
		</div>
	</div>
</div>
<%
if(tabIndex < liIndex-1 ){
	if(element.isControlType(HtmlElement.ControlType.list)){
%>
	<liferay-util:include page="/components/form/multi-step-form-list-script-elements.jsp" servletContext="<%=application%>" />
<%
	}
}
%>
<%--
else if(element.isControlType(HtmlElement.ControlType.form)){
	<liferay-util:include page="/components/form/multi-step-form-script-elements.jsp" servletContext="<%=application%>" />
<%	
	}
}
--%>
<%--
<script>

$(document).ready(function() {
	
	alert("Group Index : "+<%=tabIndex%>);
	$(".action-button-next").click(function(){	
		window.location.href='<%=nextPrevUrl.toString()%>';
	});
	try{
		$(".action-button-prev").click(function(){	
			window.location.href='<%=nextPrevUrl.toString()%>';
		});
	}catch(e){}
	
});
</script>
--%>