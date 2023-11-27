<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="java.util.Set"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@ include file="/init.jsp"%>

<%
int tabIndex = ParamUtil.getInteger(request, "tabIndex", 0);
String flowFormId=(String)request.getAttribute("flowFormId");
HtmlFormWrapper formFlow=(HtmlFormWrapper)request.getAttribute(flowFormId);
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

String formFlowClass = ParamUtil.getString(request, "formFlowClass", "");
long formFlowClassPK = ParamUtil.getLong(request, "formFlowClassPK", 0);

HtmlElementWrapper formFlowElement=(HtmlElementWrapper)request.getAttribute("formFlowElement");

/*if(formFlowClassPK==0){
	if(request.getAttribute("formFlowClassPK")!=null){
		formFlowClassPK=(Long)request.getAttribute("formFlowClassPK");
	}
}*/
boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}
%>

<portlet:renderURL var="nextRedirectURL">
	<portlet:param name="formFlowClass" value="<%=formFlowClass%>" />
<%
	if(formFlowClassPK>0){
%>	
	<portlet:param name="formFlowClassPK" value="<%=String.valueOf(formFlowClassPK)%>" />
<%
	}
%>	
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex+1)%>" />
</portlet:renderURL>

<portlet:renderURL var="prevRedirectURL">
	<portlet:param name="formFlowClass" value="<%=formFlowClass%>" />
<%
	if(formFlowClassPK>0){
%>	
	<portlet:param name="formFlowClassPK" value="<%=String.valueOf(formFlowClassPK)%>" />
<%
	}
%>	
	<portlet:param name="mvcPath" value="/components/form/multi-step-form-flow.jsp" />
	<portlet:param name="tabIndex" value="<%=String.valueOf(tabIndex-1)%>" />
</portlet:renderURL>

<script type="text/javascript">
//<!--

	$( document ).ready(function() {

		try{
			$("#<portlet:namespace/><%=formFlow.getId()%>next").click(function(event) {
<%
	if(!viewOnlyMode){
%>
			//alert("<%=formFlow.getId()%>next is clicked");
			var beforeNextClick=true;
			try{
				beforeNextClick=beforeNextOnClick(this);
				//alert("beforeNextClick "+beforeNextClick);
			}catch(e){}
			if(!beforeNextClick){
				return;
			}
<%
		if(formFlowElement!=null && StringUtils.isBlank(formFlowElement.getCustomTemplate())){
%>
			var table = $('#<portlet:namespace/><%=form.getId()%>dataTable').DataTable();
			if (!table.data().count() ) {
			    alert( 'Add one or more rows to the table.' );
			    return;
			}
<%
		}
	}
%>				
				<portlet:namespace/><%=formFlow.getId()%>next();
			});
		}catch(e){}
		<%-- For Closing Dialog --%>
		try{
			$("#<portlet:namespace/><%=formFlow.getId()%>prev").click(function(event) {
<%
	if(!viewOnlyMode){
%>
								
				var beforePrevClick=true;
				try{
					beforePrevClick=beforePrevOnClick(this);
				}catch(e){}
				
				if(!beforePrevClick){
					return;
				}
<%
	}
%>
				<portlet:namespace/><%=formFlow.getId()%>prev();
			});
		}catch(e){}
	});
	
	function <portlet:namespace/><%=formFlow.getId()%>next(){
		console.log('<%=nextRedirectURL.toString()%>');
		window.location.href='<%=nextRedirectURL.toString()%>';
	}
	
	function <portlet:namespace/><%=formFlow.getId()%>prev(){
		//alert('<%=nextRedirectURL.toString()%>');
		window.location.href='<%=prevRedirectURL.toString()%>';
	}

//--->
</script>
