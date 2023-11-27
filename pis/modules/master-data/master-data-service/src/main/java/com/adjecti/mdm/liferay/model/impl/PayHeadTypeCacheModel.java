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

package com.adjecti.mdm.liferay.model.impl;

import com.adjecti.mdm.liferay.model.PayHeadType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayHeadType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PayHeadTypeCacheModel
	implements CacheModel<PayHeadType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayHeadTypeCacheModel)) {
			return false;
		}

		PayHeadTypeCacheModel payHeadTypeCacheModel =
			(PayHeadTypeCacheModel)object;

		if (payHeadTypeId == payHeadTypeCacheModel.payHeadTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payHeadTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{payHeadTypeId=");
		sb.append(payHeadTypeId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", deduction=");
		sb.append(deduction);
		sb.append(", deductionType=");
		sb.append(deductionType);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayHeadType toEntityModel() {
		PayHeadTypeImpl payHeadTypeImpl = new PayHeadTypeImpl();

		payHeadTypeImpl.setPayHeadTypeId(payHeadTypeId);
		payHeadTypeImpl.setGroupId(groupId);
		payHeadTypeImpl.setCompanyId(companyId);
		payHeadTypeImpl.setUserId(userId);

		if (userName == null) {
			payHeadTypeImpl.setUserName("");
		}
		else {
			payHeadTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			payHeadTypeImpl.setCreateDate(null);
		}
		else {
			payHeadTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payHeadTypeImpl.setModifiedDate(null);
		}
		else {
			payHeadTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		payHeadTypeImpl.setActive(active);

		if (code == null) {
			payHeadTypeImpl.setCode("");
		}
		else {
			payHeadTypeImpl.setCode(code);
		}

		payHeadTypeImpl.setDeduction(deduction);
		payHeadTypeImpl.setDeductionType(deductionType);

		if (fromDate == Long.MIN_VALUE) {
			payHeadTypeImpl.setFromDate(null);
		}
		else {
			payHeadTypeImpl.setFromDate(new Date(fromDate));
		}

		if (name == null) {
			payHeadTypeImpl.setName("");
		}
		else {
			payHeadTypeImpl.setName(name);
		}

		if (toDate == Long.MIN_VALUE) {
			payHeadTypeImpl.setToDate(null);
		}
		else {
			payHeadTypeImpl.setToDate(new Date(toDate));
		}

		payHeadTypeImpl.setDeleted(deleted);
		payHeadTypeImpl.setStatus(status);

		payHeadTypeImpl.resetOriginalValues();

		return payHeadTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payHeadTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		code = objectInput.readUTF();

		deduction = objectInput.readBoolean();

		deductionType = objectInput.readInt();
		fromDate = objectInput.readLong();
		name = objectInput.readUTF();
		toDate = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(payHeadTypeId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(deduction);

		objectOutput.writeInt(deductionType);
		objectOutput.writeLong(fromDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(toDate);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long payHeadTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String code;
	public boolean deduction;
	public int deductionType;
	public long fromDate;
	public String name;
	public long toDate;
	public boolean deleted;
	public int status;

}