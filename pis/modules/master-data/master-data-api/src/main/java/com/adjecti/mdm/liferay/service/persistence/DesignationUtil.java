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

import com.adjecti.mdm.liferay.model.Designation;

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
 * The persistence utility for the designation service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DesignationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationPersistence
 * @generated
 */
public class DesignationUtil {

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
	public static void clearCache(Designation designation) {
		getPersistence().clearCache(designation);
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
	public static Map<Serializable, Designation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Designation update(Designation designation) {
		return getPersistence().update(designation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Designation update(
		Designation designation, ServiceContext serviceContext) {

		return getPersistence().update(designation, serviceContext);
	}

	/**
	 * Returns the designation where code = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the designation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the designation that was removed
	 */
	public static Designation removeByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of designations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designations
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the matching designations
	 */
	public static List<Designation> findByName(String name_En) {
		return getPersistence().findByName(name_En);
	}

	/**
	 * Returns a range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByName(
		String name_En, int start, int end) {

		return getPersistence().findByName(name_En, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByName(
		String name_En, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByName(
			name_En, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByName(
		String name_En, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name_En, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByName_First(
			String name_En, OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByName_First(name_En, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByName_First(
		String name_En, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByName_First(name_En, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByName_Last(
			String name_En, OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByName_Last(name_En, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByName_Last(
		String name_En, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByName_Last(name_En, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where name_En = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByName_PrevAndNext(
			long designationId, String name_En,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByName_PrevAndNext(
			designationId, name_En, orderByComparator);
	}

	/**
	 * Removes all the designations where name_En = &#63; from the database.
	 *
	 * @param name_En the name_ en
	 */
	public static void removeByName(String name_En) {
		getPersistence().removeByName(name_En);
	}

	/**
	 * Returns the number of designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the number of matching designations
	 */
	public static int countByName(String name_En) {
		return getPersistence().countByName(name_En);
	}

	/**
	 * Returns all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	public static List<Designation> findByGradeId(
		long gradeId, boolean deleted) {

		return getPersistence().findByGradeId(gradeId, deleted);
	}

	/**
	 * Returns a range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end) {

		return getPersistence().findByGradeId(gradeId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByGradeId(
			gradeId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeId(
			gradeId, deleted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByGradeId_First(
			long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByGradeId_First(
			gradeId, deleted, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByGradeId_First(
		long gradeId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByGradeId_First(
			gradeId, deleted, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByGradeId_Last(
			long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByGradeId_Last(
			gradeId, deleted, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByGradeId_Last(
		long gradeId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByGradeId_Last(
			gradeId, deleted, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByGradeId_PrevAndNext(
			long designationId, long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByGradeId_PrevAndNext(
			designationId, gradeId, deleted, orderByComparator);
	}

	/**
	 * Removes all the designations where gradeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 */
	public static void removeByGradeId(long gradeId, boolean deleted) {
		getPersistence().removeByGradeId(gradeId, deleted);
	}

	/**
	 * Returns the number of designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	public static int countByGradeId(long gradeId, boolean deleted) {
		return getPersistence().countByGradeId(gradeId, deleted);
	}

	/**
	 * Returns all the designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationClassId(
		long designationClassId) {

		return getPersistence().findByDesignationClassId(designationClassId);
	}

	/**
	 * Returns a range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end) {

		return getPersistence().findByDesignationClassId(
			designationClassId, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationClassId(
			designationClassId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationClassId(
			designationClassId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationClassId_First(
			long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationClassId_First(
			designationClassId, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationClassId_First(
		long designationClassId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationClassId_First(
			designationClassId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationClassId_Last(
			long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationClassId_Last(
			designationClassId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationClassId_Last(
		long designationClassId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationClassId_Last(
			designationClassId, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByDesignationClassId_PrevAndNext(
			long designationId, long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationClassId_PrevAndNext(
			designationId, designationClassId, orderByComparator);
	}

	/**
	 * Removes all the designations where designationClassId = &#63; from the database.
	 *
	 * @param designationClassId the designation class ID
	 */
	public static void removeByDesignationClassId(long designationClassId) {
		getPersistence().removeByDesignationClassId(designationClassId);
	}

	/**
	 * Returns the number of designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the number of matching designations
	 */
	public static int countByDesignationClassId(long designationClassId) {
		return getPersistence().countByDesignationClassId(designationClassId);
	}

	/**
	 * Returns all the designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationGroupId(
		long designationGroupId) {

		return getPersistence().findByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns a range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroupId_First(
			long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupId_First(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroupId_First(
		long designationGroupId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroupId_First(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroupId_Last(
			long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupId_Last(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroupId_Last(
		long designationGroupId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroupId_Last(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByDesignationGroupId_PrevAndNext(
			long designationId, long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupId_PrevAndNext(
			designationId, designationGroupId, orderByComparator);
	}

	/**
	 * Removes all the designations where designationGroupId = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 */
	public static void removeByDesignationGroupId(long designationGroupId) {
		getPersistence().removeByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns the number of designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the number of matching designations
	 */
	public static int countByDesignationGroupId(long designationGroupId) {
		return getPersistence().countByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		return getPersistence().findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted);
	}

	/**
	 * Returns a range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end) {

		return getPersistence().findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroupIdAndDeleted_First(
			long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupIdAndDeleted_First(
			designationGroupId, deleted, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroupIdAndDeleted_First(
		long designationGroupId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroupIdAndDeleted_First(
			designationGroupId, deleted, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroupIdAndDeleted_Last(
			long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupIdAndDeleted_Last(
			designationGroupId, deleted, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroupIdAndDeleted_Last(
		long designationGroupId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroupIdAndDeleted_Last(
			designationGroupId, deleted, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByDesignationGroupIdAndDeleted_PrevAndNext(
			long designationId, long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroupIdAndDeleted_PrevAndNext(
			designationId, designationGroupId, deleted, orderByComparator);
	}

	/**
	 * Removes all the designations where designationGroupId = &#63; and deleted = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 */
	public static void removeByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		getPersistence().removeByDesignationGroupIdAndDeleted(
			designationGroupId, deleted);
	}

	/**
	 * Returns the number of designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	public static int countByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		return getPersistence().countByDesignationGroupIdAndDeleted(
			designationGroupId, deleted);
	}

	/**
	 * Returns all the designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching designations
	 */
	public static List<Designation> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByStatus(
		int status, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByStatus(
		int status, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByStatus_First(
			int status, OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByStatus_First(
		int status, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByStatus_Last(
			int status, OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByStatus_Last(
		int status, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByStatus_PrevAndNext(
			long designationId, int status,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByStatus_PrevAndNext(
			designationId, status, orderByComparator);
	}

	/**
	 * Removes all the designations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching designations
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationGroup(
		String designationGroup, int status) {

		return getPersistence().findByDesignationGroup(
			designationGroup, status);
	}

	/**
	 * Returns a range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public static List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end) {

		return getPersistence().findByDesignationGroup(
			designationGroup, status, start, end);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationGroup(
			designationGroup, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public static List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationGroup(
			designationGroup, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroup_First(
			String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroup_First(
			designationGroup, status, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroup_First(
		String designationGroup, int status,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroup_First(
			designationGroup, status, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationGroup_Last(
			String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroup_Last(
			designationGroup, status, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationGroup_Last(
		String designationGroup, int status,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationGroup_Last(
			designationGroup, status, orderByComparator);
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation[] findByDesignationGroup_PrevAndNext(
			long designationId, String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationGroup_PrevAndNext(
			designationId, designationGroup, status, orderByComparator);
	}

	/**
	 * Removes all the designations where designationGroup = &#63; and status = &#63; from the database.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 */
	public static void removeByDesignationGroup(
		String designationGroup, int status) {

		getPersistence().removeByDesignationGroup(designationGroup, status);
	}

	/**
	 * Returns the number of designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the number of matching designations
	 */
	public static int countByDesignationGroup(
		String designationGroup, int status) {

		return getPersistence().countByDesignationGroup(
			designationGroup, status);
	}

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	public static void cacheResult(Designation designation) {
		getPersistence().cacheResult(designation);
	}

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	public static void cacheResult(List<Designation> designations) {
		getPersistence().cacheResult(designations);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	public static Designation create(long designationId) {
		return getPersistence().create(designationId);
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation remove(long designationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().remove(designationId);
	}

	public static Designation updateImpl(Designation designation) {
		return getPersistence().updateImpl(designation);
	}

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation findByPrimaryKey(long designationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDesignationException {

		return getPersistence().findByPrimaryKey(designationId);
	}

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	public static Designation fetchByPrimaryKey(long designationId) {
		return getPersistence().fetchByPrimaryKey(designationId);
	}

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	public static List<Designation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	public static List<Designation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designations
	 */
	public static List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designations
	 */
	public static List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationPersistence, DesignationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DesignationPersistence.class);

		ServiceTracker<DesignationPersistence, DesignationPersistence>
			serviceTracker =
				new ServiceTracker
					<DesignationPersistence, DesignationPersistence>(
						bundle.getBundleContext(), DesignationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}