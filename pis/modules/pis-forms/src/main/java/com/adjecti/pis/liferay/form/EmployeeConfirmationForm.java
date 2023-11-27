package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeConfirmationForm_123456",
entityClass=EmployeeConfirmation.class, advanceFilter = true,elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeeConfirmationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name = "personalNo",controlType=ControlType.text,listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "employeeName",controlType=ControlType.text,listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name="organizationId",label="Unit",controlType=ControlType.select, relation=@Relation(modelClass = Organization.class),customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "designationId", controlType = ControlType.select, relation=@Relation(modelClass=Designation.class),customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "gradeId",controlType = ControlType.select, relation=@Relation(modelClass=Grade.class),customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name="gradeModeId",controlType=ControlType.select,relation=@Relation(modelClass=GradeMode.class),customTemplate = "/components/custom/other-info-read-only-element.jsp" ),
	@HtmlElement(name="trade", controlType=ControlType.select,relation=@Relation(modelClass=Trade.class),customTemplate = "/components/custom/other-info-read-only-element.jsp" ),
	@HtmlElement(name="joiningDate",listable=false, controlType=ControlType.text,customTemplate = "/components/custom/other-info-read-only-element.jsp" ),
	@HtmlElement(name="confirmationPostId", label="Confirmed Post", controlType=ControlType.select, relation=@Relation(modelClass = Post.class, valueField = "postId" ,labelField = "name_En")),
	@HtmlElement(name="confirmationDate", controlType=ControlType.date,required=true),
	@HtmlElement(name="confirmationLetterId",listable=false,required=true, controlType=ControlType.fileUpload,accept = "image/png, image/jpeg, application/pdf"),
},
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeConfirmationForm {
	EmployeeConfirmation employeeConfirmation;
	public EmployeeConfirmationForm() {
		super();
	}
}
