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
 * Provides a wrapper for {@link VerificationTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificationTypeLocalService
 * @generated
 */
public class VerificationTypeLocalServiceWrapper
	implements ServiceWrapper<VerificationTypeLocalService>,
			   VerificationTypeLocalService {

	public VerificationTypeLocalServiceWrapper(
		VerificationTypeLocalService verificationTypeLocalService) {

		_verificationTypeLocalService = verificationTypeLocalService;
	}

	/**
	 * Adds the verification type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verificationType the verification type
	 * @return the verification type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType addVerificationType(
		com.adjecti.mdm.liferay.model.VerificationType verificationType) {

		return _verificationTypeLocalService.addVerificationType(
			verificationType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificationTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new verification type with the primary key. Does not add the verification type to the database.
	 *
	 * @param verificationTypeId the primary key for the new verification type
	 * @return the new verification type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType
		createVerificationType(long verificationTypeId) {

		return _verificationTypeLocalService.createVerificationType(
			verificationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificationTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the verification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type that was removed
	 * @throws PortalException if a verification type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType
			deleteVerificationType(long verificationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificationTypeLocalService.deleteVerificationType(
			verificationTypeId);
	}

	/**
	 * Deletes the verification type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verificationType the verification type
	 * @return the verification type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType
		deleteVerificationType(
			com.adjecti.mdm.liferay.model.VerificationType verificationType) {

		return _verificationTypeLocalService.deleteVerificationType(
			verificationType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _verificationTypeLocalService.dynamicQuery();
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

		return _verificationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.VerificationTypeModelImpl</code>.
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

		return _verificationTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.VerificationTypeModelImpl</code>.
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

		return _verificationTypeLocalService.dynamicQuery(
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

		return _verificationTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _verificationTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.VerificationType fetchVerificationType(
		long verificationTypeId) {

		return _verificationTypeLocalService.fetchVerificationType(
			verificationTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _verificationTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _verificationTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificationTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the verification type with the primary key.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type
	 * @throws PortalException if a verification type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType getVerificationType(
			long verificationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificationTypeLocalService.getVerificationType(
			verificationTypeId);
	}

	/**
	 * Returns a range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @return the range of verification types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.VerificationType>
		getVerificationTypes(int start, int end) {

		return _verificationTypeLocalService.getVerificationTypes(start, end);
	}

	/**
	 * Returns the number of verification types.
	 *
	 * @return the number of verification types
	 */
	@Override
	public int getVerificationTypesCount() {
		return _verificationTypeLocalService.getVerificationTypesCount();
	}

	/**
	 * Updates the verification type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verificationType the verification type
	 * @return the verification type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.VerificationType
		updateVerificationType(
			com.adjecti.mdm.liferay.model.VerificationType verificationType) {

		return _verificationTypeLocalService.updateVerificationType(
			verificationType);
	}

	@Override
	public VerificationTypeLocalService getWrappedService() {
		return _verificationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		VerificationTypeLocalService verificationTypeLocalService) {

		_verificationTypeLocalService = verificationTypeLocalService;
	}

	private VerificationTypeLocalService _verificationTypeLocalService;

}