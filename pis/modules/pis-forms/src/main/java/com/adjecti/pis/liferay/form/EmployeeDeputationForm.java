package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.mdm.liferay.model.DeputationType;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.pis.liferay.model.EmployeeDeputation;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeDeputationForm_123456",
entityClass=EmployeeDeputation.class, advanceFilter = true,elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeeDeputationId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name = "personalNo",controlType=ControlType.text,listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "employeeName",controlType=ControlType.text,listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "gradeId",label="Present Grade",controlType=ControlType.select, relation=@Relation(modelClass = Grade.class),listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name = "organizationId",label="Present Unit",controlType=ControlType.select, relation=@Relation(modelClass = Organization.class),listable = false,customTemplate = "/components/custom/other-info-read-only-element.jsp"),
	@HtmlElement(name="ministryId", controlType=ControlType.select),
	@HtmlElement(name="departmentId", controlType=ControlType.select),
	@HtmlElement(name="fromDate", controlType=ControlType.date,dateBefore="{today}",required=true),
	@HtmlElement(name="toDate", controlType=ControlType.date,dateBefore="{today}",dateAfter="fromDate",required=true),
	@HtmlElement(name="deputationTypeId", controlType=ControlType.select, relation=@Relation(modelClass = DeputationType.class)),
	@HtmlElement(name="deputatedPostId", controlType=ControlType.select, relation=@Relation(modelClass = Post.class, valueField = "postId" ,labelField = "name_En")),
	@HtmlElement(name="remark",listable=false, controlType=ControlType.textarea,maxLength = 100),
	@HtmlElement(name="officeAddress",listable=false, controlType=ControlType.textarea,maxLength = 100),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD)}
)
public class EmployeeDeputationForm {
	EmployeeDeputation employeeDeputation;
	public EmployeeDeputationForm() {
		super();
	}
}
