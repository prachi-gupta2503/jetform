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

import com.adjecti.pis.liferay.model.EmployeeApplication;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeApplication in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeApplicationCacheModel
	implements CacheModel<EmployeeApplication>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeApplicationCacheModel)) {
			return false;
		}

		EmployeeApplicationCacheModel employeeApplicationCacheModel =
			(EmployeeApplicationCacheModel)object;

		if (employeeApplicationId ==
				employeeApplicationCacheModel.employeeApplicationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeApplicationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{employeeApplicationId=");
		sb.append(employeeApplicationId);
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
		sb.append(", applicationId=");
		sb.append(applicationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeApplication toEntityModel() {
		EmployeeApplicationImpl employeeApplicationImpl =
			new EmployeeApplicationImpl();

		employeeApplicationImpl.setEmployeeApplicationId(employeeApplicationId);
		employeeApplicationImpl.setGroupId(groupId);
		employeeApplicationImpl.setCompanyId(companyId);
		employeeApplicationImpl.setUserId(userId);

		if (userName == null) {
			employeeApplicationImpl.setUserName("");
		}
		else {
			employeeApplicationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeApplicationImpl.setCreateDate(null);
		}
		else {
			employeeApplicationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeApplicationImpl.setModifiedDate(null);
		}
		else {
			employeeApplicationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeApplicationImpl.setEmployeeId(employeeId);
		employeeApplicationImpl.setApplicationId(applicationId);

		employeeApplicationImpl.resetOriginalValues();

		return employeeApplicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeApplicationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		applicationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeApplicationId);

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

		objectOutput.writeLong(applicationId);
	}

	public long employeeApplicationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long applicationId;

}