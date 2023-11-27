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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeDeputationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeDeputationSoap implements Serializable {

	public static EmployeeDeputationSoap toSoapModel(EmployeeDeputation model) {
		EmployeeDeputationSoap soapModel = new EmployeeDeputationSoap();

		soapModel.setEmployeeDeputationId(model.getEmployeeDeputationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setOfficeAddress(model.getOfficeAddress());
		soapModel.setRemark(model.getRemark());
		soapModel.setToDate(model.getToDate());
		soapModel.setDeputationTypeId(model.getDeputationTypeId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setMinistryId(model.getMinistryId());
		soapModel.setPostId(model.getPostId());
		soapModel.setDeputedPostId(model.getDeputedPostId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeDeputationSoap[] toSoapModels(
		EmployeeDeputation[] models) {

		EmployeeDeputationSoap[] soapModels =
			new EmployeeDeputationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDeputationSoap[][] toSoapModels(
		EmployeeDeputation[][] models) {

		EmployeeDeputationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeDeputationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDeputationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDeputationSoap[] toSoapModels(
		List<EmployeeDeputation> models) {

		List<EmployeeDeputationSoap> soapModels =
			new ArrayList<EmployeeDeputationSoap>(models.size());

		for (EmployeeDeputation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeDeputationSoap[soapModels.size()]);
	}

	public EmployeeDeputationSoap() {
	}

	public long getPrimaryKey() {
		return _employeeDeputationId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeDeputationId(pk);
	}

	public long getEmployeeDeputationId() {
		return _employeeDeputationId;
	}

	public void setEmployeeDeputationId(long employeeDeputationId) {
		_employeeDeputationId = employeeDeputationId;
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

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public String getOfficeAddress() {
		return _officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		_officeAddress = officeAddress;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public long getDeputationTypeId() {
		return _deputationTypeId;
	}

	public void setDeputationTypeId(long deputationTypeId) {
		_deputationTypeId = deputationTypeId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getMinistryId() {
		return _ministryId;
	}

	public void setMinistryId(long ministryId) {
		_ministryId = ministryId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getDeputedPostId() {
		return _deputedPostId;
	}

	public void setDeputedPostId(long deputedPostId) {
		_deputedPostId = deputedPostId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _employeeDeputationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private String _officeAddress;
	private String _remark;
	private Date _toDate;
	private long _deputationTypeId;
	private long _departmentId;
	private long _employeeId;
	private long _ministryId;
	private long _postId;
	private long _deputedPostId;
	private int _status;

}