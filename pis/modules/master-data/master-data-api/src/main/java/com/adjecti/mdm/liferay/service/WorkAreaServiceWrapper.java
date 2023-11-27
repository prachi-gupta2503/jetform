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
 * Provides a wrapper for {@link WorkAreaService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaService
 * @generated
 */
public class WorkAreaServiceWrapper
	implements ServiceWrapper<WorkAreaService>, WorkAreaService {

	public WorkAreaServiceWrapper(WorkAreaService workAreaService) {
		_workAreaService = workAreaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workAreaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkArea>
		getWorkAreas() {

		return _workAreaService.getWorkAreas();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.WorkArea>
		getWorkAreasByParentId(long parentId) {

		return _workAreaService.getWorkAreasByParentId(parentId);
	}

	@Override
	public boolean hasChild(long workAreaId) {
		return _workAreaService.hasChild(workAreaId);
	}

	@Override
	public WorkAreaService getWrappedService() {
		return _workAreaService;
	}

	@Override
	public void setWrappedService(WorkAreaService workAreaService) {
		_workAreaService = workAreaService;
	}

	private WorkAreaService _workAreaService;

}