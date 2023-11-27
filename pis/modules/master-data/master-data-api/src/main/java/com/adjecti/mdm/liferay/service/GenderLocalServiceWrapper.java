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
 * Provides a wrapper for {@link GenderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GenderLocalService
 * @generated
 */
public class GenderLocalServiceWrapper
	implements GenderLocalService, ServiceWrapper<GenderLocalService> {

	public GenderLocalServiceWrapper(GenderLocalService genderLocalService) {
		_genderLocalService = genderLocalService;
	}

	/**
	 * Adds the gender to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gender the gender
	 * @return the gender that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender addGender(
		com.adjecti.mdm.liferay.model.Gender gender) {

		return _genderLocalService.addGender(gender);
	}

	/**
	 * Creates a new gender with the primary key. Does not add the gender to the database.
	 *
	 * @param genderId the primary key for the new gender
	 * @return the new gender
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender createGender(long genderId) {
		return _genderLocalService.createGender(genderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the gender from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gender the gender
	 * @return the gender that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender deleteGender(
		com.adjecti.mdm.liferay.model.Gender gender) {

		return _genderLocalService.deleteGender(gender);
	}

	/**
	 * Deletes the gender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender that was removed
	 * @throws PortalException if a gender with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender deleteGender(long genderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderLocalService.deleteGender(genderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _genderLocalService.dynamicQuery();
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

		return _genderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GenderModelImpl</code>.
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

		return _genderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GenderModelImpl</code>.
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

		return _genderLocalService.dynamicQuery(
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

		return _genderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _genderLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Gender fetchGender(long genderId) {
		return _genderLocalService.fetchGender(genderId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _genderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the gender with the primary key.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender
	 * @throws PortalException if a gender with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender getGender(long genderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderLocalService.getGender(genderId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Gender> getGenderByName(
		String genderName) {

		return _genderLocalService.getGenderByName(genderName);
	}

	/**
	 * Returns a range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @return the range of genders
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Gender> getGenders(
		int start, int end) {

		return _genderLocalService.getGenders(start, end);
	}

	/**
	 * Returns the number of genders.
	 *
	 * @return the number of genders
	 */
	@Override
	public int getGendersCount() {
		return _genderLocalService.getGendersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _genderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _genderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the gender in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gender the gender
	 * @return the gender that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Gender updateGender(
		com.adjecti.mdm.liferay.model.Gender gender) {

		return _genderLocalService.updateGender(gender);
	}

	@Override
	public GenderLocalService getWrappedService() {
		return _genderLocalService;
	}

	@Override
	public void setWrappedService(GenderLocalService genderLocalService) {
		_genderLocalService = genderLocalService;
	}

	private GenderLocalService _genderLocalService;

}