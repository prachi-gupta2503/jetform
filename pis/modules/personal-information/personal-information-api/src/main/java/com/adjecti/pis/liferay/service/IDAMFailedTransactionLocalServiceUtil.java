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
 * Provides the local service utility for IDAMFailedTransaction. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.IDAMFailedTransactionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IDAMFailedTransactionLocalService
 * @generated
 */
public class IDAMFailedTransactionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.IDAMFailedTransactionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the idam failed transaction to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IDAMFailedTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idamFailedTransaction the idam failed transaction
	 * @return the idam failed transaction that was added
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
		addIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return getService().addIDAMFailedTransaction(idamFailedTransaction);
	}

	/**
	 * Creates a new idam failed transaction with the primary key. Does not add the idam failed transaction to the database.
	 *
	 * @param idamFailedTransactionId the primary key for the new idam failed transaction
	 * @return the new idam failed transaction
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
		createIDAMFailedTransaction(long idamFailedTransactionId) {

		return getService().createIDAMFailedTransaction(
			idamFailedTransactionId);
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
	 * Deletes the idam failed transaction from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IDAMFailedTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idamFailedTransaction the idam failed transaction
	 * @return the idam failed transaction that was removed
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
		deleteIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return getService().deleteIDAMFailedTransaction(idamFailedTransaction);
	}

	public static void deleteIdamFailedTransaction(
		long idamFailedTransactionId) {

		getService().deleteIdamFailedTransaction(idamFailedTransactionId);
	}

	/**
	 * Deletes the idam failed transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IDAMFailedTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction that was removed
	 * @throws PortalException if a idam failed transaction with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
			deleteIDAMFailedTransaction(long idamFailedTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIDAMFailedTransaction(
			idamFailedTransactionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.IDAMFailedTransactionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.IDAMFailedTransactionModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
		fetchIDAMFailedTransaction(long idamFailedTransactionId) {

		return getService().fetchIDAMFailedTransaction(idamFailedTransactionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the idam failed transaction with the primary key.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction
	 * @throws PortalException if a idam failed transaction with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
			getIDAMFailedTransaction(long idamFailedTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIDAMFailedTransaction(idamFailedTransactionId);
	}

	/**
	 * Returns a range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @return the range of idam failed transactions
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.IDAMFailedTransaction>
			getIDAMFailedTransactions(int start, int end) {

		return getService().getIDAMFailedTransactions(start, end);
	}

	/**
	 * Returns the number of idam failed transactions.
	 *
	 * @return the number of idam failed transactions
	 */
	public static int getIDAMFailedTransactionsCount() {
		return getService().getIDAMFailedTransactionsCount();
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

	public static boolean updateIdamEmployee(long idamFailedTransactionId) {
		return getService().updateIdamEmployee(idamFailedTransactionId);
	}

	/**
	 * Updates the idam failed transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IDAMFailedTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idamFailedTransaction the idam failed transaction
	 * @return the idam failed transaction that was updated
	 */
	public static com.adjecti.pis.liferay.model.IDAMFailedTransaction
		updateIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return getService().updateIDAMFailedTransaction(idamFailedTransaction);
	}

	public static IDAMFailedTransactionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IDAMFailedTransactionLocalService, IDAMFailedTransactionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			IDAMFailedTransactionLocalService.class);

		ServiceTracker
			<IDAMFailedTransactionLocalService,
			 IDAMFailedTransactionLocalService> serviceTracker =
				new ServiceTracker
					<IDAMFailedTransactionLocalService,
					 IDAMFailedTransactionLocalService>(
						 bundle.getBundleContext(),
						 IDAMFailedTransactionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}