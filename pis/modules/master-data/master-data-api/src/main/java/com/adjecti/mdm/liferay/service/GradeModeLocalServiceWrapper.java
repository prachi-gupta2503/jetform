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
 * Provides a wrapper for {@link GradeModeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GradeModeLocalService
 * @generated
 */
public class GradeModeLocalServiceWrapper
	implements GradeModeLocalService, ServiceWrapper<GradeModeLocalService> {

	public GradeModeLocalServiceWrapper(
		GradeModeLocalService gradeModeLocalService) {

		_gradeModeLocalService = gradeModeLocalService;
	}

	/**
	 * Adds the grade mode to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradeMode the grade mode
	 * @return the grade mode that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode addGradeMode(
		com.adjecti.mdm.liferay.model.GradeMode gradeMode) {

		return _gradeModeLocalService.addGradeMode(gradeMode);
	}

	/**
	 * Creates a new grade mode with the primary key. Does not add the grade mode to the database.
	 *
	 * @param gradeModeId the primary key for the new grade mode
	 * @return the new grade mode
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode createGradeMode(
		long gradeModeId) {

		return _gradeModeLocalService.createGradeMode(gradeModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeModeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the grade mode from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradeMode the grade mode
	 * @return the grade mode that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode deleteGradeMode(
		com.adjecti.mdm.liferay.model.GradeMode gradeMode) {

		return _gradeModeLocalService.deleteGradeMode(gradeMode);
	}

	/**
	 * Deletes the grade mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode that was removed
	 * @throws PortalException if a grade mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode deleteGradeMode(
			long gradeModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeModeLocalService.deleteGradeMode(gradeModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeModeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gradeModeLocalService.dynamicQuery();
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

		return _gradeModeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModeModelImpl</code>.
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

		return _gradeModeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModeModelImpl</code>.
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

		return _gradeModeLocalService.dynamicQuery(
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

		return _gradeModeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gradeModeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.GradeMode fetchGradeMode(
		long gradeModeId) {

		return _gradeModeLocalService.fetchGradeMode(gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gradeModeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the grade mode with the primary key.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode
	 * @throws PortalException if a grade mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode getGradeMode(
			long gradeModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeModeLocalService.getGradeMode(gradeModeId);
	}

	/**
	 * Returns a range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @return the range of grade modes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.GradeMode>
		getGradeModes(int start, int end) {

		return _gradeModeLocalService.getGradeModes(start, end);
	}

	/**
	 * Returns the number of grade modes.
	 *
	 * @return the number of grade modes
	 */
	@Override
	public int getGradeModesCount() {
		return _gradeModeLocalService.getGradeModesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gradeModeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gradeModeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradeModeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the grade mode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradeModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradeMode the grade mode
	 * @return the grade mode that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.GradeMode updateGradeMode(
		com.adjecti.mdm.liferay.model.GradeMode gradeMode) {

		return _gradeModeLocalService.updateGradeMode(gradeMode);
	}

	@Override
	public GradeModeLocalService getWrappedService() {
		return _gradeModeLocalService;
	}

	@Override
	public void setWrappedService(GradeModeLocalService gradeModeLocalService) {
		_gradeModeLocalService = gradeModeLocalService;
	}

	private GradeModeLocalService _gradeModeLocalService;

}