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
 * Provides a wrapper for {@link DesignationGradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationGradeLocalService
 * @generated
 */
public class DesignationGradeLocalServiceWrapper
	implements DesignationGradeLocalService,
			   ServiceWrapper<DesignationGradeLocalService> {

	public DesignationGradeLocalServiceWrapper(
		DesignationGradeLocalService designationGradeLocalService) {

		_designationGradeLocalService = designationGradeLocalService;
	}

	/**
	 * Adds the designation grade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGrade the designation grade
	 * @return the designation grade that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade addDesignationGrade(
		com.adjecti.mdm.liferay.model.DesignationGrade designationGrade) {

		return _designationGradeLocalService.addDesignationGrade(
			designationGrade);
	}

	/**
	 * Creates a new designation grade with the primary key. Does not add the designation grade to the database.
	 *
	 * @param designationGradeId the primary key for the new designation grade
	 * @return the new designation grade
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade
		createDesignationGrade(long designationGradeId) {

		return _designationGradeLocalService.createDesignationGrade(
			designationGradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGradeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the designation grade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGrade the designation grade
	 * @return the designation grade that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade
		deleteDesignationGrade(
			com.adjecti.mdm.liferay.model.DesignationGrade designationGrade) {

		return _designationGradeLocalService.deleteDesignationGrade(
			designationGrade);
	}

	/**
	 * Deletes the designation grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade that was removed
	 * @throws PortalException if a designation grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade
			deleteDesignationGrade(long designationGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGradeLocalService.deleteDesignationGrade(
			designationGradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGradeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationGradeLocalService.dynamicQuery();
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

		return _designationGradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGradeModelImpl</code>.
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

		return _designationGradeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGradeModelImpl</code>.
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

		return _designationGradeLocalService.dynamicQuery(
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

		return _designationGradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationGradeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade fetchDesignationGrade(
		long designationGradeId) {

		return _designationGradeLocalService.fetchDesignationGrade(
			designationGradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationGradeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation grade with the primary key.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade
	 * @throws PortalException if a designation grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade getDesignationGrade(
			long designationGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGradeLocalService.getDesignationGrade(
			designationGradeId);
	}

	/**
	 * Returns a range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @return the range of designation grades
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DesignationGrade>
		getDesignationGrades(int start, int end) {

		return _designationGradeLocalService.getDesignationGrades(start, end);
	}

	/**
	 * Returns the number of designation grades.
	 *
	 * @return the number of designation grades
	 */
	@Override
	public int getDesignationGradesCount() {
		return _designationGradeLocalService.getDesignationGradesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationGradeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationGradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation grade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGrade the designation grade
	 * @return the designation grade that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGrade
		updateDesignationGrade(
			com.adjecti.mdm.liferay.model.DesignationGrade designationGrade) {

		return _designationGradeLocalService.updateDesignationGrade(
			designationGrade);
	}

	@Override
	public DesignationGradeLocalService getWrappedService() {
		return _designationGradeLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationGradeLocalService designationGradeLocalService) {

		_designationGradeLocalService = designationGradeLocalService;
	}

	private DesignationGradeLocalService _designationGradeLocalService;

}