package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="OrganizationDetailForm_123456",
entityClass=OrganizationDetail.class, advanceFilter = true,
	elements={
	@HtmlElement(name="organizationDetailId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="shortName", seachable = true),
	@HtmlElement(name="longName", seachable = true),
	
	@HtmlElement(name="type", seachable = true),
	@HtmlElement(name="parentId", label="Parent Organization", relation=@Relation(modelClass =OrganizationDetail.class, valueField = "organizationDetailId", labelField = "shortName")),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0"),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE),  @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="updateAddress", applyOn ="row")}
	
)
public class OrganizationDetailForm {
	OrganizationDetail organizationDetail;

	public OrganizationDetailForm(OrganizationDetail organizationDetail) {
		super();
		this.organizationDetail = organizationDetail;
	}
	
	
}
