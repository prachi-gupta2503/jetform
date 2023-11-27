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
 * Provides a wrapper for {@link TrainingInstituteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingInstituteLocalService
 * @generated
 */
public class TrainingInstituteLocalServiceWrapper
	implements ServiceWrapper<TrainingInstituteLocalService>,
			   TrainingInstituteLocalService {

	public TrainingInstituteLocalServiceWrapper(
		TrainingInstituteLocalService trainingInstituteLocalService) {

		_trainingInstituteLocalService = trainingInstituteLocalService;
	}

	/**
	 * Adds the training institute to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingInstituteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingInstitute the training institute
	 * @return the training institute that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute addTrainingInstitute(
		com.adjecti.mdm.liferay.model.TrainingInstitute trainingInstitute) {

		return _trainingInstituteLocalService.addTrainingInstitute(
			trainingInstitute);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingInstituteLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new training institute with the primary key. Does not add the training institute to the database.
	 *
	 * @param trainingInstituteId the primary key for the new training institute
	 * @return the new training institute
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute
		createTrainingInstitute(long trainingInstituteId) {

		return _trainingInstituteLocalService.createTrainingInstitute(
			trainingInstituteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingInstituteLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the training institute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingInstituteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute that was removed
	 * @throws PortalException if a training institute with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute
			deleteTrainingInstitute(long trainingInstituteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingInstituteLocalService.deleteTrainingInstitute(
			trainingInstituteId);
	}

	/**
	 * Deletes the training institute from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingInstituteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingInstitute the training institute
	 * @return the training institute that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute
		deleteTrainingInstitute(
			com.adjecti.mdm.liferay.model.TrainingInstitute trainingInstitute) {

		return _trainingInstituteLocalService.deleteTrainingInstitute(
			trainingInstitute);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingInstituteLocalService.dynamicQuery();
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

		return _trainingInstituteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingInstituteModelImpl</code>.
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

		return _trainingInstituteLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingInstituteModelImpl</code>.
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

		return _trainingInstituteLocalService.dynamicQuery(
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

		return _trainingInstituteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _trainingInstituteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute
		fetchTrainingInstitute(long trainingInstituteId) {

		return _trainingInstituteLocalService.fetchTrainingInstitute(
			trainingInstituteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingInstituteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingInstituteLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingInstituteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingInstituteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training institute with the primary key.
	 *
	 * @param trainingInstituteId the primary key of the training institute
	 * @return the training institute
	 * @throws PortalException if a training institute with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute getTrainingInstitute(
			long trainingInstituteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingInstituteLocalService.getTrainingInstitute(
			trainingInstituteId);
	}

	/**
	 * Returns a range of all the training institutes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TrainingInstituteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training institutes
	 * @param end the upper bound of the range of training institutes (not inclusive)
	 * @return the range of training institutes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.TrainingInstitute>
		getTrainingInstitutes(int start, int end) {

		return _trainingInstituteLocalService.getTrainingInstitutes(start, end);
	}

	/**
	 * Returns the number of training institutes.
	 *
	 * @return the number of training institutes
	 */
	@Override
	public int getTrainingInstitutesCount() {
		return _trainingInstituteLocalService.getTrainingInstitutesCount();
	}

	/**
	 * Updates the training institute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingInstituteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingInstitute the training institute
	 * @return the training institute that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TrainingInstitute
		updateTrainingInstitute(
			com.adjecti.mdm.liferay.model.TrainingInstitute trainingInstitute) {

		return _trainingInstituteLocalService.updateTrainingInstitute(
			trainingInstitute);
	}

	@Override
	public TrainingInstituteLocalService getWrappedService() {
		return _trainingInstituteLocalService;
	}

	@Override
	public void setWrappedService(
		TrainingInstituteLocalService trainingInstituteLocalService) {

		_trainingInstituteLocalService = trainingInstituteLocalService;
	}

	private TrainingInstituteLocalService _trainingInstituteLocalService;

}