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

import com.adjecti.pis.liferay.model.EmployeeDeputation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDeputation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDeputationCacheModel
	implements CacheModel<EmployeeDeputation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDeputationCacheModel)) {
			return false;
		}

		EmployeeDeputationCacheModel employeeDeputationCacheModel =
			(EmployeeDeputationCacheModel)object;

		if (employeeDeputationId ==
				employeeDeputationCacheModel.employeeDeputationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDeputationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{employeeDeputationId=");
		sb.append(employeeDeputationId);
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
		sb.append(", officeAddress=");
		sb.append(officeAddress);
		sb.append(", remark=");
		sb.append(remark);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", deputationTypeId=");
		sb.append(deputationTypeId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", ministryId=");
		sb.append(ministryId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", deputedPostId=");
		sb.append(deputedPostId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDeputation toEntityModel() {
		EmployeeDeputationImpl employeeDeputationImpl =
			new EmployeeDeputationImpl();

		employeeDeputationImpl.setEmployeeDeputationId(employeeDeputationId);
		employeeDeputationImpl.setGroupId(groupId);
		employeeDeputationImpl.setCompanyId(companyId);
		employeeDeputationImpl.setUserId(userId);

		if (userName == null) {
			employeeDeputationImpl.setUserName("");
		}
		else {
			employeeDeputationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDeputationImpl.setCreateDate(null);
		}
		else {
			employeeDeputationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDeputationImpl.setModifiedDate(null);
		}
		else {
			employeeDeputationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDeputationImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeDeputationImpl.setFromDate(null);
		}
		else {
			employeeDeputationImpl.setFromDate(new Date(fromDate));
		}

		if (officeAddress == null) {
			employeeDeputationImpl.setOfficeAddress("");
		}
		else {
			employeeDeputationImpl.setOfficeAddress(officeAddress);
		}

		if (remark == null) {
			employeeDeputationImpl.setRemark("");
		}
		else {
			employeeDeputationImpl.setRemark(remark);
		}

		if (toDate == Long.MIN_VALUE) {
			employeeDeputationImpl.setToDate(null);
		}
		else {
			employeeDeputationImpl.setToDate(new Date(toDate));
		}

		employeeDeputationImpl.setDeputationTypeId(deputationTypeId);
		employeeDeputationImpl.setDepartmentId(departmentId);
		employeeDeputationImpl.setEmployeeId(employeeId);
		employeeDeputationImpl.setMinistryId(ministryId);
		employeeDeputationImpl.setPostId(postId);
		employeeDeputationImpl.setDeputedPostId(deputedPostId);
		employeeDeputationImpl.setStatus(status);

		employeeDeputationImpl.resetOriginalValues();

		return employeeDeputationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeDeputationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		officeAddress = objectInput.readUTF();
		remark = objectInput.readUTF();
		toDate = objectInput.readLong();

		deputationTypeId = objectInput.readLong();

		departmentId = objectInput.readLong();

		employeeId = objectInput.readLong();

		ministryId = objectInput.readLong();

		postId = objectInput.readLong();

		deputedPostId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeDeputationId);

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

		if (officeAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeAddress);
		}

		if (remark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remark);
		}

		objectOutput.writeLong(toDate);

		objectOutput.writeLong(deputationTypeId);

		objectOutput.writeLong(departmentId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(ministryId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(deputedPostId);

		objectOutput.writeInt(status);
	}

	public long employeeDeputationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public String officeAddress;
	public String remark;
	public long toDate;
	public long deputationTypeId;
	public long departmentId;
	public long employeeId;
	public long ministryId;
	public long postId;
	public long deputedPostId;
	public int status;

}