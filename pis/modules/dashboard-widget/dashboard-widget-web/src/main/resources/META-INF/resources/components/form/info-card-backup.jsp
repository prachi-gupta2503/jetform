

<%@page import="com.adjecti.jetform.annotation.HtmlElementGroupWrapper"%>
<%@page import="com.adjecti.jetform.annotation.RelationWrapper"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElement"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="/init.jsp"%>
<%-- script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>--%>
<script>
	//var $=jQuery.noConflict();
</script>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.info_card_jsp");%>

<%
	response.setHeader("Cache-Control", "max-age=0");

	String formClass = ParamUtil.getString(request, "formClass");
	String formClassPK = ParamUtil.getString(request, "formClassPK");
	boolean dialogMode = ParamUtil.getBoolean(request, "dialogMode", false);

	JetFormBuilderLocalService jetFormBuilderLocalService = (JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");

	HtmlFormWrapper form = null;
	if (!(StringUtils.isEmpty(formClassPK) || StringUtils.equals(formClassPK, "0"))) {
		form = jetFormBuilderLocalService.getHtmlFormByClass(formClass, formClassPK);
	}
	Class entityClass = form.getEntityClass();
	Object entity = form.getEntity();

	LOGGER.info("formClass : " + formClass + ", formClassPK : " + formClassPK + ", entity : " + entity);

	pageContext.setAttribute("htmlForm", form);
%>

<portlet:actionURL name="saveForm" var="saveFormActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<%
	if (!dialogMode) {
%>
<div class="card info-card mb-2 mt-2">
	<div class="card-header header-primary">
		<div class="row">
			<div class="col-md-12">
				<h5>
					<%=form.getTitle()%>
				</h5>
			</div>
			<%--<div class="col-md-6 text-right" >
				<i style="color: blue;" class="fa fa-edit fa-action fa-actions-top admin-role"></i> <i style="color: green;" class="fa fa-share fa-action fa-actions-top admin-role"></i>
				<i style="color: red;" class="fa fa-times fa-action fa-actions-top admin-role"></i>
				<i style="color: blue;" class="fa fa-hand-paper-o fa-action fa-actions-top user-role"></i>
				<i style="color: #ff8306;" class="fa fa-check fa-action fa-actions-top approver-role"></i>
			</div> --%>
		</div>
	</div>
	<div class="card-body">
		<%
			}
		%>
		<div class="container">
			<%
				for (HtmlElementWrapper element : form.getElements()) {
					if (element.isControlType(HtmlElement.ControlType.hidden)) {
						continue;
					}
					String value = "";
					if (entity != null && form.getPrimaryKey() != null) {
						try {
							Method method = entityClass.getMethod("get" + StringUtils.capitalize(element.getAttribute()),new Class[] {});
							value = String.valueOf(method.invoke(form.getEntity(), new Object[] {}));
							pageContext.setAttribute(element.getName() + "_savedValue", value);
							//e.setValue(value);
							RelationWrapper relation = element.getRelation();
							if (relation.isValidModelClass()) {
								Method modelMethod = null;
								Class modelClass = relation.getModelClass();
								Object relObject = jetFormBuilderLocalService.readObject(modelClass, value);
								if (relObject != null) {
									if (StringUtils.isNotEmpty(relation.getLabelField())) {
										modelMethod = modelClass.getMethod(
												"get" + StringUtils.capitalize(relation.getLabelField()), new Class[] {});
									} else {
										try {
											modelMethod = modelClass.getMethod("get" + modelClass.getSimpleName(),
													new Class[] {});
										} catch (Exception ex) {
											modelMethod = modelClass.getMethod("getName", new Class[] {});
										}
									}
									if (method != null) {
										value = String.valueOf(modelMethod.invoke(relObject, new Object[] {}));
									}
								}
							}
						} catch (Exception ex) {
						}
						if (value == null || value.equals("null") || value.equals("0")) {
							value = "-";
						}
					}
			%>
			<div class="row">
				<div class="col-md-6">
					<label><%=element.getLabel()%></label>
				</div>
				<div class="col-md-6">
					<%=value%>
				</div>
			</div>
			<%
				}
				for (HtmlElementGroupWrapper group : form.getElementGroups()) {
					for (HtmlElementWrapper element : group.getElements()) {
						if (element.isControlType(HtmlElement.ControlType.hidden)) {
							continue;
						}
						String value = "";
						if (entity != null && form.getPrimaryKey() != null) {
							try {
								Method method = entityClass
										.getMethod("get" + StringUtils.capitalize(element.getAttribute()), new Class[] {});
								value = String.valueOf(method.invoke(form.getEntity(), new Object[] {}));
								pageContext.setAttribute(element.getName() + "_savedValue", value);
								//e.setValue(value);
								RelationWrapper relation = element.getRelation();
								if (relation.isValidModelClass()) {
									Method modelMethod = null;
									Class modelClass = relation.getModelClass();
									Object relObject = jetFormBuilderLocalService.readObject(modelClass, value);
									if (relObject != null) {
										if (StringUtils.isNotEmpty(relation.getLabelField())) {
											modelMethod = modelClass.getMethod(
													"get" + StringUtils.capitalize(relation.getLabelField()),
													new Class[] {});
										} else {
											try {
												modelMethod = modelClass.getMethod("get" + modelClass.getSimpleName(),
														new Class[] {});
											} catch (Exception ex) {
												modelMethod = modelClass.getMethod("getName", new Class[] {});
											}
										}
										if (method != null) {
											value = String.valueOf(modelMethod.invoke(relObject, new Object[] {}));
										}
									}
								}
							} catch (Exception ex) {
							}
							if (value == null || value.equals("null") || value.equals("0")) {
								value = "-";
							}
						}
			%>
			<div class="row">
				<div class="col-md-6">
					<label><%=element.getLabel()%></label>
				</div>
				<div class="col-md-6">
					<%=value%>
				</div>
			</div>
			<%
				}
				}
			%>
		</div>
		<%
			if (!dialogMode) {
		%>
	</div>
</div>
<%
	}
%>
<aui:form action="<%=saveFormActionURL%>" name="<%=form.getId()%>" id="<%=form.getId()%>">
	<%@ include file="/components/form/hidden-elements.jsp"%>
</aui:form>


