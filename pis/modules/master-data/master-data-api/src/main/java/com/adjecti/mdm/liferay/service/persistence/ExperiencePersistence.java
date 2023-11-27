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

import com.adjecti.mdm.liferay.exception.NoSuchExperienceException;
import com.adjecti.mdm.liferay.model.Experience;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceUtil
 * @generated
 */
@ProviderType
public interface ExperiencePersistence extends BasePersistence<Experience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExperienceUtil} to access the experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the experiences where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching experiences
	 */
	public java.util.List<Experience> findByCode(String code);

	/**
	 * Returns a range of all the experiences where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 */
	public java.util.List<Experience> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the experiences where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the first experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the last experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the last experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the experiences before and after the current experience in the ordered set where code = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience[] findByCode_PrevAndNext(
			long experienceId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Removes all the experiences where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of experiences where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching experiences
	 */
	public int countByCode(String code);

	/**
	 * Returns all the experiences where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching experiences
	 */
	public java.util.List<Experience> findByName(String name);

	/**
	 * Returns a range of all the experiences where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 */
	public java.util.List<Experience> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the experiences where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the first experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the last experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the last experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the experiences before and after the current experience in the ordered set where name = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience[] findByName_PrevAndNext(
			long experienceId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Removes all the experiences where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of experiences where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching experiences
	 */
	public int countByName(String name);

	/**
	 * Caches the experience in the entity cache if it is enabled.
	 *
	 * @param experience the experience
	 */
	public void cacheResult(Experience experience);

	/**
	 * Caches the experiences in the entity cache if it is enabled.
	 *
	 * @param experiences the experiences
	 */
	public void cacheResult(java.util.List<Experience> experiences);

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	public Experience create(long experienceId);

	/**
	 * Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience remove(long experienceId)
		throws NoSuchExperienceException;

	public Experience updateImpl(Experience experience);

	/**
	 * Returns the experience with the primary key or throws a <code>NoSuchExperienceException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience findByPrimaryKey(long experienceId)
		throws NoSuchExperienceException;

	/**
	 * Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience, or <code>null</code> if a experience with the primary key could not be found
	 */
	public Experience fetchByPrimaryKey(long experienceId);

	/**
	 * Returns all the experiences.
	 *
	 * @return the experiences
	 */
	public java.util.List<Experience> findAll();

	/**
	 * Returns a range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of experiences
	 */
	public java.util.List<Experience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experiences
	 */
	public java.util.List<Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experiences
	 */
	public java.util.List<Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
	 */
	public int countAll();

}