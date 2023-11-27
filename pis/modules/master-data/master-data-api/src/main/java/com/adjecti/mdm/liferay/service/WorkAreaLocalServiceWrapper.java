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
 * Provides a wrapper for {@link WorkAreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaLocalService
 * @generated
 */
public class WorkAreaLocalServiceWrapper
	implements ServiceWrapper<WorkAreaLocalService>, WorkAreaLocalService {

	public WorkAreaLocalServiceWrapper(
		WorkAreaLocalService workAreaLocalService) {

		_workAreaLocalService = workAreaLocalService;
	}

	@Override
	public com.adjecti.mdm.liferay.model.WorkArea addWorkArea(
			long workAreaId, long parentId, String name, long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.addWorkArea(
			workAreaId, parentId, name, workAreaTypeId);
	}

	/**
	 * Adds the work area to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea addWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return _workAreaLocalService.addWorkArea(workArea);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work area with the primary key. Does not add the work area to the database.
	 *
	 * @param workAreaId the primary key for the new work area
	 * @return the new work area
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea createWorkArea(
		long workAreaId) {

		return _workAreaLocalService.createWorkArea(workAreaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area that was removed
	 * @throws PortalException if a work area with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea deleteWorkArea(
			long workAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.deleteWorkArea(workAreaId);
	}

	/**
	 * Deletes the work area from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea deleteWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return _workAreaLocalService.deleteWorkArea(workArea);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workAreaLocalService.dynamicQuery();
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

		return _workAreaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
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

		return _workAreaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
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

		return _workAreaLocalService.dynamicQuery(
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

		return _workAreaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workAreaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.WorkArea fetchWorkArea(
		long workAreaId) {

		return _workAreaLocalService.fetchWorkArea(workAreaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workAreaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workAreaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workAreaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work area with the primary key.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area
	 * @throws PortalException if a work area with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea getWorkArea(long workAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaLocalService.getWorkArea(workAreaId);
	}

	/**
	 * Returns a range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of work areas
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkArea> getWorkAreas(
		int start, int end) {

		return _workAreaLocalService.getWorkAreas(start, end);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkArea>
		getWorkAreasByParentId(long parentId) {

		return _workAreaLocalService.getWorkAreasByParentId(parentId);
	}

	/**
	 * Returns the number of work areas.
	 *
	 * @return the number of work areas
	 */
	@Override
	public int getWorkAreasCount() {
		return _workAreaLocalService.getWorkAreasCount();
	}

	@Override
	public boolean hasChild(long workAreaId) {
		return _workAreaLocalService.hasChild(workAreaId);
	}

	/**
	 * Updates the work area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkArea updateWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return _workAreaLocalService.updateWorkArea(workArea);
	}

	@Override
	public WorkAreaLocalService getWrappedService() {
		return _workAreaLocalService;
	}

	@Override
	public void setWrappedService(WorkAreaLocalService workAreaLocalService) {
		_workAreaLocalService = workAreaLocalService;
	}

	private WorkAreaLocalService _workAreaLocalService;

}