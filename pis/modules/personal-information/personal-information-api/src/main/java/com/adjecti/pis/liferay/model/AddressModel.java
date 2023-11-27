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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Address service. Represents a row in the &quot;pis_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.AddressModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.AddressImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
@ProviderType
public interface AddressModel
	extends BaseModel<Address>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a address model instance should use the {@link Address} interface instead.
	 */

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	public long getAddressId();

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	public void setAddressId(long addressId);

	/**
	 * Returns the group ID of this address.
	 *
	 * @return the group ID of this address
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this address.
	 *
	 * @param groupId the group ID of this address
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this address.
	 *
	 * @return the company ID of this address
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this address.
	 *
	 * @param companyId the company ID of this address
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this address.
	 *
	 * @return the user ID of this address
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this address.
	 *
	 * @param userId the user ID of this address
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this address.
	 *
	 * @return the user uuid of this address
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this address.
	 *
	 * @param userUuid the user uuid of this address
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this address.
	 *
	 * @return the user name of this address
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this address.
	 *
	 * @param userName the user name of this address
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this address.
	 *
	 * @return the create date of this address
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this address.
	 *
	 * @param createDate the create date of this address
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this address.
	 *
	 * @return the modified date of this address
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this address.
	 *
	 * @param modifiedDate the modified date of this address
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the address type ID of this address.
	 *
	 * @return the address type ID of this address
	 */
	public int getAddressTypeId();

	/**
	 * Sets the address type ID of this address.
	 *
	 * @param addressTypeId the address type ID of this address
	 */
	public void setAddressTypeId(int addressTypeId);

	/**
	 * Returns the address line1 of this address.
	 *
	 * @return the address line1 of this address
	 */
	@AutoEscape
	public String getAddressLine1();

	/**
	 * Sets the address line1 of this address.
	 *
	 * @param addressLine1 the address line1 of this address
	 */
	public void setAddressLine1(String addressLine1);

	/**
	 * Returns the address line2 of this address.
	 *
	 * @return the address line2 of this address
	 */
	@AutoEscape
	public String getAddressLine2();

	/**
	 * Sets the address line2 of this address.
	 *
	 * @param addressLine2 the address line2 of this address
	 */
	public void setAddressLine2(String addressLine2);

	/**
	 * Returns the address line3 of this address.
	 *
	 * @return the address line3 of this address
	 */
	@AutoEscape
	public String getAddressLine3();

	/**
	 * Sets the address line3 of this address.
	 *
	 * @param addressLine3 the address line3 of this address
	 */
	public void setAddressLine3(String addressLine3);

	/**
	 * Returns the city of this address.
	 *
	 * @return the city of this address
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this address.
	 *
	 * @param city the city of this address
	 */
	public void setCity(String city);

	/**
	 * Returns the pin code of this address.
	 *
	 * @return the pin code of this address
	 */
	@AutoEscape
	public String getPinCode();

	/**
	 * Sets the pin code of this address.
	 *
	 * @param pinCode the pin code of this address
	 */
	public void setPinCode(String pinCode);

	/**
	 * Returns the country ID of this address.
	 *
	 * @return the country ID of this address
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this address.
	 *
	 * @param countryId the country ID of this address
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the state ID of this address.
	 *
	 * @return the state ID of this address
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this address.
	 *
	 * @param stateId the state ID of this address
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the accomodation type ID of this address.
	 *
	 * @return the accomodation type ID of this address
	 */
	public long getAccomodationTypeId();

	/**
	 * Sets the accomodation type ID of this address.
	 *
	 * @param accomodationTypeId the accomodation type ID of this address
	 */
	public void setAccomodationTypeId(long accomodationTypeId);

	/**
	 * Returns the district ID of this address.
	 *
	 * @return the district ID of this address
	 */
	public long getDistrictId();

	/**
	 * Sets the district ID of this address.
	 *
	 * @param districtId the district ID of this address
	 */
	public void setDistrictId(long districtId);

	/**
	 * Returns the joining process ID of this address.
	 *
	 * @return the joining process ID of this address
	 */
	public long getJoiningProcessId();

	/**
	 * Sets the joining process ID of this address.
	 *
	 * @param joiningProcessId the joining process ID of this address
	 */
	public void setJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the address proof ID of this address.
	 *
	 * @return the address proof ID of this address
	 */
	public long getAddressProofId();

	/**
	 * Sets the address proof ID of this address.
	 *
	 * @param addressProofId the address proof ID of this address
	 */
	public void setAddressProofId(long addressProofId);

}