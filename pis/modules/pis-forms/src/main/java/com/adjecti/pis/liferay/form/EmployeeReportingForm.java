package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeReporting;

@HtmlForm(formId="EmployeeReportingForm_123456",
entityClass=EmployeeReporting.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeReportingId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="reportingToId", controlType=ControlType.select, relation=@Relation(modelClass = Employee.class, valueField = "employeeId", labelField = "fullName_En"), required = true),
	@HtmlElement(name="fromDate", controlType=ControlType.date, required = true, dateBefore="{today}"),
	@HtmlElement(name="toDate", controlType=ControlType.date, dateBefore="{today}", dateAfter="fromDate" ,required = true),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeReportingForm {
	EmployeeReporting employeeReporting;
	public EmployeeReportingForm() {
		super();
	}
}
