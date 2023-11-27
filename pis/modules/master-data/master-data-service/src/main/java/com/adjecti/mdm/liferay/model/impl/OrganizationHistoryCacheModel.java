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

import com.adjecti.mdm.liferay.model.OrganizationHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrganizationHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrganizationHistoryCacheModel
	implements CacheModel<OrganizationHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrganizationHistoryCacheModel)) {
			return false;
		}

		OrganizationHistoryCacheModel organizationHistoryCacheModel =
			(OrganizationHistoryCacheModel)object;

		if (organizationHistoryId ==
				organizationHistoryCacheModel.organizationHistoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{organizationHistoryId=");
		sb.append(organizationHistoryId);
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
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", previousOrganizationName=");
		sb.append(previousOrganizationName);
		sb.append(", previousOrganizationId=");
		sb.append(previousOrganizationId);
		sb.append(", previousParentOrganizationName=");
		sb.append(previousParentOrganizationName);
		sb.append(", previousParentOrganizationId=");
		sb.append(previousParentOrganizationId);
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationHistory toEntityModel() {
		OrganizationHistoryImpl organizationHistoryImpl =
			new OrganizationHistoryImpl();

		organizationHistoryImpl.setOrganizationHistoryId(organizationHistoryId);
		organizationHistoryImpl.setGroupId(groupId);
		organizationHistoryImpl.setCompanyId(companyId);
		organizationHistoryImpl.setUserId(userId);

		if (userName == null) {
			organizationHistoryImpl.setUserName("");
		}
		else {
			organizationHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationHistoryImpl.setCreateDate(null);
		}
		else {
			organizationHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationHistoryImpl.setModifiedDate(null);
		}
		else {
			organizationHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationHistoryImpl.setOrganizationId(organizationId);

		if (previousOrganizationName == null) {
			organizationHistoryImpl.setPreviousOrganizationName("");
		}
		else {
			organizationHistoryImpl.setPreviousOrganizationName(
				previousOrganizationName);
		}

		organizationHistoryImpl.setPreviousOrganizationId(
			previousOrganizationId);

		if (previousParentOrganizationName == null) {
			organizationHistoryImpl.setPreviousParentOrganizationName("");
		}
		else {
			organizationHistoryImpl.setPreviousParentOrganizationName(
				previousParentOrganizationName);
		}

		organizationHistoryImpl.setPreviousParentOrganizationId(
			previousParentOrganizationId);

		if (organizationName == null) {
			organizationHistoryImpl.setOrganizationName("");
		}
		else {
			organizationHistoryImpl.setOrganizationName(organizationName);
		}

		if (status == null) {
			organizationHistoryImpl.setStatus("");
		}
		else {
			organizationHistoryImpl.setStatus(status);
		}

		organizationHistoryImpl.resetOriginalValues();

		return organizationHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationHistoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		organizationId = objectInput.readLong();
		previousOrganizationName = objectInput.readUTF();

		previousOrganizationId = objectInput.readLong();
		previousParentOrganizationName = objectInput.readUTF();

		previousParentOrganizationId = objectInput.readLong();
		organizationName = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(organizationHistoryId);

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

		objectOutput.writeLong(organizationId);

		if (previousOrganizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(previousOrganizationName);
		}

		objectOutput.writeLong(previousOrganizationId);

		if (previousParentOrganizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(previousParentOrganizationName);
		}

		objectOutput.writeLong(previousParentOrganizationId);

		if (organizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long organizationHistoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long organizationId;
	public String previousOrganizationName;
	public long previousOrganizationId;
	public String previousParentOrganizationName;
	public long previousParentOrganizationId;
	public String organizationName;
	public String status;

}