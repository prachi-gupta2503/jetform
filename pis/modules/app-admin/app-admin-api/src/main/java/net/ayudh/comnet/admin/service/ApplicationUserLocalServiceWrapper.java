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

package net.ayudh.comnet.admin.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApplicationUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUserLocalService
 * @generated
 */
public class ApplicationUserLocalServiceWrapper
	implements ApplicationUserLocalService,
			   ServiceWrapper<ApplicationUserLocalService> {

	public ApplicationUserLocalServiceWrapper(
		ApplicationUserLocalService applicationUserLocalService) {

		_applicationUserLocalService = applicationUserLocalService;
	}

	/**
	 * Adds the application user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationUser the application user
	 * @return the application user that was added
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser addApplicationUser(
		net.ayudh.comnet.admin.model.ApplicationUser applicationUser) {

		return _applicationUserLocalService.addApplicationUser(applicationUser);
	}

	@Override
	public boolean createApplicationUser() {
		return _applicationUserLocalService.createApplicationUser();
	}

	/**
	 * Creates a new application user with the primary key. Does not add the application user to the database.
	 *
	 * @param applicationUserId the primary key for the new application user
	 * @return the new application user
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser createApplicationUser(
		long applicationUserId) {

		return _applicationUserLocalService.createApplicationUser(
			applicationUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the application user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationUser the application user
	 * @return the application user that was removed
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser deleteApplicationUser(
		net.ayudh.comnet.admin.model.ApplicationUser applicationUser) {

		return _applicationUserLocalService.deleteApplicationUser(
			applicationUser);
	}

	/**
	 * Deletes the application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user that was removed
	 * @throws PortalException if a application user with the primary key could not be found
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser deleteApplicationUser(
			long applicationUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationUserLocalService.deleteApplicationUser(
			applicationUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationUserLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationUserLocalService.dynamicQuery();
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

		return _applicationUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationUserModelImpl</code>.
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

		return _applicationUserLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationUserModelImpl</code>.
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

		return _applicationUserLocalService.dynamicQuery(
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

		return _applicationUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _applicationUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser fetchApplicationUser(
		long applicationUserId) {

		return _applicationUserLocalService.fetchApplicationUser(
			applicationUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _applicationUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the application user with the primary key.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user
	 * @throws PortalException if a application user with the primary key could not be found
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser getApplicationUser(
			long applicationUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationUserLocalService.getApplicationUser(
			applicationUserId);
	}

	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser
		getApplicationUserByPersonalNo(String personalNo) {

		return _applicationUserLocalService.getApplicationUserByPersonalNo(
			personalNo);
	}

	/**
	 * Returns a range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @return the range of application users
	 */
	@Override
	public java.util.List<net.ayudh.comnet.admin.model.ApplicationUser>
		getApplicationUsers(int start, int end) {

		return _applicationUserLocalService.getApplicationUsers(start, end);
	}

	/**
	 * Returns the number of application users.
	 *
	 * @return the number of application users
	 */
	@Override
	public int getApplicationUsersCount() {
		return _applicationUserLocalService.getApplicationUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _applicationUserLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _applicationUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the application user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationUser the application user
	 * @return the application user that was updated
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationUser updateApplicationUser(
		net.ayudh.comnet.admin.model.ApplicationUser applicationUser) {

		return _applicationUserLocalService.updateApplicationUser(
			applicationUser);
	}

	@Override
	public boolean updateApplicationUser(
		net.ayudh.comnet.admin.model.ApplicationUser applicationUser,
		long applicationUserId) {

		return _applicationUserLocalService.updateApplicationUser(
			applicationUser, applicationUserId);
	}

	@Override
	public ApplicationUserLocalService getWrappedService() {
		return _applicationUserLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationUserLocalService applicationUserLocalService) {

		_applicationUserLocalService = applicationUserLocalService;
	}

	private ApplicationUserLocalService _applicationUserLocalService;

}