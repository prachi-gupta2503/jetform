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

import com.adjecti.jetform.liferay.model.EntityWorkflow;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EntityWorkflow in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EntityWorkflowCacheModel
	implements CacheModel<EntityWorkflow>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EntityWorkflowCacheModel)) {
			return false;
		}

		EntityWorkflowCacheModel entityWorkflowCacheModel =
			(EntityWorkflowCacheModel)object;

		if (entityWorkflowId == entityWorkflowCacheModel.entityWorkflowId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entityWorkflowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{entityWorkflowId=");
		sb.append(entityWorkflowId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", remark=");
		sb.append(remark);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EntityWorkflow toEntityModel() {
		EntityWorkflowImpl entityWorkflowImpl = new EntityWorkflowImpl();

		entityWorkflowImpl.setEntityWorkflowId(entityWorkflowId);
		entityWorkflowImpl.setGroupId(groupId);
		entityWorkflowImpl.setCompanyId(companyId);
		entityWorkflowImpl.setUserId(userId);

		if (userName == null) {
			entityWorkflowImpl.setUserName("");
		}
		else {
			entityWorkflowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			entityWorkflowImpl.setCreateDate(null);
		}
		else {
			entityWorkflowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			entityWorkflowImpl.setModifiedDate(null);
		}
		else {
			entityWorkflowImpl.setModifiedDate(new Date(modifiedDate));
		}

		entityWorkflowImpl.setStatus(status);

		if (className == null) {
			entityWorkflowImpl.setClassName("");
		}
		else {
			entityWorkflowImpl.setClassName(className);
		}

		entityWorkflowImpl.setClassPK(classPK);

		if (remark == null) {
			entityWorkflowImpl.setRemark("");
		}
		else {
			entityWorkflowImpl.setRemark(remark);
		}

		entityWorkflowImpl.resetOriginalValues();

		return entityWorkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entityWorkflowId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
		remark = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(entityWorkflowId);

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

		objectOutput.writeInt(status);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (remark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remark);
		}
	}

	public long entityWorkflowId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public String className;
	public long classPK;
	public String remark;

}