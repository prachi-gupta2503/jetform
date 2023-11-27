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
 * Provides a wrapper for {@link DiseaseTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DiseaseTypeLocalService
 * @generated
 */
public class DiseaseTypeLocalServiceWrapper
	implements DiseaseTypeLocalService,
			   ServiceWrapper<DiseaseTypeLocalService> {

	public DiseaseTypeLocalServiceWrapper(
		DiseaseTypeLocalService diseaseTypeLocalService) {

		_diseaseTypeLocalService = diseaseTypeLocalService;
	}

	/**
	 * Adds the disease type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param diseaseType the disease type
	 * @return the disease type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType addDiseaseType(
		com.adjecti.mdm.liferay.model.DiseaseType diseaseType) {

		return _diseaseTypeLocalService.addDiseaseType(diseaseType);
	}

	/**
	 * Creates a new disease type with the primary key. Does not add the disease type to the database.
	 *
	 * @param diseaseTypeId the primary key for the new disease type
	 * @return the new disease type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType createDiseaseType(
		long diseaseTypeId) {

		return _diseaseTypeLocalService.createDiseaseType(diseaseTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the disease type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param diseaseType the disease type
	 * @return the disease type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType deleteDiseaseType(
		com.adjecti.mdm.liferay.model.DiseaseType diseaseType) {

		return _diseaseTypeLocalService.deleteDiseaseType(diseaseType);
	}

	/**
	 * Deletes the disease type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param diseaseTypeId the primary key of the disease type
	 * @return the disease type that was removed
	 * @throws PortalException if a disease type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType deleteDiseaseType(
			long diseaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseTypeLocalService.deleteDiseaseType(diseaseTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _diseaseTypeLocalService.dynamicQuery();
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

		return _diseaseTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseTypeModelImpl</code>.
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

		return _diseaseTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseTypeModelImpl</code>.
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

		return _diseaseTypeLocalService.dynamicQuery(
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

		return _diseaseTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _diseaseTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType fetchDiseaseType(
		long diseaseTypeId) {

		return _diseaseTypeLocalService.fetchDiseaseType(diseaseTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _diseaseTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the disease type with the primary key.
	 *
	 * @param diseaseTypeId the primary key of the disease type
	 * @return the disease type
	 * @throws PortalException if a disease type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType getDiseaseType(
			long diseaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseTypeLocalService.getDiseaseType(diseaseTypeId);
	}

	/**
	 * Returns a range of all the disease types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease types
	 * @param end the upper bound of the range of disease types (not inclusive)
	 * @return the range of disease types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DiseaseType>
		getDiseaseTypes(int start, int end) {

		return _diseaseTypeLocalService.getDiseaseTypes(start, end);
	}

	/**
	 * Returns the number of disease types.
	 *
	 * @return the number of disease types
	 */
	@Override
	public int getDiseaseTypesCount() {
		return _diseaseTypeLocalService.getDiseaseTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _diseaseTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _diseaseTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the disease type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param diseaseType the disease type
	 * @return the disease type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DiseaseType updateDiseaseType(
		com.adjecti.mdm.liferay.model.DiseaseType diseaseType) {

		return _diseaseTypeLocalService.updateDiseaseType(diseaseType);
	}

	@Override
	public DiseaseTypeLocalService getWrappedService() {
		return _diseaseTypeLocalService;
	}

	@Override
	public void setWrappedService(
		DiseaseTypeLocalService diseaseTypeLocalService) {

		_diseaseTypeLocalService = diseaseTypeLocalService;
	}

	private DiseaseTypeLocalService _diseaseTypeLocalService;

}