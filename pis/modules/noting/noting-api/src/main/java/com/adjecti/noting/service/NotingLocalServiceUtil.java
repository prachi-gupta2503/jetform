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

package com.adjecti.noting.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Noting. This utility wraps
 * <code>com.adjecti.noting.service.impl.NotingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NotingLocalService
 * @generated
 */
public class NotingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.noting.service.impl.NotingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the noting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was added
	 */
	public static com.adjecti.noting.model.Noting addNoting(
		com.adjecti.noting.model.Noting noting) {

		return getService().addNoting(noting);
	}

	public static com.adjecti.noting.model.Noting addNoting(
			String title, String content, long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addNoting(title, content, pdfId);
	}

	/**
	 * Creates a new noting with the primary key. Does not add the noting to the database.
	 *
	 * @param noteId the primary key for the new noting
	 * @return the new noting
	 */
	public static com.adjecti.noting.model.Noting createNoting(long noteId) {
		return getService().createNoting(noteId);
	}

	/**
	 * Deletes the noting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting that was removed
	 * @throws PortalException if a noting with the primary key could not be found
	 */
	public static com.adjecti.noting.model.Noting deleteNoting(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNoting(noteId);
	}

	/**
	 * Deletes the noting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was removed
	 */
	public static com.adjecti.noting.model.Noting deleteNoting(
		com.adjecti.noting.model.Noting noting) {

		return getService().deleteNoting(noting);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
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

	public static com.adjecti.noting.model.Noting fetchNoting(long noteId) {
		return getService().fetchNoting(noteId);
	}

	/**
	 * Returns the noting matching the UUID and group.
	 *
	 * @param uuid the noting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static com.adjecti.noting.model.Noting fetchNotingByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchNotingByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the noting with the primary key.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting
	 * @throws PortalException if a noting with the primary key could not be found
	 */
	public static com.adjecti.noting.model.Noting getNoting(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNoting(noteId);
	}

	/**
	 * Returns the noting matching the UUID and group.
	 *
	 * @param uuid the noting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching noting
	 * @throws PortalException if a matching noting could not be found
	 */
	public static com.adjecti.noting.model.Noting getNotingByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNotingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of notings
	 */
	public static java.util.List<com.adjecti.noting.model.Noting> getNotings(
		int start, int end) {

		return getService().getNotings(start, end);
	}

	/**
	 * Returns all the notings matching the UUID and company.
	 *
	 * @param uuid the UUID of the notings
	 * @param companyId the primary key of the company
	 * @return the matching notings, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.noting.model.Noting>
		getNotingsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getNotingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of notings matching the UUID and company.
	 *
	 * @param uuid the UUID of the notings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notings, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.noting.model.Noting>
		getNotingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.noting.model.Noting> orderByComparator) {

		return getService().getNotingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notings.
	 *
	 * @return the number of notings
	 */
	public static int getNotingsCount() {
		return getService().getNotingsCount();
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
	 * Updates the noting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was updated
	 */
	public static com.adjecti.noting.model.Noting updateNoting(
		com.adjecti.noting.model.Noting noting) {

		return getService().updateNoting(noting);
	}

	public static NotingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotingLocalService, NotingLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotingLocalService.class);

		ServiceTracker<NotingLocalService, NotingLocalService> serviceTracker =
			new ServiceTracker<NotingLocalService, NotingLocalService>(
				bundle.getBundleContext(), NotingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}