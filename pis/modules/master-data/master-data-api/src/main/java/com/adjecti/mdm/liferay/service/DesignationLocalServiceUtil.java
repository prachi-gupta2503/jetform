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
 * Provides the local service utility for Designation. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.DesignationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationLocalService
 * @generated
 */
public class DesignationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.DesignationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was added
	 */
	public static com.adjecti.mdm.liferay.model.Designation addDesignation(
		com.adjecti.mdm.liferay.model.Designation designation) {

		return getService().addDesignation(designation);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	public static com.adjecti.mdm.liferay.model.Designation createDesignation(
		long designationId) {

		return getService().createDesignation(designationId);
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
	 * Deletes the designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was removed
	 */
	public static com.adjecti.mdm.liferay.model.Designation deleteDesignation(
		com.adjecti.mdm.liferay.model.Designation designation) {

		return getService().deleteDesignation(designation);
	}

	/**
	 * Deletes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws PortalException if a designation with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.Designation deleteDesignation(
			long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDesignation(designationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModelImpl</code>.
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

	public static com.adjecti.mdm.liferay.model.Designation fetchDesignation(
		long designationId) {

		return getService().fetchDesignation(designationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getByDesignationGroup(String designationGroupName) {

		return getService().getByDesignationGroup(designationGroupName);
	}

	/**
	 * Returns the designation with the primary key.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws PortalException if a designation with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.Designation getDesignation(
			long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDesignation(designationId);
	}

	public static com.adjecti.mdm.liferay.model.Designation
		getDesignationByCode(String code) {

		return getService().getDesignationByCode(code);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationByName(String designationName) {

		return getService().getDesignationByName(designationName);
	}

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignations(int start, int end) {

		return getService().getDesignations(start, end);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByCadreId(long cadreId) {

		return getService().getDesignationsByCadreId(cadreId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationClassId(long designationClassId) {

		return getService().getDesignationsByDesignationClassId(
			designationClassId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationGroupId(long designationGroupId) {

		return getService().getDesignationsByDesignationGroupId(
			designationGroupId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByGradeId(long gradeId) {

		return getService().getDesignationsByGradeId(gradeId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByStatus(int status) {

		return getService().getDesignationsByStatus(status);
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	public static int getDesignationsCount() {
		return getService().getDesignationsCount();
	}

	public static int getDesignationsCountByDesignationClassId(
		long designationClassId) {

		return getService().getDesignationsCountByDesignationClassId(
			designationClassId);
	}

	public static int getDesignationsCountByDesignationGroupId(
		long designationGroupId, boolean deleted) {

		return getService().getDesignationsCountByDesignationGroupId(
			designationGroupId, deleted);
	}

	public static int getDesignationsCountByGradeId(long gradeId) {
		return getService().getDesignationsCountByGradeId(gradeId);
	}

	public static com.adjecti.mdm.liferay.model.Grade getGradesByDesignationId(
		long designationId) {

		return getService().getGradesByDesignationId(designationId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Updates the designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was updated
	 */
	public static com.adjecti.mdm.liferay.model.Designation updateDesignation(
		com.adjecti.mdm.liferay.model.Designation designation) {

		return getService().updateDesignation(designation);
	}

	public static DesignationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationLocalService, DesignationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DesignationLocalService.class);

		ServiceTracker<DesignationLocalService, DesignationLocalService>
			serviceTracker =
				new ServiceTracker
					<DesignationLocalService, DesignationLocalService>(
						bundle.getBundleContext(),
						DesignationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}