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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTransferException;
import com.adjecti.pis.liferay.model.EmployeeTransfer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee transfer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferUtil
 * @generated
 */
@ProviderType
public interface EmployeeTransferPersistence
	extends BasePersistence<EmployeeTransfer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTransferUtil} to access the employee transfer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByGradeModeId(long gradeModeId);

	/**
	 * Returns a range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByGradeModeId_First(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByGradeModeId_First(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByGradeModeId_Last(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByGradeModeId_Last(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer[] findByGradeModeId_PrevAndNext(
			long employeeTransferId, long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Removes all the employee transfers where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public void removeByGradeModeId(long gradeModeId);

	/**
	 * Returns the number of employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee transfers
	 */
	public int countByGradeModeId(long gradeModeId);

	/**
	 * Returns all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId);

	/**
	 * Returns a range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByFromOrganizationId_First(
			long fromOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByFromOrganizationId_First(
		long fromOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByFromOrganizationId_Last(
			long fromOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByFromOrganizationId_Last(
		long fromOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer[] findByFromOrganizationId_PrevAndNext(
			long employeeTransferId, long fromOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Removes all the employee transfers where fromOrganizationId = &#63; from the database.
	 *
	 * @param fromOrganizationId the from organization ID
	 */
	public void removeByFromOrganizationId(long fromOrganizationId);

	/**
	 * Returns the number of employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the number of matching employee transfers
	 */
	public int countByFromOrganizationId(long fromOrganizationId);

	/**
	 * Returns all the employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId);

	/**
	 * Returns a range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByToOrganizationId_First(
			long toOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByToOrganizationId_First(
		long toOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByToOrganizationId_Last(
			long toOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByToOrganizationId_Last(
		long toOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer[] findByToOrganizationId_PrevAndNext(
			long employeeTransferId, long toOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Removes all the employee transfers where toOrganizationId = &#63; from the database.
	 *
	 * @param toOrganizationId the to organization ID
	 */
	public void removeByToOrganizationId(long toOrganizationId);

	/**
	 * Returns the number of employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the number of matching employee transfers
	 */
	public int countByToOrganizationId(long toOrganizationId);

	/**
	 * Returns all the employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public java.util.List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public EmployeeTransfer findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public EmployeeTransfer fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer[] findByEmployeeId_PrevAndNext(
			long employeeTransferId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
				orderByComparator)
		throws NoSuchEmployeeTransferException;

	/**
	 * Removes all the employee transfers where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee transfers
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee transfer in the entity cache if it is enabled.
	 *
	 * @param employeeTransfer the employee transfer
	 */
	public void cacheResult(EmployeeTransfer employeeTransfer);

	/**
	 * Caches the employee transfers in the entity cache if it is enabled.
	 *
	 * @param employeeTransfers the employee transfers
	 */
	public void cacheResult(java.util.List<EmployeeTransfer> employeeTransfers);

	/**
	 * Creates a new employee transfer with the primary key. Does not add the employee transfer to the database.
	 *
	 * @param employeeTransferId the primary key for the new employee transfer
	 * @return the new employee transfer
	 */
	public EmployeeTransfer create(long employeeTransferId);

	/**
	 * Removes the employee transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer that was removed
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer remove(long employeeTransferId)
		throws NoSuchEmployeeTransferException;

	public EmployeeTransfer updateImpl(EmployeeTransfer employeeTransfer);

	/**
	 * Returns the employee transfer with the primary key or throws a <code>NoSuchEmployeeTransferException</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer findByPrimaryKey(long employeeTransferId)
		throws NoSuchEmployeeTransferException;

	/**
	 * Returns the employee transfer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer, or <code>null</code> if a employee transfer with the primary key could not be found
	 */
	public EmployeeTransfer fetchByPrimaryKey(long employeeTransferId);

	/**
	 * Returns all the employee transfers.
	 *
	 * @return the employee transfers
	 */
	public java.util.List<EmployeeTransfer> findAll();

	/**
	 * Returns a range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of employee transfers
	 */
	public java.util.List<EmployeeTransfer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee transfers
	 */
	public java.util.List<EmployeeTransfer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee transfers
	 */
	public java.util.List<EmployeeTransfer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTransfer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee transfers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee transfers.
	 *
	 * @return the number of employee transfers
	 */
	public int countAll();

}