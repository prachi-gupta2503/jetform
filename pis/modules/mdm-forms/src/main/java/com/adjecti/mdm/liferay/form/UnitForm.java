package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="UnitForm_123456", title="Unit",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Unit"},
	elements={
	@HtmlElement(name="organizationDetailId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentId", label = "Division", relation=@Relation(modelClass =OrganizationDetail.class, valueField ="organizationDetailId", labelField = "shortName", filter= {"type:Division"})),
	@HtmlElement(name="organizationCode",label = "Unit Code"),
	@HtmlElement(name="shortName", label = "Short Name"),
	@HtmlElement(name="longName", label = "Long Name"),
	@HtmlElement(name="type", value = "Unit", controlType=ControlType.hidden),
}, 
	actions = {}
	//@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)
)
public class UnitForm {
	OrganizationDetail OrganizationDetail;
}
