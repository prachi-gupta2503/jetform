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

import com.adjecti.pis.liferay.model.EmployeeDelegation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDelegation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDelegationCacheModel
	implements CacheModel<EmployeeDelegation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDelegationCacheModel)) {
			return false;
		}

		EmployeeDelegationCacheModel employeeDelegationCacheModel =
			(EmployeeDelegationCacheModel)object;

		if (employeeDelegationId ==
				employeeDelegationCacheModel.employeeDelegationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDelegationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeDelegationId=");
		sb.append(employeeDelegationId);
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
		sb.append(", delegationType=");
		sb.append(delegationType);
		sb.append(", delegatedEmployeeId=");
		sb.append(delegatedEmployeeId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDelegation toEntityModel() {
		EmployeeDelegationImpl employeeDelegationImpl =
			new EmployeeDelegationImpl();

		employeeDelegationImpl.setEmployeeDelegationId(employeeDelegationId);
		employeeDelegationImpl.setGroupId(groupId);
		employeeDelegationImpl.setCompanyId(companyId);
		employeeDelegationImpl.setUserId(userId);

		if (userName == null) {
			employeeDelegationImpl.setUserName("");
		}
		else {
			employeeDelegationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDelegationImpl.setCreateDate(null);
		}
		else {
			employeeDelegationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDelegationImpl.setModifiedDate(null);
		}
		else {
			employeeDelegationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDelegationImpl.setDelegationType(delegationType);
		employeeDelegationImpl.setDelegatedEmployeeId(delegatedEmployeeId);
		employeeDelegationImpl.setEmployeeId(employeeId);

		employeeDelegationImpl.resetOriginalValues();

		return employeeDelegationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeDelegationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		delegationType = objectInput.readLong();

		delegatedEmployeeId = objectInput.readLong();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeDelegationId);

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

		objectOutput.writeLong(delegationType);

		objectOutput.writeLong(delegatedEmployeeId);

		objectOutput.writeLong(employeeId);
	}

	public long employeeDelegationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long delegationType;
	public long delegatedEmployeeId;
	public long employeeId;

}