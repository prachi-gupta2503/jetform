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

package com.adjecti.jetform.liferay.model.impl;

import com.adjecti.jetform.liferay.model.ImportMasterEntity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ImportMasterEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImportMasterEntityCacheModel
	implements CacheModel<ImportMasterEntity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImportMasterEntityCacheModel)) {
			return false;
		}

		ImportMasterEntityCacheModel importMasterEntityCacheModel =
			(ImportMasterEntityCacheModel)object;

		if (importMasterEntityId ==
				importMasterEntityCacheModel.importMasterEntityId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, importMasterEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{importMasterEntityId=");
		sb.append(importMasterEntityId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", entityClass=");
		sb.append(entityClass);
		sb.append(", description=");
		sb.append(description);
		sb.append(", importFileId=");
		sb.append(importFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportMasterEntity toEntityModel() {
		ImportMasterEntityImpl importMasterEntityImpl =
			new ImportMasterEntityImpl();

		importMasterEntityImpl.setImportMasterEntityId(importMasterEntityId);
		importMasterEntityImpl.setGroupId(groupId);
		importMasterEntityImpl.setCompanyId(companyId);
		importMasterEntityImpl.setUserId(userId);

		if (userName == null) {
			importMasterEntityImpl.setUserName("");
		}
		else {
			importMasterEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importMasterEntityImpl.setCreateDate(null);
		}
		else {
			importMasterEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importMasterEntityImpl.setModifiedDate(null);
		}
		else {
			importMasterEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			importMasterEntityImpl.setName("");
		}
		else {
			importMasterEntityImpl.setName(name);
		}

		if (entityClass == null) {
			importMasterEntityImpl.setEntityClass("");
		}
		else {
			importMasterEntityImpl.setEntityClass(entityClass);
		}

		if (description == null) {
			importMasterEntityImpl.setDescription("");
		}
		else {
			importMasterEntityImpl.setDescription(description);
		}

		importMasterEntityImpl.setImportFileId(importFileId);

		importMasterEntityImpl.resetOriginalValues();

		return importMasterEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		importMasterEntityId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		entityClass = objectInput.readUTF();
		description = objectInput.readUTF();

		importFileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(importMasterEntityId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (entityClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityClass);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(importFileId);
	}

	public long importMasterEntityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String entityClass;
	public String description;
	public long importFileId;

}