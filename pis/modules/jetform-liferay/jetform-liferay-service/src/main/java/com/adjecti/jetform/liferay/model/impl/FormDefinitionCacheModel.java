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

import com.adjecti.jetform.liferay.model.FormDefinition;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormDefinition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormDefinitionCacheModel
	implements CacheModel<FormDefinition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormDefinitionCacheModel)) {
			return false;
		}

		FormDefinitionCacheModel formDefinitionCacheModel =
			(FormDefinitionCacheModel)object;

		if (formDefinitionId == formDefinitionCacheModel.formDefinitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formDefinitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", formDefinitionId=");
		sb.append(formDefinitionId);
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
		sb.append(", formKey=");
		sb.append(formKey);
		sb.append(", formClass=");
		sb.append(formClass);
		sb.append(", entityClass=");
		sb.append(entityClass);
		sb.append(", definition=");
		sb.append(definition);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormDefinition toEntityModel() {
		FormDefinitionImpl formDefinitionImpl = new FormDefinitionImpl();

		if (uuid == null) {
			formDefinitionImpl.setUuid("");
		}
		else {
			formDefinitionImpl.setUuid(uuid);
		}

		formDefinitionImpl.setFormDefinitionId(formDefinitionId);
		formDefinitionImpl.setGroupId(groupId);
		formDefinitionImpl.setCompanyId(companyId);
		formDefinitionImpl.setUserId(userId);

		if (userName == null) {
			formDefinitionImpl.setUserName("");
		}
		else {
			formDefinitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			formDefinitionImpl.setCreateDate(null);
		}
		else {
			formDefinitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formDefinitionImpl.setModifiedDate(null);
		}
		else {
			formDefinitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (formKey == null) {
			formDefinitionImpl.setFormKey("");
		}
		else {
			formDefinitionImpl.setFormKey(formKey);
		}

		if (formClass == null) {
			formDefinitionImpl.setFormClass("");
		}
		else {
			formDefinitionImpl.setFormClass(formClass);
		}

		if (entityClass == null) {
			formDefinitionImpl.setEntityClass("");
		}
		else {
			formDefinitionImpl.setEntityClass(entityClass);
		}

		if (definition == null) {
			formDefinitionImpl.setDefinition("");
		}
		else {
			formDefinitionImpl.setDefinition(definition);
		}

		formDefinitionImpl.resetOriginalValues();

		return formDefinitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		formDefinitionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		formKey = objectInput.readUTF();
		formClass = objectInput.readUTF();
		entityClass = objectInput.readUTF();
		definition = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(formDefinitionId);

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

		if (formKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formKey);
		}

		if (formClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formClass);
		}

		if (entityClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityClass);
		}

		if (definition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(definition);
		}
	}

	public String uuid;
	public long formDefinitionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String formKey;
	public String formClass;
	public String entityClass;
	public String definition;

}