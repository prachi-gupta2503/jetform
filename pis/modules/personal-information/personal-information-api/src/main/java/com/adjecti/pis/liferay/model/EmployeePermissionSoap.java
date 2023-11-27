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

package com.adjecti.pis.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeePermissionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeePermissionSoap implements Serializable {

	public static EmployeePermissionSoap toSoapModel(EmployeePermission model) {
		EmployeePermissionSoap soapModel = new EmployeePermissionSoap();

		soapModel.setEmployeePermissionId(model.getEmployeePermissionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setIdamUser(model.isIdamUser());
		soapModel.setDigitalSigning(model.isDigitalSigning());
		soapModel.setPisAccess(model.isPisAccess());
		soapModel.setEmailAccess(model.isEmailAccess());
		soapModel.setEGovAccess(model.isEGovAccess());
		soapModel.setIdamUserCreated(model.isIdamUserCreated());
		soapModel.setUserCreated(model.isUserCreated());
		soapModel.setEmployeeCreated(model.isEmployeeCreated());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setDesignationId(model.getDesignationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setSingleUserOnboardingId(model.getSingleUserOnboardingId());
		soapModel.setRegistrationRequestId(model.getRegistrationRequestId());
		soapModel.setForm(model.getForm());
		soapModel.setCurrentState(model.getCurrentState());

		return soapModel;
	}

	public static EmployeePermissionSoap[] toSoapModels(
		EmployeePermission[] models) {

		EmployeePermissionSoap[] soapModels =
			new EmployeePermissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeePermissionSoap[][] toSoapModels(
		EmployeePermission[][] models) {

		EmployeePermissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeePermissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeePermissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeePermissionSoap[] toSoapModels(
		List<EmployeePermission> models) {

		List<EmployeePermissionSoap> soapModels =
			new ArrayList<EmployeePermissionSoap>(models.size());

		for (EmployeePermission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeePermissionSoap[soapModels.size()]);
	}

	public EmployeePermissionSoap() {
	}

	public long getPrimaryKey() {
		return _employeePermissionId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeePermissionId(pk);
	}

	public long getEmployeePermissionId() {
		return _employeePermissionId;
	}

	public void setEmployeePermissionId(long employeePermissionId) {
		_employeePermissionId = employeePermissionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public boolean getIdamUser() {
		return _idamUser;
	}

	public boolean isIdamUser() {
		return _idamUser;
	}

	public void setIdamUser(boolean idamUser) {
		_idamUser = idamUser;
	}

	public boolean getDigitalSigning() {
		return _digitalSigning;
	}

	public boolean isDigitalSigning() {
		return _digitalSigning;
	}

	public void setDigitalSigning(boolean digitalSigning) {
		_digitalSigning = digitalSigning;
	}

	public boolean getPisAccess() {
		return _pisAccess;
	}

	public boolean isPisAccess() {
		return _pisAccess;
	}

	public void setPisAccess(boolean pisAccess) {
		_pisAccess = pisAccess;
	}

	public boolean getEmailAccess() {
		return _emailAccess;
	}

	public boolean isEmailAccess() {
		return _emailAccess;
	}

	public void setEmailAccess(boolean emailAccess) {
		_emailAccess = emailAccess;
	}

	public boolean getEGovAccess() {
		return _eGovAccess;
	}

	public boolean isEGovAccess() {
		return _eGovAccess;
	}

	public void setEGovAccess(boolean eGovAccess) {
		_eGovAccess = eGovAccess;
	}

	public boolean getIdamUserCreated() {
		return _idamUserCreated;
	}

	public boolean isIdamUserCreated() {
		return _idamUserCreated;
	}

	public void setIdamUserCreated(boolean idamUserCreated) {
		_idamUserCreated = idamUserCreated;
	}

	public boolean getUserCreated() {
		return _userCreated;
	}

	public boolean isUserCreated() {
		return _userCreated;
	}

	public void setUserCreated(boolean userCreated) {
		_userCreated = userCreated;
	}

	public boolean getEmployeeCreated() {
		return _employeeCreated;
	}

	public boolean isEmployeeCreated() {
		return _employeeCreated;
	}

	public void setEmployeeCreated(boolean employeeCreated) {
		_employeeCreated = employeeCreated;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public long getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(long personalNo) {
		_personalNo = personalNo;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getDesignationId() {
		return _designationId;
	}

	public void setDesignationId(long designationId) {
		_designationId = designationId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public long getSingleUserOnboardingId() {
		return _singleUserOnboardingId;
	}

	public void setSingleUserOnboardingId(long singleUserOnboardingId) {
		_singleUserOnboardingId = singleUserOnboardingId;
	}

	public long getRegistrationRequestId() {
		return _registrationRequestId;
	}

	public void setRegistrationRequestId(long registrationRequestId) {
		_registrationRequestId = registrationRequestId;
	}

	public String getForm() {
		return _form;
	}

	public void setForm(String form) {
		_form = form;
	}

	public String getCurrentState() {
		return _currentState;
	}

	public void setCurrentState(String currentState) {
		_currentState = currentState;
	}

	private long _employeePermissionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _idamUser;
	private boolean _digitalSigning;
	private boolean _pisAccess;
	private boolean _emailAccess;
	private boolean _eGovAccess;
	private boolean _idamUserCreated;
	private boolean _userCreated;
	private boolean _employeeCreated;
	private String _firstName;
	private long _personalNo;
	private String _lastName;
	private String _emailAddress;
	private long _designationId;
	private long _employeeId;
	private long _joiningProcessId;
	private long _singleUserOnboardingId;
	private long _registrationRequestId;
	private String _form;
	private String _currentState;

}