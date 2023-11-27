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

package com.adjecti.pis.liferay.model.impl;

import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * The extended model implementation for the Employee service. Represents a row in the &quot;pis_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.model.Employee</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class EmployeeImpl extends EmployeeBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a employee model instance should use the {@link com.adjecti.pis.liferay.model.Employee} interface instead.
	 */
	public EmployeeImpl() {
	}
	
	public String getFullName_En() {
		try {
			People people=PeopleLocalServiceUtil.getPeople(getPeopleId());
			return people.getFirstName_En().concat(
					(people.getMiddleName_En()!=null && !people.getMiddleName_En().isEmpty())?(" ".concat(people.getMiddleName_En())):"").concat(((people.getLastName_En()!=null && !people.getLastName_En().isEmpty())?(" ".concat(people.getLastName_En())):""));
		} catch (PortalException e) {
		}
		return null;
	}
	
	public String getFullName_Hi() {
		try {
			People people=PeopleLocalServiceUtil.getPeople(getPeopleId());
			return people.getFirstName_Hi().concat(
					(people.getMiddleName_Hi()!=null && !people.getMiddleName_Hi().isEmpty())?(" ".concat(people.getMiddleName_Hi())):"").concat(((people.getLastName_Hi()!=null && !people.getLastName_Hi().isEmpty())?(" ".concat(people.getLastName_Hi())):""));
		} catch (PortalException e) {
		}
		return null;
	}
}