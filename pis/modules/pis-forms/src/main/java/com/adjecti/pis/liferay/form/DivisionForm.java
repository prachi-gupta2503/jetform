package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="DivisionForm_123456", title="Division",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Division"},template =  "/organization/organization_add.jsp",
	elements={
	/*
	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentOrganizationId", label = "Organization", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Organization"})),
	@HtmlElement(name="expando_code", label="Division Code", seachable = true,required = true),
	@HtmlElement(name="name", seachable = true,required=true),
	@HtmlElement(name="expando_longName", label="Long Name", seachable = true),
	@HtmlElement(name="type", value = "Division", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="comments",listable = false),
	*/
			@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
			@HtmlElement(name="parentId", label = "Organization", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Organization"})),
			@HtmlElement(name="organizationCode",label="Division Code", seachable = true,required = true),
			@HtmlElement(name="unitType",label = "Unit Type" , controlType = ControlType.hidden,listable = false),
			@HtmlElement(name = "shortName", seachable = true, required = true/* ,unique = true */),
			@HtmlElement(name="longName", label="Long Name", seachable = true),
			@HtmlElement(name="type", value = "Division", controlType=ControlType.hidden,listable = false),
			@HtmlElement(name="comments",listable = false),
			
},
	/*actions = {}*/
	actions= {@HtmlFormAction(name = HtmlFormAction.ACTION_ADD )
	,@HtmlFormAction(name = HtmlFormAction.ACTION_EDIT ,applyOn = "row",label="<i class=\"fas fa-edit\"></i>")
	,@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"})
	/*,@HtmlFormAction(name = "remover",applyOn = "row",label="<i class=\"fas fa-trash-alt\" style=\"color:red\"></i>"),@HtmlFormAction(name="showHierarchy", applyOn ="row", label = "<i class=\"fa fa-sitemap\" aria-hidden=\"true\"></i>")*/}

)
public class DivisionForm {
	Organization Organization;
}
