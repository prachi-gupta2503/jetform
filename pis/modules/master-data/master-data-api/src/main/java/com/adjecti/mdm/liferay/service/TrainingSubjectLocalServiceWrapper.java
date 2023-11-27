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
 * Provides a wrapper for {@link TrainingSubjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSubjectLocalService
 * @generated
 */
public class TrainingSubjectLocalServiceWrapper
	implements ServiceWrapper<TrainingSubjectLocalService>,
			   TrainingSubjectLocalService {

	public TrainingSubjectLocalServiceWrapper(
		TrainingSubjectLocalService trainingSubjectLocalService) {

		_trainingSubjectLocalService = trainingSubjectLocalService;
	}

	/**
	 * Adds the training subject to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSubject the training subject
	 * @return the training subject that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject addTrainingSubject(
		com.adjecti.mdm.liferay.model.TrainingSubject trainingSubject) {

		return _trainingSubjectLocalService.addTrainingSubject(trainingSubject);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSubjectLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new training subject with the primary key. Does not add the training subject to the database.
	 *
	 * @param trainingSubjectId the primary key for the new training subject
	 * @return the new training subject
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject createTrainingSubject(
		long trainingSubjectId) {

		return _trainingSubjectLocalService.createTrainingSubject(
			trainingSubjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSubjectLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the training subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject that was removed
	 * @throws PortalException if a training subject with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject deleteTrainingSubject(
			long trainingSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSubjectLocalService.deleteTrainingSubject(
			trainingSubjectId);
	}

	/**
	 * Deletes the training subject from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSubject the training subject
	 * @return the training subject that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject deleteTrainingSubject(
		com.adjecti.mdm.liferay.model.TrainingSubject trainingSubject) {

		return _trainingSubjectLocalService.deleteTrainingSubject(
			trainingSubject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingSubjectLocalService.dynamicQuery();
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

		return _trainingSubjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingSubjectModelImpl</code>.
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

		return _trainingSubjectLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingSubjectModelImpl</code>.
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

		return _trainingSubjectLocalService.dynamicQuery(
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

		return _trainingSubjectLocalService.dynamicQueryCount(dynamicQuery);
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

		return _trainingSubjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject fetchTrainingSubject(
		long trainingSubjectId) {

		return _trainingSubjectLocalService.fetchTrainingSubject(
			trainingSubjectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingSubjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingSubjectLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingSubjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSubjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training subject with the primary key.
	 *
	 * @param trainingSubjectId the primary key of the training subject
	 * @return the training subject
	 * @throws PortalException if a training subject with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject getTrainingSubject(
			long trainingSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSubjectLocalService.getTrainingSubject(
			trainingSubjectId);
	}

	/**
	 * Returns a range of all the training subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training subjects
	 * @param end the upper bound of the range of training subjects (not inclusive)
	 * @return the range of training subjects
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.TrainingSubject>
		getTrainingSubjects(int start, int end) {

		return _trainingSubjectLocalService.getTrainingSubjects(start, end);
	}

	/**
	 * Returns the number of training subjects.
	 *
	 * @return the number of training subjects
	 */
	@Override
	public int getTrainingSubjectsCount() {
		return _trainingSubjectLocalService.getTrainingSubjectsCount();
	}

	/**
	 * Updates the training subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSubject the training subject
	 * @return the training subject that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingSubject updateTrainingSubject(
		com.adjecti.mdm.liferay.model.TrainingSubject trainingSubject) {

		return _trainingSubjectLocalService.updateTrainingSubject(
			trainingSubject);
	}

	@Override
	public TrainingSubjectLocalService getWrappedService() {
		return _trainingSubjectLocalService;
	}

	@Override
	public void setWrappedService(
		TrainingSubjectLocalService trainingSubjectLocalService) {

		_trainingSubjectLocalService = trainingSubjectLocalService;
	}

	private TrainingSubjectLocalService _trainingSubjectLocalService;

}