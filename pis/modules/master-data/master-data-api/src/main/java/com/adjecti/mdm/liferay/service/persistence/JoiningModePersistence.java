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

import com.adjecti.mdm.liferay.exception.NoSuchJoiningModeException;
import com.adjecti.mdm.liferay.model.JoiningMode;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the joining mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningModeUtil
 * @generated
 */
@ProviderType
public interface JoiningModePersistence extends BasePersistence<JoiningMode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JoiningModeUtil} to access the joining mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the joining mode in the entity cache if it is enabled.
	 *
	 * @param joiningMode the joining mode
	 */
	public void cacheResult(JoiningMode joiningMode);

	/**
	 * Caches the joining modes in the entity cache if it is enabled.
	 *
	 * @param joiningModes the joining modes
	 */
	public void cacheResult(java.util.List<JoiningMode> joiningModes);

	/**
	 * Creates a new joining mode with the primary key. Does not add the joining mode to the database.
	 *
	 * @param joiningModeId the primary key for the new joining mode
	 * @return the new joining mode
	 */
	public JoiningMode create(long joiningModeId);

	/**
	 * Removes the joining mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode that was removed
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	public JoiningMode remove(long joiningModeId)
		throws NoSuchJoiningModeException;

	public JoiningMode updateImpl(JoiningMode joiningMode);

	/**
	 * Returns the joining mode with the primary key or throws a <code>NoSuchJoiningModeException</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	public JoiningMode findByPrimaryKey(long joiningModeId)
		throws NoSuchJoiningModeException;

	/**
	 * Returns the joining mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode, or <code>null</code> if a joining mode with the primary key could not be found
	 */
	public JoiningMode fetchByPrimaryKey(long joiningModeId);

	/**
	 * Returns all the joining modes.
	 *
	 * @return the joining modes
	 */
	public java.util.List<JoiningMode> findAll();

	/**
	 * Returns a range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @return the range of joining modes
	 */
	public java.util.List<JoiningMode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining modes
	 */
	public java.util.List<JoiningMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningMode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining modes
	 */
	public java.util.List<JoiningMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningMode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the joining modes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of joining modes.
	 *
	 * @return the number of joining modes
	 */
	public int countAll();

}