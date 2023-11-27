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

import com.adjecti.pis.liferay.model.MonthlySalaryComponent;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MonthlySalaryComponent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MonthlySalaryComponentCacheModel
	implements CacheModel<MonthlySalaryComponent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MonthlySalaryComponentCacheModel)) {
			return false;
		}

		MonthlySalaryComponentCacheModel monthlySalaryComponentCacheModel =
			(MonthlySalaryComponentCacheModel)object;

		if (monthlySalaryComponentId ==
				monthlySalaryComponentCacheModel.monthlySalaryComponentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, monthlySalaryComponentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{monthlySalaryComponentId=");
		sb.append(monthlySalaryComponentId);
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
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", salaryId=");
		sb.append(salaryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MonthlySalaryComponent toEntityModel() {
		MonthlySalaryComponentImpl monthlySalaryComponentImpl =
			new MonthlySalaryComponentImpl();

		monthlySalaryComponentImpl.setMonthlySalaryComponentId(
			monthlySalaryComponentId);
		monthlySalaryComponentImpl.setGroupId(groupId);
		monthlySalaryComponentImpl.setCompanyId(companyId);
		monthlySalaryComponentImpl.setUserId(userId);

		if (userName == null) {
			monthlySalaryComponentImpl.setUserName("");
		}
		else {
			monthlySalaryComponentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			monthlySalaryComponentImpl.setCreateDate(null);
		}
		else {
			monthlySalaryComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			monthlySalaryComponentImpl.setModifiedDate(null);
		}
		else {
			monthlySalaryComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		monthlySalaryComponentImpl.setAmount(amount);
		monthlySalaryComponentImpl.setComponentId(componentId);
		monthlySalaryComponentImpl.setSalaryId(salaryId);

		monthlySalaryComponentImpl.resetOriginalValues();

		return monthlySalaryComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		monthlySalaryComponentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		amount = objectInput.readFloat();

		componentId = objectInput.readLong();

		salaryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(monthlySalaryComponentId);

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

		objectOutput.writeFloat(amount);

		objectOutput.writeLong(componentId);

		objectOutput.writeLong(salaryId);
	}

	public long monthlySalaryComponentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public float amount;
	public long componentId;
	public long salaryId;

}