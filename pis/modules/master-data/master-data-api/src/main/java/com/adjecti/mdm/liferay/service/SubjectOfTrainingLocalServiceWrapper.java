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

package com.adjecti.mdm.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubjectOfTrainingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfTrainingLocalService
 * @generated
 */
public class SubjectOfTrainingLocalServiceWrapper
	implements ServiceWrapper<SubjectOfTrainingLocalService>,
			   SubjectOfTrainingLocalService {

	public SubjectOfTrainingLocalServiceWrapper(
		SubjectOfTrainingLocalService subjectOfTrainingLocalService) {

		_subjectOfTrainingLocalService = subjectOfTrainingLocalService;
	}

	/**
	 * Adds the subject of training to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectOfTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subjectOfTraining the subject of training
	 * @return the subject of training that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining addSubjectOfTraining(
		com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return _subjectOfTrainingLocalService.addSubjectOfTraining(
			subjectOfTraining);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectOfTrainingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new subject of training with the primary key. Does not add the subject of training to the database.
	 *
	 * @param subjectOfTrainingId the primary key for the new subject of training
	 * @return the new subject of training
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining
		createSubjectOfTraining(long subjectOfTrainingId) {

		return _subjectOfTrainingLocalService.createSubjectOfTraining(
			subjectOfTrainingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectOfTrainingLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the subject of training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectOfTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training that was removed
	 * @throws PortalException if a subject of training with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining
			deleteSubjectOfTraining(long subjectOfTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectOfTrainingLocalService.deleteSubjectOfTraining(
			subjectOfTrainingId);
	}

	/**
	 * Deletes the subject of training from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectOfTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subjectOfTraining the subject of training
	 * @return the subject of training that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining
		deleteSubjectOfTraining(
			com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return _subjectOfTrainingLocalService.deleteSubjectOfTraining(
			subjectOfTraining);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subjectOfTrainingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subjectOfTrainingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _subjectOfTrainingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _subjectOfTrainingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subjectOfTrainingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _subjectOfTrainingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining
		fetchSubjectOfTraining(long subjectOfTrainingId) {

		return _subjectOfTrainingLocalService.fetchSubjectOfTraining(
			subjectOfTrainingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subjectOfTrainingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subjectOfTrainingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subjectOfTrainingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectOfTrainingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subject of training with the primary key.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training
	 * @throws PortalException if a subject of training with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining getSubjectOfTraining(
			long subjectOfTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subjectOfTrainingLocalService.getSubjectOfTraining(
			subjectOfTrainingId);
	}

	/**
	 * Returns a range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @return the range of subject of trainings
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.SubjectOfTraining>
		getSubjectOfTrainings(int start, int end) {

		return _subjectOfTrainingLocalService.getSubjectOfTrainings(start, end);
	}

	/**
	 * Returns the number of subject of trainings.
	 *
	 * @return the number of subject of trainings
	 */
	@Override
	public int getSubjectOfTrainingsCount() {
		return _subjectOfTrainingLocalService.getSubjectOfTrainingsCount();
	}

	/**
	 * Updates the subject of training in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubjectOfTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subjectOfTraining the subject of training
	 * @return the subject of training that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.SubjectOfTraining
		updateSubjectOfTraining(
			com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return _subjectOfTrainingLocalService.updateSubjectOfTraining(
			subjectOfTraining);
	}

	@Override
	public SubjectOfTrainingLocalService getWrappedService() {
		return _subjectOfTrainingLocalService;
	}

	@Override
	public void setWrappedService(
		SubjectOfTrainingLocalService subjectOfTrainingLocalService) {

		_subjectOfTrainingLocalService = subjectOfTrainingLocalService;
	}

	private SubjectOfTrainingLocalService _subjectOfTrainingLocalService;

}