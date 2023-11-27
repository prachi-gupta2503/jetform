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
 * Provides a wrapper for {@link PeopleService}.
 *
 * @author Brian Wing Shun Chan
 * @see PeopleService
 * @generated
 */
public class PeopleServiceWrapper
	implements PeopleService, ServiceWrapper<PeopleService> {

	public PeopleServiceWrapper(PeopleService peopleService) {
		_peopleService = peopleService;
	}

	@Override
	public long addPeople(
			com.adjecti.pis.liferay.model.People people, long employeeId)
		throws com.adjecti.pis.liferay.exception.PeopleException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _peopleService.addPeople(people, employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _peopleService.getOSGiServiceIdentifier();
	}

	@Override
	public PeopleService getWrappedService() {
		return _peopleService;
	}

	@Override
	public void setWrappedService(PeopleService peopleService) {
		_peopleService = peopleService;
	}

	private PeopleService _peopleService;

}