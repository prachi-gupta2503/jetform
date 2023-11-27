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

package com.adj.userportlet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPortletService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletService
 * @generated
 */
public class UserPortletServiceWrapper
	implements ServiceWrapper<UserPortletService>, UserPortletService {

	public UserPortletServiceWrapper(UserPortletService userPortletService) {
		_userPortletService = userPortletService;
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getAllOrganizations() {

		return _userPortletService.getAllOrganizations();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPortletService.getOSGiServiceIdentifier();
	}

	@Override
	public UserPortletService getWrappedService() {
		return _userPortletService;
	}

	@Override
	public void setWrappedService(UserPortletService userPortletService) {
		_userPortletService = userPortletService;
	}

	private UserPortletService _userPortletService;

}