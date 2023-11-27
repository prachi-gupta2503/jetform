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

import com.adjecti.mdm.liferay.model.PayComponent;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayComponent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PayComponentCacheModel
	implements CacheModel<PayComponent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayComponentCacheModel)) {
			return false;
		}

		PayComponentCacheModel payComponentCacheModel =
			(PayComponentCacheModel)object;

		if (payComponentId == payComponentCacheModel.payComponentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payComponentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{payComponentId=");
		sb.append(payComponentId);
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
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", amountType=");
		sb.append(amountType);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", dependantId=");
		sb.append(dependantId);
		sb.append(", headId=");
		sb.append(headId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayComponent toEntityModel() {
		PayComponentImpl payComponentImpl = new PayComponentImpl();

		payComponentImpl.setPayComponentId(payComponentId);
		payComponentImpl.setGroupId(groupId);
		payComponentImpl.setCompanyId(companyId);
		payComponentImpl.setUserId(userId);

		if (userName == null) {
			payComponentImpl.setUserName("");
		}
		else {
			payComponentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			payComponentImpl.setCreateDate(null);
		}
		else {
			payComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payComponentImpl.setModifiedDate(null);
		}
		else {
			payComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		payComponentImpl.setActive(active);
		payComponentImpl.setAmount(amount);

		if (amountType == null) {
			payComponentImpl.setAmountType("");
		}
		else {
			payComponentImpl.setAmountType(amountType);
		}

		if (fromDate == Long.MIN_VALUE) {
			payComponentImpl.setFromDate(null);
		}
		else {
			payComponentImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			payComponentImpl.setToDate(null);
		}
		else {
			payComponentImpl.setToDate(new Date(toDate));
		}

		payComponentImpl.setDependantId(dependantId);
		payComponentImpl.setHeadId(headId);
		payComponentImpl.setStructureId(structureId);
		payComponentImpl.setDeleted(deleted);
		payComponentImpl.setStatus(status);

		payComponentImpl.resetOriginalValues();

		return payComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payComponentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();

		amount = objectInput.readFloat();
		amountType = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		dependantId = objectInput.readLong();

		headId = objectInput.readLong();

		structureId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(payComponentId);

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

		objectOutput.writeFloat(amount);

		if (amountType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(amountType);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(dependantId);

		objectOutput.writeLong(headId);

		objectOutput.writeLong(structureId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long payComponentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public float amount;
	public String amountType;
	public long fromDate;
	public long toDate;
	public long dependantId;
	public long headId;
	public long structureId;
	public boolean deleted;
	public int status;

}