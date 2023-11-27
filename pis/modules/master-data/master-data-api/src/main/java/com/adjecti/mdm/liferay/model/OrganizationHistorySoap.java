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

package com.adjecti.mdm.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.OrganizationHistoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationHistorySoap implements Serializable {

	public static OrganizationHistorySoap toSoapModel(
		OrganizationHistory model) {

		OrganizationHistorySoap soapModel = new OrganizationHistorySoap();

		soapModel.setOrganizationHistoryId(model.getOrganizationHistoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setPreviousOrganizationName(
			model.getPreviousOrganizationName());
		soapModel.setPreviousOrganizationId(model.getPreviousOrganizationId());
		soapModel.setPreviousParentOrganizationName(
			model.getPreviousParentOrganizationName());
		soapModel.setPreviousParentOrganizationId(
			model.getPreviousParentOrganizationId());
		soapModel.setOrganizationName(model.getOrganizationName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OrganizationHistorySoap[] toSoapModels(
		OrganizationHistory[] models) {

		OrganizationHistorySoap[] soapModels =
			new OrganizationHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationHistorySoap[][] toSoapModels(
		OrganizationHistory[][] models) {

		OrganizationHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OrganizationHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationHistorySoap[] toSoapModels(
		List<OrganizationHistory> models) {

		List<OrganizationHistorySoap> soapModels =
			new ArrayList<OrganizationHistorySoap>(models.size());

		for (OrganizationHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new OrganizationHistorySoap[soapModels.size()]);
	}

	public OrganizationHistorySoap() {
	}

	public long getPrimaryKey() {
		return _organizationHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationHistoryId(pk);
	}

	public long getOrganizationHistoryId() {
		return _organizationHistoryId;
	}

	public void setOrganizationHistoryId(long organizationHistoryId) {
		_organizationHistoryId = organizationHistoryId;
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

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getPreviousOrganizationName() {
		return _previousOrganizationName;
	}

	public void setPreviousOrganizationName(String previousOrganizationName) {
		_previousOrganizationName = previousOrganizationName;
	}

	public long getPreviousOrganizationId() {
		return _previousOrganizationId;
	}

	public void setPreviousOrganizationId(long previousOrganizationId) {
		_previousOrganizationId = previousOrganizationId;
	}

	public String getPreviousParentOrganizationName() {
		return _previousParentOrganizationName;
	}

	public void setPreviousParentOrganizationName(
		String previousParentOrganizationName) {

		_previousParentOrganizationName = previousParentOrganizationName;
	}

	public long getPreviousParentOrganizationId() {
		return _previousParentOrganizationId;
	}

	public void setPreviousParentOrganizationId(
		long previousParentOrganizationId) {

		_previousParentOrganizationId = previousParentOrganizationId;
	}

	public String getOrganizationName() {
		return _organizationName;
	}

	public void setOrganizationName(String organizationName) {
		_organizationName = organizationName;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _organizationHistoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizationId;
	private String _previousOrganizationName;
	private long _previousOrganizationId;
	private String _previousParentOrganizationName;
	private long _previousParentOrganizationId;
	private String _organizationName;
	private String _status;

}