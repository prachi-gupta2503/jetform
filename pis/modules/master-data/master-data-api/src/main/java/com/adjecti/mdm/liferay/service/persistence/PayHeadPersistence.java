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

import com.adjecti.mdm.liferay.exception.NoSuchPayHeadException;
import com.adjecti.mdm.liferay.model.PayHead;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadUtil
 * @generated
 */
@ProviderType
public interface PayHeadPersistence extends BasePersistence<PayHead> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayHeadUtil} to access the pay head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pay head in the entity cache if it is enabled.
	 *
	 * @param payHead the pay head
	 */
	public void cacheResult(PayHead payHead);

	/**
	 * Caches the pay heads in the entity cache if it is enabled.
	 *
	 * @param payHeads the pay heads
	 */
	public void cacheResult(java.util.List<PayHead> payHeads);

	/**
	 * Creates a new pay head with the primary key. Does not add the pay head to the database.
	 *
	 * @param payHeadId the primary key for the new pay head
	 * @return the new pay head
	 */
	public PayHead create(long payHeadId);

	/**
	 * Removes the pay head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head that was removed
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	public PayHead remove(long payHeadId) throws NoSuchPayHeadException;

	public PayHead updateImpl(PayHead payHead);

	/**
	 * Returns the pay head with the primary key or throws a <code>NoSuchPayHeadException</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	public PayHead findByPrimaryKey(long payHeadId)
		throws NoSuchPayHeadException;

	/**
	 * Returns the pay head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head, or <code>null</code> if a pay head with the primary key could not be found
	 */
	public PayHead fetchByPrimaryKey(long payHeadId);

	/**
	 * Returns all the pay heads.
	 *
	 * @return the pay heads
	 */
	public java.util.List<PayHead> findAll();

	/**
	 * Returns a range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @return the range of pay heads
	 */
	public java.util.List<PayHead> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay heads
	 */
	public java.util.List<PayHead> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayHead>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay heads
	 */
	public java.util.List<PayHead> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayHead>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay heads from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay heads.
	 *
	 * @return the number of pay heads
	 */
	public int countAll();

}