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

package com.adjecti.jetform.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormDefinitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionLocalService
 * @generated
 */
public class FormDefinitionLocalServiceWrapper
	implements FormDefinitionLocalService,
			   ServiceWrapper<FormDefinitionLocalService> {

	public FormDefinitionLocalServiceWrapper(
		FormDefinitionLocalService formDefinitionLocalService) {

		_formDefinitionLocalService = formDefinitionLocalService;
	}

	/**
	 * Adds the form definition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was added
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition addFormDefinition(
		com.adjecti.jetform.liferay.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.addFormDefinition(formDefinition);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
		createFormDefinition(long formDefinitionId) {

		return _formDefinitionLocalService.createFormDefinition(
			formDefinitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the form definition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was removed
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
		deleteFormDefinition(
			com.adjecti.jetform.liferay.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.deleteFormDefinition(formDefinition);
	}

	/**
	 * Deletes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
			deleteFormDefinition(long formDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.deleteFormDefinition(
			formDefinitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formDefinitionLocalService.dynamicQuery();
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

		return _formDefinitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.FormDefinitionModelImpl</code>.
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

		return _formDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.FormDefinitionModelImpl</code>.
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

		return _formDefinitionLocalService.dynamicQuery(
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

		return _formDefinitionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _formDefinitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition fetchFormDefinition(
		long formDefinitionId) {

		return _formDefinitionLocalService.fetchFormDefinition(
			formDefinitionId);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
		fetchFormDefinitionByUuidAndGroupId(String uuid, long groupId) {

		return _formDefinitionLocalService.fetchFormDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formDefinitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _formDefinitionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
		getFormDefinationByFormClass(String formClass) {

		return _formDefinitionLocalService.getFormDefinationByFormClass(
			formClass);
	}

	/**
	 * Returns the form definition with the primary key.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition getFormDefinition(
			long formDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getFormDefinition(formDefinitionId);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition
	 * @throws PortalException if a matching form definition could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
			getFormDefinitionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getFormDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of form definitions
	 */
	@Override
	public java.util.List<com.adjecti.jetform.liferay.model.FormDefinition>
		getFormDefinitions(int start, int end) {

		return _formDefinitionLocalService.getFormDefinitions(start, end);
	}

	/**
	 * Returns all the form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @return the matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.jetform.liferay.model.FormDefinition>
		getFormDefinitionsByUuidAndCompanyId(String uuid, long companyId) {

		return _formDefinitionLocalService.getFormDefinitionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.jetform.liferay.model.FormDefinition>
		getFormDefinitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.jetform.liferay.model.FormDefinition>
					orderByComparator) {

		return _formDefinitionLocalService.getFormDefinitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	@Override
	public int getFormDefinitionsCount() {
		return _formDefinitionLocalService.getFormDefinitionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formDefinitionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formDefinitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the form definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was updated
	 */
	@Override
	public com.adjecti.jetform.liferay.model.FormDefinition
		updateFormDefinition(
			com.adjecti.jetform.liferay.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.updateFormDefinition(formDefinition);
	}

	@Override
	public FormDefinitionLocalService getWrappedService() {
		return _formDefinitionLocalService;
	}

	@Override
	public void setWrappedService(
		FormDefinitionLocalService formDefinitionLocalService) {

		_formDefinitionLocalService = formDefinitionLocalService;
	}

	private FormDefinitionLocalService _formDefinitionLocalService;

}