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

import com.adjecti.mdm.liferay.model.DocumentType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the document type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DocumentTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypePersistence
 * @generated
 */
public class DocumentTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DocumentType documentType) {
		getPersistence().clearCache(documentType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DocumentType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentType update(DocumentType documentType) {
		return getPersistence().update(documentType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentType update(
		DocumentType documentType, ServiceContext serviceContext) {

		return getPersistence().update(documentType, serviceContext);
	}

	/**
	 * Returns the document type where name = &#63; or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching document type
	 * @throws NoSuchDocumentTypeException if a matching document type could not be found
	 */
	public static DocumentType findByDocumentTypeName(String name)
		throws com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException {

		return getPersistence().findByDocumentTypeName(name);
	}

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	public static DocumentType fetchByDocumentTypeName(String name) {
		return getPersistence().fetchByDocumentTypeName(name);
	}

	/**
	 * Returns the document type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type, or <code>null</code> if a matching document type could not be found
	 */
	public static DocumentType fetchByDocumentTypeName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByDocumentTypeName(name, useFinderCache);
	}

	/**
	 * Removes the document type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the document type that was removed
	 */
	public static DocumentType removeByDocumentTypeName(String name)
		throws com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException {

		return getPersistence().removeByDocumentTypeName(name);
	}

	/**
	 * Returns the number of document types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching document types
	 */
	public static int countByDocumentTypeName(String name) {
		return getPersistence().countByDocumentTypeName(name);
	}

	/**
	 * Caches the document type in the entity cache if it is enabled.
	 *
	 * @param documentType the document type
	 */
	public static void cacheResult(DocumentType documentType) {
		getPersistence().cacheResult(documentType);
	}

	/**
	 * Caches the document types in the entity cache if it is enabled.
	 *
	 * @param documentTypes the document types
	 */
	public static void cacheResult(List<DocumentType> documentTypes) {
		getPersistence().cacheResult(documentTypes);
	}

	/**
	 * Creates a new document type with the primary key. Does not add the document type to the database.
	 *
	 * @param documentTypeId the primary key for the new document type
	 * @return the new document type
	 */
	public static DocumentType create(long documentTypeId) {
		return getPersistence().create(documentTypeId);
	}

	/**
	 * Removes the document type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type that was removed
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	public static DocumentType remove(long documentTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException {

		return getPersistence().remove(documentTypeId);
	}

	public static DocumentType updateImpl(DocumentType documentType) {
		return getPersistence().updateImpl(documentType);
	}

	/**
	 * Returns the document type with the primary key or throws a <code>NoSuchDocumentTypeException</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type
	 * @throws NoSuchDocumentTypeException if a document type with the primary key could not be found
	 */
	public static DocumentType findByPrimaryKey(long documentTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDocumentTypeException {

		return getPersistence().findByPrimaryKey(documentTypeId);
	}

	/**
	 * Returns the document type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeId the primary key of the document type
	 * @return the document type, or <code>null</code> if a document type with the primary key could not be found
	 */
	public static DocumentType fetchByPrimaryKey(long documentTypeId) {
		return getPersistence().fetchByPrimaryKey(documentTypeId);
	}

	/**
	 * Returns all the document types.
	 *
	 * @return the document types
	 */
	public static List<DocumentType> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DocumentType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DocumentType> findAll(
		int start, int end, OrderByComparator<DocumentType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DocumentType> findAll(
		int start, int end, OrderByComparator<DocumentType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document types.
	 *
	 * @return the number of document types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DocumentTypePersistence, DocumentTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DocumentTypePersistence.class);

		ServiceTracker<DocumentTypePersistence, DocumentTypePersistence>
			serviceTracker =
				new ServiceTracker
					<DocumentTypePersistence, DocumentTypePersistence>(
						bundle.getBundleContext(),
						DocumentTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}