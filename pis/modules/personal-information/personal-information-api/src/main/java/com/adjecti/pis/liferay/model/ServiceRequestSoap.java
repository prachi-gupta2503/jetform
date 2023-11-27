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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.ServiceRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestSoap implements Serializable {

	public static ServiceRequestSoap toSoapModel(ServiceRequest model) {
		ServiceRequestSoap soapModel = new ServiceRequestSoap();

		soapModel.setServiceRequestId(model.getServiceRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setServiceRequestTypeId(model.getServiceRequestTypeId());
		soapModel.setSubject(model.getSubject());
		soapModel.setDescription(model.getDescription());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDocumentProofId(model.getDocumentProofId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setStatus(model.getStatus());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setState(model.getState());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static ServiceRequestSoap[] toSoapModels(ServiceRequest[] models) {
		ServiceRequestSoap[] soapModels = new ServiceRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestSoap[][] toSoapModels(
		ServiceRequest[][] models) {

		ServiceRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestSoap[] toSoapModels(
		List<ServiceRequest> models) {

		List<ServiceRequestSoap> soapModels = new ArrayList<ServiceRequestSoap>(
			models.size());

		for (ServiceRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceRequestSoap[soapModels.size()]);
	}

	public ServiceRequestSoap() {
	}

	public long getPrimaryKey() {
		return _serviceRequestId;
	}

	public void setPrimaryKey(long pk) {
		setServiceRequestId(pk);
	}

	public long getServiceRequestId() {
		return _serviceRequestId;
	}

	public void setServiceRequestId(long serviceRequestId) {
		_serviceRequestId = serviceRequestId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getServiceRequestTypeId() {
		return _serviceRequestTypeId;
	}

	public void setServiceRequestTypeId(long serviceRequestTypeId) {
		_serviceRequestTypeId = serviceRequestTypeId;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getDocumentProofId() {
		return _documentProofId;
	}

	public void setDocumentProofId(long documentProofId) {
		_documentProofId = documentProofId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public Long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(Long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
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

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _serviceRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _serviceRequestTypeId;
	private String _subject;
	private String _description;
	private long _employeeId;
	private long _documentProofId;
	private long _organizationId;
	private Long _joiningProcessId;
	private int _status;
	private boolean _deleted;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _state;
	private String _comments;

}