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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PayHeadTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PayHeadTypeSoap implements Serializable {

	public static PayHeadTypeSoap toSoapModel(PayHeadType model) {
		PayHeadTypeSoap soapModel = new PayHeadTypeSoap();

		soapModel.setPayHeadTypeId(model.getPayHeadTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setCode(model.getCode());
		soapModel.setDeduction(model.isDeduction());
		soapModel.setDeductionType(model.getDeductionType());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setName(model.getName());
		soapModel.setToDate(model.getToDate());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PayHeadTypeSoap[] toSoapModels(PayHeadType[] models) {
		PayHeadTypeSoap[] soapModels = new PayHeadTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayHeadTypeSoap[][] toSoapModels(PayHeadType[][] models) {
		PayHeadTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayHeadTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayHeadTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayHeadTypeSoap[] toSoapModels(List<PayHeadType> models) {
		List<PayHeadTypeSoap> soapModels = new ArrayList<PayHeadTypeSoap>(
			models.size());

		for (PayHeadType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayHeadTypeSoap[soapModels.size()]);
	}

	public PayHeadTypeSoap() {
	}

	public long getPrimaryKey() {
		return _payHeadTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPayHeadTypeId(pk);
	}

	public long getPayHeadTypeId() {
		return _payHeadTypeId;
	}

	public void setPayHeadTypeId(long payHeadTypeId) {
		_payHeadTypeId = payHeadTypeId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public boolean getDeduction() {
		return _deduction;
	}

	public boolean isDeduction() {
		return _deduction;
	}

	public void setDeduction(boolean deduction) {
		_deduction = deduction;
	}

	public int getDeductionType() {
		return _deductionType;
	}

	public void setDeductionType(int deductionType) {
		_deductionType = deductionType;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
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

	private long _payHeadTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _code;
	private boolean _deduction;
	private int _deductionType;
	private Date _fromDate;
	private String _name;
	private Date _toDate;
	private boolean _deleted;
	private int _status;

}