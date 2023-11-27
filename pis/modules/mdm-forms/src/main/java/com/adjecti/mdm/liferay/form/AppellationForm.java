package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.mdm.liferay.model.Appellation;

@HtmlForm(formId="AppellationForm_123456",
entityClass=Appellation.class, advanceFilter = true, title = "Appellation",
	elements={
		@HtmlElement(name="appellationId", controlType=ControlType.hidden, key=true),
		//@HtmlElement(name="code", seachable = true,unique = true ,required = true),
		@HtmlElement(name="name", seachable = true, unique = true, required = true,regExp = HtmlElement.REGEXP_ALPHA_WITHALLSYMBOL, maxLength = 255/* validType = HtmlElement.ValidType.alpha*/),
		//@HtmlElement(name="description", seachable = true, maxLength = 75)
		@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
		@HtmlElement(name="status", controlType=ControlType.hidden, value="0",listable = false),
},
			actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
					@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" title=\"Approve\" aria-hidden=\"true\"></i>" ,enable= {"status:0"}),
					@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row"),
			@HtmlFormAction(name="active", applyOn = "row",label="<i class=\"fa fa-power-off\" aria-hidden=\"true\" title=\"Activate\"></i>"/*"<i class=\"fa fa-reply-all\" aria-hidden=\"true\" title=\"Activate\"></i>"*/, visible = {"deleted:yes"})
			}
		)
public class AppellationForm {
	AccomodationType accomodationType;
}
