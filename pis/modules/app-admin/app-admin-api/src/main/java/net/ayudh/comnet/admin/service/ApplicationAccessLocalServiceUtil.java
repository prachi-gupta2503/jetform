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

package net.ayudh.comnet.admin.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ApplicationAccess. This utility wraps
 * <code>net.ayudh.comnet.admin.service.impl.ApplicationAccessLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationAccessLocalService
 * @generated
 */
public class ApplicationAccessLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>net.ayudh.comnet.admin.service.impl.ApplicationAccessLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the application access to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was added
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
		addApplicationAccess(
			net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return getService().addApplicationAccess(applicationAccess);
	}

	/**
	 * Creates a new application access with the primary key. Does not add the application access to the database.
	 *
	 * @param applicationAccessId the primary key for the new application access
	 * @return the new application access
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
		createApplicationAccess(long applicationAccessId) {

		return getService().createApplicationAccess(applicationAccessId);
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
	 * Deletes the application access from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was removed
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
		deleteApplicationAccess(
			net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return getService().deleteApplicationAccess(applicationAccess);
	}

	/**
	 * Deletes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access that was removed
	 * @throws PortalException if a application access with the primary key could not be found
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
			deleteApplicationAccess(long applicationAccessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteApplicationAccess(applicationAccessId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
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

	public static net.ayudh.comnet.admin.model.ApplicationAccess
		fetchApplicationAccess(long applicationAccessId) {

		return getService().fetchApplicationAccess(applicationAccessId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the application access with the primary key.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access
	 * @throws PortalException if a application access with the primary key could not be found
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
			getApplicationAccess(long applicationAccessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getApplicationAccess(applicationAccessId);
	}

	/**
	 * Returns a range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of application accesses
	 */
	public static java.util.List<net.ayudh.comnet.admin.model.ApplicationAccess>
		getApplicationAccesses(int start, int end) {

		return getService().getApplicationAccesses(start, end);
	}

	/**
	 * Returns the number of application accesses.
	 *
	 * @return the number of application accesses
	 */
	public static int getApplicationAccessesCount() {
		return getService().getApplicationAccessesCount();
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
	 * Updates the application access in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApplicationAccessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param applicationAccess the application access
	 * @return the application access that was updated
	 */
	public static net.ayudh.comnet.admin.model.ApplicationAccess
		updateApplicationAccess(
			net.ayudh.comnet.admin.model.ApplicationAccess applicationAccess) {

		return getService().updateApplicationAccess(applicationAccess);
	}

	public static ApplicationAccessLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ApplicationAccessLocalService, ApplicationAccessLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ApplicationAccessLocalService.class);

		ServiceTracker
			<ApplicationAccessLocalService, ApplicationAccessLocalService>
				serviceTracker =
					new ServiceTracker
						<ApplicationAccessLocalService,
						 ApplicationAccessLocalService>(
							 bundle.getBundleContext(),
							 ApplicationAccessLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}