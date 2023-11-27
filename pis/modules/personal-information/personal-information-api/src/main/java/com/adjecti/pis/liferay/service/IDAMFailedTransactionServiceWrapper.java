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
 * Provides a wrapper for {@link IDAMFailedTransactionService}.
 *
 * @author Brian Wing Shun Chan
 * @see IDAMFailedTransactionService
 * @generated
 */
public class IDAMFailedTransactionServiceWrapper
	implements IDAMFailedTransactionService,
			   ServiceWrapper<IDAMFailedTransactionService> {

	public IDAMFailedTransactionServiceWrapper(
		IDAMFailedTransactionService idamFailedTransactionService) {

		_idamFailedTransactionService = idamFailedTransactionService;
	}

	@Override
	public void deleteIdamFailedTransaction(long idamFailedTransactionId) {
		_idamFailedTransactionService.deleteIdamFailedTransaction(
			idamFailedTransactionId);
	}

	@Override
	public int getIdamFailedTransactionCount() {
		return _idamFailedTransactionService.getIdamFailedTransactionCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _idamFailedTransactionService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean updateIdamEmployee(long idamFailedTransactionId) {
		return _idamFailedTransactionService.updateIdamEmployee(
			idamFailedTransactionId);
	}

	@Override
	public IDAMFailedTransactionService getWrappedService() {
		return _idamFailedTransactionService;
	}

	@Override
	public void setWrappedService(
		IDAMFailedTransactionService idamFailedTransactionService) {

		_idamFailedTransactionService = idamFailedTransactionService;
	}

	private IDAMFailedTransactionService _idamFailedTransactionService;

}