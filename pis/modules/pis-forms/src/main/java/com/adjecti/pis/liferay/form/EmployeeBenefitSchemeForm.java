package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.pis.liferay.model.EmployeeBenefitScheme;

@HtmlForm(formId="EmployeeBenefitSchemeForm_123456",
entityClass=EmployeeBenefitScheme.class, advanceFilter = true, elementsPerRow = 1,
	elements={
	@HtmlElement(name="employeeBenefitSchemeId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="benefitSchemeId", controlType = ControlType.select, relation=@Relation(modelClass=BenefitScheme.class, valueField="benefitSchemeId", labelField="name"), displayWidth = "20%", required = true),
	@HtmlElement(name="fromDate", label="From Date", controlType = ControlType.date, displayWidth = "10%", required = true,dateBefore="{today}"),
	@HtmlElement(name="toDate", label="To Date", controlType = ControlType.date, displayWidth = "10%", required = true,dateBefore="{today}", dateAfter="fromDate"),
	@HtmlElement(name="documentNo", displayWidth = "10%", required = true),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)})
public class EmployeeBenefitSchemeForm {
	EmployeeBenefitScheme employeeBenefitScheme;
	public EmployeeBenefitSchemeForm() {
		super();
	}
}
