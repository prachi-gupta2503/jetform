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

package com.adjecti.pis.liferay.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EmployeeDigitalSignature. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeDigitalSignatureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignatureLocalService
 * @generated
 */
public class EmployeeDigitalSignatureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeDigitalSignatureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee digital signature to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		addEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return getService().addEmployeeDigitalSignature(
			employeeDigitalSignature);
	}

	/**
	 * Creates a new employee digital signature with the primary key. Does not add the employee digital signature to the database.
	 *
	 * @param employeeDigitalSignatureId the primary key for the new employee digital signature
	 * @return the new employee digital signature
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		createEmployeeDigitalSignature(long employeeDigitalSignatureId) {

		return getService().createEmployeeDigitalSignature(
			employeeDigitalSignatureId);
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
	 * Deletes the employee digital signature from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		deleteEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return getService().deleteEmployeeDigitalSignature(
			employeeDigitalSignature);
	}

	/**
	 * Deletes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws PortalException if a employee digital signature with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
			deleteEmployeeDigitalSignature(long employeeDigitalSignatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeDigitalSignature(
			employeeDigitalSignatureId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		fetchEmployeeDigitalSignature(long employeeDigitalSignatureId) {

		return getService().fetchEmployeeDigitalSignature(
			employeeDigitalSignatureId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee digital signature with the primary key.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws PortalException if a employee digital signature with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
			getEmployeeDigitalSignature(long employeeDigitalSignatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeDigitalSignature(
			employeeDigitalSignatureId);
	}

	/**
	 * Returns a range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of employee digital signatures
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeDigitalSignature>
			getEmployeeDigitalSignatures(int start, int end) {

		return getService().getEmployeeDigitalSignatures(start, end);
	}

	/**
	 * Returns the number of employee digital signatures.
	 *
	 * @return the number of employee digital signatures
	 */
	public static int getEmployeeDigitalSignaturesCount() {
		return getService().getEmployeeDigitalSignaturesCount();
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
	 * Updates the employee digital signature in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		updateEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return getService().updateEmployeeDigitalSignature(
			employeeDigitalSignature);
	}

	public static EmployeeDigitalSignatureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDigitalSignatureLocalService,
		 EmployeeDigitalSignatureLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDigitalSignatureLocalService.class);

		ServiceTracker
			<EmployeeDigitalSignatureLocalService,
			 EmployeeDigitalSignatureLocalService> serviceTracker =
				new ServiceTracker
					<EmployeeDigitalSignatureLocalService,
					 EmployeeDigitalSignatureLocalService>(
						 bundle.getBundleContext(),
						 EmployeeDigitalSignatureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}