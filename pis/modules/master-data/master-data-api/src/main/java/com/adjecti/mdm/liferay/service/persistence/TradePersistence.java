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

package com.adjecti.mdm.liferay.service.persistence;

import com.adjecti.mdm.liferay.exception.NoSuchTradeException;
import com.adjecti.mdm.liferay.model.Trade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradeUtil
 * @generated
 */
@ProviderType
public interface TradePersistence extends BasePersistence<Trade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TradeUtil} to access the trade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching trades
	 */
	public java.util.List<Trade> findByName(String name);

	/**
	 * Returns a range of all the trades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @return the range of matching trades
	 */
	public java.util.List<Trade> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the trades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trades
	 */
	public java.util.List<Trade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trades
	 */
	public java.util.List<Trade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public Trade findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Trade>
				orderByComparator)
		throws NoSuchTradeException;

	/**
	 * Returns the first trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public Trade fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator);

	/**
	 * Returns the last trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public Trade findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Trade>
				orderByComparator)
		throws NoSuchTradeException;

	/**
	 * Returns the last trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public Trade fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator);

	/**
	 * Returns the trades before and after the current trade in the ordered set where name = &#63;.
	 *
	 * @param tradeId the primary key of the current trade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trade
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public Trade[] findByName_PrevAndNext(
			long tradeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Trade>
				orderByComparator)
		throws NoSuchTradeException;

	/**
	 * Removes all the trades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of trades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching trades
	 */
	public int countByName(String name);

	/**
	 * Returns the trade where code = &#63; or throws a <code>NoSuchTradeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public Trade findByCode(String code) throws NoSuchTradeException;

	/**
	 * Returns the trade where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public Trade fetchByCode(String code);

	/**
	 * Returns the trade where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public Trade fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the trade where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the trade that was removed
	 */
	public Trade removeByCode(String code) throws NoSuchTradeException;

	/**
	 * Returns the number of trades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching trades
	 */
	public int countByCode(String code);

	/**
	 * Caches the trade in the entity cache if it is enabled.
	 *
	 * @param trade the trade
	 */
	public void cacheResult(Trade trade);

	/**
	 * Caches the trades in the entity cache if it is enabled.
	 *
	 * @param trades the trades
	 */
	public void cacheResult(java.util.List<Trade> trades);

	/**
	 * Creates a new trade with the primary key. Does not add the trade to the database.
	 *
	 * @param tradeId the primary key for the new trade
	 * @return the new trade
	 */
	public Trade create(long tradeId);

	/**
	 * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade that was removed
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public Trade remove(long tradeId) throws NoSuchTradeException;

	public Trade updateImpl(Trade trade);

	/**
	 * Returns the trade with the primary key or throws a <code>NoSuchTradeException</code> if it could not be found.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public Trade findByPrimaryKey(long tradeId) throws NoSuchTradeException;

	/**
	 * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade, or <code>null</code> if a trade with the primary key could not be found
	 */
	public Trade fetchByPrimaryKey(long tradeId);

	/**
	 * Returns all the trades.
	 *
	 * @return the trades
	 */
	public java.util.List<Trade> findAll();

	/**
	 * Returns a range of all the trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @return the range of trades
	 */
	public java.util.List<Trade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trades
	 */
	public java.util.List<Trade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trades
	 */
	public java.util.List<Trade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trades.
	 *
	 * @return the number of trades
	 */
	public int countAll();

}