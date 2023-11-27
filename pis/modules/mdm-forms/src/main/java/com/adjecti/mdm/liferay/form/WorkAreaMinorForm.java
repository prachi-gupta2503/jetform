package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.WorkAreaMajor;
import com.adjecti.mdm.liferay.model.WorkAreaMinor;

@HtmlForm(formId="WorkAreaMinorForm_123456",
entityClass=WorkAreaMinor.class, advanceFilter = true,
	elements={
	@HtmlElement(name="workAreaMinorId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name = "code", seachable = true, required = true,  unique=true, controlType = ControlType.number, max = 2147483647, min = 1 ),
	@HtmlElement(name = "name", seachable = true, required = true ,unique=true , regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
	@HtmlElement(name="workAreaMajorId",label = "Work Area Major", controlType = ControlType.select, relation=@Relation(modelClass=WorkAreaMajor.class, valueField = "workAreaMajorId", labelField = "name"),required = true ),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>"),
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
	})
public class WorkAreaMinorForm {
	WorkAreaMinor workAreaMinor;
}
