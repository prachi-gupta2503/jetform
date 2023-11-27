package com.adjecti.mdm.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="OrganizationForm_123456",
entityClass=Organization.class, advanceFilter = true,template = "/organization/organization_add.jsp",
	elements={
	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="expando_code", label="Code", seachable = true,required = true),
	@HtmlElement(name="name", seachable = true,required=true),
	@HtmlElement(name="expando_longName", label="Long Name", seachable = true),
	@HtmlElement(name="type",required=true, seachable = true,controlType = ControlType.select, label = "Type",options = {"Organization:Organization","Division:Division","Unit:Unit","Section:Section"}),
//	@HtmlElement(name="countryId", seachable = true,relation=@Relation(modelClass =Country.class, valueField = "countryId", labelField = "name"),controlType = ControlType.select),
	@HtmlElement(name="parentOrganizationId", label="Parent Organization", seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=Organization.class, valueField="organizationId", labelField="name"),  customTemplate = "/components/custom/organization-parent-select-element.jsp"),
	@HtmlElement(name="comments")
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE),  @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="updateAddress", applyOn ="row", label = "<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>")/*,@HtmlFormAction(name="showHierarchy", applyOn ="row", label = "<i class=\"fa fa-sitemap\" aria-hidden=\"true\"></i>")*/}
	
)
public class OrganizationForm {

	Organization organization;	
} 
