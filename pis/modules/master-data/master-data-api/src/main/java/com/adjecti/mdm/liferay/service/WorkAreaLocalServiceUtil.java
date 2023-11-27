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
 * Provides the local service utility for WorkArea. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.WorkAreaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaLocalService
 * @generated
 */
public class WorkAreaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.WorkAreaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea addWorkArea(
			long workAreaId, long parentId, String name, long workAreaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addWorkArea(
			workAreaId, parentId, name, workAreaTypeId);
	}

	/**
	 * Adds the work area to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was added
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea addWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return getService().addWorkArea(workArea);
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
	 * Creates a new work area with the primary key. Does not add the work area to the database.
	 *
	 * @param workAreaId the primary key for the new work area
	 * @return the new work area
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea createWorkArea(
		long workAreaId) {

		return getService().createWorkArea(workAreaId);
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
	 * Deletes the work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area that was removed
	 * @throws PortalException if a work area with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea deleteWorkArea(
			long workAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteWorkArea(workAreaId);
	}

	/**
	 * Deletes the work area from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was removed
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea deleteWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return getService().deleteWorkArea(workArea);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
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

	public static com.adjecti.mdm.liferay.model.WorkArea fetchWorkArea(
		long workAreaId) {

		return getService().fetchWorkArea(workAreaId);
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
	 * Returns the work area with the primary key.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area
	 * @throws PortalException if a work area with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea getWorkArea(
			long workAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getWorkArea(workAreaId);
	}

	/**
	 * Returns a range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of work areas
	 */
	public static java.util.List<com.adjecti.mdm.liferay.model.WorkArea>
		getWorkAreas(int start, int end) {

		return getService().getWorkAreas(start, end);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.WorkArea>
		getWorkAreasByParentId(long parentId) {

		return getService().getWorkAreasByParentId(parentId);
	}

	/**
	 * Returns the number of work areas.
	 *
	 * @return the number of work areas
	 */
	public static int getWorkAreasCount() {
		return getService().getWorkAreasCount();
	}

	public static boolean hasChild(long workAreaId) {
		return getService().hasChild(workAreaId);
	}

	/**
	 * Updates the work area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workArea the work area
	 * @return the work area that was updated
	 */
	public static com.adjecti.mdm.liferay.model.WorkArea updateWorkArea(
		com.adjecti.mdm.liferay.model.WorkArea workArea) {

		return getService().updateWorkArea(workArea);
	}

	public static WorkAreaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkAreaLocalService, WorkAreaLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaLocalService.class);

		ServiceTracker<WorkAreaLocalService, WorkAreaLocalService>
			serviceTracker =
				new ServiceTracker<WorkAreaLocalService, WorkAreaLocalService>(
					bundle.getBundleContext(), WorkAreaLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}