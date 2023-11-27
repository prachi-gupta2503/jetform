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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.OrganizationAssignmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationAssignmentSoap implements Serializable {

	public static OrganizationAssignmentSoap toSoapModel(
		OrganizationAssignment model) {

		OrganizationAssignmentSoap soapModel = new OrganizationAssignmentSoap();

		soapModel.setOrganizationAssignmentId(
			model.getOrganizationAssignmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setOrganizationCode(model.getOrganizationCode());
		soapModel.setSubOrganizationId(model.getSubOrganizationId());
		soapModel.setSubOrganizationCode(model.getSubOrganizationCode());
		soapModel.setActive(model.isActive());

		return soapModel;
	}

	public static OrganizationAssignmentSoap[] toSoapModels(
		OrganizationAssignment[] models) {

		OrganizationAssignmentSoap[] soapModels =
			new OrganizationAssignmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationAssignmentSoap[][] toSoapModels(
		OrganizationAssignment[][] models) {

		OrganizationAssignmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OrganizationAssignmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationAssignmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationAssignmentSoap[] toSoapModels(
		List<OrganizationAssignment> models) {

		List<OrganizationAssignmentSoap> soapModels =
			new ArrayList<OrganizationAssignmentSoap>(models.size());

		for (OrganizationAssignment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new OrganizationAssignmentSoap[soapModels.size()]);
	}

	public OrganizationAssignmentSoap() {
	}

	public long getPrimaryKey() {
		return _organizationAssignmentId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationAssignmentId(pk);
	}

	public long getOrganizationAssignmentId() {
		return _organizationAssignmentId;
	}

	public void setOrganizationAssignmentId(long organizationAssignmentId) {
		_organizationAssignmentId = organizationAssignmentId;
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

	public String getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(String personalNo) {
		_personalNo = personalNo;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getOrganizationCode() {
		return _organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		_organizationCode = organizationCode;
	}

	public long getSubOrganizationId() {
		return _subOrganizationId;
	}

	public void setSubOrganizationId(long subOrganizationId) {
		_subOrganizationId = subOrganizationId;
	}

	public String getSubOrganizationCode() {
		return _subOrganizationCode;
	}

	public void setSubOrganizationCode(String subOrganizationCode) {
		_subOrganizationCode = subOrganizationCode;
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

	private long _organizationAssignmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _personalNo;
	private long _organizationId;
	private String _organizationCode;
	private long _subOrganizationId;
	private String _subOrganizationCode;
	private boolean _active;

}