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
 * Provides a wrapper for {@link TrainingCourseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingCourseLocalService
 * @generated
 */
public class TrainingCourseLocalServiceWrapper
	implements ServiceWrapper<TrainingCourseLocalService>,
			   TrainingCourseLocalService {

	public TrainingCourseLocalServiceWrapper(
		TrainingCourseLocalService trainingCourseLocalService) {

		_trainingCourseLocalService = trainingCourseLocalService;
	}

	/**
	 * Adds the training course to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingCourse the training course
	 * @return the training course that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse addTrainingCourse(
		com.adjecti.mdm.liferay.model.TrainingCourse trainingCourse) {

		return _trainingCourseLocalService.addTrainingCourse(trainingCourse);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingCourseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new training course with the primary key. Does not add the training course to the database.
	 *
	 * @param trainingCourseId the primary key for the new training course
	 * @return the new training course
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse createTrainingCourse(
		long trainingCourseId) {

		return _trainingCourseLocalService.createTrainingCourse(
			trainingCourseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingCourseLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the training course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course that was removed
	 * @throws PortalException if a training course with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse deleteTrainingCourse(
			long trainingCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingCourseLocalService.deleteTrainingCourse(
			trainingCourseId);
	}

	/**
	 * Deletes the training course from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingCourse the training course
	 * @return the training course that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse deleteTrainingCourse(
		com.adjecti.mdm.liferay.model.TrainingCourse trainingCourse) {

		return _trainingCourseLocalService.deleteTrainingCourse(trainingCourse);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingCourseLocalService.dynamicQuery();
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

		return _trainingCourseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingCourseModelImpl</code>.
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

		return _trainingCourseLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingCourseModelImpl</code>.
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

		return _trainingCourseLocalService.dynamicQuery(
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

		return _trainingCourseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _trainingCourseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse fetchTrainingCourse(
		long trainingCourseId) {

		return _trainingCourseLocalService.fetchTrainingCourse(
			trainingCourseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingCourseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingCourseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingCourseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingCourseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training course with the primary key.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course
	 * @throws PortalException if a training course with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse getTrainingCourse(
			long trainingCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingCourseLocalService.getTrainingCourse(trainingCourseId);
	}

	/**
	 * Returns a range of all the training courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @return the range of training courses
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.TrainingCourse>
		getTrainingCourses(int start, int end) {

		return _trainingCourseLocalService.getTrainingCourses(start, end);
	}

	/**
	 * Returns the number of training courses.
	 *
	 * @return the number of training courses
	 */
	@Override
	public int getTrainingCoursesCount() {
		return _trainingCourseLocalService.getTrainingCoursesCount();
	}

	/**
	 * Updates the training course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingCourse the training course
	 * @return the training course that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingCourse updateTrainingCourse(
		com.adjecti.mdm.liferay.model.TrainingCourse trainingCourse) {

		return _trainingCourseLocalService.updateTrainingCourse(trainingCourse);
	}

	@Override
	public TrainingCourseLocalService getWrappedService() {
		return _trainingCourseLocalService;
	}

	@Override
	public void setWrappedService(
		TrainingCourseLocalService trainingCourseLocalService) {

		_trainingCourseLocalService = trainingCourseLocalService;
	}

	private TrainingCourseLocalService _trainingCourseLocalService;

}