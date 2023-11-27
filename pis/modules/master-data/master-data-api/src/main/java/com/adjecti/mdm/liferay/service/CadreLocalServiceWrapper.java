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
 * Provides a wrapper for {@link CadreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CadreLocalService
 * @generated
 */
public class CadreLocalServiceWrapper
	implements CadreLocalService, ServiceWrapper<CadreLocalService> {

	public CadreLocalServiceWrapper(CadreLocalService cadreLocalService) {
		_cadreLocalService = cadreLocalService;
	}

	/**
	 * Adds the cadre to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadre the cadre
	 * @return the cadre that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre addCadre(
		com.adjecti.mdm.liferay.model.Cadre cadre) {

		return _cadreLocalService.addCadre(cadre);
	}

	/**
	 * Creates a new cadre with the primary key. Does not add the cadre to the database.
	 *
	 * @param cadreId the primary key for the new cadre
	 * @return the new cadre
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre createCadre(long cadreId) {
		return _cadreLocalService.createCadre(cadreId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cadre from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadre the cadre
	 * @return the cadre that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre deleteCadre(
		com.adjecti.mdm.liferay.model.Cadre cadre) {

		return _cadreLocalService.deleteCadre(cadre);
	}

	/**
	 * Deletes the cadre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre that was removed
	 * @throws PortalException if a cadre with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre deleteCadre(long cadreId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreLocalService.deleteCadre(cadreId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cadreLocalService.dynamicQuery();
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

		return _cadreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreModelImpl</code>.
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

		return _cadreLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreModelImpl</code>.
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

		return _cadreLocalService.dynamicQuery(
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

		return _cadreLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cadreLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Cadre fetchCadre(long cadreId) {
		return _cadreLocalService.fetchCadre(cadreId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cadreLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cadre with the primary key.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre
	 * @throws PortalException if a cadre with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre getCadre(long cadreId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreLocalService.getCadre(cadreId);
	}

	/**
	 * Returns a range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of cadres
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Cadre> getCadres(
		int start, int end) {

		return _cadreLocalService.getCadres(start, end);
	}

	/**
	 * Returns the number of cadres.
	 *
	 * @return the number of cadres
	 */
	@Override
	public int getCadresCount() {
		return _cadreLocalService.getCadresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cadreLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cadreLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cadreLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cadre in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CadreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cadre the cadre
	 * @return the cadre that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Cadre updateCadre(
		com.adjecti.mdm.liferay.model.Cadre cadre) {

		return _cadreLocalService.updateCadre(cadre);
	}

	@Override
	public CadreLocalService getWrappedService() {
		return _cadreLocalService;
	}

	@Override
	public void setWrappedService(CadreLocalService cadreLocalService) {
		_cadreLocalService = cadreLocalService;
	}

	private CadreLocalService _cadreLocalService;

}