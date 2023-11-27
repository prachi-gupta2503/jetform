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

import com.adjecti.mdm.liferay.model.OrganizationType;

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
 * The persistence utility for the organization type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OrganizationTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationTypePersistence
 * @generated
 */
public class OrganizationTypeUtil {

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
	public static void clearCache(OrganizationType organizationType) {
		getPersistence().clearCache(organizationType);
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
	public static Map<Serializable, OrganizationType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationType update(OrganizationType organizationType) {
		return getPersistence().update(organizationType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationType update(
		OrganizationType organizationType, ServiceContext serviceContext) {

		return getPersistence().update(organizationType, serviceContext);
	}

	/**
	 * Returns all the organization types where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching organization types
	 */
	public static List<OrganizationType> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the organization types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @return the range of matching organization types
	 */
	public static List<OrganizationType> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the organization types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization types
	 */
	public static List<OrganizationType> findByCode(
		String code, int start, int end,
		OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization types
	 */
	public static List<OrganizationType> findByCode(
		String code, int start, int end,
		OrderByComparator<OrganizationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public static OrganizationType findByCode_First(
			String code, OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public static OrganizationType fetchByCode_First(
		String code, OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public static OrganizationType findByCode_Last(
			String code, OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public static OrganizationType fetchByCode_Last(
		String code, OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the organization types before and after the current organization type in the ordered set where code = &#63;.
	 *
	 * @param organizationTypeId the primary key of the current organization type
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public static OrganizationType[] findByCode_PrevAndNext(
			long organizationTypeId, String code,
			OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByCode_PrevAndNext(
			organizationTypeId, code, orderByComparator);
	}

	/**
	 * Removes all the organization types where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of organization types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching organization types
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the organization types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organization types
	 */
	public static List<OrganizationType> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the organization types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @return the range of matching organization types
	 */
	public static List<OrganizationType> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the organization types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization types
	 */
	public static List<OrganizationType> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization types
	 */
	public static List<OrganizationType> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public static OrganizationType findByName_First(
			String name, OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public static OrganizationType fetchByName_First(
		String name, OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public static OrganizationType findByName_Last(
			String name, OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public static OrganizationType fetchByName_Last(
		String name, OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the organization types before and after the current organization type in the ordered set where name = &#63;.
	 *
	 * @param organizationTypeId the primary key of the current organization type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public static OrganizationType[] findByName_PrevAndNext(
			long organizationTypeId, String name,
			OrderByComparator<OrganizationType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByName_PrevAndNext(
			organizationTypeId, name, orderByComparator);
	}

	/**
	 * Removes all the organization types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of organization types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organization types
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the organization type in the entity cache if it is enabled.
	 *
	 * @param organizationType the organization type
	 */
	public static void cacheResult(OrganizationType organizationType) {
		getPersistence().cacheResult(organizationType);
	}

	/**
	 * Caches the organization types in the entity cache if it is enabled.
	 *
	 * @param organizationTypes the organization types
	 */
	public static void cacheResult(List<OrganizationType> organizationTypes) {
		getPersistence().cacheResult(organizationTypes);
	}

	/**
	 * Creates a new organization type with the primary key. Does not add the organization type to the database.
	 *
	 * @param organizationTypeId the primary key for the new organization type
	 * @return the new organization type
	 */
	public static OrganizationType create(long organizationTypeId) {
		return getPersistence().create(organizationTypeId);
	}

	/**
	 * Removes the organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type that was removed
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public static OrganizationType remove(long organizationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().remove(organizationTypeId);
	}

	public static OrganizationType updateImpl(
		OrganizationType organizationType) {

		return getPersistence().updateImpl(organizationType);
	}

	/**
	 * Returns the organization type with the primary key or throws a <code>NoSuchOrganizationTypeException</code> if it could not be found.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public static OrganizationType findByPrimaryKey(long organizationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationTypeException {

		return getPersistence().findByPrimaryKey(organizationTypeId);
	}

	/**
	 * Returns the organization type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type, or <code>null</code> if a organization type with the primary key could not be found
	 */
	public static OrganizationType fetchByPrimaryKey(long organizationTypeId) {
		return getPersistence().fetchByPrimaryKey(organizationTypeId);
	}

	/**
	 * Returns all the organization types.
	 *
	 * @return the organization types
	 */
	public static List<OrganizationType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @return the range of organization types
	 */
	public static List<OrganizationType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization types
	 */
	public static List<OrganizationType> findAll(
		int start, int end,
		OrderByComparator<OrganizationType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization types
	 */
	public static List<OrganizationType> findAll(
		int start, int end,
		OrderByComparator<OrganizationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization types.
	 *
	 * @return the number of organization types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationTypePersistence, OrganizationTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationTypePersistence.class);

		ServiceTracker<OrganizationTypePersistence, OrganizationTypePersistence>
			serviceTracker =
				new ServiceTracker
					<OrganizationTypePersistence, OrganizationTypePersistence>(
						bundle.getBundleContext(),
						OrganizationTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}