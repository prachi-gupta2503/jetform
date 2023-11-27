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

import com.adjecti.mdm.liferay.model.DesignationScope;
import com.adjecti.mdm.liferay.service.persistence.DesignationScopePK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DesignationScope in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationScopeCacheModel
	implements CacheModel<DesignationScope>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationScopeCacheModel)) {
			return false;
		}

		DesignationScopeCacheModel designationScopeCacheModel =
			(DesignationScopeCacheModel)object;

		if (designationScopePK.equals(
				designationScopeCacheModel.designationScopePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, designationScopePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{designationScopeId=");
		sb.append(designationScopeId);
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
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", scopeType=");
		sb.append(scopeType);
		sb.append(", scopeOrganizationId=");
		sb.append(scopeOrganizationId);
		sb.append(", scopeOrganizationTypeId=");
		sb.append(scopeOrganizationTypeId);
		sb.append(", scopePostId=");
		sb.append(scopePostId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DesignationScope toEntityModel() {
		DesignationScopeImpl designationScopeImpl = new DesignationScopeImpl();

		designationScopeImpl.setDesignationScopeId(designationScopeId);
		designationScopeImpl.setGroupId(groupId);
		designationScopeImpl.setCompanyId(companyId);
		designationScopeImpl.setUserId(userId);

		if (userName == null) {
			designationScopeImpl.setUserName("");
		}
		else {
			designationScopeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			designationScopeImpl.setCreateDate(null);
		}
		else {
			designationScopeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designationScopeImpl.setModifiedDate(null);
		}
		else {
			designationScopeImpl.setModifiedDate(new Date(modifiedDate));
		}

		designationScopeImpl.setDesignationId(designationId);
		designationScopeImpl.setScopeType(scopeType);
		designationScopeImpl.setScopeOrganizationId(scopeOrganizationId);
		designationScopeImpl.setScopeOrganizationTypeId(
			scopeOrganizationTypeId);
		designationScopeImpl.setScopePostId(scopePostId);
		designationScopeImpl.setDeleted(deleted);
		designationScopeImpl.setStatus(status);

		designationScopeImpl.resetOriginalValues();

		return designationScopeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designationScopeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		designationId = objectInput.readLong();

		scopeType = objectInput.readInt();

		scopeOrganizationId = objectInput.readLong();

		scopeOrganizationTypeId = objectInput.readLong();

		scopePostId = objectInput.readLong();

		deleted = objectInput.readBoolean();

		status = objectInput.readInt();

		designationScopePK = new DesignationScopePK(
			designationScopeId, designationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(designationScopeId);

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

		objectOutput.writeLong(designationId);

		objectOutput.writeInt(scopeType);

		objectOutput.writeLong(scopeOrganizationId);

		objectOutput.writeLong(scopeOrganizationTypeId);

		objectOutput.writeLong(scopePostId);

		objectOutput.writeBoolean(deleted);

		objectOutput.writeInt(status);
	}

	public long designationScopeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long designationId;
	public int scopeType;
	public long scopeOrganizationId;
	public long scopeOrganizationTypeId;
	public long scopePostId;
	public boolean deleted;
	public int status;
	public transient DesignationScopePK designationScopePK;

}