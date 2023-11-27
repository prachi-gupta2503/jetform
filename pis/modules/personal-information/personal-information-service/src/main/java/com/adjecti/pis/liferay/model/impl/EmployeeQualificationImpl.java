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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeQualificationException;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the EmployeeQualification service. Represents a row in the &quot;pis_EmployeeQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.model.EmployeeQualification</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class EmployeeQualificationImpl extends EmployeeQualificationBaseImpl {

	public EmployeeQualificationImpl() {
	}
	
	public List<EmployeeQualification> getQualificationByEmployeeId(long employeeId) throws NoSuchEmployeeQualificationException{
		return 	EmployeeQualificationLocalServiceUtil.getEmployeeQualificationByEmployeeId(employeeId);	
	}
	
	public List<EmployeeQualification> getQualificationByPersonalNo(String personalNo) throws NoSuchEmployeeQualificationException,NoSuchEmployeeException{
		return EmployeeQualificationLocalServiceUtil.getEmployeeQualificationByPersonalNo(personalNo);
	}
	
	

}