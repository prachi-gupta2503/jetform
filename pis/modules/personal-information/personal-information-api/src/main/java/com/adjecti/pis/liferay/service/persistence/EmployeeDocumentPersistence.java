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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDocumentException;
import com.adjecti.pis.liferay.model.EmployeeDocument;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentUtil
 * @generated
 */
@ProviderType
public interface EmployeeDocumentPersistence
	extends BasePersistence<EmployeeDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDocumentUtil} to access the employee document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByEmployeeId(long employeeId);

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
	public java.util.List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

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
	public java.util.List<EmployeeDocument> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the first employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the last employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDocumentId the primary key of the current employee document
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument[] findByEmployeeId_PrevAndNext(
			long employeeDocumentId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Removes all the employee documents where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee documents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee documents
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns the employee document where documentId = &#63; or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByDocumentId(long documentId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByDocumentId(long documentId);

	/**
	 * Returns the employee document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByDocumentId(
		long documentId, boolean useFinderCache);

	/**
	 * Removes the employee document where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the employee document that was removed
	 */
	public EmployeeDocument removeByDocumentId(long documentId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the number of employee documents where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching employee documents
	 */
	public int countByDocumentId(long documentId);

	/**
	 * Caches the employee document in the entity cache if it is enabled.
	 *
	 * @param employeeDocument the employee document
	 */
	public void cacheResult(EmployeeDocument employeeDocument);

	/**
	 * Caches the employee documents in the entity cache if it is enabled.
	 *
	 * @param employeeDocuments the employee documents
	 */
	public void cacheResult(java.util.List<EmployeeDocument> employeeDocuments);

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param employeeDocumentId the primary key for the new employee document
	 * @return the new employee document
	 */
	public EmployeeDocument create(long employeeDocumentId);

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument remove(long employeeDocumentId)
		throws NoSuchEmployeeDocumentException;

	public EmployeeDocument updateImpl(EmployeeDocument employeeDocument);

	/**
	 * Returns the employee document with the primary key or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument findByPrimaryKey(long employeeDocumentId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the employee document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDocumentId the primary key of the employee document
	 * @return the employee document, or <code>null</code> if a employee document with the primary key could not be found
	 */
	public EmployeeDocument fetchByPrimaryKey(long employeeDocumentId);

	/**
	 * Returns all the employee documents.
	 *
	 * @return the employee documents
	 */
	public java.util.List<EmployeeDocument> findAll();

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
	public java.util.List<EmployeeDocument> findAll(int start, int end);

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
	public java.util.List<EmployeeDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

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
	public java.util.List<EmployeeDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	public int countAll();

}