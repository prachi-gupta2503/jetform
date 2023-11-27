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

import com.adjecti.pis.liferay.model.EmployeeDocument;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDocument in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDocumentCacheModel
	implements CacheModel<EmployeeDocument>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDocumentCacheModel)) {
			return false;
		}

		EmployeeDocumentCacheModel employeeDocumentCacheModel =
			(EmployeeDocumentCacheModel)object;

		if (employeeDocumentId ==
				employeeDocumentCacheModel.employeeDocumentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDocumentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employeeDocumentId=");
		sb.append(employeeDocumentId);
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
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", documentTypeId=");
		sb.append(documentTypeId);
		sb.append(", discription=");
		sb.append(discription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDocument toEntityModel() {
		EmployeeDocumentImpl employeeDocumentImpl = new EmployeeDocumentImpl();

		employeeDocumentImpl.setEmployeeDocumentId(employeeDocumentId);
		employeeDocumentImpl.setGroupId(groupId);
		employeeDocumentImpl.setCompanyId(companyId);
		employeeDocumentImpl.setUserId(userId);

		if (userName == null) {
			employeeDocumentImpl.setUserName("");
		}
		else {
			employeeDocumentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDocumentImpl.setCreateDate(null);
		}
		else {
			employeeDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDocumentImpl.setModifiedDate(null);
		}
		else {
			employeeDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDocumentImpl.setActive(active);
		employeeDocumentImpl.setDocumentId(documentId);
		employeeDocumentImpl.setEmployeeId(employeeId);

		if (title == null) {
			employeeDocumentImpl.setTitle("");
		}
		else {
			employeeDocumentImpl.setTitle(title);
		}

		employeeDocumentImpl.setDocumentTypeId(documentTypeId);

		if (discription == null) {
			employeeDocumentImpl.setDiscription("");
		}
		else {
			employeeDocumentImpl.setDiscription(discription);
		}

		employeeDocumentImpl.resetOriginalValues();

		return employeeDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeDocumentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();

		documentId = objectInput.readLong();

		employeeId = objectInput.readLong();
		title = objectInput.readUTF();

		documentTypeId = objectInput.readLong();
		discription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeDocumentId);

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

		objectOutput.writeLong(documentId);

		objectOutput.writeLong(employeeId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(documentTypeId);

		if (discription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(discription);
		}
	}

	public long employeeDocumentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long documentId;
	public long employeeId;
	public String title;
	public long documentTypeId;
	public String discription;

}