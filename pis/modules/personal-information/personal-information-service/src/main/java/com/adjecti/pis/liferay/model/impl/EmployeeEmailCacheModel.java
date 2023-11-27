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

import com.adjecti.pis.liferay.model.EmployeeEmail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeEmail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeEmailCacheModel
	implements CacheModel<EmployeeEmail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeEmailCacheModel)) {
			return false;
		}

		EmployeeEmailCacheModel employeeEmailCacheModel =
			(EmployeeEmailCacheModel)object;

		if (employeeEmailId == employeeEmailCacheModel.employeeEmailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeEmailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{employeeEmailId=");
		sb.append(employeeEmailId);
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
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", emailAddressType=");
		sb.append(emailAddressType);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeEmail toEntityModel() {
		EmployeeEmailImpl employeeEmailImpl = new EmployeeEmailImpl();

		employeeEmailImpl.setEmployeeEmailId(employeeEmailId);
		employeeEmailImpl.setGroupId(groupId);
		employeeEmailImpl.setCompanyId(companyId);
		employeeEmailImpl.setUserId(userId);

		if (userName == null) {
			employeeEmailImpl.setUserName("");
		}
		else {
			employeeEmailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeEmailImpl.setCreateDate(null);
		}
		else {
			employeeEmailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeEmailImpl.setModifiedDate(null);
		}
		else {
			employeeEmailImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeEmailImpl.setEmployeeId(employeeId);

		if (emailAddress == null) {
			employeeEmailImpl.setEmailAddress("");
		}
		else {
			employeeEmailImpl.setEmailAddress(emailAddress);
		}

		if (emailAddressType == null) {
			employeeEmailImpl.setEmailAddressType("");
		}
		else {
			employeeEmailImpl.setEmailAddressType(emailAddressType);
		}

		employeeEmailImpl.setActive(active);

		employeeEmailImpl.resetOriginalValues();

		return employeeEmailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeEmailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		emailAddressType = objectInput.readUTF();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeEmailId);

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

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (emailAddressType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddressType);
		}

		objectOutput.writeBoolean(active);
	}

	public long employeeEmailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String emailAddress;
	public String emailAddressType;
	public boolean active;

}