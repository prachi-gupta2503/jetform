package com.adjecti.form.adapter;

import com.adjecti.form.adapter.service.FormDBStorageAdapterService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.dynamic.data.mapping.exception.StorageException;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesSerializer;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapter;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterDeleteRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterDeleteResponse;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterGetRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterGetResponse;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterSaveRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterSaveResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = "ddm.storage.adapter.type=form-db-storage-adapter",
		service = DDMStorageAdapter.class
)
public class FormDBStorageAdapter implements DDMStorageAdapter{
	
	private static final Log log = LogFactoryUtil.getLog(FormDBStorageAdapter.class);
	

	@Reference(target = "(ddm.storage.adapter.type=json)")
	private DDMStorageAdapter _ddmStorageAdapter;
	
	@Reference
	protected DDMContentLocalService ddmContentLocalService;
	
	@Reference
	DDMStructureLocalService ddmStructureLocalService;
	
	@Reference
	private FormDBStorageAdapterService formDBStorageAdapterService;
	
	@Reference(target = "(ddm.form.values.deserializer.type=json)")
	protected DDMFormValuesDeserializer jsonDDMFormValuesDeserializer;

	@Reference(target = "(ddm.form.values.serializer.type=json)")
	protected DDMFormValuesSerializer jsonDDMFormValuesSerializer;


	@Override
	public DDMStorageAdapterDeleteResponse delete(DDMStorageAdapterDeleteRequest ddmStorageAdapterDeleteRequest)
			throws StorageException {
		long recordId = ddmStorageAdapterDeleteRequest.getPrimaryKey();
		
		formDBStorageAdapterService.deleteRecord(recordId);
		
		return _ddmStorageAdapter.delete(ddmStorageAdapterDeleteRequest);
	}

	@Override
	public DDMStorageAdapterGetResponse get(DDMStorageAdapterGetRequest ddmStorageAdapterGetRequest)
			throws StorageException {

		
		long reordId = ddmStorageAdapterGetRequest.getPrimaryKey();
		formDBStorageAdapterService.getRecord(reordId);
		
		return _ddmStorageAdapter.get(ddmStorageAdapterGetRequest);
	}


	
	@Override
	public DDMStorageAdapterSaveResponse save(DDMStorageAdapterSaveRequest ddmStorageAdapterSaveRequest)
			throws StorageException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		HttpSession session = serviceContext.getRequest().getSession(true);
		Long recordId = CounterLocalServiceUtil.increment ();


//		DDMContent ddmContent = ddmContentLocalService.addContent(userId, groupId, name, description, data, serviceContext)
		
		long formInstanceId = (long) session.getAttribute("formInstanceId");
//		long recordId = ddmStorageAdapterSaveRequest.getPrimaryKey();
		DDMFormValues formValues = ddmStorageAdapterSaveRequest.getDDMFormValues();
		
		formDBStorageAdapterService.saveForm(recordId, formInstanceId, formValues, serviceContext);
		
		log.info(" Form Storage Adapter value stored !!!");
		_ddmStorageAdapter.save(ddmStorageAdapterSaveRequest);
		DDMStorageAdapterSaveResponse.Builder builder =
				DDMStorageAdapterSaveResponse.Builder.newBuilder(recordId);
		return builder.build();
	}
	
}
