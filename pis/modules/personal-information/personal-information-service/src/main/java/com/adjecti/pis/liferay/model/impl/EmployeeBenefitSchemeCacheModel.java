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

import com.adjecti.pis.liferay.model.EmployeeBenefitScheme;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeBenefitScheme in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeBenefitSchemeCacheModel
	implements CacheModel<EmployeeBenefitScheme>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeBenefitSchemeCacheModel)) {
			return false;
		}

		EmployeeBenefitSchemeCacheModel employeeBenefitSchemeCacheModel =
			(EmployeeBenefitSchemeCacheModel)object;

		if (employeeBenefitSchemeId ==
				employeeBenefitSchemeCacheModel.employeeBenefitSchemeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeBenefitSchemeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{employeeBenefitSchemeId=");
		sb.append(employeeBenefitSchemeId);
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
		sb.append(", documentNo=");
		sb.append(documentNo);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", benefitSchemeId=");
		sb.append(benefitSchemeId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeBenefitScheme toEntityModel() {
		EmployeeBenefitSchemeImpl employeeBenefitSchemeImpl =
			new EmployeeBenefitSchemeImpl();

		employeeBenefitSchemeImpl.setEmployeeBenefitSchemeId(
			employeeBenefitSchemeId);
		employeeBenefitSchemeImpl.setGroupId(groupId);
		employeeBenefitSchemeImpl.setCompanyId(companyId);
		employeeBenefitSchemeImpl.setUserId(userId);

		if (userName == null) {
			employeeBenefitSchemeImpl.setUserName("");
		}
		else {
			employeeBenefitSchemeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeBenefitSchemeImpl.setCreateDate(null);
		}
		else {
			employeeBenefitSchemeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeBenefitSchemeImpl.setModifiedDate(null);
		}
		else {
			employeeBenefitSchemeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeBenefitSchemeImpl.setActive(active);

		if (documentNo == null) {
			employeeBenefitSchemeImpl.setDocumentNo("");
		}
		else {
			employeeBenefitSchemeImpl.setDocumentNo(documentNo);
		}

		if (fromDate == Long.MIN_VALUE) {
			employeeBenefitSchemeImpl.setFromDate(null);
		}
		else {
			employeeBenefitSchemeImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			employeeBenefitSchemeImpl.setToDate(null);
		}
		else {
			employeeBenefitSchemeImpl.setToDate(new Date(toDate));
		}

		employeeBenefitSchemeImpl.setEmployeeId(employeeId);
		employeeBenefitSchemeImpl.setBenefitSchemeId(benefitSchemeId);
		employeeBenefitSchemeImpl.setStatus(status);

		employeeBenefitSchemeImpl.resetOriginalValues();

		return employeeBenefitSchemeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeBenefitSchemeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		documentNo = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		benefitSchemeId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeBenefitSchemeId);

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

		if (documentNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNo);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(benefitSchemeId);

		objectOutput.writeInt(status);
	}

	public long employeeBenefitSchemeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String documentNo;
	public long fromDate;
	public long toDate;
	public long employeeId;
	public long benefitSchemeId;
	public int status;

}