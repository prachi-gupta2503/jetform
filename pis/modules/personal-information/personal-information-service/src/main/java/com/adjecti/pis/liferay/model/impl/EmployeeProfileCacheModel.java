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

import com.adjecti.pis.liferay.model.EmployeeProfile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeProfileCacheModel
	implements CacheModel<EmployeeProfile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeProfileCacheModel)) {
			return false;
		}

		EmployeeProfileCacheModel employeeProfileCacheModel =
			(EmployeeProfileCacheModel)object;

		if (employeeProfileId == employeeProfileCacheModel.employeeProfileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeProfileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeProfileId=");
		sb.append(employeeProfileId);
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
		sb.append(", profileDocumentId=");
		sb.append(profileDocumentId);
		sb.append(", profileDescription=");
		sb.append(profileDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeProfile toEntityModel() {
		EmployeeProfileImpl employeeProfileImpl = new EmployeeProfileImpl();

		employeeProfileImpl.setEmployeeProfileId(employeeProfileId);
		employeeProfileImpl.setGroupId(groupId);
		employeeProfileImpl.setCompanyId(companyId);
		employeeProfileImpl.setUserId(userId);

		if (userName == null) {
			employeeProfileImpl.setUserName("");
		}
		else {
			employeeProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeProfileImpl.setCreateDate(null);
		}
		else {
			employeeProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeProfileImpl.setModifiedDate(null);
		}
		else {
			employeeProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeProfileImpl.setEmployeeId(employeeId);
		employeeProfileImpl.setProfileDocumentId(profileDocumentId);

		if (profileDescription == null) {
			employeeProfileImpl.setProfileDescription("");
		}
		else {
			employeeProfileImpl.setProfileDescription(profileDescription);
		}

		employeeProfileImpl.resetOriginalValues();

		return employeeProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeProfileId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		profileDocumentId = objectInput.readLong();
		profileDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeProfileId);

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

		objectOutput.writeLong(profileDocumentId);

		if (profileDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileDescription);
		}
	}

	public long employeeProfileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long profileDocumentId;
	public String profileDescription;

}