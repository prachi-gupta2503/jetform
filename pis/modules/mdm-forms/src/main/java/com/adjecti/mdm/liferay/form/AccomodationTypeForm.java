package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.AccomodationType;

@HtmlForm(formId = "AccomodationTypeForm_123456", entityClass = AccomodationType.class, advanceFilter = true, title = "Accommodation Type",readOnly = false, elements = {
		@HtmlElement(name = "accomodationTypeId", controlType = ControlType.hidden, key = true),
		// @HtmlElement(name="code", seachable = true,unique = true ,required = true),
		@HtmlElement(name = "name", seachable = true, unique = true, required = true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255),
		//@HtmlElement(name = "status", controlType = ControlType.hidden),
		// @HtmlElement(name="description", seachable = true, maxLength = 75)
		@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
		@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
actions = {
		@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\" title=\"Edit\"></i>"),
		@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\" title=\"Approve\"></i>" ,enable ={"status:0"}),
		@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\" title=\"Delete\"></i>")
		,@HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
		}
/*
 * actions = {@HtmlFormAction(name="approve", applyOn =
 * "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>" ,enable
 * ={"status:0"} )}
 */
)
public class AccomodationTypeForm {
	AccomodationType accomodationType;
}
