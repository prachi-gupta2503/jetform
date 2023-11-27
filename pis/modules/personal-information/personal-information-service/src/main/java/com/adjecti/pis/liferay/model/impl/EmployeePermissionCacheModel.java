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

import com.adjecti.pis.liferay.model.EmployeePermission;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeePermission in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeePermissionCacheModel
	implements CacheModel<EmployeePermission>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePermissionCacheModel)) {
			return false;
		}

		EmployeePermissionCacheModel employeePermissionCacheModel =
			(EmployeePermissionCacheModel)object;

		if (employeePermissionId ==
				employeePermissionCacheModel.employeePermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeePermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{employeePermissionId=");
		sb.append(employeePermissionId);
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
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", idamUser=");
		sb.append(idamUser);
		sb.append(", digitalSigning=");
		sb.append(digitalSigning);
		sb.append(", pisAccess=");
		sb.append(pisAccess);
		sb.append(", emailAccess=");
		sb.append(emailAccess);
		sb.append(", eGovAccess=");
		sb.append(eGovAccess);
		sb.append(", idamUserCreated=");
		sb.append(idamUserCreated);
		sb.append(", userCreated=");
		sb.append(userCreated);
		sb.append(", employeeCreated=");
		sb.append(employeeCreated);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", personalNo=");
		sb.append(personalNo);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", designationId=");
		sb.append(designationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", joiningProcessId=");
		sb.append(joiningProcessId);
		sb.append(", singleUserOnboardingId=");
		sb.append(singleUserOnboardingId);
		sb.append(", registrationRequestId=");
		sb.append(registrationRequestId);
		sb.append(", form=");
		sb.append(form);
		sb.append(", currentState=");
		sb.append(currentState);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePermission toEntityModel() {
		EmployeePermissionImpl employeePermissionImpl =
			new EmployeePermissionImpl();

		employeePermissionImpl.setEmployeePermissionId(employeePermissionId);
		employeePermissionImpl.setGroupId(groupId);
		employeePermissionImpl.setCompanyId(companyId);
		employeePermissionImpl.setUserId(userId);

		if (userName == null) {
			employeePermissionImpl.setUserName("");
		}
		else {
			employeePermissionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeePermissionImpl.setCreateDate(null);
		}
		else {
			employeePermissionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeePermissionImpl.setModifiedDate(null);
		}
		else {
			employeePermissionImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeePermissionImpl.setStatus(status);
		employeePermissionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			employeePermissionImpl.setStatusByUserName("");
		}
		else {
			employeePermissionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			employeePermissionImpl.setStatusDate(null);
		}
		else {
			employeePermissionImpl.setStatusDate(new Date(statusDate));
		}

		employeePermissionImpl.setIdamUser(idamUser);
		employeePermissionImpl.setDigitalSigning(digitalSigning);
		employeePermissionImpl.setPisAccess(pisAccess);
		employeePermissionImpl.setEmailAccess(emailAccess);
		employeePermissionImpl.setEGovAccess(eGovAccess);
		employeePermissionImpl.setIdamUserCreated(idamUserCreated);
		employeePermissionImpl.setUserCreated(userCreated);
		employeePermissionImpl.setEmployeeCreated(employeeCreated);

		if (firstName == null) {
			employeePermissionImpl.setFirstName("");
		}
		else {
			employeePermissionImpl.setFirstName(firstName);
		}

		employeePermissionImpl.setPersonalNo(personalNo);

		if (lastName == null) {
			employeePermissionImpl.setLastName("");
		}
		else {
			employeePermissionImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			employeePermissionImpl.setEmailAddress("");
		}
		else {
			employeePermissionImpl.setEmailAddress(emailAddress);
		}

		employeePermissionImpl.setDesignationId(designationId);
		employeePermissionImpl.setEmployeeId(employeeId);
		employeePermissionImpl.setJoiningProcessId(joiningProcessId);
		employeePermissionImpl.setSingleUserOnboardingId(
			singleUserOnboardingId);
		employeePermissionImpl.setRegistrationRequestId(registrationRequestId);

		if (form == null) {
			employeePermissionImpl.setForm("");
		}
		else {
			employeePermissionImpl.setForm(form);
		}

		if (currentState == null) {
			employeePermissionImpl.setCurrentState("");
		}
		else {
			employeePermissionImpl.setCurrentState(currentState);
		}

		employeePermissionImpl.resetOriginalValues();

		return employeePermissionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeePermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		idamUser = objectInput.readBoolean();

		digitalSigning = objectInput.readBoolean();

		pisAccess = objectInput.readBoolean();

		emailAccess = objectInput.readBoolean();

		eGovAccess = objectInput.readBoolean();

		idamUserCreated = objectInput.readBoolean();

		userCreated = objectInput.readBoolean();

		employeeCreated = objectInput.readBoolean();
		firstName = objectInput.readUTF();

		personalNo = objectInput.readLong();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		designationId = objectInput.readLong();

		employeeId = objectInput.readLong();

		joiningProcessId = objectInput.readLong();

		singleUserOnboardingId = objectInput.readLong();

		registrationRequestId = objectInput.readLong();
		form = objectInput.readUTF();
		currentState = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeePermissionId);

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

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeBoolean(idamUser);

		objectOutput.writeBoolean(digitalSigning);

		objectOutput.writeBoolean(pisAccess);

		objectOutput.writeBoolean(emailAccess);

		objectOutput.writeBoolean(eGovAccess);

		objectOutput.writeBoolean(idamUserCreated);

		objectOutput.writeBoolean(userCreated);

		objectOutput.writeBoolean(employeeCreated);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		objectOutput.writeLong(personalNo);

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(designationId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(joiningProcessId);

		objectOutput.writeLong(singleUserOnboardingId);

		objectOutput.writeLong(registrationRequestId);

		if (form == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(form);
		}

		if (currentState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentState);
		}
	}

	public long employeePermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean idamUser;
	public boolean digitalSigning;
	public boolean pisAccess;
	public boolean emailAccess;
	public boolean eGovAccess;
	public boolean idamUserCreated;
	public boolean userCreated;
	public boolean employeeCreated;
	public String firstName;
	public long personalNo;
	public String lastName;
	public String emailAddress;
	public long designationId;
	public long employeeId;
	public long joiningProcessId;
	public long singleUserOnboardingId;
	public long registrationRequestId;
	public String form;
	public String currentState;

}