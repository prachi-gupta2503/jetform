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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.exception.NoSuchIDAMFailedTransactionException;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the idam failed transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IDAMFailedTransactionUtil
 * @generated
 */
@ProviderType
public interface IDAMFailedTransactionPersistence
	extends BasePersistence<IDAMFailedTransaction> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IDAMFailedTransactionUtil} to access the idam failed transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the idam failed transaction in the entity cache if it is enabled.
	 *
	 * @param idamFailedTransaction the idam failed transaction
	 */
	public void cacheResult(IDAMFailedTransaction idamFailedTransaction);

	/**
	 * Caches the idam failed transactions in the entity cache if it is enabled.
	 *
	 * @param idamFailedTransactions the idam failed transactions
	 */
	public void cacheResult(
		java.util.List<IDAMFailedTransaction> idamFailedTransactions);

	/**
	 * Creates a new idam failed transaction with the primary key. Does not add the idam failed transaction to the database.
	 *
	 * @param idamFailedTransactionId the primary key for the new idam failed transaction
	 * @return the new idam failed transaction
	 */
	public IDAMFailedTransaction create(long idamFailedTransactionId);

	/**
	 * Removes the idam failed transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction that was removed
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	public IDAMFailedTransaction remove(long idamFailedTransactionId)
		throws NoSuchIDAMFailedTransactionException;

	public IDAMFailedTransaction updateImpl(
		IDAMFailedTransaction idamFailedTransaction);

	/**
	 * Returns the idam failed transaction with the primary key or throws a <code>NoSuchIDAMFailedTransactionException</code> if it could not be found.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	public IDAMFailedTransaction findByPrimaryKey(long idamFailedTransactionId)
		throws NoSuchIDAMFailedTransactionException;

	/**
	 * Returns the idam failed transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction, or <code>null</code> if a idam failed transaction with the primary key could not be found
	 */
	public IDAMFailedTransaction fetchByPrimaryKey(
		long idamFailedTransactionId);

	/**
	 * Returns all the idam failed transactions.
	 *
	 * @return the idam failed transactions
	 */
	public java.util.List<IDAMFailedTransaction> findAll();

	/**
	 * Returns a range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @return the range of idam failed transactions
	 */
	public java.util.List<IDAMFailedTransaction> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idam failed transactions
	 */
	public java.util.List<IDAMFailedTransaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IDAMFailedTransaction>
			orderByComparator);

	/**
	 * Returns an ordered range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of idam failed transactions
	 */
	public java.util.List<IDAMFailedTransaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IDAMFailedTransaction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the idam failed transactions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of idam failed transactions.
	 *
	 * @return the number of idam failed transactions
	 */
	public int countAll();

}