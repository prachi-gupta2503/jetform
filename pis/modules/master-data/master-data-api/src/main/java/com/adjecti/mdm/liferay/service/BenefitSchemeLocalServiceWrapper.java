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
 * Provides a wrapper for {@link BenefitSchemeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BenefitSchemeLocalService
 * @generated
 */
public class BenefitSchemeLocalServiceWrapper
	implements BenefitSchemeLocalService,
			   ServiceWrapper<BenefitSchemeLocalService> {

	public BenefitSchemeLocalServiceWrapper(
		BenefitSchemeLocalService benefitSchemeLocalService) {

		_benefitSchemeLocalService = benefitSchemeLocalService;
	}

	/**
	 * Adds the benefit scheme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitScheme the benefit scheme
	 * @return the benefit scheme that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme addBenefitScheme(
		com.adjecti.mdm.liferay.model.BenefitScheme benefitScheme) {

		return _benefitSchemeLocalService.addBenefitScheme(benefitScheme);
	}

	/**
	 * Creates a new benefit scheme with the primary key. Does not add the benefit scheme to the database.
	 *
	 * @param benefitSchemeId the primary key for the new benefit scheme
	 * @return the new benefit scheme
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme createBenefitScheme(
		long benefitSchemeId) {

		return _benefitSchemeLocalService.createBenefitScheme(benefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitSchemeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the benefit scheme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitScheme the benefit scheme
	 * @return the benefit scheme that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme deleteBenefitScheme(
		com.adjecti.mdm.liferay.model.BenefitScheme benefitScheme) {

		return _benefitSchemeLocalService.deleteBenefitScheme(benefitScheme);
	}

	/**
	 * Deletes the benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme that was removed
	 * @throws PortalException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme deleteBenefitScheme(
			long benefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitSchemeLocalService.deleteBenefitScheme(benefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitSchemeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _benefitSchemeLocalService.dynamicQuery();
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

		return _benefitSchemeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BenefitSchemeModelImpl</code>.
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

		return _benefitSchemeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BenefitSchemeModelImpl</code>.
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

		return _benefitSchemeLocalService.dynamicQuery(
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

		return _benefitSchemeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _benefitSchemeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme fetchBenefitScheme(
		long benefitSchemeId) {

		return _benefitSchemeLocalService.fetchBenefitScheme(benefitSchemeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _benefitSchemeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the benefit scheme with the primary key.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme
	 * @throws PortalException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme getBenefitScheme(
			long benefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitSchemeLocalService.getBenefitScheme(benefitSchemeId);
	}

	/**
	 * Returns a range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @return the range of benefit schemes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.BenefitScheme>
		getBenefitSchemes(int start, int end) {

		return _benefitSchemeLocalService.getBenefitSchemes(start, end);
	}

	/**
	 * Returns the number of benefit schemes.
	 *
	 * @return the number of benefit schemes
	 */
	@Override
	public int getBenefitSchemesCount() {
		return _benefitSchemeLocalService.getBenefitSchemesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _benefitSchemeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _benefitSchemeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitSchemeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the benefit scheme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitScheme the benefit scheme
	 * @return the benefit scheme that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BenefitScheme updateBenefitScheme(
		com.adjecti.mdm.liferay.model.BenefitScheme benefitScheme) {

		return _benefitSchemeLocalService.updateBenefitScheme(benefitScheme);
	}

	@Override
	public BenefitSchemeLocalService getWrappedService() {
		return _benefitSchemeLocalService;
	}

	@Override
	public void setWrappedService(
		BenefitSchemeLocalService benefitSchemeLocalService) {

		_benefitSchemeLocalService = benefitSchemeLocalService;
	}

	private BenefitSchemeLocalService _benefitSchemeLocalService;

}