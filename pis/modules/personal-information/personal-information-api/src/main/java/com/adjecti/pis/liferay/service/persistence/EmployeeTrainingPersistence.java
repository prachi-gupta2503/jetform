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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTrainingException;
import com.adjecti.pis.liferay.model.EmployeeTraining;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTrainingUtil
 * @generated
 */
@ProviderType
public interface EmployeeTrainingPersistence
	extends BasePersistence<EmployeeTraining> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTrainingUtil} to access the employee training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public EmployeeTraining[] findByEmployeeId_PrevAndNext(
			long employeeTrainingId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Removes all the employee trainings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee trainings
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByInstituteId(long instituteId);

	/**
	 * Returns a range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end);

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByInstituteId_First(
			long instituteId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByInstituteId_First(
		long instituteId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByInstituteId_Last(
			long instituteId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByInstituteId_Last(
		long instituteId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public EmployeeTraining[] findByInstituteId_PrevAndNext(
			long employeeTrainingId, long instituteId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Removes all the employee trainings where instituteId = &#63; from the database.
	 *
	 * @param instituteId the institute ID
	 */
	public void removeByInstituteId(long instituteId);

	/**
	 * Returns the number of employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the number of matching employee trainings
	 */
	public int countByInstituteId(long instituteId);

	/**
	 * Returns all the employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public java.util.List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public EmployeeTraining findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public EmployeeTraining fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public EmployeeTraining[] findByOrganizationId_PrevAndNext(
			long employeeTrainingId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
				orderByComparator)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Removes all the employee trainings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee trainings
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Caches the employee training in the entity cache if it is enabled.
	 *
	 * @param employeeTraining the employee training
	 */
	public void cacheResult(EmployeeTraining employeeTraining);

	/**
	 * Caches the employee trainings in the entity cache if it is enabled.
	 *
	 * @param employeeTrainings the employee trainings
	 */
	public void cacheResult(java.util.List<EmployeeTraining> employeeTrainings);

	/**
	 * Creates a new employee training with the primary key. Does not add the employee training to the database.
	 *
	 * @param employeeTrainingId the primary key for the new employee training
	 * @return the new employee training
	 */
	public EmployeeTraining create(long employeeTrainingId);

	/**
	 * Removes the employee training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training that was removed
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public EmployeeTraining remove(long employeeTrainingId)
		throws NoSuchEmployeeTrainingException;

	public EmployeeTraining updateImpl(EmployeeTraining employeeTraining);

	/**
	 * Returns the employee training with the primary key or throws a <code>NoSuchEmployeeTrainingException</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public EmployeeTraining findByPrimaryKey(long employeeTrainingId)
		throws NoSuchEmployeeTrainingException;

	/**
	 * Returns the employee training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training, or <code>null</code> if a employee training with the primary key could not be found
	 */
	public EmployeeTraining fetchByPrimaryKey(long employeeTrainingId);

	/**
	 * Returns all the employee trainings.
	 *
	 * @return the employee trainings
	 */
	public java.util.List<EmployeeTraining> findAll();

	/**
	 * Returns a range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of employee trainings
	 */
	public java.util.List<EmployeeTraining> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee trainings
	 */
	public java.util.List<EmployeeTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee trainings
	 */
	public java.util.List<EmployeeTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTraining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee trainings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee trainings.
	 *
	 * @return the number of employee trainings
	 */
	public int countAll();

}