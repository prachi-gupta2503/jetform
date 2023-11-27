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
 * Provides a wrapper for {@link CadreDesignationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CadreDesignationLocalService
 * @generated
 */
public class CadreDesignationLocalServiceWrapper
	implements CadreDesignationLocalService,
			   ServiceWrapper<CadreDesignationLocalService> {

	public CadreDesignationLocalServiceWrapper(
		CadreDesignationLocalService cadreDesignationLocalService) {

		_cadreDesignationLocalService = cadreDesignationLocalService;
	}

	/**
	 * Adds the cadre designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadreDesignation the cadre designation
	 * @return the cadre designation that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation addCadreDesignation(
		com.adjecti.mdm.liferay.model.CadreDesignation cadreDesignation) {

		return _cadreDesignationLocalService.addCadreDesignation(
			cadreDesignation);
	}

	/**
	 * Creates a new cadre designation with the primary key. Does not add the cadre designation to the database.
	 *
	 * @param cadreDesignationId the primary key for the new cadre designation
	 * @return the new cadre designation
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation
		createCadreDesignation(long cadreDesignationId) {

		return _cadreDesignationLocalService.createCadreDesignation(
			cadreDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreDesignationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the cadre designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadreDesignation the cadre designation
	 * @return the cadre designation that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation
		deleteCadreDesignation(
			com.adjecti.mdm.liferay.model.CadreDesignation cadreDesignation) {

		return _cadreDesignationLocalService.deleteCadreDesignation(
			cadreDesignation);
	}

	/**
	 * Deletes the cadre designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation that was removed
	 * @throws PortalException if a cadre designation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation
			deleteCadreDesignation(long cadreDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreDesignationLocalService.deleteCadreDesignation(
			cadreDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreDesignationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cadreDesignationLocalService.dynamicQuery();
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

		return _cadreDesignationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreDesignationModelImpl</code>.
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

		return _cadreDesignationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreDesignationModelImpl</code>.
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

		return _cadreDesignationLocalService.dynamicQuery(
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

		return _cadreDesignationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cadreDesignationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation fetchCadreDesignation(
		long cadreDesignationId) {

		return _cadreDesignationLocalService.fetchCadreDesignation(
			cadreDesignationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cadreDesignationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cadre designation with the primary key.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation
	 * @throws PortalException if a cadre designation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation getCadreDesignation(
			long cadreDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreDesignationLocalService.getCadreDesignation(
			cadreDesignationId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CadreDesignation>
		getCadreDesignations() {

		return _cadreDesignationLocalService.getCadreDesignations();
	}

	/**
	 * Returns a range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of cadre designations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CadreDesignation>
		getCadreDesignations(int start, int end) {

		return _cadreDesignationLocalService.getCadreDesignations(start, end);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CadreDesignation>
		getCadreDesignationsByCadreId(long cadreId) {

		return _cadreDesignationLocalService.getCadreDesignationsByCadreId(
			cadreId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.CadreDesignation>
		getCadreDesignationsByDesignationId(long designationId) {

		return _cadreDesignationLocalService.
			getCadreDesignationsByDesignationId(designationId);
	}

	/**
	 * Returns the number of cadre designations.
	 *
	 * @return the number of cadre designations
	 */
	@Override
	public int getCadreDesignationsCount() {
		return _cadreDesignationLocalService.getCadreDesignationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cadreDesignationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cadreDesignationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreDesignationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cadre designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadreDesignation the cadre designation
	 * @return the cadre designation that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.CadreDesignation
		updateCadreDesignation(
			com.adjecti.mdm.liferay.model.CadreDesignation cadreDesignation) {

		return _cadreDesignationLocalService.updateCadreDesignation(
			cadreDesignation);
	}

	@Override
	public CadreDesignationLocalService getWrappedService() {
		return _cadreDesignationLocalService;
	}

	@Override
	public void setWrappedService(
		CadreDesignationLocalService cadreDesignationLocalService) {

		_cadreDesignationLocalService = cadreDesignationLocalService;
	}

	private CadreDesignationLocalService _cadreDesignationLocalService;

}