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
 * Provides a wrapper for {@link ApplicationAccessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationAccessLocalService
 * @generated
 */
public class ApplicationAccessLocalServiceWrapper
	implements ApplicationAccessLocalService,
			   ServiceWrapper<ApplicationAccessLocalService> {

	public ApplicationAccessLocalServiceWrapper(
		ApplicationAccessLocalService applicationAccessLocalService) {

		_applicationAccessLocalService = applicationAccessLocalService;
	}

	/**
	 * Adds the application access to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was added
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess addApplicationAccess(
		net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return _applicationAccessLocalService.addApplicationAccess(
			applicationAccess);
	}

	/**
	 * Creates a new application access with the primary key. Does not add the application access to the database.
	 *
	 * @param applicationAccessId the primary key for the new application access
	 * @return the new application access
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess
		createApplicationAccess(long applicationAccessId) {

		return _applicationAccessLocalService.createApplicationAccess(
			applicationAccessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationAccessLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the application access from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was removed
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess
		deleteApplicationAccess(
			net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return _applicationAccessLocalService.deleteApplicationAccess(
			applicationAccess);
	}

	/**
	 * Deletes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access that was removed
	 * @throws PortalException if a application access with the primary key could not be found
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess
			deleteApplicationAccess(long applicationAccessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationAccessLocalService.deleteApplicationAccess(
			applicationAccessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationAccessLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationAccessLocalService.dynamicQuery();
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

		return _applicationAccessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
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

		return _applicationAccessLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
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

		return _applicationAccessLocalService.dynamicQuery(
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

		return _applicationAccessLocalService.dynamicQueryCount(dynamicQuery);
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

		return _applicationAccessLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess
		fetchApplicationAccess(long applicationAccessId) {

		return _applicationAccessLocalService.fetchApplicationAccess(
			applicationAccessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _applicationAccessLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the application access with the primary key.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access
	 * @throws PortalException if a application access with the primary key could not be found
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess getApplicationAccess(
			long applicationAccessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationAccessLocalService.getApplicationAccess(
			applicationAccessId);
	}

	/**
	 * Returns a range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of application accesses
	 */
	@Override
	public java.util.List<net.ayudh.comnet.admin.model.ApplicationAccess>
		getApplicationAccesses(int start, int end) {

		return _applicationAccessLocalService.getApplicationAccesses(
			start, end);
	}

	/**
	 * Returns the number of application accesses.
	 *
	 * @return the number of application accesses
	 */
	@Override
	public int getApplicationAccessesCount() {
		return _applicationAccessLocalService.getApplicationAccessesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _applicationAccessLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _applicationAccessLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _applicationAccessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the application access in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was updated
	 */
	@Override
	public net.ayudh.comnet.admin.model.ApplicationAccess
		updateApplicationAccess(
			net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return _applicationAccessLocalService.updateApplicationAccess(
			applicationAccess);
	}

	@Override
	public ApplicationAccessLocalService getWrappedService() {
		return _applicationAccessLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationAccessLocalService applicationAccessLocalService) {

		_applicationAccessLocalService = applicationAccessLocalService;
	}

	private ApplicationAccessLocalService _applicationAccessLocalService;

}