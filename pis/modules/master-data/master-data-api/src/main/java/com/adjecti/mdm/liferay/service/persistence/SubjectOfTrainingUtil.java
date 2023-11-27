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

import com.adjecti.mdm.liferay.model.SubjectOfTraining;

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
 * The persistence utility for the subject of training service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.SubjectOfTrainingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfTrainingPersistence
 * @generated
 */
public class SubjectOfTrainingUtil {

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
	public static void clearCache(SubjectOfTraining subjectOfTraining) {
		getPersistence().clearCache(subjectOfTraining);
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
	public static Map<Serializable, SubjectOfTraining> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubjectOfTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubjectOfTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubjectOfTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubjectOfTraining> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubjectOfTraining update(
		SubjectOfTraining subjectOfTraining) {

		return getPersistence().update(subjectOfTraining);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubjectOfTraining update(
		SubjectOfTraining subjectOfTraining, ServiceContext serviceContext) {

		return getPersistence().update(subjectOfTraining, serviceContext);
	}

	/**
	 * Caches the subject of training in the entity cache if it is enabled.
	 *
	 * @param subjectOfTraining the subject of training
	 */
	public static void cacheResult(SubjectOfTraining subjectOfTraining) {
		getPersistence().cacheResult(subjectOfTraining);
	}

	/**
	 * Caches the subject of trainings in the entity cache if it is enabled.
	 *
	 * @param subjectOfTrainings the subject of trainings
	 */
	public static void cacheResult(List<SubjectOfTraining> subjectOfTrainings) {
		getPersistence().cacheResult(subjectOfTrainings);
	}

	/**
	 * Creates a new subject of training with the primary key. Does not add the subject of training to the database.
	 *
	 * @param subjectOfTrainingId the primary key for the new subject of training
	 * @return the new subject of training
	 */
	public static SubjectOfTraining create(long subjectOfTrainingId) {
		return getPersistence().create(subjectOfTrainingId);
	}

	/**
	 * Removes the subject of training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training that was removed
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	public static SubjectOfTraining remove(long subjectOfTrainingId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchSubjectOfTrainingException {

		return getPersistence().remove(subjectOfTrainingId);
	}

	public static SubjectOfTraining updateImpl(
		SubjectOfTraining subjectOfTraining) {

		return getPersistence().updateImpl(subjectOfTraining);
	}

	/**
	 * Returns the subject of training with the primary key or throws a <code>NoSuchSubjectOfTrainingException</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	public static SubjectOfTraining findByPrimaryKey(long subjectOfTrainingId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchSubjectOfTrainingException {

		return getPersistence().findByPrimaryKey(subjectOfTrainingId);
	}

	/**
	 * Returns the subject of training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training, or <code>null</code> if a subject of training with the primary key could not be found
	 */
	public static SubjectOfTraining fetchByPrimaryKey(
		long subjectOfTrainingId) {

		return getPersistence().fetchByPrimaryKey(subjectOfTrainingId);
	}

	/**
	 * Returns all the subject of trainings.
	 *
	 * @return the subject of trainings
	 */
	public static List<SubjectOfTraining> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @return the range of subject of trainings
	 */
	public static List<SubjectOfTraining> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of trainings
	 */
	public static List<SubjectOfTraining> findAll(
		int start, int end,
		OrderByComparator<SubjectOfTraining> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of trainings
	 */
	public static List<SubjectOfTraining> findAll(
		int start, int end,
		OrderByComparator<SubjectOfTraining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the subject of trainings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of subject of trainings.
	 *
	 * @return the number of subject of trainings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubjectOfTrainingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SubjectOfTrainingPersistence, SubjectOfTrainingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SubjectOfTrainingPersistence.class);

		ServiceTracker
			<SubjectOfTrainingPersistence, SubjectOfTrainingPersistence>
				serviceTracker =
					new ServiceTracker
						<SubjectOfTrainingPersistence,
						 SubjectOfTrainingPersistence>(
							 bundle.getBundleContext(),
							 SubjectOfTrainingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}