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
 * Provides a wrapper for {@link SpecializationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecializationLocalService
 * @generated
 */
public class SpecializationLocalServiceWrapper
	implements ServiceWrapper<SpecializationLocalService>,
			   SpecializationLocalService {

	public SpecializationLocalServiceWrapper(
		SpecializationLocalService specializationLocalService) {

		_specializationLocalService = specializationLocalService;
	}

	/**
	 * Adds the specialization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecializationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialization the specialization
	 * @return the specialization that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization addSpecialization(
		com.adjecti.mdm.liferay.model.Specialization specialization) {

		return _specializationLocalService.addSpecialization(specialization);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specializationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new specialization with the primary key. Does not add the specialization to the database.
	 *
	 * @param specializationId the primary key for the new specialization
	 * @return the new specialization
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization createSpecialization(
		long specializationId) {

		return _specializationLocalService.createSpecialization(
			specializationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specializationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the specialization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecializationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specializationId the primary key of the specialization
	 * @return the specialization that was removed
	 * @throws PortalException if a specialization with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization deleteSpecialization(
			long specializationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specializationLocalService.deleteSpecialization(
			specializationId);
	}

	/**
	 * Deletes the specialization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecializationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialization the specialization
	 * @return the specialization that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization deleteSpecialization(
		com.adjecti.mdm.liferay.model.Specialization specialization) {

		return _specializationLocalService.deleteSpecialization(specialization);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specializationLocalService.dynamicQuery();
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

		return _specializationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SpecializationModelImpl</code>.
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

		return _specializationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SpecializationModelImpl</code>.
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

		return _specializationLocalService.dynamicQuery(
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

		return _specializationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specializationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Specialization fetchSpecialization(
		long specializationId) {

		return _specializationLocalService.fetchSpecialization(
			specializationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specializationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specializationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specializationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specializationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the specialization with the primary key.
	 *
	 * @param specializationId the primary key of the specialization
	 * @return the specialization
	 * @throws PortalException if a specialization with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization getSpecialization(
			long specializationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specializationLocalService.getSpecialization(specializationId);
	}

	/**
	 * Returns a range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @return the range of specializations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Specialization>
		getSpecializations(int start, int end) {

		return _specializationLocalService.getSpecializations(start, end);
	}

	/**
	 * Returns the number of specializations.
	 *
	 * @return the number of specializations
	 */
	@Override
	public int getSpecializationsCount() {
		return _specializationLocalService.getSpecializationsCount();
	}

	/**
	 * Updates the specialization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecializationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialization the specialization
	 * @return the specialization that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Specialization updateSpecialization(
		com.adjecti.mdm.liferay.model.Specialization specialization) {

		return _specializationLocalService.updateSpecialization(specialization);
	}

	@Override
	public SpecializationLocalService getWrappedService() {
		return _specializationLocalService;
	}

	@Override
	public void setWrappedService(
		SpecializationLocalService specializationLocalService) {

		_specializationLocalService = specializationLocalService;
	}

	private SpecializationLocalService _specializationLocalService;

}