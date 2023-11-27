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
 * Provides a wrapper for {@link QualificationSubjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationSubjectLocalService
 * @generated
 */
public class QualificationSubjectLocalServiceWrapper
	implements QualificationSubjectLocalService,
			   ServiceWrapper<QualificationSubjectLocalService> {

	public QualificationSubjectLocalServiceWrapper(
		QualificationSubjectLocalService qualificationSubjectLocalService) {

		_qualificationSubjectLocalService = qualificationSubjectLocalService;
	}

	/**
	 * Adds the qualification subject to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationSubject the qualification subject
	 * @return the qualification subject that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
		addQualificationSubject(
			com.adjecti.mdm.liferay.model.QualificationSubject
				qualificationSubject) {

		return _qualificationSubjectLocalService.addQualificationSubject(
			qualificationSubject);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationSubjectLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new qualification subject with the primary key. Does not add the qualification subject to the database.
	 *
	 * @param qualificationSubjectId the primary key for the new qualification subject
	 * @return the new qualification subject
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
		createQualificationSubject(long qualificationSubjectId) {

		return _qualificationSubjectLocalService.createQualificationSubject(
			qualificationSubjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationSubjectLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the qualification subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject that was removed
	 * @throws PortalException if a qualification subject with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
			deleteQualificationSubject(long qualificationSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationSubjectLocalService.deleteQualificationSubject(
			qualificationSubjectId);
	}

	/**
	 * Deletes the qualification subject from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationSubject the qualification subject
	 * @return the qualification subject that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
		deleteQualificationSubject(
			com.adjecti.mdm.liferay.model.QualificationSubject
				qualificationSubject) {

		return _qualificationSubjectLocalService.deleteQualificationSubject(
			qualificationSubject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qualificationSubjectLocalService.dynamicQuery();
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

		return _qualificationSubjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationSubjectModelImpl</code>.
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

		return _qualificationSubjectLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationSubjectModelImpl</code>.
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

		return _qualificationSubjectLocalService.dynamicQuery(
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

		return _qualificationSubjectLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _qualificationSubjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
		fetchQualificationSubject(long qualificationSubjectId) {

		return _qualificationSubjectLocalService.fetchQualificationSubject(
			qualificationSubjectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _qualificationSubjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _qualificationSubjectLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationSubjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationSubjectLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the qualification subject with the primary key.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject
	 * @throws PortalException if a qualification subject with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
			getQualificationSubject(long qualificationSubjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationSubjectLocalService.getQualificationSubject(
			qualificationSubjectId);
	}

	/**
	 * Returns a range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of qualification subjects
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.QualificationSubject>
		getQualificationSubjects(int start, int end) {

		return _qualificationSubjectLocalService.getQualificationSubjects(
			start, end);
	}

	/**
	 * Returns the number of qualification subjects.
	 *
	 * @return the number of qualification subjects
	 */
	@Override
	public int getQualificationSubjectsCount() {
		return _qualificationSubjectLocalService.
			getQualificationSubjectsCount();
	}

	/**
	 * Updates the qualification subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationSubjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationSubject the qualification subject
	 * @return the qualification subject that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationSubject
		updateQualificationSubject(
			com.adjecti.mdm.liferay.model.QualificationSubject
				qualificationSubject) {

		return _qualificationSubjectLocalService.updateQualificationSubject(
			qualificationSubject);
	}

	@Override
	public QualificationSubjectLocalService getWrappedService() {
		return _qualificationSubjectLocalService;
	}

	@Override
	public void setWrappedService(
		QualificationSubjectLocalService qualificationSubjectLocalService) {

		_qualificationSubjectLocalService = qualificationSubjectLocalService;
	}

	private QualificationSubjectLocalService _qualificationSubjectLocalService;

}