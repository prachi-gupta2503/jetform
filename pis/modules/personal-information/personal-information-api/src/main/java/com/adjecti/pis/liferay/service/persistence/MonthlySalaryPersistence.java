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

import com.adjecti.pis.liferay.exception.NoSuchMonthlySalaryException;
import com.adjecti.pis.liferay.model.MonthlySalary;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the monthly salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryUtil
 * @generated
 */
@ProviderType
public interface MonthlySalaryPersistence
	extends BasePersistence<MonthlySalary> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MonthlySalaryUtil} to access the monthly salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the monthly salary in the entity cache if it is enabled.
	 *
	 * @param monthlySalary the monthly salary
	 */
	public void cacheResult(MonthlySalary monthlySalary);

	/**
	 * Caches the monthly salaries in the entity cache if it is enabled.
	 *
	 * @param monthlySalaries the monthly salaries
	 */
	public void cacheResult(java.util.List<MonthlySalary> monthlySalaries);

	/**
	 * Creates a new monthly salary with the primary key. Does not add the monthly salary to the database.
	 *
	 * @param monthlySalaryId the primary key for the new monthly salary
	 * @return the new monthly salary
	 */
	public MonthlySalary create(long monthlySalaryId);

	/**
	 * Removes the monthly salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary that was removed
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	public MonthlySalary remove(long monthlySalaryId)
		throws NoSuchMonthlySalaryException;

	public MonthlySalary updateImpl(MonthlySalary monthlySalary);

	/**
	 * Returns the monthly salary with the primary key or throws a <code>NoSuchMonthlySalaryException</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	public MonthlySalary findByPrimaryKey(long monthlySalaryId)
		throws NoSuchMonthlySalaryException;

	/**
	 * Returns the monthly salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary, or <code>null</code> if a monthly salary with the primary key could not be found
	 */
	public MonthlySalary fetchByPrimaryKey(long monthlySalaryId);

	/**
	 * Returns all the monthly salaries.
	 *
	 * @return the monthly salaries
	 */
	public java.util.List<MonthlySalary> findAll();

	/**
	 * Returns a range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @return the range of monthly salaries
	 */
	public java.util.List<MonthlySalary> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly salaries
	 */
	public java.util.List<MonthlySalary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlySalary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of monthly salaries
	 */
	public java.util.List<MonthlySalary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlySalary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the monthly salaries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of monthly salaries.
	 *
	 * @return the number of monthly salaries
	 */
	public int countAll();

}