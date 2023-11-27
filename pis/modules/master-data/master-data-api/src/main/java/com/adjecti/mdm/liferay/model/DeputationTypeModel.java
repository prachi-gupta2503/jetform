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
 * The base model interface for the DeputationType service. Represents a row in the &quot;mdm_DeputationType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.DeputationTypeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.DeputationTypeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeputationType
 * @generated
 */
@ProviderType
public interface DeputationTypeModel
	extends BaseModel<DeputationType>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a deputation type model instance should use the {@link DeputationType} interface instead.
	 */

	/**
	 * Returns the primary key of this deputation type.
	 *
	 * @return the primary key of this deputation type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this deputation type.
	 *
	 * @param primaryKey the primary key of this deputation type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the deputation type ID of this deputation type.
	 *
	 * @return the deputation type ID of this deputation type
	 */
	public long getDeputationTypeId();

	/**
	 * Sets the deputation type ID of this deputation type.
	 *
	 * @param deputationTypeId the deputation type ID of this deputation type
	 */
	public void setDeputationTypeId(long deputationTypeId);

	/**
	 * Returns the group ID of this deputation type.
	 *
	 * @return the group ID of this deputation type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this deputation type.
	 *
	 * @param groupId the group ID of this deputation type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this deputation type.
	 *
	 * @return the company ID of this deputation type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this deputation type.
	 *
	 * @param companyId the company ID of this deputation type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this deputation type.
	 *
	 * @return the user ID of this deputation type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this deputation type.
	 *
	 * @param userId the user ID of this deputation type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this deputation type.
	 *
	 * @return the user uuid of this deputation type
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this deputation type.
	 *
	 * @param userUuid the user uuid of this deputation type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this deputation type.
	 *
	 * @return the user name of this deputation type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this deputation type.
	 *
	 * @param userName the user name of this deputation type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this deputation type.
	 *
	 * @return the create date of this deputation type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this deputation type.
	 *
	 * @param createDate the create date of this deputation type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this deputation type.
	 *
	 * @return the modified date of this deputation type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this deputation type.
	 *
	 * @param modifiedDate the modified date of this deputation type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this deputation type.
	 *
	 * @return the description of this deputation type
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this deputation type.
	 *
	 * @param description the description of this deputation type
	 */
	public void setDescription(String description);

	/**
	 * Returns the name of this deputation type.
	 *
	 * @return the name of this deputation type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this deputation type.
	 *
	 * @param name the name of this deputation type
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this deputation type.
	 *
	 * @return the deleted of this deputation type
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this deputation type is deleted.
	 *
	 * @return <code>true</code> if this deputation type is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this deputation type is deleted.
	 *
	 * @param deleted the deleted of this deputation type
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this deputation type.
	 *
	 * @return the status of this deputation type
	 */
	public int getStatus();

	/**
	 * Sets the status of this deputation type.
	 *
	 * @param status the status of this deputation type
	 */
	public void setStatus(int status);

}