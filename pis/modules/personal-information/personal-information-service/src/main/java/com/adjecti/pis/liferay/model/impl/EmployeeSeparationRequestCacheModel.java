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

import com.adjecti.pis.liferay.model.EmployeeSeparationRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeSeparationRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeSeparationRequestCacheModel
	implements CacheModel<EmployeeSeparationRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeSeparationRequestCacheModel)) {
			return false;
		}

		EmployeeSeparationRequestCacheModel
			employeeSeparationRequestCacheModel =
				(EmployeeSeparationRequestCacheModel)object;

		if (employeeSeparationRequestId ==
				employeeSeparationRequestCacheModel.
					employeeSeparationRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeSeparationRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeSeparationRequestId=");
		sb.append(employeeSeparationRequestId);
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
		sb.append(", separationMode=");
		sb.append(separationMode);
		sb.append(", separationDate=");
		sb.append(separationDate);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append(", officeOrderNo=");
		sb.append(officeOrderNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeSeparationRequest toEntityModel() {
		EmployeeSeparationRequestImpl employeeSeparationRequestImpl =
			new EmployeeSeparationRequestImpl();

		if (uuid == null) {
			employeeSeparationRequestImpl.setUuid("");
		}
		else {
			employeeSeparationRequestImpl.setUuid(uuid);
		}

		employeeSeparationRequestImpl.setEmployeeSeparationRequestId(
			employeeSeparationRequestId);
		employeeSeparationRequestImpl.setGroupId(groupId);
		employeeSeparationRequestImpl.setCompanyId(companyId);
		employeeSeparationRequestImpl.setUserId(userId);

		if (userName == null) {
			employeeSeparationRequestImpl.setUserName("");
		}
		else {
			employeeSeparationRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeSeparationRequestImpl.setCreateDate(null);
		}
		else {
			employeeSeparationRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeSeparationRequestImpl.setModifiedDate(null);
		}
		else {
			employeeSeparationRequestImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		employeeSeparationRequestImpl.setEmployeeId(employeeId);

		if (separationMode == null) {
			employeeSeparationRequestImpl.setSeparationMode("");
		}
		else {
			employeeSeparationRequestImpl.setSeparationMode(separationMode);
		}

		if (separationDate == Long.MIN_VALUE) {
			employeeSeparationRequestImpl.setSeparationDate(null);
		}
		else {
			employeeSeparationRequestImpl.setSeparationDate(
				new Date(separationDate));
		}

		if (remarks == null) {
			employeeSeparationRequestImpl.setRemarks("");
		}
		else {
			employeeSeparationRequestImpl.setRemarks(remarks);
		}

		employeeSeparationRequestImpl.setProcessFileId(processFileId);

		if (processFileNo == null) {
			employeeSeparationRequestImpl.setProcessFileNo("");
		}
		else {
			employeeSeparationRequestImpl.setProcessFileNo(processFileNo);
		}

		if (officeOrderNo == null) {
			employeeSeparationRequestImpl.setOfficeOrderNo("");
		}
		else {
			employeeSeparationRequestImpl.setOfficeOrderNo(officeOrderNo);
		}

		employeeSeparationRequestImpl.resetOriginalValues();

		return employeeSeparationRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeSeparationRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		separationMode = objectInput.readUTF();
		separationDate = objectInput.readLong();
		remarks = objectInput.readUTF();

		processFileId = objectInput.readLong();
		processFileNo = objectInput.readUTF();
		officeOrderNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeSeparationRequestId);

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

		if (separationMode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(separationMode);
		}

		objectOutput.writeLong(separationDate);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(processFileId);

		if (processFileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processFileNo);
		}

		if (officeOrderNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeOrderNo);
		}
	}

	public String uuid;
	public long employeeSeparationRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String separationMode;
	public long separationDate;
	public String remarks;
	public long processFileId;
	public String processFileNo;
	public String officeOrderNo;

}