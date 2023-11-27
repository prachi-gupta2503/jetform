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

import com.adjecti.pis.liferay.model.EmployeeContact;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeContactCacheModel
	implements CacheModel<EmployeeContact>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeContactCacheModel)) {
			return false;
		}

		EmployeeContactCacheModel employeeContactCacheModel =
			(EmployeeContactCacheModel)object;

		if (employeeContactId == employeeContactCacheModel.employeeContactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeContactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeeContactId=");
		sb.append(employeeContactId);
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
		sb.append(", deskNo=");
		sb.append(deskNo);
		sb.append(", extn=");
		sb.append(extn);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", directNo=");
		sb.append(directNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeContact toEntityModel() {
		EmployeeContactImpl employeeContactImpl = new EmployeeContactImpl();

		employeeContactImpl.setEmployeeContactId(employeeContactId);
		employeeContactImpl.setGroupId(groupId);
		employeeContactImpl.setCompanyId(companyId);
		employeeContactImpl.setUserId(userId);

		if (userName == null) {
			employeeContactImpl.setUserName("");
		}
		else {
			employeeContactImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeContactImpl.setCreateDate(null);
		}
		else {
			employeeContactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeContactImpl.setModifiedDate(null);
		}
		else {
			employeeContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (deskNo == null) {
			employeeContactImpl.setDeskNo("");
		}
		else {
			employeeContactImpl.setDeskNo(deskNo);
		}

		if (extn == null) {
			employeeContactImpl.setExtn("");
		}
		else {
			employeeContactImpl.setExtn(extn);
		}

		if (phoneNo == null) {
			employeeContactImpl.setPhoneNo("");
		}
		else {
			employeeContactImpl.setPhoneNo(phoneNo);
		}

		employeeContactImpl.setContactId(contactId);
		employeeContactImpl.setEmployeeId(employeeId);

		if (directNo == null) {
			employeeContactImpl.setDirectNo("");
		}
		else {
			employeeContactImpl.setDirectNo(directNo);
		}

		employeeContactImpl.resetOriginalValues();

		return employeeContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeContactId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		deskNo = objectInput.readUTF();
		extn = objectInput.readUTF();
		phoneNo = objectInput.readUTF();

		contactId = objectInput.readLong();

		employeeId = objectInput.readLong();
		directNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeContactId);

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

		if (deskNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deskNo);
		}

		if (extn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extn);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		objectOutput.writeLong(contactId);

		objectOutput.writeLong(employeeId);

		if (directNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(directNo);
		}
	}

	public long employeeContactId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String deskNo;
	public String extn;
	public String phoneNo;
	public long contactId;
	public long employeeId;
	public String directNo;

}