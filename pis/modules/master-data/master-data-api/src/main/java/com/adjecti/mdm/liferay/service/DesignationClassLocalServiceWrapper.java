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
 * Provides a wrapper for {@link DesignationClassLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationClassLocalService
 * @generated
 */
public class DesignationClassLocalServiceWrapper
	implements DesignationClassLocalService,
			   ServiceWrapper<DesignationClassLocalService> {

	public DesignationClassLocalServiceWrapper(
		DesignationClassLocalService designationClassLocalService) {

		_designationClassLocalService = designationClassLocalService;
	}

	/**
	 * Adds the designation class to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationClassLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationClass the designation class
	 * @return the designation class that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass addDesignationClass(
		com.adjecti.mdm.liferay.model.DesignationClass designationClass) {

		return _designationClassLocalService.addDesignationClass(
			designationClass);
	}

	/**
	 * Creates a new designation class with the primary key. Does not add the designation class to the database.
	 *
	 * @param designationClassId the primary key for the new designation class
	 * @return the new designation class
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass
		createDesignationClass(long designationClassId) {

		return _designationClassLocalService.createDesignationClass(
			designationClassId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationClassLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the designation class from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationClassLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationClass the designation class
	 * @return the designation class that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass
		deleteDesignationClass(
			com.adjecti.mdm.liferay.model.DesignationClass designationClass) {

		return _designationClassLocalService.deleteDesignationClass(
			designationClass);
	}

	/**
	 * Deletes the designation class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationClassLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class that was removed
	 * @throws PortalException if a designation class with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass
			deleteDesignationClass(long designationClassId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationClassLocalService.deleteDesignationClass(
			designationClassId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationClassLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationClassLocalService.dynamicQuery();
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

		return _designationClassLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationClassModelImpl</code>.
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

		return _designationClassLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationClassModelImpl</code>.
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

		return _designationClassLocalService.dynamicQuery(
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

		return _designationClassLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationClassLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass fetchDesignationClass(
		long designationClassId) {

		return _designationClassLocalService.fetchDesignationClass(
			designationClassId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationClassLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation class with the primary key.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class
	 * @throws PortalException if a designation class with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass getDesignationClass(
			long designationClassId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationClassLocalService.getDesignationClass(
			designationClassId);
	}

	/**
	 * Returns a range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @return the range of designation classes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DesignationClass>
		getDesignationClasses(int start, int end) {

		return _designationClassLocalService.getDesignationClasses(start, end);
	}

	/**
	 * Returns the number of designation classes.
	 *
	 * @return the number of designation classes
	 */
	@Override
	public int getDesignationClassesCount() {
		return _designationClassLocalService.getDesignationClassesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationClassLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationClassLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationClassLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation class in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationClassLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationClass the designation class
	 * @return the designation class that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationClass
		updateDesignationClass(
			com.adjecti.mdm.liferay.model.DesignationClass designationClass) {

		return _designationClassLocalService.updateDesignationClass(
			designationClass);
	}

	@Override
	public DesignationClassLocalService getWrappedService() {
		return _designationClassLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationClassLocalService designationClassLocalService) {

		_designationClassLocalService = designationClassLocalService;
	}

	private DesignationClassLocalService _designationClassLocalService;

}