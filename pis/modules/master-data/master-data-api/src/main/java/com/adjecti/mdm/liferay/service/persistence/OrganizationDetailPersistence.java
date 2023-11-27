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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationDetailException;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailUtil
 * @generated
 */
@ProviderType
public interface OrganizationDetailPersistence
	extends BasePersistence<OrganizationDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationDetailUtil} to access the organization detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type);

	/**
	 * Returns a range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByShortNameAndType_First(
			String shortName, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByShortNameAndType_First(
		String shortName, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByShortNameAndType_Last(
			String shortName, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByShortNameAndType_Last(
		String shortName, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByShortNameAndType_PrevAndNext(
			long organizationDetailId, String shortName, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where shortName = &#63; and type = &#63; from the database.
	 *
	 * @param shortName the short name
	 * @param type the type
	 */
	public void removeByShortNameAndType(String shortName, String type);

	/**
	 * Returns the number of organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public int countByShortNameAndType(String shortName, String type);

	/**
	 * Returns all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type);

	/**
	 * Returns a range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByOrganizationCodeAndType_First(
			String organizationCode, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationCodeAndType_First(
		String organizationCode, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByOrganizationCodeAndType_Last(
			String organizationCode, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationCodeAndType_Last(
		String organizationCode, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByOrganizationCodeAndType_PrevAndNext(
			long organizationDetailId, String organizationCode, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where organizationCode = &#63; and type = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 */
	public void removeByOrganizationCodeAndType(
		String organizationCode, String type);

	/**
	 * Returns the number of organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public int countByOrganizationCodeAndType(
		String organizationCode, String type);

	/**
	 * Returns all the organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByunitType(String unitType);

	/**
	 * Returns a range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByunitType(
		String unitType, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByunitType_First(
			String unitType,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByunitType_First(
		String unitType,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByunitType_Last(
			String unitType,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByunitType_Last(
		String unitType,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByunitType_PrevAndNext(
			long organizationDetailId, String unitType,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where unitType = &#63; from the database.
	 *
	 * @param unitType the unit type
	 */
	public void removeByunitType(String unitType);

	/**
	 * Returns the number of organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the number of matching organization details
	 */
	public int countByunitType(String unitType);

	/**
	 * Returns all the organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentId(long parentId);

	/**
	 * Returns a range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentId(
		long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentId_First(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentId_Last(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentId_PrevAndNext(
			long organizationDetailId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public void removeByParentId(long parentId);

	/**
	 * Returns the number of organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching organization details
	 */
	public int countByParentId(long parentId);

	/**
	 * Returns all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type);

	/**
	 * Returns a range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndType_First(
			long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndType_First(
		long parentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndType_Last(
			long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndType_Last(
		long parentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentIdAndType_PrevAndNext(
			long organizationDetailId, long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentId = &#63; and type = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 */
	public void removeByParentIdAndType(long parentId, String type);

	/**
	 * Returns the number of organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public int countByParentIdAndType(long parentId, String type);

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode);

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndParentIdAndOrganizationCode_First(
			String type, long parentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndParentIdAndOrganizationCode_First(
		String type, long parentId, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndParentIdAndOrganizationCode_Last(
			String type, long parentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndParentIdAndOrganizationCode_Last(
		String type, long parentId, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[]
			findByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				long organizationDetailId, String type, long parentId,
				String organizationCode,
				com.liferay.portal.kernel.util.OrderByComparator
					<OrganizationDetail> orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	public void removeByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode);

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public int countByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode);

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName);

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndParentIdAndShortName_First(
			String type, long parentId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndParentIdAndShortName_First(
		String type, long parentId, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndParentIdAndShortName_Last(
			String type, long parentId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndParentIdAndShortName_Last(
		String type, long parentId, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByTypeAndParentIdAndShortName_PrevAndNext(
			long organizationDetailId, String type, long parentId,
			String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	public void removeByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName);

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public int countByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName);

	/**
	 * Returns all the organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCode(
		String parentCode);

	/**
	 * Returns a range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCode_First(
			String parentCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCode_First(
		String parentCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCode_Last(
			String parentCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCode_Last(
		String parentCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentCode_PrevAndNext(
			long organizationDetailId, String parentCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 */
	public void removeByParentCode(String parentCode);

	/**
	 * Returns the number of organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the number of matching organization details
	 */
	public int countByParentCode(String parentCode);

	/**
	 * Returns the organization detail where organizationId = &#63; or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByOrganizationId(long organizationId)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationId(long organizationId);

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationId(
		long organizationId, boolean useFinderCache);

	/**
	 * Removes the organization detail where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the organization detail that was removed
	 */
	public OrganizationDetail removeByOrganizationId(long organizationId)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the number of organization details where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization details
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCode(
		String organizationCode);

	/**
	 * Returns a range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByOrganizationCode_First(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationCode_First(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByOrganizationCode_Last(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByOrganizationCode_Last(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByOrganizationCode_PrevAndNext(
			long organizationDetailId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public void removeByOrganizationCode(String organizationCode);

	/**
	 * Returns the number of organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public int countByOrganizationCode(String organizationCode);

	/**
	 * Returns all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByParentCodeAndOrganizationCode(
			String parentCode, String organizationCode);

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByParentCodeAndOrganizationCode(
			String parentCode, String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByParentCodeAndOrganizationCode(
			String parentCode, String organizationCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail>
		findByParentCodeAndOrganizationCode(
			String parentCode, String organizationCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCodeAndOrganizationCode_First(
			String parentCode, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCodeAndOrganizationCode_First(
		String parentCode, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCodeAndOrganizationCode_Last(
			String parentCode, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCodeAndOrganizationCode_Last(
		String parentCode, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentCodeAndOrganizationCode_PrevAndNext(
			long organizationDetailId, String parentCode,
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentCode = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 */
	public void removeByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode);

	/**
	 * Returns the number of organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public int countByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode);

	/**
	 * Returns all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName);

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCodeAndShortName_First(
			String parentCode, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCodeAndShortName_First(
		String parentCode, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentCodeAndShortName_Last(
			String parentCode, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentCodeAndShortName_Last(
		String parentCode, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentCodeAndShortName_PrevAndNext(
			long organizationDetailId, String parentCode, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentCode = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 */
	public void removeByParentCodeAndShortName(
		String parentCode, String shortName);

	/**
	 * Returns the number of organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public int countByParentCodeAndShortName(
		String parentCode, String shortName);

	/**
	 * Returns all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode);

	/**
	 * Returns a range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndOrganizationCode_First(
			long parentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndOrganizationCode_First(
		long parentId, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndOrganizationCode_Last(
			long parentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndOrganizationCode_Last(
		long parentId, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentIdAndOrganizationCode_PrevAndNext(
			long organizationDetailId, long parentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	public void removeByParentIdAndOrganizationCode(
		long parentId, String organizationCode);

	/**
	 * Returns the number of organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public int countByParentIdAndOrganizationCode(
		long parentId, String organizationCode);

	/**
	 * Returns all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName);

	/**
	 * Returns a range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndShortName_First(
			long parentId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndShortName_First(
		long parentId, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByParentIdAndShortName_Last(
			long parentId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByParentIdAndShortName_Last(
		long parentId, String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByParentIdAndShortName_PrevAndNext(
			long organizationDetailId, long parentId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	public void removeByParentIdAndShortName(long parentId, String shortName);

	/**
	 * Returns the number of organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public int countByParentIdAndShortName(long parentId, String shortName);

	/**
	 * Returns all the organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortName(String shortName);

	/**
	 * Returns a range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortName(
		String shortName, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByShortName_First(
			String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByShortName_First(
		String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByShortName_Last(
			String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByShortName_Last(
		String shortName,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByShortName_PrevAndNext(
			long organizationDetailId, String shortName,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where shortName = &#63; from the database.
	 *
	 * @param shortName the short name
	 */
	public void removeByShortName(String shortName);

	/**
	 * Returns the number of organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public int countByShortName(String shortName);

	/**
	 * Returns all the organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByType(String type);

	/**
	 * Returns a range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByType(
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByType_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByType_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByType_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByType_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByType_PrevAndNext(
			long organizationDetailId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByType(String type);

	/**
	 * Returns the number of organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public int countByType(String type);

	/**
	 * Returns all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode);

	/**
	 * Returns a range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndOrganizationCode_First(
			String type, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndOrganizationCode_First(
		String type, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByTypeAndOrganizationCode_Last(
			String type, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByTypeAndOrganizationCode_Last(
		String type, String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByTypeAndOrganizationCode_PrevAndNext(
			long organizationDetailId, String type, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where type = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 */
	public void removeByTypeAndOrganizationCode(
		String type, String organizationCode);

	/**
	 * Returns the number of organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public int countByTypeAndOrganizationCode(
		String type, String organizationCode);

	/**
	 * Returns all the organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching organization details
	 */
	public java.util.List<OrganizationDetail> findByStateId(long stateId);

	/**
	 * Returns a range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByStateId(
		long stateId, int start, int end);

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public java.util.List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByStateId_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByStateId_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public OrganizationDetail findByStateId_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public OrganizationDetail fetchByStateId_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail[] findByStateId_PrevAndNext(
			long organizationDetailId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
				orderByComparator)
		throws NoSuchOrganizationDetailException;

	/**
	 * Removes all the organization details where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeByStateId(long stateId);

	/**
	 * Returns the number of organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching organization details
	 */
	public int countByStateId(long stateId);

	/**
	 * Caches the organization detail in the entity cache if it is enabled.
	 *
	 * @param organizationDetail the organization detail
	 */
	public void cacheResult(OrganizationDetail organizationDetail);

	/**
	 * Caches the organization details in the entity cache if it is enabled.
	 *
	 * @param organizationDetails the organization details
	 */
	public void cacheResult(
		java.util.List<OrganizationDetail> organizationDetails);

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	public OrganizationDetail create(long organizationDetailId);

	/**
	 * Removes the organization detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail that was removed
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail remove(long organizationDetailId)
		throws NoSuchOrganizationDetailException;

	public OrganizationDetail updateImpl(OrganizationDetail organizationDetail);

	/**
	 * Returns the organization detail with the primary key or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail findByPrimaryKey(long organizationDetailId)
		throws NoSuchOrganizationDetailException;

	/**
	 * Returns the organization detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail, or <code>null</code> if a organization detail with the primary key could not be found
	 */
	public OrganizationDetail fetchByPrimaryKey(long organizationDetailId);

	/**
	 * Returns all the organization details.
	 *
	 * @return the organization details
	 */
	public java.util.List<OrganizationDetail> findAll();

	/**
	 * Returns a range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of organization details
	 */
	public java.util.List<OrganizationDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization details
	 */
	public java.util.List<OrganizationDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization details
	 */
	public java.util.List<OrganizationDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
	 */
	public int countAll();

}