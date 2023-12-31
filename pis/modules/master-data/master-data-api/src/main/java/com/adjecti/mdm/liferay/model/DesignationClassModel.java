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
 * The base model interface for the DesignationClass service. Represents a row in the &quot;mdm_DesignationClass&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.DesignationClassModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.DesignationClassImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationClass
 * @generated
 */
@ProviderType
public interface DesignationClassModel
	extends BaseModel<DesignationClass>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a designation class model instance should use the {@link DesignationClass} interface instead.
	 */

	/**
	 * Returns the primary key of this designation class.
	 *
	 * @return the primary key of this designation class
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this designation class.
	 *
	 * @param primaryKey the primary key of this designation class
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the designation class ID of this designation class.
	 *
	 * @return the designation class ID of this designation class
	 */
	public long getDesignationClassId();

	/**
	 * Sets the designation class ID of this designation class.
	 *
	 * @param designationClassId the designation class ID of this designation class
	 */
	public void setDesignationClassId(long designationClassId);

	/**
	 * Returns the group ID of this designation class.
	 *
	 * @return the group ID of this designation class
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this designation class.
	 *
	 * @param groupId the group ID of this designation class
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this designation class.
	 *
	 * @return the company ID of this designation class
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this designation class.
	 *
	 * @param companyId the company ID of this designation class
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this designation class.
	 *
	 * @return the user ID of this designation class
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this designation class.
	 *
	 * @param userId the user ID of this designation class
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this designation class.
	 *
	 * @return the user uuid of this designation class
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this designation class.
	 *
	 * @param userUuid the user uuid of this designation class
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this designation class.
	 *
	 * @return the user name of this designation class
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this designation class.
	 *
	 * @param userName the user name of this designation class
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this designation class.
	 *
	 * @return the create date of this designation class
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this designation class.
	 *
	 * @param createDate the create date of this designation class
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this designation class.
	 *
	 * @return the modified date of this designation class
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this designation class.
	 *
	 * @param modifiedDate the modified date of this designation class
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this designation class.
	 *
	 * @return the name of this designation class
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this designation class.
	 *
	 * @param name the name of this designation class
	 */
	public void setName(String name);

	/**
	 * Returns the description of this designation class.
	 *
	 * @return the description of this designation class
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this designation class.
	 *
	 * @param description the description of this designation class
	 */
	public void setDescription(String description);

	/**
	 * Returns the code of this designation class.
	 *
	 * @return the code of this designation class
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this designation class.
	 *
	 * @param code the code of this designation class
	 */
	public void setCode(String code);

	/**
	 * Returns the deleted of this designation class.
	 *
	 * @return the deleted of this designation class
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this designation class is deleted.
	 *
	 * @return <code>true</code> if this designation class is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this designation class is deleted.
	 *
	 * @param deleted the deleted of this designation class
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this designation class.
	 *
	 * @return the status of this designation class
	 */
	public int getStatus();

	/**
	 * Sets the status of this designation class.
	 *
	 * @param status the status of this designation class
	 */
	public void setStatus(int status);

}