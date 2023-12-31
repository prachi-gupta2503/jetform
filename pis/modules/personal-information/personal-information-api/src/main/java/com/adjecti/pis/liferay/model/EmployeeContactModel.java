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
 * The base model interface for the EmployeeContact service. Represents a row in the &quot;pis_EmployeeContact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeContactModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeContactImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContact
 * @generated
 */
@ProviderType
public interface EmployeeContactModel
	extends BaseModel<EmployeeContact>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee contact model instance should use the {@link EmployeeContact} interface instead.
	 */

	/**
	 * Returns the primary key of this employee contact.
	 *
	 * @return the primary key of this employee contact
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee contact.
	 *
	 * @param primaryKey the primary key of this employee contact
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee contact ID of this employee contact.
	 *
	 * @return the employee contact ID of this employee contact
	 */
	public long getEmployeeContactId();

	/**
	 * Sets the employee contact ID of this employee contact.
	 *
	 * @param employeeContactId the employee contact ID of this employee contact
	 */
	public void setEmployeeContactId(long employeeContactId);

	/**
	 * Returns the group ID of this employee contact.
	 *
	 * @return the group ID of this employee contact
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee contact.
	 *
	 * @param groupId the group ID of this employee contact
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee contact.
	 *
	 * @return the company ID of this employee contact
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee contact.
	 *
	 * @param companyId the company ID of this employee contact
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee contact.
	 *
	 * @return the user ID of this employee contact
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee contact.
	 *
	 * @param userId the user ID of this employee contact
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee contact.
	 *
	 * @return the user uuid of this employee contact
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee contact.
	 *
	 * @param userUuid the user uuid of this employee contact
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee contact.
	 *
	 * @return the user name of this employee contact
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee contact.
	 *
	 * @param userName the user name of this employee contact
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee contact.
	 *
	 * @return the create date of this employee contact
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee contact.
	 *
	 * @param createDate the create date of this employee contact
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee contact.
	 *
	 * @return the modified date of this employee contact
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee contact.
	 *
	 * @param modifiedDate the modified date of this employee contact
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the desk no of this employee contact.
	 *
	 * @return the desk no of this employee contact
	 */
	@AutoEscape
	public String getDeskNo();

	/**
	 * Sets the desk no of this employee contact.
	 *
	 * @param deskNo the desk no of this employee contact
	 */
	public void setDeskNo(String deskNo);

	/**
	 * Returns the extn of this employee contact.
	 *
	 * @return the extn of this employee contact
	 */
	@AutoEscape
	public String getExtn();

	/**
	 * Sets the extn of this employee contact.
	 *
	 * @param extn the extn of this employee contact
	 */
	public void setExtn(String extn);

	/**
	 * Returns the phone no of this employee contact.
	 *
	 * @return the phone no of this employee contact
	 */
	@AutoEscape
	public String getPhoneNo();

	/**
	 * Sets the phone no of this employee contact.
	 *
	 * @param phoneNo the phone no of this employee contact
	 */
	public void setPhoneNo(String phoneNo);

	/**
	 * Returns the contact ID of this employee contact.
	 *
	 * @return the contact ID of this employee contact
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this employee contact.
	 *
	 * @param contactId the contact ID of this employee contact
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the employee ID of this employee contact.
	 *
	 * @return the employee ID of this employee contact
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee contact.
	 *
	 * @param employeeId the employee ID of this employee contact
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the direct no of this employee contact.
	 *
	 * @return the direct no of this employee contact
	 */
	@AutoEscape
	public String getDirectNo();

	/**
	 * Sets the direct no of this employee contact.
	 *
	 * @param directNo the direct no of this employee contact
	 */
	public void setDirectNo(String directNo);

}