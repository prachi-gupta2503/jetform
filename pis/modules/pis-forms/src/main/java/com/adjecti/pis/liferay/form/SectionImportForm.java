package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

@HtmlForm(formId="SectionImportForm_123456", title="Import Section",
entityClass=OrganizationDetail.class, advanceFilter = true,
	elements={
	@HtmlElement(name="organizationDetailId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentId", label = "Unit Code", relation=@Relation(modelClass =OrganizationDetail.class, valueField ="organizationDetailId", labelField = "organizationCode")),
	@HtmlElement(name="organizationCode",label = "Section Code"),
	@HtmlElement(name="shortName", label = "Short Description"),
	@HtmlElement(name="longName", label = "Long Description"),
	@HtmlElement(name="type", value = "Section", controlType=ControlType.hidden),
})
public class SectionImportForm {
	OrganizationDetail OrganizationDetail;
}
