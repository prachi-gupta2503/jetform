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

import com.adjecti.pis.liferay.model.EmployeeReporting;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeReporting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeReportingCacheModel
	implements CacheModel<EmployeeReporting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeReportingCacheModel)) {
			return false;
		}

		EmployeeReportingCacheModel employeeReportingCacheModel =
			(EmployeeReportingCacheModel)object;

		if (employeeReportingId ==
				employeeReportingCacheModel.employeeReportingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeReportingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeeReportingId=");
		sb.append(employeeReportingId);
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
		sb.append(", reportingToId=");
		sb.append(reportingToId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeReporting toEntityModel() {
		EmployeeReportingImpl employeeReportingImpl =
			new EmployeeReportingImpl();

		employeeReportingImpl.setEmployeeReportingId(employeeReportingId);
		employeeReportingImpl.setGroupId(groupId);
		employeeReportingImpl.setCompanyId(companyId);
		employeeReportingImpl.setUserId(userId);

		if (userName == null) {
			employeeReportingImpl.setUserName("");
		}
		else {
			employeeReportingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeReportingImpl.setCreateDate(null);
		}
		else {
			employeeReportingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeReportingImpl.setModifiedDate(null);
		}
		else {
			employeeReportingImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeReportingImpl.setEmployeeId(employeeId);
		employeeReportingImpl.setReportingToId(reportingToId);
		employeeReportingImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeReportingImpl.setFromDate(null);
		}
		else {
			employeeReportingImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeReportingImpl.setToDate(null);
		}
		else {
			employeeReportingImpl.setToDate(new Date(toDate));
		}

		employeeReportingImpl.setStatus(status);

		employeeReportingImpl.resetOriginalValues();

		return employeeReportingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeReportingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		reportingToId = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeReportingId);

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

		objectOutput.writeLong(reportingToId);

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeInt(status);
	}

	public long employeeReportingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long reportingToId;
	public boolean active;
	public long fromDate;
	public long toDate;
	public int status;

}