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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.exception.NoSuchEmployeePromotionException;
import com.adjecti.pis.liferay.model.EmployeePromotion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee promotion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionUtil
 * @generated
 */
@ProviderType
public interface EmployeePromotionPersistence
	extends BasePersistence<EmployeePromotion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePromotionUtil} to access the employee promotion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByGradeModeId(
		long gradeModeId);

	/**
	 * Returns a range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByGradeModeId_First(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByGradeModeId_First(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByGradeModeId_Last(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByGradeModeId_Last(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion[] findByGradeModeId_PrevAndNext(
			long employeePromotionId, long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Removes all the employee promotions where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public void removeByGradeModeId(long gradeModeId);

	/**
	 * Returns the number of employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee promotions
	 */
	public int countByGradeModeId(long gradeModeId);

	/**
	 * Returns all the employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion[] findByEmployeeId_PrevAndNext(
			long employeePromotionId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Removes all the employee promotions where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee promotions
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public java.util.List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public EmployeePromotion findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public EmployeePromotion fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion[] findByOrganizationId_PrevAndNext(
			long employeePromotionId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
				orderByComparator)
		throws NoSuchEmployeePromotionException;

	/**
	 * Removes all the employee promotions where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee promotions
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Caches the employee promotion in the entity cache if it is enabled.
	 *
	 * @param employeePromotion the employee promotion
	 */
	public void cacheResult(EmployeePromotion employeePromotion);

	/**
	 * Caches the employee promotions in the entity cache if it is enabled.
	 *
	 * @param employeePromotions the employee promotions
	 */
	public void cacheResult(
		java.util.List<EmployeePromotion> employeePromotions);

	/**
	 * Creates a new employee promotion with the primary key. Does not add the employee promotion to the database.
	 *
	 * @param employeePromotionId the primary key for the new employee promotion
	 * @return the new employee promotion
	 */
	public EmployeePromotion create(long employeePromotionId);

	/**
	 * Removes the employee promotion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion that was removed
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion remove(long employeePromotionId)
		throws NoSuchEmployeePromotionException;

	public EmployeePromotion updateImpl(EmployeePromotion employeePromotion);

	/**
	 * Returns the employee promotion with the primary key or throws a <code>NoSuchEmployeePromotionException</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion findByPrimaryKey(long employeePromotionId)
		throws NoSuchEmployeePromotionException;

	/**
	 * Returns the employee promotion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion, or <code>null</code> if a employee promotion with the primary key could not be found
	 */
	public EmployeePromotion fetchByPrimaryKey(long employeePromotionId);

	/**
	 * Returns all the employee promotions.
	 *
	 * @return the employee promotions
	 */
	public java.util.List<EmployeePromotion> findAll();

	/**
	 * Returns a range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of employee promotions
	 */
	public java.util.List<EmployeePromotion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee promotions
	 */
	public java.util.List<EmployeePromotion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee promotions
	 */
	public java.util.List<EmployeePromotion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePromotion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee promotions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee promotions.
	 *
	 * @return the number of employee promotions
	 */
	public int countAll();

}