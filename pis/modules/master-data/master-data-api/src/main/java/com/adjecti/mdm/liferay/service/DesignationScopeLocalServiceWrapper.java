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
 * Provides a wrapper for {@link DesignationScopeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationScopeLocalService
 * @generated
 */
public class DesignationScopeLocalServiceWrapper
	implements DesignationScopeLocalService,
			   ServiceWrapper<DesignationScopeLocalService> {

	public DesignationScopeLocalServiceWrapper(
		DesignationScopeLocalService designationScopeLocalService) {

		_designationScopeLocalService = designationScopeLocalService;
	}

	/**
	 * Adds the designation scope to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationScopeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationScope the designation scope
	 * @return the designation scope that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope addDesignationScope(
		com.adjecti.mdm.liferay.model.DesignationScope designationScope) {

		return _designationScopeLocalService.addDesignationScope(
			designationScope);
	}

	/**
	 * Creates a new designation scope with the primary key. Does not add the designation scope to the database.
	 *
	 * @param designationScopePK the primary key for the new designation scope
	 * @return the new designation scope
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope
		createDesignationScope(
			com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
				designationScopePK) {

		return _designationScopeLocalService.createDesignationScope(
			designationScopePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationScopeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the designation scope from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationScopeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationScope the designation scope
	 * @return the designation scope that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope
		deleteDesignationScope(
			com.adjecti.mdm.liferay.model.DesignationScope designationScope) {

		return _designationScopeLocalService.deleteDesignationScope(
			designationScope);
	}

	/**
	 * Deletes the designation scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationScopeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope that was removed
	 * @throws PortalException if a designation scope with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope
			deleteDesignationScope(
				com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
					designationScopePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationScopeLocalService.deleteDesignationScope(
			designationScopePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationScopeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationScopeLocalService.dynamicQuery();
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

		return _designationScopeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationScopeModelImpl</code>.
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

		return _designationScopeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationScopeModelImpl</code>.
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

		return _designationScopeLocalService.dynamicQuery(
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

		return _designationScopeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationScopeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope fetchDesignationScope(
		com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
			designationScopePK) {

		return _designationScopeLocalService.fetchDesignationScope(
			designationScopePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationScopeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation scope with the primary key.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope
	 * @throws PortalException if a designation scope with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope getDesignationScope(
			com.adjecti.mdm.liferay.service.persistence.DesignationScopePK
				designationScopePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationScopeLocalService.getDesignationScope(
			designationScopePK);
	}

	/**
	 * Returns a range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of designation scopes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DesignationScope>
		getDesignationScopes(int start, int end) {

		return _designationScopeLocalService.getDesignationScopes(start, end);
	}

	/**
	 * Returns the number of designation scopes.
	 *
	 * @return the number of designation scopes
	 */
	@Override
	public int getDesignationScopesCount() {
		return _designationScopeLocalService.getDesignationScopesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationScopeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationScopeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationScopeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation scope in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationScopeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationScope the designation scope
	 * @return the designation scope that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationScope
		updateDesignationScope(
			com.adjecti.mdm.liferay.model.DesignationScope designationScope) {

		return _designationScopeLocalService.updateDesignationScope(
			designationScope);
	}

	@Override
	public DesignationScopeLocalService getWrappedService() {
		return _designationScopeLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationScopeLocalService designationScopeLocalService) {

		_designationScopeLocalService = designationScopeLocalService;
	}

	private DesignationScopeLocalService _designationScopeLocalService;

}