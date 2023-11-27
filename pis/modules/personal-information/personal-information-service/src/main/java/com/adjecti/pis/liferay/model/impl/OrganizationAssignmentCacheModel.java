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

import com.adjecti.pis.liferay.model.OrganizationAssignment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrganizationAssignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrganizationAssignmentCacheModel
	implements CacheModel<OrganizationAssignment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrganizationAssignmentCacheModel)) {
			return false;
		}

		OrganizationAssignmentCacheModel organizationAssignmentCacheModel =
			(OrganizationAssignmentCacheModel)object;

		if (organizationAssignmentId ==
				organizationAssignmentCacheModel.organizationAssignmentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationAssignmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{organizationAssignmentId=");
		sb.append(organizationAssignmentId);
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
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", organizationCode=");
		sb.append(organizationCode);
		sb.append(", subOrganizationId=");
		sb.append(subOrganizationId);
		sb.append(", subOrganizationCode=");
		sb.append(subOrganizationCode);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationAssignment toEntityModel() {
		OrganizationAssignmentImpl organizationAssignmentImpl =
			new OrganizationAssignmentImpl();

		organizationAssignmentImpl.setOrganizationAssignmentId(
			organizationAssignmentId);
		organizationAssignmentImpl.setGroupId(groupId);
		organizationAssignmentImpl.setCompanyId(companyId);
		organizationAssignmentImpl.setUserId(userId);

		if (userName == null) {
			organizationAssignmentImpl.setUserName("");
		}
		else {
			organizationAssignmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationAssignmentImpl.setCreateDate(null);
		}
		else {
			organizationAssignmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationAssignmentImpl.setModifiedDate(null);
		}
		else {
			organizationAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationAssignmentImpl.setEmployeeId(employeeId);

		if (personalNo == null) {
			organizationAssignmentImpl.setPersonalNo("");
		}
		else {
			organizationAssignmentImpl.setPersonalNo(personalNo);
		}

		organizationAssignmentImpl.setOrganizationId(organizationId);

		if (organizationCode == null) {
			organizationAssignmentImpl.setOrganizationCode("");
		}
		else {
			organizationAssignmentImpl.setOrganizationCode(organizationCode);
		}

		organizationAssignmentImpl.setSubOrganizationId(subOrganizationId);

		if (subOrganizationCode == null) {
			organizationAssignmentImpl.setSubOrganizationCode("");
		}
		else {
			organizationAssignmentImpl.setSubOrganizationCode(
				subOrganizationCode);
		}

		organizationAssignmentImpl.setActive(active);

		organizationAssignmentImpl.resetOriginalValues();

		return organizationAssignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationAssignmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		personalNo = objectInput.readUTF();

		organizationId = objectInput.readLong();
		organizationCode = objectInput.readUTF();

		subOrganizationId = objectInput.readLong();
		subOrganizationCode = objectInput.readUTF();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(organizationAssignmentId);

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

		if (personalNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalNo);
		}

		objectOutput.writeLong(organizationId);

		if (organizationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationCode);
		}

		objectOutput.writeLong(subOrganizationId);

		if (subOrganizationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subOrganizationCode);
		}

		objectOutput.writeBoolean(active);
	}

	public long organizationAssignmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String personalNo;
	public long organizationId;
	public String organizationCode;
	public long subOrganizationId;
	public String subOrganizationCode;
	public boolean active;

}