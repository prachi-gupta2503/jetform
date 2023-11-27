package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeOrganization;

@HtmlForm(formId="EmployeeOrganizationForm_12345", title="Section Mapping",associationEntity = true,associationOneKey = "employeeId",associationManyKey = "subOrganizationId",
entityClass=EmployeeOrganization.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeOrganizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", label = "Personal No", relation = @Relation(modelClass = Employee.class, valueField = "employeeId", labelField = "personalNo"), controlType = ControlType.hidden, listable = false),
	/*@HtmlElement(name="organizationId", label = "Unit Name", relation = @Relation(modelClass = OrganizationDetail.class, valueField = "organizationDetailId", labelField = "shortName", filter={"type:Unit"}), customTemplate = "/components/custom/unit-select-element.jsp", required = true),*/
	@HtmlElement(name="organizationId",  controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="subOrganizationId",controlType = ControlType.multiSelect, label = "Section Name", relation = @Relation(modelClass = OrganizationDetail.class, valueField = "organizationDetailId", labelField = "shortName", filter={"type:Section"}), depends = "organizationId", customTemplate = "/components/custom/additional-section-select-element.jsp", required = true),
}, 
		actions = {
				/* @HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), */@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeOrganizationForm {
	EmployeeOrganization employeeOrganization;
}
