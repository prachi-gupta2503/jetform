/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.jetform.liferay.service;

import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.jetform.model.KeyValue;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for JetFormBuilder. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface JetFormBuilderLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the jet form builder local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link JetFormBuilderLocalServiceUtil} if injection and service tracking are not available.
	 */
	public long approveEntity(
		String className, long classPK, long userId, String remark);

	public String deleteEntity(String className, long id, boolean logical);

	public List<Object> findAll(
		String objectClass, String attributeName, String attributeValue);

	public void generateForm(String formClass) throws ClassNotFoundException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityWorkflow getEntityWorkflow(String className, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KeyValue> getListOptions(
		Class entityClass, Map<String, String> filter, String valueField,
		String labelField);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KeyValue> getListOptions(String formClass, String elementName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KeyValue> getListOptions(
		String entityClass, String searchField, String searchValue,
		String valueField, String labelField);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KeyValue getRelationObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KeyValue getRelationObjectAsKeyValue(
		String formClassName, String objectClassName, String objectClassPK,
		String keyField, String valueField);

	public Map<String, String> importData(String formClass, File file);

	public Map<String, String> importExcel(String formClass, long fileEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isUnique(
		String className, long id, String fieldName, String fieldValue);

	public Object readObject(String objectClassName, String classPK);

	public KeyValue readObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField);

	public List<?> readObjects(String objectClass);

	public JSONArray readObjectsAsJson(Map<String, String> searchFilter);

	public long rejectEntity(
		String className, long classPK, long userId, String remark);

	public HtmlFormWrapper rendererForm(Class className)
		throws ClassNotFoundException, JSONException;

	public HtmlFormWrapper rendererForm(String className)
		throws ClassNotFoundException, JSONException;

	public HtmlFormWrapper rendererForm(String className, String formClassPK)
		throws ClassNotFoundException, JSONException;

	public HtmlFormWrapper rendererFormByFormFlowProcessId(
			String className, String formFlowProcessId)
		throws JSONException;

	public String saveForm(Map<String, Object> params);

	public long saveObject(Map<String, String[]> paramMap, Class entityClass);

	public long saveObject(
		Map<String, String[]> paramMap, String entityClassName);

	public long saveObject(
			Map<String, String[]> paramMap, String entityClassName,
			String primaryKeyName)
		throws PortalException;

	public String unDeleteEntity(String className, long id);

}