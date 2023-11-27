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
 * Provides a wrapper for {@link OccupationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OccupationLocalService
 * @generated
 */
public class OccupationLocalServiceWrapper
	implements OccupationLocalService, ServiceWrapper<OccupationLocalService> {

	public OccupationLocalServiceWrapper(
		OccupationLocalService occupationLocalService) {

		_occupationLocalService = occupationLocalService;
	}

	/**
	 * Adds the occupation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param occupation the occupation
	 * @return the occupation that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation addOccupation(
		com.adjecti.mdm.liferay.model.Occupation occupation) {

		return _occupationLocalService.addOccupation(occupation);
	}

	/**
	 * Creates a new occupation with the primary key. Does not add the occupation to the database.
	 *
	 * @param occupationId the primary key for the new occupation
	 * @return the new occupation
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation createOccupation(
		long occupationId) {

		return _occupationLocalService.createOccupation(occupationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _occupationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation that was removed
	 * @throws PortalException if a occupation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation deleteOccupation(
			long occupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _occupationLocalService.deleteOccupation(occupationId);
	}

	/**
	 * Deletes the occupation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param occupation the occupation
	 * @return the occupation that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation deleteOccupation(
		com.adjecti.mdm.liferay.model.Occupation occupation) {

		return _occupationLocalService.deleteOccupation(occupation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _occupationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _occupationLocalService.dynamicQuery();
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

		return _occupationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OccupationModelImpl</code>.
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

		return _occupationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OccupationModelImpl</code>.
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

		return _occupationLocalService.dynamicQuery(
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

		return _occupationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _occupationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Occupation fetchOccupation(
		long occupationId) {

		return _occupationLocalService.fetchOccupation(occupationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _occupationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _occupationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the occupation with the primary key.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation
	 * @throws PortalException if a occupation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation getOccupation(
			long occupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _occupationLocalService.getOccupation(occupationId);
	}

	/**
	 * Returns a range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @return the range of occupations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Occupation>
		getOccupations(int start, int end) {

		return _occupationLocalService.getOccupations(start, end);
	}

	/**
	 * Returns the number of occupations.
	 *
	 * @return the number of occupations
	 */
	@Override
	public int getOccupationsCount() {
		return _occupationLocalService.getOccupationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _occupationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _occupationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the occupation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param occupation the occupation
	 * @return the occupation that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Occupation updateOccupation(
		com.adjecti.mdm.liferay.model.Occupation occupation) {

		return _occupationLocalService.updateOccupation(occupation);
	}

	@Override
	public OccupationLocalService getWrappedService() {
		return _occupationLocalService;
	}

	@Override
	public void setWrappedService(
		OccupationLocalService occupationLocalService) {

		_occupationLocalService = occupationLocalService;
	}

	private OccupationLocalService _occupationLocalService;

}