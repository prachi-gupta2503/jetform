package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElement.ValidType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="EmployeeJoiningForm_123456",
entityClass=EmployeeJoining.class, advanceFilter = true, elementsPerRow = 2,
	elements={
	@HtmlElement(name="employeeJoiningId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="employeeId", controlType=ControlType.hidden, listable = false),
	@HtmlElement(name="joiningProcessId", controlType=ControlType.hidden, formFlowKey = true, listable = false),
	@HtmlElement(name = "organizationId",label="Unit",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Unit"}),customTemplate = "/components/custom/unit-select-element.jsp"),
	@HtmlElement(name = "subOrganizationId",label="Section",required = true, seachable = true, controlType = ControlType.select, relation=@Relation(modelClass=OrganizationDetail.class, valueField="organizationDetailId", labelField="shortName", filter = {"type:Section"}), depends = "organizationId", customTemplate = "/components/custom/section-select-element.jsp"),
	@HtmlElement(name="designationId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = Designation.class, valueField = "designationId", labelField = "name_En")),
	@HtmlElement(name="gradeId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = Grade.class),depends = "designationId", customTemplate = "/components/custom/desig-grade-select-element.jsp"),
	@HtmlElement(name="gradeModeId",required=true,listable = false, controlType=ControlType.select, relation=@Relation(modelClass = GradeMode.class)),
	@HtmlElement(name="joiningModeId",required=true,  controlType=ControlType.select, relation=@Relation(modelClass = JoiningMode.class)),
	@HtmlElement(name="tradeId",required=true, controlType=ControlType.select, relation=@Relation(modelClass = Trade.class)),
	@HtmlElement(name="recruitmentBatch", controlType=ControlType.year,listable = false),
	//@HtmlElement(name="postId", controlType=ControlType.select, relation=@Relation(modelClass = Post.class)),
	@HtmlElement(name="fromDate", controlType=ControlType.date,dateBefore="{today}",required = true),
	@HtmlElement(name="toDate", controlType=ControlType.date,dateBefore="{today}", dateAfter="fromDate",required = true),
	@HtmlElement(name="selectionDate", controlType=ControlType.date ,dateBefore="{today}",listable = false),
    @HtmlElement(name="dateOfJoining", controlType=ControlType.date,dateBefore="{today}",listable = false,required=true),
	@HtmlElement(name="confirmationDate", controlType=ControlType.date,dateBefore="{today}",listable = false),
	@HtmlElement(name="gradeConfirmationDate", controlType=ControlType.date,dateBefore="{today}",listable = false),
	@HtmlElement(name="govtServiceDate", controlType=ControlType.date,dateBefore="{today}",listable = false),
	@HtmlElement(name="postBox",required=true),
	@HtmlElement(name = "rank",required=true, min=0,validType = ValidType.digits,listable=false),
	@HtmlElement(name="joiningLetterId",listable = false,controlType = ControlType.fileUpload,  required = true,accept = "image/png, image/jpeg, application/pdf")
	
	//@HtmlElement(name="organizationId", controlType=ControlType.select, relation=@Relation(modelClass = Organization.class), customTemplate = "/cmponents/custom/unit-select-element.jsp"),
	//@HtmlElement(name="subOrganizationId", controlType=ControlType.select, relation=@Relation(modelClass = Organization.class), customTemplate = "/cmponents/custom/section-select-element.jsp"),
	
	
	
	//@HtmlElement(name="designationGroupId", controlType=ControlType.select, relation=@Relation(modelClass = DesignationGroup.class), customTemplate = "/mdm/designation-group-element.jsp"),
	
	
	//@HtmlElement(name="dateOfJoiningOrganization", controlType=ControlType.date),
}, 
	actions = {@HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_ADD),@HtmlFormAction(name="approve",applyOn = "row",label="<i class=\"fa fa-check\" aria-hidden=\"true\"></i>"),@HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)}
)
public class EmployeeJoiningForm {
	EmployeeJoining employeeJoining;
	public EmployeeJoiningForm() {
		super();
	}
}
