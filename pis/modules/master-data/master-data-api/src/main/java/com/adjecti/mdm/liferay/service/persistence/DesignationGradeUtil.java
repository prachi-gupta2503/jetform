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

import com.adjecti.mdm.liferay.model.DesignationGrade;

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
 * The persistence utility for the designation grade service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DesignationGradePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationGradePersistence
 * @generated
 */
public class DesignationGradeUtil {

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
	public static void clearCache(DesignationGrade designationGrade) {
		getPersistence().clearCache(designationGrade);
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
	public static Map<Serializable, DesignationGrade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignationGrade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignationGrade update(DesignationGrade designationGrade) {
		return getPersistence().update(designationGrade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignationGrade update(
		DesignationGrade designationGrade, ServiceContext serviceContext) {

		return getPersistence().update(designationGrade, serviceContext);
	}

	/**
	 * Caches the designation grade in the entity cache if it is enabled.
	 *
	 * @param designationGrade the designation grade
	 */
	public static void cacheResult(DesignationGrade designationGrade) {
		getPersistence().cacheResult(designationGrade);
	}

	/**
	 * Caches the designation grades in the entity cache if it is enabled.
	 *
	 * @param designationGrades the designation grades
	 */
	public static void cacheResult(List<DesignationGrade> designationGrades) {
		getPersistence().cacheResult(designationGrades);
	}

	/**
	 * Creates a new designation grade with the primary key. Does not add the designation grade to the database.
	 *
	 * @param designationGradeId the primary key for the new designation grade
	 * @return the new designation grade
	 */
	public static DesignationGrade create(long designationGradeId) {
		return getPersistence().create(designationGradeId);
	}

	/**
	 * Removes the designation grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade that was removed
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	public static DesignationGrade remove(long designationGradeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationGradeException {

		return getPersistence().remove(designationGradeId);
	}

	public static DesignationGrade updateImpl(
		DesignationGrade designationGrade) {

		return getPersistence().updateImpl(designationGrade);
	}

	/**
	 * Returns the designation grade with the primary key or throws a <code>NoSuchDesignationGradeException</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	public static DesignationGrade findByPrimaryKey(long designationGradeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationGradeException {

		return getPersistence().findByPrimaryKey(designationGradeId);
	}

	/**
	 * Returns the designation grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade, or <code>null</code> if a designation grade with the primary key could not be found
	 */
	public static DesignationGrade fetchByPrimaryKey(long designationGradeId) {
		return getPersistence().fetchByPrimaryKey(designationGradeId);
	}

	/**
	 * Returns all the designation grades.
	 *
	 * @return the designation grades
	 */
	public static List<DesignationGrade> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @return the range of designation grades
	 */
	public static List<DesignationGrade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation grades
	 */
	public static List<DesignationGrade> findAll(
		int start, int end,
		OrderByComparator<DesignationGrade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation grades
	 */
	public static List<DesignationGrade> findAll(
		int start, int end,
		OrderByComparator<DesignationGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designation grades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designation grades.
	 *
	 * @return the number of designation grades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationGradePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationGradePersistence, DesignationGradePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignationGradePersistence.class);

		ServiceTracker<DesignationGradePersistence, DesignationGradePersistence>
			serviceTracker =
				new ServiceTracker
					<DesignationGradePersistence, DesignationGradePersistence>(
						bundle.getBundleContext(),
						DesignationGradePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}