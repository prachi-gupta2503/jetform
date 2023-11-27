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
 * Provides a wrapper for {@link JoiningProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessLocalService
 * @generated
 */
public class JoiningProcessLocalServiceWrapper
	implements JoiningProcessLocalService,
			   ServiceWrapper<JoiningProcessLocalService> {

	public JoiningProcessLocalServiceWrapper(
		JoiningProcessLocalService joiningProcessLocalService) {

		_joiningProcessLocalService = joiningProcessLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess addJoiningProcess(
		com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return _joiningProcessLocalService.addJoiningProcess(joiningProcess);
	}

	/**
	 * Creates a new joining process with the primary key. Does not add the joining process to the database.
	 *
	 * @param joiningProcessId the primary key for the new joining process
	 * @return the new joining process
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess createJoiningProcess(
		long joiningProcessId) {

		return _joiningProcessLocalService.createJoiningProcess(
			joiningProcessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public int currentStatusByJoiningProcessId(long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.currentStatusByJoiningProcessId(
			joiningProcessId);
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
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess deleteJoiningProcess(
		com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return _joiningProcessLocalService.deleteJoiningProcess(joiningProcess);
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
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess deleteJoiningProcess(
			long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.deleteJoiningProcess(
			joiningProcessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _joiningProcessLocalService.dynamicQuery();
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

		return _joiningProcessLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _joiningProcessLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _joiningProcessLocalService.dynamicQuery(
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

		return _joiningProcessLocalService.dynamicQueryCount(dynamicQuery);
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

		return _joiningProcessLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess fetchJoiningProcess(
		long joiningProcessId) {

		return _joiningProcessLocalService.fetchJoiningProcess(
			joiningProcessId);
	}

	/**
	 * Returns the joining process matching the UUID and group.
	 *
	 * @param uuid the joining process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess
		fetchJoiningProcessByUuidAndGroupId(String uuid, long groupId) {

		return _joiningProcessLocalService.fetchJoiningProcessByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _joiningProcessLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getByUnitId(Long unitId) {

		return _joiningProcessLocalService.getByUnitId(unitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _joiningProcessLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _joiningProcessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the joining process with the primary key.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process
	 * @throws PortalException if a joining process with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess getJoiningProcess(
			long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.getJoiningProcess(joiningProcessId);
	}

	/**
	 * Returns the joining process matching the UUID and group.
	 *
	 * @param uuid the joining process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process
	 * @throws PortalException if a matching joining process could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess
			getJoiningProcessByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.getJoiningProcessByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcesses(int start, int end) {

		return _joiningProcessLocalService.getJoiningProcesses(start, end);
	}

	/**
	 * Returns all the joining processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the joining processes
	 * @param companyId the primary key of the company
	 * @return the matching joining processes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcessesByUuidAndCompanyId(String uuid, long companyId) {

		return _joiningProcessLocalService.
			getJoiningProcessesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcess>
		getJoiningProcessesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.JoiningProcess>
					orderByComparator) {

		return _joiningProcessLocalService.
			getJoiningProcessesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of joining processes.
	 *
	 * @return the number of joining processes
	 */
	@Override
	public int getJoiningProcessesCount() {
		return _joiningProcessLocalService.getJoiningProcessesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _joiningProcessLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcess updateJoiningProcess(
		com.adjecti.pis.liferay.model.JoiningProcess joiningProcess) {

		return _joiningProcessLocalService.updateJoiningProcess(joiningProcess);
	}

	@Override
	public String updateStatusByJoiningProcessId(
			long joiningProcessId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessLocalService.updateStatusByJoiningProcessId(
			joiningProcessId, status);
	}

	@Override
	public JoiningProcessLocalService getWrappedService() {
		return _joiningProcessLocalService;
	}

	@Override
	public void setWrappedService(
		JoiningProcessLocalService joiningProcessLocalService) {

		_joiningProcessLocalService = joiningProcessLocalService;
	}

	private JoiningProcessLocalService _joiningProcessLocalService;

}