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
 * Provides a wrapper for {@link PersonalNoPrefixLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalNoPrefixLocalService
 * @generated
 */
public class PersonalNoPrefixLocalServiceWrapper
	implements PersonalNoPrefixLocalService,
			   ServiceWrapper<PersonalNoPrefixLocalService> {

	public PersonalNoPrefixLocalServiceWrapper(
		PersonalNoPrefixLocalService personalNoPrefixLocalService) {

		_personalNoPrefixLocalService = personalNoPrefixLocalService;
	}

	/**
	 * Adds the personal no prefix to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalNoPrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalNoPrefix the personal no prefix
	 * @return the personal no prefix that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix addPersonalNoPrefix(
		com.adjecti.mdm.liferay.model.PersonalNoPrefix personalNoPrefix) {

		return _personalNoPrefixLocalService.addPersonalNoPrefix(
			personalNoPrefix);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalNoPrefixLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new personal no prefix with the primary key. Does not add the personal no prefix to the database.
	 *
	 * @param personalNoPrefixId the primary key for the new personal no prefix
	 * @return the new personal no prefix
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix
		createPersonalNoPrefix(long personalNoPrefixId) {

		return _personalNoPrefixLocalService.createPersonalNoPrefix(
			personalNoPrefixId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalNoPrefixLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the personal no prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalNoPrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix that was removed
	 * @throws PortalException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix
			deletePersonalNoPrefix(long personalNoPrefixId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalNoPrefixLocalService.deletePersonalNoPrefix(
			personalNoPrefixId);
	}

	/**
	 * Deletes the personal no prefix from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalNoPrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalNoPrefix the personal no prefix
	 * @return the personal no prefix that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix
		deletePersonalNoPrefix(
			com.adjecti.mdm.liferay.model.PersonalNoPrefix personalNoPrefix) {

		return _personalNoPrefixLocalService.deletePersonalNoPrefix(
			personalNoPrefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personalNoPrefixLocalService.dynamicQuery();
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

		return _personalNoPrefixLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PersonalNoPrefixModelImpl</code>.
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

		return _personalNoPrefixLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PersonalNoPrefixModelImpl</code>.
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

		return _personalNoPrefixLocalService.dynamicQuery(
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

		return _personalNoPrefixLocalService.dynamicQueryCount(dynamicQuery);
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

		return _personalNoPrefixLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix fetchPersonalNoPrefix(
		long personalNoPrefixId) {

		return _personalNoPrefixLocalService.fetchPersonalNoPrefix(
			personalNoPrefixId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _personalNoPrefixLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _personalNoPrefixLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personalNoPrefixLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalNoPrefixLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the personal no prefix with the primary key.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix
	 * @throws PortalException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix getPersonalNoPrefix(
			long personalNoPrefixId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalNoPrefixLocalService.getPersonalNoPrefix(
			personalNoPrefixId);
	}

	/**
	 * Returns a range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @return the range of personal no prefixes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PersonalNoPrefix>
		getPersonalNoPrefixes(int start, int end) {

		return _personalNoPrefixLocalService.getPersonalNoPrefixes(start, end);
	}

	/**
	 * Returns the number of personal no prefixes.
	 *
	 * @return the number of personal no prefixes
	 */
	@Override
	public int getPersonalNoPrefixesCount() {
		return _personalNoPrefixLocalService.getPersonalNoPrefixesCount();
	}

	/**
	 * Updates the personal no prefix in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalNoPrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalNoPrefix the personal no prefix
	 * @return the personal no prefix that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PersonalNoPrefix
		updatePersonalNoPrefix(
			com.adjecti.mdm.liferay.model.PersonalNoPrefix personalNoPrefix) {

		return _personalNoPrefixLocalService.updatePersonalNoPrefix(
			personalNoPrefix);
	}

	@Override
	public PersonalNoPrefixLocalService getWrappedService() {
		return _personalNoPrefixLocalService;
	}

	@Override
	public void setWrappedService(
		PersonalNoPrefixLocalService personalNoPrefixLocalService) {

		_personalNoPrefixLocalService = personalNoPrefixLocalService;
	}

	private PersonalNoPrefixLocalService _personalNoPrefixLocalService;

}