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
 * The base model interface for the EmployeePromotion service. Represents a row in the &quot;pis_EmployeePromotion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotion
 * @generated
 */
@ProviderType
public interface EmployeePromotionModel
	extends BaseModel<EmployeePromotion>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee promotion model instance should use the {@link EmployeePromotion} interface instead.
	 */

	/**
	 * Returns the primary key of this employee promotion.
	 *
	 * @return the primary key of this employee promotion
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee promotion.
	 *
	 * @param primaryKey the primary key of this employee promotion
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee promotion ID of this employee promotion.
	 *
	 * @return the employee promotion ID of this employee promotion
	 */
	public long getEmployeePromotionId();

	/**
	 * Sets the employee promotion ID of this employee promotion.
	 *
	 * @param employeePromotionId the employee promotion ID of this employee promotion
	 */
	public void setEmployeePromotionId(long employeePromotionId);

	/**
	 * Returns the group ID of this employee promotion.
	 *
	 * @return the group ID of this employee promotion
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee promotion.
	 *
	 * @param groupId the group ID of this employee promotion
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee promotion.
	 *
	 * @return the company ID of this employee promotion
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee promotion.
	 *
	 * @param companyId the company ID of this employee promotion
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee promotion.
	 *
	 * @return the user ID of this employee promotion
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee promotion.
	 *
	 * @param userId the user ID of this employee promotion
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee promotion.
	 *
	 * @return the user uuid of this employee promotion
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee promotion.
	 *
	 * @param userUuid the user uuid of this employee promotion
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee promotion.
	 *
	 * @return the user name of this employee promotion
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee promotion.
	 *
	 * @param userName the user name of this employee promotion
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee promotion.
	 *
	 * @return the create date of this employee promotion
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee promotion.
	 *
	 * @param createDate the create date of this employee promotion
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee promotion.
	 *
	 * @return the modified date of this employee promotion
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee promotion.
	 *
	 * @param modifiedDate the modified date of this employee promotion
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this employee promotion.
	 *
	 * @return the active of this employee promotion
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this employee promotion is active.
	 *
	 * @return <code>true</code> if this employee promotion is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this employee promotion is active.
	 *
	 * @param active the active of this employee promotion
	 */
	public void setActive(boolean active);

	/**
	 * Returns the promotion date of this employee promotion.
	 *
	 * @return the promotion date of this employee promotion
	 */
	public Date getPromotionDate();

	/**
	 * Sets the promotion date of this employee promotion.
	 *
	 * @param promotionDate the promotion date of this employee promotion
	 */
	public void setPromotionDate(Date promotionDate);

	/**
	 * Returns the designation ID of this employee promotion.
	 *
	 * @return the designation ID of this employee promotion
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this employee promotion.
	 *
	 * @param designationId the designation ID of this employee promotion
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the employee ID of this employee promotion.
	 *
	 * @return the employee ID of this employee promotion
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee promotion.
	 *
	 * @param employeeId the employee ID of this employee promotion
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the grade ID of this employee promotion.
	 *
	 * @return the grade ID of this employee promotion
	 */
	public long getGradeId();

	/**
	 * Sets the grade ID of this employee promotion.
	 *
	 * @param gradeId the grade ID of this employee promotion
	 */
	public void setGradeId(long gradeId);

	/**
	 * Returns the grade mode ID of this employee promotion.
	 *
	 * @return the grade mode ID of this employee promotion
	 */
	public long getGradeModeId();

	/**
	 * Sets the grade mode ID of this employee promotion.
	 *
	 * @param gradeModeId the grade mode ID of this employee promotion
	 */
	public void setGradeModeId(long gradeModeId);

	/**
	 * Returns the promotion letter ID of this employee promotion.
	 *
	 * @return the promotion letter ID of this employee promotion
	 */
	public long getPromotionLetterId();

	/**
	 * Sets the promotion letter ID of this employee promotion.
	 *
	 * @param promotionLetterId the promotion letter ID of this employee promotion
	 */
	public void setPromotionLetterId(long promotionLetterId);

	/**
	 * Returns the organization ID of this employee promotion.
	 *
	 * @return the organization ID of this employee promotion
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this employee promotion.
	 *
	 * @param organizationId the organization ID of this employee promotion
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the personal no of this employee promotion.
	 *
	 * @return the personal no of this employee promotion
	 */
	public long getPersonalNo();

	/**
	 * Sets the personal no of this employee promotion.
	 *
	 * @param personalNo the personal no of this employee promotion
	 */
	public void setPersonalNo(long personalNo);

	/**
	 * Returns the status of this employee promotion.
	 *
	 * @return the status of this employee promotion
	 */
	public int getStatus();

	/**
	 * Sets the status of this employee promotion.
	 *
	 * @param status the status of this employee promotion
	 */
	public void setStatus(int status);

}