package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="SectionForm_123456", title="Section",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Section"},
	elements={
	@HtmlElement(name="organizationDetailId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentId", label = "Unit", relation=@Relation(modelClass =OrganizationDetail.class, valueField ="organizationDetailId", labelField = "shortName", filter= {"type:Unit"})),
	@HtmlElement(name="organizationCode",label = "Section Code"),
	@HtmlElement(name="shortName", label = "Short Name"),
	@HtmlElement(name="longName", label = "Long Name"),
	@HtmlElement(name="type", value = "Section", controlType=ControlType.hidden),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
}, 
	actions = {}
//@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)
)
public class SectionForm {
	OrganizationDetail OrganizationDetail;
}
