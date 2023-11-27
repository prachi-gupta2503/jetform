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
 * Provides the local service utility for MonthlySalaryComponent. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.MonthlySalaryComponentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryComponentLocalService
 * @generated
 */
public class MonthlySalaryComponentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.MonthlySalaryComponentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the monthly salary component to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was added
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
		addMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return getService().addMonthlySalaryComponent(monthlySalaryComponent);
	}

	/**
	 * Creates a new monthly salary component with the primary key. Does not add the monthly salary component to the database.
	 *
	 * @param monthlySalaryComponentId the primary key for the new monthly salary component
	 * @return the new monthly salary component
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
		createMonthlySalaryComponent(long monthlySalaryComponentId) {

		return getService().createMonthlySalaryComponent(
			monthlySalaryComponentId);
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
	 * Deletes the monthly salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component that was removed
	 * @throws PortalException if a monthly salary component with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
			deleteMonthlySalaryComponent(long monthlySalaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	/**
	 * Deletes the monthly salary component from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was removed
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
		deleteMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return getService().deleteMonthlySalaryComponent(
			monthlySalaryComponent);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
		fetchMonthlySalaryComponent(long monthlySalaryComponentId) {

		return getService().fetchMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the monthly salary component with the primary key.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component
	 * @throws PortalException if a monthly salary component with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
			getMonthlySalaryComponent(long monthlySalaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMonthlySalaryComponent(monthlySalaryComponentId);
	}

	/**
	 * Returns a range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @return the range of monthly salary components
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.MonthlySalaryComponent>
			getMonthlySalaryComponents(int start, int end) {

		return getService().getMonthlySalaryComponents(start, end);
	}

	/**
	 * Returns the number of monthly salary components.
	 *
	 * @return the number of monthly salary components
	 */
	public static int getMonthlySalaryComponentsCount() {
		return getService().getMonthlySalaryComponentsCount();
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
	 * Updates the monthly salary component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was updated
	 */
	public static com.adjecti.pis.liferay.model.MonthlySalaryComponent
		updateMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return getService().updateMonthlySalaryComponent(
			monthlySalaryComponent);
	}

	public static MonthlySalaryComponentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MonthlySalaryComponentLocalService, MonthlySalaryComponentLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MonthlySalaryComponentLocalService.class);

		ServiceTracker
			<MonthlySalaryComponentLocalService,
			 MonthlySalaryComponentLocalService> serviceTracker =
				new ServiceTracker
					<MonthlySalaryComponentLocalService,
					 MonthlySalaryComponentLocalService>(
						 bundle.getBundleContext(),
						 MonthlySalaryComponentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}