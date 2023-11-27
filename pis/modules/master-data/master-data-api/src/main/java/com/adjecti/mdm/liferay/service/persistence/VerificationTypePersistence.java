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

import com.adjecti.mdm.liferay.exception.NoSuchVerificationTypeException;
import com.adjecti.mdm.liferay.model.VerificationType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the verification type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificationTypeUtil
 * @generated
 */
@ProviderType
public interface VerificationTypePersistence
	extends BasePersistence<VerificationType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VerificationTypeUtil} to access the verification type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the verification type in the entity cache if it is enabled.
	 *
	 * @param verificationType the verification type
	 */
	public void cacheResult(VerificationType verificationType);

	/**
	 * Caches the verification types in the entity cache if it is enabled.
	 *
	 * @param verificationTypes the verification types
	 */
	public void cacheResult(java.util.List<VerificationType> verificationTypes);

	/**
	 * Creates a new verification type with the primary key. Does not add the verification type to the database.
	 *
	 * @param verificationTypeId the primary key for the new verification type
	 * @return the new verification type
	 */
	public VerificationType create(long verificationTypeId);

	/**
	 * Removes the verification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type that was removed
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	public VerificationType remove(long verificationTypeId)
		throws NoSuchVerificationTypeException;

	public VerificationType updateImpl(VerificationType verificationType);

	/**
	 * Returns the verification type with the primary key or throws a <code>NoSuchVerificationTypeException</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	public VerificationType findByPrimaryKey(long verificationTypeId)
		throws NoSuchVerificationTypeException;

	/**
	 * Returns the verification type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type, or <code>null</code> if a verification type with the primary key could not be found
	 */
	public VerificationType fetchByPrimaryKey(long verificationTypeId);

	/**
	 * Returns all the verification types.
	 *
	 * @return the verification types
	 */
	public java.util.List<VerificationType> findAll();

	/**
	 * Returns a range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @return the range of verification types
	 */
	public java.util.List<VerificationType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verification types
	 */
	public java.util.List<VerificationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificationType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verification types
	 */
	public java.util.List<VerificationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the verification types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of verification types.
	 *
	 * @return the number of verification types
	 */
	public int countAll();

}