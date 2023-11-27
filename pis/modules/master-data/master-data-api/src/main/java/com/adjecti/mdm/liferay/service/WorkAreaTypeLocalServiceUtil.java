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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for WorkAreaType. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.WorkAreaTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaTypeLocalService
 * @generated
 */
public class WorkAreaTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.WorkAreaTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work area type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was added
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType addWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return getService().addWorkAreaType(workAreaType);
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
	 * Creates a new work area type with the primary key. Does not add the work area type to the database.
	 *
	 * @param workAreaTypeId the primary key for the new work area type
	 * @return the new work area type
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType createWorkAreaType(
		long workAreaTypeId) {

		return getService().createWorkAreaType(workAreaTypeId);
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
	 * Deletes the work area type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type that was removed
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType deleteWorkAreaType(
			long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteWorkAreaType(workAreaTypeId);
	}

	/**
	 * Deletes the work area type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was removed
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType deleteWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return getService().deleteWorkAreaType(workAreaType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
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

	public static com.adjecti.mdm.liferay.model.WorkAreaType fetchWorkAreaType(
		long workAreaTypeId) {

		return getService().fetchWorkAreaType(workAreaTypeId);
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
	 * Returns the work area type with the primary key.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type
	 * @throws PortalException if a work area type with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType getWorkAreaType(
			long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getWorkAreaType(workAreaTypeId);
	}

	/**
	 * Returns a range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of work area types
	 */
	public static java.util.List<com.adjecti.mdm.liferay.model.WorkAreaType>
		getWorkAreaTypes(int start, int end) {

		return getService().getWorkAreaTypes(start, end);
	}

	/**
	 * Returns the number of work area types.
	 *
	 * @return the number of work area types
	 */
	public static int getWorkAreaTypesCount() {
		return getService().getWorkAreaTypesCount();
	}

	/**
	 * Updates the work area type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaType the work area type
	 * @return the work area type that was updated
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaType updateWorkAreaType(
		com.adjecti.mdm.liferay.model.WorkAreaType workAreaType) {

		return getService().updateWorkAreaType(workAreaType);
	}

	public static WorkAreaTypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkAreaTypeLocalService, WorkAreaTypeLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaTypeLocalService.class);

		ServiceTracker<WorkAreaTypeLocalService, WorkAreaTypeLocalService>
			serviceTracker =
				new ServiceTracker
					<WorkAreaTypeLocalService, WorkAreaTypeLocalService>(
						bundle.getBundleContext(),
						WorkAreaTypeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}