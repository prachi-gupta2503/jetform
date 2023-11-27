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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IDAMFailedTransactionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IDAMFailedTransactionLocalService
 * @generated
 */
public class IDAMFailedTransactionLocalServiceWrapper
	implements IDAMFailedTransactionLocalService,
			   ServiceWrapper<IDAMFailedTransactionLocalService> {

	public IDAMFailedTransactionLocalServiceWrapper(
		IDAMFailedTransactionLocalService idamFailedTransactionLocalService) {

		_idamFailedTransactionLocalService = idamFailedTransactionLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
		addIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return _idamFailedTransactionLocalService.addIDAMFailedTransaction(
			idamFailedTransaction);
	}

	/**
	 * Creates a new idam failed transaction with the primary key. Does not add the idam failed transaction to the database.
	 *
	 * @param idamFailedTransactionId the primary key for the new idam failed transaction
	 * @return the new idam failed transaction
	 */
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
		createIDAMFailedTransaction(long idamFailedTransactionId) {

		return _idamFailedTransactionLocalService.createIDAMFailedTransaction(
			idamFailedTransactionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idamFailedTransactionLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
		deleteIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return _idamFailedTransactionLocalService.deleteIDAMFailedTransaction(
			idamFailedTransaction);
	}

	@Override
	public void deleteIdamFailedTransaction(long idamFailedTransactionId) {
		_idamFailedTransactionLocalService.deleteIdamFailedTransaction(
			idamFailedTransactionId);
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
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
			deleteIDAMFailedTransaction(long idamFailedTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idamFailedTransactionLocalService.deleteIDAMFailedTransaction(
			idamFailedTransactionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idamFailedTransactionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _idamFailedTransactionLocalService.dynamicQuery();
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

		return _idamFailedTransactionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _idamFailedTransactionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _idamFailedTransactionLocalService.dynamicQuery(
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

		return _idamFailedTransactionLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _idamFailedTransactionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
		fetchIDAMFailedTransaction(long idamFailedTransactionId) {

		return _idamFailedTransactionLocalService.fetchIDAMFailedTransaction(
			idamFailedTransactionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _idamFailedTransactionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the idam failed transaction with the primary key.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction
	 * @throws PortalException if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
			getIDAMFailedTransaction(long idamFailedTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idamFailedTransactionLocalService.getIDAMFailedTransaction(
			idamFailedTransactionId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.IDAMFailedTransaction>
		getIDAMFailedTransactions(int start, int end) {

		return _idamFailedTransactionLocalService.getIDAMFailedTransactions(
			start, end);
	}

	/**
	 * Returns the number of idam failed transactions.
	 *
	 * @return the number of idam failed transactions
	 */
	@Override
	public int getIDAMFailedTransactionsCount() {
		return _idamFailedTransactionLocalService.
			getIDAMFailedTransactionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _idamFailedTransactionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _idamFailedTransactionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idamFailedTransactionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean updateIdamEmployee(long idamFailedTransactionId) {
		return _idamFailedTransactionLocalService.updateIdamEmployee(
			idamFailedTransactionId);
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
	@Override
	public com.adjecti.pis.liferay.model.IDAMFailedTransaction
		updateIDAMFailedTransaction(
			com.adjecti.pis.liferay.model.IDAMFailedTransaction
				idamFailedTransaction) {

		return _idamFailedTransactionLocalService.updateIDAMFailedTransaction(
			idamFailedTransaction);
	}

	@Override
	public IDAMFailedTransactionLocalService getWrappedService() {
		return _idamFailedTransactionLocalService;
	}

	@Override
	public void setWrappedService(
		IDAMFailedTransactionLocalService idamFailedTransactionLocalService) {

		_idamFailedTransactionLocalService = idamFailedTransactionLocalService;
	}

	private IDAMFailedTransactionLocalService
		_idamFailedTransactionLocalService;

}