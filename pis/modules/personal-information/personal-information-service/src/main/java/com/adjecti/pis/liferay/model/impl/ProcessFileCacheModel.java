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

import com.adjecti.pis.liferay.model.ProcessFile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcessFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcessFileCacheModel
	implements CacheModel<ProcessFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcessFileCacheModel)) {
			return false;
		}

		ProcessFileCacheModel processFileCacheModel =
			(ProcessFileCacheModel)object;

		if (processFileId == processFileCacheModel.processFileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, processFileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", processFileId=");
		sb.append(processFileId);
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
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcessFile toEntityModel() {
		ProcessFileImpl processFileImpl = new ProcessFileImpl();

		if (uuid == null) {
			processFileImpl.setUuid("");
		}
		else {
			processFileImpl.setUuid(uuid);
		}

		processFileImpl.setProcessFileId(processFileId);
		processFileImpl.setGroupId(groupId);
		processFileImpl.setCompanyId(companyId);
		processFileImpl.setUserId(userId);

		if (userName == null) {
			processFileImpl.setUserName("");
		}
		else {
			processFileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			processFileImpl.setCreateDate(null);
		}
		else {
			processFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			processFileImpl.setModifiedDate(null);
		}
		else {
			processFileImpl.setModifiedDate(new Date(modifiedDate));
		}

		processFileImpl.setEmployeeId(employeeId);
		processFileImpl.setProcessFileNo(processFileNo);

		processFileImpl.resetOriginalValues();

		return processFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		processFileId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		processFileNo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(processFileId);

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

		objectOutput.writeLong(processFileNo);
	}

	public String uuid;
	public long processFileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public long processFileNo;

}