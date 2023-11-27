<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationClass"%>
<%@page import="com.adjecti.mdm.liferay.model.DesignationGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.GradeMode"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.model.Religion"%>
<%@page import="com.adjecti.mdm.liferay.model.PhType"%>
<%@page import="com.adjecti.mdm.liferay.model.Occupation"%>
<%@page import="com.adjecti.mdm.liferay.model.MaritalStatus"%>
<%@page import="com.adjecti.mdm.liferay.model.Gender"%>
<%@page import="com.adjecti.mdm.liferay.model.Course"%>
<%@page import="com.adjecti.mdm.liferay.model.CasteCategory"%>
<%@page import="com.adjecti.mdm.liferay.model.BloodGroup"%>
<%@page import="com.adjecti.mdm.liferay.model.BenefitScheme"%>
<%@page import="com.adjecti.mdm.liferay.model.Appellation"%>
<%@page import="com.adjecti.mdm.liferay.model.AccomodationType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ include file="/init.jsp"%>

<style>

	/*tr:hover{
		background-color:#000;
	}*/
</style>
<portlet:renderURL var="formListURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
	<portlet:param name="quickMenu" value="/masterEntityList.jsp" />
</portlet:renderURL>

<%
List<Class> mdmClasses=new ArrayList<Class>();
mdmClasses.add(AccomodationType.class);
mdmClasses.add(Appellation.class);
mdmClasses.add(BenefitScheme.class);
mdmClasses.add(BloodGroup.class);
mdmClasses.add(CasteCategory.class);
mdmClasses.add(Course.class);
mdmClasses.add(Gender.class);
mdmClasses.add(MaritalStatus.class);
mdmClasses.add(Occupation.class);
mdmClasses.add(PhType.class);
mdmClasses.add(Religion.class);
mdmClasses.add(Grade.class);
mdmClasses.add(GradeMode.class);
mdmClasses.add(Trade.class);
mdmClasses.add(DesignationGroup.class);
mdmClasses.add(DesignationClass.class);
mdmClasses.add(Designation.class);
mdmClasses.add(Country.class);

String formClass=ParamUtil.getString(request, "formClass");
%>

<div class="card">
	<div class="card-header bg-primary text-white mt-2">
		<h4>Other Masters</h4>
	</div>
	<div class="card-body" style="padding: 0px !important;">
		<table class="table">
			<tbody>
<%
	for(Class c:mdmClasses){
		
%>
				<tr>
<%
		if(StringUtils.equalsIgnoreCase(formClass, c.getName())){
%>				
					<td scope="row" style="background-color:lightgray; color:#fff;"><%=AnnotationUtil.getItemLabel(c.getSimpleName()) %></td>
<%
		}else{
%>			
					<td scope="row"><a href="<%=formListURL.toString()%>&<portlet:namespace/>formClass=<%=c.getName()%>"><%=AnnotationUtil.getItemLabel(c.getSimpleName()) %></a></td>
<%
		}
%>		
				</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>
</div>
