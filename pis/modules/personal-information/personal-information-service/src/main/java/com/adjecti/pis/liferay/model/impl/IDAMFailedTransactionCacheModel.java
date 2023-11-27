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

import com.adjecti.pis.liferay.model.IDAMFailedTransaction;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IDAMFailedTransaction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IDAMFailedTransactionCacheModel
	implements CacheModel<IDAMFailedTransaction>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IDAMFailedTransactionCacheModel)) {
			return false;
		}

		IDAMFailedTransactionCacheModel idamFailedTransactionCacheModel =
			(IDAMFailedTransactionCacheModel)object;

		if (idamFailedTransactionId ==
				idamFailedTransactionCacheModel.idamFailedTransactionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idamFailedTransactionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{idamFailedTransactionId=");
		sb.append(idamFailedTransactionId);
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
		sb.append(", classId=");
		sb.append(classId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", idamUrl=");
		sb.append(idamUrl);
		sb.append(", attribute=");
		sb.append(attribute);
		sb.append(", oldValue=");
		sb.append(oldValue);
		sb.append(", newValue=");
		sb.append(newValue);
		sb.append(", error=");
		sb.append(error);
		sb.append(", firedon=");
		sb.append(firedon);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IDAMFailedTransaction toEntityModel() {
		IDAMFailedTransactionImpl idamFailedTransactionImpl =
			new IDAMFailedTransactionImpl();

		idamFailedTransactionImpl.setIdamFailedTransactionId(
			idamFailedTransactionId);
		idamFailedTransactionImpl.setGroupId(groupId);
		idamFailedTransactionImpl.setCompanyId(companyId);
		idamFailedTransactionImpl.setUserId(userId);

		if (userName == null) {
			idamFailedTransactionImpl.setUserName("");
		}
		else {
			idamFailedTransactionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			idamFailedTransactionImpl.setCreateDate(null);
		}
		else {
			idamFailedTransactionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			idamFailedTransactionImpl.setModifiedDate(null);
		}
		else {
			idamFailedTransactionImpl.setModifiedDate(new Date(modifiedDate));
		}

		idamFailedTransactionImpl.setEmployeeId(employeeId);
		idamFailedTransactionImpl.setClassId(classId);

		if (className == null) {
			idamFailedTransactionImpl.setClassName("");
		}
		else {
			idamFailedTransactionImpl.setClassName(className);
		}

		if (idamUrl == null) {
			idamFailedTransactionImpl.setIdamUrl("");
		}
		else {
			idamFailedTransactionImpl.setIdamUrl(idamUrl);
		}

		if (attribute == null) {
			idamFailedTransactionImpl.setAttribute("");
		}
		else {
			idamFailedTransactionImpl.setAttribute(attribute);
		}

		if (oldValue == null) {
			idamFailedTransactionImpl.setOldValue("");
		}
		else {
			idamFailedTransactionImpl.setOldValue(oldValue);
		}

		if (newValue == null) {
			idamFailedTransactionImpl.setNewValue("");
		}
		else {
			idamFailedTransactionImpl.setNewValue(newValue);
		}

		if (error == null) {
			idamFailedTransactionImpl.setError("");
		}
		else {
			idamFailedTransactionImpl.setError(error);
		}

		if (firedon == Long.MIN_VALUE) {
			idamFailedTransactionImpl.setFiredon(null);
		}
		else {
			idamFailedTransactionImpl.setFiredon(new Date(firedon));
		}

		idamFailedTransactionImpl.setDeleted(deleted);
		idamFailedTransactionImpl.setStatus(status);

		idamFailedTransactionImpl.resetOriginalValues();

		return idamFailedTransactionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idamFailedTransactionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		classId = objectInput.readLong();
		className = objectInput.readUTF();
		idamUrl = objectInput.readUTF();
		attribute = objectInput.readUTF();
		oldValue = objectInput.readUTF();
		newValue = objectInput.readUTF();
		error = objectInput.readUTF();
		firedon = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(idamFailedTransactionId);

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

		objectOutput.writeLong(classId);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (idamUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idamUrl);
		}

		if (attribute == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attribute);
		}

		if (oldValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oldValue);
		}

		if (newValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newValue);
		}

		if (error == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(error);
		}

		objectOutput.writeLong(firedon);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long idamFailedTransactionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long classId;
	public String className;
	public String idamUrl;
	public String attribute;
	public String oldValue;
	public String newValue;
	public String error;
	public long firedon;
	public boolean deleted;
	public int status;

}