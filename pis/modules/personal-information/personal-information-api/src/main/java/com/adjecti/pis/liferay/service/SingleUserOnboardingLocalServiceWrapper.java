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
 * Provides a wrapper for {@link SingleUserOnboardingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingLocalService
 * @generated
 */
public class SingleUserOnboardingLocalServiceWrapper
	implements ServiceWrapper<SingleUserOnboardingLocalService>,
			   SingleUserOnboardingLocalService {

	public SingleUserOnboardingLocalServiceWrapper(
		SingleUserOnboardingLocalService singleUserOnboardingLocalService) {

		_singleUserOnboardingLocalService = singleUserOnboardingLocalService;
	}

	/**
	 * Adds the single user onboarding to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		addSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return _singleUserOnboardingLocalService.addSingleUserOnboarding(
			singleUserOnboarding);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		createSingleUserOnboarding(long singleUserRegistrationId) {

		return _singleUserOnboardingLocalService.createSingleUserOnboarding(
			singleUserRegistrationId);
	}

	@Override
	public int currentStatusBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.
			currentStatusBySingleUserOnboardingId(singleUserOnboardingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws PortalException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
			deleteSingleUserOnboarding(long singleUserRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.deleteSingleUserOnboarding(
			singleUserRegistrationId);
	}

	/**
	 * Deletes the single user onboarding from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		deleteSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return _singleUserOnboardingLocalService.deleteSingleUserOnboarding(
			singleUserOnboarding);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _singleUserOnboardingLocalService.dynamicQuery();
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

		return _singleUserOnboardingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
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

		return _singleUserOnboardingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
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

		return _singleUserOnboardingLocalService.dynamicQuery(
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

		return _singleUserOnboardingLocalService.dynamicQueryCount(
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

		return _singleUserOnboardingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		fetchSingleUserOnboarding(long singleUserRegistrationId) {

		return _singleUserOnboardingLocalService.fetchSingleUserOnboarding(
			singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		fetchSingleUserOnboardingByUuidAndGroupId(String uuid, long groupId) {

		return _singleUserOnboardingLocalService.
			fetchSingleUserOnboardingByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _singleUserOnboardingLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SingleUserOnboarding>
		getBySectionAndStatus(long sectionId, int status) {

		return _singleUserOnboardingLocalService.getBySectionAndStatus(
			sectionId, status);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SingleUserOnboarding>
		getByUnitId(String unitId) {

		return _singleUserOnboardingLocalService.getByUnitId(unitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _singleUserOnboardingLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _singleUserOnboardingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _singleUserOnboardingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the single user onboarding with the primary key.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws PortalException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
			getSingleUserOnboarding(long singleUserRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.getSingleUserOnboarding(
			singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding
	 * @throws PortalException if a matching single user onboarding could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
			getSingleUserOnboardingByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.
			getSingleUserOnboardingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of single user onboardings
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SingleUserOnboarding>
		getSingleUserOnboardings(int start, int end) {

		return _singleUserOnboardingLocalService.getSingleUserOnboardings(
			start, end);
	}

	/**
	 * Returns all the single user onboardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the single user onboardings
	 * @param companyId the primary key of the company
	 * @return the matching single user onboardings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SingleUserOnboarding>
		getSingleUserOnboardingsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _singleUserOnboardingLocalService.
			getSingleUserOnboardingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of single user onboardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the single user onboardings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching single user onboardings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SingleUserOnboarding>
		getSingleUserOnboardingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.SingleUserOnboarding>
					orderByComparator) {

		return _singleUserOnboardingLocalService.
			getSingleUserOnboardingsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	@Override
	public int getSingleUserOnboardingsCount() {
		return _singleUserOnboardingLocalService.
			getSingleUserOnboardingsCount();
	}

	/**
	 * Updates the single user onboarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SingleUserOnboardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param singleUserOnboarding the single user onboarding
	 * @return the single user onboarding that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.SingleUserOnboarding
		updateSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return _singleUserOnboardingLocalService.updateSingleUserOnboarding(
			singleUserOnboarding);
	}

	@Override
	public String updateStatusBySingleUserOnboardingId(
			long SingleUserOnboardingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingLocalService.
			updateStatusBySingleUserOnboardingId(
				SingleUserOnboardingId, status);
	}

	@Override
	public SingleUserOnboardingLocalService getWrappedService() {
		return _singleUserOnboardingLocalService;
	}

	@Override
	public void setWrappedService(
		SingleUserOnboardingLocalService singleUserOnboardingLocalService) {

		_singleUserOnboardingLocalService = singleUserOnboardingLocalService;
	}

	private SingleUserOnboardingLocalService _singleUserOnboardingLocalService;

}