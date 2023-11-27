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
 * Provides a wrapper for {@link TradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TradeLocalService
 * @generated
 */
public class TradeLocalServiceWrapper
	implements ServiceWrapper<TradeLocalService>, TradeLocalService {

	public TradeLocalServiceWrapper(TradeLocalService tradeLocalService) {
		_tradeLocalService = tradeLocalService;
	}

	/**
	 * Adds the trade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trade the trade
	 * @return the trade that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade addTrade(
		com.adjecti.mdm.liferay.model.Trade trade) {

		return _tradeLocalService.addTrade(trade);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tradeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trade with the primary key. Does not add the trade to the database.
	 *
	 * @param tradeId the primary key for the new trade
	 * @return the new trade
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade createTrade(long tradeId) {
		return _tradeLocalService.createTrade(tradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tradeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade that was removed
	 * @throws PortalException if a trade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade deleteTrade(long tradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tradeLocalService.deleteTrade(tradeId);
	}

	/**
	 * Deletes the trade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trade the trade
	 * @return the trade that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade deleteTrade(
		com.adjecti.mdm.liferay.model.Trade trade) {

		return _tradeLocalService.deleteTrade(trade);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tradeLocalService.dynamicQuery();
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

		return _tradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TradeModelImpl</code>.
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

		return _tradeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TradeModelImpl</code>.
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

		return _tradeLocalService.dynamicQuery(
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

		return _tradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tradeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Trade fetchTrade(long tradeId) {
		return _tradeLocalService.fetchTrade(tradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tradeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tradeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trade with the primary key.
	 *
	 * @param tradeId the primary key of the trade
	 * @return the trade
	 * @throws PortalException if a trade with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade getTrade(long tradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tradeLocalService.getTrade(tradeId);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Trade getTradeByCode(String code) {
		return _tradeLocalService.getTradeByCode(code);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Trade> getTradeByName(
		String tradeName) {

		return _tradeLocalService.getTradeByName(tradeName);
	}

	/**
	 * Returns a range of all the trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.TradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trades
	 * @param end the upper bound of the range of trades (not inclusive)
	 * @return the range of trades
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Trade> getTrades(
		int start, int end) {

		return _tradeLocalService.getTrades(start, end);
	}

	/**
	 * Returns the number of trades.
	 *
	 * @return the number of trades
	 */
	@Override
	public int getTradesCount() {
		return _tradeLocalService.getTradesCount();
	}

	/**
	 * Updates the trade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trade the trade
	 * @return the trade that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Trade updateTrade(
		com.adjecti.mdm.liferay.model.Trade trade) {

		return _tradeLocalService.updateTrade(trade);
	}

	@Override
	public TradeLocalService getWrappedService() {
		return _tradeLocalService;
	}

	@Override
	public void setWrappedService(TradeLocalService tradeLocalService) {
		_tradeLocalService = tradeLocalService;
	}

	private TradeLocalService _tradeLocalService;

}