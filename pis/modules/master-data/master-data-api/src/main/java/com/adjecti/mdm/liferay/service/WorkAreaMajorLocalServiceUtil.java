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
 * Provides the local service utility for WorkAreaMajor. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.WorkAreaMajorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMajorLocalService
 * @generated
 */
public class WorkAreaMajorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.WorkAreaMajorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work area major to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMajorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMajor the work area major
	 * @return the work area major that was added
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor addWorkAreaMajor(
		com.adjecti.mdm.liferay.model.WorkAreaMajor workAreaMajor) {

		return getService().addWorkAreaMajor(workAreaMajor);
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
	 * Creates a new work area major with the primary key. Does not add the work area major to the database.
	 *
	 * @param workAreaMajorId the primary key for the new work area major
	 * @return the new work area major
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor
		createWorkAreaMajor(long workAreaMajorId) {

		return getService().createWorkAreaMajor(workAreaMajorId);
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
	 * Deletes the work area major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMajorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major that was removed
	 * @throws PortalException if a work area major with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor
			deleteWorkAreaMajor(long workAreaMajorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteWorkAreaMajor(workAreaMajorId);
	}

	/**
	 * Deletes the work area major from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMajorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMajor the work area major
	 * @return the work area major that was removed
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor
		deleteWorkAreaMajor(
			com.adjecti.mdm.liferay.model.WorkAreaMajor workAreaMajor) {

		return getService().deleteWorkAreaMajor(workAreaMajor);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMajorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMajorModelImpl</code>.
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

	public static com.adjecti.mdm.liferay.model.WorkAreaMajor
		fetchWorkAreaMajor(long workAreaMajorId) {

		return getService().fetchWorkAreaMajor(workAreaMajorId);
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
	 * Returns the work area major with the primary key.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major
	 * @throws PortalException if a work area major with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor getWorkAreaMajor(
			long workAreaMajorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getWorkAreaMajor(workAreaMajorId);
	}

	/**
	 * Returns a range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of work area majors
	 */
	public static java.util.List<com.adjecti.mdm.liferay.model.WorkAreaMajor>
		getWorkAreaMajors(int start, int end) {

		return getService().getWorkAreaMajors(start, end);
	}

	/**
	 * Returns the number of work area majors.
	 *
	 * @return the number of work area majors
	 */
	public static int getWorkAreaMajorsCount() {
		return getService().getWorkAreaMajorsCount();
	}

	/**
	 * Updates the work area major in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaMajorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaMajor the work area major
	 * @return the work area major that was updated
	 */
	public static com.adjecti.mdm.liferay.model.WorkAreaMajor
		updateWorkAreaMajor(
			com.adjecti.mdm.liferay.model.WorkAreaMajor workAreaMajor) {

		return getService().updateWorkAreaMajor(workAreaMajor);
	}

	public static WorkAreaMajorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkAreaMajorLocalService, WorkAreaMajorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			WorkAreaMajorLocalService.class);

		ServiceTracker<WorkAreaMajorLocalService, WorkAreaMajorLocalService>
			serviceTracker =
				new ServiceTracker
					<WorkAreaMajorLocalService, WorkAreaMajorLocalService>(
						bundle.getBundleContext(),
						WorkAreaMajorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}