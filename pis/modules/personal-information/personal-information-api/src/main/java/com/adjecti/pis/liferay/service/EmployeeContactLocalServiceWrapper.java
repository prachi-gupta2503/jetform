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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactLocalService
 * @generated
 */
public class EmployeeContactLocalServiceWrapper
	implements EmployeeContactLocalService,
			   ServiceWrapper<EmployeeContactLocalService> {

	public EmployeeContactLocalServiceWrapper(
		EmployeeContactLocalService employeeContactLocalService) {

		_employeeContactLocalService = employeeContactLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact addEmployeeContact(
		com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return _employeeContactLocalService.addEmployeeContact(employeeContact);
	}

	@Override
	public boolean beforeUpdateEmployeeContact(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return _employeeContactLocalService.beforeUpdateEmployeeContact(
			entity, fieldValues);
	}

	/**
	 * Creates a new employee contact with the primary key. Does not add the employee contact to the database.
	 *
	 * @param employeeContactId the primary key for the new employee contact
	 * @return the new employee contact
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact createEmployeeContact(
		long employeeContactId) {

		return _employeeContactLocalService.createEmployeeContact(
			employeeContactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeContactLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact deleteEmployeeContact(
		com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return _employeeContactLocalService.deleteEmployeeContact(
			employeeContact);
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact deleteEmployeeContact(
			long employeeContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeContactLocalService.deleteEmployeeContact(
			employeeContactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeContactLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeContactLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeContactLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeContactLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeContactLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeContactLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeContactLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact fetchEmployeeContact(
		long employeeContactId) {

		return _employeeContactLocalService.fetchEmployeeContact(
			employeeContactId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeContactLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact getByPersonalNo(
		String personalNo) {

		return _employeeContactLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee contact with the primary key.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact
	 * @throws PortalException if a employee contact with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact getEmployeeContact(
			long employeeContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeContactLocalService.getEmployeeContact(
			employeeContactId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact
			getEmployeeContactByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return _employeeContactLocalService.getEmployeeContactByEmployeeId(
			employeeId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
		getEmployeeContacts(int start, int end) {

		return _employeeContactLocalService.getEmployeeContacts(start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
		getEmployeeContactsByEmployeeId(long employeeId) {

		return _employeeContactLocalService.getEmployeeContactsByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the number of employee contacts.
	 *
	 * @return the number of employee contacts
	 */
	@Override
	public int getEmployeeContactsCount() {
		return _employeeContactLocalService.getEmployeeContactsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeContactLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeContactLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeContactLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact updateEmployeeContact(
		com.adjecti.pis.liferay.model.EmployeeContact employeeContact) {

		return _employeeContactLocalService.updateEmployeeContact(
			employeeContact);
	}

	@Override
	public EmployeeContactLocalService getWrappedService() {
		return _employeeContactLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeContactLocalService employeeContactLocalService) {

		_employeeContactLocalService = employeeContactLocalService;
	}

	private EmployeeContactLocalService _employeeContactLocalService;

}