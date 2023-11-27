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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDigitalSignatureException;
import com.adjecti.pis.liferay.model.EmployeeDigitalSignature;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee digital signature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignatureUtil
 * @generated
 */
@ProviderType
public interface EmployeeDigitalSignaturePersistence
	extends BasePersistence<EmployeeDigitalSignature> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDigitalSignatureUtil} to access the employee digital signature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public EmployeeDigitalSignature[] findByEmployeeId_PrevAndNext(
			long employeeDigitalSignatureId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Removes all the employee digital signatures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee digital signatures
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByCid(String cid);

	/**
	 * Returns a range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end);

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature findByCid_First(
			String cid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature fetchByCid_First(
		String cid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature findByCid_Last(
			String cid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public EmployeeDigitalSignature fetchByCid_Last(
		String cid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public EmployeeDigitalSignature[] findByCid_PrevAndNext(
			long employeeDigitalSignatureId, String cid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDigitalSignature> orderByComparator)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Removes all the employee digital signatures where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	public void removeByCid(String cid);

	/**
	 * Returns the number of employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee digital signatures
	 */
	public int countByCid(String cid);

	/**
	 * Caches the employee digital signature in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 */
	public void cacheResult(EmployeeDigitalSignature employeeDigitalSignature);

	/**
	 * Caches the employee digital signatures in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignatures the employee digital signatures
	 */
	public void cacheResult(
		java.util.List<EmployeeDigitalSignature> employeeDigitalSignatures);

	/**
	 * Creates a new employee digital signature with the primary key. Does not add the employee digital signature to the database.
	 *
	 * @param employeeDigitalSignatureId the primary key for the new employee digital signature
	 * @return the new employee digital signature
	 */
	public EmployeeDigitalSignature create(long employeeDigitalSignatureId);

	/**
	 * Removes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public EmployeeDigitalSignature remove(long employeeDigitalSignatureId)
		throws NoSuchEmployeeDigitalSignatureException;

	public EmployeeDigitalSignature updateImpl(
		EmployeeDigitalSignature employeeDigitalSignature);

	/**
	 * Returns the employee digital signature with the primary key or throws a <code>NoSuchEmployeeDigitalSignatureException</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public EmployeeDigitalSignature findByPrimaryKey(
			long employeeDigitalSignatureId)
		throws NoSuchEmployeeDigitalSignatureException;

	/**
	 * Returns the employee digital signature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature, or <code>null</code> if a employee digital signature with the primary key could not be found
	 */
	public EmployeeDigitalSignature fetchByPrimaryKey(
		long employeeDigitalSignatureId);

	/**
	 * Returns all the employee digital signatures.
	 *
	 * @return the employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findAll();

	/**
	 * Returns a range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator);

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee digital signatures
	 */
	public java.util.List<EmployeeDigitalSignature> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee digital signatures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee digital signatures.
	 *
	 * @return the number of employee digital signatures
	 */
	public int countAll();

}