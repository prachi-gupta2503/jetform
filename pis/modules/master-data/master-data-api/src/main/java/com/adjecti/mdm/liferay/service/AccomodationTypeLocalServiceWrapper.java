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
 * Provides a wrapper for {@link AccomodationTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccomodationTypeLocalService
 * @generated
 */
public class AccomodationTypeLocalServiceWrapper
	implements AccomodationTypeLocalService,
			   ServiceWrapper<AccomodationTypeLocalService> {

	public AccomodationTypeLocalServiceWrapper(
		AccomodationTypeLocalService accomodationTypeLocalService) {

		_accomodationTypeLocalService = accomodationTypeLocalService;
	}

	/**
	 * Adds the accomodation type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccomodationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accomodationType the accomodation type
	 * @return the accomodation type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType addAccomodationType(
		com.adjecti.mdm.liferay.model.AccomodationType accomodationType) {

		return _accomodationTypeLocalService.addAccomodationType(
			accomodationType);
	}

	/**
	 * Creates a new accomodation type with the primary key. Does not add the accomodation type to the database.
	 *
	 * @param accomodationTypeId the primary key for the new accomodation type
	 * @return the new accomodation type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType
		createAccomodationType(long accomodationTypeId) {

		return _accomodationTypeLocalService.createAccomodationType(
			accomodationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accomodationTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the accomodation type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccomodationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accomodationType the accomodation type
	 * @return the accomodation type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType
		deleteAccomodationType(
			com.adjecti.mdm.liferay.model.AccomodationType accomodationType) {

		return _accomodationTypeLocalService.deleteAccomodationType(
			accomodationType);
	}

	/**
	 * Deletes the accomodation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccomodationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accomodationTypeId the primary key of the accomodation type
	 * @return the accomodation type that was removed
	 * @throws PortalException if a accomodation type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType
			deleteAccomodationType(long accomodationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accomodationTypeLocalService.deleteAccomodationType(
			accomodationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accomodationTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accomodationTypeLocalService.dynamicQuery();
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

		return _accomodationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AccomodationTypeModelImpl</code>.
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

		return _accomodationTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AccomodationTypeModelImpl</code>.
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

		return _accomodationTypeLocalService.dynamicQuery(
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

		return _accomodationTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _accomodationTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType fetchAccomodationType(
		long accomodationTypeId) {

		return _accomodationTypeLocalService.fetchAccomodationType(
			accomodationTypeId);
	}

	/**
	 * Returns the accomodation type with the primary key.
	 *
	 * @param accomodationTypeId the primary key of the accomodation type
	 * @return the accomodation type
	 * @throws PortalException if a accomodation type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType getAccomodationType(
			long accomodationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accomodationTypeLocalService.getAccomodationType(
			accomodationTypeId);
	}

	/**
	 * Returns a range of all the accomodation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AccomodationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accomodation types
	 * @param end the upper bound of the range of accomodation types (not inclusive)
	 * @return the range of accomodation types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.AccomodationType>
		getAccomodationTypes(int start, int end) {

		return _accomodationTypeLocalService.getAccomodationTypes(start, end);
	}

	/**
	 * Returns the number of accomodation types.
	 *
	 * @return the number of accomodation types
	 */
	@Override
	public int getAccomodationTypesCount() {
		return _accomodationTypeLocalService.getAccomodationTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accomodationTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accomodationTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accomodationTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accomodationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the accomodation type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccomodationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accomodationType the accomodation type
	 * @return the accomodation type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AccomodationType
		updateAccomodationType(
			com.adjecti.mdm.liferay.model.AccomodationType accomodationType) {

		return _accomodationTypeLocalService.updateAccomodationType(
			accomodationType);
	}

	@Override
	public AccomodationTypeLocalService getWrappedService() {
		return _accomodationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		AccomodationTypeLocalService accomodationTypeLocalService) {

		_accomodationTypeLocalService = accomodationTypeLocalService;
	}

	private AccomodationTypeLocalService _accomodationTypeLocalService;

}