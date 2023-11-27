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

import com.adjecti.pis.liferay.model.EmployeeDsc;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDsc in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDscCacheModel
	implements CacheModel<EmployeeDsc>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDscCacheModel)) {
			return false;
		}

		EmployeeDscCacheModel employeeDscCacheModel =
			(EmployeeDscCacheModel)object;

		if (employeeDscId == employeeDscCacheModel.employeeDscId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDscId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{employeeDscId=");
		sb.append(employeeDscId);
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
		sb.append(", cid=");
		sb.append(cid);
		sb.append(", details=");
		sb.append(details);
		sb.append(", ofbDSCReissueDate=");
		sb.append(ofbDSCReissueDate);
		sb.append(", ofbDSCRevocationDate=");
		sb.append(ofbDSCRevocationDate);
		sb.append(", ofbDSCRevocationStatus=");
		sb.append(ofbDSCRevocationStatus);
		sb.append(", ofbDSCReissueStatus=");
		sb.append(ofbDSCReissueStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDsc toEntityModel() {
		EmployeeDscImpl employeeDscImpl = new EmployeeDscImpl();

		employeeDscImpl.setEmployeeDscId(employeeDscId);
		employeeDscImpl.setGroupId(groupId);
		employeeDscImpl.setCompanyId(companyId);
		employeeDscImpl.setUserId(userId);

		if (userName == null) {
			employeeDscImpl.setUserName("");
		}
		else {
			employeeDscImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDscImpl.setCreateDate(null);
		}
		else {
			employeeDscImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDscImpl.setModifiedDate(null);
		}
		else {
			employeeDscImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDscImpl.setEmployeeId(employeeId);

		if (cid == null) {
			employeeDscImpl.setCid("");
		}
		else {
			employeeDscImpl.setCid(cid);
		}

		if (details == null) {
			employeeDscImpl.setDetails("");
		}
		else {
			employeeDscImpl.setDetails(details);
		}

		if (ofbDSCReissueDate == Long.MIN_VALUE) {
			employeeDscImpl.setOfbDSCReissueDate(null);
		}
		else {
			employeeDscImpl.setOfbDSCReissueDate(new Date(ofbDSCReissueDate));
		}

		if (ofbDSCRevocationDate == Long.MIN_VALUE) {
			employeeDscImpl.setOfbDSCRevocationDate(null);
		}
		else {
			employeeDscImpl.setOfbDSCRevocationDate(
				new Date(ofbDSCRevocationDate));
		}

		employeeDscImpl.setOfbDSCRevocationStatus(ofbDSCRevocationStatus);
		employeeDscImpl.setOfbDSCReissueStatus(ofbDSCReissueStatus);

		employeeDscImpl.resetOriginalValues();

		return employeeDscImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeDscId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		cid = objectInput.readUTF();
		details = objectInput.readUTF();
		ofbDSCReissueDate = objectInput.readLong();
		ofbDSCRevocationDate = objectInput.readLong();

		ofbDSCRevocationStatus = objectInput.readBoolean();

		ofbDSCReissueStatus = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeDscId);

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

		if (cid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cid);
		}

		if (details == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(details);
		}

		objectOutput.writeLong(ofbDSCReissueDate);
		objectOutput.writeLong(ofbDSCRevocationDate);

		objectOutput.writeBoolean(ofbDSCRevocationStatus);

		objectOutput.writeBoolean(ofbDSCReissueStatus);
	}

	public long employeeDscId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String cid;
	public String details;
	public long ofbDSCReissueDate;
	public long ofbDSCRevocationDate;
	public boolean ofbDSCRevocationStatus;
	public boolean ofbDSCReissueStatus;

}