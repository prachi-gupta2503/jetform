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
 * The base model interface for the EmployeeApplication service. Represents a row in the &quot;pis_EmployeeApplication&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplication
 * @generated
 */
@ProviderType
public interface EmployeeApplicationModel
	extends BaseModel<EmployeeApplication>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee application model instance should use the {@link EmployeeApplication} interface instead.
	 */

	/**
	 * Returns the primary key of this employee application.
	 *
	 * @return the primary key of this employee application
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee application.
	 *
	 * @param primaryKey the primary key of this employee application
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee application ID of this employee application.
	 *
	 * @return the employee application ID of this employee application
	 */
	public long getEmployeeApplicationId();

	/**
	 * Sets the employee application ID of this employee application.
	 *
	 * @param employeeApplicationId the employee application ID of this employee application
	 */
	public void setEmployeeApplicationId(long employeeApplicationId);

	/**
	 * Returns the group ID of this employee application.
	 *
	 * @return the group ID of this employee application
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee application.
	 *
	 * @param groupId the group ID of this employee application
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee application.
	 *
	 * @return the company ID of this employee application
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee application.
	 *
	 * @param companyId the company ID of this employee application
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee application.
	 *
	 * @return the user ID of this employee application
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee application.
	 *
	 * @param userId the user ID of this employee application
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee application.
	 *
	 * @return the user uuid of this employee application
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee application.
	 *
	 * @param userUuid the user uuid of this employee application
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee application.
	 *
	 * @return the user name of this employee application
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee application.
	 *
	 * @param userName the user name of this employee application
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee application.
	 *
	 * @return the create date of this employee application
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee application.
	 *
	 * @param createDate the create date of this employee application
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee application.
	 *
	 * @return the modified date of this employee application
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee application.
	 *
	 * @param modifiedDate the modified date of this employee application
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee ID of this employee application.
	 *
	 * @return the employee ID of this employee application
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee application.
	 *
	 * @param employeeId the employee ID of this employee application
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the application ID of this employee application.
	 *
	 * @return the application ID of this employee application
	 */
	public long getApplicationId();

	/**
	 * Sets the application ID of this employee application.
	 *
	 * @param applicationId the application ID of this employee application
	 */
	public void setApplicationId(long applicationId);

}