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
 * The extended model interface for the EmployeeFamily service. Represents a row in the &quot;pis_EmployeeFamily&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamilyModel
 * @generated
 */
@ImplementationClassName(
	"com.adjecti.pis.liferay.model.impl.EmployeeFamilyImpl"
)
@ProviderType
public interface EmployeeFamily extends EmployeeFamilyModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeFamily, Long>
		EMPLOYEE_FAMILY_ID_ACCESSOR = new Accessor<EmployeeFamily, Long>() {

			@Override
			public Long get(EmployeeFamily employeeFamily) {
				return employeeFamily.getEmployeeFamilyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmployeeFamily> getTypeClass() {
				return EmployeeFamily.class;
			}

		};

}