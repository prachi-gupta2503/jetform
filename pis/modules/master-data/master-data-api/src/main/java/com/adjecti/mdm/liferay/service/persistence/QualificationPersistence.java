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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationException;
import com.adjecti.mdm.liferay.model.Qualification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationUtil
 * @generated
 */
@ProviderType
public interface QualificationPersistence
	extends BasePersistence<Qualification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QualificationUtil} to access the qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the qualification in the entity cache if it is enabled.
	 *
	 * @param qualification the qualification
	 */
	public void cacheResult(Qualification qualification);

	/**
	 * Caches the qualifications in the entity cache if it is enabled.
	 *
	 * @param qualifications the qualifications
	 */
	public void cacheResult(java.util.List<Qualification> qualifications);

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param qualificationId the primary key for the new qualification
	 * @return the new qualification
	 */
	public Qualification create(long qualificationId);

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification remove(long qualificationId)
		throws NoSuchQualificationException;

	public Qualification updateImpl(Qualification qualification);

	/**
	 * Returns the qualification with the primary key or throws a <code>NoSuchQualificationException</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification findByPrimaryKey(long qualificationId)
		throws NoSuchQualificationException;

	/**
	 * Returns the qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification, or <code>null</code> if a qualification with the primary key could not be found
	 */
	public Qualification fetchByPrimaryKey(long qualificationId);

	/**
	 * Returns all the qualifications.
	 *
	 * @return the qualifications
	 */
	public java.util.List<Qualification> findAll();

	/**
	 * Returns a range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of qualifications
	 */
	public java.util.List<Qualification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualifications
	 */
	public java.util.List<Qualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualifications
	 */
	public java.util.List<Qualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the qualifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
	 */
	public int countAll();

}