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
 * Provides a wrapper for {@link ProcessFileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessFileLocalService
 * @generated
 */
public class ProcessFileLocalServiceWrapper
	implements ProcessFileLocalService,
			   ServiceWrapper<ProcessFileLocalService> {

	public ProcessFileLocalServiceWrapper(
		ProcessFileLocalService processFileLocalService) {

		_processFileLocalService = processFileLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile addProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return _processFileLocalService.addProcessFile(processFile);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new process file with the primary key. Does not add the process file to the database.
	 *
	 * @param processFileId the primary key for the new process file
	 * @return the new process file
	 */
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile createProcessFile(
		long processFileId) {

		return _processFileLocalService.createProcessFile(processFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile deleteProcessFile(
			long processFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.deleteProcessFile(processFileId);
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
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile deleteProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return _processFileLocalService.deleteProcessFile(processFile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processFileLocalService.dynamicQuery();
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

		return _processFileLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _processFileLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _processFileLocalService.dynamicQuery(
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

		return _processFileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _processFileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.ProcessFile fetchProcessFile(
		long processFileId) {

		return _processFileLocalService.fetchProcessFile(processFileId);
	}

	/**
	 * Returns the process file matching the UUID and group.
	 *
	 * @param uuid the process file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile
		fetchProcessFileByUuidAndGroupId(String uuid, long groupId) {

		return _processFileLocalService.fetchProcessFileByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _processFileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _processFileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _processFileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _processFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the process file with the primary key.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file
	 * @throws PortalException if a process file with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile getProcessFile(
			long processFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.getProcessFile(processFileId);
	}

	/**
	 * Returns the process file matching the UUID and group.
	 *
	 * @param uuid the process file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching process file
	 * @throws PortalException if a matching process file could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile
			getProcessFileByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _processFileLocalService.getProcessFileByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFiles(int start, int end) {

		return _processFileLocalService.getProcessFiles(start, end);
	}

	/**
	 * Returns all the process files matching the UUID and company.
	 *
	 * @param uuid the UUID of the process files
	 * @param companyId the primary key of the company
	 * @return the matching process files, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFilesByUuidAndCompanyId(String uuid, long companyId) {

		return _processFileLocalService.getProcessFilesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ProcessFile>
		getProcessFilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.ProcessFile> orderByComparator) {

		return _processFileLocalService.getProcessFilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of process files.
	 *
	 * @return the number of process files
	 */
	@Override
	public int getProcessFilesCount() {
		return _processFileLocalService.getProcessFilesCount();
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
	@Override
	public com.adjecti.pis.liferay.model.ProcessFile updateProcessFile(
		com.adjecti.pis.liferay.model.ProcessFile processFile) {

		return _processFileLocalService.updateProcessFile(processFile);
	}

	@Override
	public ProcessFileLocalService getWrappedService() {
		return _processFileLocalService;
	}

	@Override
	public void setWrappedService(
		ProcessFileLocalService processFileLocalService) {

		_processFileLocalService = processFileLocalService;
	}

	private ProcessFileLocalService _processFileLocalService;

}