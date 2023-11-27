package com.adjecti.mdm.liferay.form;
import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.UnitType;

@HtmlForm(formId="UnitTypeForm_123456",title = "UnitType",
entityClass=UnitType.class, advanceFilter = true,
	elements={
	@HtmlElement(name="unitTypeId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="code", seachable = true, required = true, unique=true,validType =HtmlElement.ValidType.alpha, maxLength = 30/* controlType = ControlType.number, max = 999, min = 1 */),
	@HtmlElement(name="shortDiscription", seachable = true,unique=true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, required = true,  maxLength = 255),
	@HtmlElement(name="longDiscription", seachable = true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL,  maxLength = 255),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>"),
	        @HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>", visible = {"deleted:yes"})
	})
public class UnitTypeForm {
	UnitType unitType;
}
