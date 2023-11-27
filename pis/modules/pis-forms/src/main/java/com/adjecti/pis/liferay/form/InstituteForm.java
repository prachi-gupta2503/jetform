package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.UnitType;
import com.liferay.portal.kernel.model.Organization;




@HtmlForm(formId="InstituteForm_123456", title="Institute",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Institute"},template =  "/organization/organization_add.jsp",
	elements={
/*	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentOrganizationId", controlType = ControlType.hidden,value="0",listable = false),
	@HtmlElement(name="expando_code", label="Institute Code",seachable = true,required = true),
	@HtmlElement(name="expando_unitType",label = "Unit Type" , controlType = ControlType.hidden),
	@HtmlElement(name="name", seachable = true,required=true),
	@HtmlElement(name="expando_longName", label="Long Name", seachable = true),
	@HtmlElement(name="type", value = "Institute", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="comments",listable = false),*/
			@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
			@HtmlElement(name="parentId", controlType = ControlType.hidden,value="0",listable = false),
			@HtmlElement(name="organizationCode",label="Institute Code",seachable = true,required = true),
			@HtmlElement(name="unitType",label = "Unit Type" , controlType = ControlType.hidden,listable = false),
		    @HtmlElement(name = "shortName", seachable = true, required = true/* ,unique = true */),
			@HtmlElement(name="longName", label="Long Name", seachable = true),
			@HtmlElement(name="type", value = "Institute", controlType=ControlType.hidden,listable = false),
			@HtmlElement(name="comments",listable = false),
},
	actions= {@HtmlFormAction(name = HtmlFormAction.ACTION_ADD ),
			@HtmlFormAction(name = HtmlFormAction.ACTION_EDIT ,applyOn = "row",label="<i class=\"fas fa-edit\"></i>"),
			@HtmlFormAction(name = "remover",applyOn = "row",label="<i class=\"fas fa-trash-alt\" style=\"color:red\"></i>"),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"})
	/*,@HtmlFormAction(name="showHierarchy", applyOn ="row", label = "<i class=\"fa fa-sitemap\" aria-hidden=\"true\"></i>")*/}

	)
public class InstituteForm {

}
