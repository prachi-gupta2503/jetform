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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PersonalNoPrefixServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersonalNoPrefixSoap implements Serializable {

	public static PersonalNoPrefixSoap toSoapModel(PersonalNoPrefix model) {
		PersonalNoPrefixSoap soapModel = new PersonalNoPrefixSoap();

		soapModel.setPersonalNoPrefixId(model.getPersonalNoPrefixId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setPrefix(model.getPrefix());
		soapModel.setToDate(model.getToDate());
		soapModel.setDesigClassId(model.getDesigClassId());
		soapModel.setDesigGradeId(model.getDesigGradeId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PersonalNoPrefixSoap[] toSoapModels(
		PersonalNoPrefix[] models) {

		PersonalNoPrefixSoap[] soapModels =
			new PersonalNoPrefixSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonalNoPrefixSoap[][] toSoapModels(
		PersonalNoPrefix[][] models) {

		PersonalNoPrefixSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersonalNoPrefixSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonalNoPrefixSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonalNoPrefixSoap[] toSoapModels(
		List<PersonalNoPrefix> models) {

		List<PersonalNoPrefixSoap> soapModels =
			new ArrayList<PersonalNoPrefixSoap>(models.size());

		for (PersonalNoPrefix model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonalNoPrefixSoap[soapModels.size()]);
	}

	public PersonalNoPrefixSoap() {
	}

	public long getPrimaryKey() {
		return _personalNoPrefixId;
	}

	public void setPrimaryKey(long pk) {
		setPersonalNoPrefixId(pk);
	}

	public long getPersonalNoPrefixId() {
		return _personalNoPrefixId;
	}

	public void setPersonalNoPrefixId(long personalNoPrefixId) {
		_personalNoPrefixId = personalNoPrefixId;
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

	public String getPrefix() {
		return _prefix;
	}

	public void setPrefix(String prefix) {
		_prefix = prefix;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public long getDesigClassId() {
		return _desigClassId;
	}

	public void setDesigClassId(long desigClassId) {
		_desigClassId = desigClassId;
	}

	public long getDesigGradeId() {
		return _desigGradeId;
	}

	public void setDesigGradeId(long desigGradeId) {
		_desigGradeId = desigGradeId;
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

	private long _personalNoPrefixId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private String _prefix;
	private Date _toDate;
	private long _desigClassId;
	private long _desigGradeId;
	private boolean _deleted;
	private int _status;

}