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

import com.adjecti.pis.liferay.model.EmployeeTransfer;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeTransfer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeTransferCacheModel
	implements CacheModel<EmployeeTransfer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeTransferCacheModel)) {
			return false;
		}

		EmployeeTransferCacheModel employeeTransferCacheModel =
			(EmployeeTransferCacheModel)object;

		if (employeeTransferId ==
				employeeTransferCacheModel.employeeTransferId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeTransferId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{employeeTransferId=");
		sb.append(employeeTransferId);
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
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", transferDate=");
		sb.append(transferDate);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", fromOrganizationId=");
		sb.append(fromOrganizationId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append(", toOrganizationId=");
		sb.append(toOrganizationId);
		sb.append(", transferLetterId=");
		sb.append(transferLetterId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeTransfer toEntityModel() {
		EmployeeTransferImpl employeeTransferImpl = new EmployeeTransferImpl();

		employeeTransferImpl.setEmployeeTransferId(employeeTransferId);
		employeeTransferImpl.setGroupId(groupId);
		employeeTransferImpl.setCompanyId(companyId);
		employeeTransferImpl.setUserId(userId);

		if (userName == null) {
			employeeTransferImpl.setUserName("");
		}
		else {
			employeeTransferImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeTransferImpl.setCreateDate(null);
		}
		else {
			employeeTransferImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeTransferImpl.setModifiedDate(null);
		}
		else {
			employeeTransferImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeTransferImpl.setActive(active);

		if (personalNo == null) {
			employeeTransferImpl.setPersonalNo("");
		}
		else {
			employeeTransferImpl.setPersonalNo(personalNo);
		}

		if (transferDate == Long.MIN_VALUE) {
			employeeTransferImpl.setTransferDate(null);
		}
		else {
			employeeTransferImpl.setTransferDate(new Date(transferDate));
		}

		employeeTransferImpl.setDesignationId(designationId);
		employeeTransferImpl.setEmployeeId(employeeId);
		employeeTransferImpl.setFromOrganizationId(fromOrganizationId);
		employeeTransferImpl.setGradeId(gradeId);
		employeeTransferImpl.setGradeModeId(gradeModeId);
		employeeTransferImpl.setToOrganizationId(toOrganizationId);
		employeeTransferImpl.setTransferLetterId(transferLetterId);
		employeeTransferImpl.setStatus(status);

		employeeTransferImpl.resetOriginalValues();

		return employeeTransferImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeTransferId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		personalNo = objectInput.readUTF();
		transferDate = objectInput.readLong();

		designationId = objectInput.readLong();

		employeeId = objectInput.readLong();

		fromOrganizationId = objectInput.readLong();

		gradeId = objectInput.readLong();

		gradeModeId = objectInput.readLong();

		toOrganizationId = objectInput.readLong();

		transferLetterId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeTransferId);

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

		if (personalNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalNo);
		}

		objectOutput.writeLong(transferDate);

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(fromOrganizationId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(gradeModeId);

		objectOutput.writeLong(toOrganizationId);

		objectOutput.writeLong(transferLetterId);

		objectOutput.writeInt(status);
	}

	public long employeeTransferId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String personalNo;
	public long transferDate;
	public long designationId;
	public long employeeId;
	public long fromOrganizationId;
	public long gradeId;
	public long gradeModeId;
	public long toOrganizationId;
	public long transferLetterId;
	public int status;

}