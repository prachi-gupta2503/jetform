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

import com.adjecti.mdm.liferay.exception.NoSuchPersonalNoPrefixException;
import com.adjecti.mdm.liferay.model.PersonalNoPrefix;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the personal no prefix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalNoPrefixUtil
 * @generated
 */
@ProviderType
public interface PersonalNoPrefixPersistence
	extends BasePersistence<PersonalNoPrefix> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonalNoPrefixUtil} to access the personal no prefix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the personal no prefix in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefix the personal no prefix
	 */
	public void cacheResult(PersonalNoPrefix personalNoPrefix);

	/**
	 * Caches the personal no prefixes in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefixes the personal no prefixes
	 */
	public void cacheResult(
		java.util.List<PersonalNoPrefix> personalNoPrefixes);

	/**
	 * Creates a new personal no prefix with the primary key. Does not add the personal no prefix to the database.
	 *
	 * @param personalNoPrefixId the primary key for the new personal no prefix
	 * @return the new personal no prefix
	 */
	public PersonalNoPrefix create(long personalNoPrefixId);

	/**
	 * Removes the personal no prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix that was removed
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	public PersonalNoPrefix remove(long personalNoPrefixId)
		throws NoSuchPersonalNoPrefixException;

	public PersonalNoPrefix updateImpl(PersonalNoPrefix personalNoPrefix);

	/**
	 * Returns the personal no prefix with the primary key or throws a <code>NoSuchPersonalNoPrefixException</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	public PersonalNoPrefix findByPrimaryKey(long personalNoPrefixId)
		throws NoSuchPersonalNoPrefixException;

	/**
	 * Returns the personal no prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix, or <code>null</code> if a personal no prefix with the primary key could not be found
	 */
	public PersonalNoPrefix fetchByPrimaryKey(long personalNoPrefixId);

	/**
	 * Returns all the personal no prefixes.
	 *
	 * @return the personal no prefixes
	 */
	public java.util.List<PersonalNoPrefix> findAll();

	/**
	 * Returns a range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @return the range of personal no prefixes
	 */
	public java.util.List<PersonalNoPrefix> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal no prefixes
	 */
	public java.util.List<PersonalNoPrefix> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalNoPrefix>
			orderByComparator);

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal no prefixes
	 */
	public java.util.List<PersonalNoPrefix> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalNoPrefix>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the personal no prefixes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of personal no prefixes.
	 *
	 * @return the number of personal no prefixes
	 */
	public int countAll();

}