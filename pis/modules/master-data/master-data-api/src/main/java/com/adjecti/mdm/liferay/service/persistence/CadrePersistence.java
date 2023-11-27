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

import com.adjecti.mdm.liferay.exception.NoSuchCadreException;
import com.adjecti.mdm.liferay.model.Cadre;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cadre service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreUtil
 * @generated
 */
@ProviderType
public interface CadrePersistence extends BasePersistence<Cadre> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CadreUtil} to access the cadre persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cadres where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching cadres
	 */
	public java.util.List<Cadre> findByCode(String code);

	/**
	 * Returns a range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of matching cadres
	 */
	public java.util.List<Cadre> findByCode(String code, int start, int end);

	/**
	 * Returns an ordered range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadres
	 */
	public java.util.List<Cadre> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadres
	 */
	public java.util.List<Cadre> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public Cadre findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Returns the first cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public Cadre fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns the last cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public Cadre findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Returns the last cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public Cadre fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns the cadres before and after the current cadre in the ordered set where code = &#63;.
	 *
	 * @param cadreId the primary key of the current cadre
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public Cadre[] findByCode_PrevAndNext(
			long cadreId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Removes all the cadres where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of cadres where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching cadres
	 */
	public int countByCode(String code);

	/**
	 * Returns all the cadres where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching cadres
	 */
	public java.util.List<Cadre> findByName(String name);

	/**
	 * Returns a range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of matching cadres
	 */
	public java.util.List<Cadre> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadres
	 */
	public java.util.List<Cadre> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadres
	 */
	public java.util.List<Cadre> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public Cadre findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Returns the first cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public Cadre fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns the last cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public Cadre findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Returns the last cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public Cadre fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns the cadres before and after the current cadre in the ordered set where name = &#63;.
	 *
	 * @param cadreId the primary key of the current cadre
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public Cadre[] findByName_PrevAndNext(
			long cadreId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Cadre>
				orderByComparator)
		throws NoSuchCadreException;

	/**
	 * Removes all the cadres where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of cadres where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching cadres
	 */
	public int countByName(String name);

	/**
	 * Caches the cadre in the entity cache if it is enabled.
	 *
	 * @param cadre the cadre
	 */
	public void cacheResult(Cadre cadre);

	/**
	 * Caches the cadres in the entity cache if it is enabled.
	 *
	 * @param cadres the cadres
	 */
	public void cacheResult(java.util.List<Cadre> cadres);

	/**
	 * Creates a new cadre with the primary key. Does not add the cadre to the database.
	 *
	 * @param cadreId the primary key for the new cadre
	 * @return the new cadre
	 */
	public Cadre create(long cadreId);

	/**
	 * Removes the cadre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre that was removed
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public Cadre remove(long cadreId) throws NoSuchCadreException;

	public Cadre updateImpl(Cadre cadre);

	/**
	 * Returns the cadre with the primary key or throws a <code>NoSuchCadreException</code> if it could not be found.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public Cadre findByPrimaryKey(long cadreId) throws NoSuchCadreException;

	/**
	 * Returns the cadre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre, or <code>null</code> if a cadre with the primary key could not be found
	 */
	public Cadre fetchByPrimaryKey(long cadreId);

	/**
	 * Returns all the cadres.
	 *
	 * @return the cadres
	 */
	public java.util.List<Cadre> findAll();

	/**
	 * Returns a range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of cadres
	 */
	public java.util.List<Cadre> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cadres
	 */
	public java.util.List<Cadre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cadres
	 */
	public java.util.List<Cadre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cadre>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cadres from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cadres.
	 *
	 * @return the number of cadres
	 */
	public int countAll();

}