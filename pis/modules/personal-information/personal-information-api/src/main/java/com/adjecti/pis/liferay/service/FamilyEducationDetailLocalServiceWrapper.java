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

package com.adjecti.pis.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FamilyEducationDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FamilyEducationDetailLocalService
 * @generated
 */
public class FamilyEducationDetailLocalServiceWrapper
	implements FamilyEducationDetailLocalService,
			   ServiceWrapper<FamilyEducationDetailLocalService> {

	public FamilyEducationDetailLocalServiceWrapper(
		FamilyEducationDetailLocalService familyEducationDetailLocalService) {

		_familyEducationDetailLocalService = familyEducationDetailLocalService;
	}

	/**
	 * Adds the family education detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyEducationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyEducationDetail the family education detail
	 * @return the family education detail that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
		addFamilyEducationDetail(
			com.adjecti.pis.liferay.model.FamilyEducationDetail
				familyEducationDetail) {

		return _familyEducationDetailLocalService.addFamilyEducationDetail(
			familyEducationDetail);
	}

	/**
	 * Creates a new family education detail with the primary key. Does not add the family education detail to the database.
	 *
	 * @param familyEducationDetailId the primary key for the new family education detail
	 * @return the new family education detail
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
		createFamilyEducationDetail(long familyEducationDetailId) {

		return _familyEducationDetailLocalService.createFamilyEducationDetail(
			familyEducationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyEducationDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the family education detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyEducationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyEducationDetail the family education detail
	 * @return the family education detail that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
		deleteFamilyEducationDetail(
			com.adjecti.pis.liferay.model.FamilyEducationDetail
				familyEducationDetail) {

		return _familyEducationDetailLocalService.deleteFamilyEducationDetail(
			familyEducationDetail);
	}

	/**
	 * Deletes the family education detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyEducationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail that was removed
	 * @throws PortalException if a family education detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
			deleteFamilyEducationDetail(long familyEducationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyEducationDetailLocalService.deleteFamilyEducationDetail(
			familyEducationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyEducationDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _familyEducationDetailLocalService.dynamicQuery();
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

		return _familyEducationDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyEducationDetailModelImpl</code>.
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

		return _familyEducationDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyEducationDetailModelImpl</code>.
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

		return _familyEducationDetailLocalService.dynamicQuery(
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

		return _familyEducationDetailLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _familyEducationDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
		fetchFamilyEducationDetail(long familyEducationDetailId) {

		return _familyEducationDetailLocalService.fetchFamilyEducationDetail(
			familyEducationDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _familyEducationDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the family education detail with the primary key.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail
	 * @throws PortalException if a family education detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
			getFamilyEducationDetail(long familyEducationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyEducationDetailLocalService.getFamilyEducationDetail(
			familyEducationDetailId);
	}

	/**
	 * Returns a range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @return the range of family education details
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.FamilyEducationDetail>
		getFamilyEducationDetails(int start, int end) {

		return _familyEducationDetailLocalService.getFamilyEducationDetails(
			start, end);
	}

	/**
	 * Returns the number of family education details.
	 *
	 * @return the number of family education details
	 */
	@Override
	public int getFamilyEducationDetailsCount() {
		return _familyEducationDetailLocalService.
			getFamilyEducationDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _familyEducationDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _familyEducationDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyEducationDetailLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the family education detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyEducationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyEducationDetail the family education detail
	 * @return the family education detail that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyEducationDetail
		updateFamilyEducationDetail(
			com.adjecti.pis.liferay.model.FamilyEducationDetail
				familyEducationDetail) {

		return _familyEducationDetailLocalService.updateFamilyEducationDetail(
			familyEducationDetail);
	}

	@Override
	public FamilyEducationDetailLocalService getWrappedService() {
		return _familyEducationDetailLocalService;
	}

	@Override
	public void setWrappedService(
		FamilyEducationDetailLocalService familyEducationDetailLocalService) {

		_familyEducationDetailLocalService = familyEducationDetailLocalService;
	}

	private FamilyEducationDetailLocalService
		_familyEducationDetailLocalService;

}