package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.BloodGroup;

@HtmlForm(formId="BloodGroupForm_123456",
entityClass=BloodGroup.class, advanceFilter = true, title = "Blood Group",
	elements={
	@HtmlElement(name="bloodGroupId", controlType=ControlType.hidden, key=true),
	//@HtmlElement(name="code", seachable = true,unique = true ,required = true),
	@HtmlElement(name="name", seachable = true, unique = true, required = true, regExp = HtmlElement.REGEXP_BLOODGROUP),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
		@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
		@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>")
,
@HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
}
		)
public class BloodGroupForm {
	BloodGroup bloodGroup;
}
