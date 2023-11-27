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
 * Provides a wrapper for {@link OrganizationStationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationStationLocalService
 * @generated
 */
public class OrganizationStationLocalServiceWrapper
	implements OrganizationStationLocalService,
			   ServiceWrapper<OrganizationStationLocalService> {

	public OrganizationStationLocalServiceWrapper(
		OrganizationStationLocalService organizationStationLocalService) {

		_organizationStationLocalService = organizationStationLocalService;
	}

	/**
	 * Adds the organization station to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationStation the organization station
	 * @return the organization station that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
		addOrganizationStation(
			com.adjecti.mdm.liferay.model.OrganizationStation
				organizationStation) {

		return _organizationStationLocalService.addOrganizationStation(
			organizationStation);
	}

	/**
	 * Creates a new organization station with the primary key. Does not add the organization station to the database.
	 *
	 * @param organizationStationId the primary key for the new organization station
	 * @return the new organization station
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
		createOrganizationStation(long organizationStationId) {

		return _organizationStationLocalService.createOrganizationStation(
			organizationStationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationStationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the organization station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station that was removed
	 * @throws PortalException if a organization station with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
			deleteOrganizationStation(long organizationStationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationStationLocalService.deleteOrganizationStation(
			organizationStationId);
	}

	/**
	 * Deletes the organization station from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationStation the organization station
	 * @return the organization station that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
		deleteOrganizationStation(
			com.adjecti.mdm.liferay.model.OrganizationStation
				organizationStation) {

		return _organizationStationLocalService.deleteOrganizationStation(
			organizationStation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationStationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationStationLocalService.dynamicQuery();
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

		return _organizationStationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationStationModelImpl</code>.
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

		return _organizationStationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationStationModelImpl</code>.
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

		return _organizationStationLocalService.dynamicQuery(
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

		return _organizationStationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _organizationStationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
		fetchOrganizationStation(long organizationStationId) {

		return _organizationStationLocalService.fetchOrganizationStation(
			organizationStationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationStationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationStationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organization station with the primary key.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station
	 * @throws PortalException if a organization station with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
			getOrganizationStation(long organizationStationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationStationLocalService.getOrganizationStation(
			organizationStationId);
	}

	/**
	 * Returns a range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of organization stations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationStation>
		getOrganizationStations(int start, int end) {

		return _organizationStationLocalService.getOrganizationStations(
			start, end);
	}

	/**
	 * Returns the number of organization stations.
	 *
	 * @return the number of organization stations
	 */
	@Override
	public int getOrganizationStationsCount() {
		return _organizationStationLocalService.getOrganizationStationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationStationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationStationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the organization station in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationStationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationStation the organization station
	 * @return the organization station that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationStation
		updateOrganizationStation(
			com.adjecti.mdm.liferay.model.OrganizationStation
				organizationStation) {

		return _organizationStationLocalService.updateOrganizationStation(
			organizationStation);
	}

	@Override
	public OrganizationStationLocalService getWrappedService() {
		return _organizationStationLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationStationLocalService organizationStationLocalService) {

		_organizationStationLocalService = organizationStationLocalService;
	}

	private OrganizationStationLocalService _organizationStationLocalService;

}