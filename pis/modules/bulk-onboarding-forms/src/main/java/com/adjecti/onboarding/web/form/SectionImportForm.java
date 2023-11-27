package com.adjecti.onboarding.web.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="SectionImportForm_123456", title="Import Section",
entityClass=OrganizationDetail.class, advanceFilter = true,
	elements={
	@HtmlElement(name="organizationDetailId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="unitCode",label = "Unit Code"),
	@HtmlElement(name="sectionCode",label = "Section Code"),
	@HtmlElement(name="shortName", label = "Short Description"),
	@HtmlElement(name="longName", label = "Long Description"),
	@HtmlElement(name="type", value = "Section", controlType=ControlType.hidden),
})
public class SectionImportForm {
	OrganizationDetail OrganizationDetail;
}
