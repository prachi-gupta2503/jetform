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
 * Provides a wrapper for {@link FamilyMemberServiceDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FamilyMemberServiceDetailLocalService
 * @generated
 */
public class FamilyMemberServiceDetailLocalServiceWrapper
	implements FamilyMemberServiceDetailLocalService,
			   ServiceWrapper<FamilyMemberServiceDetailLocalService> {

	public FamilyMemberServiceDetailLocalServiceWrapper(
		FamilyMemberServiceDetailLocalService
			familyMemberServiceDetailLocalService) {

		_familyMemberServiceDetailLocalService =
			familyMemberServiceDetailLocalService;
	}

	/**
	 * Adds the family member service detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyMemberServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyMemberServiceDetail the family member service detail
	 * @return the family member service detail that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
		addFamilyMemberServiceDetail(
			com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
				familyMemberServiceDetail) {

		return _familyMemberServiceDetailLocalService.
			addFamilyMemberServiceDetail(familyMemberServiceDetail);
	}

	/**
	 * Creates a new family member service detail with the primary key. Does not add the family member service detail to the database.
	 *
	 * @param familyMemberServiceDetailId the primary key for the new family member service detail
	 * @return the new family member service detail
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
		createFamilyMemberServiceDetail(long familyMemberServiceDetailId) {

		return _familyMemberServiceDetailLocalService.
			createFamilyMemberServiceDetail(familyMemberServiceDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyMemberServiceDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the family member service detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyMemberServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyMemberServiceDetail the family member service detail
	 * @return the family member service detail that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
		deleteFamilyMemberServiceDetail(
			com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
				familyMemberServiceDetail) {

		return _familyMemberServiceDetailLocalService.
			deleteFamilyMemberServiceDetail(familyMemberServiceDetail);
	}

	/**
	 * Deletes the family member service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyMemberServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyMemberServiceDetailId the primary key of the family member service detail
	 * @return the family member service detail that was removed
	 * @throws PortalException if a family member service detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
			deleteFamilyMemberServiceDetail(long familyMemberServiceDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyMemberServiceDetailLocalService.
			deleteFamilyMemberServiceDetail(familyMemberServiceDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyMemberServiceDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _familyMemberServiceDetailLocalService.dynamicQuery();
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

		return _familyMemberServiceDetailLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyMemberServiceDetailModelImpl</code>.
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

		return _familyMemberServiceDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyMemberServiceDetailModelImpl</code>.
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

		return _familyMemberServiceDetailLocalService.dynamicQuery(
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

		return _familyMemberServiceDetailLocalService.dynamicQueryCount(
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

		return _familyMemberServiceDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
		fetchFamilyMemberServiceDetail(long familyMemberServiceDetailId) {

		return _familyMemberServiceDetailLocalService.
			fetchFamilyMemberServiceDetail(familyMemberServiceDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _familyMemberServiceDetailLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the family member service detail with the primary key.
	 *
	 * @param familyMemberServiceDetailId the primary key of the family member service detail
	 * @return the family member service detail
	 * @throws PortalException if a family member service detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
			getFamilyMemberServiceDetail(long familyMemberServiceDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyMemberServiceDetailLocalService.
			getFamilyMemberServiceDetail(familyMemberServiceDetailId);
	}

	/**
	 * Returns a range of all the family member service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyMemberServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family member service details
	 * @param end the upper bound of the range of family member service details (not inclusive)
	 * @return the range of family member service details
	 */
	@Override
	public java.util.List
		<com.adjecti.pis.liferay.model.FamilyMemberServiceDetail>
			getFamilyMemberServiceDetails(int start, int end) {

		return _familyMemberServiceDetailLocalService.
			getFamilyMemberServiceDetails(start, end);
	}

	/**
	 * Returns the number of family member service details.
	 *
	 * @return the number of family member service details
	 */
	@Override
	public int getFamilyMemberServiceDetailsCount() {
		return _familyMemberServiceDetailLocalService.
			getFamilyMemberServiceDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _familyMemberServiceDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _familyMemberServiceDetailLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyMemberServiceDetailLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the family member service detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyMemberServiceDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyMemberServiceDetail the family member service detail
	 * @return the family member service detail that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
		updateFamilyMemberServiceDetail(
			com.adjecti.pis.liferay.model.FamilyMemberServiceDetail
				familyMemberServiceDetail) {

		return _familyMemberServiceDetailLocalService.
			updateFamilyMemberServiceDetail(familyMemberServiceDetail);
	}

	@Override
	public FamilyMemberServiceDetailLocalService getWrappedService() {
		return _familyMemberServiceDetailLocalService;
	}

	@Override
	public void setWrappedService(
		FamilyMemberServiceDetailLocalService
			familyMemberServiceDetailLocalService) {

		_familyMemberServiceDetailLocalService =
			familyMemberServiceDetailLocalService;
	}

	private FamilyMemberServiceDetailLocalService
		_familyMemberServiceDetailLocalService;

}