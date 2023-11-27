package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.FamilyRelation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.pis.liferay.model.EmployeeFamily;

@HtmlForm(formId="EmployeeFamilyForm_123456",
entityClass=EmployeeFamily.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeFamilyId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="name",required = true ,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="genderId",listable = false,required = true, controlType=ControlType.select, relation=@Relation(modelClass = Gender.class)),
	@HtmlElement(name="relationId", controlType=ControlType.select, relation=@Relation(modelClass = FamilyRelation.class, valueField = "familyRelationId", labelField = "name")),
	@HtmlElement(name = "dateOfBirth", controlType = ControlType.date, required = true),
	@HtmlElement(name="occupationId",controlType=ControlType.select, relation=@Relation(modelClass = Occupation.class, valueField = "occupationId", labelField = "name")),
	@HtmlElement(name="nominee", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="dependant", controlType=ControlType.checkbox)
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeFamilyForm {
	EmployeeFamily employeeFamily;
	public EmployeeFamilyForm() {
		super();
	}
}
