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
 * The base model interface for the EmployeeDocument service. Represents a row in the &quot;pis_EmployeeDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeDocumentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeDocumentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocument
 * @generated
 */
@ProviderType
public interface EmployeeDocumentModel
	extends BaseModel<EmployeeDocument>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee document model instance should use the {@link EmployeeDocument} interface instead.
	 */

	/**
	 * Returns the primary key of this employee document.
	 *
	 * @return the primary key of this employee document
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee document.
	 *
	 * @param primaryKey the primary key of this employee document
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee document ID of this employee document.
	 *
	 * @return the employee document ID of this employee document
	 */
	public long getEmployeeDocumentId();

	/**
	 * Sets the employee document ID of this employee document.
	 *
	 * @param employeeDocumentId the employee document ID of this employee document
	 */
	public void setEmployeeDocumentId(long employeeDocumentId);

	/**
	 * Returns the group ID of this employee document.
	 *
	 * @return the group ID of this employee document
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee document.
	 *
	 * @param groupId the group ID of this employee document
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee document.
	 *
	 * @return the company ID of this employee document
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee document.
	 *
	 * @param companyId the company ID of this employee document
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee document.
	 *
	 * @return the user ID of this employee document
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee document.
	 *
	 * @param userId the user ID of this employee document
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee document.
	 *
	 * @return the user uuid of this employee document
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee document.
	 *
	 * @param userUuid the user uuid of this employee document
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee document.
	 *
	 * @return the user name of this employee document
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee document.
	 *
	 * @param userName the user name of this employee document
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee document.
	 *
	 * @return the create date of this employee document
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee document.
	 *
	 * @param createDate the create date of this employee document
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee document.
	 *
	 * @return the modified date of this employee document
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee document.
	 *
	 * @param modifiedDate the modified date of this employee document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this employee document.
	 *
	 * @return the active of this employee document
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this employee document is active.
	 *
	 * @return <code>true</code> if this employee document is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this employee document is active.
	 *
	 * @param active the active of this employee document
	 */
	public void setActive(boolean active);

	/**
	 * Returns the document ID of this employee document.
	 *
	 * @return the document ID of this employee document
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this employee document.
	 *
	 * @param documentId the document ID of this employee document
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the employee ID of this employee document.
	 *
	 * @return the employee ID of this employee document
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee document.
	 *
	 * @param employeeId the employee ID of this employee document
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the title of this employee document.
	 *
	 * @return the title of this employee document
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this employee document.
	 *
	 * @param title the title of this employee document
	 */
	public void setTitle(String title);

	/**
	 * Returns the document type ID of this employee document.
	 *
	 * @return the document type ID of this employee document
	 */
	public long getDocumentTypeId();

	/**
	 * Sets the document type ID of this employee document.
	 *
	 * @param documentTypeId the document type ID of this employee document
	 */
	public void setDocumentTypeId(long documentTypeId);

	/**
	 * Returns the discription of this employee document.
	 *
	 * @return the discription of this employee document
	 */
	@AutoEscape
	public String getDiscription();

	/**
	 * Sets the discription of this employee document.
	 *
	 * @param discription the discription of this employee document
	 */
	public void setDiscription(String discription);

}