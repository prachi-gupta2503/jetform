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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationTypeException;
import com.adjecti.mdm.liferay.model.OrganizationType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationTypeUtil
 * @generated
 */
@ProviderType
public interface OrganizationTypePersistence
	extends BasePersistence<OrganizationType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationTypeUtil} to access the organization type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organization types where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching organization types
	 */
	public java.util.List<OrganizationType> findByCode(String code);

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
	public java.util.List<OrganizationType> findByCode(
		String code, int start, int end);

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
	public java.util.List<OrganizationType> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

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
	public java.util.List<OrganizationType> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public OrganizationType findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Returns the first organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public OrganizationType fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

	/**
	 * Returns the last organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public OrganizationType findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Returns the last organization type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public OrganizationType fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

	/**
	 * Returns the organization types before and after the current organization type in the ordered set where code = &#63;.
	 *
	 * @param organizationTypeId the primary key of the current organization type
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public OrganizationType[] findByCode_PrevAndNext(
			long organizationTypeId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Removes all the organization types where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of organization types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching organization types
	 */
	public int countByCode(String code);

	/**
	 * Returns all the organization types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organization types
	 */
	public java.util.List<OrganizationType> findByName(String name);

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
	public java.util.List<OrganizationType> findByName(
		String name, int start, int end);

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
	public java.util.List<OrganizationType> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

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
	public java.util.List<OrganizationType> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public OrganizationType findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Returns the first organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public OrganizationType fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

	/**
	 * Returns the last organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type
	 * @throws NoSuchOrganizationTypeException if a matching organization type could not be found
	 */
	public OrganizationType findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Returns the last organization type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization type, or <code>null</code> if a matching organization type could not be found
	 */
	public OrganizationType fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

	/**
	 * Returns the organization types before and after the current organization type in the ordered set where name = &#63;.
	 *
	 * @param organizationTypeId the primary key of the current organization type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public OrganizationType[] findByName_PrevAndNext(
			long organizationTypeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
				orderByComparator)
		throws NoSuchOrganizationTypeException;

	/**
	 * Removes all the organization types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of organization types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organization types
	 */
	public int countByName(String name);

	/**
	 * Caches the organization type in the entity cache if it is enabled.
	 *
	 * @param organizationType the organization type
	 */
	public void cacheResult(OrganizationType organizationType);

	/**
	 * Caches the organization types in the entity cache if it is enabled.
	 *
	 * @param organizationTypes the organization types
	 */
	public void cacheResult(java.util.List<OrganizationType> organizationTypes);

	/**
	 * Creates a new organization type with the primary key. Does not add the organization type to the database.
	 *
	 * @param organizationTypeId the primary key for the new organization type
	 * @return the new organization type
	 */
	public OrganizationType create(long organizationTypeId);

	/**
	 * Removes the organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type that was removed
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public OrganizationType remove(long organizationTypeId)
		throws NoSuchOrganizationTypeException;

	public OrganizationType updateImpl(OrganizationType organizationType);

	/**
	 * Returns the organization type with the primary key or throws a <code>NoSuchOrganizationTypeException</code> if it could not be found.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type
	 * @throws NoSuchOrganizationTypeException if a organization type with the primary key could not be found
	 */
	public OrganizationType findByPrimaryKey(long organizationTypeId)
		throws NoSuchOrganizationTypeException;

	/**
	 * Returns the organization type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type, or <code>null</code> if a organization type with the primary key could not be found
	 */
	public OrganizationType fetchByPrimaryKey(long organizationTypeId);

	/**
	 * Returns all the organization types.
	 *
	 * @return the organization types
	 */
	public java.util.List<OrganizationType> findAll();

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
	public java.util.List<OrganizationType> findAll(int start, int end);

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
	public java.util.List<OrganizationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator);

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
	public java.util.List<OrganizationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization types.
	 *
	 * @return the number of organization types
	 */
	public int countAll();

}