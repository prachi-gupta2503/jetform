package com.adjecti.jetform.liferay.helper;

import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public interface JetFormDataHelper {

	String saveForm(Map<String, Object> params,HtmlFormWrapper form);

	Map<String, String> importData(String formClass, File file,HtmlFormWrapper form);

	Map<String, String> importExcel(String formClass, long fileEntryId,HtmlFormWrapper form);

	String deleteEntity(String className, long id, boolean logical);

	String unDeleteEntity(String className, long id);

	JSONArray readObjectsAsJson(Map<String, String> searchFilter,HtmlFormWrapper form);

	List<?> readObjects(Class<?> objectClass);

	Object readObject(String objectClassName, String classPK);

	Map<String, Object> getRelationObjects(Map<String, Object> relationEntities, String baseAttribute,
			Class entityClass, Object model, boolean recursive);

	List<Object> findAll(String objectClass, String attributeName, String attributeValue);

	Object findFirst(String objectClass, String attributeName, String attributeValue);

	List<?> readObjects(String objectClass);

	KeyValue getRelationObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField,
			String valueField);

	KeyValue getRelationObjectAsKeyValue(String formClassName, String objectClassName, String objectClassPK,
			String keyField, String valueField);

	KeyValue readObjectAsKeyValue(String objectClassName, String objectClassPK, String keyField, String valueField);

	long saveObject(Map<String, String[]> paramMap, Class entityClass, String primaryKeyName) throws PortalException;

	List<KeyValue> getListOptions(String entityClass, String searchField, String searchValue, String valueField,
			String labelField);

	List<KeyValue> getListOptions(Class entityClass, Map<String, String> filter, String valueField, String labelField);

	long approveEntity(String className, long classPK, long userId, String remark);

	long rejectEntity(String className, long classPK, long userId, String remark);

	List<KeyValue> getListOptions(String formClass, String elementName, HtmlFormWrapper form);

	boolean isUnique(String className, long id, String fieldName, String fieldValue);

}
