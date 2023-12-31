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
 * The base model interface for the District service. Represents a row in the &quot;mdm_District&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.DistrictModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.DistrictImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see District
 * @generated
 */
@ProviderType
public interface DistrictModel
	extends BaseModel<District>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a district model instance should use the {@link District} interface instead.
	 */

	/**
	 * Returns the primary key of this district.
	 *
	 * @return the primary key of this district
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this district.
	 *
	 * @param primaryKey the primary key of this district
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the district ID of this district.
	 *
	 * @return the district ID of this district
	 */
	public long getDistrictId();

	/**
	 * Sets the district ID of this district.
	 *
	 * @param districtId the district ID of this district
	 */
	public void setDistrictId(long districtId);

	/**
	 * Returns the group ID of this district.
	 *
	 * @return the group ID of this district
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this district.
	 *
	 * @param groupId the group ID of this district
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this district.
	 *
	 * @return the company ID of this district
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this district.
	 *
	 * @param companyId the company ID of this district
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this district.
	 *
	 * @return the user ID of this district
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this district.
	 *
	 * @param userId the user ID of this district
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this district.
	 *
	 * @return the user uuid of this district
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this district.
	 *
	 * @param userUuid the user uuid of this district
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this district.
	 *
	 * @return the user name of this district
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this district.
	 *
	 * @param userName the user name of this district
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this district.
	 *
	 * @return the create date of this district
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this district.
	 *
	 * @param createDate the create date of this district
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this district.
	 *
	 * @return the modified date of this district
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this district.
	 *
	 * @param modifiedDate the modified date of this district
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this district.
	 *
	 * @return the code of this district
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this district.
	 *
	 * @param code the code of this district
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this district.
	 *
	 * @return the name of this district
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this district.
	 *
	 * @param name the name of this district
	 */
	public void setName(String name);

	/**
	 * Returns the state ID of this district.
	 *
	 * @return the state ID of this district
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this district.
	 *
	 * @param stateId the state ID of this district
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the deleted of this district.
	 *
	 * @return the deleted of this district
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this district is deleted.
	 *
	 * @return <code>true</code> if this district is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this district is deleted.
	 *
	 * @param deleted the deleted of this district
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this district.
	 *
	 * @return the status of this district
	 */
	public int getStatus();

	/**
	 * Sets the status of this district.
	 *
	 * @param status the status of this district
	 */
	public void setStatus(int status);

}