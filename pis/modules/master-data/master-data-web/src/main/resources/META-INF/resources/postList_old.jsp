<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryPos"%>
<%@page import="com.adjecti.mdm.liferay.service.PostLocalServiceUtil"%>
<%@page import="java.lang.reflect.Modifier"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>

<%@ include file="/init.jsp"%>

<portlet:renderURL var="addURL">
    <portlet:param name="mvcPath" value="/postAdd.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcRenderCommandName" value="editPost"></portlet:param>
</portlet:renderURL>	

<portlet:actionURL name="deletePost" var="deleteURL">
	 <portlet:param name="mvcActionCommand" value="deletePost" /> 
</portlet:actionURL>
		
<%!
final static List<String> excludeMethodList=Arrays.asList(new String[] {"getCreatedBy","getUserName","getCompanyId","getPrimaryKey","getGroupId","getUserUuid","getUuid","getUserId","getCreatedByUserName","getCreateDate","getLanguageId","getModifiedDate","getExpandoBridge","getModelAttributes","getPrimaryKeyObj","getModelClass","getModelClassName","getExpandoBridge","getPrimaryKeyObj","getStagedModelType","getAttributeGetterFunctions","getAttributeSetterBiConsumers"});

%>
<%
Map<String, Method> methodMap=new HashMap<String, Method>();
Method[] methods=Post.class.getMethods();

//String elemName="";
for(Method method:methods) {
	if(!method.getName().startsWith("get")) {
		continue;
	}
	
	if(excludeMethodList.contains(method.getName())) {
		continue;
	}
	
	String modifiers = Modifier.toString(method.getModifiers());
	if (modifiers.contains("final") || modifiers.contains("static")) {
		continue;
	}
	
	String attributeName=ReflectionUtil.getAttributeFromAccessorMethod(method);
	methodMap.put(attributeName, method);
}
%>	

<div>
	<a class="btn btn-success" href="<%= addURL %>" role="button">Add New Post</a>
</div>


<table id="dataTable">
	<thead>
		<tr>
			<th>#</th>
<%
for(String column:methodMap.keySet()){
	if(!column.equalsIgnoreCase("postid")){
%>
	<th><%=StringUtils.capitalize(column) %></th>
<%
	}
}
%>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
<%
List<Post> posts=PostLocalServiceUtil.getPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
int counter=1;
for(Post post:posts){
%>
	<tr>
	<td><%=counter++ %></td>
<%
	for(Map.Entry<String, Method> entry:methodMap.entrySet()){
		String column=entry.getKey();
		if(!column.equalsIgnoreCase("postid")){
			String value="";
			try{
				value=String.valueOf(entry.getValue().invoke(post, new Object[]{}));
			}catch(Exception e){}
%>
		<td><%=value %></td>
<%			
		}
	}
	Method postIdMethod=methodMap.get("postId");
	String postId="0";
	try{
		postId=String.valueOf(postIdMethod.invoke(post, new Object[]{}));
	}catch(Exception e){}
%>
		<td>
			<a href="<%=editURL%>&<portlet:namespace/>postId=<%=postId %>" class="btn btn-primary mr-2">edit</a>
			<a href="<%=deleteURL%>&<portlet:namespace/>postId=<%=postId %>" class="btn btn-danger">delete</a>
								
		</td>
	<tr>
<%
}
%>
	</tbody>
</table>
