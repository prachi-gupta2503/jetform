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

import com.adjecti.mdm.liferay.exception.NoSuchGradeModeException;
import com.adjecti.mdm.liferay.model.GradeMode;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the grade mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GradeModeUtil
 * @generated
 */
@ProviderType
public interface GradeModePersistence extends BasePersistence<GradeMode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GradeModeUtil} to access the grade mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the grade mode in the entity cache if it is enabled.
	 *
	 * @param gradeMode the grade mode
	 */
	public void cacheResult(GradeMode gradeMode);

	/**
	 * Caches the grade modes in the entity cache if it is enabled.
	 *
	 * @param gradeModes the grade modes
	 */
	public void cacheResult(java.util.List<GradeMode> gradeModes);

	/**
	 * Creates a new grade mode with the primary key. Does not add the grade mode to the database.
	 *
	 * @param gradeModeId the primary key for the new grade mode
	 * @return the new grade mode
	 */
	public GradeMode create(long gradeModeId);

	/**
	 * Removes the grade mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode that was removed
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	public GradeMode remove(long gradeModeId) throws NoSuchGradeModeException;

	public GradeMode updateImpl(GradeMode gradeMode);

	/**
	 * Returns the grade mode with the primary key or throws a <code>NoSuchGradeModeException</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	public GradeMode findByPrimaryKey(long gradeModeId)
		throws NoSuchGradeModeException;

	/**
	 * Returns the grade mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode, or <code>null</code> if a grade mode with the primary key could not be found
	 */
	public GradeMode fetchByPrimaryKey(long gradeModeId);

	/**
	 * Returns all the grade modes.
	 *
	 * @return the grade modes
	 */
	public java.util.List<GradeMode> findAll();

	/**
	 * Returns a range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @return the range of grade modes
	 */
	public java.util.List<GradeMode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grade modes
	 */
	public java.util.List<GradeMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GradeMode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grade modes
	 */
	public java.util.List<GradeMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GradeMode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the grade modes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of grade modes.
	 *
	 * @return the number of grade modes
	 */
	public int countAll();

}