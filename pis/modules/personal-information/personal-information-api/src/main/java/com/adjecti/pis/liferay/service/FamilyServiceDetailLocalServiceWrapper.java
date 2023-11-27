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
 * Provides a wrapper for {@link FamilyServiceDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FamilyServiceDetailLocalService
 * @generated
 */
public class FamilyServiceDetailLocalServiceWrapper
	implements FamilyServiceDetailLocalService,
			   ServiceWrapper<FamilyServiceDetailLocalService> {

	public FamilyServiceDetailLocalServiceWrapper(
		FamilyServiceDetailLocalService familyServiceDetailLocalService) {

		_familyServiceDetailLocalService = familyServiceDetailLocalService;
	}

	/**
	 * Adds the family service detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyServiceDetail the family service detail
	 * @return the family service detail that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
		addFamilyServiceDetail(
			com.adjecti.pis.liferay.model.FamilyServiceDetail
				familyServiceDetail) {

		return _familyServiceDetailLocalService.addFamilyServiceDetail(
			familyServiceDetail);
	}

	/**
	 * Creates a new family service detail with the primary key. Does not add the family service detail to the database.
	 *
	 * @param familyServiceDetailId the primary key for the new family service detail
	 * @return the new family service detail
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
		createFamilyServiceDetail(long familyServiceDetailId) {

		return _familyServiceDetailLocalService.createFamilyServiceDetail(
			familyServiceDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyServiceDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the family service detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyServiceDetail the family service detail
	 * @return the family service detail that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
		deleteFamilyServiceDetail(
			com.adjecti.pis.liferay.model.FamilyServiceDetail
				familyServiceDetail) {

		return _familyServiceDetailLocalService.deleteFamilyServiceDetail(
			familyServiceDetail);
	}

	/**
	 * Deletes the family service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail that was removed
	 * @throws PortalException if a family service detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
			deleteFamilyServiceDetail(long familyServiceDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyServiceDetailLocalService.deleteFamilyServiceDetail(
			familyServiceDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyServiceDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _familyServiceDetailLocalService.dynamicQuery();
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

		return _familyServiceDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyServiceDetailModelImpl</code>.
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

		return _familyServiceDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyServiceDetailModelImpl</code>.
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

		return _familyServiceDetailLocalService.dynamicQuery(
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

		return _familyServiceDetailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _familyServiceDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
		fetchFamilyServiceDetail(long familyServiceDetailId) {

		return _familyServiceDetailLocalService.fetchFamilyServiceDetail(
			familyServiceDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _familyServiceDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the family service detail with the primary key.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail
	 * @throws PortalException if a family service detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
			getFamilyServiceDetail(long familyServiceDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyServiceDetailLocalService.getFamilyServiceDetail(
			familyServiceDetailId);
	}

	/**
	 * Returns a range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @return the range of family service details
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.FamilyServiceDetail>
		getFamilyServiceDetails(int start, int end) {

		return _familyServiceDetailLocalService.getFamilyServiceDetails(
			start, end);
	}

	/**
	 * Returns the number of family service details.
	 *
	 * @return the number of family service details
	 */
	@Override
	public int getFamilyServiceDetailsCount() {
		return _familyServiceDetailLocalService.getFamilyServiceDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _familyServiceDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _familyServiceDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyServiceDetailLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the family service detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyServiceDetail the family service detail
	 * @return the family service detail that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyServiceDetail
		updateFamilyServiceDetail(
			com.adjecti.pis.liferay.model.FamilyServiceDetail
				familyServiceDetail) {

		return _familyServiceDetailLocalService.updateFamilyServiceDetail(
			familyServiceDetail);
	}

	@Override
	public FamilyServiceDetailLocalService getWrappedService() {
		return _familyServiceDetailLocalService;
	}

	@Override
	public void setWrappedService(
		FamilyServiceDetailLocalService familyServiceDetailLocalService) {

		_familyServiceDetailLocalService = familyServiceDetailLocalService;
	}

	private FamilyServiceDetailLocalService _familyServiceDetailLocalService;

}