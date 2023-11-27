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
 * Provides a wrapper for {@link TimeFrequencyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimeFrequencyLocalService
 * @generated
 */
public class TimeFrequencyLocalServiceWrapper
	implements ServiceWrapper<TimeFrequencyLocalService>,
			   TimeFrequencyLocalService {

	public TimeFrequencyLocalServiceWrapper(
		TimeFrequencyLocalService timeFrequencyLocalService) {

		_timeFrequencyLocalService = timeFrequencyLocalService;
	}

	/**
	 * Adds the time frequency to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeFrequencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeFrequency the time frequency
	 * @return the time frequency that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency addTimeFrequency(
		com.adjecti.mdm.liferay.model.TimeFrequency timeFrequency) {

		return _timeFrequencyLocalService.addTimeFrequency(timeFrequency);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _timeFrequencyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new time frequency with the primary key. Does not add the time frequency to the database.
	 *
	 * @param timeFrequencyId the primary key for the new time frequency
	 * @return the new time frequency
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency createTimeFrequency(
		long timeFrequencyId) {

		return _timeFrequencyLocalService.createTimeFrequency(timeFrequencyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _timeFrequencyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the time frequency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeFrequencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency that was removed
	 * @throws PortalException if a time frequency with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency deleteTimeFrequency(
			long timeFrequencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _timeFrequencyLocalService.deleteTimeFrequency(timeFrequencyId);
	}

	/**
	 * Deletes the time frequency from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeFrequencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeFrequency the time frequency
	 * @return the time frequency that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency deleteTimeFrequency(
		com.adjecti.mdm.liferay.model.TimeFrequency timeFrequency) {

		return _timeFrequencyLocalService.deleteTimeFrequency(timeFrequency);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timeFrequencyLocalService.dynamicQuery();
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

		return _timeFrequencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TimeFrequencyModelImpl</code>.
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

		return _timeFrequencyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TimeFrequencyModelImpl</code>.
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

		return _timeFrequencyLocalService.dynamicQuery(
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

		return _timeFrequencyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _timeFrequencyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency fetchTimeFrequency(
		long timeFrequencyId) {

		return _timeFrequencyLocalService.fetchTimeFrequency(timeFrequencyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _timeFrequencyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _timeFrequencyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _timeFrequencyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _timeFrequencyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @return the range of time frequencies
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.TimeFrequency>
		getTimeFrequencies(int start, int end) {

		return _timeFrequencyLocalService.getTimeFrequencies(start, end);
	}

	/**
	 * Returns the number of time frequencies.
	 *
	 * @return the number of time frequencies
	 */
	@Override
	public int getTimeFrequenciesCount() {
		return _timeFrequencyLocalService.getTimeFrequenciesCount();
	}

	/**
	 * Returns the time frequency with the primary key.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency
	 * @throws PortalException if a time frequency with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency getTimeFrequency(
			long timeFrequencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _timeFrequencyLocalService.getTimeFrequency(timeFrequencyId);
	}

	/**
	 * Updates the time frequency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeFrequencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeFrequency the time frequency
	 * @return the time frequency that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.TimeFrequency updateTimeFrequency(
		com.adjecti.mdm.liferay.model.TimeFrequency timeFrequency) {

		return _timeFrequencyLocalService.updateTimeFrequency(timeFrequency);
	}

	@Override
	public TimeFrequencyLocalService getWrappedService() {
		return _timeFrequencyLocalService;
	}

	@Override
	public void setWrappedService(
		TimeFrequencyLocalService timeFrequencyLocalService) {

		_timeFrequencyLocalService = timeFrequencyLocalService;
	}

	private TimeFrequencyLocalService _timeFrequencyLocalService;

}