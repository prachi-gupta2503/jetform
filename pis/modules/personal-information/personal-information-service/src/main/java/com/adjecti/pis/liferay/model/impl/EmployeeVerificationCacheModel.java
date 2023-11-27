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

import com.adjecti.pis.liferay.model.EmployeeVerification;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeVerification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeVerificationCacheModel
	implements CacheModel<EmployeeVerification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeVerificationCacheModel)) {
			return false;
		}

		EmployeeVerificationCacheModel employeeVerificationCacheModel =
			(EmployeeVerificationCacheModel)object;

		if (employeeVerificationId ==
				employeeVerificationCacheModel.employeeVerificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeVerificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{employeeVerificationId=");
		sb.append(employeeVerificationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", authority=");
		sb.append(authority);
		sb.append(", documentNo=");
		sb.append(documentNo);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", verificationDate=");
		sb.append(verificationDate);
		sb.append(", verificationTypeId=");
		sb.append(verificationTypeId);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeVerification toEntityModel() {
		EmployeeVerificationImpl employeeVerificationImpl =
			new EmployeeVerificationImpl();

		employeeVerificationImpl.setEmployeeVerificationId(
			employeeVerificationId);
		employeeVerificationImpl.setGroupId(groupId);
		employeeVerificationImpl.setCompanyId(companyId);
		employeeVerificationImpl.setUserId(userId);

		if (userName == null) {
			employeeVerificationImpl.setUserName("");
		}
		else {
			employeeVerificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeVerificationImpl.setCreateDate(null);
		}
		else {
			employeeVerificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeVerificationImpl.setModifiedDate(null);
		}
		else {
			employeeVerificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeVerificationImpl.setActive(active);

		if (authority == null) {
			employeeVerificationImpl.setAuthority("");
		}
		else {
			employeeVerificationImpl.setAuthority(authority);
		}

		if (documentNo == null) {
			employeeVerificationImpl.setDocumentNo("");
		}
		else {
			employeeVerificationImpl.setDocumentNo(documentNo);
		}

		if (remarks == null) {
			employeeVerificationImpl.setRemarks("");
		}
		else {
			employeeVerificationImpl.setRemarks(remarks);
		}

		if (verificationDate == Long.MIN_VALUE) {
			employeeVerificationImpl.setVerificationDate(null);
		}
		else {
			employeeVerificationImpl.setVerificationDate(
				new Date(verificationDate));
		}

		employeeVerificationImpl.setVerificationTypeId(verificationTypeId);
		employeeVerificationImpl.setDocumentId(documentId);
		employeeVerificationImpl.setEmployeeId(employeeId);
		employeeVerificationImpl.setOrganizationId(organizationId);
		employeeVerificationImpl.setJoiningProcessId(joiningProcessId);
		employeeVerificationImpl.setStatus(status);

		employeeVerificationImpl.resetOriginalValues();

		return employeeVerificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeVerificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		authority = objectInput.readUTF();
		documentNo = objectInput.readUTF();
		remarks = objectInput.readUTF();
		verificationDate = objectInput.readLong();

		verificationTypeId = objectInput.readLong();

		documentId = objectInput.readLong();

		employeeId = objectInput.readLong();

		organizationId = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeVerificationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(active);

		if (authority == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authority);
		}

		if (documentNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNo);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(verificationDate);

		objectOutput.writeLong(verificationTypeId);

		objectOutput.writeLong(documentId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeInt(status);
	}

	public long employeeVerificationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String authority;
	public String documentNo;
	public String remarks;
	public long verificationDate;
	public long verificationTypeId;
	public long documentId;
	public long employeeId;
	public long organizationId;
	public long joiningProcessId;
	public int status;

}