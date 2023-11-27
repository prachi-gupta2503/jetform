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

import com.adjecti.mdm.liferay.model.PayStructure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PayStructureCacheModel
	implements CacheModel<PayStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayStructureCacheModel)) {
			return false;
		}

		PayStructureCacheModel payStructureCacheModel =
			(PayStructureCacheModel)object;

		if (payStructureId == payStructureCacheModel.payStructureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, payStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{payStructureId=");
		sb.append(payStructureId);
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
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayStructure toEntityModel() {
		PayStructureImpl payStructureImpl = new PayStructureImpl();

		payStructureImpl.setPayStructureId(payStructureId);
		payStructureImpl.setGroupId(groupId);
		payStructureImpl.setCompanyId(companyId);
		payStructureImpl.setUserId(userId);

		if (userName == null) {
			payStructureImpl.setUserName("");
		}
		else {
			payStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			payStructureImpl.setCreateDate(null);
		}
		else {
			payStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payStructureImpl.setModifiedDate(null);
		}
		else {
			payStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		payStructureImpl.setActive(active);

		if (currency == null) {
			payStructureImpl.setCurrency("");
		}
		else {
			payStructureImpl.setCurrency(currency);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			payStructureImpl.setEffectiveDate(null);
		}
		else {
			payStructureImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			payStructureImpl.setExpiryDate(null);
		}
		else {
			payStructureImpl.setExpiryDate(new Date(expiryDate));
		}

		if (name == null) {
			payStructureImpl.setName("");
		}
		else {
			payStructureImpl.setName(name);
		}

		payStructureImpl.setDeleted(deleted);
		payStructureImpl.setStatus(status);

		payStructureImpl.resetOriginalValues();

		return payStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payStructureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		currency = objectInput.readUTF();
		effectiveDate = objectInput.readLong();
		expiryDate = objectInput.readLong();
		name = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(payStructureId);

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

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(effectiveDate);
		objectOutput.writeLong(expiryDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long payStructureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String currency;
	public long effectiveDate;
	public long expiryDate;
	public String name;
	public boolean deleted;
	public int status;

}