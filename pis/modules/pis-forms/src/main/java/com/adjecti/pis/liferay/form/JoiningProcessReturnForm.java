package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.ProcessFile;

@HtmlForm(formId="JoiningProcessForm_123456",
entityClass=JoiningProcess.class, formFlowProcess = true, 
	elements={
		@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, key=true, formFlowKey = true),
		
		@HtmlElement(name="reason",label="Reason",required = true),
		@HtmlElement(name="processStatus",controlType=ControlType.hidden,label="Status",value="4")
	},
	
	
	    actions = {@HtmlFormAction(name =HtmlFormAction.ACTION_EDIT, label = "<i class=\"fas fa-edit\"></i>", applyOn = "row" ),@HtmlFormAction(name ="return", label = "<i class=\"fas fa-undo\"></i>", applyOn = "row"),@HtmlFormAction(name ="approve", label = "Approve", applyOn = "row"),@HtmlFormAction(name ="reject", label = "Reject", applyOn = "row")})
public class JoiningProcessReturnForm {

}
