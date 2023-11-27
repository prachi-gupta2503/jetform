package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.model.WorkAreaMajor;

@HtmlForm(formId="WorkAreaForm_123456",title = "Work Area",
entityClass=WorkAreaMajor.class, advanceFilter = true,
	elements={
	@HtmlElement(name="workAreaMajorId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="code", seachable = true, required = true, unique=true, controlType = ControlType.number, max = 2147483647, min = 1 ),
	@HtmlElement(name="name", seachable = true, required = true,unique=true, regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL/*REGEXP_NAME*/, maxLength = 255),
	//@HtmlElement(name="parentWorkAreaId", label="Parent WorkArea", relation=@Relation(modelClass =WorkArea.class, valueField = "workAreaId", labelField = "name")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>"),
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
	})
public class WorkAreaMajorForm {
	WorkArea workArea;
}
