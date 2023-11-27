package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.ServiceRequestType;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.liferay.portal.kernel.model.Organization;


@HtmlForm(formId="MyRequestForm_123456",
entityClass=ServiceRequest.class, advanceFilter = true,filter = {"deleted:false"},
	elements={
	@HtmlElement(name="serviceRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId",listable = false,controlType=ControlType.hidden),
	@HtmlElement(name="organizationId",controlType=ControlType.hidden,listable = false,relation=@Relation(modelClass =Organization.class)),
	@HtmlElement(name="createDate",label="Date",controlType = ControlType.hidden),
	@HtmlElement(name="serviceRequestTypeId", label="Request Type", required = true, seachable = true, controlType = ControlType.select,relation=@Relation(modelClass =ServiceRequestType.class, valueField = "serviceRequestTypeId", labelField = "name")),//@HtmlElement(name="subject", label="Subject", seachable = true, controlType = ControlType.select, options = {"People:Personal Information", "Employee:Employement Information", "Address:Address","Joining:Joining","Post:Post","Promotion:Promotion","Qualification:Qualification","Experience:Experience","Transfer:Transfer"}),
	//@HtmlElement(name="type", label="Request Type", required = true, seachable = true, controlType = ControlType.select, options = {"Personal Information Change Request:Personal Information change", "Employement Information Change:Employement Information Change", "Address Change Request:Address Change","Joining Change Request:Joining Change","Post Change Request:Post Change","Promotion Change:Promotion Change","Qualification Change:Qualification Change Request","Experience Change:Experience Change Request","Transfer Change Request:Transfer Change"}),//@HtmlElement(name="subject", label="Subject", seachable = true, controlType = ControlType.select, options = {"People:Personal Information", "Employee:Employement Information", "Address:Address","Joining:Joining","Post:Post","Promotion:Promotion","Qualification:Qualification","Experience:Experience","Transfer:Transfer"}),
	@HtmlElement(name="description", controlType = ControlType.textarea,maxLength = 1024),
	//@HtmlElement(name="documentProofId", label="Document", controlType = ControlType.fileUpload),
	@HtmlElement(name="status",controlType = ControlType.hidden,options= {"0:Reject","1:Pending","2:Approved","3:reject","4:Return for correction"},value="1"),
	@HtmlElement(name="comments", controlType = ControlType.hidden,maxLength=1024),
	
},
			
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW, applyOn = "row",label="<i class=\"fas fa-eye\"></i>")
	,@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT, applyOn = "row",label="<i class=\"fas fa-edit\">",criterias = {"status:Return for correction"}),
	@HtmlFormAction(name=HtmlFormAction.ACTION_ADD, applyOn =  "table"),
	@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE,visible = {"deleted:2"})}
)
public class MyRequestForm {
	ServiceRequest request;
	public MyRequestForm() {
		super();
	}
}
