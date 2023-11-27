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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.model.EmployeeDocument;

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
 * The persistence utility for the employee document service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentPersistence
 * @generated
 */
public class EmployeeDocumentUtil {

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
	public static void clearCache(EmployeeDocument employeeDocument) {
		getPersistence().clearCache(employeeDocument);
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
	public static Map<Serializable, EmployeeDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDocument update(EmployeeDocument employeeDocument) {
		return getPersistence().update(employeeDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDocument update(
		EmployeeDocument employeeDocument, ServiceContext serviceContext) {

		return getPersistence().update(employeeDocument, serviceContext);
	}

	/**
	 * Returns all the employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee documents
	 */
	public static List<EmployeeDocument> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of matching employee documents
	 */
	public static List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee documents
	 */
	public static List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee documents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee documents
	 */
	public static List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDocumentId the primary key of the current employee document
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument[] findByEmployeeId_PrevAndNext(
			long employeeDocumentId, long employeeId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeDocumentId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee documents where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee documents
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee document where documentId = &#63; or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByDocumentId(long documentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().findByDocumentId(documentId);
	}

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByDocumentId(long documentId) {
		return getPersistence().fetchByDocumentId(documentId);
	}

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByDocumentId(
		long documentId, boolean useFinderCache) {

		return getPersistence().fetchByDocumentId(documentId, useFinderCache);
	}

	/**
	 * Removes the employee document where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the employee document that was removed
	 */
	public static EmployeeDocument removeByDocumentId(long documentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().removeByDocumentId(documentId);
	}

	/**
	 * Returns the number of employee documents where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching employee documents
	 */
	public static int countByDocumentId(long documentId) {
		return getPersistence().countByDocumentId(documentId);
	}

	/**
	 * Caches the employee document in the entity cache if it is enabled.
	 *
	 * @param employeeDocument the employee document
	 */
	public static void cacheResult(EmployeeDocument employeeDocument) {
		getPersistence().cacheResult(employeeDocument);
	}

	/**
	 * Caches the employee documents in the entity cache if it is enabled.
	 *
	 * @param employeeDocuments the employee documents
	 */
	public static void cacheResult(List<EmployeeDocument> employeeDocuments) {
		getPersistence().cacheResult(employeeDocuments);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param employeeDocumentId the primary key for the new employee document
	 * @return the new employee document
	 */
	public static EmployeeDocument create(long employeeDocumentId) {
		return getPersistence().create(employeeDocumentId);
	}

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument remove(long employeeDocumentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().remove(employeeDocumentId);
	}

	public static EmployeeDocument updateImpl(
		EmployeeDocument employeeDocument) {

		return getPersistence().updateImpl(employeeDocument);
	}

	/**
	 * Returns the employee document with the primary key or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument findByPrimaryKey(long employeeDocumentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDocumentException {

		return getPersistence().findByPrimaryKey(employeeDocumentId);
	}

	/**
	 * Returns the employee document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document, or <code>null</code> if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument fetchByPrimaryKey(long employeeDocumentId) {
		return getPersistence().fetchByPrimaryKey(employeeDocumentId);
	}

	/**
	 * Returns all the employee documents.
	 *
	 * @return the employee documents
	 */
	public static List<EmployeeDocument> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of employee documents
	 */
	public static List<EmployeeDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee documents
	 */
	public static List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee documents
	 */
	public static List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDocumentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDocumentPersistence, EmployeeDocumentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDocumentPersistence.class);

		ServiceTracker<EmployeeDocumentPersistence, EmployeeDocumentPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeDocumentPersistence, EmployeeDocumentPersistence>(
						bundle.getBundleContext(),
						EmployeeDocumentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}