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
 * Provides a wrapper for {@link FamilyBenefitSchemeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FamilyBenefitSchemeLocalService
 * @generated
 */
public class FamilyBenefitSchemeLocalServiceWrapper
	implements FamilyBenefitSchemeLocalService,
			   ServiceWrapper<FamilyBenefitSchemeLocalService> {

	public FamilyBenefitSchemeLocalServiceWrapper(
		FamilyBenefitSchemeLocalService familyBenefitSchemeLocalService) {

		_familyBenefitSchemeLocalService = familyBenefitSchemeLocalService;
	}

	/**
	 * Adds the family benefit scheme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyBenefitScheme the family benefit scheme
	 * @return the family benefit scheme that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
		addFamilyBenefitScheme(
			com.adjecti.pis.liferay.model.FamilyBenefitScheme
				familyBenefitScheme) {

		return _familyBenefitSchemeLocalService.addFamilyBenefitScheme(
			familyBenefitScheme);
	}

	/**
	 * Creates a new family benefit scheme with the primary key. Does not add the family benefit scheme to the database.
	 *
	 * @param familyBenefitSchemeId the primary key for the new family benefit scheme
	 * @return the new family benefit scheme
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
		createFamilyBenefitScheme(long familyBenefitSchemeId) {

		return _familyBenefitSchemeLocalService.createFamilyBenefitScheme(
			familyBenefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyBenefitSchemeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the family benefit scheme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyBenefitScheme the family benefit scheme
	 * @return the family benefit scheme that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
		deleteFamilyBenefitScheme(
			com.adjecti.pis.liferay.model.FamilyBenefitScheme
				familyBenefitScheme) {

		return _familyBenefitSchemeLocalService.deleteFamilyBenefitScheme(
			familyBenefitScheme);
	}

	/**
	 * Deletes the family benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme that was removed
	 * @throws PortalException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
			deleteFamilyBenefitScheme(long familyBenefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyBenefitSchemeLocalService.deleteFamilyBenefitScheme(
			familyBenefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyBenefitSchemeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _familyBenefitSchemeLocalService.dynamicQuery();
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

		return _familyBenefitSchemeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyBenefitSchemeModelImpl</code>.
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

		return _familyBenefitSchemeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyBenefitSchemeModelImpl</code>.
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

		return _familyBenefitSchemeLocalService.dynamicQuery(
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

		return _familyBenefitSchemeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _familyBenefitSchemeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
		fetchFamilyBenefitScheme(long familyBenefitSchemeId) {

		return _familyBenefitSchemeLocalService.fetchFamilyBenefitScheme(
			familyBenefitSchemeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _familyBenefitSchemeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the family benefit scheme with the primary key.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme
	 * @throws PortalException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
			getFamilyBenefitScheme(long familyBenefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyBenefitSchemeLocalService.getFamilyBenefitScheme(
			familyBenefitSchemeId);
	}

	/**
	 * Returns a range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @return the range of family benefit schemes
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.FamilyBenefitScheme>
		getFamilyBenefitSchemes(int start, int end) {

		return _familyBenefitSchemeLocalService.getFamilyBenefitSchemes(
			start, end);
	}

	/**
	 * Returns the number of family benefit schemes.
	 *
	 * @return the number of family benefit schemes
	 */
	@Override
	public int getFamilyBenefitSchemesCount() {
		return _familyBenefitSchemeLocalService.getFamilyBenefitSchemesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _familyBenefitSchemeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _familyBenefitSchemeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _familyBenefitSchemeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the family benefit scheme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FamilyBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param familyBenefitScheme the family benefit scheme
	 * @return the family benefit scheme that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.FamilyBenefitScheme
		updateFamilyBenefitScheme(
			com.adjecti.pis.liferay.model.FamilyBenefitScheme
				familyBenefitScheme) {

		return _familyBenefitSchemeLocalService.updateFamilyBenefitScheme(
			familyBenefitScheme);
	}

	@Override
	public FamilyBenefitSchemeLocalService getWrappedService() {
		return _familyBenefitSchemeLocalService;
	}

	@Override
	public void setWrappedService(
		FamilyBenefitSchemeLocalService familyBenefitSchemeLocalService) {

		_familyBenefitSchemeLocalService = familyBenefitSchemeLocalService;
	}

	private FamilyBenefitSchemeLocalService _familyBenefitSchemeLocalService;

}