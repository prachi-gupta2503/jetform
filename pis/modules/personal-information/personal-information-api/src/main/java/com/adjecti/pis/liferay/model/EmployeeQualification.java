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

package com.adjecti.pis.liferay.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmployeeQualification service. Represents a row in the &quot;pis_EmployeeQualification&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationModel
 * @generated
 */
@ImplementationClassName(
	"com.adjecti.pis.liferay.model.impl.EmployeeQualificationImpl"
)
@ProviderType
public interface EmployeeQualification
	extends EmployeeQualificationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeQualification, Long>
		EMPLOYEE_QUALIFICATION_ID_ACCESSOR =
			new Accessor<EmployeeQualification, Long>() {

				@Override
				public Long get(EmployeeQualification employeeQualification) {
					return employeeQualification.getEmployeeQualificationId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<EmployeeQualification> getTypeClass() {
					return EmployeeQualification.class;
				}

			};

	public java.util.List<EmployeeQualification> getQualificationByEmployeeId(
			long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException;

	public java.util.List<EmployeeQualification> getQualificationByPersonalNo(
			String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException,
			   com.adjecti.pis.liferay.exception.
				   NoSuchEmployeeQualificationException;

}