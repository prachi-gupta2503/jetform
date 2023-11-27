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
 * The Blob model class for lazy loading the documentProof column in EmployeeFamily.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamily
 * @generated
 */
public class EmployeeFamilyDocumentProofBlobModel {

	public EmployeeFamilyDocumentProofBlobModel() {
	}

	public EmployeeFamilyDocumentProofBlobModel(long employeeFamilyId) {
		_employeeFamilyId = employeeFamilyId;
	}

	public EmployeeFamilyDocumentProofBlobModel(
		long employeeFamilyId, Blob documentProofBlob) {

		_employeeFamilyId = employeeFamilyId;
		_documentProofBlob = documentProofBlob;
	}

	public long getEmployeeFamilyId() {
		return _employeeFamilyId;
	}

	public void setEmployeeFamilyId(long employeeFamilyId) {
		_employeeFamilyId = employeeFamilyId;
	}

	public Blob getDocumentProofBlob() {
		return _documentProofBlob;
	}

	public void setDocumentProofBlob(Blob documentProofBlob) {
		_documentProofBlob = documentProofBlob;
	}

	private long _employeeFamilyId;
	private Blob _documentProofBlob;

}