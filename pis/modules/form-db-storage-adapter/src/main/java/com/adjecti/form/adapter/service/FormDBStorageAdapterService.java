package com.adjecti.form.adapter.service;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.service.ServiceContext;

public interface FormDBStorageAdapterService {

	public void deleteRecord(long recordId);
	public void getRecord(long reordId);
	public void saveForm(long recordId, long formInstanceId, DDMFormValues formValues, ServiceContext serviceContext);
}
