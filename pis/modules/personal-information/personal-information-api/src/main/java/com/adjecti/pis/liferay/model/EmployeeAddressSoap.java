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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.EmployeeAddressServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeAddressSoap implements Serializable {

	public static EmployeeAddressSoap toSoapModel(EmployeeAddress model) {
		EmployeeAddressSoap soapModel = new EmployeeAddressSoap();

		soapModel.setEmployeeAddressId(model.getEmployeeAddressId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setPermanent(model.isPermanent());
		soapModel.setToDate(model.getToDate());
		soapModel.setAddressLine1(model.getAddressLine1());
		soapModel.setAddressLine2(model.getAddressLine2());
		soapModel.setAddressLine3(model.getAddressLine3());
		soapModel.setCity(model.getCity());
		soapModel.setPinCode(model.getPinCode());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setStateId(model.getStateId());
		soapModel.setAccomodationTypeId(model.getAccomodationTypeId());
		soapModel.setDistrictId(model.getDistrictId());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setAddressProofId(model.getAddressProofId());
		soapModel.setStatus(model.getStatus());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static EmployeeAddressSoap[] toSoapModels(EmployeeAddress[] models) {
		EmployeeAddressSoap[] soapModels =
			new EmployeeAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeAddressSoap[][] toSoapModels(
		EmployeeAddress[][] models) {

		EmployeeAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeAddressSoap[] toSoapModels(
		List<EmployeeAddress> models) {

		List<EmployeeAddressSoap> soapModels =
			new ArrayList<EmployeeAddressSoap>(models.size());

		for (EmployeeAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeAddressSoap[soapModels.size()]);
	}

	public EmployeeAddressSoap() {
	}

	public long getPrimaryKey() {
		return _employeeAddressId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeAddressId(pk);
	}

	public long getEmployeeAddressId() {
		return _employeeAddressId;
	}

	public void setEmployeeAddressId(long employeeAddressId) {
		_employeeAddressId = employeeAddressId;
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

	public boolean getPermanent() {
		return _permanent;
	}

	public boolean isPermanent() {
		return _permanent;
	}

	public void setPermanent(boolean permanent) {
		_permanent = permanent;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getAddressLine1() {
		return _addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		_addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return _addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		_addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return _addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		_addressLine3 = addressLine3;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getPinCode() {
		return _pinCode;
	}

	public void setPinCode(String pinCode) {
		_pinCode = pinCode;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public long getAccomodationTypeId() {
		return _accomodationTypeId;
	}

	public void setAccomodationTypeId(long accomodationTypeId) {
		_accomodationTypeId = accomodationTypeId;
	}

	public long getDistrictId() {
		return _districtId;
	}

	public void setDistrictId(long districtId) {
		_districtId = districtId;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
	}

	public long getAddressProofId() {
		return _addressProofId;
	}

	public void setAddressProofId(long addressProofId) {
		_addressProofId = addressProofId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private long _employeeAddressId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private Date _fromDate;
	private boolean _permanent;
	private Date _toDate;
	private String _addressLine1;
	private String _addressLine2;
	private String _addressLine3;
	private String _city;
	private String _pinCode;
	private long _countryId;
	private long _stateId;
	private long _accomodationTypeId;
	private long _districtId;
	private long _joiningProcessId;
	private long _addressProofId;
	private int _status;
	private long _addressId;
	private long _employeeId;

}