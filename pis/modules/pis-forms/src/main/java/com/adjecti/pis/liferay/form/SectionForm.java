package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.UnitType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;

import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="SectionForm_123456", title="Section",
entityClass=OrganizationDetail.class, advanceFilter = true, filter= {"type:Section"},template =  "/organization/organization_add.jsp",
	elements={
//	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
//	@HtmlElement(name="parentOrganizationId", label = "Unit", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Unit"})),
//	@HtmlElement(name="expando_code", label="Section Code", seachable = true,required = true),
//	@HtmlElement(name="name", seachable = true,required=true),
//	@HtmlElement(name="expando_longName", label="Unit Type", controlType=ControlType.hidden,seachable = true),
//	@HtmlElement(name="expando_unitType", label="Long Name", seachable = true),
//	@HtmlElement(name="expando_status", label="Status", seachable = true),
//	@HtmlElement(name="type", value = "Section", controlType=ControlType.hidden,listable = false),
//	@HtmlElement(name="comments",listable = false),

	
	@HtmlElement(name="organizationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="parentId", label = "Unit", relation=@Relation(modelClass =Organization.class, valueField ="organizationId", labelField = "name", filter= {"type:Unit"})),
	@HtmlElement(name = "organizationCode", /* unique = true, */ label="Section Code", seachable = true,required = true),
	@HtmlElement(name="unitType",label = "Unit Type" ,listable = false,controlType=ControlType.hidden, relation=@Relation(modelClass = UnitType.class,valueField ="unitTypeId", labelField = "shortDiscription")),
	@HtmlElement(name="shortName",seachable = true,required=true/*,unique = true*/),
	@HtmlElement(name="longName", label="Long Name", seachable = true),
	@HtmlElement(name="type", value = "Section", controlType=ControlType.hidden,listable = false),
	@HtmlElement(name="comments",listable = false),
	@HtmlElement(name="orgStatus", label="Status", controlType=ControlType.hidden,listable = true ,seachable = true),
}, 
	//actions = {}<i class="fa fa-compress" aria-hidden="true"></i>
	
actions= {@HtmlFormAction(name = HtmlFormAction.ACTION_ADD ),
		@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW, applyOn = "row",label="View"),
		@HtmlFormAction(name = "dissolve",applyOn = "row",label = "<span title=\"Initiate Dissolve\">Initiate Dissolve</span>" ),
		@HtmlFormAction(name = "split",applyOn = "row",label = "<span  title=\"Initiate Split\">Initiate Split</span>" ),
		@HtmlFormAction(name = "merge",applyOn = "row",label = "<span  title=\"Initiate Merge\">Initiate Merge</span>" ),
		@HtmlFormAction(name = "dissolveapprover",applyOn = "row",label = "<span  title=\"Approve Dissolve\">Approve Dissolve</span>" ),
		@HtmlFormAction(name = "splitapprover",applyOn = "row",label = "<span  title=\"Approve Split\">Approve Split</span>" ),
		@HtmlFormAction(name = "mergeapprover",applyOn = "row",label = "<span  title=\"Approve Merge\">Approve Merge</span>" ),
		@HtmlFormAction(name = "history",applyOn = "row",label = "<span  title=\"History\">History</span>" ),
		@HtmlFormAction(name = HtmlFormAction.ACTION_EDIT ,applyOn = "row",label= "<span  title=\"Edit\">Edit</span>"),
		@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"}),
		@HtmlFormAction(name = "remover",applyOn = "row",label= "<span  title=\"Delete\">Delete</span>")/*,@HtmlFormAction(name="showHierarchy", applyOn ="row", label = "<i class=\"fa fa-sitemap\" aria-hidden=\"true\"></i>")*/}

)
public class SectionForm {
	Organization Organization;
}
