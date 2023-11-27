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

import com.adjecti.mdm.liferay.model.Trade;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Trade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TradeCacheModel implements CacheModel<Trade>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TradeCacheModel)) {
			return false;
		}

		TradeCacheModel tradeCacheModel = (TradeCacheModel)object;

		if (tradeId == tradeCacheModel.tradeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tradeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{tradeId=");
		sb.append(tradeId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Trade toEntityModel() {
		TradeImpl tradeImpl = new TradeImpl();

		tradeImpl.setTradeId(tradeId);
		tradeImpl.setGroupId(groupId);
		tradeImpl.setCompanyId(companyId);
		tradeImpl.setUserId(userId);

		if (userName == null) {
			tradeImpl.setUserName("");
		}
		else {
			tradeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tradeImpl.setCreateDate(null);
		}
		else {
			tradeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tradeImpl.setModifiedDate(null);
		}
		else {
			tradeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			tradeImpl.setDescription("");
		}
		else {
			tradeImpl.setDescription(description);
		}

		if (code == null) {
			tradeImpl.setCode("");
		}
		else {
			tradeImpl.setCode(code);
		}

		if (name == null) {
			tradeImpl.setName("");
		}
		else {
			tradeImpl.setName(name);
		}

		tradeImpl.setParentId(parentId);
		tradeImpl.setDeleted(deleted);
		tradeImpl.setStatus(status);

		tradeImpl.resetOriginalValues();

		return tradeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tradeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		parentId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tradeId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(parentId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long tradeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
	public String name;
	public long parentId;
	public boolean deleted;
	public int status;

}