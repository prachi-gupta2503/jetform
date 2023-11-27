<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.model.KeyValue"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String savedValue=(String)pageContext.getAttribute(htmlElement.getName()+ "_savedValue");
%>

<div class="alloy-editor-container">
    <liferay-editor:editor
    		contents="<%=savedValue%>"
    		cssClass="my-alloy-editor"
    		editorName="alloyeditor"
    		name="<%=htmlElement.getName()%>"
    		placeholder="<%=htmlElement.getPlaceHolder()%>"
    		showSource="true" 
    /> 
</div>