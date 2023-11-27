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
 * Provides the remote service utility for JetFormBuilder. This utility wraps
 * <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see JetFormBuilderService
 * @generated
 */
public class JetFormBuilderServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.jetform.liferay.service.impl.JetFormBuilderServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static long approveEntity(
		String className, long classPK, long userId, String remark) {

		return getService().approveEntity(className, classPK, userId, remark);
	}

	public static String deleteEntity(
		String className, long id, boolean logical) {

		return getService().deleteEntity(className, id, logical);
	}

	public static void generateForm(String formClass)
		throws ClassNotFoundException {

		getService().generateForm(formClass);
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

	public static java.util.Map<String, String> importExcel(
		String formClass, long fileEntryId) {

		return getService().importExcel(formClass, fileEntryId);
	}

	public static boolean isUnique(
		String className, long id, String fieldName, String fieldValue) {

		return getService().isUnique(className, id, fieldName, fieldValue);
	}

	public static com.liferay.portal.kernel.json.JSONArray readObjectsAsJson(
		java.util.Map<String, String> searchFilter) {

		return getService().readObjectsAsJson(searchFilter);
	}

	public static long rejectEntity(
		String className, long classPK, long userId, String remark) {

		return getService().rejectEntity(className, classPK, userId, remark);
	}

	public static String saveForm(java.util.Map<String, Object> params) {
		return getService().saveForm(params);
	}

	public static String unDeleteEntity(String className, long id) {
		return getService().unDeleteEntity(className, id);
	}

	public static JetFormBuilderService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JetFormBuilderService, JetFormBuilderService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JetFormBuilderService.class);

		ServiceTracker<JetFormBuilderService, JetFormBuilderService>
			serviceTracker =
				new ServiceTracker
					<JetFormBuilderService, JetFormBuilderService>(
						bundle.getBundleContext(), JetFormBuilderService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}