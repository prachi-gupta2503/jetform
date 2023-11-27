package com.adjecti.jetform.liferay.form;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.liferay.model.ImportMasterEntity;

@HtmlForm(formId="ImportMasterEntityForm_123456",
entityClass=ImportMasterEntity.class,
	elements={
	@HtmlElement(name="importMasterEntityId", controlType=ControlType.hidden, key=true),
	@HtmlElement(name="name"),
	@HtmlElement(name="entityClass", controlType=ControlType.select ),
	@HtmlElement(name="importFileId", placeHolder="Upload File", controlType=ControlType.fileUpload),
	@HtmlElement(name="description")
})
public class ImportDataForm {
}
