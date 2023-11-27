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
 * Provides the local service utility for JoiningProcess. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.JoiningProcessLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessLocalService
 * @generated
 */
public class JoiningProcessLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.JoiningProcessLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the joining process to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcess the joining process
	 * @return the joining process that was added
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
		addJoiningProcess(
			com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return getService().addJoiningProcess(joiningProcess);
	}

	/**
	 * Creates a new joining process with the primary key. Does not add the joining process to the database.
	 *
	 * @param joiningProcessId the primary key for the new joining process
	 * @return the new joining process
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
		createJoiningProcess(long joiningProcessId) {

		return getService().createJoiningProcess(joiningProcessId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static int currentStatusByJoiningProcessId(long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().currentStatusByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Deletes the joining process from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcess the joining process
	 * @return the joining process that was removed
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
		deleteJoiningProcess(
			com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return getService().deleteJoiningProcess(joiningProcess);
	}

	/**
	 * Deletes the joining process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process that was removed
	 * @throws PortalException if a joining process with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
			deleteJoiningProcess(long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteJoiningProcess(joiningProcessId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.JoiningProcess
		fetchJoiningProcess(long joiningProcessId) {

		return getService().fetchJoiningProcess(joiningProcessId);
	}

	/**
	 * Returns the joining process matching the UUID and group.
	 *
	 * @param uuid the joining process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
		fetchJoiningProcessByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchJoiningProcessByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getByUnitId(Long unitId) {

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
	 * Returns the joining process with the primary key.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process
	 * @throws PortalException if a joining process with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
			getJoiningProcess(long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJoiningProcess(joiningProcessId);
	}

	/**
	 * Returns the joining process matching the UUID and group.
	 *
	 * @param uuid the joining process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process
	 * @throws PortalException if a matching joining process could not be found
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
			getJoiningProcessByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJoiningProcessByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of joining processes
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcesses(int start, int end) {

		return getService().getJoiningProcesses(start, end);
	}

	/**
	 * Returns all the joining processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the joining processes
	 * @param companyId the primary key of the company
	 * @return the matching joining processes, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcessesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getJoiningProcessesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of joining processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the joining processes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching joining processes, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcessesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.JoiningProcess>
					orderByComparator) {

		return getService().getJoiningProcessesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of joining processes.
	 *
	 * @return the number of joining processes
	 */
	public static int getJoiningProcessesCount() {
		return getService().getJoiningProcessesCount();
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
	 * Updates the joining process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcess the joining process
	 * @return the joining process that was updated
	 */
	public static com.adjecti.pis.liferay.model.JoiningProcess
		updateJoiningProcess(
			com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return getService().updateJoiningProcess(joiningProcess);
	}

	public static String updateStatusByJoiningProcessId(
			long joiningProcessId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatusByJoiningProcessId(
			joiningProcessId, status);
	}

	public static JoiningProcessLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<JoiningProcessLocalService, JoiningProcessLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			JoiningProcessLocalService.class);

		ServiceTracker<JoiningProcessLocalService, JoiningProcessLocalService>
			serviceTracker =
				new ServiceTracker
					<JoiningProcessLocalService, JoiningProcessLocalService>(
						bundle.getBundleContext(),
						JoiningProcessLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}