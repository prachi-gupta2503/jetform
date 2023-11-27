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

import com.adjecti.mdm.liferay.model.DesignationClass;

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
 * The persistence utility for the designation class service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DesignationClassPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationClassPersistence
 * @generated
 */
public class DesignationClassUtil {

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
	public static void clearCache(DesignationClass designationClass) {
		getPersistence().clearCache(designationClass);
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
	public static Map<Serializable, DesignationClass> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignationClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignationClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignationClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignationClass> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignationClass update(DesignationClass designationClass) {
		return getPersistence().update(designationClass);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignationClass update(
		DesignationClass designationClass, ServiceContext serviceContext) {

		return getPersistence().update(designationClass, serviceContext);
	}

	/**
	 * Caches the designation class in the entity cache if it is enabled.
	 *
	 * @param designationClass the designation class
	 */
	public static void cacheResult(DesignationClass designationClass) {
		getPersistence().cacheResult(designationClass);
	}

	/**
	 * Caches the designation classes in the entity cache if it is enabled.
	 *
	 * @param designationClasses the designation classes
	 */
	public static void cacheResult(List<DesignationClass> designationClasses) {
		getPersistence().cacheResult(designationClasses);
	}

	/**
	 * Creates a new designation class with the primary key. Does not add the designation class to the database.
	 *
	 * @param designationClassId the primary key for the new designation class
	 * @return the new designation class
	 */
	public static DesignationClass create(long designationClassId) {
		return getPersistence().create(designationClassId);
	}

	/**
	 * Removes the designation class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class that was removed
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	public static DesignationClass remove(long designationClassId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationClassException {

		return getPersistence().remove(designationClassId);
	}

	public static DesignationClass updateImpl(
		DesignationClass designationClass) {

		return getPersistence().updateImpl(designationClass);
	}

	/**
	 * Returns the designation class with the primary key or throws a <code>NoSuchDesignationClassException</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	public static DesignationClass findByPrimaryKey(long designationClassId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationClassException {

		return getPersistence().findByPrimaryKey(designationClassId);
	}

	/**
	 * Returns the designation class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class, or <code>null</code> if a designation class with the primary key could not be found
	 */
	public static DesignationClass fetchByPrimaryKey(long designationClassId) {
		return getPersistence().fetchByPrimaryKey(designationClassId);
	}

	/**
	 * Returns all the designation classes.
	 *
	 * @return the designation classes
	 */
	public static List<DesignationClass> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @return the range of designation classes
	 */
	public static List<DesignationClass> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation classes
	 */
	public static List<DesignationClass> findAll(
		int start, int end,
		OrderByComparator<DesignationClass> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation classes
	 */
	public static List<DesignationClass> findAll(
		int start, int end,
		OrderByComparator<DesignationClass> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designation classes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designation classes.
	 *
	 * @return the number of designation classes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationClassPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationClassPersistence, DesignationClassPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignationClassPersistence.class);

		ServiceTracker<DesignationClassPersistence, DesignationClassPersistence>
			serviceTracker =
				new ServiceTracker
					<DesignationClassPersistence, DesignationClassPersistence>(
						bundle.getBundleContext(),
						DesignationClassPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}