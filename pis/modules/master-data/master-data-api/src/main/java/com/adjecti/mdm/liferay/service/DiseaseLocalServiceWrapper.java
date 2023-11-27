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
 * Provides a wrapper for {@link DiseaseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DiseaseLocalService
 * @generated
 */
public class DiseaseLocalServiceWrapper
	implements DiseaseLocalService, ServiceWrapper<DiseaseLocalService> {

	public DiseaseLocalServiceWrapper(DiseaseLocalService diseaseLocalService) {
		_diseaseLocalService = diseaseLocalService;
	}

	/**
	 * Adds the disease to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disease the disease
	 * @return the disease that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease addDisease(
		com.adjecti.mdm.liferay.model.Disease disease) {

		return _diseaseLocalService.addDisease(disease);
	}

	/**
	 * Creates a new disease with the primary key. Does not add the disease to the database.
	 *
	 * @param diseaseId the primary key for the new disease
	 * @return the new disease
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease createDisease(long diseaseId) {
		return _diseaseLocalService.createDisease(diseaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the disease from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disease the disease
	 * @return the disease that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease deleteDisease(
		com.adjecti.mdm.liferay.model.Disease disease) {

		return _diseaseLocalService.deleteDisease(disease);
	}

	/**
	 * Deletes the disease with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease that was removed
	 * @throws PortalException if a disease with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease deleteDisease(long diseaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseLocalService.deleteDisease(diseaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _diseaseLocalService.dynamicQuery();
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

		return _diseaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseModelImpl</code>.
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

		return _diseaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseModelImpl</code>.
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

		return _diseaseLocalService.dynamicQuery(
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

		return _diseaseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _diseaseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Disease fetchDisease(long diseaseId) {
		return _diseaseLocalService.fetchDisease(diseaseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _diseaseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the disease with the primary key.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease
	 * @throws PortalException if a disease with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease getDisease(long diseaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseLocalService.getDisease(diseaseId);
	}

	/**
	 * Returns a range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @return the range of diseases
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Disease> getDiseases(
		int start, int end) {

		return _diseaseLocalService.getDiseases(start, end);
	}

	/**
	 * Returns the number of diseases.
	 *
	 * @return the number of diseases
	 */
	@Override
	public int getDiseasesCount() {
		return _diseaseLocalService.getDiseasesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _diseaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _diseaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _diseaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the disease in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiseaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disease the disease
	 * @return the disease that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Disease updateDisease(
		com.adjecti.mdm.liferay.model.Disease disease) {

		return _diseaseLocalService.updateDisease(disease);
	}

	@Override
	public DiseaseLocalService getWrappedService() {
		return _diseaseLocalService;
	}

	@Override
	public void setWrappedService(DiseaseLocalService diseaseLocalService) {
		_diseaseLocalService = diseaseLocalService;
	}

	private DiseaseLocalService _diseaseLocalService;

}