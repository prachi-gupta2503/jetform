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
 * Provides a wrapper for {@link CasteCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CasteCategoryLocalService
 * @generated
 */
public class CasteCategoryLocalServiceWrapper
	implements CasteCategoryLocalService,
			   ServiceWrapper<CasteCategoryLocalService> {

	public CasteCategoryLocalServiceWrapper(
		CasteCategoryLocalService casteCategoryLocalService) {

		_casteCategoryLocalService = casteCategoryLocalService;
	}

	/**
	 * Adds the caste category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasteCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casteCategory the caste category
	 * @return the caste category that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory addCasteCategory(
		com.adjecti.mdm.liferay.model.CasteCategory casteCategory) {

		return _casteCategoryLocalService.addCasteCategory(casteCategory);
	}

	/**
	 * Creates a new caste category with the primary key. Does not add the caste category to the database.
	 *
	 * @param casteCategoryId the primary key for the new caste category
	 * @return the new caste category
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory createCasteCategory(
		long casteCategoryId) {

		return _casteCategoryLocalService.createCasteCategory(casteCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casteCategoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the caste category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasteCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casteCategory the caste category
	 * @return the caste category that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory deleteCasteCategory(
		com.adjecti.mdm.liferay.model.CasteCategory casteCategory) {

		return _casteCategoryLocalService.deleteCasteCategory(casteCategory);
	}

	/**
	 * Deletes the caste category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasteCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category that was removed
	 * @throws PortalException if a caste category with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory deleteCasteCategory(
			long casteCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casteCategoryLocalService.deleteCasteCategory(casteCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casteCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _casteCategoryLocalService.dynamicQuery();
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

		return _casteCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CasteCategoryModelImpl</code>.
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

		return _casteCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CasteCategoryModelImpl</code>.
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

		return _casteCategoryLocalService.dynamicQuery(
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

		return _casteCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _casteCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory fetchCasteCategory(
		long casteCategoryId) {

		return _casteCategoryLocalService.fetchCasteCategory(casteCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _casteCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CasteCategory>
		getCastCategoryByName(String categoryName) {

		return _casteCategoryLocalService.getCastCategoryByName(categoryName);
	}

	/**
	 * Returns a range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of caste categories
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CasteCategory>
		getCasteCategories(int start, int end) {

		return _casteCategoryLocalService.getCasteCategories(start, end);
	}

	/**
	 * Returns the number of caste categories.
	 *
	 * @return the number of caste categories
	 */
	@Override
	public int getCasteCategoriesCount() {
		return _casteCategoryLocalService.getCasteCategoriesCount();
	}

	/**
	 * Returns the caste category with the primary key.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category
	 * @throws PortalException if a caste category with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory getCasteCategory(
			long casteCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casteCategoryLocalService.getCasteCategory(casteCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _casteCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _casteCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casteCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the caste category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasteCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casteCategory the caste category
	 * @return the caste category that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CasteCategory updateCasteCategory(
		com.adjecti.mdm.liferay.model.CasteCategory casteCategory) {

		return _casteCategoryLocalService.updateCasteCategory(casteCategory);
	}

	@Override
	public CasteCategoryLocalService getWrappedService() {
		return _casteCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		CasteCategoryLocalService casteCategoryLocalService) {

		_casteCategoryLocalService = casteCategoryLocalService;
	}

	private CasteCategoryLocalService _casteCategoryLocalService;

}