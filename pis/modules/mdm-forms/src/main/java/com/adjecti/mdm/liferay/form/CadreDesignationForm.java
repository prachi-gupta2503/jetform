package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.Designation;

@HtmlForm(formId="CadreDesignationForm_123456",
entityClass=CadreDesignation.class, advanceFilter = true,
	elements={
	@HtmlElement(name="cadreDesignationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="cadreId", controlType = ControlType.hidden),
	@HtmlElement(name="designationId", required = true, relation=@Relation(modelClass = Designation.class, labelField = "name_En", valueField = "designationId")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class CadreDesignationForm {
	CadreDesignation cadreDesignation;

	public CadreDesignationForm(CadreDesignation cadreDesignation) {
		super();
		this.cadreDesignation = cadreDesignation;
	}
}
