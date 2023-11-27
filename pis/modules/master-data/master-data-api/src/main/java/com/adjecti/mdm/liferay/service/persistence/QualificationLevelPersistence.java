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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationLevelException;
import com.adjecti.mdm.liferay.model.QualificationLevel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qualification level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLevelUtil
 * @generated
 */
@ProviderType
public interface QualificationLevelPersistence
	extends BasePersistence<QualificationLevel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QualificationLevelUtil} to access the qualification level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByCode(String code);

	/**
	 * Returns a range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public QualificationLevel findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public QualificationLevel fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public QualificationLevel findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public QualificationLevel fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where code = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public QualificationLevel[] findByCode_PrevAndNext(
			long qualificationLevelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Removes all the qualification levels where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification levels
	 */
	public int countByCode(String code);

	/**
	 * Returns all the qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByName(String name);

	/**
	 * Returns a range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	public java.util.List<QualificationLevel> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public QualificationLevel findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public QualificationLevel fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public QualificationLevel findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public QualificationLevel fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where name = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public QualificationLevel[] findByName_PrevAndNext(
			long qualificationLevelId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
				orderByComparator)
		throws NoSuchQualificationLevelException;

	/**
	 * Removes all the qualification levels where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification levels
	 */
	public int countByName(String name);

	/**
	 * Caches the qualification level in the entity cache if it is enabled.
	 *
	 * @param qualificationLevel the qualification level
	 */
	public void cacheResult(QualificationLevel qualificationLevel);

	/**
	 * Caches the qualification levels in the entity cache if it is enabled.
	 *
	 * @param qualificationLevels the qualification levels
	 */
	public void cacheResult(
		java.util.List<QualificationLevel> qualificationLevels);

	/**
	 * Creates a new qualification level with the primary key. Does not add the qualification level to the database.
	 *
	 * @param qualificationLevelId the primary key for the new qualification level
	 * @return the new qualification level
	 */
	public QualificationLevel create(long qualificationLevelId);

	/**
	 * Removes the qualification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level that was removed
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public QualificationLevel remove(long qualificationLevelId)
		throws NoSuchQualificationLevelException;

	public QualificationLevel updateImpl(QualificationLevel qualificationLevel);

	/**
	 * Returns the qualification level with the primary key or throws a <code>NoSuchQualificationLevelException</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public QualificationLevel findByPrimaryKey(long qualificationLevelId)
		throws NoSuchQualificationLevelException;

	/**
	 * Returns the qualification level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level, or <code>null</code> if a qualification level with the primary key could not be found
	 */
	public QualificationLevel fetchByPrimaryKey(long qualificationLevelId);

	/**
	 * Returns all the qualification levels.
	 *
	 * @return the qualification levels
	 */
	public java.util.List<QualificationLevel> findAll();

	/**
	 * Returns a range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of qualification levels
	 */
	public java.util.List<QualificationLevel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification levels
	 */
	public java.util.List<QualificationLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification levels
	 */
	public java.util.List<QualificationLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationLevel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the qualification levels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qualification levels.
	 *
	 * @return the number of qualification levels
	 */
	public int countAll();

}