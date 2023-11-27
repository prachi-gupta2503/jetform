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
 * Provides a wrapper for {@link EmployeeDocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentLocalService
 * @generated
 */
public class EmployeeDocumentLocalServiceWrapper
	implements EmployeeDocumentLocalService,
			   ServiceWrapper<EmployeeDocumentLocalService> {

	public EmployeeDocumentLocalServiceWrapper(
		EmployeeDocumentLocalService employeeDocumentLocalService) {

		_employeeDocumentLocalService = employeeDocumentLocalService;
	}

	/**
	 * Adds the employee document to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument addEmployeeDocument(
		com.adjecti.pis.liferay.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.addEmployeeDocument(
			employeeDocument);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
			addEmployeeDocument(
				java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
					employeeDocuments)
		throws com.adjecti.pis.liferay.exception.EmployeeDocumentException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.addEmployeeDocument(
			employeeDocuments);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param employeeDocumentId the primary key for the new employee document
	 * @return the new employee document
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument
		createEmployeeDocument(long employeeDocumentId) {

		return _employeeDocumentLocalService.createEmployeeDocument(
			employeeDocumentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee document from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument
		deleteEmployeeDocument(
			com.adjecti.pis.liferay.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.deleteEmployeeDocument(
			employeeDocument);
	}

	/**
	 * Deletes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws PortalException if a employee document with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument
			deleteEmployeeDocument(long employeeDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.deleteEmployeeDocument(
			employeeDocumentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDocumentLocalService.dynamicQuery();
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

		return _employeeDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDocumentModelImpl</code>.
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

		return _employeeDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDocumentModelImpl</code>.
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

		return _employeeDocumentLocalService.dynamicQuery(
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

		return _employeeDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument fetchEmployeeDocument(
		long employeeDocumentId) {

		return _employeeDocumentLocalService.fetchEmployeeDocument(
			employeeDocumentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
		getByPersonalNo(String personalNo) {

		return _employeeDocumentLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee document with the primary key.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document
	 * @throws PortalException if a employee document with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument getEmployeeDocument(
			long employeeDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.getEmployeeDocument(
			employeeDocumentId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
		getEmployeeDocumentByEmpId(long employeeId) {

		return _employeeDocumentLocalService.getEmployeeDocumentByEmpId(
			employeeId);
	}

	/**
	 * Returns a range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of employee documents
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
		getEmployeeDocuments(int start, int end) {

		return _employeeDocumentLocalService.getEmployeeDocuments(start, end);
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	@Override
	public int getEmployeeDocumentsCount() {
		return _employeeDocumentLocalService.getEmployeeDocumentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDocumentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDocument
		updateEmployeeDocument(
			com.adjecti.pis.liferay.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.updateEmployeeDocument(
			employeeDocument);
	}

	@Override
	public EmployeeDocumentLocalService getWrappedService() {
		return _employeeDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDocumentLocalService employeeDocumentLocalService) {

		_employeeDocumentLocalService = employeeDocumentLocalService;
	}

	private EmployeeDocumentLocalService _employeeDocumentLocalService;

}