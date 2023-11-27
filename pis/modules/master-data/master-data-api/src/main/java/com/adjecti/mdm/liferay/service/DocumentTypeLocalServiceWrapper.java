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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeLocalService
 * @generated
 */
public class DocumentTypeLocalServiceWrapper
	implements DocumentTypeLocalService,
			   ServiceWrapper<DocumentTypeLocalService> {

	public DocumentTypeLocalServiceWrapper(
		DocumentTypeLocalService documentTypeLocalService) {

		_documentTypeLocalService = documentTypeLocalService;
	}

	/**
	 * Adds the document type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentType the document type
	 * @return the document type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType addDocumentType(
		com.adjecti.mdm.liferay.model.DocumentType documentType) {

		return _documentTypeLocalService.addDocumentType(documentType);
	}

	/**
	 * Creates a new document type with the primary key. Does not add the document type to the database.
	 *
	 * @param documentTypeId the primary key for the new document type
	 * @return the new document type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType createDocumentType(
		long documentTypeId) {

		return _documentTypeLocalService.createDocumentType(documentTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the document type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentType the document type
	 * @return the document type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType deleteDocumentType(
		com.adjecti.mdm.liferay.model.DocumentType documentType) {

		return _documentTypeLocalService.deleteDocumentType(documentType);
	}

	/**
	 * Deletes the document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type that was removed
	 * @throws PortalException if a document type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType deleteDocumentType(
			long documentTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeLocalService.deleteDocumentType(documentTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentTypeLocalService.dynamicQuery();
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

		return _documentTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DocumentTypeModelImpl</code>.
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

		return _documentTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DocumentTypeModelImpl</code>.
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

		return _documentTypeLocalService.dynamicQuery(
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

		return _documentTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DocumentType fetchDocumentType(
		long documentTypeId) {

		return _documentTypeLocalService.fetchDocumentType(documentTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document type with the primary key.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type
	 * @throws PortalException if a document type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType getDocumentType(
			long documentTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeLocalService.getDocumentType(documentTypeId);
	}

	@Override
	public long getDocumentTypeIdByName(String name) {
		return _documentTypeLocalService.getDocumentTypeIdByName(name);
	}

	/**
	 * Returns a range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @return the range of document types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DocumentType>
		getDocumentTypes(int start, int end) {

		return _documentTypeLocalService.getDocumentTypes(start, end);
	}

	/**
	 * Returns the number of document types.
	 *
	 * @return the number of document types
	 */
	@Override
	public int getDocumentTypesCount() {
		return _documentTypeLocalService.getDocumentTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the document type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentType the document type
	 * @return the document type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DocumentType updateDocumentType(
		com.adjecti.mdm.liferay.model.DocumentType documentType) {

		return _documentTypeLocalService.updateDocumentType(documentType);
	}

	@Override
	public DocumentTypeLocalService getWrappedService() {
		return _documentTypeLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentTypeLocalService documentTypeLocalService) {

		_documentTypeLocalService = documentTypeLocalService;
	}

	private DocumentTypeLocalService _documentTypeLocalService;

}