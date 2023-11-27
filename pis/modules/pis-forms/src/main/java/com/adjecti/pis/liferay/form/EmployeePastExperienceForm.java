package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.pis.liferay.model.EmployeePastExperience;

@HtmlForm(formId="EmployeePastExperienceForm_123456",
entityClass=EmployeePastExperience.class,elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeePastExperienceId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true, listable = false),
	@HtmlElement(name="organization", controlType=ControlType.text, required = true, maxLength = 50),
	@HtmlElement(name="designation", controlType=ControlType.text, required = true, maxLength = 50),
	@HtmlElement(name="workAreaId",label = "Work Area", controlType=ControlType.select, relation=@Relation(modelClass = WorkArea.class), required = true),
	@HtmlElement(name="fromDate", controlType=ControlType.date,dateBefore="{today}",required = true),
	@HtmlElement(name="toDate", controlType=ControlType.date,dateBefore="{today}", dateAfter="fromDate",required = true),
	@HtmlElement(name="experienceLetterId",controlType = ControlType.fileUpload,accept = "application/pdf")
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT,applyOn = "row"),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,applyOn = "row"), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeePastExperienceForm {
	EmployeePastExperience employeePastExperience;
	public EmployeePastExperienceForm() {
		super();
	}
}
