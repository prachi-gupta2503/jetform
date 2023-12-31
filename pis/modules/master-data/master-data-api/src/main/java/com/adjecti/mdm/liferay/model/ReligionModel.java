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
 * The base model interface for the Religion service. Represents a row in the &quot;mdm_Religion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.ReligionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.ReligionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Religion
 * @generated
 */
@ProviderType
public interface ReligionModel
	extends BaseModel<Religion>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a religion model instance should use the {@link Religion} interface instead.
	 */

	/**
	 * Returns the primary key of this religion.
	 *
	 * @return the primary key of this religion
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this religion.
	 *
	 * @param primaryKey the primary key of this religion
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the religion ID of this religion.
	 *
	 * @return the religion ID of this religion
	 */
	public long getReligionId();

	/**
	 * Sets the religion ID of this religion.
	 *
	 * @param religionId the religion ID of this religion
	 */
	public void setReligionId(long religionId);

	/**
	 * Returns the group ID of this religion.
	 *
	 * @return the group ID of this religion
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this religion.
	 *
	 * @param groupId the group ID of this religion
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this religion.
	 *
	 * @return the company ID of this religion
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this religion.
	 *
	 * @param companyId the company ID of this religion
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this religion.
	 *
	 * @return the user ID of this religion
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this religion.
	 *
	 * @param userId the user ID of this religion
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this religion.
	 *
	 * @return the user uuid of this religion
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this religion.
	 *
	 * @param userUuid the user uuid of this religion
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this religion.
	 *
	 * @return the user name of this religion
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this religion.
	 *
	 * @param userName the user name of this religion
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this religion.
	 *
	 * @return the create date of this religion
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this religion.
	 *
	 * @param createDate the create date of this religion
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this religion.
	 *
	 * @return the modified date of this religion
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this religion.
	 *
	 * @param modifiedDate the modified date of this religion
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this religion.
	 *
	 * @return the code of this religion
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this religion.
	 *
	 * @param code the code of this religion
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this religion.
	 *
	 * @return the name of this religion
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this religion.
	 *
	 * @param name the name of this religion
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this religion.
	 *
	 * @return the deleted of this religion
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this religion is deleted.
	 *
	 * @return <code>true</code> if this religion is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this religion is deleted.
	 *
	 * @param deleted the deleted of this religion
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this religion.
	 *
	 * @return the status of this religion
	 */
	public int getStatus();

	/**
	 * Sets the status of this religion.
	 *
	 * @param status the status of this religion
	 */
	public void setStatus(int status);

}