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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PayHeadServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PayHeadSoap implements Serializable {

	public static PayHeadSoap toSoapModel(PayHead model) {
		PayHeadSoap soapModel = new PayHeadSoap();

		soapModel.setPayHeadId(model.getPayHeadId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setCode(model.getCode());
		soapModel.setDisbursePeriod(model.getDisbursePeriod());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setName(model.getName());
		soapModel.setNonTaxable(model.isNonTaxable());
		soapModel.setToDate(model.getToDate());
		soapModel.setHeadTypeId(model.getHeadTypeId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PayHeadSoap[] toSoapModels(PayHead[] models) {
		PayHeadSoap[] soapModels = new PayHeadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayHeadSoap[][] toSoapModels(PayHead[][] models) {
		PayHeadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayHeadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayHeadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayHeadSoap[] toSoapModels(List<PayHead> models) {
		List<PayHeadSoap> soapModels = new ArrayList<PayHeadSoap>(
			models.size());

		for (PayHead model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayHeadSoap[soapModels.size()]);
	}

	public PayHeadSoap() {
	}

	public long getPrimaryKey() {
		return _payHeadId;
	}

	public void setPrimaryKey(long pk) {
		setPayHeadId(pk);
	}

	public long getPayHeadId() {
		return _payHeadId;
	}

	public void setPayHeadId(long payHeadId) {
		_payHeadId = payHeadId;
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

	public int getDisbursePeriod() {
		return _disbursePeriod;
	}

	public void setDisbursePeriod(int disbursePeriod) {
		_disbursePeriod = disbursePeriod;
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

	public boolean getNonTaxable() {
		return _nonTaxable;
	}

	public boolean isNonTaxable() {
		return _nonTaxable;
	}

	public void setNonTaxable(boolean nonTaxable) {
		_nonTaxable = nonTaxable;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public long getHeadTypeId() {
		return _headTypeId;
	}

	public void setHeadTypeId(long headTypeId) {
		_headTypeId = headTypeId;
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

	private long _payHeadId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _code;
	private int _disbursePeriod;
	private Date _fromDate;
	private String _name;
	private boolean _nonTaxable;
	private Date _toDate;
	private long _headTypeId;
	private boolean _deleted;
	private int _status;

}