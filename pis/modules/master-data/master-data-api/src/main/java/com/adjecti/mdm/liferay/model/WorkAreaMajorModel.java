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
 * The base model interface for the WorkAreaMajor service. Represents a row in the &quot;mdm_WorkAreaMajor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMajorModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.WorkAreaMajorImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMajor
 * @generated
 */
@ProviderType
public interface WorkAreaMajorModel
	extends BaseModel<WorkAreaMajor>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a work area major model instance should use the {@link WorkAreaMajor} interface instead.
	 */

	/**
	 * Returns the primary key of this work area major.
	 *
	 * @return the primary key of this work area major
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this work area major.
	 *
	 * @param primaryKey the primary key of this work area major
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the work area major ID of this work area major.
	 *
	 * @return the work area major ID of this work area major
	 */
	public long getWorkAreaMajorId();

	/**
	 * Sets the work area major ID of this work area major.
	 *
	 * @param workAreaMajorId the work area major ID of this work area major
	 */
	public void setWorkAreaMajorId(long workAreaMajorId);

	/**
	 * Returns the group ID of this work area major.
	 *
	 * @return the group ID of this work area major
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this work area major.
	 *
	 * @param groupId the group ID of this work area major
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this work area major.
	 *
	 * @return the company ID of this work area major
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this work area major.
	 *
	 * @param companyId the company ID of this work area major
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this work area major.
	 *
	 * @return the user ID of this work area major
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this work area major.
	 *
	 * @param userId the user ID of this work area major
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this work area major.
	 *
	 * @return the user uuid of this work area major
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this work area major.
	 *
	 * @param userUuid the user uuid of this work area major
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this work area major.
	 *
	 * @return the user name of this work area major
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this work area major.
	 *
	 * @param userName the user name of this work area major
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this work area major.
	 *
	 * @return the create date of this work area major
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this work area major.
	 *
	 * @param createDate the create date of this work area major
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this work area major.
	 *
	 * @return the modified date of this work area major
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this work area major.
	 *
	 * @param modifiedDate the modified date of this work area major
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this work area major.
	 *
	 * @return the code of this work area major
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this work area major.
	 *
	 * @param code the code of this work area major
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this work area major.
	 *
	 * @return the name of this work area major
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this work area major.
	 *
	 * @param name the name of this work area major
	 */
	public void setName(String name);

	/**
	 * Returns the work area type ID of this work area major.
	 *
	 * @return the work area type ID of this work area major
	 */
	public long getWorkAreaTypeId();

	/**
	 * Sets the work area type ID of this work area major.
	 *
	 * @param workAreaTypeId the work area type ID of this work area major
	 */
	public void setWorkAreaTypeId(long workAreaTypeId);

	/**
	 * Returns the parent work area ID of this work area major.
	 *
	 * @return the parent work area ID of this work area major
	 */
	public long getParentWorkAreaId();

	/**
	 * Sets the parent work area ID of this work area major.
	 *
	 * @param parentWorkAreaId the parent work area ID of this work area major
	 */
	public void setParentWorkAreaId(long parentWorkAreaId);

	/**
	 * Returns the deleted of this work area major.
	 *
	 * @return the deleted of this work area major
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this work area major is deleted.
	 *
	 * @return <code>true</code> if this work area major is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this work area major is deleted.
	 *
	 * @param deleted the deleted of this work area major
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this work area major.
	 *
	 * @return the status of this work area major
	 */
	public int getStatus();

	/**
	 * Sets the status of this work area major.
	 *
	 * @param status the status of this work area major
	 */
	public void setStatus(int status);

}