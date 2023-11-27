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
 * The Blob model class for lazy loading the addressProof column in EmployeeAddress.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddress
 * @generated
 */
public class EmployeeAddressAddressProofBlobModel {

	public EmployeeAddressAddressProofBlobModel() {
	}

	public EmployeeAddressAddressProofBlobModel(long employeeAddressId) {
		_employeeAddressId = employeeAddressId;
	}

	public EmployeeAddressAddressProofBlobModel(
		long employeeAddressId, Blob addressProofBlob) {

		_employeeAddressId = employeeAddressId;
		_addressProofBlob = addressProofBlob;
	}

	public long getEmployeeAddressId() {
		return _employeeAddressId;
	}

	public void setEmployeeAddressId(long employeeAddressId) {
		_employeeAddressId = employeeAddressId;
	}

	public Blob getAddressProofBlob() {
		return _addressProofBlob;
	}

	public void setAddressProofBlob(Blob addressProofBlob) {
		_addressProofBlob = addressProofBlob;
	}

	private long _employeeAddressId;
	private Blob _addressProofBlob;

}