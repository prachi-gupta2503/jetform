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

import com.adjecti.pis.liferay.model.EmployeeTransferRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeTransferRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeTransferRequestCacheModel
	implements CacheModel<EmployeeTransferRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeTransferRequestCacheModel)) {
			return false;
		}

		EmployeeTransferRequestCacheModel employeeTransferRequestCacheModel =
			(EmployeeTransferRequestCacheModel)object;

		if (employeeTransferRequestId ==
				employeeTransferRequestCacheModel.employeeTransferRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeTransferRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeTransferRequestId=");
		sb.append(employeeTransferRequestId);
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
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", transferDate=");
		sb.append(transferDate);
		sb.append(", startDateInNewUnit=");
		sb.append(startDateInNewUnit);
		sb.append(", lastDateInCurrentUnit=");
		sb.append(lastDateInCurrentUnit);
		sb.append(", officeOrderNo=");
		sb.append(officeOrderNo);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeTransferRequest toEntityModel() {
		EmployeeTransferRequestImpl employeeTransferRequestImpl =
			new EmployeeTransferRequestImpl();

		if (uuid == null) {
			employeeTransferRequestImpl.setUuid("");
		}
		else {
			employeeTransferRequestImpl.setUuid(uuid);
		}

		employeeTransferRequestImpl.setEmployeeTransferRequestId(
			employeeTransferRequestId);
		employeeTransferRequestImpl.setGroupId(groupId);
		employeeTransferRequestImpl.setCompanyId(companyId);
		employeeTransferRequestImpl.setUserId(userId);

		if (userName == null) {
			employeeTransferRequestImpl.setUserName("");
		}
		else {
			employeeTransferRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeTransferRequestImpl.setCreateDate(null);
		}
		else {
			employeeTransferRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeTransferRequestImpl.setModifiedDate(null);
		}
		else {
			employeeTransferRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeTransferRequestImpl.setEmployeeId(employeeId);
		employeeTransferRequestImpl.setOrganizationId(organizationId);

		if (transferDate == null) {
			employeeTransferRequestImpl.setTransferDate("");
		}
		else {
			employeeTransferRequestImpl.setTransferDate(transferDate);
		}

		if (startDateInNewUnit == Long.MIN_VALUE) {
			employeeTransferRequestImpl.setStartDateInNewUnit(null);
		}
		else {
			employeeTransferRequestImpl.setStartDateInNewUnit(
				new Date(startDateInNewUnit));
		}

		if (lastDateInCurrentUnit == Long.MIN_VALUE) {
			employeeTransferRequestImpl.setLastDateInCurrentUnit(null);
		}
		else {
			employeeTransferRequestImpl.setLastDateInCurrentUnit(
				new Date(lastDateInCurrentUnit));
		}

		if (officeOrderNo == null) {
			employeeTransferRequestImpl.setOfficeOrderNo("");
		}
		else {
			employeeTransferRequestImpl.setOfficeOrderNo(officeOrderNo);
		}

		employeeTransferRequestImpl.setProcessFileId(processFileId);

		if (processFileNo == null) {
			employeeTransferRequestImpl.setProcessFileNo("");
		}
		else {
			employeeTransferRequestImpl.setProcessFileNo(processFileNo);
		}

		employeeTransferRequestImpl.resetOriginalValues();

		return employeeTransferRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeTransferRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		organizationId = objectInput.readLong();
		transferDate = objectInput.readUTF();
		startDateInNewUnit = objectInput.readLong();
		lastDateInCurrentUnit = objectInput.readLong();
		officeOrderNo = objectInput.readUTF();

		processFileId = objectInput.readLong();
		processFileNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeTransferRequestId);

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

		objectOutput.writeLong(organizationId);

		if (transferDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(transferDate);
		}

		objectOutput.writeLong(startDateInNewUnit);
		objectOutput.writeLong(lastDateInCurrentUnit);

		if (officeOrderNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeOrderNo);
		}

		objectOutput.writeLong(processFileId);

		if (processFileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processFileNo);
		}
	}

	public String uuid;
	public long employeeTransferRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long organizationId;
	public String transferDate;
	public long startDateInNewUnit;
	public long lastDateInCurrentUnit;
	public String officeOrderNo;
	public long processFileId;
	public String processFileNo;

}