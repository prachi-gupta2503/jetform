package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.ProcessFile;
import com.liferay.portal.kernel.model.Organization;

@HtmlForm(formId="TransferProcessRequestForm_123456",
entityClass=OrganizationDetail.class,selectable = false,
	elements={
		@HtmlElement(name="transferProcessRequestId", controlType=ControlType.hidden, key=true),
		@HtmlElement(name="transferProcessId", controlType=ControlType.hidden, formFlowKey = true, listable = false),
		@HtmlElement(name="employeeId",label="Employee Name", controlType=ControlType.hidden, relation=@Relation(modelClass = Employee.class)),
		@HtmlElement(name="organizationId",label="Transfered To",relation=@Relation(modelClass = Organization.class)),
		@HtmlElement(name="transferDate",controlType=ControlType.date),
		@HtmlElement(name="officeOrderNo"),
		@HtmlElement(name="processFileId",relation=@Relation(modelClass = ProcessFile.class)),
		@HtmlElement(name="remark"),
		
	}, actions= {@HtmlFormAction(name = HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name = HtmlFormAction.ACTION_VIEW), @HtmlFormAction(name = HtmlFormAction.ACTION_DELETE)}
)

public class TransferProcessRequestForm {

}
