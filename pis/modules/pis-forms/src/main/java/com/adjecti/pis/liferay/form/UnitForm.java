package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.UnitType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;

import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="UnitForm_123456", title="Unit",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Unit"},template =  "/organization/organization_add.jsp",
	elements={
	/*@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentOrganizationId", label = "Division", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Division"})),
	@HtmlElement(name="expando_code", label="Unit Code", seachable = true,required = true),
	@HtmlElement(name="expando_unitType",label = "Unit Type" , relation=@Relation(modelClass = UnitType.class,valueField ="unitTypeId", labelField = "shortDiscription")),
	@HtmlElement(name="name", seachable = true,required=true),
	@HtmlElement(name="expando_longName", label="Long Name", seachable = true),
	@HtmlElement(name="type", value = "Unit", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="comments",listable = false),*/
			
	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentId", label = "Division", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Division"})),
	@HtmlElement(name="organizationCode", label="Unit Code", seachable = true,required = true),
	@HtmlElement(name="unitType",label = "Unit Type" , relation=@Relation(modelClass = UnitType.class,valueField ="unitTypeId", labelField = "shortDiscription")),
	@HtmlElement(name = "shortName", seachable = true, required = true/* ,unique = true */),
	@HtmlElement(name="longName", label="Long Name", seachable = true),
	@HtmlElement(name="type", value = "Unit", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="comments",listable = false),
	@HtmlElement(name="deleted", controlType=ControlType.hidden, value="0",listable = false),
	
		
},
	/*actions = {}*/
	actions= {@HtmlFormAction(name = HtmlFormAction.ACTION_ADD ),@HtmlFormAction(name = HtmlFormAction.ACTION_EDIT ,applyOn = "row",label="<i class=\"fas fa-edit\"></i>"),@HtmlFormAction(name = "remover",applyOn = "row",label="<i class=\"fas fa-trash-alt\" style=\"color:red\"></i>"),@HtmlFormAction(name="updateAddress", applyOn ="row", label = "<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"})/*,@HtmlFormAction(name="showHierarchy", applyOn ="row", label = "<i class=\"fa fa-sitemap\" aria-hidden=\"true\"></i>")*/}

)
public class UnitForm {
	Organization Organization;
}
