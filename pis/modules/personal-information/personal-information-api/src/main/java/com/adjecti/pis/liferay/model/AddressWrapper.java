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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressWrapper
	extends BaseModelWrapper<Address>
	implements Address, ModelWrapper<Address> {

	public AddressWrapper(Address address) {
		super(address);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("addressTypeId", getAddressTypeId());
		attributes.put("addressLine1", getAddressLine1());
		attributes.put("addressLine2", getAddressLine2());
		attributes.put("addressLine3", getAddressLine3());
		attributes.put("city", getCity());
		attributes.put("pinCode", getPinCode());
		attributes.put("countryId", getCountryId());
		attributes.put("stateId", getStateId());
		attributes.put("accomodationTypeId", getAccomodationTypeId());
		attributes.put("districtId", getDistrictId());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("addressProofId", getAddressProofId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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

		Integer addressTypeId = (Integer)attributes.get("addressTypeId");

		if (addressTypeId != null) {
			setAddressTypeId(addressTypeId);
		}

		String addressLine1 = (String)attributes.get("addressLine1");

		if (addressLine1 != null) {
			setAddressLine1(addressLine1);
		}

		String addressLine2 = (String)attributes.get("addressLine2");

		if (addressLine2 != null) {
			setAddressLine2(addressLine2);
		}

		String addressLine3 = (String)attributes.get("addressLine3");

		if (addressLine3 != null) {
			setAddressLine3(addressLine3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long accomodationTypeId = (Long)attributes.get("accomodationTypeId");

		if (accomodationTypeId != null) {
			setAccomodationTypeId(accomodationTypeId);
		}

		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Long addressProofId = (Long)attributes.get("addressProofId");

		if (addressProofId != null) {
			setAddressProofId(addressProofId);
		}
	}

	/**
	 * Returns the accomodation type ID of this address.
	 *
	 * @return the accomodation type ID of this address
	 */
	@Override
	public long getAccomodationTypeId() {
		return model.getAccomodationTypeId();
	}

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the address line1 of this address.
	 *
	 * @return the address line1 of this address
	 */
	@Override
	public String getAddressLine1() {
		return model.getAddressLine1();
	}

	/**
	 * Returns the address line2 of this address.
	 *
	 * @return the address line2 of this address
	 */
	@Override
	public String getAddressLine2() {
		return model.getAddressLine2();
	}

	/**
	 * Returns the address line3 of this address.
	 *
	 * @return the address line3 of this address
	 */
	@Override
	public String getAddressLine3() {
		return model.getAddressLine3();
	}

	/**
	 * Returns the address proof ID of this address.
	 *
	 * @return the address proof ID of this address
	 */
	@Override
	public long getAddressProofId() {
		return model.getAddressProofId();
	}

	/**
	 * Returns the address type ID of this address.
	 *
	 * @return the address type ID of this address
	 */
	@Override
	public int getAddressTypeId() {
		return model.getAddressTypeId();
	}

	/**
	 * Returns the city of this address.
	 *
	 * @return the city of this address
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this address.
	 *
	 * @return the company ID of this address
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country ID of this address.
	 *
	 * @return the country ID of this address
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this address.
	 *
	 * @return the create date of this address
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district ID of this address.
	 *
	 * @return the district ID of this address
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	@Override
	public String getFullAddress() {
		return model.getFullAddress();
	}

	/**
	 * Returns the group ID of this address.
	 *
	 * @return the group ID of this address
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this address.
	 *
	 * @return the joining process ID of this address
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the modified date of this address.
	 *
	 * @return the modified date of this address
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pin code of this address.
	 *
	 * @return the pin code of this address
	 */
	@Override
	public String getPinCode() {
		return model.getPinCode();
	}

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this address.
	 *
	 * @return the state ID of this address
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the user ID of this address.
	 *
	 * @return the user ID of this address
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this address.
	 *
	 * @return the user name of this address
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this address.
	 *
	 * @return the user uuid of this address
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accomodation type ID of this address.
	 *
	 * @param accomodationTypeId the accomodation type ID of this address
	 */
	@Override
	public void setAccomodationTypeId(long accomodationTypeId) {
		model.setAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the address line1 of this address.
	 *
	 * @param addressLine1 the address line1 of this address
	 */
	@Override
	public void setAddressLine1(String addressLine1) {
		model.setAddressLine1(addressLine1);
	}

	/**
	 * Sets the address line2 of this address.
	 *
	 * @param addressLine2 the address line2 of this address
	 */
	@Override
	public void setAddressLine2(String addressLine2) {
		model.setAddressLine2(addressLine2);
	}

	/**
	 * Sets the address line3 of this address.
	 *
	 * @param addressLine3 the address line3 of this address
	 */
	@Override
	public void setAddressLine3(String addressLine3) {
		model.setAddressLine3(addressLine3);
	}

	/**
	 * Sets the address proof ID of this address.
	 *
	 * @param addressProofId the address proof ID of this address
	 */
	@Override
	public void setAddressProofId(long addressProofId) {
		model.setAddressProofId(addressProofId);
	}

	/**
	 * Sets the address type ID of this address.
	 *
	 * @param addressTypeId the address type ID of this address
	 */
	@Override
	public void setAddressTypeId(int addressTypeId) {
		model.setAddressTypeId(addressTypeId);
	}

	/**
	 * Sets the city of this address.
	 *
	 * @param city the city of this address
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this address.
	 *
	 * @param companyId the company ID of this address
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country ID of this address.
	 *
	 * @param countryId the country ID of this address
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this address.
	 *
	 * @param createDate the create date of this address
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district ID of this address.
	 *
	 * @param districtId the district ID of this address
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the group ID of this address.
	 *
	 * @param groupId the group ID of this address
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this address.
	 *
	 * @param joiningProcessId the joining process ID of this address
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the modified date of this address.
	 *
	 * @param modifiedDate the modified date of this address
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pin code of this address.
	 *
	 * @param pinCode the pin code of this address
	 */
	@Override
	public void setPinCode(String pinCode) {
		model.setPinCode(pinCode);
	}

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this address.
	 *
	 * @param stateId the state ID of this address
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the user ID of this address.
	 *
	 * @param userId the user ID of this address
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this address.
	 *
	 * @param userName the user name of this address
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this address.
	 *
	 * @param userUuid the user uuid of this address
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AddressWrapper wrap(Address address) {
		return new AddressWrapper(address);
	}

}