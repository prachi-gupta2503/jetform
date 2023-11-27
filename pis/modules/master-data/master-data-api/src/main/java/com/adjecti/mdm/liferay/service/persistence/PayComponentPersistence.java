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

import com.adjecti.mdm.liferay.exception.NoSuchPayComponentException;
import com.adjecti.mdm.liferay.model.PayComponent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayComponentUtil
 * @generated
 */
@ProviderType
public interface PayComponentPersistence extends BasePersistence<PayComponent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayComponentUtil} to access the pay component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pay component in the entity cache if it is enabled.
	 *
	 * @param payComponent the pay component
	 */
	public void cacheResult(PayComponent payComponent);

	/**
	 * Caches the pay components in the entity cache if it is enabled.
	 *
	 * @param payComponents the pay components
	 */
	public void cacheResult(java.util.List<PayComponent> payComponents);

	/**
	 * Creates a new pay component with the primary key. Does not add the pay component to the database.
	 *
	 * @param payComponentId the primary key for the new pay component
	 * @return the new pay component
	 */
	public PayComponent create(long payComponentId);

	/**
	 * Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component that was removed
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	public PayComponent remove(long payComponentId)
		throws NoSuchPayComponentException;

	public PayComponent updateImpl(PayComponent payComponent);

	/**
	 * Returns the pay component with the primary key or throws a <code>NoSuchPayComponentException</code> if it could not be found.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	public PayComponent findByPrimaryKey(long payComponentId)
		throws NoSuchPayComponentException;

	/**
	 * Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	 */
	public PayComponent fetchByPrimaryKey(long payComponentId);

	/**
	 * Returns all the pay components.
	 *
	 * @return the pay components
	 */
	public java.util.List<PayComponent> findAll();

	/**
	 * Returns a range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of pay components
	 */
	public java.util.List<PayComponent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay components
	 */
	public java.util.List<PayComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay components
	 */
	public java.util.List<PayComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay components from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay components.
	 *
	 * @return the number of pay components
	 */
	public int countAll();

}