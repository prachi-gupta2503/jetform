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
 * The base model interface for the EmployeeTransferRequest service. Represents a row in the &quot;pis_EmployeeTransferRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferRequestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferRequestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferRequest
 * @generated
 */
@ProviderType
public interface EmployeeTransferRequestModel
	extends BaseModel<EmployeeTransferRequest>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee transfer request model instance should use the {@link EmployeeTransferRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this employee transfer request.
	 *
	 * @return the primary key of this employee transfer request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee transfer request.
	 *
	 * @param primaryKey the primary key of this employee transfer request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this employee transfer request.
	 *
	 * @return the uuid of this employee transfer request
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this employee transfer request.
	 *
	 * @param uuid the uuid of this employee transfer request
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the employee transfer request ID of this employee transfer request.
	 *
	 * @return the employee transfer request ID of this employee transfer request
	 */
	public long getEmployeeTransferRequestId();

	/**
	 * Sets the employee transfer request ID of this employee transfer request.
	 *
	 * @param employeeTransferRequestId the employee transfer request ID of this employee transfer request
	 */
	public void setEmployeeTransferRequestId(long employeeTransferRequestId);

	/**
	 * Returns the group ID of this employee transfer request.
	 *
	 * @return the group ID of this employee transfer request
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee transfer request.
	 *
	 * @param groupId the group ID of this employee transfer request
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee transfer request.
	 *
	 * @return the company ID of this employee transfer request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee transfer request.
	 *
	 * @param companyId the company ID of this employee transfer request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee transfer request.
	 *
	 * @return the user ID of this employee transfer request
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee transfer request.
	 *
	 * @param userId the user ID of this employee transfer request
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee transfer request.
	 *
	 * @return the user uuid of this employee transfer request
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee transfer request.
	 *
	 * @param userUuid the user uuid of this employee transfer request
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee transfer request.
	 *
	 * @return the user name of this employee transfer request
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee transfer request.
	 *
	 * @param userName the user name of this employee transfer request
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee transfer request.
	 *
	 * @return the create date of this employee transfer request
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee transfer request.
	 *
	 * @param createDate the create date of this employee transfer request
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee transfer request.
	 *
	 * @return the modified date of this employee transfer request
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee transfer request.
	 *
	 * @param modifiedDate the modified date of this employee transfer request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee ID of this employee transfer request.
	 *
	 * @return the employee ID of this employee transfer request
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee transfer request.
	 *
	 * @param employeeId the employee ID of this employee transfer request
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the organization ID of this employee transfer request.
	 *
	 * @return the organization ID of this employee transfer request
	 */
	public Long getOrganizationId();

	/**
	 * Sets the organization ID of this employee transfer request.
	 *
	 * @param organizationId the organization ID of this employee transfer request
	 */
	public void setOrganizationId(Long organizationId);

	/**
	 * Returns the transfer date of this employee transfer request.
	 *
	 * @return the transfer date of this employee transfer request
	 */
	@AutoEscape
	public String getTransferDate();

	/**
	 * Sets the transfer date of this employee transfer request.
	 *
	 * @param transferDate the transfer date of this employee transfer request
	 */
	public void setTransferDate(String transferDate);

	/**
	 * Returns the start date in new unit of this employee transfer request.
	 *
	 * @return the start date in new unit of this employee transfer request
	 */
	public Date getStartDateInNewUnit();

	/**
	 * Sets the start date in new unit of this employee transfer request.
	 *
	 * @param startDateInNewUnit the start date in new unit of this employee transfer request
	 */
	public void setStartDateInNewUnit(Date startDateInNewUnit);

	/**
	 * Returns the last date in current unit of this employee transfer request.
	 *
	 * @return the last date in current unit of this employee transfer request
	 */
	public Date getLastDateInCurrentUnit();

	/**
	 * Sets the last date in current unit of this employee transfer request.
	 *
	 * @param lastDateInCurrentUnit the last date in current unit of this employee transfer request
	 */
	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit);

	/**
	 * Returns the office order no of this employee transfer request.
	 *
	 * @return the office order no of this employee transfer request
	 */
	@AutoEscape
	public String getOfficeOrderNo();

	/**
	 * Sets the office order no of this employee transfer request.
	 *
	 * @param officeOrderNo the office order no of this employee transfer request
	 */
	public void setOfficeOrderNo(String officeOrderNo);

	/**
	 * Returns the process file ID of this employee transfer request.
	 *
	 * @return the process file ID of this employee transfer request
	 */
	public long getProcessFileId();

	/**
	 * Sets the process file ID of this employee transfer request.
	 *
	 * @param processFileId the process file ID of this employee transfer request
	 */
	public void setProcessFileId(long processFileId);

	/**
	 * Returns the process file no of this employee transfer request.
	 *
	 * @return the process file no of this employee transfer request
	 */
	@AutoEscape
	public String getProcessFileNo();

	/**
	 * Sets the process file no of this employee transfer request.
	 *
	 * @param processFileNo the process file no of this employee transfer request
	 */
	public void setProcessFileNo(String processFileNo);

}