<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="adjecti" prefix="selectTag"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script> 

<script>
function myFunction() {
  var x = document.getElementById("101").value;
  document.getElementById("demo").innerHTML = "You selected: " + x;
}
</script>

<selectTag:designation-class-select id="101" cssStyle="color:yellow"  onChange='myFunction()' />

<p id="demo"></p>

