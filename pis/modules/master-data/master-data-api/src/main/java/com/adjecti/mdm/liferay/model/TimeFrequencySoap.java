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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.TimeFrequencyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TimeFrequencySoap implements Serializable {

	public static TimeFrequencySoap toSoapModel(TimeFrequency model) {
		TimeFrequencySoap soapModel = new TimeFrequencySoap();

		soapModel.setTimeFrequencyId(model.getTimeFrequencyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TimeFrequencySoap[] toSoapModels(TimeFrequency[] models) {
		TimeFrequencySoap[] soapModels = new TimeFrequencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimeFrequencySoap[][] toSoapModels(TimeFrequency[][] models) {
		TimeFrequencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimeFrequencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimeFrequencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimeFrequencySoap[] toSoapModels(List<TimeFrequency> models) {
		List<TimeFrequencySoap> soapModels = new ArrayList<TimeFrequencySoap>(
			models.size());

		for (TimeFrequency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimeFrequencySoap[soapModels.size()]);
	}

	public TimeFrequencySoap() {
	}

	public long getPrimaryKey() {
		return _timeFrequencyId;
	}

	public void setPrimaryKey(long pk) {
		setTimeFrequencyId(pk);
	}

	public long getTimeFrequencyId() {
		return _timeFrequencyId;
	}

	public void setTimeFrequencyId(long timeFrequencyId) {
		_timeFrequencyId = timeFrequencyId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _timeFrequencyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private boolean _deleted;
	private int _status;

}