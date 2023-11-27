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

import com.adjecti.mdm.liferay.model.SubjectOfQualification;

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
 * The persistence utility for the subject of qualification service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.SubjectOfQualificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfQualificationPersistence
 * @generated
 */
public class SubjectOfQualificationUtil {

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
	public static void clearCache(
		SubjectOfQualification subjectOfQualification) {

		getPersistence().clearCache(subjectOfQualification);
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
	public static Map<Serializable, SubjectOfQualification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubjectOfQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubjectOfQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubjectOfQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubjectOfQualification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubjectOfQualification update(
		SubjectOfQualification subjectOfQualification) {

		return getPersistence().update(subjectOfQualification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubjectOfQualification update(
		SubjectOfQualification subjectOfQualification,
		ServiceContext serviceContext) {

		return getPersistence().update(subjectOfQualification, serviceContext);
	}

	/**
	 * Caches the subject of qualification in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualification the subject of qualification
	 */
	public static void cacheResult(
		SubjectOfQualification subjectOfQualification) {

		getPersistence().cacheResult(subjectOfQualification);
	}

	/**
	 * Caches the subject of qualifications in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualifications the subject of qualifications
	 */
	public static void cacheResult(
		List<SubjectOfQualification> subjectOfQualifications) {

		getPersistence().cacheResult(subjectOfQualifications);
	}

	/**
	 * Creates a new subject of qualification with the primary key. Does not add the subject of qualification to the database.
	 *
	 * @param subjectOfQualificationId the primary key for the new subject of qualification
	 * @return the new subject of qualification
	 */
	public static SubjectOfQualification create(long subjectOfQualificationId) {
		return getPersistence().create(subjectOfQualificationId);
	}

	/**
	 * Removes the subject of qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification that was removed
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	public static SubjectOfQualification remove(long subjectOfQualificationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchSubjectOfQualificationException {

		return getPersistence().remove(subjectOfQualificationId);
	}

	public static SubjectOfQualification updateImpl(
		SubjectOfQualification subjectOfQualification) {

		return getPersistence().updateImpl(subjectOfQualification);
	}

	/**
	 * Returns the subject of qualification with the primary key or throws a <code>NoSuchSubjectOfQualificationException</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	public static SubjectOfQualification findByPrimaryKey(
			long subjectOfQualificationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchSubjectOfQualificationException {

		return getPersistence().findByPrimaryKey(subjectOfQualificationId);
	}

	/**
	 * Returns the subject of qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification, or <code>null</code> if a subject of qualification with the primary key could not be found
	 */
	public static SubjectOfQualification fetchByPrimaryKey(
		long subjectOfQualificationId) {

		return getPersistence().fetchByPrimaryKey(subjectOfQualificationId);
	}

	/**
	 * Returns all the subject of qualifications.
	 *
	 * @return the subject of qualifications
	 */
	public static List<SubjectOfQualification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @return the range of subject of qualifications
	 */
	public static List<SubjectOfQualification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of qualifications
	 */
	public static List<SubjectOfQualification> findAll(
		int start, int end,
		OrderByComparator<SubjectOfQualification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of qualifications
	 */
	public static List<SubjectOfQualification> findAll(
		int start, int end,
		OrderByComparator<SubjectOfQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the subject of qualifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of subject of qualifications.
	 *
	 * @return the number of subject of qualifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubjectOfQualificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SubjectOfQualificationPersistence, SubjectOfQualificationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SubjectOfQualificationPersistence.class);

		ServiceTracker
			<SubjectOfQualificationPersistence,
			 SubjectOfQualificationPersistence> serviceTracker =
				new ServiceTracker
					<SubjectOfQualificationPersistence,
					 SubjectOfQualificationPersistence>(
						 bundle.getBundleContext(),
						 SubjectOfQualificationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}