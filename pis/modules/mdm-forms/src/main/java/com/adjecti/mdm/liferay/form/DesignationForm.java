package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;

@HtmlForm(formId="DesignationForm_123456",
entityClass=Designation.class, advanceFilter = true,
	elements={
	@HtmlElement(name="designationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="code", seachable = true, required = true, unique=true, controlType = ControlType.number, max = 2147483647, min = 1 ),
	@HtmlElement(name="name_En",label="Name", seachable = true, unique=true,required = true, regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
	@HtmlElement(name="longName", seachable = true, required = true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
	//@HtmlElement(name="name_Hi"),
	//@HtmlElement(name="cadreId", label="Cadre", seachable = true, required = true, relation=@Relation(modelClass=Cadre.class, valueField="cadreId", labelField="name")),
	@HtmlElement(name="gradeId", label="Grade", seachable = true, required = true, relation=@Relation(modelClass=Grade.class, valueField="gradeId", labelField="name")),
	//@HtmlElement(name="designationClassId", label="Class", seachable = true, relation=@Relation(modelClass=Designation.class, valueField="designationClassId", labelField="name")),
	@HtmlElement(name="designationGroupId", label="Group", seachable = true, required = true, relation=@Relation(modelClass=DesignationGroup.class, valueField="designationGroupId", labelField="name")),
	@HtmlElement(name="organizationType", label="Organization Type", controlType=ControlType.select,options = {"O=Ordnance Factories", "H=Hospital", "S=School"}) ,//relation=@Relation(modelClass=OrganizationType.class, valueField="code", labelField="longName")),
	//@HtmlElement(name="description", listable = false),
	//@HtmlElement(name="designationModeId", label="Entry Mode", seachable = true, required = true, relation=@Relation(modelClass=DesignationMode.class, valueField="designationModeId", labelField="name")),
	//@HtmlElement(name="organizations", controlType = ControlType.list, mappingField="designationId", formClass = DesignationScopeForm.class),

	/*@HtmlElement(name="scopeOrganizationName"),
	@HtmlElement(name="scopePostName"),*/
	//@HtmlElement(name="successorGradeId", label="Next Grade", seachable = true, relation=@Relation(modelClass=Grade.class, valueField="gradeId", labelField="name")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>"),
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
	})
public class DesignationForm {

}
