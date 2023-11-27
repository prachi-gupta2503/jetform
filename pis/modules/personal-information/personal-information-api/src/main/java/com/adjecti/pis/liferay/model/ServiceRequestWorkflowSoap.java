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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.ServiceRequestWorkflowServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestWorkflowSoap implements Serializable {

	public static ServiceRequestWorkflowSoap toSoapModel(
		ServiceRequestWorkflow model) {

		ServiceRequestWorkflowSoap soapModel = new ServiceRequestWorkflowSoap();

		soapModel.setServiceRequestWorkflowId(
			model.getServiceRequestWorkflowId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceRequestId(model.getServiceRequestId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setRemark(model.getRemark());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ServiceRequestWorkflowSoap[] toSoapModels(
		ServiceRequestWorkflow[] models) {

		ServiceRequestWorkflowSoap[] soapModels =
			new ServiceRequestWorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestWorkflowSoap[][] toSoapModels(
		ServiceRequestWorkflow[][] models) {

		ServiceRequestWorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestWorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestWorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestWorkflowSoap[] toSoapModels(
		List<ServiceRequestWorkflow> models) {

		List<ServiceRequestWorkflowSoap> soapModels =
			new ArrayList<ServiceRequestWorkflowSoap>(models.size());

		for (ServiceRequestWorkflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestWorkflowSoap[soapModels.size()]);
	}

	public ServiceRequestWorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _serviceRequestWorkflowId;
	}

	public void setPrimaryKey(long pk) {
		setServiceRequestWorkflowId(pk);
	}

	public long getServiceRequestWorkflowId() {
		return _serviceRequestWorkflowId;
	}

	public void setServiceRequestWorkflowId(long serviceRequestWorkflowId) {
		_serviceRequestWorkflowId = serviceRequestWorkflowId;
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

	public long getServiceRequestId() {
		return _serviceRequestId;
	}

	public void setServiceRequestId(long serviceRequestId) {
		_serviceRequestId = serviceRequestId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _serviceRequestWorkflowId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceRequestId;
	private long _employeeId;
	private String _className;
	private long _classPK;
	private String _remark;
	private int _status;

}