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

import com.adjecti.pis.liferay.model.EmployeeWorkArea;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeWorkArea in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeWorkAreaCacheModel
	implements CacheModel<EmployeeWorkArea>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeWorkAreaCacheModel)) {
			return false;
		}

		EmployeeWorkAreaCacheModel employeeWorkAreaCacheModel =
			(EmployeeWorkAreaCacheModel)object;

		if (employeeWorkAreaId ==
				employeeWorkAreaCacheModel.employeeWorkAreaId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeWorkAreaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{employeeWorkAreaId=");
		sb.append(employeeWorkAreaId);
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
		sb.append(", workAreaMajorId=");
		sb.append(workAreaMajorId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeWorkArea toEntityModel() {
		EmployeeWorkAreaImpl employeeWorkAreaImpl = new EmployeeWorkAreaImpl();

		employeeWorkAreaImpl.setEmployeeWorkAreaId(employeeWorkAreaId);
		employeeWorkAreaImpl.setGroupId(groupId);
		employeeWorkAreaImpl.setCompanyId(companyId);
		employeeWorkAreaImpl.setUserId(userId);

		if (userName == null) {
			employeeWorkAreaImpl.setUserName("");
		}
		else {
			employeeWorkAreaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeWorkAreaImpl.setCreateDate(null);
		}
		else {
			employeeWorkAreaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeWorkAreaImpl.setModifiedDate(null);
		}
		else {
			employeeWorkAreaImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeWorkAreaImpl.setEmployeeId(employeeId);
		employeeWorkAreaImpl.setWorkAreaMajorId(workAreaMajorId);
		employeeWorkAreaImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeWorkAreaImpl.setFromDate(null);
		}
		else {
			employeeWorkAreaImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeWorkAreaImpl.setToDate(null);
		}
		else {
			employeeWorkAreaImpl.setToDate(new Date(toDate));
		}

		employeeWorkAreaImpl.resetOriginalValues();

		return employeeWorkAreaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeWorkAreaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		workAreaMajorId = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeWorkAreaId);

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

		objectOutput.writeLong(workAreaMajorId);

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
	}

	public long employeeWorkAreaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long workAreaMajorId;
	public boolean active;
	public long fromDate;
	public long toDate;

}