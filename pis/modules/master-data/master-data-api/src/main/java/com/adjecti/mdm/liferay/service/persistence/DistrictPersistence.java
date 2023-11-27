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

import com.adjecti.mdm.liferay.exception.NoSuchDistrictException;
import com.adjecti.mdm.liferay.model.District;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictUtil
 * @generated
 */
@ProviderType
public interface DistrictPersistence extends BasePersistence<District> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching districts
	 */
	public java.util.List<District> findByCode(String code);

	/**
	 * Returns a range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public java.util.List<District> findByCode(String code, int start, int end);

	/**
	 * Returns an ordered range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns an ordered range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where code = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByCode_PrevAndNext(
			long districtId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching districts
	 */
	public int countByCode(String code);

	/**
	 * Returns all the districts where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching districts
	 */
	public java.util.List<District> findByName(String name);

	/**
	 * Returns a range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public java.util.List<District> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns an ordered range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where name = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByName_PrevAndNext(
			long districtId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of districts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching districts
	 */
	public int countByName(String name);

	/**
	 * Returns all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @return the matching districts
	 */
	public java.util.List<District> findByDistrictList(
		long stateId, boolean deleted);

	/**
	 * Returns a range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public java.util.List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns an ordered range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByDistrictList_First(
			long stateId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByDistrictList_First(
		long stateId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByDistrictList_Last(
			long stateId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByDistrictList_Last(
		long stateId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByDistrictList_PrevAndNext(
			long districtId, long stateId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where stateId = &#63; and deleted = &#63; from the database.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 */
	public void removeByDistrictList(long stateId, boolean deleted);

	/**
	 * Returns the number of districts where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @return the number of matching districts
	 */
	public int countByDistrictList(long stateId, boolean deleted);

	/**
	 * Returns all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @return the matching districts
	 */
	public java.util.List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted);

	/**
	 * Returns a range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public java.util.List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns an ordered range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public java.util.List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByDistrictIdAndDeleted_First(
			long districtId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByDistrictIdAndDeleted_First(
		long districtId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByDistrictIdAndDeleted_Last(
			long districtId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByDistrictIdAndDeleted_Last(
		long districtId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Removes all the districts where districtId = &#63; and deleted = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 */
	public void removeByDistrictIdAndDeleted(long districtId, boolean deleted);

	/**
	 * Returns the number of districts where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @return the number of matching districts
	 */
	public int countByDistrictIdAndDeleted(long districtId, boolean deleted);

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public void cacheResult(District district);

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public void cacheResult(java.util.List<District> districts);

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public District create(long districtId);

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District remove(long districtId) throws NoSuchDistrictException;

	public District updateImpl(District district);

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District findByPrimaryKey(long districtId)
		throws NoSuchDistrictException;

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public District fetchByPrimaryKey(long districtId);

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public java.util.List<District> findAll();

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	public java.util.List<District> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of districts
	 */
	public java.util.List<District> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of districts
	 */
	public java.util.List<District> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the districts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public int countAll();

}