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

import com.adjecti.mdm.liferay.model.PayHead;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayHead in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PayHeadCacheModel implements CacheModel<PayHead>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayHeadCacheModel)) {
			return false;
		}

		PayHeadCacheModel payHeadCacheModel = (PayHeadCacheModel)object;

		if (payHeadId == payHeadCacheModel.payHeadId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payHeadId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{payHeadId=");
		sb.append(payHeadId);
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
		sb.append(", disbursePeriod=");
		sb.append(disbursePeriod);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", nonTaxable=");
		sb.append(nonTaxable);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", headTypeId=");
		sb.append(headTypeId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayHead toEntityModel() {
		PayHeadImpl payHeadImpl = new PayHeadImpl();

		payHeadImpl.setPayHeadId(payHeadId);
		payHeadImpl.setGroupId(groupId);
		payHeadImpl.setCompanyId(companyId);
		payHeadImpl.setUserId(userId);

		if (userName == null) {
			payHeadImpl.setUserName("");
		}
		else {
			payHeadImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			payHeadImpl.setCreateDate(null);
		}
		else {
			payHeadImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payHeadImpl.setModifiedDate(null);
		}
		else {
			payHeadImpl.setModifiedDate(new Date(modifiedDate));
		}

		payHeadImpl.setActive(active);

		if (code == null) {
			payHeadImpl.setCode("");
		}
		else {
			payHeadImpl.setCode(code);
		}

		payHeadImpl.setDisbursePeriod(disbursePeriod);

		if (fromDate == Long.MIN_VALUE) {
			payHeadImpl.setFromDate(null);
		}
		else {
			payHeadImpl.setFromDate(new Date(fromDate));
		}

		if (name == null) {
			payHeadImpl.setName("");
		}
		else {
			payHeadImpl.setName(name);
		}

		payHeadImpl.setNonTaxable(nonTaxable);

		if (toDate == Long.MIN_VALUE) {
			payHeadImpl.setToDate(null);
		}
		else {
			payHeadImpl.setToDate(new Date(toDate));
		}

		payHeadImpl.setHeadTypeId(headTypeId);
		payHeadImpl.setDeleted(deleted);
		payHeadImpl.setStatus(status);

		payHeadImpl.resetOriginalValues();

		return payHeadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payHeadId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		code = objectInput.readUTF();

		disbursePeriod = objectInput.readInt();
		fromDate = objectInput.readLong();
		name = objectInput.readUTF();

		nonTaxable = objectInput.readBoolean();
		toDate = objectInput.readLong();

		headTypeId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(payHeadId);

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

		objectOutput.writeInt(disbursePeriod);
		objectOutput.writeLong(fromDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(nonTaxable);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(headTypeId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long payHeadId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String code;
	public int disbursePeriod;
	public long fromDate;
	public String name;
	public boolean nonTaxable;
	public long toDate;
	public long headTypeId;
	public boolean deleted;
	public int status;

}