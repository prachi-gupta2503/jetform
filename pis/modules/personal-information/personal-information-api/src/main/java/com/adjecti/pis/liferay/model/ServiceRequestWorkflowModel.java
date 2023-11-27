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
 * The base model interface for the ServiceRequestWorkflow service. Represents a row in the &quot;pis_ServiceRequestWorkflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWorkflow
 * @generated
 */
@ProviderType
public interface ServiceRequestWorkflowModel
	extends BaseModel<ServiceRequestWorkflow>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a service request workflow model instance should use the {@link ServiceRequestWorkflow} interface instead.
	 */

	/**
	 * Returns the primary key of this service request workflow.
	 *
	 * @return the primary key of this service request workflow
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this service request workflow.
	 *
	 * @param primaryKey the primary key of this service request workflow
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the service request workflow ID of this service request workflow.
	 *
	 * @return the service request workflow ID of this service request workflow
	 */
	public long getServiceRequestWorkflowId();

	/**
	 * Sets the service request workflow ID of this service request workflow.
	 *
	 * @param serviceRequestWorkflowId the service request workflow ID of this service request workflow
	 */
	public void setServiceRequestWorkflowId(long serviceRequestWorkflowId);

	/**
	 * Returns the group ID of this service request workflow.
	 *
	 * @return the group ID of this service request workflow
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this service request workflow.
	 *
	 * @param groupId the group ID of this service request workflow
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this service request workflow.
	 *
	 * @return the company ID of this service request workflow
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this service request workflow.
	 *
	 * @param companyId the company ID of this service request workflow
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this service request workflow.
	 *
	 * @return the user ID of this service request workflow
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this service request workflow.
	 *
	 * @param userId the user ID of this service request workflow
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this service request workflow.
	 *
	 * @return the user uuid of this service request workflow
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this service request workflow.
	 *
	 * @param userUuid the user uuid of this service request workflow
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this service request workflow.
	 *
	 * @return the user name of this service request workflow
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this service request workflow.
	 *
	 * @param userName the user name of this service request workflow
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this service request workflow.
	 *
	 * @return the create date of this service request workflow
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this service request workflow.
	 *
	 * @param createDate the create date of this service request workflow
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this service request workflow.
	 *
	 * @return the modified date of this service request workflow
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this service request workflow.
	 *
	 * @param modifiedDate the modified date of this service request workflow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the service request ID of this service request workflow.
	 *
	 * @return the service request ID of this service request workflow
	 */
	public long getServiceRequestId();

	/**
	 * Sets the service request ID of this service request workflow.
	 *
	 * @param serviceRequestId the service request ID of this service request workflow
	 */
	public void setServiceRequestId(long serviceRequestId);

	/**
	 * Returns the employee ID of this service request workflow.
	 *
	 * @return the employee ID of this service request workflow
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this service request workflow.
	 *
	 * @param employeeId the employee ID of this service request workflow
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the class name of this service request workflow.
	 *
	 * @return the class name of this service request workflow
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this service request workflow.
	 *
	 * @param className the class name of this service request workflow
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this service request workflow.
	 *
	 * @return the class pk of this service request workflow
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this service request workflow.
	 *
	 * @param classPK the class pk of this service request workflow
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the remark of this service request workflow.
	 *
	 * @return the remark of this service request workflow
	 */
	@AutoEscape
	public String getRemark();

	/**
	 * Sets the remark of this service request workflow.
	 *
	 * @param remark the remark of this service request workflow
	 */
	public void setRemark(String remark);

	/**
	 * Returns the status of this service request workflow.
	 *
	 * @return the status of this service request workflow
	 */
	public int getStatus();

	/**
	 * Sets the status of this service request workflow.
	 *
	 * @param status the status of this service request workflow
	 */
	public void setStatus(int status);

}