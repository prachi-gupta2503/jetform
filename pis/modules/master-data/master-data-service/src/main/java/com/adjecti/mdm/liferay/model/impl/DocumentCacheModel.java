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

import com.adjecti.mdm.liferay.model.Document;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentCacheModel
	implements CacheModel<Document>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentCacheModel)) {
			return false;
		}

		DocumentCacheModel documentCacheModel = (DocumentCacheModel)object;

		if (documentId == documentCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{documentId=");
		sb.append(documentId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", path=");
		sb.append(path);
		sb.append(", refNo=");
		sb.append(refNo);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(documentId);
		documentImpl.setGroupId(groupId);
		documentImpl.setCompanyId(companyId);
		documentImpl.setUserId(userId);

		if (userName == null) {
			documentImpl.setUserName("");
		}
		else {
			documentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			documentImpl.setDescription("");
		}
		else {
			documentImpl.setDescription(description);
		}

		if (name == null) {
			documentImpl.setName("");
		}
		else {
			documentImpl.setName(name);
		}

		if (path == null) {
			documentImpl.setPath("");
		}
		else {
			documentImpl.setPath(path);
		}

		if (refNo == null) {
			documentImpl.setRefNo("");
		}
		else {
			documentImpl.setRefNo(refNo);
		}

		if (typeId == null) {
			documentImpl.setTypeId("");
		}
		else {
			documentImpl.setTypeId(typeId);
		}

		documentImpl.setDeleted(deleted);
		documentImpl.setStatus(status);

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		name = objectInput.readUTF();
		path = objectInput.readUTF();
		refNo = objectInput.readUTF();
		typeId = objectInput.readUTF();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(documentId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
		}

		if (refNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refNo);
		}

		if (typeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeId);
		}

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long documentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String name;
	public String path;
	public String refNo;
	public String typeId;
	public boolean deleted;
	public int status;

}