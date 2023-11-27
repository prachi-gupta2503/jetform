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

import com.adjecti.mdm.liferay.exception.NoSuchTrainingSubjectException;
import com.adjecti.mdm.liferay.model.TrainingSubject;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the training subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSubjectUtil
 * @generated
 */
@ProviderType
public interface TrainingSubjectPersistence
	extends BasePersistence<TrainingSubject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrainingSubjectUtil} to access the training subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the training subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training subjects
	 */
	public java.util.List<TrainingSubject> findByCode(String code);

	/**
	 * Returns a range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public TrainingSubject findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Returns the first training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public TrainingSubject fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns the last training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public TrainingSubject findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Returns the last training subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public TrainingSubject fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns the training subjects before and after the current training subject in the ordered set where code = &#63;.
	 *
	 * @param trainingSubjectId the primary key of the current training subject
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public TrainingSubject[] findByCode_PrevAndNext(
			long trainingSubjectId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Removes all the training subjects where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of training subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training subjects
	 */
	public int countByCode(String code);

	/**
	 * Returns all the training subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training subjects
	 */
	public java.util.List<TrainingSubject> findByName(String name);

	/**
	 * Returns a range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training subjects
	 */
	public java.util.List<TrainingSubject> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public TrainingSubject findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Returns the first training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public TrainingSubject fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns the last training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject
	 * @throws NoSuchTrainingSubjectException if a matching training subject could not be found
	 */
	public TrainingSubject findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Returns the last training subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training subject, or <code>null</code> if a matching training subject could not be found
	 */
	public TrainingSubject fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns the training subjects before and after the current training subject in the ordered set where name = &#63;.
	 *
	 * @param trainingSubjectId the primary key of the current training subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public TrainingSubject[] findByName_PrevAndNext(
			long trainingSubjectId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
				orderByComparator)
		throws NoSuchTrainingSubjectException;

	/**
	 * Removes all the training subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of training subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training subjects
	 */
	public int countByName(String name);

	/**
	 * Caches the training subject in the entity cache if it is enabled.
	 *
	 * @param trainingSubject the training subject
	 */
	public void cacheResult(TrainingSubject trainingSubject);

	/**
	 * Caches the training subjects in the entity cache if it is enabled.
	 *
	 * @param trainingSubjects the training subjects
	 */
	public void cacheResult(java.util.List<TrainingSubject> trainingSubjects);

	/**
	 * Creates a new training subject with the primary key. Does not add the training subject to the database.
	 *
	 * @param trainingSubjectId the primary key for the new training subject
	 * @return the new training subject
	 */
	public TrainingSubject create(long trainingSubjectId);

	/**
	 * Removes the training subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject that was removed
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public TrainingSubject remove(long trainingSubjectId)
		throws NoSuchTrainingSubjectException;

	public TrainingSubject updateImpl(TrainingSubject trainingSubject);

	/**
	 * Returns the training subject with the primary key or throws a <code>NoSuchTrainingSubjectException</code> if it could not be found.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject
	 * @throws NoSuchTrainingSubjectException if a training subject with the primary key could not be found
	 */
	public TrainingSubject findByPrimaryKey(long trainingSubjectId)
		throws NoSuchTrainingSubjectException;

	/**
	 * Returns the training subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject, or <code>null</code> if a training subject with the primary key could not be found
	 */
	public TrainingSubject fetchByPrimaryKey(long trainingSubjectId);

	/**
	 * Returns all the training subjects.
	 *
	 * @return the training subjects
	 */
	public java.util.List<TrainingSubject> findAll();

	/**
	 * Returns a range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of training subjects
	 */
	public java.util.List<TrainingSubject> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training subjects
	 */
	public java.util.List<TrainingSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training subjects
	 */
	public java.util.List<TrainingSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingSubject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the training subjects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of training subjects.
	 *
	 * @return the number of training subjects
	 */
	public int countAll();

}