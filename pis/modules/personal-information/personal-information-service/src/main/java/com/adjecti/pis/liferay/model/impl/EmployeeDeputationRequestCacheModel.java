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

import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDeputationRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDeputationRequestCacheModel
	implements CacheModel<EmployeeDeputationRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDeputationRequestCacheModel)) {
			return false;
		}

		EmployeeDeputationRequestCacheModel
			employeeDeputationRequestCacheModel =
				(EmployeeDeputationRequestCacheModel)object;

		if (employeeDeputationRequestId ==
				employeeDeputationRequestCacheModel.
					employeeDeputationRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDeputationRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeDeputationRequestId=");
		sb.append(employeeDeputationRequestId);
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
		sb.append(", deputationOrganization=");
		sb.append(deputationOrganization);
		sb.append(", deputationAddress=");
		sb.append(deputationAddress);
		sb.append(", deputationCity=");
		sb.append(deputationCity);
		sb.append(", deputationState=");
		sb.append(deputationState);
		sb.append(", deputationStartDate=");
		sb.append(deputationStartDate);
		sb.append(", lastDateInCurrentUnit=");
		sb.append(lastDateInCurrentUnit);
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
	public EmployeeDeputationRequest toEntityModel() {
		EmployeeDeputationRequestImpl employeeDeputationRequestImpl =
			new EmployeeDeputationRequestImpl();

		if (uuid == null) {
			employeeDeputationRequestImpl.setUuid("");
		}
		else {
			employeeDeputationRequestImpl.setUuid(uuid);
		}

		employeeDeputationRequestImpl.setEmployeeDeputationRequestId(
			employeeDeputationRequestId);
		employeeDeputationRequestImpl.setGroupId(groupId);
		employeeDeputationRequestImpl.setCompanyId(companyId);
		employeeDeputationRequestImpl.setUserId(userId);

		if (userName == null) {
			employeeDeputationRequestImpl.setUserName("");
		}
		else {
			employeeDeputationRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDeputationRequestImpl.setCreateDate(null);
		}
		else {
			employeeDeputationRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDeputationRequestImpl.setModifiedDate(null);
		}
		else {
			employeeDeputationRequestImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		employeeDeputationRequestImpl.setEmployeeId(employeeId);

		if (deputationOrganization == null) {
			employeeDeputationRequestImpl.setDeputationOrganization("");
		}
		else {
			employeeDeputationRequestImpl.setDeputationOrganization(
				deputationOrganization);
		}

		if (deputationAddress == null) {
			employeeDeputationRequestImpl.setDeputationAddress("");
		}
		else {
			employeeDeputationRequestImpl.setDeputationAddress(
				deputationAddress);
		}

		if (deputationCity == null) {
			employeeDeputationRequestImpl.setDeputationCity("");
		}
		else {
			employeeDeputationRequestImpl.setDeputationCity(deputationCity);
		}

		if (deputationState == null) {
			employeeDeputationRequestImpl.setDeputationState("");
		}
		else {
			employeeDeputationRequestImpl.setDeputationState(deputationState);
		}

		if (deputationStartDate == Long.MIN_VALUE) {
			employeeDeputationRequestImpl.setDeputationStartDate(null);
		}
		else {
			employeeDeputationRequestImpl.setDeputationStartDate(
				new Date(deputationStartDate));
		}

		if (lastDateInCurrentUnit == Long.MIN_VALUE) {
			employeeDeputationRequestImpl.setLastDateInCurrentUnit(null);
		}
		else {
			employeeDeputationRequestImpl.setLastDateInCurrentUnit(
				new Date(lastDateInCurrentUnit));
		}

		employeeDeputationRequestImpl.setProcessFileId(processFileId);

		if (processFileNo == null) {
			employeeDeputationRequestImpl.setProcessFileNo("");
		}
		else {
			employeeDeputationRequestImpl.setProcessFileNo(processFileNo);
		}

		if (officeOrderNo == null) {
			employeeDeputationRequestImpl.setOfficeOrderNo("");
		}
		else {
			employeeDeputationRequestImpl.setOfficeOrderNo(officeOrderNo);
		}

		employeeDeputationRequestImpl.resetOriginalValues();

		return employeeDeputationRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeDeputationRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		deputationOrganization = objectInput.readUTF();
		deputationAddress = objectInput.readUTF();
		deputationCity = objectInput.readUTF();
		deputationState = objectInput.readUTF();
		deputationStartDate = objectInput.readLong();
		lastDateInCurrentUnit = objectInput.readLong();

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

		objectOutput.writeLong(employeeDeputationRequestId);

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

		if (deputationOrganization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationOrganization);
		}

		if (deputationAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationAddress);
		}

		if (deputationCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationCity);
		}

		if (deputationState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deputationState);
		}

		objectOutput.writeLong(deputationStartDate);
		objectOutput.writeLong(lastDateInCurrentUnit);

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
	public long employeeDeputationRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String deputationOrganization;
	public String deputationAddress;
	public String deputationCity;
	public String deputationState;
	public long deputationStartDate;
	public long lastDateInCurrentUnit;
	public long processFileId;
	public String processFileNo;
	public String officeOrderNo;

}