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
 * Provides a wrapper for {@link WorkStationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkStationLocalService
 * @generated
 */
public class WorkStationLocalServiceWrapper
	implements ServiceWrapper<WorkStationLocalService>,
			   WorkStationLocalService {

	public WorkStationLocalServiceWrapper(
		WorkStationLocalService workStationLocalService) {

		_workStationLocalService = workStationLocalService;
	}

	/**
	 * Adds the work station to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workStation the work station
	 * @return the work station that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation addWorkStation(
		com.adjecti.mdm.liferay.model.WorkStation workStation) {

		return _workStationLocalService.addWorkStation(workStation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workStationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work station with the primary key. Does not add the work station to the database.
	 *
	 * @param workStationId the primary key for the new work station
	 * @return the new work station
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation createWorkStation(
		long workStationId) {

		return _workStationLocalService.createWorkStation(workStationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workStationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station that was removed
	 * @throws PortalException if a work station with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation deleteWorkStation(
			long workStationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workStationLocalService.deleteWorkStation(workStationId);
	}

	/**
	 * Deletes the work station from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workStation the work station
	 * @return the work station that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation deleteWorkStation(
		com.adjecti.mdm.liferay.model.WorkStation workStation) {

		return _workStationLocalService.deleteWorkStation(workStation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workStationLocalService.dynamicQuery();
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

		return _workStationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkStationModelImpl</code>.
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

		return _workStationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkStationModelImpl</code>.
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

		return _workStationLocalService.dynamicQuery(
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

		return _workStationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workStationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.WorkStation fetchWorkStation(
		long workStationId) {

		return _workStationLocalService.fetchWorkStation(workStationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workStationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workStationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workStationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workStationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work station with the primary key.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station
	 * @throws PortalException if a work station with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation getWorkStation(
			long workStationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workStationLocalService.getWorkStation(workStationId);
	}

	/**
	 * Returns a range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of work stations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkStation>
		getWorkStations(int start, int end) {

		return _workStationLocalService.getWorkStations(start, end);
	}

	/**
	 * Returns the number of work stations.
	 *
	 * @return the number of work stations
	 */
	@Override
	public int getWorkStationsCount() {
		return _workStationLocalService.getWorkStationsCount();
	}

	/**
	 * Updates the work station in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workStation the work station
	 * @return the work station that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.WorkStation updateWorkStation(
		com.adjecti.mdm.liferay.model.WorkStation workStation) {

		return _workStationLocalService.updateWorkStation(workStation);
	}

	@Override
	public WorkStationLocalService getWrappedService() {
		return _workStationLocalService;
	}

	@Override
	public void setWrappedService(
		WorkStationLocalService workStationLocalService) {

		_workStationLocalService = workStationLocalService;
	}

	private WorkStationLocalService _workStationLocalService;

}