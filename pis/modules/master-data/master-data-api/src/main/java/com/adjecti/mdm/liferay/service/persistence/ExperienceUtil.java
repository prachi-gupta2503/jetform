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

import com.adjecti.mdm.liferay.model.Experience;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the experience service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.ExperiencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperiencePersistence
 * @generated
 */
public class ExperienceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Experience experience) {
		getPersistence().clearCache(experience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Experience> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Experience> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Experience update(Experience experience) {
		return getPersistence().update(experience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Experience update(
		Experience experience, ServiceContext serviceContext) {

		return getPersistence().update(experience, serviceContext);
	}

	/**
	 * Returns all the experiences where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching experiences
	 */
	public static List<Experience> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

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
	public static List<Experience> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

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
	public static List<Experience> findByCode(
		String code, int start, int end,
		OrderByComparator<Experience> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

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
	public static List<Experience> findByCode(
		String code, int start, int end,
		OrderByComparator<Experience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public static Experience findByCode_First(
			String code, OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public static Experience fetchByCode_First(
		String code, OrderByComparator<Experience> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public static Experience findByCode_Last(
			String code, OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last experience in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public static Experience fetchByCode_Last(
		String code, OrderByComparator<Experience> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the experiences before and after the current experience in the ordered set where code = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public static Experience[] findByCode_PrevAndNext(
			long experienceId, String code,
			OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByCode_PrevAndNext(
			experienceId, code, orderByComparator);
	}

	/**
	 * Removes all the experiences where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of experiences where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching experiences
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the experiences where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching experiences
	 */
	public static List<Experience> findByName(String name) {
		return getPersistence().findByName(name);
	}

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
	public static List<Experience> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

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
	public static List<Experience> findByName(
		String name, int start, int end,
		OrderByComparator<Experience> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

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
	public static List<Experience> findByName(
		String name, int start, int end,
		OrderByComparator<Experience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public static Experience findByName_First(
			String name, OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public static Experience fetchByName_First(
		String name, OrderByComparator<Experience> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public static Experience findByName_Last(
			String name, OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last experience in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public static Experience fetchByName_Last(
		String name, OrderByComparator<Experience> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the experiences before and after the current experience in the ordered set where name = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public static Experience[] findByName_PrevAndNext(
			long experienceId, String name,
			OrderByComparator<Experience> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByName_PrevAndNext(
			experienceId, name, orderByComparator);
	}

	/**
	 * Removes all the experiences where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of experiences where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching experiences
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the experience in the entity cache if it is enabled.
	 *
	 * @param experience the experience
	 */
	public static void cacheResult(Experience experience) {
		getPersistence().cacheResult(experience);
	}

	/**
	 * Caches the experiences in the entity cache if it is enabled.
	 *
	 * @param experiences the experiences
	 */
	public static void cacheResult(List<Experience> experiences) {
		getPersistence().cacheResult(experiences);
	}

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	public static Experience create(long experienceId) {
		return getPersistence().create(experienceId);
	}

	/**
	 * Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public static Experience remove(long experienceId)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().remove(experienceId);
	}

	public static Experience updateImpl(Experience experience) {
		return getPersistence().updateImpl(experience);
	}

	/**
	 * Returns the experience with the primary key or throws a <code>NoSuchExperienceException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public static Experience findByPrimaryKey(long experienceId)
		throws com.adjecti.mdm.liferay.exception.NoSuchExperienceException {

		return getPersistence().findByPrimaryKey(experienceId);
	}

	/**
	 * Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience, or <code>null</code> if a experience with the primary key could not be found
	 */
	public static Experience fetchByPrimaryKey(long experienceId) {
		return getPersistence().fetchByPrimaryKey(experienceId);
	}

	/**
	 * Returns all the experiences.
	 *
	 * @return the experiences
	 */
	public static List<Experience> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Experience> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Experience> findAll(
		int start, int end, OrderByComparator<Experience> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Experience> findAll(
		int start, int end, OrderByComparator<Experience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the experiences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExperiencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExperiencePersistence, ExperiencePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExperiencePersistence.class);

		ServiceTracker<ExperiencePersistence, ExperiencePersistence>
			serviceTracker =
				new ServiceTracker
					<ExperiencePersistence, ExperiencePersistence>(
						bundle.getBundleContext(), ExperiencePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}