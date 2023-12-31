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
 * The base model interface for the DesignationMode service. Represents a row in the &quot;mdm_DesignationMode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.DesignationModeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.DesignationModeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMode
 * @generated
 */
@ProviderType
public interface DesignationModeModel
	extends BaseModel<DesignationMode>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a designation mode model instance should use the {@link DesignationMode} interface instead.
	 */

	/**
	 * Returns the primary key of this designation mode.
	 *
	 * @return the primary key of this designation mode
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this designation mode.
	 *
	 * @param primaryKey the primary key of this designation mode
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the designation mode ID of this designation mode.
	 *
	 * @return the designation mode ID of this designation mode
	 */
	public long getDesignationModeId();

	/**
	 * Sets the designation mode ID of this designation mode.
	 *
	 * @param designationModeId the designation mode ID of this designation mode
	 */
	public void setDesignationModeId(long designationModeId);

	/**
	 * Returns the group ID of this designation mode.
	 *
	 * @return the group ID of this designation mode
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this designation mode.
	 *
	 * @param groupId the group ID of this designation mode
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this designation mode.
	 *
	 * @return the company ID of this designation mode
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this designation mode.
	 *
	 * @param companyId the company ID of this designation mode
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this designation mode.
	 *
	 * @return the user ID of this designation mode
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this designation mode.
	 *
	 * @param userId the user ID of this designation mode
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this designation mode.
	 *
	 * @return the user uuid of this designation mode
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this designation mode.
	 *
	 * @param userUuid the user uuid of this designation mode
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this designation mode.
	 *
	 * @return the user name of this designation mode
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this designation mode.
	 *
	 * @param userName the user name of this designation mode
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this designation mode.
	 *
	 * @return the create date of this designation mode
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this designation mode.
	 *
	 * @param createDate the create date of this designation mode
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this designation mode.
	 *
	 * @return the modified date of this designation mode
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this designation mode.
	 *
	 * @param modifiedDate the modified date of this designation mode
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this designation mode.
	 *
	 * @return the code of this designation mode
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this designation mode.
	 *
	 * @param code the code of this designation mode
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this designation mode.
	 *
	 * @return the name of this designation mode
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this designation mode.
	 *
	 * @param name the name of this designation mode
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this designation mode.
	 *
	 * @return the deleted of this designation mode
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this designation mode is deleted.
	 *
	 * @return <code>true</code> if this designation mode is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this designation mode is deleted.
	 *
	 * @param deleted the deleted of this designation mode
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this designation mode.
	 *
	 * @return the status of this designation mode
	 */
	public int getStatus();

	/**
	 * Sets the status of this designation mode.
	 *
	 * @param status the status of this designation mode
	 */
	public void setStatus(int status);

}