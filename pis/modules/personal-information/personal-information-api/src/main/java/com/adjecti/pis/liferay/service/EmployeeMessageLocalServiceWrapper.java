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
 * Provides a wrapper for {@link EmployeeMessageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeMessageLocalService
 * @generated
 */
public class EmployeeMessageLocalServiceWrapper
	implements EmployeeMessageLocalService,
			   ServiceWrapper<EmployeeMessageLocalService> {

	public EmployeeMessageLocalServiceWrapper(
		EmployeeMessageLocalService employeeMessageLocalService) {

		_employeeMessageLocalService = employeeMessageLocalService;
	}

	/**
	 * Adds the employee message to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeMessage the employee message
	 * @return the employee message that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage addEmployeeMessage(
		com.adjecti.pis.liferay.model.EmployeeMessage employeeMessage) {

		return _employeeMessageLocalService.addEmployeeMessage(employeeMessage);
	}

	/**
	 * Creates a new employee message with the primary key. Does not add the employee message to the database.
	 *
	 * @param employeeMessageId the primary key for the new employee message
	 * @return the new employee message
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage createEmployeeMessage(
		long employeeMessageId) {

		return _employeeMessageLocalService.createEmployeeMessage(
			employeeMessageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeMessageLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee message from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeMessage the employee message
	 * @return the employee message that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage deleteEmployeeMessage(
		com.adjecti.pis.liferay.model.EmployeeMessage employeeMessage) {

		return _employeeMessageLocalService.deleteEmployeeMessage(
			employeeMessage);
	}

	/**
	 * Deletes the employee message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message that was removed
	 * @throws PortalException if a employee message with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage deleteEmployeeMessage(
			long employeeMessageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeMessageLocalService.deleteEmployeeMessage(
			employeeMessageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeMessageLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeMessageLocalService.dynamicQuery();
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

		return _employeeMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeMessageModelImpl</code>.
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

		return _employeeMessageLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeMessageModelImpl</code>.
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

		return _employeeMessageLocalService.dynamicQuery(
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

		return _employeeMessageLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeMessageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage fetchEmployeeMessage(
		long employeeMessageId) {

		return _employeeMessageLocalService.fetchEmployeeMessage(
			employeeMessageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeMessageLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee message with the primary key.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message
	 * @throws PortalException if a employee message with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage getEmployeeMessage(
			long employeeMessageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeMessageLocalService.getEmployeeMessage(
			employeeMessageId);
	}

	/**
	 * Returns a range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of employee messages
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeMessage>
		getEmployeeMessages(int start, int end) {

		return _employeeMessageLocalService.getEmployeeMessages(start, end);
	}

	/**
	 * Returns the number of employee messages.
	 *
	 * @return the number of employee messages
	 */
	@Override
	public int getEmployeeMessagesCount() {
		return _employeeMessageLocalService.getEmployeeMessagesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeMessageLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeMessageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeMessage the employee message
	 * @return the employee message that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeMessage updateEmployeeMessage(
		com.adjecti.pis.liferay.model.EmployeeMessage employeeMessage) {

		return _employeeMessageLocalService.updateEmployeeMessage(
			employeeMessage);
	}

	@Override
	public EmployeeMessageLocalService getWrappedService() {
		return _employeeMessageLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeMessageLocalService employeeMessageLocalService) {

		_employeeMessageLocalService = employeeMessageLocalService;
	}

	private EmployeeMessageLocalService _employeeMessageLocalService;

}