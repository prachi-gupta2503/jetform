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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for JetFormBuilder. This utility wraps
 * <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderLocalService
 * @generated
 */
public class JetFormBuilderLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static long approveEntity(
		String className, long classPK, long userId, String remark) {

		return getService().approveEntity(className, classPK, userId, remark);
	}

	public static String deleteEntity(
		String className, long id, boolean logical) {

		return getService().deleteEntity(className, id, logical);
	}

	public static java.util.List<Object> findAll(
		String objectClass, String attributeName, String attributeValue) {

		return getService().findAll(objectClass, attributeName, attributeValue);
	}

	public static void generateForm(String formClass)
		throws ClassNotFoundException {

		getService().generateForm(formClass);
	}

	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		getEntityWorkflow(String className, long classPK) {

		return getService().getEntityWorkflow(className, classPK);
	}

	public static java.util.List<com.adjecti.jetform.model.KeyValue>
		getListOptions(
			Class entityClass, java.util.Map<String, String> filter,
			String valueField, String labelField) {

		return getService().getListOptions(
			entityClass, filter, valueField, labelField);
	}

	public static java.util.List<com.adjecti.jetform.model.KeyValue>
		getListOptions(String formClass, String elementName) {

		return getService().getListOptions(formClass, elementName);
	}

	public static java.util.List<com.adjecti.jetform.model.KeyValue>
		getListOptions(
			String entityClass, String searchField, String searchValue,
			String valueField, String labelField) {

		return getService().getListOptions(
			entityClass, searchField, searchValue, valueField, labelField);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.adjecti.jetform.model.KeyValue
		getRelationObjectAsKeyValue(
			String objectClassName, String objectClassPK, String keyField,
			String valueField) {

		return getService().getRelationObjectAsKeyValue(
			objectClassName, objectClassPK, keyField, valueField);
	}

	public static com.adjecti.jetform.model.KeyValue
		getRelationObjectAsKeyValue(
			String formClassName, String objectClassName, String objectClassPK,
			String keyField, String valueField) {

		return getService().getRelationObjectAsKeyValue(
			formClassName, objectClassName, objectClassPK, keyField,
			valueField);
	}

	public static java.util.Map<String, String> importData(
		String formClass, java.io.File file) {

		return getService().importData(formClass, file);
	}

	public static java.util.Map<String, String> importExcel(
		String formClass, long fileEntryId) {

		return getService().importExcel(formClass, fileEntryId);
	}

	public static boolean isUnique(
		String className, long id, String fieldName, String fieldValue) {

		return getService().isUnique(className, id, fieldName, fieldValue);
	}

	public static Object readObject(String objectClassName, String classPK) {
		return getService().readObject(objectClassName, classPK);
	}

	public static com.adjecti.jetform.model.KeyValue readObjectAsKeyValue(
		String objectClassName, String objectClassPK, String keyField,
		String valueField) {

		return getService().readObjectAsKeyValue(
			objectClassName, objectClassPK, keyField, valueField);
	}

	public static java.util.List<?> readObjects(String objectClass) {
		return getService().readObjects(objectClass);
	}

	public static com.liferay.portal.kernel.json.JSONArray readObjectsAsJson(
		java.util.Map<String, String> searchFilter) {

		return getService().readObjectsAsJson(searchFilter);
	}

	public static long rejectEntity(
		String className, long classPK, long userId, String remark) {

		return getService().rejectEntity(className, classPK, userId, remark);
	}

	public static com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			Class className)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return getService().rendererForm(className);
	}

	public static com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			String className)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return getService().rendererForm(className);
	}

	public static com.adjecti.jetform.annotation.HtmlFormWrapper rendererForm(
			String className, String formClassPK)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.json.JSONException {

		return getService().rendererForm(className, formClassPK);
	}

	public static com.adjecti.jetform.annotation.HtmlFormWrapper
			rendererFormByFormFlowProcessId(
				String className, String formFlowProcessId)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().rendererFormByFormFlowProcessId(
			className, formFlowProcessId);
	}

	public static String saveForm(java.util.Map<String, Object> params) {
		return getService().saveForm(params);
	}

	public static long saveObject(
		java.util.Map<String, String[]> paramMap, Class entityClass) {

		return getService().saveObject(paramMap, entityClass);
	}

	public static long saveObject(
		java.util.Map<String, String[]> paramMap, String entityClassName) {

		return getService().saveObject(paramMap, entityClassName);
	}

	public static long saveObject(
			java.util.Map<String, String[]> paramMap, String entityClassName,
			String primaryKeyName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveObject(
			paramMap, entityClassName, primaryKeyName);
	}

	public static String unDeleteEntity(String className, long id) {
		return getService().unDeleteEntity(className, id);
	}

	public static JetFormBuilderLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<JetFormBuilderLocalService, JetFormBuilderLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			JetFormBuilderLocalService.class);

		ServiceTracker<JetFormBuilderLocalService, JetFormBuilderLocalService>
			serviceTracker =
				new ServiceTracker
					<JetFormBuilderLocalService, JetFormBuilderLocalService>(
						bundle.getBundleContext(),
						JetFormBuilderLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}