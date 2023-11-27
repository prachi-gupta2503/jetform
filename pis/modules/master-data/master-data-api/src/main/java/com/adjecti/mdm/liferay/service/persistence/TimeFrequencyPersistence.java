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

import com.adjecti.mdm.liferay.exception.NoSuchTimeFrequencyException;
import com.adjecti.mdm.liferay.model.TimeFrequency;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the time frequency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeFrequencyUtil
 * @generated
 */
@ProviderType
public interface TimeFrequencyPersistence
	extends BasePersistence<TimeFrequency> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimeFrequencyUtil} to access the time frequency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the time frequency in the entity cache if it is enabled.
	 *
	 * @param timeFrequency the time frequency
	 */
	public void cacheResult(TimeFrequency timeFrequency);

	/**
	 * Caches the time frequencies in the entity cache if it is enabled.
	 *
	 * @param timeFrequencies the time frequencies
	 */
	public void cacheResult(java.util.List<TimeFrequency> timeFrequencies);

	/**
	 * Creates a new time frequency with the primary key. Does not add the time frequency to the database.
	 *
	 * @param timeFrequencyId the primary key for the new time frequency
	 * @return the new time frequency
	 */
	public TimeFrequency create(long timeFrequencyId);

	/**
	 * Removes the time frequency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency that was removed
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	public TimeFrequency remove(long timeFrequencyId)
		throws NoSuchTimeFrequencyException;

	public TimeFrequency updateImpl(TimeFrequency timeFrequency);

	/**
	 * Returns the time frequency with the primary key or throws a <code>NoSuchTimeFrequencyException</code> if it could not be found.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	public TimeFrequency findByPrimaryKey(long timeFrequencyId)
		throws NoSuchTimeFrequencyException;

	/**
	 * Returns the time frequency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency, or <code>null</code> if a time frequency with the primary key could not be found
	 */
	public TimeFrequency fetchByPrimaryKey(long timeFrequencyId);

	/**
	 * Returns all the time frequencies.
	 *
	 * @return the time frequencies
	 */
	public java.util.List<TimeFrequency> findAll();

	/**
	 * Returns a range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @return the range of time frequencies
	 */
	public java.util.List<TimeFrequency> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time frequencies
	 */
	public java.util.List<TimeFrequency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeFrequency>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of time frequencies
	 */
	public java.util.List<TimeFrequency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeFrequency>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the time frequencies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of time frequencies.
	 *
	 * @return the number of time frequencies
	 */
	public int countAll();

}