package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.mdm.liferay.model.Qualification;
import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.model.QualificationLevel;
import com.adjecti.mdm.liferay.model.Specialization;
import com.adjecti.pis.liferay.model.EmployeeQualification;

@HtmlForm(formId="EmployeeJoiningQualificationForm_123456",
entityClass=EmployeeQualification.class, advanceFilter = true, elementsPerRow = 1,
	elements={
	@HtmlElement(name="employeeQualificationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true, listable = false),
	@HtmlElement(name="qualificationId", controlType = ControlType.select, relation=@Relation(modelClass=Qualification.class, valueField="qualificationId", labelField="name"), displayWidth = "20%", required=true),
	@HtmlElement(name="specializationId", controlType = ControlType.select, relation=@Relation(modelClass=Specialization.class, valueField="specializationId", labelField="name"), displayWidth = "20%", required=true),
	@HtmlElement(name="gradeId", listable = false,controlType = ControlType.select, relation=@Relation(modelClass=QualificationGrade.class, valueField="qualificationGradeId", labelField="name"), displayWidth = "20%", required=true),
	@HtmlElement(name="levelId", controlType = ControlType.select, relation=@Relation(modelClass=QualificationLevel.class, valueField="QualificationLevelId", labelField="name"), displayWidth = "20%", required=true),
	@HtmlElement(name="institution", displayWidth = "20%",  maxLength = 75,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name="foreignDegree", listable = false,controlType = ControlType.checkbox, displayWidth = "10%"),
	@HtmlElement(name="fromYear", controlType = ControlType.year, displayWidth = "10%", required=true, min=1970,yearBefore = "{currentYear}"),
	@HtmlElement(name="toYear", controlType = ControlType.year, displayWidth = "10%", required=true, min=1970, yearBefore = "{currentYear}",yearAfter="fromYear"),
	@HtmlElement(name="marksPercentage",listable = false, displayWidth = "10%",maxLength=10,minLength=0, controlType = ControlType.number),
	@HtmlElement(name="qualificationDate",controlType = ControlType.date,  required = true, listable = false,dateBefore="{today}"),
	@HtmlElement(name="certificateId",listable = false,controlType = ControlType.fileUpload,  required = true,accept = "image/png, image/jpeg, application/pdf")
},
		actions = { @HtmlFormAction(name = HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_DELETE), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeJoiningQualificationForm {

	EmployeeQualification employeeQualification;
	public EmployeeJoiningQualificationForm() {
		super();
	}
}
