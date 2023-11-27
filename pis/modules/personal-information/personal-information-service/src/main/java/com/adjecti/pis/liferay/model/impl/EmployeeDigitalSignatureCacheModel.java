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

import com.adjecti.pis.liferay.model.EmployeeDigitalSignature;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDigitalSignature in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDigitalSignatureCacheModel
	implements CacheModel<EmployeeDigitalSignature>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDigitalSignatureCacheModel)) {
			return false;
		}

		EmployeeDigitalSignatureCacheModel employeeDigitalSignatureCacheModel =
			(EmployeeDigitalSignatureCacheModel)object;

		if (employeeDigitalSignatureId ==
				employeeDigitalSignatureCacheModel.employeeDigitalSignatureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDigitalSignatureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeeDigitalSignatureId=");
		sb.append(employeeDigitalSignatureId);
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
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", cid=");
		sb.append(cid);
		sb.append(", details=");
		sb.append(details);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", revokeDate=");
		sb.append(revokeDate);
		sb.append(", revoked=");
		sb.append(revoked);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDigitalSignature toEntityModel() {
		EmployeeDigitalSignatureImpl employeeDigitalSignatureImpl =
			new EmployeeDigitalSignatureImpl();

		employeeDigitalSignatureImpl.setEmployeeDigitalSignatureId(
			employeeDigitalSignatureId);
		employeeDigitalSignatureImpl.setGroupId(groupId);
		employeeDigitalSignatureImpl.setCompanyId(companyId);
		employeeDigitalSignatureImpl.setUserId(userId);

		if (userName == null) {
			employeeDigitalSignatureImpl.setUserName("");
		}
		else {
			employeeDigitalSignatureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDigitalSignatureImpl.setCreateDate(null);
		}
		else {
			employeeDigitalSignatureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDigitalSignatureImpl.setModifiedDate(null);
		}
		else {
			employeeDigitalSignatureImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		employeeDigitalSignatureImpl.setEmployeeId(employeeId);

		if (cid == null) {
			employeeDigitalSignatureImpl.setCid("");
		}
		else {
			employeeDigitalSignatureImpl.setCid(cid);
		}

		if (details == null) {
			employeeDigitalSignatureImpl.setDetails("");
		}
		else {
			employeeDigitalSignatureImpl.setDetails(details);
		}

		if (issueDate == Long.MIN_VALUE) {
			employeeDigitalSignatureImpl.setIssueDate(null);
		}
		else {
			employeeDigitalSignatureImpl.setIssueDate(new Date(issueDate));
		}

		if (revokeDate == Long.MIN_VALUE) {
			employeeDigitalSignatureImpl.setRevokeDate(null);
		}
		else {
			employeeDigitalSignatureImpl.setRevokeDate(new Date(revokeDate));
		}

		employeeDigitalSignatureImpl.setRevoked(revoked);

		employeeDigitalSignatureImpl.resetOriginalValues();

		return employeeDigitalSignatureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeDigitalSignatureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		cid = objectInput.readUTF();
		details = objectInput.readUTF();
		issueDate = objectInput.readLong();
		revokeDate = objectInput.readLong();

		revoked = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeDigitalSignatureId);

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

		objectOutput.writeLong(employeeId);

		if (cid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cid);
		}

		if (details == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(details);
		}

		objectOutput.writeLong(issueDate);
		objectOutput.writeLong(revokeDate);

		objectOutput.writeBoolean(revoked);
	}

	public long employeeDigitalSignatureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String cid;
	public String details;
	public long issueDate;
	public long revokeDate;
	public boolean revoked;

}