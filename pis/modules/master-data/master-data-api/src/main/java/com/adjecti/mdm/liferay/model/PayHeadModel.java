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
 * The base model interface for the PayHead service. Represents a row in the &quot;mdm_PayHead&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.PayHeadModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.PayHeadImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHead
 * @generated
 */
@ProviderType
public interface PayHeadModel
	extends BaseModel<PayHead>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pay head model instance should use the {@link PayHead} interface instead.
	 */

	/**
	 * Returns the primary key of this pay head.
	 *
	 * @return the primary key of this pay head
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pay head.
	 *
	 * @param primaryKey the primary key of this pay head
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the pay head ID of this pay head.
	 *
	 * @return the pay head ID of this pay head
	 */
	public long getPayHeadId();

	/**
	 * Sets the pay head ID of this pay head.
	 *
	 * @param payHeadId the pay head ID of this pay head
	 */
	public void setPayHeadId(long payHeadId);

	/**
	 * Returns the group ID of this pay head.
	 *
	 * @return the group ID of this pay head
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this pay head.
	 *
	 * @param groupId the group ID of this pay head
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this pay head.
	 *
	 * @return the company ID of this pay head
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pay head.
	 *
	 * @param companyId the company ID of this pay head
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this pay head.
	 *
	 * @return the user ID of this pay head
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this pay head.
	 *
	 * @param userId the user ID of this pay head
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this pay head.
	 *
	 * @return the user uuid of this pay head
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this pay head.
	 *
	 * @param userUuid the user uuid of this pay head
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this pay head.
	 *
	 * @return the user name of this pay head
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this pay head.
	 *
	 * @param userName the user name of this pay head
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this pay head.
	 *
	 * @return the create date of this pay head
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this pay head.
	 *
	 * @param createDate the create date of this pay head
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this pay head.
	 *
	 * @return the modified date of this pay head
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pay head.
	 *
	 * @param modifiedDate the modified date of this pay head
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this pay head.
	 *
	 * @return the active of this pay head
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this pay head is active.
	 *
	 * @return <code>true</code> if this pay head is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this pay head is active.
	 *
	 * @param active the active of this pay head
	 */
	public void setActive(boolean active);

	/**
	 * Returns the code of this pay head.
	 *
	 * @return the code of this pay head
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this pay head.
	 *
	 * @param code the code of this pay head
	 */
	public void setCode(String code);

	/**
	 * Returns the disburse period of this pay head.
	 *
	 * @return the disburse period of this pay head
	 */
	public int getDisbursePeriod();

	/**
	 * Sets the disburse period of this pay head.
	 *
	 * @param disbursePeriod the disburse period of this pay head
	 */
	public void setDisbursePeriod(int disbursePeriod);

	/**
	 * Returns the from date of this pay head.
	 *
	 * @return the from date of this pay head
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this pay head.
	 *
	 * @param fromDate the from date of this pay head
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the name of this pay head.
	 *
	 * @return the name of this pay head
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this pay head.
	 *
	 * @param name the name of this pay head
	 */
	public void setName(String name);

	/**
	 * Returns the non taxable of this pay head.
	 *
	 * @return the non taxable of this pay head
	 */
	public boolean getNonTaxable();

	/**
	 * Returns <code>true</code> if this pay head is non taxable.
	 *
	 * @return <code>true</code> if this pay head is non taxable; <code>false</code> otherwise
	 */
	public boolean isNonTaxable();

	/**
	 * Sets whether this pay head is non taxable.
	 *
	 * @param nonTaxable the non taxable of this pay head
	 */
	public void setNonTaxable(boolean nonTaxable);

	/**
	 * Returns the to date of this pay head.
	 *
	 * @return the to date of this pay head
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this pay head.
	 *
	 * @param toDate the to date of this pay head
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the head type ID of this pay head.
	 *
	 * @return the head type ID of this pay head
	 */
	public long getHeadTypeId();

	/**
	 * Sets the head type ID of this pay head.
	 *
	 * @param headTypeId the head type ID of this pay head
	 */
	public void setHeadTypeId(long headTypeId);

	/**
	 * Returns the deleted of this pay head.
	 *
	 * @return the deleted of this pay head
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this pay head is deleted.
	 *
	 * @return <code>true</code> if this pay head is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this pay head is deleted.
	 *
	 * @param deleted the deleted of this pay head
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this pay head.
	 *
	 * @return the status of this pay head
	 */
	public int getStatus();

	/**
	 * Sets the status of this pay head.
	 *
	 * @param status the status of this pay head
	 */
	public void setStatus(int status);

}