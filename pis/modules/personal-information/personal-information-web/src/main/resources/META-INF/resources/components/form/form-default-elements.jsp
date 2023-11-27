<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.common.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="java.util.Random"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

<%@ include file="/init.jsp"%>

<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.form_default_elements.jsp");
%>

<%
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

int childFormCount=0;

if(request.getAttribute("childFormCount")!=null){
	childFormCount=(Integer)request.getAttribute("childFormCount");
}
boolean childForm=false;
String formId=(String)request.getAttribute("childFormId");
if(StringUtils.isBlank(formId)){
	formId=(String)request.getAttribute("formId");
}else{
	childForm=true;
}

String childFormNamespace="";
if(childForm){
	childFormNamespace=(String)request.getAttribute("childFormNamespace");
}

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

boolean editMode=(form.getEntity()!=null && form.getPrimaryKey()!=null);

if(form.getElements().size()>0){
	
//LOGGER.info("form.getElementsPerRow() =========================================== "+form.getElementsPerRow());
	String elementColClass=elementColClass="col-md-"+(12/form.getElementsPerRow());

	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	Class formClazz=FormEntityCache.getFormClass(form.getFormClass());
	Class entityClazz=FormEntityCache.getFormClass(form.getEntityClass());

	if(entityClazz==Object.class){
		entityClazz=formClazz;
	}
	ExpandoBridge expandoBridge=(ExpandoBridge)request.getAttribute(form.getId()+"expandoBridge");
%>
	<div class="row">
<%	
	for (HtmlElementWrapper e : form.getElements()) {
		
		/** This to check if the field values are set in paramater 
		 ** and element is set as hidden **/
		 
		String presetFieldValue  = ParamUtil.getString(request, e.getName());
		String presetHiddenField = ParamUtil.getString(request, e.getName()+".hidden");
		
		request.setAttribute(childFormNamespace+"htmlElement_"+e.getName(), e);
		request.setAttribute(childFormNamespace+"elementName", e.getName());
		
		String value=e.getValue();
		if(editMode){
			try{
				Method m=null;
				String methodName=null;
		 if(!e.getName().startsWith("expando_")){		
				if(e.isControlType(HtmlElement.ControlType.form) && e.isValidFormClass()){
					methodName="get"+StringUtils.capitalize(e.getMappingField());
				}else{
					methodName="get"+StringUtils.capitalize(e.getAttribute());
				}
				m=entityClazz.getMethod(methodName, blankTypes);
				if(m.getReturnType() == Date.class || e.isControlType(HtmlElement.ControlType.date)){
					Object dateValue=m.invoke(form.getEntity(), blankParams);
					if(dateValue!=null){
						value=DateUtils.format((Date)dateValue, "yyyy-MM-dd");
					}
				}else{
					value=String.valueOf(m.invoke(form.getEntity(), blankParams));
				}
		 }else{
			 	String expName=e.getName().substring("expando_".length());
			  	value=String.valueOf(expandoBridge.getAttribute(expName));
			  
		 }
			}catch(Exception ex){}
		}
		if(StringUtils.isNotBlank(presetFieldValue)){
			value=presetFieldValue;
		}
		
		request.setAttribute(childFormNamespace+e.getName()+"_savedValue", value);
		
		//LOGGER.info("childFormNamespace: "+childFormNamespace+", e.getName() : "+e.getName()+", e.getControlType(): "+e.getControlType()+", value :"+value);
		
		boolean isPresetHidden=(StringUtils.equalsIgnoreCase(presetHiddenField, "true") || StringUtils.equalsIgnoreCase(presetHiddenField, "yes"));
		
		if(e.isControlType(HtmlElement.ControlType.hidden) || e.isControlType(HtmlElement.ControlType.list) || isPresetHidden){
			continue;
		}
		
		String template=e.getCustomTemplate();
%>
			<div class="<%=elementColClass%> <%="col-"+e.getName().toLowerCase()%>">
				<div class="form-group-autofit <%="form-group-"+e.getName().toLowerCase()%>">
					<div class="form-group-item <%="form-item-"+e.getName().toLowerCase()%> <%=e.isRequired()?"required":""%>">
<%
		//Disabling labels for checkbox 
		//LOGGER.info("Disabling labels for checkbox "+e.isControlType(HtmlElement.ControlType.checkbox)+", "+CollectionUtils.isEmpty(e.getListOptions()));
		if(!(e.isControlType(HtmlElement.ControlType.checkbox) && CollectionUtils.isEmpty(e.getListOptions()))){					
%>						
				<label class="control-label <%="label-"+e.getName().toLowerCase()%>" for="<%=e.getName()%>"><%=e.getLabel()%></label>
<%
		}

		if(e.isControlType(HtmlElement.ControlType.select) || e.isControlType(HtmlElement.ControlType.multiSelect)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/select-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.country)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/country-select.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/checkbox-radio-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>			
<%
		}else if(e.isControlType(HtmlElement.ControlType.datetime)  || e.isControlType(HtmlElement.ControlType.date)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/datetime-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.email)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/email-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUpload)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-upload-element.jsp";
			}
%>	
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.fileDragDrop)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-dragdrop-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileBrowser)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-browser-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileScan)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-scanner-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScan)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-adder-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.textEditor)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/editor-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.number)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/number-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.phone)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/phone-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.text) || e.isControlType(HtmlElement.ControlType.textarea)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/text-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.currentYear)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/current-year-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.year)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/year-select-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScanView)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/document-adder-viewer-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.form)){
			
			childFormCount++;
			
			if(StringUtils.isEmpty(template)){
				template="/components/form/form-element.jsp";
			}
%>
			<aui:input type="hidden" name="<%="childForm_"+e.getName()%>" value="<%=e.getName()%>"/>
			
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="childFormClass" value="<%=e.getFormClass()%>" />
				<liferay-util:param name="childFormClassPK" value="<%=value%>" />
				<liferay-util:param name="childFormNamespace" value="<%=e.getName()+"_"%>" />
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
			}else if(e.isControlType(HtmlElement.ControlType.paragraph)){
			
			
			if(StringUtils.isEmpty(template)){
				template="/components/form/paragraph-element.jsp";
			}
%>			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="<%=childFormNamespace+"elementName"%>" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
         } 
%>
				</div>
			</div>
		</div>
<%		
	}
%>
	</div>
<%
	request.setAttribute("childFormCount", childFormCount);
}
%>
