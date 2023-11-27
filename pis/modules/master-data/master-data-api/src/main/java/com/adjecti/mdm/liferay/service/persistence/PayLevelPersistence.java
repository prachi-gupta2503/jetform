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

import com.adjecti.mdm.liferay.exception.NoSuchPayLevelException;
import com.adjecti.mdm.liferay.model.PayLevel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayLevelUtil
 * @generated
 */
@ProviderType
public interface PayLevelPersistence extends BasePersistence<PayLevel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayLevelUtil} to access the pay level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pay level in the entity cache if it is enabled.
	 *
	 * @param payLevel the pay level
	 */
	public void cacheResult(PayLevel payLevel);

	/**
	 * Caches the pay levels in the entity cache if it is enabled.
	 *
	 * @param payLevels the pay levels
	 */
	public void cacheResult(java.util.List<PayLevel> payLevels);

	/**
	 * Creates a new pay level with the primary key. Does not add the pay level to the database.
	 *
	 * @param payLevelId the primary key for the new pay level
	 * @return the new pay level
	 */
	public PayLevel create(long payLevelId);

	/**
	 * Removes the pay level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payLevelId the primary key of the pay level
	 * @return the pay level that was removed
	 * @throws NoSuchPayLevelException if a pay level with the primary key could not be found
	 */
	public PayLevel remove(long payLevelId) throws NoSuchPayLevelException;

	public PayLevel updateImpl(PayLevel payLevel);

	/**
	 * Returns the pay level with the primary key or throws a <code>NoSuchPayLevelException</code> if it could not be found.
	 *
	 * @param payLevelId the primary key of the pay level
	 * @return the pay level
	 * @throws NoSuchPayLevelException if a pay level with the primary key could not be found
	 */
	public PayLevel findByPrimaryKey(long payLevelId)
		throws NoSuchPayLevelException;

	/**
	 * Returns the pay level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payLevelId the primary key of the pay level
	 * @return the pay level, or <code>null</code> if a pay level with the primary key could not be found
	 */
	public PayLevel fetchByPrimaryKey(long payLevelId);

	/**
	 * Returns all the pay levels.
	 *
	 * @return the pay levels
	 */
	public java.util.List<PayLevel> findAll();

	/**
	 * Returns a range of all the pay levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay levels
	 * @param end the upper bound of the range of pay levels (not inclusive)
	 * @return the range of pay levels
	 */
	public java.util.List<PayLevel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay levels
	 * @param end the upper bound of the range of pay levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay levels
	 */
	public java.util.List<PayLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayLevel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay levels
	 * @param end the upper bound of the range of pay levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay levels
	 */
	public java.util.List<PayLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayLevel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay levels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay levels.
	 *
	 * @return the number of pay levels
	 */
	public int countAll();

}