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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationClassException;
import com.adjecti.mdm.liferay.model.DesignationClass;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationClassUtil
 * @generated
 */
@ProviderType
public interface DesignationClassPersistence
	extends BasePersistence<DesignationClass> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationClassUtil} to access the designation class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the designation class in the entity cache if it is enabled.
	 *
	 * @param designationClass the designation class
	 */
	public void cacheResult(DesignationClass designationClass);

	/**
	 * Caches the designation classes in the entity cache if it is enabled.
	 *
	 * @param designationClasses the designation classes
	 */
	public void cacheResult(
		java.util.List<DesignationClass> designationClasses);

	/**
	 * Creates a new designation class with the primary key. Does not add the designation class to the database.
	 *
	 * @param designationClassId the primary key for the new designation class
	 * @return the new designation class
	 */
	public DesignationClass create(long designationClassId);

	/**
	 * Removes the designation class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class that was removed
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	public DesignationClass remove(long designationClassId)
		throws NoSuchDesignationClassException;

	public DesignationClass updateImpl(DesignationClass designationClass);

	/**
	 * Returns the designation class with the primary key or throws a <code>NoSuchDesignationClassException</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	public DesignationClass findByPrimaryKey(long designationClassId)
		throws NoSuchDesignationClassException;

	/**
	 * Returns the designation class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class, or <code>null</code> if a designation class with the primary key could not be found
	 */
	public DesignationClass fetchByPrimaryKey(long designationClassId);

	/**
	 * Returns all the designation classes.
	 *
	 * @return the designation classes
	 */
	public java.util.List<DesignationClass> findAll();

	/**
	 * Returns a range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @return the range of designation classes
	 */
	public java.util.List<DesignationClass> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation classes
	 */
	public java.util.List<DesignationClass> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationClass>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation classes
	 */
	public java.util.List<DesignationClass> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationClass>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation classes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation classes.
	 *
	 * @return the number of designation classes
	 */
	public int countAll();

}