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

import com.adjecti.pis.liferay.model.EmployeeBiodata;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeBiodata in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeBiodataCacheModel
	implements CacheModel<EmployeeBiodata>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeBiodataCacheModel)) {
			return false;
		}

		EmployeeBiodataCacheModel employeeBiodataCacheModel =
			(EmployeeBiodataCacheModel)object;

		if (employeeBiodataId == employeeBiodataCacheModel.employeeBiodataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeBiodataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeBiodataId=");
		sb.append(employeeBiodataId);
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
		sb.append(", biodata=");
		sb.append(biodata);
		sb.append(", biodataFileId=");
		sb.append(biodataFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeBiodata toEntityModel() {
		EmployeeBiodataImpl employeeBiodataImpl = new EmployeeBiodataImpl();

		employeeBiodataImpl.setEmployeeBiodataId(employeeBiodataId);
		employeeBiodataImpl.setGroupId(groupId);
		employeeBiodataImpl.setCompanyId(companyId);
		employeeBiodataImpl.setUserId(userId);

		if (userName == null) {
			employeeBiodataImpl.setUserName("");
		}
		else {
			employeeBiodataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeBiodataImpl.setCreateDate(null);
		}
		else {
			employeeBiodataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeBiodataImpl.setModifiedDate(null);
		}
		else {
			employeeBiodataImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeBiodataImpl.setEmployeeId(employeeId);

		if (biodata == null) {
			employeeBiodataImpl.setBiodata("");
		}
		else {
			employeeBiodataImpl.setBiodata(biodata);
		}

		employeeBiodataImpl.setBiodataFileId(biodataFileId);

		employeeBiodataImpl.resetOriginalValues();

		return employeeBiodataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeBiodataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		biodata = objectInput.readUTF();

		biodataFileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeBiodataId);

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

		if (biodata == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(biodata);
		}

		objectOutput.writeLong(biodataFileId);
	}

	public long employeeBiodataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String biodata;
	public long biodataFileId;

}