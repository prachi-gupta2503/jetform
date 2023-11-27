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

import com.adjecti.mdm.liferay.exception.NoSuchTrainingInstituteException;
import com.adjecti.mdm.liferay.model.TrainingInstitute;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the training institute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstituteUtil
 * @generated
 */
@ProviderType
public interface TrainingInstitutePersistence
	extends BasePersistence<TrainingInstitute> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrainingInstituteUtil} to access the training institute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the training institutes where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByCode(String code);

	/**
	 * Returns a range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training institutes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public TrainingInstitute findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Returns the first training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public TrainingInstitute fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns the last training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public TrainingInstitute findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Returns the last training institute in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public TrainingInstitute fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns the training institutes before and after the current training institute in the ordered set where code = &#63;.
	 *
	 * @param trainingInstituteId the primary key of the current training institute
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public TrainingInstitute[] findByCode_PrevAndNext(
			long trainingInstituteId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Removes all the training institutes where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of training institutes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training institutes
	 */
	public int countByCode(String code);

	/**
	 * Returns all the training institutes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByName(String name);

	/**
	 * Returns a range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training institutes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training institutes
	 */
	public java.util.List<TrainingInstitute> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public TrainingInstitute findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Returns the first training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public TrainingInstitute fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns the last training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute
	 * @throws NoSuchTrainingInstituteException if a matching training institute could not be found
	 */
	public TrainingInstitute findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Returns the last training institute in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training institute, or <code>null</code> if a matching training institute could not be found
	 */
	public TrainingInstitute fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns the training institutes before and after the current training institute in the ordered set where name = &#63;.
	 *
	 * @param trainingInstituteId the primary key of the current training institute
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public TrainingInstitute[] findByName_PrevAndNext(
			long trainingInstituteId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
				orderByComparator)
		throws NoSuchTrainingInstituteException;

	/**
	 * Removes all the training institutes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of training institutes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training institutes
	 */
	public int countByName(String name);

	/**
	 * Caches the training institute in the entity cache if it is enabled.
	 *
	 * @param trainingInstitute the training institute
	 */
	public void cacheResult(TrainingInstitute trainingInstitute);

	/**
	 * Caches the training institutes in the entity cache if it is enabled.
	 *
	 * @param trainingInstitutes the training institutes
	 */
	public void cacheResult(
		java.util.List<TrainingInstitute> trainingInstitutes);

	/**
	 * Creates a new training institute with the primary key. Does not add the training institute to the database.
	 *
	 * @param trainingInstituteId the primary key for the new training institute
	 * @return the new training institute
	 */
	public TrainingInstitute create(long trainingInstituteId);

	/**
	 * Removes the training institute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute that was removed
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public TrainingInstitute remove(long trainingInstituteId)
		throws NoSuchTrainingInstituteException;

	public TrainingInstitute updateImpl(TrainingInstitute trainingInstitute);

	/**
	 * Returns the training institute with the primary key or throws a <code>NoSuchTrainingInstituteException</code> if it could not be found.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute
	 * @throws NoSuchTrainingInstituteException if a training institute with the primary key could not be found
	 */
	public TrainingInstitute findByPrimaryKey(long trainingInstituteId)
		throws NoSuchTrainingInstituteException;

	/**
	 * Returns the training institute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute, or <code>null</code> if a training institute with the primary key could not be found
	 */
	public TrainingInstitute fetchByPrimaryKey(long trainingInstituteId);

	/**
	 * Returns all the training institutes.
	 *
	 * @return the training institutes
	 */
	public java.util.List<TrainingInstitute> findAll();

	/**
	 * Returns a range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of training institutes
	 */
	public java.util.List<TrainingInstitute> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training institutes
	 */
	public java.util.List<TrainingInstitute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator);

	/**
	 * Returns an ordered range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training institutes
	 */
	public java.util.List<TrainingInstitute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingInstitute>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the training institutes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of training institutes.
	 *
	 * @return the number of training institutes
	 */
	public int countAll();

}