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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the OrganizationDetail service. Represents a row in the &quot;mdm_OrganizationDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetail
 * @generated
 */
@ProviderType
public interface OrganizationDetailModel
	extends BaseModel<OrganizationDetail>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a organization detail model instance should use the {@link OrganizationDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this organization detail.
	 *
	 * @return the primary key of this organization detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this organization detail.
	 *
	 * @param primaryKey the primary key of this organization detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the organization detail ID of this organization detail.
	 *
	 * @return the organization detail ID of this organization detail
	 */
	public long getOrganizationDetailId();

	/**
	 * Sets the organization detail ID of this organization detail.
	 *
	 * @param organizationDetailId the organization detail ID of this organization detail
	 */
	public void setOrganizationDetailId(long organizationDetailId);

	/**
	 * Returns the group ID of this organization detail.
	 *
	 * @return the group ID of this organization detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this organization detail.
	 *
	 * @param groupId the group ID of this organization detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this organization detail.
	 *
	 * @return the company ID of this organization detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this organization detail.
	 *
	 * @param companyId the company ID of this organization detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this organization detail.
	 *
	 * @return the user ID of this organization detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this organization detail.
	 *
	 * @param userId the user ID of this organization detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this organization detail.
	 *
	 * @return the user uuid of this organization detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this organization detail.
	 *
	 * @param userUuid the user uuid of this organization detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this organization detail.
	 *
	 * @return the user name of this organization detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this organization detail.
	 *
	 * @param userName the user name of this organization detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this organization detail.
	 *
	 * @return the create date of this organization detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this organization detail.
	 *
	 * @param createDate the create date of this organization detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this organization detail.
	 *
	 * @return the modified date of this organization detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this organization detail.
	 *
	 * @param modifiedDate the modified date of this organization detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the organization ID of this organization detail.
	 *
	 * @return the organization ID of this organization detail
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this organization detail.
	 *
	 * @param organizationId the organization ID of this organization detail
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the organization code of this organization detail.
	 *
	 * @return the organization code of this organization detail
	 */
	@AutoEscape
	public String getOrganizationCode();

	/**
	 * Sets the organization code of this organization detail.
	 *
	 * @param organizationCode the organization code of this organization detail
	 */
	public void setOrganizationCode(String organizationCode);

	/**
	 * Returns the parent ID of this organization detail.
	 *
	 * @return the parent ID of this organization detail
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this organization detail.
	 *
	 * @param parentId the parent ID of this organization detail
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the parent code of this organization detail.
	 *
	 * @return the parent code of this organization detail
	 */
	@AutoEscape
	public String getParentCode();

	/**
	 * Sets the parent code of this organization detail.
	 *
	 * @param parentCode the parent code of this organization detail
	 */
	public void setParentCode(String parentCode);

	/**
	 * Returns the type of this organization detail.
	 *
	 * @return the type of this organization detail
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this organization detail.
	 *
	 * @param type the type of this organization detail
	 */
	public void setType(String type);

	/**
	 * Returns the short name of this organization detail.
	 *
	 * @return the short name of this organization detail
	 */
	@AutoEscape
	public String getShortName();

	/**
	 * Sets the short name of this organization detail.
	 *
	 * @param shortName the short name of this organization detail
	 */
	public void setShortName(String shortName);

	/**
	 * Returns the long name of this organization detail.
	 *
	 * @return the long name of this organization detail
	 */
	@AutoEscape
	public String getLongName();

	/**
	 * Sets the long name of this organization detail.
	 *
	 * @param longName the long name of this organization detail
	 */
	public void setLongName(String longName);

	/**
	 * Returns the division of this organization detail.
	 *
	 * @return the division of this organization detail
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this organization detail.
	 *
	 * @param division the division of this organization detail
	 */
	public void setDivision(String division);

	/**
	 * Returns the addressed to of this organization detail.
	 *
	 * @return the addressed to of this organization detail
	 */
	@AutoEscape
	public String getAddressedTo();

	/**
	 * Sets the addressed to of this organization detail.
	 *
	 * @param addressedTo the addressed to of this organization detail
	 */
	public void setAddressedTo(String addressedTo);

	/**
	 * Returns the address1 of this organization detail.
	 *
	 * @return the address1 of this organization detail
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this organization detail.
	 *
	 * @param address1 the address1 of this organization detail
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this organization detail.
	 *
	 * @return the address2 of this organization detail
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this organization detail.
	 *
	 * @param address2 the address2 of this organization detail
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the address3 of this organization detail.
	 *
	 * @return the address3 of this organization detail
	 */
	@AutoEscape
	public String getAddress3();

	/**
	 * Sets the address3 of this organization detail.
	 *
	 * @param address3 the address3 of this organization detail
	 */
	public void setAddress3(String address3);

	/**
	 * Returns the city of this organization detail.
	 *
	 * @return the city of this organization detail
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this organization detail.
	 *
	 * @param city the city of this organization detail
	 */
	public void setCity(String city);

	/**
	 * Returns the district of this organization detail.
	 *
	 * @return the district of this organization detail
	 */
	@AutoEscape
	public String getDistrict();

	/**
	 * Sets the district of this organization detail.
	 *
	 * @param district the district of this organization detail
	 */
	public void setDistrict(String district);

	/**
	 * Returns the state ID of this organization detail.
	 *
	 * @return the state ID of this organization detail
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this organization detail.
	 *
	 * @param stateId the state ID of this organization detail
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the zone of this organization detail.
	 *
	 * @return the zone of this organization detail
	 */
	@AutoEscape
	public String getZone();

	/**
	 * Sets the zone of this organization detail.
	 *
	 * @param zone the zone of this organization detail
	 */
	public void setZone(String zone);

	/**
	 * Returns the pin of this organization detail.
	 *
	 * @return the pin of this organization detail
	 */
	@AutoEscape
	public String getPin();

	/**
	 * Sets the pin of this organization detail.
	 *
	 * @param pin the pin of this organization detail
	 */
	public void setPin(String pin);

	/**
	 * Returns the nearest railway station of this organization detail.
	 *
	 * @return the nearest railway station of this organization detail
	 */
	@AutoEscape
	public String getNearestRailwayStation();

	/**
	 * Sets the nearest railway station of this organization detail.
	 *
	 * @param nearestRailwayStation the nearest railway station of this organization detail
	 */
	public void setNearestRailwayStation(String nearestRailwayStation);

	/**
	 * Returns the telegram of this organization detail.
	 *
	 * @return the telegram of this organization detail
	 */
	@AutoEscape
	public String getTelegram();

	/**
	 * Sets the telegram of this organization detail.
	 *
	 * @param telegram the telegram of this organization detail
	 */
	public void setTelegram(String telegram);

	/**
	 * Returns the fax of this organization detail.
	 *
	 * @return the fax of this organization detail
	 */
	@AutoEscape
	public String getFax();

	/**
	 * Sets the fax of this organization detail.
	 *
	 * @param fax the fax of this organization detail
	 */
	public void setFax(String fax);

	/**
	 * Returns the telex of this organization detail.
	 *
	 * @return the telex of this organization detail
	 */
	@AutoEscape
	public String getTelex();

	/**
	 * Sets the telex of this organization detail.
	 *
	 * @param telex the telex of this organization detail
	 */
	public void setTelex(String telex);

	/**
	 * Returns the telephone1 of this organization detail.
	 *
	 * @return the telephone1 of this organization detail
	 */
	@AutoEscape
	public String getTelephone1();

	/**
	 * Sets the telephone1 of this organization detail.
	 *
	 * @param telephone1 the telephone1 of this organization detail
	 */
	public void setTelephone1(String telephone1);

	/**
	 * Returns the telephone2 of this organization detail.
	 *
	 * @return the telephone2 of this organization detail
	 */
	@AutoEscape
	public String getTelephone2();

	/**
	 * Sets the telephone2 of this organization detail.
	 *
	 * @param telephone2 the telephone2 of this organization detail
	 */
	public void setTelephone2(String telephone2);

	/**
	 * Returns the station ID of this organization detail.
	 *
	 * @return the station ID of this organization detail
	 */
	@AutoEscape
	public String getStationId();

	/**
	 * Sets the station ID of this organization detail.
	 *
	 * @param stationId the station ID of this organization detail
	 */
	public void setStationId(String stationId);

	/**
	 * Returns the unit type of this organization detail.
	 *
	 * @return the unit type of this organization detail
	 */
	@AutoEscape
	public String getUnitType();

	/**
	 * Sets the unit type of this organization detail.
	 *
	 * @param unitType the unit type of this organization detail
	 */
	public void setUnitType(String unitType);

	/**
	 * Returns the org status of this organization detail.
	 *
	 * @return the org status of this organization detail
	 */
	@AutoEscape
	public String getOrgStatus();

	/**
	 * Sets the org status of this organization detail.
	 *
	 * @param orgStatus the org status of this organization detail
	 */
	public void setOrgStatus(String orgStatus);

	/**
	 * Returns the deleted of this organization detail.
	 *
	 * @return the deleted of this organization detail
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this organization detail is deleted.
	 *
	 * @return <code>true</code> if this organization detail is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this organization detail is deleted.
	 *
	 * @param deleted the deleted of this organization detail
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this organization detail.
	 *
	 * @return the status of this organization detail
	 */
	public int getStatus();

	/**
	 * Sets the status of this organization detail.
	 *
	 * @param status the status of this organization detail
	 */
	public void setStatus(int status);

}