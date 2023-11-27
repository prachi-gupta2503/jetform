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

package com.adjecti.pis.model.impl;

import com.adjecti.pis.model.BulkOnbordingFile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BulkOnbordingFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BulkOnbordingFileCacheModel
	implements CacheModel<BulkOnbordingFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BulkOnbordingFileCacheModel)) {
			return false;
		}

		BulkOnbordingFileCacheModel bulkOnbordingFileCacheModel =
			(BulkOnbordingFileCacheModel)object;

		if (bulkOnbordingFileId ==
				bulkOnbordingFileCacheModel.bulkOnbordingFileId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bulkOnbordingFileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);
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
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", title=");
		sb.append(title);
		sb.append(", totalRecords=");
		sb.append(totalRecords);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BulkOnbordingFile toEntityModel() {
		BulkOnbordingFileImpl bulkOnbordingFileImpl =
			new BulkOnbordingFileImpl();

		if (uuid == null) {
			bulkOnbordingFileImpl.setUuid("");
		}
		else {
			bulkOnbordingFileImpl.setUuid(uuid);
		}

		bulkOnbordingFileImpl.setBulkOnbordingFileId(bulkOnbordingFileId);
		bulkOnbordingFileImpl.setGroupId(groupId);
		bulkOnbordingFileImpl.setCompanyId(companyId);
		bulkOnbordingFileImpl.setUserId(userId);

		if (userName == null) {
			bulkOnbordingFileImpl.setUserName("");
		}
		else {
			bulkOnbordingFileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bulkOnbordingFileImpl.setCreateDate(null);
		}
		else {
			bulkOnbordingFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bulkOnbordingFileImpl.setModifiedDate(null);
		}
		else {
			bulkOnbordingFileImpl.setModifiedDate(new Date(modifiedDate));
		}

		bulkOnbordingFileImpl.setFileEntryId(fileEntryId);

		if (fileName == null) {
			bulkOnbordingFileImpl.setFileName("");
		}
		else {
			bulkOnbordingFileImpl.setFileName(fileName);
		}

		if (remarks == null) {
			bulkOnbordingFileImpl.setRemarks("");
		}
		else {
			bulkOnbordingFileImpl.setRemarks(remarks);
		}

		if (title == null) {
			bulkOnbordingFileImpl.setTitle("");
		}
		else {
			bulkOnbordingFileImpl.setTitle(title);
		}

		bulkOnbordingFileImpl.setTotalRecords(totalRecords);
		bulkOnbordingFileImpl.setUnitId(unitId);

		bulkOnbordingFileImpl.resetOriginalValues();

		return bulkOnbordingFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bulkOnbordingFileId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		fileName = objectInput.readUTF();
		remarks = objectInput.readUTF();
		title = objectInput.readUTF();

		totalRecords = objectInput.readLong();

		unitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bulkOnbordingFileId);

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

		objectOutput.writeLong(fileEntryId);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(totalRecords);

		objectOutput.writeLong(unitId);
	}

	public String uuid;
	public long bulkOnbordingFileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fileEntryId;
	public String fileName;
	public String remarks;
	public String title;
	public long totalRecords;
	public long unitId;

}