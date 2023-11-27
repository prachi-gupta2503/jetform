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
 * Provides a wrapper for {@link PostHierarchyService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostHierarchyService
 * @generated
 */
public class PostHierarchyServiceWrapper
	implements PostHierarchyService, ServiceWrapper<PostHierarchyService> {

	public PostHierarchyServiceWrapper(
		PostHierarchyService postHierarchyService) {

		_postHierarchyService = postHierarchyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postHierarchyService.getOSGiServiceIdentifier();
	}

	@Override
	public PostHierarchyService getWrappedService() {
		return _postHierarchyService;
	}

	@Override
	public void setWrappedService(PostHierarchyService postHierarchyService) {
		_postHierarchyService = postHierarchyService;
	}

	private PostHierarchyService _postHierarchyService;

}