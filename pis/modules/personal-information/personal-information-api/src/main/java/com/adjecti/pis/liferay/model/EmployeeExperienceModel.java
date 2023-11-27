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
 * The base model interface for the EmployeeExperience service. Represents a row in the &quot;pis_EmployeeExperience&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeExperienceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeExperienceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperience
 * @generated
 */
@ProviderType
public interface EmployeeExperienceModel
	extends BaseModel<EmployeeExperience>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee experience model instance should use the {@link EmployeeExperience} interface instead.
	 */

	/**
	 * Returns the primary key of this employee experience.
	 *
	 * @return the primary key of this employee experience
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee experience.
	 *
	 * @param primaryKey the primary key of this employee experience
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee experience ID of this employee experience.
	 *
	 * @return the employee experience ID of this employee experience
	 */
	public long getEmployeeExperienceId();

	/**
	 * Sets the employee experience ID of this employee experience.
	 *
	 * @param employeeExperienceId the employee experience ID of this employee experience
	 */
	public void setEmployeeExperienceId(long employeeExperienceId);

	/**
	 * Returns the group ID of this employee experience.
	 *
	 * @return the group ID of this employee experience
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee experience.
	 *
	 * @param groupId the group ID of this employee experience
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee experience.
	 *
	 * @return the company ID of this employee experience
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee experience.
	 *
	 * @param companyId the company ID of this employee experience
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee experience.
	 *
	 * @return the user ID of this employee experience
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee experience.
	 *
	 * @param userId the user ID of this employee experience
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee experience.
	 *
	 * @return the user uuid of this employee experience
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee experience.
	 *
	 * @param userUuid the user uuid of this employee experience
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee experience.
	 *
	 * @return the user name of this employee experience
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee experience.
	 *
	 * @param userName the user name of this employee experience
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee experience.
	 *
	 * @return the create date of this employee experience
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee experience.
	 *
	 * @param createDate the create date of this employee experience
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee experience.
	 *
	 * @return the modified date of this employee experience
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee experience.
	 *
	 * @param modifiedDate the modified date of this employee experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this employee experience.
	 *
	 * @return the active of this employee experience
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this employee experience is active.
	 *
	 * @return <code>true</code> if this employee experience is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this employee experience is active.
	 *
	 * @param active the active of this employee experience
	 */
	public void setActive(boolean active);

	/**
	 * Returns the from date of this employee experience.
	 *
	 * @return the from date of this employee experience
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this employee experience.
	 *
	 * @param fromDate the from date of this employee experience
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this employee experience.
	 *
	 * @return the to date of this employee experience
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this employee experience.
	 *
	 * @param toDate the to date of this employee experience
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the designation ID of this employee experience.
	 *
	 * @return the designation ID of this employee experience
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this employee experience.
	 *
	 * @param designationId the designation ID of this employee experience
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the employee ID of this employee experience.
	 *
	 * @return the employee ID of this employee experience
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee experience.
	 *
	 * @param employeeId the employee ID of this employee experience
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the post ID of this employee experience.
	 *
	 * @return the post ID of this employee experience
	 */
	public long getPostId();

	/**
	 * Sets the post ID of this employee experience.
	 *
	 * @param postId the post ID of this employee experience
	 */
	public void setPostId(long postId);

	/**
	 * Returns the trade ID of this employee experience.
	 *
	 * @return the trade ID of this employee experience
	 */
	public long getTradeId();

	/**
	 * Sets the trade ID of this employee experience.
	 *
	 * @param tradeId the trade ID of this employee experience
	 */
	public void setTradeId(long tradeId);

	/**
	 * Returns the experience ID of this employee experience.
	 *
	 * @return the experience ID of this employee experience
	 */
	public long getExperienceId();

	/**
	 * Sets the experience ID of this employee experience.
	 *
	 * @param experienceId the experience ID of this employee experience
	 */
	public void setExperienceId(long experienceId);

	/**
	 * Returns the organization ID of this employee experience.
	 *
	 * @return the organization ID of this employee experience
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this employee experience.
	 *
	 * @param organizationId the organization ID of this employee experience
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the work area ID of this employee experience.
	 *
	 * @return the work area ID of this employee experience
	 */
	public long getWorkAreaId();

	/**
	 * Sets the work area ID of this employee experience.
	 *
	 * @param workAreaId the work area ID of this employee experience
	 */
	public void setWorkAreaId(long workAreaId);

	/**
	 * Returns the work area minor ID of this employee experience.
	 *
	 * @return the work area minor ID of this employee experience
	 */
	public long getWorkAreaMinorId();

	/**
	 * Sets the work area minor ID of this employee experience.
	 *
	 * @param workAreaMinorId the work area minor ID of this employee experience
	 */
	public void setWorkAreaMinorId(long workAreaMinorId);

	/**
	 * Returns the status of this employee experience.
	 *
	 * @return the status of this employee experience
	 */
	public int getStatus();

	/**
	 * Sets the status of this employee experience.
	 *
	 * @param status the status of this employee experience
	 */
	public void setStatus(int status);

}