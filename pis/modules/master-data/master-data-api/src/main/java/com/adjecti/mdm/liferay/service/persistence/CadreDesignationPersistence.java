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

import com.adjecti.mdm.liferay.exception.NoSuchCadreDesignationException;
import com.adjecti.mdm.liferay.model.CadreDesignation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cadre designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreDesignationUtil
 * @generated
 */
@ProviderType
public interface CadreDesignationPersistence
	extends BasePersistence<CadreDesignation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CadreDesignationUtil} to access the cadre designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByCadreId(long cadreId);

	/**
	 * Returns a range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end);

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public CadreDesignation findByCadreId_First(
			long cadreId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public CadreDesignation fetchByCadreId_First(
		long cadreId,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public CadreDesignation findByCadreId_Last(
			long cadreId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public CadreDesignation fetchByCadreId_Last(
		long cadreId,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public CadreDesignation[] findByCadreId_PrevAndNext(
			long cadreDesignationId, long cadreId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Removes all the cadre designations where cadreId = &#63; from the database.
	 *
	 * @param cadreId the cadre ID
	 */
	public void removeByCadreId(long cadreId);

	/**
	 * Returns the number of cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the number of matching cadre designations
	 */
	public int countByCadreId(long cadreId);

	/**
	 * Returns all the cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByDesignationId(
		long designationId);

	/**
	 * Returns a range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end);

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	public java.util.List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public CadreDesignation findByDesignationId_First(
			long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public CadreDesignation fetchByDesignationId_First(
		long designationId,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public CadreDesignation findByDesignationId_Last(
			long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public CadreDesignation fetchByDesignationId_Last(
		long designationId,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public CadreDesignation[] findByDesignationId_PrevAndNext(
			long cadreDesignationId, long designationId,
			com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
				orderByComparator)
		throws NoSuchCadreDesignationException;

	/**
	 * Removes all the cadre designations where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public void removeByDesignationId(long designationId);

	/**
	 * Returns the number of cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching cadre designations
	 */
	public int countByDesignationId(long designationId);

	/**
	 * Caches the cadre designation in the entity cache if it is enabled.
	 *
	 * @param cadreDesignation the cadre designation
	 */
	public void cacheResult(CadreDesignation cadreDesignation);

	/**
	 * Caches the cadre designations in the entity cache if it is enabled.
	 *
	 * @param cadreDesignations the cadre designations
	 */
	public void cacheResult(java.util.List<CadreDesignation> cadreDesignations);

	/**
	 * Creates a new cadre designation with the primary key. Does not add the cadre designation to the database.
	 *
	 * @param cadreDesignationId the primary key for the new cadre designation
	 * @return the new cadre designation
	 */
	public CadreDesignation create(long cadreDesignationId);

	/**
	 * Removes the cadre designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation that was removed
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public CadreDesignation remove(long cadreDesignationId)
		throws NoSuchCadreDesignationException;

	public CadreDesignation updateImpl(CadreDesignation cadreDesignation);

	/**
	 * Returns the cadre designation with the primary key or throws a <code>NoSuchCadreDesignationException</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public CadreDesignation findByPrimaryKey(long cadreDesignationId)
		throws NoSuchCadreDesignationException;

	/**
	 * Returns the cadre designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation, or <code>null</code> if a cadre designation with the primary key could not be found
	 */
	public CadreDesignation fetchByPrimaryKey(long cadreDesignationId);

	/**
	 * Returns all the cadre designations.
	 *
	 * @return the cadre designations
	 */
	public java.util.List<CadreDesignation> findAll();

	/**
	 * Returns a range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of cadre designations
	 */
	public java.util.List<CadreDesignation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cadre designations
	 */
	public java.util.List<CadreDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cadre designations
	 */
	public java.util.List<CadreDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CadreDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cadre designations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cadre designations.
	 *
	 * @return the number of cadre designations
	 */
	public int countAll();

}