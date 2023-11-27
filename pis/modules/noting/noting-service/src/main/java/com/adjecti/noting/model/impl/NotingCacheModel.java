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

package com.adjecti.noting.model.impl;

import com.adjecti.noting.model.Noting;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Noting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NotingCacheModel implements CacheModel<Noting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotingCacheModel)) {
			return false;
		}

		NotingCacheModel notingCacheModel = (NotingCacheModel)object;

		if (noteId == notingCacheModel.noteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, noteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", noteId=");
		sb.append(noteId);
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
		sb.append(", content=");
		sb.append(content);
		sb.append(", title=");
		sb.append(title);
		sb.append(", pdfId=");
		sb.append(pdfId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Noting toEntityModel() {
		NotingImpl notingImpl = new NotingImpl();

		if (uuid == null) {
			notingImpl.setUuid("");
		}
		else {
			notingImpl.setUuid(uuid);
		}

		notingImpl.setNoteId(noteId);
		notingImpl.setGroupId(groupId);
		notingImpl.setCompanyId(companyId);
		notingImpl.setUserId(userId);

		if (userName == null) {
			notingImpl.setUserName("");
		}
		else {
			notingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notingImpl.setCreateDate(null);
		}
		else {
			notingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notingImpl.setModifiedDate(null);
		}
		else {
			notingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (content == null) {
			notingImpl.setContent("");
		}
		else {
			notingImpl.setContent(content);
		}

		if (title == null) {
			notingImpl.setTitle("");
		}
		else {
			notingImpl.setTitle(title);
		}

		notingImpl.setPdfId(pdfId);

		notingImpl.resetOriginalValues();

		return notingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		noteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		content = objectInput.readUTF();
		title = objectInput.readUTF();

		pdfId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(noteId);

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

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(pdfId);
	}

	public String uuid;
	public long noteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String content;
	public String title;
	public long pdfId;

}