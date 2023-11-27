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
 * Provides a wrapper for {@link GradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GradeLocalService
 * @generated
 */
public class GradeLocalServiceWrapper
	implements GradeLocalService, ServiceWrapper<GradeLocalService> {

	public GradeLocalServiceWrapper(GradeLocalService gradeLocalService) {
		_gradeLocalService = gradeLocalService;
	}

	/**
	 * Adds the grade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grade the grade
	 * @return the grade that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade addGrade(
		com.adjecti.mdm.liferay.model.Grade grade) {

		return _gradeLocalService.addGrade(grade);
	}

	/**
	 * Creates a new grade with the primary key. Does not add the grade to the database.
	 *
	 * @param gradeId the primary key for the new grade
	 * @return the new grade
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade createGrade(long gradeId) {
		return _gradeLocalService.createGrade(gradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the grade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grade the grade
	 * @return the grade that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade deleteGrade(
		com.adjecti.mdm.liferay.model.Grade grade) {

		return _gradeLocalService.deleteGrade(grade);
	}

	/**
	 * Deletes the grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade that was removed
	 * @throws PortalException if a grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade deleteGrade(long gradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeLocalService.deleteGrade(gradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gradeLocalService.dynamicQuery();
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

		return _gradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModelImpl</code>.
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

		return _gradeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModelImpl</code>.
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

		return _gradeLocalService.dynamicQuery(
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

		return _gradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gradeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Grade fetchGrade(long gradeId) {
		return _gradeLocalService.fetchGrade(gradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gradeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the grade with the primary key.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade
	 * @throws PortalException if a grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade getGrade(long gradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeLocalService.getGrade(gradeId);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Grade getGradeByCode(String code) {
		return _gradeLocalService.getGradeByCode(code);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Grade> getGradeByName(
		String gradeName) {

		return _gradeLocalService.getGradeByName(gradeName);
	}

	/**
	 * Returns a range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @return the range of grades
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Grade> getGrades(
		int start, int end) {

		return _gradeLocalService.getGrades(start, end);
	}

	/**
	 * Returns the number of grades.
	 *
	 * @return the number of grades
	 */
	@Override
	public int getGradesCount() {
		return _gradeLocalService.getGradesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gradeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the grade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grade the grade
	 * @return the grade that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Grade updateGrade(
		com.adjecti.mdm.liferay.model.Grade grade) {

		return _gradeLocalService.updateGrade(grade);
	}

	@Override
	public GradeLocalService getWrappedService() {
		return _gradeLocalService;
	}

	@Override
	public void setWrappedService(GradeLocalService gradeLocalService) {
		_gradeLocalService = gradeLocalService;
	}

	private GradeLocalService _gradeLocalService;

}