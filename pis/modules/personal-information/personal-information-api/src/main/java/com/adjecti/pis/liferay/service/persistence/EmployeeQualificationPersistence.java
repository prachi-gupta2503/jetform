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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeQualificationException;
import com.adjecti.pis.liferay.model.EmployeeQualification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationUtil
 * @generated
 */
@ProviderType
public interface EmployeeQualificationPersistence
	extends BasePersistence<EmployeeQualification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeQualificationUtil} to access the employee qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification[] findByEmployeeId_PrevAndNext(
			long employeeQualificationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Removes all the employee qualifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee qualifications
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationId(
		long qualificationId);

	/**
	 * Returns a range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByQualificationId_First(
			long qualificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByQualificationId_First(
		long qualificationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByQualificationId_Last(
			long qualificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByQualificationId_Last(
		long qualificationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification[] findByQualificationId_PrevAndNext(
			long employeeQualificationId, long qualificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Removes all the employee qualifications where qualificationId = &#63; from the database.
	 *
	 * @param qualificationId the qualification ID
	 */
	public void removeByQualificationId(long qualificationId);

	/**
	 * Returns the number of employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the number of matching employee qualifications
	 */
	public int countByQualificationId(long qualificationId);

	/**
	 * Returns all the employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findBySpecializationId(
		long specializationId);

	/**
	 * Returns a range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findBySpecializationId_First(
			long specializationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchBySpecializationId_First(
		long specializationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findBySpecializationId_Last(
			long specializationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchBySpecializationId_Last(
		long specializationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification[] findBySpecializationId_PrevAndNext(
			long employeeQualificationId, long specializationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Removes all the employee qualifications where specializationId = &#63; from the database.
	 *
	 * @param specializationId the specialization ID
	 */
	public void removeBySpecializationId(long specializationId);

	/**
	 * Returns the number of employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the number of matching employee qualifications
	 */
	public int countBySpecializationId(long specializationId);

	/**
	 * Returns all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId);

	/**
	 * Returns a range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification[] findByJoiningProcessId_PrevAndNext(
			long employeeQualificationId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Removes all the employee qualifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee qualifications
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns all the employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationLevelId(
		long levelId);

	/**
	 * Returns a range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public java.util.List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByQualificationLevelId_First(
			long levelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByQualificationLevelId_First(
		long levelId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public EmployeeQualification findByQualificationLevelId_Last(
			long levelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public EmployeeQualification fetchByQualificationLevelId_Last(
		long levelId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification[] findByQualificationLevelId_PrevAndNext(
			long employeeQualificationId, long levelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Removes all the employee qualifications where levelId = &#63; from the database.
	 *
	 * @param levelId the level ID
	 */
	public void removeByQualificationLevelId(long levelId);

	/**
	 * Returns the number of employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the number of matching employee qualifications
	 */
	public int countByQualificationLevelId(long levelId);

	/**
	 * Caches the employee qualification in the entity cache if it is enabled.
	 *
	 * @param employeeQualification the employee qualification
	 */
	public void cacheResult(EmployeeQualification employeeQualification);

	/**
	 * Caches the employee qualifications in the entity cache if it is enabled.
	 *
	 * @param employeeQualifications the employee qualifications
	 */
	public void cacheResult(
		java.util.List<EmployeeQualification> employeeQualifications);

	/**
	 * Creates a new employee qualification with the primary key. Does not add the employee qualification to the database.
	 *
	 * @param employeeQualificationId the primary key for the new employee qualification
	 * @return the new employee qualification
	 */
	public EmployeeQualification create(long employeeQualificationId);

	/**
	 * Removes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification remove(long employeeQualificationId)
		throws NoSuchEmployeeQualificationException;

	public EmployeeQualification updateImpl(
		EmployeeQualification employeeQualification);

	/**
	 * Returns the employee qualification with the primary key or throws a <code>NoSuchEmployeeQualificationException</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification findByPrimaryKey(long employeeQualificationId)
		throws NoSuchEmployeeQualificationException;

	/**
	 * Returns the employee qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification, or <code>null</code> if a employee qualification with the primary key could not be found
	 */
	public EmployeeQualification fetchByPrimaryKey(
		long employeeQualificationId);

	/**
	 * Returns all the employee qualifications.
	 *
	 * @return the employee qualifications
	 */
	public java.util.List<EmployeeQualification> findAll();

	/**
	 * Returns a range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of employee qualifications
	 */
	public java.util.List<EmployeeQualification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee qualifications
	 */
	public java.util.List<EmployeeQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee qualifications
	 */
	public java.util.List<EmployeeQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee qualifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee qualifications.
	 *
	 * @return the number of employee qualifications
	 */
	public int countAll();

}