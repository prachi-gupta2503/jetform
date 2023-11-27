<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlEventWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
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

<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%--script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>
<link href="<%=request.getContextPath()%>/css/select2.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>
<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/fonts/font-awesome/css/font-awesome.min.css"> --%>

<link href="<%=request.getContextPath()%>/css/multistep.form.css" rel="stylesheet" />
<%--<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/multistep.form.js"></script>
		

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.multi_002dstep_002dform_002dflow_jsp");
%>

<%
	response.setHeader("Cache-Control","max-age=0");

	String formClassesParam = ParamUtil.getString(request, "formClasses");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	String redirectPage = ParamUtil.getString(request, "redirectPage");
	String title=ParamUtil.getString(request, "title");
	String subTitle=ParamUtil.getString(request, "subTitle");
	
	String[] formClasses=formClassesParam.split(",");
	
	HtmlFormWrapper[] forms= new HtmlFormWrapper[formClasses.length];
	//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	
	int i=0;
	for(String formClass:formClasses){
		HtmlFormWrapper form = JetFormBuilderLocalServiceUtil.rendererForm(StringUtils.trim(formClass));
		/*if(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0")){
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass);
		}else{
			form=jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
		}*/
		forms[i++]=form;
	}
	
	//pageContext.setAttribute("htmlForm", form);
	//FormEntityCache.getFormClass(className)
%>
<div class="container-fluid" id="msform-main">
	<div class="row justify-content-center mt-0">
		<div class="col-md-11 text-center p-0 mt-3 mb-2">
			 <div class="card px-0 pt-4 pb-0 mt-3 mb-3" style="text-align:center;">
				<h2>
					<strong><%=title %></strong>
				</h2>
				<p><%=subTitle %></p>
				<div class="row">
					<div class="col-md-12 mx-0">
						<div id="msform">
							<ul id="progressbar">
<%
	i=0;
	for(HtmlFormWrapper form : forms){
		if(i==0){
%>
								<li class="active" id="<%=form.getFormClass().toLowerCase()%>"><strong><%=form.getTitle()%></strong></li>
<%
		}else{
%>
								<li id="<%=form.getFormClass().toLowerCase()%>"><strong><%=form.getTitle()%></strong></li>
<%		
		}
		i++;
	}
%>	
								<li id="confirm"><strong>Finish</strong></li>
							</ul>

<%
	i=1;
	for(HtmlFormWrapper form : forms){
		String formId="form".concat(String.valueOf(i));
		request.setAttribute(formId, form);
%>
							<fieldset id="<%=formId%>">
								<liferay-util:include page="/components/form/multi-step-form-add.jsp" servletContext="<%=application%>">
									<liferay-util:param name="formIndex" value="<%=String.valueOf(i)%>" />
									<liferay-util:param name="formId" value="<%=formId%>" />
									<liferay-util:param name="formClass" value="<%=form.getFormClass()%>" />
								</liferay-util:include>
							</fieldset>
<%	
		i++;
	}
%>	

							<fieldset id="form<%=i%>">
								<div class="form-card">
									<h2 class="fs-title text-center">Success !</h2>
									<br> <br>
									<div class="row justify-content-center">
										<div class="col-3 text-center">
											<i class="fa fa-check" aria-hidden="true"
												style="color: #fff; background-color: #4caf50; font-size: 50px; border: 5px solid #4caf50; border-radius: 50%;"></i>
										</div>
									</div>
									<div class="row justify-content-center">
										<div class="col-7 text-center">
											<h5>Joining details submitted successfully!</h5>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
