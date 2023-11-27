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

import com.adjecti.mdm.liferay.model.Trade;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the trade service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.TradePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradePersistence
 * @generated
 */
public class TradeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Trade trade) {
		getPersistence().clearCache(trade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Trade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Trade> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Trade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Trade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Trade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Trade update(Trade trade) {
		return getPersistence().update(trade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Trade update(Trade trade, ServiceContext serviceContext) {
		return getPersistence().update(trade, serviceContext);
	}

	/**
	 * Returns all the trades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching trades
	 */
	public static List<Trade> findByName(String name) {
		return getPersistence().findByName(name);
	}

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
	public static List<Trade> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

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
	public static List<Trade> findByName(
		String name, int start, int end,
		OrderByComparator<Trade> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

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
	public static List<Trade> findByName(
		String name, int start, int end,
		OrderByComparator<Trade> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public static Trade findByName_First(
			String name, OrderByComparator<Trade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public static Trade fetchByName_First(
		String name, OrderByComparator<Trade> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public static Trade findByName_Last(
			String name, OrderByComparator<Trade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last trade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public static Trade fetchByName_Last(
		String name, OrderByComparator<Trade> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the trades before and after the current trade in the ordered set where name = &#63;.
	 *
	 * @param tradeId the primary key of the current trade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trade
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public static Trade[] findByName_PrevAndNext(
			long tradeId, String name,
			OrderByComparator<Trade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().findByName_PrevAndNext(
			tradeId, name, orderByComparator);
	}

	/**
	 * Removes all the trades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of trades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching trades
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the trade where code = &#63; or throws a <code>NoSuchTradeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching trade
	 * @throws NoSuchTradeException if a matching trade could not be found
	 */
	public static Trade findByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the trade where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public static Trade fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the trade where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trade, or <code>null</code> if a matching trade could not be found
	 */
	public static Trade fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the trade where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the trade that was removed
	 */
	public static Trade removeByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of trades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching trades
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the trade in the entity cache if it is enabled.
	 *
	 * @param trade the trade
	 */
	public static void cacheResult(Trade trade) {
		getPersistence().cacheResult(trade);
	}

	/**
	 * Caches the trades in the entity cache if it is enabled.
	 *
	 * @param trades the trades
	 */
	public static void cacheResult(List<Trade> trades) {
		getPersistence().cacheResult(trades);
	}

	/**
	 * Creates a new trade with the primary key. Does not add the trade to the database.
	 *
	 * @param tradeId the primary key for the new trade
	 * @return the new trade
	 */
	public static Trade create(long tradeId) {
		return getPersistence().create(tradeId);
	}

	/**
	 * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade that was removed
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public static Trade remove(long tradeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().remove(tradeId);
	}

	public static Trade updateImpl(Trade trade) {
		return getPersistence().updateImpl(trade);
	}

	/**
	 * Returns the trade with the primary key or throws a <code>NoSuchTradeException</code> if it could not be found.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade
	 * @throws NoSuchTradeException if a trade with the primary key could not be found
	 */
	public static Trade findByPrimaryKey(long tradeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchTradeException {

		return getPersistence().findByPrimaryKey(tradeId);
	}

	/**
	 * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade, or <code>null</code> if a trade with the primary key could not be found
	 */
	public static Trade fetchByPrimaryKey(long tradeId) {
		return getPersistence().fetchByPrimaryKey(tradeId);
	}

	/**
	 * Returns all the trades.
	 *
	 * @return the trades
	 */
	public static List<Trade> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Trade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Trade> findAll(
		int start, int end, OrderByComparator<Trade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Trade> findAll(
		int start, int end, OrderByComparator<Trade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trades.
	 *
	 * @return the number of trades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TradePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TradePersistence, TradePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TradePersistence.class);

		ServiceTracker<TradePersistence, TradePersistence> serviceTracker =
			new ServiceTracker<TradePersistence, TradePersistence>(
				bundle.getBundleContext(), TradePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}