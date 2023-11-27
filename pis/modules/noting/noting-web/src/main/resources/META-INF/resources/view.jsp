<%@page import="com.adjecti.noting.web.portlet.NotingDTO"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>


<%
List<NotingDTO> notingDTOList = (List<NotingDTO>)request.getAttribute("notingList");
pageContext.setAttribute("notingDTOList", notingDTOList);  
%>

<ul>
	<c:forEach var="noting" items="${notingDTOList}">
	
		<li><a href=${noting.viewUrl}>${noting.title}</a></li>
			
	</c:forEach>
</ul>  

<portlet:actionURL var="saveContent" name="saveContent"></portlet:actionURL>
<portlet:actionURL var="savePdf"></portlet:actionURL>


<aui:form action="<%= saveContent%>" method="post">
	 <aui:input name="title"></aui:input>
	 <liferay-ui:input-editor name="content" initMethod="initEditor" width="100" height="400" 
	  resizable="true" ></liferay-ui:input-editor>
	 <aui:button type="submit" value="Save"></aui:button>
	 <aui:button type="submit" value="Pdf" ></aui:button>
</aui:form>


<aui:script>
 function <portlet:namespace/>initEditor(){
 return  "Sample CKEDITOR";
 }
</aui:script>

<script type="text/javascript">
function onsubmitform()
{
  if(document.pressed == 'Save')
  {
   document.addDetails.action ="<%=saveContent%>";
  }
  else
  if(document.pressed == 'Pdf')
  {
    document.addDetails.action ="<%=savePdf%>";
  }
  return true;
}
</script>


