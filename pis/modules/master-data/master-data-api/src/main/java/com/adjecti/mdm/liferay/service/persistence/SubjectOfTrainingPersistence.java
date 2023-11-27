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

import com.adjecti.mdm.liferay.exception.NoSuchSubjectOfTrainingException;
import com.adjecti.mdm.liferay.model.SubjectOfTraining;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subject of training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfTrainingUtil
 * @generated
 */
@ProviderType
public interface SubjectOfTrainingPersistence
	extends BasePersistence<SubjectOfTraining> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectOfTrainingUtil} to access the subject of training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the subject of training in the entity cache if it is enabled.
	 *
	 * @param subjectOfTraining the subject of training
	 */
	public void cacheResult(SubjectOfTraining subjectOfTraining);

	/**
	 * Caches the subject of trainings in the entity cache if it is enabled.
	 *
	 * @param subjectOfTrainings the subject of trainings
	 */
	public void cacheResult(
		java.util.List<SubjectOfTraining> subjectOfTrainings);

	/**
	 * Creates a new subject of training with the primary key. Does not add the subject of training to the database.
	 *
	 * @param subjectOfTrainingId the primary key for the new subject of training
	 * @return the new subject of training
	 */
	public SubjectOfTraining create(long subjectOfTrainingId);

	/**
	 * Removes the subject of training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training that was removed
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	public SubjectOfTraining remove(long subjectOfTrainingId)
		throws NoSuchSubjectOfTrainingException;

	public SubjectOfTraining updateImpl(SubjectOfTraining subjectOfTraining);

	/**
	 * Returns the subject of training with the primary key or throws a <code>NoSuchSubjectOfTrainingException</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	public SubjectOfTraining findByPrimaryKey(long subjectOfTrainingId)
		throws NoSuchSubjectOfTrainingException;

	/**
	 * Returns the subject of training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training, or <code>null</code> if a subject of training with the primary key could not be found
	 */
	public SubjectOfTraining fetchByPrimaryKey(long subjectOfTrainingId);

	/**
	 * Returns all the subject of trainings.
	 *
	 * @return the subject of trainings
	 */
	public java.util.List<SubjectOfTraining> findAll();

	/**
	 * Returns a range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @return the range of subject of trainings
	 */
	public java.util.List<SubjectOfTraining> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of trainings
	 */
	public java.util.List<SubjectOfTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubjectOfTraining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of trainings
	 */
	public java.util.List<SubjectOfTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubjectOfTraining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subject of trainings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subject of trainings.
	 *
	 * @return the number of subject of trainings
	 */
	public int countAll();

}