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

package com.adjecti.mdm.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkAreaMinorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMinorLocalService
 * @generated
 */
public class WorkAreaMinorLocalServiceWrapper
	implements ServiceWrapper<WorkAreaMinorLocalService>,
			   WorkAreaMinorLocalService {

	public WorkAreaMinorLocalServiceWrapper(
		WorkAreaMinorLocalService workAreaMinorLocalService) {

		_workAreaMinorLocalService = workAreaMinorLocalService;
	}

	/**
	 * Adds the work area minor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMinorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMinor the work area minor
	 * @return the work area minor that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor addWorkAreaMinor(
		com.adjecti.mdm.liferay.model.WorkAreaMinor workAreaMinor) {

		return _workAreaMinorLocalService.addWorkAreaMinor(workAreaMinor);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaMinorLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work area minor with the primary key. Does not add the work area minor to the database.
	 *
	 * @param workAreaMinorId the primary key for the new work area minor
	 * @return the new work area minor
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor createWorkAreaMinor(
		long workAreaMinorId) {

		return _workAreaMinorLocalService.createWorkAreaMinor(workAreaMinorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaMinorLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work area minor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMinorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor that was removed
	 * @throws PortalException if a work area minor with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor deleteWorkAreaMinor(
			long workAreaMinorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaMinorLocalService.deleteWorkAreaMinor(workAreaMinorId);
	}

	/**
	 * Deletes the work area minor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMinorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMinor the work area minor
	 * @return the work area minor that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor deleteWorkAreaMinor(
		com.adjecti.mdm.liferay.model.WorkAreaMinor workAreaMinor) {

		return _workAreaMinorLocalService.deleteWorkAreaMinor(workAreaMinor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workAreaMinorLocalService.dynamicQuery();
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

		return _workAreaMinorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMinorModelImpl</code>.
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

		return _workAreaMinorLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMinorModelImpl</code>.
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

		return _workAreaMinorLocalService.dynamicQuery(
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

		return _workAreaMinorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workAreaMinorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor fetchWorkAreaMinor(
		long workAreaMinorId) {

		return _workAreaMinorLocalService.fetchWorkAreaMinor(workAreaMinorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workAreaMinorLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkAreaMinor>
		getByWorkAreaMajorIdAndDeleted(long workAreaMajorId, boolean deleted) {

		return _workAreaMinorLocalService.getByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workAreaMinorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workAreaMinorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaMinorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work area minor with the primary key.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor
	 * @throws PortalException if a work area minor with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor getWorkAreaMinor(
			long workAreaMinorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaMinorLocalService.getWorkAreaMinor(workAreaMinorId);
	}

	/**
	 * Returns a range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of work area minors
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkAreaMinor>
		getWorkAreaMinors(int start, int end) {

		return _workAreaMinorLocalService.getWorkAreaMinors(start, end);
	}

	/**
	 * Returns the number of work area minors.
	 *
	 * @return the number of work area minors
	 */
	@Override
	public int getWorkAreaMinorsCount() {
		return _workAreaMinorLocalService.getWorkAreaMinorsCount();
	}

	/**
	 * Updates the work area minor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMinorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMinor the work area minor
	 * @return the work area minor that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaMinor updateWorkAreaMinor(
		com.adjecti.mdm.liferay.model.WorkAreaMinor workAreaMinor) {

		return _workAreaMinorLocalService.updateWorkAreaMinor(workAreaMinor);
	}

	@Override
	public WorkAreaMinorLocalService getWrappedService() {
		return _workAreaMinorLocalService;
	}

	@Override
	public void setWrappedService(
		WorkAreaMinorLocalService workAreaMinorLocalService) {

		_workAreaMinorLocalService = workAreaMinorLocalService;
	}

	private WorkAreaMinorLocalService _workAreaMinorLocalService;

}