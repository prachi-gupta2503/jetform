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

package com.adjecti.pis.liferay.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EmployeeContact. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeContactLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactLocalService
 * @generated
 */
public class EmployeeContactLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeContactLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee contact to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeContact the employee contact
	 * @return the employee contact that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
		addEmployeeContact(
			com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return getService().addEmployeeContact(employeeContact);
	}

	public static boolean beforeUpdateEmployeeContact(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return getService().beforeUpdateEmployeeContact(entity, fieldValues);
	}

	/**
	 * Creates a new employee contact with the primary key. Does not add the employee contact to the database.
	 *
	 * @param employeeContactId the primary key for the new employee contact
	 * @return the new employee contact
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
		createEmployeeContact(long employeeContactId) {

		return getService().createEmployeeContact(employeeContactId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee contact from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeContact the employee contact
	 * @return the employee contact that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
		deleteEmployeeContact(
			com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return getService().deleteEmployeeContact(employeeContact);
	}

	/**
	 * Deletes the employee contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact that was removed
	 * @throws PortalException if a employee contact with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
			deleteEmployeeContact(long employeeContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeContact(employeeContactId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.pis.liferay.model.EmployeeContact
		fetchEmployeeContact(long employeeContactId) {

		return getService().fetchEmployeeContact(employeeContactId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.adjecti.pis.liferay.model.EmployeeContact getByPersonalNo(
		String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee contact with the primary key.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact
	 * @throws PortalException if a employee contact with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
			getEmployeeContact(long employeeContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeContact(employeeContactId);
	}

	public static com.adjecti.pis.liferay.model.EmployeeContact
			getEmployeeContactByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getService().getEmployeeContactByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of employee contacts
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
		getEmployeeContacts(int start, int end) {

		return getService().getEmployeeContacts(start, end);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
		getEmployeeContactsByEmployeeId(long employeeId) {

		return getService().getEmployeeContactsByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee contacts.
	 *
	 * @return the number of employee contacts
	 */
	public static int getEmployeeContactsCount() {
		return getService().getEmployeeContactsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeContact the employee contact
	 * @return the employee contact that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact
		updateEmployeeContact(
			com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return getService().updateEmployeeContact(employeeContact);
	}

	public static EmployeeContactLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeContactLocalService, EmployeeContactLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeContactLocalService.class);

		ServiceTracker<EmployeeContactLocalService, EmployeeContactLocalService>
			serviceTracker =
				new ServiceTracker
					<EmployeeContactLocalService, EmployeeContactLocalService>(
						bundle.getBundleContext(),
						EmployeeContactLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}