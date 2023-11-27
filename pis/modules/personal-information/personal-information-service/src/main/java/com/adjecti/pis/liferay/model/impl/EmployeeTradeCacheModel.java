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

import com.adjecti.pis.liferay.model.EmployeeTrade;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeTrade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeTradeCacheModel
	implements CacheModel<EmployeeTrade>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeTradeCacheModel)) {
			return false;
		}

		EmployeeTradeCacheModel employeeTradeCacheModel =
			(EmployeeTradeCacheModel)object;

		if (employeeTradeId == employeeTradeCacheModel.employeeTradeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeTradeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{employeeTradeId=");
		sb.append(employeeTradeId);
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
		sb.append(", tradeId=");
		sb.append(tradeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeTrade toEntityModel() {
		EmployeeTradeImpl employeeTradeImpl = new EmployeeTradeImpl();

		employeeTradeImpl.setEmployeeTradeId(employeeTradeId);
		employeeTradeImpl.setGroupId(groupId);
		employeeTradeImpl.setCompanyId(companyId);
		employeeTradeImpl.setUserId(userId);

		if (userName == null) {
			employeeTradeImpl.setUserName("");
		}
		else {
			employeeTradeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeTradeImpl.setCreateDate(null);
		}
		else {
			employeeTradeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeTradeImpl.setModifiedDate(null);
		}
		else {
			employeeTradeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeTradeImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			employeeTradeImpl.setFromDate(null);
		}
		else {
			employeeTradeImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeTradeImpl.setToDate(null);
		}
		else {
			employeeTradeImpl.setToDate(new Date(toDate));
		}

		employeeTradeImpl.setEmployeeId(employeeId);
		employeeTradeImpl.setTradeId(tradeId);

		employeeTradeImpl.resetOriginalValues();

		return employeeTradeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeTradeId = objectInput.readLong();

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

		tradeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeTradeId);

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

		objectOutput.writeLong(tradeId);
	}

	public long employeeTradeId;
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
	public long tradeId;

}