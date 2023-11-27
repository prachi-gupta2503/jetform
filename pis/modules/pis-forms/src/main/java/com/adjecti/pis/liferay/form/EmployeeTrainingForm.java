package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeTrainingForm_123456",
entityClass=EmployeeTraining.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeTrainingId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="organizationId",label = "Organization" ,controlType=ControlType.hidden,listable = false, relation=@Relation(modelClass = Organization.class,filter = {"type:Unit"}),required = true),
	@HtmlElement(name="instituteId",label = "Institute" ,listable = false,controlType=ControlType.select, relation=@Relation(modelClass = Organization.class,filter= {"type:Institute"})),
	@HtmlElement(name="courseId", controlType=ControlType.select, relation=@Relation(modelClass = Course.class)),
	@HtmlElement(name="durationMonths", label="Duration (in Days)",controlType=ControlType.hidden/*, min=1,max=60*/),
	@HtmlElement(name="startDate", controlType=ControlType.date, dateBefore="{today}"),
	@HtmlElement(name="endDate", controlType=ControlType.date,dateBefore="{today}", dateAfter="startDate"/*, monthBefore  = "durationMonths"*/),
}, 
	actions = { @HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeTrainingForm {
	EmployeeTraining employeeTraining;
	public EmployeeTrainingForm() {
		super();
	}
	
}
