package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;



@HtmlForm(formId="SingleUserOnboardingForm_123456",
entityClass=SingleUserOnboarding.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name = "singleUserRegistrationId", controlType=ControlType.hidden, key=true),
	
	@HtmlElement(name = "firstName",controlType=ControlType.hidden, required = true, regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name = "middleName",controlType=ControlType.hidden, regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name = "lastName",controlType=ControlType.hidden,required = true, regExp =HtmlElement.REGEXP_ALPHA_SPACE),
	@HtmlElement(name = "reason",required=true,listable=false),
	@HtmlElement(name="status",controlType=ControlType.hidden,options= {"0:created","1:pending","2:approved","3:rejected","4:Return for correction"})
		
	
},
	actions = {@HtmlFormAction(name =HtmlFormAction.ACTION_EDIT, label = "<i class=\"fas fa-eye\"></i>", applyOn = "row" ),@HtmlFormAction(name ="return", label = "<i class=\"fas fa-undo\"></i>", applyOn = "row"),@HtmlFormAction(name ="approve", label = "<i class=\"fas fa-check\"title=\"Approve\"></i>", applyOn = "row"),@HtmlFormAction(name ="reject", label = "<i class=\"fas fa-times-circle\"></i>", applyOn = "row")})

public class SingleUserOnboardingApproverForm {
	SingleUserOnboarding SingleUserOnboarding;
	public SingleUserOnboardingApproverForm() {
		super();
	}
}

