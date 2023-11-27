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
 * Provides a wrapper for {@link WorkAreaTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaTypeLocalService
 * @generated
 */
public class WorkAreaTypeLocalServiceWrapper
	implements ServiceWrapper<WorkAreaTypeLocalService>,
			   WorkAreaTypeLocalService {

	public WorkAreaTypeLocalServiceWrapper(
		WorkAreaTypeLocalService workAreaTypeLocalService) {

		_workAreaTypeLocalService = workAreaTypeLocalService;
	}

	/**
	 * Adds the work area type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType addWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return _workAreaTypeLocalService.addWorkAreaType(workAreaType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work area type with the primary key. Does not add the work area type to the database.
	 *
	 * @param workAreaTypeId the primary key for the new work area type
	 * @return the new work area type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType createWorkAreaType(
		long workAreaTypeId) {

		return _workAreaTypeLocalService.createWorkAreaType(workAreaTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work area type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type that was removed
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType deleteWorkAreaType(
			long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaTypeLocalService.deleteWorkAreaType(workAreaTypeId);
	}

	/**
	 * Deletes the work area type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType deleteWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return _workAreaTypeLocalService.deleteWorkAreaType(workAreaType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workAreaTypeLocalService.dynamicQuery();
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

		return _workAreaTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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

		return _workAreaTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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

		return _workAreaTypeLocalService.dynamicQuery(
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

		return _workAreaTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workAreaTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType fetchWorkAreaType(
		long workAreaTypeId) {

		return _workAreaTypeLocalService.fetchWorkAreaType(workAreaTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workAreaTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workAreaTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workAreaTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work area type with the primary key.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType getWorkAreaType(
			long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workAreaTypeLocalService.getWorkAreaType(workAreaTypeId);
	}

	/**
	 * Returns a range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of work area types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkAreaType>
		getWorkAreaTypes(int start, int end) {

		return _workAreaTypeLocalService.getWorkAreaTypes(start, end);
	}

	/**
	 * Returns the number of work area types.
	 *
	 * @return the number of work area types
	 */
	@Override
	public int getWorkAreaTypesCount() {
		return _workAreaTypeLocalService.getWorkAreaTypesCount();
	}

	/**
	 * Updates the work area type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkAreaType updateWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return _workAreaTypeLocalService.updateWorkAreaType(workAreaType);
	}

	@Override
	public WorkAreaTypeLocalService getWrappedService() {
		return _workAreaTypeLocalService;
	}

	@Override
	public void setWrappedService(
		WorkAreaTypeLocalService workAreaTypeLocalService) {

		_workAreaTypeLocalService = workAreaTypeLocalService;
	}

	private WorkAreaTypeLocalService _workAreaTypeLocalService;

}