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

import com.adjecti.mdm.liferay.exception.NoSuchSubjectOfQualificationException;
import com.adjecti.mdm.liferay.model.SubjectOfQualification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subject of qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfQualificationUtil
 * @generated
 */
@ProviderType
public interface SubjectOfQualificationPersistence
	extends BasePersistence<SubjectOfQualification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectOfQualificationUtil} to access the subject of qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the subject of qualification in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualification the subject of qualification
	 */
	public void cacheResult(SubjectOfQualification subjectOfQualification);

	/**
	 * Caches the subject of qualifications in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualifications the subject of qualifications
	 */
	public void cacheResult(
		java.util.List<SubjectOfQualification> subjectOfQualifications);

	/**
	 * Creates a new subject of qualification with the primary key. Does not add the subject of qualification to the database.
	 *
	 * @param subjectOfQualificationId the primary key for the new subject of qualification
	 * @return the new subject of qualification
	 */
	public SubjectOfQualification create(long subjectOfQualificationId);

	/**
	 * Removes the subject of qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification that was removed
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	public SubjectOfQualification remove(long subjectOfQualificationId)
		throws NoSuchSubjectOfQualificationException;

	public SubjectOfQualification updateImpl(
		SubjectOfQualification subjectOfQualification);

	/**
	 * Returns the subject of qualification with the primary key or throws a <code>NoSuchSubjectOfQualificationException</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	public SubjectOfQualification findByPrimaryKey(
			long subjectOfQualificationId)
		throws NoSuchSubjectOfQualificationException;

	/**
	 * Returns the subject of qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification, or <code>null</code> if a subject of qualification with the primary key could not be found
	 */
	public SubjectOfQualification fetchByPrimaryKey(
		long subjectOfQualificationId);

	/**
	 * Returns all the subject of qualifications.
	 *
	 * @return the subject of qualifications
	 */
	public java.util.List<SubjectOfQualification> findAll();

	/**
	 * Returns a range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @return the range of subject of qualifications
	 */
	public java.util.List<SubjectOfQualification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of qualifications
	 */
	public java.util.List<SubjectOfQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubjectOfQualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of qualifications
	 */
	public java.util.List<SubjectOfQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubjectOfQualification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subject of qualifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subject of qualifications.
	 *
	 * @return the number of subject of qualifications
	 */
	public int countAll();

}