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

import com.adjecti.mdm.liferay.model.Application;

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
 * The persistence utility for the application service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.ApplicationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationPersistence
 * @generated
 */
public class ApplicationUtil {

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
	public static void clearCache(Application application) {
		getPersistence().clearCache(application);
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
	public static Map<Serializable, Application> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Application> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Application> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Application> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Application> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Application update(Application application) {
		return getPersistence().update(application);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Application update(
		Application application, ServiceContext serviceContext) {

		return getPersistence().update(application, serviceContext);
	}

	/**
	 * Returns all the applications where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching applications
	 */
	public static List<Application> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the applications where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @return the range of matching applications
	 */
	public static List<Application> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the applications where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByCode(
		String code, int start, int end,
		OrderByComparator<Application> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the applications where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByCode(
		String code, int start, int end,
		OrderByComparator<Application> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first application in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByCode_First(
			String code, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first application in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByCode_First(
		String code, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByCode_Last(
			String code, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByCode_Last(
		String code, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the applications before and after the current application in the ordered set where code = &#63;.
	 *
	 * @param applicationId the primary key of the current application
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application
	 * @throws NoSuchApplicationException if a application with the primary key could not be found
	 */
	public static Application[] findByCode_PrevAndNext(
			long applicationId, String code,
			OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByCode_PrevAndNext(
			applicationId, code, orderByComparator);
	}

	/**
	 * Removes all the applications where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of applications where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching applications
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the applications where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching applications
	 */
	public static List<Application> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the applications where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @return the range of matching applications
	 */
	public static List<Application> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the applications where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByName(
		String name, int start, int end,
		OrderByComparator<Application> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the applications where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByName(
		String name, int start, int end,
		OrderByComparator<Application> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first application in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByName_First(
			String name, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first application in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByName_First(
		String name, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByName_Last(
			String name, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByName_Last(
		String name, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the applications before and after the current application in the ordered set where name = &#63;.
	 *
	 * @param applicationId the primary key of the current application
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application
	 * @throws NoSuchApplicationException if a application with the primary key could not be found
	 */
	public static Application[] findByName_PrevAndNext(
			long applicationId, String name,
			OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByName_PrevAndNext(
			applicationId, name, orderByComparator);
	}

	/**
	 * Removes all the applications where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of applications where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching applications
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the applications where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @return the matching applications
	 */
	public static List<Application> findByOemId(long oemId) {
		return getPersistence().findByOemId(oemId);
	}

	/**
	 * Returns a range of all the applications where oemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param oemId the oem ID
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @return the range of matching applications
	 */
	public static List<Application> findByOemId(
		long oemId, int start, int end) {

		return getPersistence().findByOemId(oemId, start, end);
	}

	/**
	 * Returns an ordered range of all the applications where oemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param oemId the oem ID
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByOemId(
		long oemId, int start, int end,
		OrderByComparator<Application> orderByComparator) {

		return getPersistence().findByOemId(
			oemId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the applications where oemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param oemId the oem ID
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching applications
	 */
	public static List<Application> findByOemId(
		long oemId, int start, int end,
		OrderByComparator<Application> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOemId(
			oemId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first application in the ordered set where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByOemId_First(
			long oemId, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByOemId_First(oemId, orderByComparator);
	}

	/**
	 * Returns the first application in the ordered set where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByOemId_First(
		long oemId, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByOemId_First(oemId, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application
	 * @throws NoSuchApplicationException if a matching application could not be found
	 */
	public static Application findByOemId_Last(
			long oemId, OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByOemId_Last(oemId, orderByComparator);
	}

	/**
	 * Returns the last application in the ordered set where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application, or <code>null</code> if a matching application could not be found
	 */
	public static Application fetchByOemId_Last(
		long oemId, OrderByComparator<Application> orderByComparator) {

		return getPersistence().fetchByOemId_Last(oemId, orderByComparator);
	}

	/**
	 * Returns the applications before and after the current application in the ordered set where oemId = &#63;.
	 *
	 * @param applicationId the primary key of the current application
	 * @param oemId the oem ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application
	 * @throws NoSuchApplicationException if a application with the primary key could not be found
	 */
	public static Application[] findByOemId_PrevAndNext(
			long applicationId, long oemId,
			OrderByComparator<Application> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByOemId_PrevAndNext(
			applicationId, oemId, orderByComparator);
	}

	/**
	 * Removes all the applications where oemId = &#63; from the database.
	 *
	 * @param oemId the oem ID
	 */
	public static void removeByOemId(long oemId) {
		getPersistence().removeByOemId(oemId);
	}

	/**
	 * Returns the number of applications where oemId = &#63;.
	 *
	 * @param oemId the oem ID
	 * @return the number of matching applications
	 */
	public static int countByOemId(long oemId) {
		return getPersistence().countByOemId(oemId);
	}

	/**
	 * Caches the application in the entity cache if it is enabled.
	 *
	 * @param application the application
	 */
	public static void cacheResult(Application application) {
		getPersistence().cacheResult(application);
	}

	/**
	 * Caches the applications in the entity cache if it is enabled.
	 *
	 * @param applications the applications
	 */
	public static void cacheResult(List<Application> applications) {
		getPersistence().cacheResult(applications);
	}

	/**
	 * Creates a new application with the primary key. Does not add the application to the database.
	 *
	 * @param applicationId the primary key for the new application
	 * @return the new application
	 */
	public static Application create(long applicationId) {
		return getPersistence().create(applicationId);
	}

	/**
	 * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationId the primary key of the application
	 * @return the application that was removed
	 * @throws NoSuchApplicationException if a application with the primary key could not be found
	 */
	public static Application remove(long applicationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().remove(applicationId);
	}

	public static Application updateImpl(Application application) {
		return getPersistence().updateImpl(application);
	}

	/**
	 * Returns the application with the primary key or throws a <code>NoSuchApplicationException</code> if it could not be found.
	 *
	 * @param applicationId the primary key of the application
	 * @return the application
	 * @throws NoSuchApplicationException if a application with the primary key could not be found
	 */
	public static Application findByPrimaryKey(long applicationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchApplicationException {

		return getPersistence().findByPrimaryKey(applicationId);
	}

	/**
	 * Returns the application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationId the primary key of the application
	 * @return the application, or <code>null</code> if a application with the primary key could not be found
	 */
	public static Application fetchByPrimaryKey(long applicationId) {
		return getPersistence().fetchByPrimaryKey(applicationId);
	}

	/**
	 * Returns all the applications.
	 *
	 * @return the applications
	 */
	public static List<Application> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @return the range of applications
	 */
	public static List<Application> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of applications
	 */
	public static List<Application> findAll(
		int start, int end, OrderByComparator<Application> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of applications
	 * @param end the upper bound of the range of applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of applications
	 */
	public static List<Application> findAll(
		int start, int end, OrderByComparator<Application> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the applications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of applications.
	 *
	 * @return the number of applications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ApplicationPersistence, ApplicationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ApplicationPersistence.class);

		ServiceTracker<ApplicationPersistence, ApplicationPersistence>
			serviceTracker =
				new ServiceTracker
					<ApplicationPersistence, ApplicationPersistence>(
						bundle.getBundleContext(), ApplicationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}