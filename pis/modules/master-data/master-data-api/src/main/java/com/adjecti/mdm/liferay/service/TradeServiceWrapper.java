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
 * Provides a wrapper for {@link TradeService}.
 *
 * @author Brian Wing Shun Chan
 * @see TradeService
 * @generated
 */
public class TradeServiceWrapper
	implements ServiceWrapper<TradeService>, TradeService {

	public TradeServiceWrapper(TradeService tradeService) {
		_tradeService = tradeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tradeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Trade> getTrades() {
		return _tradeService.getTrades();
	}

	@Override
	public TradeService getWrappedService() {
		return _tradeService;
	}

	@Override
	public void setWrappedService(TradeService tradeService) {
		_tradeService = tradeService;
	}

	private TradeService _tradeService;

}