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

import com.adjecti.mdm.liferay.model.TrainingInstitute;

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
 * The persistence utility for the training institute service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.TrainingInstitutePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstitutePersistence
 * @generated
 */
public class TrainingInstituteUtil {

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
	public static void clearCache(TrainingInstitute trainingInstitute) {
		getPersistence().clearCache(trainingInstitute);
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
	public static Map<Serializable, TrainingInstitute> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrainingInstitute> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrainingInstitute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrainingInstitute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrainingInstitute update(
		TrainingInstitute trainingInstitute) {

		return getPersistence().update(trainingInstitute);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrainingInstitute update(
		TrainingInstitute trainingInstitute, ServiceContext serviceContext) {

		return getPersistence().update(trainingInstitute, serviceContext);
	}

	/**
	 * Returns all the training institutes where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training institutes
	 */
	public static List<TrainingInstitute> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of matching training institutes
	 */
	public static List<TrainingInstitute> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training institutes
	 */
	public static List<TrainingInstitute> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training institutes
	 */
	public static List<TrainingInstitute> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public static TrainingInstitute findByCode_First(
			String code, OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public static TrainingInstitute fetchByCode_First(
		String code, OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public static TrainingInstitute findByCode_Last(
			String code, OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public static TrainingInstitute fetchByCode_Last(
		String code, OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the training institutes before and after the current training institute in the ordered set where code = &#63;.
	 *
	 * @param trainingInstituteId the primary key of the current training institute
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public static TrainingInstitute[] findByCode_PrevAndNext(
			long trainingInstituteId, String code,
			OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByCode_PrevAndNext(
			trainingInstituteId, code, orderByComparator);
	}

	/**
	 * Removes all the training institutes where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of training institutes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training institutes
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the training institutes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training institutes
	 */
	public static List<TrainingInstitute> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of matching training institutes
	 */
	public static List<TrainingInstitute> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training institutes
	 */
	public static List<TrainingInstitute> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training institutes
	 */
	public static List<TrainingInstitute> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public static TrainingInstitute findByName_First(
			String name, OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public static TrainingInstitute fetchByName_First(
		String name, OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public static TrainingInstitute findByName_Last(
			String name, OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public static TrainingInstitute fetchByName_Last(
		String name, OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the training institutes before and after the current training institute in the ordered set where name = &#63;.
	 *
	 * @param trainingInstituteId the primary key of the current training institute
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public static TrainingInstitute[] findByName_PrevAndNext(
			long trainingInstituteId, String name,
			OrderByComparator<TrainingInstitute> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByName_PrevAndNext(
			trainingInstituteId, name, orderByComparator);
	}

	/**
	 * Removes all the training institutes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of training institutes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training institutes
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the training institute in the entity cache if it is enabled.
	 *
	 * @param trainingInstitute the training institute
	 */
	public static void cacheResult(TrainingInstitute trainingInstitute) {
		getPersistence().cacheResult(trainingInstitute);
	}

	/**
	 * Caches the training institutes in the entity cache if it is enabled.
	 *
	 * @param trainingInstitutes the training institutes
	 */
	public static void cacheResult(List<TrainingInstitute> trainingInstitutes) {
		getPersistence().cacheResult(trainingInstitutes);
	}

	/**
	 * Creates a new training institute with the primary key. Does not add the training institute to the database.
	 *
	 * @param trainingInstituteId the primary key for the new training institute
	 * @return the new training institute
	 */
	public static TrainingInstitute create(long trainingInstituteId) {
		return getPersistence().create(trainingInstituteId);
	}

	/**
	 * Removes the training institute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute that was removed
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public static TrainingInstitute remove(long trainingInstituteId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().remove(trainingInstituteId);
	}

	public static TrainingInstitute updateImpl(
		TrainingInstitute trainingInstitute) {

		return getPersistence().updateImpl(trainingInstitute);
	}

	/**
	 * Returns the training institute with the primary key or throws a <code>NoSuchTrainingInstituteException</code> if it could not be found.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public static TrainingInstitute findByPrimaryKey(long trainingInstituteId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchTrainingInstituteException {

		return getPersistence().findByPrimaryKey(trainingInstituteId);
	}

	/**
	 * Returns the training institute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute, or <code>null</code> if a training institute with the primary key could not be found
	 */
	public static TrainingInstitute fetchByPrimaryKey(
		long trainingInstituteId) {

		return getPersistence().fetchByPrimaryKey(trainingInstituteId);
	}

	/**
	 * Returns all the training institutes.
	 *
	 * @return the training institutes
	 */
	public static List<TrainingInstitute> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of training institutes
	 */
	public static List<TrainingInstitute> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training institutes
	 */
	public static List<TrainingInstitute> findAll(
		int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training institutes
	 */
	public static List<TrainingInstitute> findAll(
		int start, int end,
		OrderByComparator<TrainingInstitute> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the training institutes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of training institutes.
	 *
	 * @return the number of training institutes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TrainingInstitutePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TrainingInstitutePersistence, TrainingInstitutePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TrainingInstitutePersistence.class);

		ServiceTracker
			<TrainingInstitutePersistence, TrainingInstitutePersistence>
				serviceTracker =
					new ServiceTracker
						<TrainingInstitutePersistence,
						 TrainingInstitutePersistence>(
							 bundle.getBundleContext(),
							 TrainingInstitutePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}