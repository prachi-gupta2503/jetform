package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.ServiceRequestType;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.liferay.portal.kernel.model.Organization;


@HtmlForm(formId="MyApprovalForm_123456",
entityClass=ServiceRequest.class, advanceFilter = true,filter = {"status:1","deleted:false"},
	elements={
	@HtmlElement(name="serviceRequestId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId",controlType=ControlType.hidden,relation=@Relation(modelClass =Employee.class, valueField = "employeeId", labelField = "fullName_En"),label="Requested By"),
	@HtmlElement(name="organizationId",controlType=ControlType.hidden,listable = false,relation=@Relation(modelClass =Organization.class)),
	
	//@HtmlElement(name="createDate",label="Date",controlType = ControlType.hidden),
	@HtmlElement(name="serviceRequestTypeId",readOnly = true, label="Request Type", required = true, seachable = true, controlType = ControlType.select,relation=@Relation(modelClass =ServiceRequestType.class, valueField = "serviceRequestTypeId", labelField = "name")),//@HtmlElement(name="subject", label="Subject", seachable = true, controlType = ControlType.select, options = {"People:Personal Information", "Employee:Employement Information", "Address:Address","Joining:Joining","Post:Post","Promotion:Promotion","Qualification:Qualification","Experience:Experience","Transfer:Transfer"}),
	//@HtmlElement(name="type", label="Request Type",readOnly = true,seachable = true, controlType = ControlType.select, options = {"Personal Information Change Request:Personal Information change", "Employement Information Change:Employement Information Change", "Address Change Request:Address Change","Joining Change Request:Joining Change","Post Change Request:Post Change","Promotion Change:Promotion Change","Qualification Change:Qualification Change Request","Experience Change:Experience Change Request","Transfer Change Request:Transfer Change"}),
	//@HtmlElement(name="subject", label="Subject", seachable = true, controlType = ControlType.select, options = {"People:Personal Information", "Employee:Employement Information", "Address:Address","Joining:Joining","Post:Post","Promotion:Promotion","Qualification:Qualification","Experience:Experience","Transfer:Transfer"}),
	@HtmlElement(name="description",readOnly = true, controlType = ControlType.textarea,maxLength = 1024),
	//@HtmlElement(name="documentProofId", label="Document", controlType = ControlType.fileUpload),
	@HtmlElement(name="status",controlType = ControlType.select,options= {"0:Created","1:Pending","2:Approved","3:Reject","4:Return for correction"},required = true),
	@HtmlElement(name="comments", controlType = ControlType.textarea,listable = false,maxLength=1024),
	
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_ADD,visible = {"deleted:2"}),
			@HtmlFormAction(name=HtmlFormAction.ACTION_VIEW, applyOn = "row",label="<i class=\"fas fa-eye\"></i>"),
			@HtmlFormAction(name="approve", applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),
			@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE, applyOn = "row",label="<i class=\"fas fa-trash-alt\"></i>")}
)
public class MyApprovalForm {

}
