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
 * Provides the local service utility for ProcessFile. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.ProcessFileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessFileLocalService
 * @generated
 */
public class ProcessFileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.ProcessFileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the process file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processFile the process file
	 * @return the process file that was added
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile addProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return getService().addProcessFile(processFile);
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
	 * Creates a new process file with the primary key. Does not add the process file to the database.
	 *
	 * @param processFileId the primary key for the new process file
	 * @return the new process file
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile createProcessFile(
		long processFileId) {

		return getService().createProcessFile(processFileId);
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
	 * Deletes the process file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file that was removed
	 * @throws PortalException if a process file with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile deleteProcessFile(
			long processFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProcessFile(processFileId);
	}

	/**
	 * Deletes the process file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processFile the process file
	 * @return the process file that was removed
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile deleteProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return getService().deleteProcessFile(processFile);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ProcessFileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ProcessFileModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.ProcessFile fetchProcessFile(
		long processFileId) {

		return getService().fetchProcessFile(processFileId);
	}

	/**
	 * Returns the process file matching the UUID and group.
	 *
	 * @param uuid the process file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile
		fetchProcessFileByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProcessFileByUuidAndGroupId(uuid, groupId);
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
	 * Returns the process file with the primary key.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file
	 * @throws PortalException if a process file with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile getProcessFile(
			long processFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProcessFile(processFileId);
	}

	/**
	 * Returns the process file matching the UUID and group.
	 *
	 * @param uuid the process file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching process file
	 * @throws PortalException if a matching process file could not be found
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile
			getProcessFileByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProcessFileByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the process files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of process files
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFiles(int start, int end) {

		return getService().getProcessFiles(start, end);
	}

	/**
	 * Returns all the process files matching the UUID and company.
	 *
	 * @param uuid the UUID of the process files
	 * @param companyId the primary key of the company
	 * @return the matching process files, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFilesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProcessFilesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of process files matching the UUID and company.
	 *
	 * @param uuid the UUID of the process files
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching process files, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.ProcessFile> orderByComparator) {

		return getService().getProcessFilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of process files.
	 *
	 * @return the number of process files
	 */
	public static int getProcessFilesCount() {
		return getService().getProcessFilesCount();
	}

	/**
	 * Updates the process file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcessFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param processFile the process file
	 * @return the process file that was updated
	 */
	public static com.adjecti.pis.liferay.model.ProcessFile updateProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return getService().updateProcessFile(processFile);
	}

	public static ProcessFileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProcessFileLocalService, ProcessFileLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProcessFileLocalService.class);

		ServiceTracker<ProcessFileLocalService, ProcessFileLocalService>
			serviceTracker =
				new ServiceTracker
					<ProcessFileLocalService, ProcessFileLocalService>(
						bundle.getBundleContext(),
						ProcessFileLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}