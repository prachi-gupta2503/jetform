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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationScopeException;
import com.adjecti.mdm.liferay.model.DesignationScope;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation scope service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationScopeUtil
 * @generated
 */
@ProviderType
public interface DesignationScopePersistence
	extends BasePersistence<DesignationScope> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationScopeUtil} to access the designation scope persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching designation scopes
	 */
	public java.util.List<DesignationScope> findByDesignationId(
		long designationId);

	/**
	 * Returns a range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of matching designation scopes
	 */
	public java.util.List<DesignationScope> findByDesignationId(
		long designationId, int start, int end);

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation scopes
	 */
	public java.util.List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation scopes
	 */
	public java.util.List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	public DesignationScope findByDesignationId_First(
			long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
				orderByComparator)
		throws NoSuchDesignationScopeException;

	/**
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	public DesignationScope fetchByDesignationId_First(
		long designationId,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator);

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	public DesignationScope findByDesignationId_Last(
			long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
				orderByComparator)
		throws NoSuchDesignationScopeException;

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	public DesignationScope fetchByDesignationId_Last(
		long designationId,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator);

	/**
	 * Returns the designation scopes before and after the current designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationScopePK the primary key of the current designation scope
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public DesignationScope[] findByDesignationId_PrevAndNext(
			DesignationScopePK designationScopePK, long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
				orderByComparator)
		throws NoSuchDesignationScopeException;

	/**
	 * Removes all the designation scopes where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public void removeByDesignationId(long designationId);

	/**
	 * Returns the number of designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching designation scopes
	 */
	public int countByDesignationId(long designationId);

	/**
	 * Caches the designation scope in the entity cache if it is enabled.
	 *
	 * @param designationScope the designation scope
	 */
	public void cacheResult(DesignationScope designationScope);

	/**
	 * Caches the designation scopes in the entity cache if it is enabled.
	 *
	 * @param designationScopes the designation scopes
	 */
	public void cacheResult(java.util.List<DesignationScope> designationScopes);

	/**
	 * Creates a new designation scope with the primary key. Does not add the designation scope to the database.
	 *
	 * @param designationScopePK the primary key for the new designation scope
	 * @return the new designation scope
	 */
	public DesignationScope create(DesignationScopePK designationScopePK);

	/**
	 * Removes the designation scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope that was removed
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public DesignationScope remove(DesignationScopePK designationScopePK)
		throws NoSuchDesignationScopeException;

	public DesignationScope updateImpl(DesignationScope designationScope);

	/**
	 * Returns the designation scope with the primary key or throws a <code>NoSuchDesignationScopeException</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public DesignationScope findByPrimaryKey(
			DesignationScopePK designationScopePK)
		throws NoSuchDesignationScopeException;

	/**
	 * Returns the designation scope with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope, or <code>null</code> if a designation scope with the primary key could not be found
	 */
	public DesignationScope fetchByPrimaryKey(
		DesignationScopePK designationScopePK);

	/**
	 * Returns all the designation scopes.
	 *
	 * @return the designation scopes
	 */
	public java.util.List<DesignationScope> findAll();

	/**
	 * Returns a range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of designation scopes
	 */
	public java.util.List<DesignationScope> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation scopes
	 */
	public java.util.List<DesignationScope> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation scopes
	 */
	public java.util.List<DesignationScope> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationScope>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation scopes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation scopes.
	 *
	 * @return the number of designation scopes
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}