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

package net.ayudh.comnet.admin.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.ayudh.comnet.admin.service.http.ApplicationUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ApplicationUserSoap implements Serializable {

	public static ApplicationUserSoap toSoapModel(ApplicationUser model) {
		ApplicationUserSoap soapModel = new ApplicationUserSoap();

		soapModel.setApplicationUserId(model.getApplicationUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setLoginId(model.getLoginId());
		soapModel.setStatus(model.getStatus());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setIdamUser(model.isIdamUser());
		soapModel.setEmailAccess(model.isEmailAccess());
		soapModel.setDigitalSigning(model.isDigitalSigning());
		soapModel.setEGovAccess(model.isEGovAccess());
		soapModel.setPisAccess(model.isPisAccess());
		soapModel.setLastIdamUser(model.isLastIdamUser());
		soapModel.setLastEmailAccess(model.isLastEmailAccess());
		soapModel.setLastDigitalSigning(model.isLastDigitalSigning());
		soapModel.setLastEGovAccess(model.isLastEGovAccess());
		soapModel.setLastPisAccess(model.isLastPisAccess());
		soapModel.setIdamServiceStatus(model.isIdamServiceStatus());
		soapModel.setIdamServiceMessage(model.getIdamServiceMessage());
		soapModel.setIdamUserCreated(model.isIdamUserCreated());

		return soapModel;
	}

	public static ApplicationUserSoap[] toSoapModels(ApplicationUser[] models) {
		ApplicationUserSoap[] soapModels =
			new ApplicationUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationUserSoap[][] toSoapModels(
		ApplicationUser[][] models) {

		ApplicationUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ApplicationUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationUserSoap[] toSoapModels(
		List<ApplicationUser> models) {

		List<ApplicationUserSoap> soapModels =
			new ArrayList<ApplicationUserSoap>(models.size());

		for (ApplicationUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationUserSoap[soapModels.size()]);
	}

	public ApplicationUserSoap() {
	}

	public long getPrimaryKey() {
		return _applicationUserId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationUserId(pk);
	}

	public long getApplicationUserId() {
		return _applicationUserId;
	}

	public void setApplicationUserId(long applicationUserId) {
		_applicationUserId = applicationUserId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getLoginId() {
		return _loginId;
	}

	public void setLoginId(String loginId) {
		_loginId = loginId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
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

	public boolean getEmailAccess() {
		return _emailAccess;
	}

	public boolean isEmailAccess() {
		return _emailAccess;
	}

	public void setEmailAccess(boolean emailAccess) {
		_emailAccess = emailAccess;
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

	public boolean getEGovAccess() {
		return _eGovAccess;
	}

	public boolean isEGovAccess() {
		return _eGovAccess;
	}

	public void setEGovAccess(boolean eGovAccess) {
		_eGovAccess = eGovAccess;
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

	public boolean getLastIdamUser() {
		return _lastIdamUser;
	}

	public boolean isLastIdamUser() {
		return _lastIdamUser;
	}

	public void setLastIdamUser(boolean lastIdamUser) {
		_lastIdamUser = lastIdamUser;
	}

	public boolean getLastEmailAccess() {
		return _lastEmailAccess;
	}

	public boolean isLastEmailAccess() {
		return _lastEmailAccess;
	}

	public void setLastEmailAccess(boolean lastEmailAccess) {
		_lastEmailAccess = lastEmailAccess;
	}

	public boolean getLastDigitalSigning() {
		return _lastDigitalSigning;
	}

	public boolean isLastDigitalSigning() {
		return _lastDigitalSigning;
	}

	public void setLastDigitalSigning(boolean lastDigitalSigning) {
		_lastDigitalSigning = lastDigitalSigning;
	}

	public boolean getLastEGovAccess() {
		return _lastEGovAccess;
	}

	public boolean isLastEGovAccess() {
		return _lastEGovAccess;
	}

	public void setLastEGovAccess(boolean lastEGovAccess) {
		_lastEGovAccess = lastEGovAccess;
	}

	public boolean getLastPisAccess() {
		return _lastPisAccess;
	}

	public boolean isLastPisAccess() {
		return _lastPisAccess;
	}

	public void setLastPisAccess(boolean lastPisAccess) {
		_lastPisAccess = lastPisAccess;
	}

	public boolean getIdamServiceStatus() {
		return _idamServiceStatus;
	}

	public boolean isIdamServiceStatus() {
		return _idamServiceStatus;
	}

	public void setIdamServiceStatus(boolean idamServiceStatus) {
		_idamServiceStatus = idamServiceStatus;
	}

	public String getIdamServiceMessage() {
		return _idamServiceMessage;
	}

	public void setIdamServiceMessage(String idamServiceMessage) {
		_idamServiceMessage = idamServiceMessage;
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

	private long _applicationUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _loginId;
	private int _status;
	private boolean _deleted;
	private boolean _idamUser;
	private boolean _emailAccess;
	private boolean _digitalSigning;
	private boolean _eGovAccess;
	private boolean _pisAccess;
	private boolean _lastIdamUser;
	private boolean _lastEmailAccess;
	private boolean _lastDigitalSigning;
	private boolean _lastEGovAccess;
	private boolean _lastPisAccess;
	private boolean _idamServiceStatus;
	private String _idamServiceMessage;
	private boolean _idamUserCreated;

}