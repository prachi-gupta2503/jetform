package com.adjecti.pis.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.Relation;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.pis.liferay.model.ProcessFile;

@HtmlForm(formId="TransferProcessForm_123456",
entityClass=OrganizationDetail.class, formFlowProcess = true, selectable = true,
	elements={
		@HtmlElement(name="transferProcessId", controlType=ControlType.hidden, key=true, formFlowKey = true),
		@HtmlElement(name="name", required = true),
		@HtmlElement(name="description"),
		@HtmlElement(name="processFileId", label="Process File No.", relation=@Relation(modelClass = ProcessFile.class, valueField ="processFileId", labelField = "processFileNo" )),
	})
public class TransferProcessForm {

}
