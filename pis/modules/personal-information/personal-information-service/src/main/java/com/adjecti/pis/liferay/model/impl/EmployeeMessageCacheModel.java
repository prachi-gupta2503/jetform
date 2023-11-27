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

import com.adjecti.pis.liferay.model.EmployeeMessage;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeMessageCacheModel
	implements CacheModel<EmployeeMessage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeMessageCacheModel)) {
			return false;
		}

		EmployeeMessageCacheModel employeeMessageCacheModel =
			(EmployeeMessageCacheModel)object;

		if (employeeMessageId == employeeMessageCacheModel.employeeMessageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeMessageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeMessageId=");
		sb.append(employeeMessageId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", message=");
		sb.append(message);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeMessage toEntityModel() {
		EmployeeMessageImpl employeeMessageImpl = new EmployeeMessageImpl();

		employeeMessageImpl.setEmployeeMessageId(employeeMessageId);
		employeeMessageImpl.setGroupId(groupId);
		employeeMessageImpl.setCompanyId(companyId);
		employeeMessageImpl.setUserId(userId);

		if (userName == null) {
			employeeMessageImpl.setUserName("");
		}
		else {
			employeeMessageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeMessageImpl.setCreateDate(null);
		}
		else {
			employeeMessageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeMessageImpl.setModifiedDate(null);
		}
		else {
			employeeMessageImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeMessageImpl.setEmployeeId(employeeId);

		if (title == null) {
			employeeMessageImpl.setTitle("");
		}
		else {
			employeeMessageImpl.setTitle(title);
		}

		if (message == null) {
			employeeMessageImpl.setMessage("");
		}
		else {
			employeeMessageImpl.setMessage(message);
		}

		employeeMessageImpl.resetOriginalValues();

		return employeeMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeMessageId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		title = objectInput.readUTF();
		message = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeMessageId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}
	}

	public long employeeMessageId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String title;
	public String message;

}