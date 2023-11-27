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

import com.adjecti.pis.liferay.model.EmployeeGrade;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeGrade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeGradeCacheModel
	implements CacheModel<EmployeeGrade>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeGradeCacheModel)) {
			return false;
		}

		EmployeeGradeCacheModel employeeGradeCacheModel =
			(EmployeeGradeCacheModel)object;

		if (employeeGradeId == employeeGradeCacheModel.employeeGradeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeGradeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeeGradeId=");
		sb.append(employeeGradeId);
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
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", gradeId=");
		sb.append(gradeId);
		sb.append(", gradeModeId=");
		sb.append(gradeModeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeGrade toEntityModel() {
		EmployeeGradeImpl employeeGradeImpl = new EmployeeGradeImpl();

		employeeGradeImpl.setEmployeeGradeId(employeeGradeId);
		employeeGradeImpl.setGroupId(groupId);
		employeeGradeImpl.setCompanyId(companyId);
		employeeGradeImpl.setUserId(userId);

		if (userName == null) {
			employeeGradeImpl.setUserName("");
		}
		else {
			employeeGradeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeGradeImpl.setCreateDate(null);
		}
		else {
			employeeGradeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeGradeImpl.setModifiedDate(null);
		}
		else {
			employeeGradeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeGradeImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeGradeImpl.setFromDate(null);
		}
		else {
			employeeGradeImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeGradeImpl.setToDate(null);
		}
		else {
			employeeGradeImpl.setToDate(new Date(toDate));
		}

		employeeGradeImpl.setEmployeeId(employeeId);
		employeeGradeImpl.setGradeId(gradeId);
		employeeGradeImpl.setGradeModeId(gradeModeId);

		employeeGradeImpl.resetOriginalValues();

		return employeeGradeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeGradeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		gradeId = objectInput.readLong();

		gradeModeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeGradeId);

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

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(gradeId);

		objectOutput.writeLong(gradeModeId);
	}

	public long employeeGradeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public long employeeId;
	public long gradeId;
	public long gradeModeId;

}