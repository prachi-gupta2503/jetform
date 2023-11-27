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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the address column in EmployeeAddress.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddress
 * @generated
 */
public class EmployeeAddressAddressBlobModel {

	public EmployeeAddressAddressBlobModel() {
	}

	public EmployeeAddressAddressBlobModel(long employeeAddressId) {
		_employeeAddressId = employeeAddressId;
	}

	public EmployeeAddressAddressBlobModel(
		long employeeAddressId, Blob addressBlob) {

		_employeeAddressId = employeeAddressId;
		_addressBlob = addressBlob;
	}

	public long getEmployeeAddressId() {
		return _employeeAddressId;
	}

	public void setEmployeeAddressId(long employeeAddressId) {
		_employeeAddressId = employeeAddressId;
	}

	public Blob getAddressBlob() {
		return _addressBlob;
	}

	public void setAddressBlob(Blob addressBlob) {
		_addressBlob = addressBlob;
	}

	private long _employeeAddressId;
	private Blob _addressBlob;

}