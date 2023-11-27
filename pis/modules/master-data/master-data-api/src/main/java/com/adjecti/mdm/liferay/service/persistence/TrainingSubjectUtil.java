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

import com.adjecti.mdm.liferay.model.TrainingSubject;

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
 * The persistence utility for the training subject service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.TrainingSubjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSubjectPersistence
 * @generated
 */
public class TrainingSubjectUtil {

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
	public static void clearCache(TrainingSubject trainingSubject) {
		getPersistence().clearCache(trainingSubject);
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
	public static Map<Serializable, TrainingSubject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrainingSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrainingSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrainingSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrainingSubject update(TrainingSubject trainingSubject) {
		return getPersistence().update(trainingSubject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrainingSubject update(
		TrainingSubject trainingSubject, ServiceContext serviceContext) {

		return getPersistence().update(trainingSubject, serviceContext);
	}

	/**
	 * Returns all the training subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training subjects
	 */
	public static List<TrainingSubject> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of matching training subjects
	 */
	public static List<TrainingSubject> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training subjects
	 */
	public static List<TrainingSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training subjects
	 */
	public static List<TrainingSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public static TrainingSubject findByCode_First(
			String code, OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public static TrainingSubject fetchByCode_First(
		String code, OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public static TrainingSubject findByCode_Last(
			String code, OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public static TrainingSubject fetchByCode_Last(
		String code, OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the training subjects before and after the current training subject in the ordered set where code = &#63;.
	 *
	 * @param trainingSubjectId the primary key of the current training subject
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public static TrainingSubject[] findByCode_PrevAndNext(
			long trainingSubjectId, String code,
			OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByCode_PrevAndNext(
			trainingSubjectId, code, orderByComparator);
	}

	/**
	 * Removes all the training subjects where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of training subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training subjects
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the training subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training subjects
	 */
	public static List<TrainingSubject> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of matching training subjects
	 */
	public static List<TrainingSubject> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training subjects
	 */
	public static List<TrainingSubject> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training subjects
	 */
	public static List<TrainingSubject> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public static TrainingSubject findByName_First(
			String name, OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public static TrainingSubject fetchByName_First(
		String name, OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public static TrainingSubject findByName_Last(
			String name, OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public static TrainingSubject fetchByName_Last(
		String name, OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the training subjects before and after the current training subject in the ordered set where name = &#63;.
	 *
	 * @param trainingSubjectId the primary key of the current training subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public static TrainingSubject[] findByName_PrevAndNext(
			long trainingSubjectId, String name,
			OrderByComparator<TrainingSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByName_PrevAndNext(
			trainingSubjectId, name, orderByComparator);
	}

	/**
	 * Removes all the training subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of training subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training subjects
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the training subject in the entity cache if it is enabled.
	 *
	 * @param trainingSubject the training subject
	 */
	public static void cacheResult(TrainingSubject trainingSubject) {
		getPersistence().cacheResult(trainingSubject);
	}

	/**
	 * Caches the training subjects in the entity cache if it is enabled.
	 *
	 * @param trainingSubjects the training subjects
	 */
	public static void cacheResult(List<TrainingSubject> trainingSubjects) {
		getPersistence().cacheResult(trainingSubjects);
	}

	/**
	 * Creates a new training subject with the primary key. Does not add the training subject to the database.
	 *
	 * @param trainingSubjectId the primary key for the new training subject
	 * @return the new training subject
	 */
	public static TrainingSubject create(long trainingSubjectId) {
		return getPersistence().create(trainingSubjectId);
	}

	/**
	 * Removes the training subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject that was removed
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public static TrainingSubject remove(long trainingSubjectId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().remove(trainingSubjectId);
	}

	public static TrainingSubject updateImpl(TrainingSubject trainingSubject) {
		return getPersistence().updateImpl(trainingSubject);
	}

	/**
	 * Returns the training subject with the primary key or throws a <code>NoSuchTrainingSubjectException</code> if it could not be found.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public static TrainingSubject findByPrimaryKey(long trainingSubjectId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingSubjectException {

		return getPersistence().findByPrimaryKey(trainingSubjectId);
	}

	/**
	 * Returns the training subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject, or <code>null</code> if a training subject with the primary key could not be found
	 */
	public static TrainingSubject fetchByPrimaryKey(long trainingSubjectId) {
		return getPersistence().fetchByPrimaryKey(trainingSubjectId);
	}

	/**
	 * Returns all the training subjects.
	 *
	 * @return the training subjects
	 */
	public static List<TrainingSubject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of training subjects
	 */
	public static List<TrainingSubject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training subjects
	 */
	public static List<TrainingSubject> findAll(
		int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training subjects
	 */
	public static List<TrainingSubject> findAll(
		int start, int end,
		OrderByComparator<TrainingSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the training subjects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of training subjects.
	 *
	 * @return the number of training subjects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TrainingSubjectPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TrainingSubjectPersistence, TrainingSubjectPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TrainingSubjectPersistence.class);

		ServiceTracker<TrainingSubjectPersistence, TrainingSubjectPersistence>
			serviceTracker =
				new ServiceTracker
					<TrainingSubjectPersistence, TrainingSubjectPersistence>(
						bundle.getBundleContext(),
						TrainingSubjectPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}