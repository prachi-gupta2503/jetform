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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.OrganizationDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationDetailSoap implements Serializable {

	public static OrganizationDetailSoap toSoapModel(OrganizationDetail model) {
		OrganizationDetailSoap soapModel = new OrganizationDetailSoap();

		soapModel.setOrganizationDetailId(model.getOrganizationDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setOrganizationCode(model.getOrganizationCode());
		soapModel.setParentId(model.getParentId());
		soapModel.setParentCode(model.getParentCode());
		soapModel.setType(model.getType());
		soapModel.setShortName(model.getShortName());
		soapModel.setLongName(model.getLongName());
		soapModel.setDivision(model.getDivision());
		soapModel.setAddressedTo(model.getAddressedTo());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setAddress3(model.getAddress3());
		soapModel.setCity(model.getCity());
		soapModel.setDistrict(model.getDistrict());
		soapModel.setStateId(model.getStateId());
		soapModel.setZone(model.getZone());
		soapModel.setPin(model.getPin());
		soapModel.setNearestRailwayStation(model.getNearestRailwayStation());
		soapModel.setTelegram(model.getTelegram());
		soapModel.setFax(model.getFax());
		soapModel.setTelex(model.getTelex());
		soapModel.setTelephone1(model.getTelephone1());
		soapModel.setTelephone2(model.getTelephone2());
		soapModel.setStationId(model.getStationId());
		soapModel.setUnitType(model.getUnitType());
		soapModel.setOrgStatus(model.getOrgStatus());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OrganizationDetailSoap[] toSoapModels(
		OrganizationDetail[] models) {

		OrganizationDetailSoap[] soapModels =
			new OrganizationDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationDetailSoap[][] toSoapModels(
		OrganizationDetail[][] models) {

		OrganizationDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new OrganizationDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationDetailSoap[] toSoapModels(
		List<OrganizationDetail> models) {

		List<OrganizationDetailSoap> soapModels =
			new ArrayList<OrganizationDetailSoap>(models.size());

		for (OrganizationDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new OrganizationDetailSoap[soapModels.size()]);
	}

	public OrganizationDetailSoap() {
	}

	public long getPrimaryKey() {
		return _organizationDetailId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationDetailId(pk);
	}

	public long getOrganizationDetailId() {
		return _organizationDetailId;
	}

	public void setOrganizationDetailId(long organizationDetailId) {
		_organizationDetailId = organizationDetailId;
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

	public String getOrganizationCode() {
		return _organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		_organizationCode = organizationCode;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getParentCode() {
		return _parentCode;
	}

	public void setParentCode(String parentCode) {
		_parentCode = parentCode;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getShortName() {
		return _shortName;
	}

	public void setShortName(String shortName) {
		_shortName = shortName;
	}

	public String getLongName() {
		return _longName;
	}

	public void setLongName(String longName) {
		_longName = longName;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getAddressedTo() {
		return _addressedTo;
	}

	public void setAddressedTo(String addressedTo) {
		_addressedTo = addressedTo;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getAddress3() {
		return _address3;
	}

	public void setAddress3(String address3) {
		_address3 = address3;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getZone() {
		return _zone;
	}

	public void setZone(String zone) {
		_zone = zone;
	}

	public String getPin() {
		return _pin;
	}

	public void setPin(String pin) {
		_pin = pin;
	}

	public String getNearestRailwayStation() {
		return _nearestRailwayStation;
	}

	public void setNearestRailwayStation(String nearestRailwayStation) {
		_nearestRailwayStation = nearestRailwayStation;
	}

	public String getTelegram() {
		return _telegram;
	}

	public void setTelegram(String telegram) {
		_telegram = telegram;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getTelex() {
		return _telex;
	}

	public void setTelex(String telex) {
		_telex = telex;
	}

	public String getTelephone1() {
		return _telephone1;
	}

	public void setTelephone1(String telephone1) {
		_telephone1 = telephone1;
	}

	public String getTelephone2() {
		return _telephone2;
	}

	public void setTelephone2(String telephone2) {
		_telephone2 = telephone2;
	}

	public String getStationId() {
		return _stationId;
	}

	public void setStationId(String stationId) {
		_stationId = stationId;
	}

	public String getUnitType() {
		return _unitType;
	}

	public void setUnitType(String unitType) {
		_unitType = unitType;
	}

	public String getOrgStatus() {
		return _orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		_orgStatus = orgStatus;
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

	private long _organizationDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizationId;
	private String _organizationCode;
	private long _parentId;
	private String _parentCode;
	private String _type;
	private String _shortName;
	private String _longName;
	private String _division;
	private String _addressedTo;
	private String _address1;
	private String _address2;
	private String _address3;
	private String _city;
	private String _district;
	private long _stateId;
	private String _zone;
	private String _pin;
	private String _nearestRailwayStation;
	private String _telegram;
	private String _fax;
	private String _telex;
	private String _telephone1;
	private String _telephone2;
	private String _stationId;
	private String _unitType;
	private String _orgStatus;
	private boolean _deleted;
	private int _status;

}