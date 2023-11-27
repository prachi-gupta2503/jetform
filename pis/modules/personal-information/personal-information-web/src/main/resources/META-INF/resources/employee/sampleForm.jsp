
<%@ include file="/init.jsp"%>
<%
	String myActionURL="/test.jsp";
%>
<aui:form action="<%= myActionURL %>" method="post" name="myForm">
        <aui:input label="My Text Input" name="myTextInput" type="text" 
        value='<%= "My Text Value" %>' >
        	<aui:validator name="required" />
        </aui:input>

        <aui:button type="submit" />
</aui:form>