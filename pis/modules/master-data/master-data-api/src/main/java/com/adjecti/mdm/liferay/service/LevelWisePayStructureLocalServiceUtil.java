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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LevelWisePayStructure. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.LevelWisePayStructureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LevelWisePayStructureLocalService
 * @generated
 */
public class LevelWisePayStructureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.LevelWisePayStructureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the level wise pay structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelWisePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelWisePayStructure the level wise pay structure
	 * @return the level wise pay structure that was added
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
		addLevelWisePayStructure(
			com.adjecti.mdm.liferay.model.LevelWisePayStructure
				levelWisePayStructure) {

		return getService().addLevelWisePayStructure(levelWisePayStructure);
	}

	/**
	 * Creates a new level wise pay structure with the primary key. Does not add the level wise pay structure to the database.
	 *
	 * @param levelWisePayStructureId the primary key for the new level wise pay structure
	 * @return the new level wise pay structure
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
		createLevelWisePayStructure(long levelWisePayStructureId) {

		return getService().createLevelWisePayStructure(
			levelWisePayStructureId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the level wise pay structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelWisePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelWisePayStructure the level wise pay structure
	 * @return the level wise pay structure that was removed
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
		deleteLevelWisePayStructure(
			com.adjecti.mdm.liferay.model.LevelWisePayStructure
				levelWisePayStructure) {

		return getService().deleteLevelWisePayStructure(levelWisePayStructure);
	}

	/**
	 * Deletes the level wise pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelWisePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelWisePayStructureId the primary key of the level wise pay structure
	 * @return the level wise pay structure that was removed
	 * @throws PortalException if a level wise pay structure with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
			deleteLevelWisePayStructure(long levelWisePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLevelWisePayStructure(
			levelWisePayStructureId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
		fetchLevelWisePayStructure(long levelWisePayStructureId) {

		return getService().fetchLevelWisePayStructure(levelWisePayStructureId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the level wise pay structure with the primary key.
	 *
	 * @param levelWisePayStructureId the primary key of the level wise pay structure
	 * @return the level wise pay structure
	 * @throws PortalException if a level wise pay structure with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
			getLevelWisePayStructure(long levelWisePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLevelWisePayStructure(levelWisePayStructureId);
	}

	/**
	 * Returns a range of all the level wise pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level wise pay structures
	 * @param end the upper bound of the range of level wise pay structures (not inclusive)
	 * @return the range of level wise pay structures
	 */
	public static java.util.List
		<com.adjecti.mdm.liferay.model.LevelWisePayStructure>
			getLevelWisePayStructures(int start, int end) {

		return getService().getLevelWisePayStructures(start, end);
	}

	/**
	 * Returns the number of level wise pay structures.
	 *
	 * @return the number of level wise pay structures
	 */
	public static int getLevelWisePayStructuresCount() {
		return getService().getLevelWisePayStructuresCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the level wise pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelWisePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelWisePayStructure the level wise pay structure
	 * @return the level wise pay structure that was updated
	 */
	public static com.adjecti.mdm.liferay.model.LevelWisePayStructure
		updateLevelWisePayStructure(
			com.adjecti.mdm.liferay.model.LevelWisePayStructure
				levelWisePayStructure) {

		return getService().updateLevelWisePayStructure(levelWisePayStructure);
	}

	public static LevelWisePayStructureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LevelWisePayStructureLocalService, LevelWisePayStructureLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LevelWisePayStructureLocalService.class);

		ServiceTracker
			<LevelWisePayStructureLocalService,
			 LevelWisePayStructureLocalService> serviceTracker =
				new ServiceTracker
					<LevelWisePayStructureLocalService,
					 LevelWisePayStructureLocalService>(
						 bundle.getBundleContext(),
						 LevelWisePayStructureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}