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
		@HtmlElement(name="name", required = true,regExp =HtmlElement.REGEXP_ALPHA_SPACE),
		@HtmlElement(name="description", required = true),
		@HtmlElement(name="reason",controlType=ControlType.hidden,label="Reason"),
		//@HtmlElement(name="processFileId", label="Process File No.", relation=@Relation(modelClass = ProcessFile.class, valueField ="processFileId", labelField = "processFileNo" )),
		@HtmlElement(name="processStatus",controlType=ControlType.hidden, label="Status",options= {"-1:incomplete","0:created","1:pending","2:approved","3:rejected","4:return for correction"}, value="0")
		},
	
	
	    actions = {@HtmlFormAction(name =HtmlFormAction.ACTION_ADD, label = "Add", applyOn = "table" ),@HtmlFormAction(name =HtmlFormAction.ACTION_EDIT, label = "<i class=\"fas fa-edit\"></i>", applyOn = "row" ),@HtmlFormAction(name ="submit", label = "<i class=\"fas fa-paper-plane\" title=\"Send for Approve\"></i>", applyOn = "row"), @HtmlFormAction(name =HtmlFormAction.ACTION_DELETE, label = "<i class=\"fas fa-trash\"></i>", applyOn = "row" )})
public class JoiningProcessForm {

}
