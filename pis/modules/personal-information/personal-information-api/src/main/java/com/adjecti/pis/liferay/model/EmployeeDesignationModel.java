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
 * The base model interface for the EmployeeDesignation service. Represents a row in the &quot;pis_EmployeeDesignation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeDesignationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeDesignationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignation
 * @generated
 */
@ProviderType
public interface EmployeeDesignationModel
	extends BaseModel<EmployeeDesignation>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee designation model instance should use the {@link EmployeeDesignation} interface instead.
	 */

	/**
	 * Returns the primary key of this employee designation.
	 *
	 * @return the primary key of this employee designation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee designation.
	 *
	 * @param primaryKey the primary key of this employee designation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee designation ID of this employee designation.
	 *
	 * @return the employee designation ID of this employee designation
	 */
	public long getEmployeeDesignationId();

	/**
	 * Sets the employee designation ID of this employee designation.
	 *
	 * @param employeeDesignationId the employee designation ID of this employee designation
	 */
	public void setEmployeeDesignationId(long employeeDesignationId);

	/**
	 * Returns the group ID of this employee designation.
	 *
	 * @return the group ID of this employee designation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee designation.
	 *
	 * @param groupId the group ID of this employee designation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee designation.
	 *
	 * @return the company ID of this employee designation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee designation.
	 *
	 * @param companyId the company ID of this employee designation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee designation.
	 *
	 * @return the user ID of this employee designation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee designation.
	 *
	 * @param userId the user ID of this employee designation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee designation.
	 *
	 * @return the user uuid of this employee designation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee designation.
	 *
	 * @param userUuid the user uuid of this employee designation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee designation.
	 *
	 * @return the user name of this employee designation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee designation.
	 *
	 * @param userName the user name of this employee designation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee designation.
	 *
	 * @return the create date of this employee designation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee designation.
	 *
	 * @param createDate the create date of this employee designation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee designation.
	 *
	 * @return the modified date of this employee designation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee designation.
	 *
	 * @param modifiedDate the modified date of this employee designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this employee designation.
	 *
	 * @return the active of this employee designation
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this employee designation is active.
	 *
	 * @return <code>true</code> if this employee designation is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this employee designation is active.
	 *
	 * @param active the active of this employee designation
	 */
	public void setActive(boolean active);

	/**
	 * Returns the from date of this employee designation.
	 *
	 * @return the from date of this employee designation
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this employee designation.
	 *
	 * @param fromDate the from date of this employee designation
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this employee designation.
	 *
	 * @return the to date of this employee designation
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this employee designation.
	 *
	 * @param toDate the to date of this employee designation
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the designation ID of this employee designation.
	 *
	 * @return the designation ID of this employee designation
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this employee designation.
	 *
	 * @param designationId the designation ID of this employee designation
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the employee ID of this employee designation.
	 *
	 * @return the employee ID of this employee designation
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee designation.
	 *
	 * @param employeeId the employee ID of this employee designation
	 */
	public void setEmployeeId(long employeeId);

}