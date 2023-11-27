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

package com.adjecti.mdm.liferay.service.persistence;

import com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException;
import com.adjecti.mdm.liferay.model.DocumentType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeUtil
 * @generated
 */
@ProviderType
public interface DocumentTypePersistence extends BasePersistence<DocumentType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentTypeUtil} to access the document type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the document type where name = &#63; or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching document type
	 * @throws NoSuchDocumentTypeException if a matching document type could not be found
	 */
	public DocumentType findByDocumentTypeName(String name)
		throws NoSuchDocumentTypeException;

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	public DocumentType fetchByDocumentTypeName(String name);

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	public DocumentType fetchByDocumentTypeName(
		String name, boolean useFinderCache);

	/**
	 * Removes the document type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the document type that was removed
	 */
	public DocumentType removeByDocumentTypeName(String name)
		throws NoSuchDocumentTypeException;

	/**
	 * Returns the number of document types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching document types
	 */
	public int countByDocumentTypeName(String name);

	/**
	 * Caches the document type in the entity cache if it is enabled.
	 *
	 * @param documentType the document type
	 */
	public void cacheResult(DocumentType documentType);

	/**
	 * Caches the document types in the entity cache if it is enabled.
	 *
	 * @param documentTypes the document types
	 */
	public void cacheResult(java.util.List<DocumentType> documentTypes);

	/**
	 * Creates a new document type with the primary key. Does not add the document type to the database.
	 *
	 * @param documentTypeId the primary key for the new document type
	 * @return the new document type
	 */
	public DocumentType create(long documentTypeId);

	/**
	 * Removes the document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type that was removed
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	public DocumentType remove(long documentTypeId)
		throws NoSuchDocumentTypeException;

	public DocumentType updateImpl(DocumentType documentType);

	/**
	 * Returns the document type with the primary key or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	public DocumentType findByPrimaryKey(long documentTypeId)
		throws NoSuchDocumentTypeException;

	/**
	 * Returns the document type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type, or <code>null</code> if a document type with the primary key could not be found
	 */
	public DocumentType fetchByPrimaryKey(long documentTypeId);

	/**
	 * Returns all the document types.
	 *
	 * @return the document types
	 */
	public java.util.List<DocumentType> findAll();

	/**
	 * Returns a range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @return the range of document types
	 */
	public java.util.List<DocumentType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document types
	 */
	public java.util.List<DocumentType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document types
	 * @param end the upper bound of the range of document types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document types
	 */
	public java.util.List<DocumentType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document types.
	 *
	 * @return the number of document types
	 */
	public int countAll();

}