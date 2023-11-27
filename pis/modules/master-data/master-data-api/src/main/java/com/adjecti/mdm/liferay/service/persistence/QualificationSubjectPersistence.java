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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationSubjectException;
import com.adjecti.mdm.liferay.model.QualificationSubject;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qualification subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationSubjectUtil
 * @generated
 */
@ProviderType
public interface QualificationSubjectPersistence
	extends BasePersistence<QualificationSubject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QualificationSubjectUtil} to access the qualification subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByCode(String code);

	/**
	 * Returns a range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public QualificationSubject findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public QualificationSubject fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public QualificationSubject findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public QualificationSubject fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where code = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public QualificationSubject[] findByCode_PrevAndNext(
			long qualificationSubjectId, String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Removes all the qualification subjects where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification subjects
	 */
	public int countByCode(String code);

	/**
	 * Returns all the qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByName(String name);

	/**
	 * Returns a range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	public java.util.List<QualificationSubject> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public QualificationSubject findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public QualificationSubject fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public QualificationSubject findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public QualificationSubject fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where name = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public QualificationSubject[] findByName_PrevAndNext(
			long qualificationSubjectId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException;

	/**
	 * Removes all the qualification subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification subjects
	 */
	public int countByName(String name);

	/**
	 * Caches the qualification subject in the entity cache if it is enabled.
	 *
	 * @param qualificationSubject the qualification subject
	 */
	public void cacheResult(QualificationSubject qualificationSubject);

	/**
	 * Caches the qualification subjects in the entity cache if it is enabled.
	 *
	 * @param qualificationSubjects the qualification subjects
	 */
	public void cacheResult(
		java.util.List<QualificationSubject> qualificationSubjects);

	/**
	 * Creates a new qualification subject with the primary key. Does not add the qualification subject to the database.
	 *
	 * @param qualificationSubjectId the primary key for the new qualification subject
	 * @return the new qualification subject
	 */
	public QualificationSubject create(long qualificationSubjectId);

	/**
	 * Removes the qualification subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject that was removed
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public QualificationSubject remove(long qualificationSubjectId)
		throws NoSuchQualificationSubjectException;

	public QualificationSubject updateImpl(
		QualificationSubject qualificationSubject);

	/**
	 * Returns the qualification subject with the primary key or throws a <code>NoSuchQualificationSubjectException</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public QualificationSubject findByPrimaryKey(long qualificationSubjectId)
		throws NoSuchQualificationSubjectException;

	/**
	 * Returns the qualification subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject, or <code>null</code> if a qualification subject with the primary key could not be found
	 */
	public QualificationSubject fetchByPrimaryKey(long qualificationSubjectId);

	/**
	 * Returns all the qualification subjects.
	 *
	 * @return the qualification subjects
	 */
	public java.util.List<QualificationSubject> findAll();

	/**
	 * Returns a range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of qualification subjects
	 */
	public java.util.List<QualificationSubject> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification subjects
	 */
	public java.util.List<QualificationSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification subjects
	 */
	public java.util.List<QualificationSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the qualification subjects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qualification subjects.
	 *
	 * @return the number of qualification subjects
	 */
	public int countAll();

}