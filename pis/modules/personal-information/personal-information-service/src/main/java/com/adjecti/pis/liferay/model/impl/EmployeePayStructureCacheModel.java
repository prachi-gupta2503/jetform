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

import com.adjecti.pis.liferay.model.EmployeePayStructure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePayStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePayStructureCacheModel
	implements CacheModel<EmployeePayStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePayStructureCacheModel)) {
			return false;
		}

		EmployeePayStructureCacheModel employeePayStructureCacheModel =
			(EmployeePayStructureCacheModel)object;

		if (employeePayStructureId ==
				employeePayStructureCacheModel.employeePayStructureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePayStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeePayStructureId=");
		sb.append(employeePayStructureId);
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
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePayStructure toEntityModel() {
		EmployeePayStructureImpl employeePayStructureImpl =
			new EmployeePayStructureImpl();

		employeePayStructureImpl.setEmployeePayStructureId(
			employeePayStructureId);
		employeePayStructureImpl.setGroupId(groupId);
		employeePayStructureImpl.setCompanyId(companyId);
		employeePayStructureImpl.setUserId(userId);

		if (userName == null) {
			employeePayStructureImpl.setUserName("");
		}
		else {
			employeePayStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePayStructureImpl.setCreateDate(null);
		}
		else {
			employeePayStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePayStructureImpl.setModifiedDate(null);
		}
		else {
			employeePayStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeePayStructureImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeePayStructureImpl.setFromDate(null);
		}
		else {
			employeePayStructureImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeePayStructureImpl.setToDate(null);
		}
		else {
			employeePayStructureImpl.setToDate(new Date(toDate));
		}

		employeePayStructureImpl.setEmployeeId(employeeId);
		employeePayStructureImpl.setLevelId(levelId);
		employeePayStructureImpl.setStructureId(structureId);

		employeePayStructureImpl.resetOriginalValues();

		return employeePayStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeePayStructureId = objectInput.readLong();

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

		levelId = objectInput.readLong();

		structureId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeePayStructureId);

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

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(structureId);
	}

	public long employeePayStructureId;
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
	public long levelId;
	public long structureId;

}