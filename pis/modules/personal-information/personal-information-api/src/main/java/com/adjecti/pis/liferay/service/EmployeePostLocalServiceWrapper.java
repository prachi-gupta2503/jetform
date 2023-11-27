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
 * Provides a wrapper for {@link EmployeePostLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostLocalService
 * @generated
 */
public class EmployeePostLocalServiceWrapper
	implements EmployeePostLocalService,
			   ServiceWrapper<EmployeePostLocalService> {

	public EmployeePostLocalServiceWrapper(
		EmployeePostLocalService employeePostLocalService) {

		_employeePostLocalService = employeePostLocalService;
	}

	/**
	 * Adds the employee post to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePost the employee post
	 * @return the employee post that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost addEmployeePost(
		com.adjecti.pis.liferay.model.EmployeePost employeePost) {

		return _employeePostLocalService.addEmployeePost(employeePost);
	}

	/**
	 * Creates a new employee post with the primary key. Does not add the employee post to the database.
	 *
	 * @param employeePostId the primary key for the new employee post
	 * @return the new employee post
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost createEmployeePost(
		long employeePostId) {

		return _employeePostLocalService.createEmployeePost(employeePostId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePostLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee post from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePost the employee post
	 * @return the employee post that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost deleteEmployeePost(
		com.adjecti.pis.liferay.model.EmployeePost employeePost) {

		return _employeePostLocalService.deleteEmployeePost(employeePost);
	}

	/**
	 * Deletes the employee post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post that was removed
	 * @throws PortalException if a employee post with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost deleteEmployeePost(
			long employeePostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePostLocalService.deleteEmployeePost(employeePostId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePostLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePostLocalService.dynamicQuery();
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

		return _employeePostLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePostModelImpl</code>.
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

		return _employeePostLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePostModelImpl</code>.
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

		return _employeePostLocalService.dynamicQuery(
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

		return _employeePostLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeePostLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePost fetchEmployeePost(
		long employeePostId) {

		return _employeePostLocalService.fetchEmployeePost(employeePostId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePostLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePost>
		getByEmployeeId(long employeeId) {

		return _employeePostLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePost>
		getByPersonalNo(String personalNo) {

		return _employeePostLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee post with the primary key.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post
	 * @throws PortalException if a employee post with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost getEmployeePost(
			long employeePostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePostLocalService.getEmployeePost(employeePostId);
	}

	/**
	 * Returns a range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @return the range of employee posts
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePost>
		getEmployeePosts(int start, int end) {

		return _employeePostLocalService.getEmployeePosts(start, end);
	}

	/**
	 * Returns the number of employee posts.
	 *
	 * @return the number of employee posts
	 */
	@Override
	public int getEmployeePostsCount() {
		return _employeePostLocalService.getEmployeePostsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePostLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePostLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePost the employee post
	 * @return the employee post that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePost updateEmployeePost(
		com.adjecti.pis.liferay.model.EmployeePost employeePost) {

		return _employeePostLocalService.updateEmployeePost(employeePost);
	}

	@Override
	public EmployeePostLocalService getWrappedService() {
		return _employeePostLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePostLocalService employeePostLocalService) {

		_employeePostLocalService = employeePostLocalService;
	}

	private EmployeePostLocalService _employeePostLocalService;

}