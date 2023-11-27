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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SingleUserOnboarding. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.SingleUserOnboardingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingLocalService
 * @generated
 */
public class SingleUserOnboardingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.SingleUserOnboardingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		addSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return getService().addSingleUserOnboarding(singleUserOnboarding);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		createSingleUserOnboarding(long singleUserRegistrationId) {

		return getService().createSingleUserOnboarding(
			singleUserRegistrationId);
	}

	public static int currentStatusBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().currentStatusBySingleUserOnboardingId(
			singleUserOnboardingId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
			deleteSingleUserOnboarding(long singleUserRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSingleUserOnboarding(
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
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		deleteSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return getService().deleteSingleUserOnboarding(singleUserOnboarding);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		fetchSingleUserOnboarding(long singleUserRegistrationId) {

		return getService().fetchSingleUserOnboarding(singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		fetchSingleUserOnboardingByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchSingleUserOnboardingByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.SingleUserOnboarding>
			getBySectionAndStatus(long sectionId, int status) {

		return getService().getBySectionAndStatus(sectionId, status);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.SingleUserOnboarding> getByUnitId(
			String unitId) {

		return getService().getByUnitId(unitId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the single user onboarding with the primary key.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws PortalException if a single user onboarding with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
			getSingleUserOnboarding(long singleUserRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSingleUserOnboarding(singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding matching the UUID and group.
	 *
	 * @param uuid the single user onboarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching single user onboarding
	 * @throws PortalException if a matching single user onboarding could not be found
	 */
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
			getSingleUserOnboardingByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSingleUserOnboardingByUuidAndGroupId(
			uuid, groupId);
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
	public static java.util.List
		<com.adjecti.pis.liferay.model.SingleUserOnboarding>
			getSingleUserOnboardings(int start, int end) {

		return getService().getSingleUserOnboardings(start, end);
	}

	/**
	 * Returns all the single user onboardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the single user onboardings
	 * @param companyId the primary key of the company
	 * @return the matching single user onboardings, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.SingleUserOnboarding>
			getSingleUserOnboardingsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getSingleUserOnboardingsByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List
		<com.adjecti.pis.liferay.model.SingleUserOnboarding>
			getSingleUserOnboardingsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.adjecti.pis.liferay.model.SingleUserOnboarding>
						orderByComparator) {

		return getService().getSingleUserOnboardingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	public static int getSingleUserOnboardingsCount() {
		return getService().getSingleUserOnboardingsCount();
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
	public static com.adjecti.pis.liferay.model.SingleUserOnboarding
		updateSingleUserOnboarding(
			com.adjecti.pis.liferay.model.SingleUserOnboarding
				singleUserOnboarding) {

		return getService().updateSingleUserOnboarding(singleUserOnboarding);
	}

	public static String updateStatusBySingleUserOnboardingId(
			long SingleUserOnboardingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatusBySingleUserOnboardingId(
			SingleUserOnboardingId, status);
	}

	public static SingleUserOnboardingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SingleUserOnboardingLocalService, SingleUserOnboardingLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SingleUserOnboardingLocalService.class);

		ServiceTracker
			<SingleUserOnboardingLocalService, SingleUserOnboardingLocalService>
				serviceTracker =
					new ServiceTracker
						<SingleUserOnboardingLocalService,
						 SingleUserOnboardingLocalService>(
							 bundle.getBundleContext(),
							 SingleUserOnboardingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}