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
 * Provides a wrapper for {@link QualificationLevelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLevelLocalService
 * @generated
 */
public class QualificationLevelLocalServiceWrapper
	implements QualificationLevelLocalService,
			   ServiceWrapper<QualificationLevelLocalService> {

	public QualificationLevelLocalServiceWrapper(
		QualificationLevelLocalService qualificationLevelLocalService) {

		_qualificationLevelLocalService = qualificationLevelLocalService;
	}

	/**
	 * Adds the qualification level to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationLevel the qualification level
	 * @return the qualification level that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
		addQualificationLevel(
			com.adjecti.mdm.liferay.model.QualificationLevel
				qualificationLevel) {

		return _qualificationLevelLocalService.addQualificationLevel(
			qualificationLevel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLevelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new qualification level with the primary key. Does not add the qualification level to the database.
	 *
	 * @param qualificationLevelId the primary key for the new qualification level
	 * @return the new qualification level
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
		createQualificationLevel(long qualificationLevelId) {

		return _qualificationLevelLocalService.createQualificationLevel(
			qualificationLevelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLevelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the qualification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level that was removed
	 * @throws PortalException if a qualification level with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
			deleteQualificationLevel(long qualificationLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLevelLocalService.deleteQualificationLevel(
			qualificationLevelId);
	}

	/**
	 * Deletes the qualification level from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationLevel the qualification level
	 * @return the qualification level that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
		deleteQualificationLevel(
			com.adjecti.mdm.liferay.model.QualificationLevel
				qualificationLevel) {

		return _qualificationLevelLocalService.deleteQualificationLevel(
			qualificationLevel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qualificationLevelLocalService.dynamicQuery();
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

		return _qualificationLevelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationLevelModelImpl</code>.
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

		return _qualificationLevelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationLevelModelImpl</code>.
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

		return _qualificationLevelLocalService.dynamicQuery(
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

		return _qualificationLevelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _qualificationLevelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
		fetchQualificationLevel(long qualificationLevelId) {

		return _qualificationLevelLocalService.fetchQualificationLevel(
			qualificationLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _qualificationLevelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _qualificationLevelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationLevelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLevelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the qualification level with the primary key.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level
	 * @throws PortalException if a qualification level with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
			getQualificationLevel(long qualificationLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLevelLocalService.getQualificationLevel(
			qualificationLevelId);
	}

	/**
	 * Returns a range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of qualification levels
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.QualificationLevel>
		getQualificationLevels(int start, int end) {

		return _qualificationLevelLocalService.getQualificationLevels(
			start, end);
	}

	/**
	 * Returns the number of qualification levels.
	 *
	 * @return the number of qualification levels
	 */
	@Override
	public int getQualificationLevelsCount() {
		return _qualificationLevelLocalService.getQualificationLevelsCount();
	}

	/**
	 * Updates the qualification level in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QualificationLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qualificationLevel the qualification level
	 * @return the qualification level that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.QualificationLevel
		updateQualificationLevel(
			com.adjecti.mdm.liferay.model.QualificationLevel
				qualificationLevel) {

		return _qualificationLevelLocalService.updateQualificationLevel(
			qualificationLevel);
	}

	@Override
	public QualificationLevelLocalService getWrappedService() {
		return _qualificationLevelLocalService;
	}

	@Override
	public void setWrappedService(
		QualificationLevelLocalService qualificationLevelLocalService) {

		_qualificationLevelLocalService = qualificationLevelLocalService;
	}

	private QualificationLevelLocalService _qualificationLevelLocalService;

}