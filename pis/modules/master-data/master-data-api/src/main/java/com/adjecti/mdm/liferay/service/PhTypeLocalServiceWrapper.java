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
 * Provides a wrapper for {@link PhTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhTypeLocalService
 * @generated
 */
public class PhTypeLocalServiceWrapper
	implements PhTypeLocalService, ServiceWrapper<PhTypeLocalService> {

	public PhTypeLocalServiceWrapper(PhTypeLocalService phTypeLocalService) {
		_phTypeLocalService = phTypeLocalService;
	}

	/**
	 * Adds the ph type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phType the ph type
	 * @return the ph type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType addPhType(
		com.adjecti.mdm.liferay.model.PhType phType) {

		return _phTypeLocalService.addPhType(phType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new ph type with the primary key. Does not add the ph type to the database.
	 *
	 * @param phTypeId the primary key for the new ph type
	 * @return the new ph type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType createPhType(long phTypeId) {
		return _phTypeLocalService.createPhType(phTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ph type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type that was removed
	 * @throws PortalException if a ph type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType deletePhType(long phTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phTypeLocalService.deletePhType(phTypeId);
	}

	/**
	 * Deletes the ph type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phType the ph type
	 * @return the ph type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType deletePhType(
		com.adjecti.mdm.liferay.model.PhType phType) {

		return _phTypeLocalService.deletePhType(phType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phTypeLocalService.dynamicQuery();
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

		return _phTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PhTypeModelImpl</code>.
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

		return _phTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PhTypeModelImpl</code>.
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

		return _phTypeLocalService.dynamicQuery(
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

		return _phTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PhType fetchPhType(long phTypeId) {
		return _phTypeLocalService.fetchPhType(phTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ph type with the primary key.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type
	 * @throws PortalException if a ph type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType getPhType(long phTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phTypeLocalService.getPhType(phTypeId);
	}

	/**
	 * Returns a range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @return the range of ph types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PhType> getPhTypes(
		int start, int end) {

		return _phTypeLocalService.getPhTypes(start, end);
	}

	/**
	 * Returns the number of ph types.
	 *
	 * @return the number of ph types
	 */
	@Override
	public int getPhTypesCount() {
		return _phTypeLocalService.getPhTypesCount();
	}

	/**
	 * Updates the ph type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phType the ph type
	 * @return the ph type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PhType updatePhType(
		com.adjecti.mdm.liferay.model.PhType phType) {

		return _phTypeLocalService.updatePhType(phType);
	}

	@Override
	public PhTypeLocalService getWrappedService() {
		return _phTypeLocalService;
	}

	@Override
	public void setWrappedService(PhTypeLocalService phTypeLocalService) {
		_phTypeLocalService = phTypeLocalService;
	}

	private PhTypeLocalService _phTypeLocalService;

}