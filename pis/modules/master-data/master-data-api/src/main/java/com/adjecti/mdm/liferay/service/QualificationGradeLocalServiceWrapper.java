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
 * Provides a wrapper for {@link QualificationGradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationGradeLocalService
 * @generated
 */
public class QualificationGradeLocalServiceWrapper
	implements QualificationGradeLocalService,
			   ServiceWrapper<QualificationGradeLocalService> {

	public QualificationGradeLocalServiceWrapper(
		QualificationGradeLocalService qualificationGradeLocalService) {

		_qualificationGradeLocalService = qualificationGradeLocalService;
	}

	/**
	 * Adds the qualification grade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationGrade the qualification grade
	 * @return the qualification grade that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
		addQualificationGrade(
			com.adjecti.mdm.liferay.model.QualificationGrade
				qualificationGrade) {

		return _qualificationGradeLocalService.addQualificationGrade(
			qualificationGrade);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationGradeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new qualification grade with the primary key. Does not add the qualification grade to the database.
	 *
	 * @param qualificationGradeId the primary key for the new qualification grade
	 * @return the new qualification grade
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
		createQualificationGrade(long qualificationGradeId) {

		return _qualificationGradeLocalService.createQualificationGrade(
			qualificationGradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationGradeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the qualification grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade that was removed
	 * @throws PortalException if a qualification grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
			deleteQualificationGrade(long qualificationGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationGradeLocalService.deleteQualificationGrade(
			qualificationGradeId);
	}

	/**
	 * Deletes the qualification grade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationGrade the qualification grade
	 * @return the qualification grade that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
		deleteQualificationGrade(
			com.adjecti.mdm.liferay.model.QualificationGrade
				qualificationGrade) {

		return _qualificationGradeLocalService.deleteQualificationGrade(
			qualificationGrade);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qualificationGradeLocalService.dynamicQuery();
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

		return _qualificationGradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationGradeModelImpl</code>.
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

		return _qualificationGradeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationGradeModelImpl</code>.
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

		return _qualificationGradeLocalService.dynamicQuery(
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

		return _qualificationGradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _qualificationGradeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
		fetchQualificationGrade(long qualificationGradeId) {

		return _qualificationGradeLocalService.fetchQualificationGrade(
			qualificationGradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _qualificationGradeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _qualificationGradeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationGradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationGradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the qualification grade with the primary key.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade
	 * @throws PortalException if a qualification grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
			getQualificationGrade(long qualificationGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationGradeLocalService.getQualificationGrade(
			qualificationGradeId);
	}

	/**
	 * Returns a range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of qualification grades
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.QualificationGrade>
		getQualificationGrades(int start, int end) {

		return _qualificationGradeLocalService.getQualificationGrades(
			start, end);
	}

	/**
	 * Returns the number of qualification grades.
	 *
	 * @return the number of qualification grades
	 */
	@Override
	public int getQualificationGradesCount() {
		return _qualificationGradeLocalService.getQualificationGradesCount();
	}

	/**
	 * Updates the qualification grade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationGrade the qualification grade
	 * @return the qualification grade that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationGrade
		updateQualificationGrade(
			com.adjecti.mdm.liferay.model.QualificationGrade
				qualificationGrade) {

		return _qualificationGradeLocalService.updateQualificationGrade(
			qualificationGrade);
	}

	@Override
	public QualificationGradeLocalService getWrappedService() {
		return _qualificationGradeLocalService;
	}

	@Override
	public void setWrappedService(
		QualificationGradeLocalService qualificationGradeLocalService) {

		_qualificationGradeLocalService = qualificationGradeLocalService;
	}

	private QualificationGradeLocalService _qualificationGradeLocalService;

}