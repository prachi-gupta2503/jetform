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
 * The base model interface for the EmployeeConfirmation service. Represents a row in the &quot;pis_EmployeeConfirmation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmation
 * @generated
 */
@ProviderType
public interface EmployeeConfirmationModel
	extends BaseModel<EmployeeConfirmation>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee confirmation model instance should use the {@link EmployeeConfirmation} interface instead.
	 */

	/**
	 * Returns the primary key of this employee confirmation.
	 *
	 * @return the primary key of this employee confirmation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee confirmation.
	 *
	 * @param primaryKey the primary key of this employee confirmation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee confirmation ID of this employee confirmation.
	 *
	 * @return the employee confirmation ID of this employee confirmation
	 */
	public long getEmployeeConfirmationId();

	/**
	 * Sets the employee confirmation ID of this employee confirmation.
	 *
	 * @param employeeConfirmationId the employee confirmation ID of this employee confirmation
	 */
	public void setEmployeeConfirmationId(long employeeConfirmationId);

	/**
	 * Returns the group ID of this employee confirmation.
	 *
	 * @return the group ID of this employee confirmation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee confirmation.
	 *
	 * @param groupId the group ID of this employee confirmation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee confirmation.
	 *
	 * @return the company ID of this employee confirmation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee confirmation.
	 *
	 * @param companyId the company ID of this employee confirmation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee confirmation.
	 *
	 * @return the user ID of this employee confirmation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee confirmation.
	 *
	 * @param userId the user ID of this employee confirmation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee confirmation.
	 *
	 * @return the user uuid of this employee confirmation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee confirmation.
	 *
	 * @param userUuid the user uuid of this employee confirmation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee confirmation.
	 *
	 * @return the user name of this employee confirmation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee confirmation.
	 *
	 * @param userName the user name of this employee confirmation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee confirmation.
	 *
	 * @return the create date of this employee confirmation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee confirmation.
	 *
	 * @param createDate the create date of this employee confirmation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee confirmation.
	 *
	 * @return the modified date of this employee confirmation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee confirmation.
	 *
	 * @param modifiedDate the modified date of this employee confirmation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this employee confirmation.
	 *
	 * @return the active of this employee confirmation
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this employee confirmation is active.
	 *
	 * @return <code>true</code> if this employee confirmation is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this employee confirmation is active.
	 *
	 * @param active the active of this employee confirmation
	 */
	public void setActive(boolean active);

	/**
	 * Returns the confirmation date of this employee confirmation.
	 *
	 * @return the confirmation date of this employee confirmation
	 */
	public Date getConfirmationDate();

	/**
	 * Sets the confirmation date of this employee confirmation.
	 *
	 * @param confirmationDate the confirmation date of this employee confirmation
	 */
	public void setConfirmationDate(Date confirmationDate);

	/**
	 * Returns the confirmation letter ID of this employee confirmation.
	 *
	 * @return the confirmation letter ID of this employee confirmation
	 */
	public long getConfirmationLetterId();

	/**
	 * Sets the confirmation letter ID of this employee confirmation.
	 *
	 * @param confirmationLetterId the confirmation letter ID of this employee confirmation
	 */
	public void setConfirmationLetterId(long confirmationLetterId);

	/**
	 * Returns the designation ID of this employee confirmation.
	 *
	 * @return the designation ID of this employee confirmation
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this employee confirmation.
	 *
	 * @param designationId the designation ID of this employee confirmation
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the grade ID of this employee confirmation.
	 *
	 * @return the grade ID of this employee confirmation
	 */
	public long getGradeId();

	/**
	 * Sets the grade ID of this employee confirmation.
	 *
	 * @param gradeId the grade ID of this employee confirmation
	 */
	public void setGradeId(long gradeId);

	/**
	 * Returns the grade mode ID of this employee confirmation.
	 *
	 * @return the grade mode ID of this employee confirmation
	 */
	public long getGradeModeId();

	/**
	 * Sets the grade mode ID of this employee confirmation.
	 *
	 * @param gradeModeId the grade mode ID of this employee confirmation
	 */
	public void setGradeModeId(long gradeModeId);

	/**
	 * Returns the joining ID of this employee confirmation.
	 *
	 * @return the joining ID of this employee confirmation
	 */
	public long getJoiningId();

	/**
	 * Sets the joining ID of this employee confirmation.
	 *
	 * @param joiningId the joining ID of this employee confirmation
	 */
	public void setJoiningId(long joiningId);

	/**
	 * Returns the promotion ID of this employee confirmation.
	 *
	 * @return the promotion ID of this employee confirmation
	 */
	public long getPromotionId();

	/**
	 * Sets the promotion ID of this employee confirmation.
	 *
	 * @param promotionId the promotion ID of this employee confirmation
	 */
	public void setPromotionId(long promotionId);

	/**
	 * Returns the organization ID of this employee confirmation.
	 *
	 * @return the organization ID of this employee confirmation
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this employee confirmation.
	 *
	 * @param organizationId the organization ID of this employee confirmation
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the confirmation post ID of this employee confirmation.
	 *
	 * @return the confirmation post ID of this employee confirmation
	 */
	public long getConfirmationPostId();

	/**
	 * Sets the confirmation post ID of this employee confirmation.
	 *
	 * @param confirmationPostId the confirmation post ID of this employee confirmation
	 */
	public void setConfirmationPostId(long confirmationPostId);

	/**
	 * Returns the status of this employee confirmation.
	 *
	 * @return the status of this employee confirmation
	 */
	public int getStatus();

	/**
	 * Sets the status of this employee confirmation.
	 *
	 * @param status the status of this employee confirmation
	 */
	public void setStatus(int status);

	/**
	 * Returns the employee ID of this employee confirmation.
	 *
	 * @return the employee ID of this employee confirmation
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee confirmation.
	 *
	 * @param employeeId the employee ID of this employee confirmation
	 */
	public void setEmployeeId(long employeeId);

}