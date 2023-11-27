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
 * Provides a wrapper for {@link UnitTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UnitTypeLocalService
 * @generated
 */
public class UnitTypeLocalServiceWrapper
	implements ServiceWrapper<UnitTypeLocalService>, UnitTypeLocalService {

	public UnitTypeLocalServiceWrapper(
		UnitTypeLocalService unitTypeLocalService) {

		_unitTypeLocalService = unitTypeLocalService;
	}

	/**
	 * Adds the unit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UnitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @return the unit type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType addUnitType(
		com.adjecti.mdm.liferay.model.UnitType unitType) {

		return _unitTypeLocalService.addUnitType(unitType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new unit type with the primary key. Does not add the unit type to the database.
	 *
	 * @param unitTypeId the primary key for the new unit type
	 * @return the new unit type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType createUnitType(
		long unitTypeId) {

		return _unitTypeLocalService.createUnitType(unitTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the unit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UnitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type that was removed
	 * @throws PortalException if a unit type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType deleteUnitType(
			long unitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitTypeLocalService.deleteUnitType(unitTypeId);
	}

	/**
	 * Deletes the unit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UnitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @return the unit type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType deleteUnitType(
		com.adjecti.mdm.liferay.model.UnitType unitType) {

		return _unitTypeLocalService.deleteUnitType(unitType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _unitTypeLocalService.dynamicQuery();
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

		return _unitTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.UnitTypeModelImpl</code>.
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

		return _unitTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.UnitTypeModelImpl</code>.
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

		return _unitTypeLocalService.dynamicQuery(
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

		return _unitTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _unitTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.UnitType fetchUnitType(
		long unitTypeId) {

		return _unitTypeLocalService.fetchUnitType(unitTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _unitTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _unitTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _unitTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the unit type with the primary key.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type
	 * @throws PortalException if a unit type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType getUnitType(long unitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _unitTypeLocalService.getUnitType(unitTypeId);
	}

	/**
	 * Returns a range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @return the range of unit types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.UnitType> getUnitTypes(
		int start, int end) {

		return _unitTypeLocalService.getUnitTypes(start, end);
	}

	/**
	 * Returns the number of unit types.
	 *
	 * @return the number of unit types
	 */
	@Override
	public int getUnitTypesCount() {
		return _unitTypeLocalService.getUnitTypesCount();
	}

	/**
	 * Updates the unit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UnitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @return the unit type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.UnitType updateUnitType(
		com.adjecti.mdm.liferay.model.UnitType unitType) {

		return _unitTypeLocalService.updateUnitType(unitType);
	}

	@Override
	public UnitTypeLocalService getWrappedService() {
		return _unitTypeLocalService;
	}

	@Override
	public void setWrappedService(UnitTypeLocalService unitTypeLocalService) {
		_unitTypeLocalService = unitTypeLocalService;
	}

	private UnitTypeLocalService _unitTypeLocalService;

}