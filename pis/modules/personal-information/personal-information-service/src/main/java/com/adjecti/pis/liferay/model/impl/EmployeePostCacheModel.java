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

import com.adjecti.pis.liferay.model.EmployeePost;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePost in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePostCacheModel
	implements CacheModel<EmployeePost>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePostCacheModel)) {
			return false;
		}

		EmployeePostCacheModel employeePostCacheModel =
			(EmployeePostCacheModel)object;

		if (employeePostId == employeePostCacheModel.employeePostId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePostId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{employeePostId=");
		sb.append(employeePostId);
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
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", delegatedPostId=");
		sb.append(delegatedPostId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePost toEntityModel() {
		EmployeePostImpl employeePostImpl = new EmployeePostImpl();

		employeePostImpl.setEmployeePostId(employeePostId);
		employeePostImpl.setGroupId(groupId);
		employeePostImpl.setCompanyId(companyId);
		employeePostImpl.setUserId(userId);

		if (userName == null) {
			employeePostImpl.setUserName("");
		}
		else {
			employeePostImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePostImpl.setCreateDate(null);
		}
		else {
			employeePostImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePostImpl.setModifiedDate(null);
		}
		else {
			employeePostImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeePostImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeePostImpl.setFromDate(null);
		}
		else {
			employeePostImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeePostImpl.setToDate(null);
		}
		else {
			employeePostImpl.setToDate(new Date(toDate));
		}

		employeePostImpl.setPostId(postId);
		employeePostImpl.setDelegatedPostId(delegatedPostId);
		employeePostImpl.setEmployeeId(employeeId);
		employeePostImpl.setStatus(status);

		employeePostImpl.resetOriginalValues();

		return employeePostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeePostId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		postId = objectInput.readLong();

		delegatedPostId = objectInput.readLong();

		employeeId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeePostId);

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
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(delegatedPostId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeInt(status);
	}

	public long employeePostId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public long postId;
	public long delegatedPostId;
	public long employeeId;
	public int status;

}