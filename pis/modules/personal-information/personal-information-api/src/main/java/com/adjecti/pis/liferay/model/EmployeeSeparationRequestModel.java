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
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EmployeeSeparationRequest service. Represents a row in the &quot;pis_EmployeeSeparationRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSeparationRequest
 * @generated
 */
@ProviderType
public interface EmployeeSeparationRequestModel
	extends BaseModel<EmployeeSeparationRequest>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee separation request model instance should use the {@link EmployeeSeparationRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this employee separation request.
	 *
	 * @return the primary key of this employee separation request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee separation request.
	 *
	 * @param primaryKey the primary key of this employee separation request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this employee separation request.
	 *
	 * @return the uuid of this employee separation request
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this employee separation request.
	 *
	 * @param uuid the uuid of this employee separation request
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the employee separation request ID of this employee separation request.
	 *
	 * @return the employee separation request ID of this employee separation request
	 */
	public long getEmployeeSeparationRequestId();

	/**
	 * Sets the employee separation request ID of this employee separation request.
	 *
	 * @param employeeSeparationRequestId the employee separation request ID of this employee separation request
	 */
	public void setEmployeeSeparationRequestId(
		long employeeSeparationRequestId);

	/**
	 * Returns the group ID of this employee separation request.
	 *
	 * @return the group ID of this employee separation request
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee separation request.
	 *
	 * @param groupId the group ID of this employee separation request
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee separation request.
	 *
	 * @return the company ID of this employee separation request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee separation request.
	 *
	 * @param companyId the company ID of this employee separation request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee separation request.
	 *
	 * @return the user ID of this employee separation request
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee separation request.
	 *
	 * @param userId the user ID of this employee separation request
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee separation request.
	 *
	 * @return the user uuid of this employee separation request
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee separation request.
	 *
	 * @param userUuid the user uuid of this employee separation request
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee separation request.
	 *
	 * @return the user name of this employee separation request
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee separation request.
	 *
	 * @param userName the user name of this employee separation request
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee separation request.
	 *
	 * @return the create date of this employee separation request
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee separation request.
	 *
	 * @param createDate the create date of this employee separation request
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee separation request.
	 *
	 * @return the modified date of this employee separation request
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee separation request.
	 *
	 * @param modifiedDate the modified date of this employee separation request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee ID of this employee separation request.
	 *
	 * @return the employee ID of this employee separation request
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee separation request.
	 *
	 * @param employeeId the employee ID of this employee separation request
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the separation mode of this employee separation request.
	 *
	 * @return the separation mode of this employee separation request
	 */
	@AutoEscape
	public String getSeparationMode();

	/**
	 * Sets the separation mode of this employee separation request.
	 *
	 * @param separationMode the separation mode of this employee separation request
	 */
	public void setSeparationMode(String separationMode);

	/**
	 * Returns the separation date of this employee separation request.
	 *
	 * @return the separation date of this employee separation request
	 */
	public Date getSeparationDate();

	/**
	 * Sets the separation date of this employee separation request.
	 *
	 * @param separationDate the separation date of this employee separation request
	 */
	public void setSeparationDate(Date separationDate);

	/**
	 * Returns the remarks of this employee separation request.
	 *
	 * @return the remarks of this employee separation request
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this employee separation request.
	 *
	 * @param remarks the remarks of this employee separation request
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the process file ID of this employee separation request.
	 *
	 * @return the process file ID of this employee separation request
	 */
	public long getProcessFileId();

	/**
	 * Sets the process file ID of this employee separation request.
	 *
	 * @param processFileId the process file ID of this employee separation request
	 */
	public void setProcessFileId(long processFileId);

	/**
	 * Returns the process file no of this employee separation request.
	 *
	 * @return the process file no of this employee separation request
	 */
	@AutoEscape
	public String getProcessFileNo();

	/**
	 * Sets the process file no of this employee separation request.
	 *
	 * @param processFileNo the process file no of this employee separation request
	 */
	public void setProcessFileNo(String processFileNo);

	/**
	 * Returns the office order no of this employee separation request.
	 *
	 * @return the office order no of this employee separation request
	 */
	@AutoEscape
	public String getOfficeOrderNo();

	/**
	 * Sets the office order no of this employee separation request.
	 *
	 * @param officeOrderNo the office order no of this employee separation request
	 */
	public void setOfficeOrderNo(String officeOrderNo);

}