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

import com.adjecti.pis.liferay.exception.NoSuchMonthlySalaryComponentException;
import com.adjecti.pis.liferay.model.MonthlySalaryComponent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the monthly salary component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryComponentUtil
 * @generated
 */
@ProviderType
public interface MonthlySalaryComponentPersistence
	extends BasePersistence<MonthlySalaryComponent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MonthlySalaryComponentUtil} to access the monthly salary component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the monthly salary component in the entity cache if it is enabled.
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 */
	public void cacheResult(MonthlySalaryComponent monthlySalaryComponent);

	/**
	 * Caches the monthly salary components in the entity cache if it is enabled.
	 *
	 * @param monthlySalaryComponents the monthly salary components
	 */
	public void cacheResult(
		java.util.List<MonthlySalaryComponent> monthlySalaryComponents);

	/**
	 * Creates a new monthly salary component with the primary key. Does not add the monthly salary component to the database.
	 *
	 * @param monthlySalaryComponentId the primary key for the new monthly salary component
	 * @return the new monthly salary component
	 */
	public MonthlySalaryComponent create(long monthlySalaryComponentId);

	/**
	 * Removes the monthly salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component that was removed
	 * @throws NoSuchMonthlySalaryComponentException if a monthly salary component with the primary key could not be found
	 */
	public MonthlySalaryComponent remove(long monthlySalaryComponentId)
		throws NoSuchMonthlySalaryComponentException;

	public MonthlySalaryComponent updateImpl(
		MonthlySalaryComponent monthlySalaryComponent);

	/**
	 * Returns the monthly salary component with the primary key or throws a <code>NoSuchMonthlySalaryComponentException</code> if it could not be found.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component
	 * @throws NoSuchMonthlySalaryComponentException if a monthly salary component with the primary key could not be found
	 */
	public MonthlySalaryComponent findByPrimaryKey(
			long monthlySalaryComponentId)
		throws NoSuchMonthlySalaryComponentException;

	/**
	 * Returns the monthly salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component, or <code>null</code> if a monthly salary component with the primary key could not be found
	 */
	public MonthlySalaryComponent fetchByPrimaryKey(
		long monthlySalaryComponentId);

	/**
	 * Returns all the monthly salary components.
	 *
	 * @return the monthly salary components
	 */
	public java.util.List<MonthlySalaryComponent> findAll();

	/**
	 * Returns a range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @return the range of monthly salary components
	 */
	public java.util.List<MonthlySalaryComponent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly salary components
	 */
	public java.util.List<MonthlySalaryComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlySalaryComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of monthly salary components
	 */
	public java.util.List<MonthlySalaryComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlySalaryComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the monthly salary components from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of monthly salary components.
	 *
	 * @return the number of monthly salary components
	 */
	public int countAll();

}