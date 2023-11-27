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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrganizationDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetail
 * @generated
 */
public class OrganizationDetailWrapper
	extends BaseModelWrapper<OrganizationDetail>
	implements ModelWrapper<OrganizationDetail>, OrganizationDetail {

	public OrganizationDetailWrapper(OrganizationDetail organizationDetail) {
		super(organizationDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationDetailId", getOrganizationDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("organizationCode", getOrganizationCode());
		attributes.put("parentId", getParentId());
		attributes.put("parentCode", getParentCode());
		attributes.put("type", getType());
		attributes.put("shortName", getShortName());
		attributes.put("longName", getLongName());
		attributes.put("division", getDivision());
		attributes.put("addressedTo", getAddressedTo());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("address3", getAddress3());
		attributes.put("city", getCity());
		attributes.put("district", getDistrict());
		attributes.put("stateId", getStateId());
		attributes.put("zone", getZone());
		attributes.put("pin", getPin());
		attributes.put("nearestRailwayStation", getNearestRailwayStation());
		attributes.put("telegram", getTelegram());
		attributes.put("fax", getFax());
		attributes.put("telex", getTelex());
		attributes.put("telephone1", getTelephone1());
		attributes.put("telephone2", getTelephone2());
		attributes.put("stationId", getStationId());
		attributes.put("unitType", getUnitType());
		attributes.put("orgStatus", getOrgStatus());
		attributes.put("deleted", isDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationDetailId = (Long)attributes.get(
			"organizationDetailId");

		if (organizationDetailId != null) {
			setOrganizationDetailId(organizationDetailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String organizationCode = (String)attributes.get("organizationCode");

		if (organizationCode != null) {
			setOrganizationCode(organizationCode);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentCode = (String)attributes.get("parentCode");

		if (parentCode != null) {
			setParentCode(parentCode);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String longName = (String)attributes.get("longName");

		if (longName != null) {
			setLongName(longName);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String addressedTo = (String)attributes.get("addressedTo");

		if (addressedTo != null) {
			setAddressedTo(addressedTo);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String address3 = (String)attributes.get("address3");

		if (address3 != null) {
			setAddress3(address3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String zone = (String)attributes.get("zone");

		if (zone != null) {
			setZone(zone);
		}

		String pin = (String)attributes.get("pin");

		if (pin != null) {
			setPin(pin);
		}

		String nearestRailwayStation = (String)attributes.get(
			"nearestRailwayStation");

		if (nearestRailwayStation != null) {
			setNearestRailwayStation(nearestRailwayStation);
		}

		String telegram = (String)attributes.get("telegram");

		if (telegram != null) {
			setTelegram(telegram);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String telex = (String)attributes.get("telex");

		if (telex != null) {
			setTelex(telex);
		}

		String telephone1 = (String)attributes.get("telephone1");

		if (telephone1 != null) {
			setTelephone1(telephone1);
		}

		String telephone2 = (String)attributes.get("telephone2");

		if (telephone2 != null) {
			setTelephone2(telephone2);
		}

		String stationId = (String)attributes.get("stationId");

		if (stationId != null) {
			setStationId(stationId);
		}

		String unitType = (String)attributes.get("unitType");

		if (unitType != null) {
			setUnitType(unitType);
		}

		String orgStatus = (String)attributes.get("orgStatus");

		if (orgStatus != null) {
			setOrgStatus(orgStatus);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the address1 of this organization detail.
	 *
	 * @return the address1 of this organization detail
	 */
	@Override
	public String getAddress1() {
		return model.getAddress1();
	}

	/**
	 * Returns the address2 of this organization detail.
	 *
	 * @return the address2 of this organization detail
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the address3 of this organization detail.
	 *
	 * @return the address3 of this organization detail
	 */
	@Override
	public String getAddress3() {
		return model.getAddress3();
	}

	/**
	 * Returns the addressed to of this organization detail.
	 *
	 * @return the addressed to of this organization detail
	 */
	@Override
	public String getAddressedTo() {
		return model.getAddressedTo();
	}

	/**
	 * Returns the city of this organization detail.
	 *
	 * @return the city of this organization detail
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this organization detail.
	 *
	 * @return the company ID of this organization detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this organization detail.
	 *
	 * @return the create date of this organization detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this organization detail.
	 *
	 * @return the deleted of this organization detail
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the district of this organization detail.
	 *
	 * @return the district of this organization detail
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this organization detail.
	 *
	 * @return the division of this organization detail
	 */
	@Override
	public String getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the fax of this organization detail.
	 *
	 * @return the fax of this organization detail
	 */
	@Override
	public String getFax() {
		return model.getFax();
	}

	/**
	 * Returns the group ID of this organization detail.
	 *
	 * @return the group ID of this organization detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the long name of this organization detail.
	 *
	 * @return the long name of this organization detail
	 */
	@Override
	public String getLongName() {
		return model.getLongName();
	}

	/**
	 * Returns the modified date of this organization detail.
	 *
	 * @return the modified date of this organization detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nearest railway station of this organization detail.
	 *
	 * @return the nearest railway station of this organization detail
	 */
	@Override
	public String getNearestRailwayStation() {
		return model.getNearestRailwayStation();
	}

	/**
	 * Returns the organization code of this organization detail.
	 *
	 * @return the organization code of this organization detail
	 */
	@Override
	public String getOrganizationCode() {
		return model.getOrganizationCode();
	}

	/**
	 * Returns the organization detail ID of this organization detail.
	 *
	 * @return the organization detail ID of this organization detail
	 */
	@Override
	public long getOrganizationDetailId() {
		return model.getOrganizationDetailId();
	}

	/**
	 * Returns the organization ID of this organization detail.
	 *
	 * @return the organization ID of this organization detail
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the org status of this organization detail.
	 *
	 * @return the org status of this organization detail
	 */
	@Override
	public String getOrgStatus() {
		return model.getOrgStatus();
	}

	/**
	 * Returns the parent code of this organization detail.
	 *
	 * @return the parent code of this organization detail
	 */
	@Override
	public String getParentCode() {
		return model.getParentCode();
	}

	/**
	 * Returns the parent ID of this organization detail.
	 *
	 * @return the parent ID of this organization detail
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the pin of this organization detail.
	 *
	 * @return the pin of this organization detail
	 */
	@Override
	public String getPin() {
		return model.getPin();
	}

	/**
	 * Returns the primary key of this organization detail.
	 *
	 * @return the primary key of this organization detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the short name of this organization detail.
	 *
	 * @return the short name of this organization detail
	 */
	@Override
	public String getShortName() {
		return model.getShortName();
	}

	/**
	 * Returns the state ID of this organization detail.
	 *
	 * @return the state ID of this organization detail
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the station ID of this organization detail.
	 *
	 * @return the station ID of this organization detail
	 */
	@Override
	public String getStationId() {
		return model.getStationId();
	}

	/**
	 * Returns the status of this organization detail.
	 *
	 * @return the status of this organization detail
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the telegram of this organization detail.
	 *
	 * @return the telegram of this organization detail
	 */
	@Override
	public String getTelegram() {
		return model.getTelegram();
	}

	/**
	 * Returns the telephone1 of this organization detail.
	 *
	 * @return the telephone1 of this organization detail
	 */
	@Override
	public String getTelephone1() {
		return model.getTelephone1();
	}

	/**
	 * Returns the telephone2 of this organization detail.
	 *
	 * @return the telephone2 of this organization detail
	 */
	@Override
	public String getTelephone2() {
		return model.getTelephone2();
	}

	/**
	 * Returns the telex of this organization detail.
	 *
	 * @return the telex of this organization detail
	 */
	@Override
	public String getTelex() {
		return model.getTelex();
	}

	/**
	 * Returns the type of this organization detail.
	 *
	 * @return the type of this organization detail
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the unit type of this organization detail.
	 *
	 * @return the unit type of this organization detail
	 */
	@Override
	public String getUnitType() {
		return model.getUnitType();
	}

	/**
	 * Returns the user ID of this organization detail.
	 *
	 * @return the user ID of this organization detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this organization detail.
	 *
	 * @return the user name of this organization detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this organization detail.
	 *
	 * @return the user uuid of this organization detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zone of this organization detail.
	 *
	 * @return the zone of this organization detail
	 */
	@Override
	public String getZone() {
		return model.getZone();
	}

	/**
	 * Returns <code>true</code> if this organization detail is deleted.
	 *
	 * @return <code>true</code> if this organization detail is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address1 of this organization detail.
	 *
	 * @param address1 the address1 of this organization detail
	 */
	@Override
	public void setAddress1(String address1) {
		model.setAddress1(address1);
	}

	/**
	 * Sets the address2 of this organization detail.
	 *
	 * @param address2 the address2 of this organization detail
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the address3 of this organization detail.
	 *
	 * @param address3 the address3 of this organization detail
	 */
	@Override
	public void setAddress3(String address3) {
		model.setAddress3(address3);
	}

	/**
	 * Sets the addressed to of this organization detail.
	 *
	 * @param addressedTo the addressed to of this organization detail
	 */
	@Override
	public void setAddressedTo(String addressedTo) {
		model.setAddressedTo(addressedTo);
	}

	/**
	 * Sets the city of this organization detail.
	 *
	 * @param city the city of this organization detail
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this organization detail.
	 *
	 * @param companyId the company ID of this organization detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this organization detail.
	 *
	 * @param createDate the create date of this organization detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this organization detail is deleted.
	 *
	 * @param deleted the deleted of this organization detail
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the district of this organization detail.
	 *
	 * @param district the district of this organization detail
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this organization detail.
	 *
	 * @param division the division of this organization detail
	 */
	@Override
	public void setDivision(String division) {
		model.setDivision(division);
	}

	/**
	 * Sets the fax of this organization detail.
	 *
	 * @param fax the fax of this organization detail
	 */
	@Override
	public void setFax(String fax) {
		model.setFax(fax);
	}

	/**
	 * Sets the group ID of this organization detail.
	 *
	 * @param groupId the group ID of this organization detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the long name of this organization detail.
	 *
	 * @param longName the long name of this organization detail
	 */
	@Override
	public void setLongName(String longName) {
		model.setLongName(longName);
	}

	/**
	 * Sets the modified date of this organization detail.
	 *
	 * @param modifiedDate the modified date of this organization detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nearest railway station of this organization detail.
	 *
	 * @param nearestRailwayStation the nearest railway station of this organization detail
	 */
	@Override
	public void setNearestRailwayStation(String nearestRailwayStation) {
		model.setNearestRailwayStation(nearestRailwayStation);
	}

	/**
	 * Sets the organization code of this organization detail.
	 *
	 * @param organizationCode the organization code of this organization detail
	 */
	@Override
	public void setOrganizationCode(String organizationCode) {
		model.setOrganizationCode(organizationCode);
	}

	/**
	 * Sets the organization detail ID of this organization detail.
	 *
	 * @param organizationDetailId the organization detail ID of this organization detail
	 */
	@Override
	public void setOrganizationDetailId(long organizationDetailId) {
		model.setOrganizationDetailId(organizationDetailId);
	}

	/**
	 * Sets the organization ID of this organization detail.
	 *
	 * @param organizationId the organization ID of this organization detail
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the org status of this organization detail.
	 *
	 * @param orgStatus the org status of this organization detail
	 */
	@Override
	public void setOrgStatus(String orgStatus) {
		model.setOrgStatus(orgStatus);
	}

	/**
	 * Sets the parent code of this organization detail.
	 *
	 * @param parentCode the parent code of this organization detail
	 */
	@Override
	public void setParentCode(String parentCode) {
		model.setParentCode(parentCode);
	}

	/**
	 * Sets the parent ID of this organization detail.
	 *
	 * @param parentId the parent ID of this organization detail
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the pin of this organization detail.
	 *
	 * @param pin the pin of this organization detail
	 */
	@Override
	public void setPin(String pin) {
		model.setPin(pin);
	}

	/**
	 * Sets the primary key of this organization detail.
	 *
	 * @param primaryKey the primary key of this organization detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the short name of this organization detail.
	 *
	 * @param shortName the short name of this organization detail
	 */
	@Override
	public void setShortName(String shortName) {
		model.setShortName(shortName);
	}

	/**
	 * Sets the state ID of this organization detail.
	 *
	 * @param stateId the state ID of this organization detail
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the station ID of this organization detail.
	 *
	 * @param stationId the station ID of this organization detail
	 */
	@Override
	public void setStationId(String stationId) {
		model.setStationId(stationId);
	}

	/**
	 * Sets the status of this organization detail.
	 *
	 * @param status the status of this organization detail
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the telegram of this organization detail.
	 *
	 * @param telegram the telegram of this organization detail
	 */
	@Override
	public void setTelegram(String telegram) {
		model.setTelegram(telegram);
	}

	/**
	 * Sets the telephone1 of this organization detail.
	 *
	 * @param telephone1 the telephone1 of this organization detail
	 */
	@Override
	public void setTelephone1(String telephone1) {
		model.setTelephone1(telephone1);
	}

	/**
	 * Sets the telephone2 of this organization detail.
	 *
	 * @param telephone2 the telephone2 of this organization detail
	 */
	@Override
	public void setTelephone2(String telephone2) {
		model.setTelephone2(telephone2);
	}

	/**
	 * Sets the telex of this organization detail.
	 *
	 * @param telex the telex of this organization detail
	 */
	@Override
	public void setTelex(String telex) {
		model.setTelex(telex);
	}

	/**
	 * Sets the type of this organization detail.
	 *
	 * @param type the type of this organization detail
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the unit type of this organization detail.
	 *
	 * @param unitType the unit type of this organization detail
	 */
	@Override
	public void setUnitType(String unitType) {
		model.setUnitType(unitType);
	}

	/**
	 * Sets the user ID of this organization detail.
	 *
	 * @param userId the user ID of this organization detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this organization detail.
	 *
	 * @param userName the user name of this organization detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this organization detail.
	 *
	 * @param userUuid the user uuid of this organization detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zone of this organization detail.
	 *
	 * @param zone the zone of this organization detail
	 */
	@Override
	public void setZone(String zone) {
		model.setZone(zone);
	}

	@Override
	protected OrganizationDetailWrapper wrap(
		OrganizationDetail organizationDetail) {

		return new OrganizationDetailWrapper(organizationDetail);
	}

}