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

import com.adjecti.jetform.model.KeyValue;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for JetFormBuilder. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface JetFormBuilderService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the jet form builder remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link JetFormBuilderServiceUtil} if injection and service tracking are not available.
	 */
	public long approveEntity(
		String className, long classPK, long userId, String remark);

	public String deleteEntity(String className, long id, boolean logical);

	public void generateForm(String formClass) throws ClassNotFoundException;

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

	public Map<String, String> importExcel(String formClass, long fileEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isUnique(
		String className, long id, String fieldName, String fieldValue);

	public JSONArray readObjectsAsJson(Map<String, String> searchFilter);

	public long rejectEntity(
		String className, long classPK, long userId, String remark);

	public String saveForm(Map<String, Object> params);

	public String unDeleteEntity(String className, long id);

}