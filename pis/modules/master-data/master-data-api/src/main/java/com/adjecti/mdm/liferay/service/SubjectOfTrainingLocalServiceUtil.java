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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SubjectOfTraining. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.SubjectOfTrainingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubjectOfTrainingLocalService
 * @generated
 */
public class SubjectOfTrainingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.SubjectOfTrainingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
		addSubjectOfTraining(
			com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return getService().addSubjectOfTraining(subjectOfTraining);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subject of training with the primary key. Does not add the subject of training to the database.
	 *
	 * @param subjectOfTrainingId the primary key for the new subject of training
	 * @return the new subject of training
	 */
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
		createSubjectOfTraining(long subjectOfTrainingId) {

		return getService().createSubjectOfTraining(subjectOfTrainingId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
			deleteSubjectOfTraining(long subjectOfTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSubjectOfTraining(subjectOfTrainingId);
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
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
		deleteSubjectOfTraining(
			com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return getService().deleteSubjectOfTraining(subjectOfTraining);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
		fetchSubjectOfTraining(long subjectOfTrainingId) {

		return getService().fetchSubjectOfTraining(subjectOfTrainingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subject of training with the primary key.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training
	 * @throws PortalException if a subject of training with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
			getSubjectOfTraining(long subjectOfTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSubjectOfTraining(subjectOfTrainingId);
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
	public static java.util.List
		<com.adjecti.mdm.liferay.model.SubjectOfTraining> getSubjectOfTrainings(
			int start, int end) {

		return getService().getSubjectOfTrainings(start, end);
	}

	/**
	 * Returns the number of subject of trainings.
	 *
	 * @return the number of subject of trainings
	 */
	public static int getSubjectOfTrainingsCount() {
		return getService().getSubjectOfTrainingsCount();
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
	public static com.adjecti.mdm.liferay.model.SubjectOfTraining
		updateSubjectOfTraining(
			com.adjecti.mdm.liferay.model.SubjectOfTraining subjectOfTraining) {

		return getService().updateSubjectOfTraining(subjectOfTraining);
	}

	public static SubjectOfTrainingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SubjectOfTrainingLocalService, SubjectOfTrainingLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SubjectOfTrainingLocalService.class);

		ServiceTracker
			<SubjectOfTrainingLocalService, SubjectOfTrainingLocalService>
				serviceTracker =
					new ServiceTracker
						<SubjectOfTrainingLocalService,
						 SubjectOfTrainingLocalService>(
							 bundle.getBundleContext(),
							 SubjectOfTrainingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}