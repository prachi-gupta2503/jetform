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

import com.adjecti.pis.liferay.model.JoiningProcessRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JoiningProcessRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JoiningProcessRequestCacheModel
	implements CacheModel<JoiningProcessRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JoiningProcessRequestCacheModel)) {
			return false;
		}

		JoiningProcessRequestCacheModel joiningProcessRequestCacheModel =
			(JoiningProcessRequestCacheModel)object;

		if (joiningProcessRequestId ==
				joiningProcessRequestCacheModel.joiningProcessRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, joiningProcessRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", joiningProcessRequestId=");
		sb.append(joiningProcessRequestId);
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
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", processFileId=");
		sb.append(processFileId);
		sb.append(", processFileNo=");
		sb.append(processFileNo);
		sb.append(", officeOrderNo=");
		sb.append(officeOrderNo);
		sb.append(", doPart1Content=");
		sb.append(doPart1Content);
		sb.append(", doPart1FileId=");
		sb.append(doPart1FileId);
		sb.append(", doPart2Content=");
		sb.append(doPart2Content);
		sb.append(", doPart2FileId=");
		sb.append(doPart2FileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JoiningProcessRequest toEntityModel() {
		JoiningProcessRequestImpl joiningProcessRequestImpl =
			new JoiningProcessRequestImpl();

		if (uuid == null) {
			joiningProcessRequestImpl.setUuid("");
		}
		else {
			joiningProcessRequestImpl.setUuid(uuid);
		}

		joiningProcessRequestImpl.setJoiningProcessRequestId(
			joiningProcessRequestId);
		joiningProcessRequestImpl.setGroupId(groupId);
		joiningProcessRequestImpl.setCompanyId(companyId);
		joiningProcessRequestImpl.setUserId(userId);

		if (userName == null) {
			joiningProcessRequestImpl.setUserName("");
		}
		else {
			joiningProcessRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			joiningProcessRequestImpl.setCreateDate(null);
		}
		else {
			joiningProcessRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			joiningProcessRequestImpl.setModifiedDate(null);
		}
		else {
			joiningProcessRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		joiningProcessRequestImpl.setJoiningProcessId(joiningProcessId);
		joiningProcessRequestImpl.setEmployeeId(employeeId);
		joiningProcessRequestImpl.setProcessFileId(processFileId);

		if (processFileNo == null) {
			joiningProcessRequestImpl.setProcessFileNo("");
		}
		else {
			joiningProcessRequestImpl.setProcessFileNo(processFileNo);
		}

		if (officeOrderNo == null) {
			joiningProcessRequestImpl.setOfficeOrderNo("");
		}
		else {
			joiningProcessRequestImpl.setOfficeOrderNo(officeOrderNo);
		}

		if (doPart1Content == null) {
			joiningProcessRequestImpl.setDoPart1Content("");
		}
		else {
			joiningProcessRequestImpl.setDoPart1Content(doPart1Content);
		}

		joiningProcessRequestImpl.setDoPart1FileId(doPart1FileId);

		if (doPart2Content == null) {
			joiningProcessRequestImpl.setDoPart2Content("");
		}
		else {
			joiningProcessRequestImpl.setDoPart2Content(doPart2Content);
		}

		joiningProcessRequestImpl.setDoPart2FileId(doPart2FileId);

		joiningProcessRequestImpl.resetOriginalValues();

		return joiningProcessRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		joiningProcessRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		employeeId = objectInput.readLong();

		processFileId = objectInput.readLong();
		processFileNo = objectInput.readUTF();
		officeOrderNo = objectInput.readUTF();
		doPart1Content = objectInput.readUTF();

		doPart1FileId = objectInput.readLong();
		doPart2Content = objectInput.readUTF();

		doPart2FileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(joiningProcessRequestId);

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

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(processFileId);

		if (processFileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processFileNo);
		}

		if (officeOrderNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeOrderNo);
		}

		if (doPart1Content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doPart1Content);
		}

		objectOutput.writeLong(doPart1FileId);

		if (doPart2Content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doPart2Content);
		}

		objectOutput.writeLong(doPart2FileId);
	}

	public String uuid;
	public long joiningProcessRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long joiningProcessId;
	public long employeeId;
	public long processFileId;
	public String processFileNo;
	public String officeOrderNo;
	public String doPart1Content;
	public long doPart1FileId;
	public String doPart2Content;
	public long doPart2FileId;

}