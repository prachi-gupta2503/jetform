package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeExperienceForm_123456",
entityClass=EmployeeExperience.class, advanceFilter = true,
	elements={
	@HtmlElement(name="employeeExperienceId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="designationId", controlType=ControlType.select, relation=@Relation(modelClass = Designation.class, valueField = "designationId", labelField = "name_En"), required=true),
	//@HtmlElement(name="postId", controlType=ControlType.select, relation=@Relation(modelClass = Post.class, valueField = "postId", labelField = "name_En")),
	@HtmlElement(name="tradeId", controlType=ControlType.select, relation=@Relation(modelClass = Trade.class, valueField = "tradeId", labelField = "name"), required=true),
	@HtmlElement(name="organizationId", controlType=ControlType.select, relation=@Relation(modelClass = Organization.class, valueField = "organizationId", labelField = "name",filter= {"type:Unit"}), required=true),
	@HtmlElement(name="workAreaId", label = "Work Area", controlType=ControlType.select, relation=@Relation(modelClass = WorkArea.class, valueField = "workAreaId", labelField = "name"), required=true),
	
	//@HtmlElement(name="workAreaMinorId", controlType=ControlType.select, relation=@Relation(modelClass = WorkAreaMinor.class, valueField = "workAreaMinorId", labelField = "name"),depends = "workAreaMajorId", required=true),
	
	@HtmlElement(name="fromDate", controlType=ControlType.date, required=true, dateBefore="{today}"),
	@HtmlElement(name="toDate", controlType=ControlType.date, required=true, dateBefore="{today}", dateAfter="fromDate"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeExperienceForm {
	EmployeeExperience employeeExperience;
	public EmployeeExperienceForm() {
		super();
	}
}
