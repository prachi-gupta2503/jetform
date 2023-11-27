<%@page import="com.adjecti.common.util.DateUtils"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroup"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
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

<%
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

int childFormCount=0;
if(request.getAttribute("childFormCount")!=null){
	childFormCount=(Integer)request.getAttribute("childFormCount");
}
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

boolean editMode=(form.getEntity()!=null && form.getPrimaryKey()!=null);
	
if(CollectionUtils.isNotEmpty(form.getElementGroups())){
	Class[] blankTypes=new Class[]{};
	Object[] blankParams=new Object[] {};
	Class formClazz=form.getFormClass();
	Class entityClazz=form.getEntityClass();

	if(entityClazz==Object.class){
		entityClazz=formClazz;
	}
	
	for(HtmlElementGroupWrapper group: form.getElementGroups()){
		
		int elementsPerRow = (group.getElementsPerRow()>1? group.getElementsPerRow(): form.getElementsPerRow());

		String elementColClass="col-md-"+(12/elementsPerRow);
		
		//LOGGER.info("form-group-elements.jsp : elementsPerRow : "+elementsPerRow+", elementColClass: "+elementColClass);
%>

	<div class="row">

<%	
	for (HtmlElementWrapper e : group.getElements()) {
		//LOGGER.info(e.getName()+" - "+e.isTransientElement()+" - "+e.getControlType());
		if(e.isTransientElement()){
			continue;
		}
		/** This to check if the field values are set in paramater 
		 ** and element is set as hidden **/
		 
		String presetFieldValue  = ParamUtil.getString(request, e.getName());
		String presetHiddenField = ParamUtil.getString(request, e.getName()+".hidden");
		
		pageContext.setAttribute("htmlElement", e);
		request.setAttribute("htmlElement_"+e.getName(), e);
		request.setAttribute("elementName", e.getName());
		
		String value="";
		if(editMode){
			try{
				Method m=null;
				String methodName=null;
				if(e.isControlType(HtmlElement.ControlType.form) && e.getFormClass()!=null){
					methodName="get"+StringUtils.capitalize(e.getMappingField());
				}else{
					methodName="get"+StringUtils.capitalize(e.getAttribute());
				}
				m=entityClazz.getMethod(methodName, blankTypes);
				if(m.getReturnType() == Date.class && e.isControlType(HtmlElement.ControlType.date)){
					Object dateValue=m.invoke(form.getEntity(), blankParams);
					value=DateUtils.format((Date)dateValue, "yyyy-MM-dd");
					//pageContext.setAttribute(e.getName()+"_savedValue", dateValue);
					//request.setAttribute(e.getName()+"_savedValue", dateValue);
					//value=String.valueOf(dateValue);
				}else{
					value=String.valueOf(m.invoke(form.getEntity(), blankParams));
					//pageContext.setAttribute(e.getName()+"_savedValue", value);
					
				}
				request.setAttribute(e.getName()+"_savedValue", value);
				//e.setValue(value);
				
			}catch(Exception ex){}
		}
		if((StringUtils.isEmpty(value) || value.trim().equals("0") || value.trim().equals("null"))  && StringUtils.isNotEmpty(presetFieldValue)){
			value=presetFieldValue;
			//pageContext.setAttribute(e.getName()+"_savedValue", value);
			request.setAttribute(e.getName()+"_savedValue", value);
			
		}
		//LOGGER.info(e.getName()+" - "+e.isTransientElement()+" - "+e.getControlType()+" - "+value);
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
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.country)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/country-select.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.checkbox) || e.isControlType(HtmlElement.ControlType.radio)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/checkbox-radio-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>			
<%
		}else if(e.isControlType(HtmlElement.ControlType.datetime)  || e.isControlType(HtmlElement.ControlType.date)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/datetime-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.email)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/email-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUpload)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-upload-element.jsp";
			}
%>	
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.fileDragDrop)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-dragdrop-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileBrowser)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-browser-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>		
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileScan)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-scanner-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScan)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/document-adder-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>	
<%
		}else if(e.isControlType(HtmlElement.ControlType.textEditor)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/editor-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.number)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/number-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%
		}else if(e.isControlType(HtmlElement.ControlType.phone)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/phone-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.text) || e.isControlType(HtmlElement.ControlType.textarea)){
			if(StringUtils.isEmpty(template)){
				template="/components/form/text-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.currentYear)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/current-year-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.year)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/year-select-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
			</liferay-util:include>
<%	
		}else if(e.isControlType(HtmlElement.ControlType.fileUploadBrowseScanView)){

			if(StringUtils.isEmpty(template)){
				template="/components/form/document-adder-viewer-element.jsp";
			}
%>
			<liferay-util:include page="<%=template%>" servletContext="<%=application%>">
				<liferay-util:param name="elementName" value="<%=e.getName()%>" />
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
	}
}
%>

