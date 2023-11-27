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

import com.adjecti.mdm.liferay.model.OrganizationPayStructure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrganizationPayStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrganizationPayStructureCacheModel
	implements CacheModel<OrganizationPayStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrganizationPayStructureCacheModel)) {
			return false;
		}

		OrganizationPayStructureCacheModel organizationPayStructureCacheModel =
			(OrganizationPayStructureCacheModel)object;

		if (organizationPayStructureId ==
				organizationPayStructureCacheModel.organizationPayStructureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationPayStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{organizationPayStructureId=");
		sb.append(organizationPayStructureId);
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
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationPayStructure toEntityModel() {
		OrganizationPayStructureImpl organizationPayStructureImpl =
			new OrganizationPayStructureImpl();

		organizationPayStructureImpl.setOrganizationPayStructureId(
			organizationPayStructureId);
		organizationPayStructureImpl.setGroupId(groupId);
		organizationPayStructureImpl.setCompanyId(companyId);
		organizationPayStructureImpl.setUserId(userId);

		if (userName == null) {
			organizationPayStructureImpl.setUserName("");
		}
		else {
			organizationPayStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationPayStructureImpl.setCreateDate(null);
		}
		else {
			organizationPayStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationPayStructureImpl.setModifiedDate(null);
		}
		else {
			organizationPayStructureImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		organizationPayStructureImpl.setActive(active);

		if (fromDate == Long.MIN_VALUE) {
			organizationPayStructureImpl.setFromDate(null);
		}
		else {
			organizationPayStructureImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			organizationPayStructureImpl.setToDate(null);
		}
		else {
			organizationPayStructureImpl.setToDate(new Date(toDate));
		}

		organizationPayStructureImpl.setLevelId(levelId);
		organizationPayStructureImpl.setOrganizationId(organizationId);
		organizationPayStructureImpl.setStructureId(structureId);
		organizationPayStructureImpl.setDeleted(deleted);
		organizationPayStructureImpl.setStatus(status);

		organizationPayStructureImpl.resetOriginalValues();

		return organizationPayStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationPayStructureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		levelId = objectInput.readLong();

		organizationId = objectInput.readLong();

		structureId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(organizationPayStructureId);

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
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(levelId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(structureId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long organizationPayStructureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long fromDate;
	public long toDate;
	public long levelId;
	public long organizationId;
	public long structureId;
	public boolean deleted;
	public int status;

}