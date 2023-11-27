package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="JoiningProcessApproverForm_123456",
entityClass=JoiningProcess.class, formFlowProcess = true,
	elements={
		@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, key=true, formFlowKey = true),
		@HtmlElement(name="name",controlType=ControlType.hidden, required = true),
		@HtmlElement(name="unitId",label="Organization", controlType=ControlType.hidden,listable=false, relation=@Relation(modelClass = Organization.class), customTemplate = "/components/custom/unit-select-element.jsp"),
		@HtmlElement(name = "personalNo", controlType=ControlType.number,listable=false, unique = true, customTemplate = "/components/custom/personal-no-element.jsp", minLength = 6, maxLength = 7, required = true),
	  // 	@HtmlElement(name="description",controlType=ControlType.hidden),
		//@HtmlElement(name="processFileId",controlType=ControlType.hidden, label="Process File No.", relation=@Relation(modelClass = ProcessFile.class, valueField ="processFileId", labelField = "processFileNo" )),
		@HtmlElement(name="processStatus",controlType=ControlType.hidden,label="Status",options= {"0:created","1:pending","2:approved","3:rejected","4:Return for correction"},value="2")
	},
	
	
	    actions = {@HtmlFormAction(name =HtmlFormAction.ACTION_EDIT, label = "<i class=\"fas fa-eye\"></i>", applyOn = "row" ),@HtmlFormAction(name ="return", label = "<i class=\"fas fa-undo\"></i>", applyOn = "row"),@HtmlFormAction(name ="approveJoining", label = "<i class=\"fas fa-check\"title=\"Approve\"></i>", applyOn = "row"),@HtmlFormAction(name ="reject", label = "<i class=\"fas fa-times-circle\"></i>", applyOn = "row")})
public class JoiningProcessApproverForm {

}
