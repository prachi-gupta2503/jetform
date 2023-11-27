package com.adjecti.form.adapter.service.impl;

import com.adjecti.form.adapter.model.TableModel;
import com.adjecti.form.adapter.persistence.FormDBStoragePersistence;
import com.adjecti.form.adapter.service.FormDBStorageAdapterService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class FormDBStorageAdapterServiceImpl implements FormDBStorageAdapterService{

	
	@Reference
	FormDBStoragePersistence formDBStoragePersistence;

	@Override
	public void deleteRecord(long recordId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRecord(long reordId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void saveForm(long recordId, long formInstanceId, DDMFormValues formValues, ServiceContext serviceContext) {

		try {
			DDMStructure structure = DDMFormInstanceLocalServiceUtil.getDDMFormInstance(formInstanceId).getStructure();
			List<TableModel> modelList = getValueMap(structure, formValues);
			User user = serviceContext.getThemeDisplay().getUser();
			
			formDBStoragePersistence.saveData(getString(structure.getNameCurrentValue()), recordId, formInstanceId, structure.getGroupId(), structure.getCompanyId(), user.getUserId(), user.getFullName(), new Date(), modelList);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * Get column value map from DDMFormValues
	 */
	private List<TableModel> getValueMap(DDMStructure structure, DDMFormValues formValues) {
		List<TableModel> modelList = new ArrayList<TableModel>();
		Locale locale = formValues.getDefaultLocale();
		try {
			List<DDMFormFieldValue> formFieldValues = formValues.getDDMFormFieldValues();
			for (DDMFormFieldValue fieldValue : formFieldValues) {
				TableModel model = new TableModel();
				String value= fieldValue.getValue() == null ? "" :fieldValue.getValue().getString(locale);
				String field = getString(structure.getFieldLabel(fieldValue.getName(), locale));

				System.out.println("Field : "+field + " Value : "+value+ " Type : "+fieldValue.getType());
				
				model.setColumnName(field);
				model.setColumnType(getColumnType(fieldValue.getType()));
				model.setColumnValue(value);
				modelList.add(model);
//				System.out.println(fieldValue.getType()+" : 1111");
			}
		} catch (PortalException e) {

			System.err.println(e.getMessage());
		}
		return modelList;
	}
	
	private String getColumnType(String fieldType) {
		if (fieldType.matches("text|radio|select")) {
			return "varchar(150)";
		} else if(fieldType.matches("checkbox_multiple|rich_text")) {
			return "text";
		} else if(fieldType.equalsIgnoreCase("numeric")) {
			return "bigint";
		} else if(fieldType.equalsIgnoreCase("date")) {
			return "DATETIME";
		} else if (fieldType.equalsIgnoreCase("image")) {
			return "text";
		}
			

		return "";
	}
	/*
	 * remove whitespace 
	 * return string in lowercase
	 */
	private String getString( String str) {
			str = str.replaceAll("\\s", "").toLowerCase();
		return str;
	}


}
