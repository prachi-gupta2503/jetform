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
 * The base model interface for the QualificationGrade service. Represents a row in the &quot;mdm_QualificationGrade&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.QualificationGradeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.QualificationGradeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationGrade
 * @generated
 */
@ProviderType
public interface QualificationGradeModel
	extends BaseModel<QualificationGrade>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a qualification grade model instance should use the {@link QualificationGrade} interface instead.
	 */

	/**
	 * Returns the primary key of this qualification grade.
	 *
	 * @return the primary key of this qualification grade
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this qualification grade.
	 *
	 * @param primaryKey the primary key of this qualification grade
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the qualification grade ID of this qualification grade.
	 *
	 * @return the qualification grade ID of this qualification grade
	 */
	public long getQualificationGradeId();

	/**
	 * Sets the qualification grade ID of this qualification grade.
	 *
	 * @param qualificationGradeId the qualification grade ID of this qualification grade
	 */
	public void setQualificationGradeId(long qualificationGradeId);

	/**
	 * Returns the group ID of this qualification grade.
	 *
	 * @return the group ID of this qualification grade
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this qualification grade.
	 *
	 * @param groupId the group ID of this qualification grade
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this qualification grade.
	 *
	 * @return the company ID of this qualification grade
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this qualification grade.
	 *
	 * @param companyId the company ID of this qualification grade
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this qualification grade.
	 *
	 * @return the user ID of this qualification grade
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this qualification grade.
	 *
	 * @param userId the user ID of this qualification grade
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this qualification grade.
	 *
	 * @return the user uuid of this qualification grade
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this qualification grade.
	 *
	 * @param userUuid the user uuid of this qualification grade
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this qualification grade.
	 *
	 * @return the user name of this qualification grade
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this qualification grade.
	 *
	 * @param userName the user name of this qualification grade
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this qualification grade.
	 *
	 * @return the create date of this qualification grade
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this qualification grade.
	 *
	 * @param createDate the create date of this qualification grade
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this qualification grade.
	 *
	 * @return the modified date of this qualification grade
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this qualification grade.
	 *
	 * @param modifiedDate the modified date of this qualification grade
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this qualification grade.
	 *
	 * @return the code of this qualification grade
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this qualification grade.
	 *
	 * @param code the code of this qualification grade
	 */
	public void setCode(String code);

	/**
	 * Returns the description of this qualification grade.
	 *
	 * @return the description of this qualification grade
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this qualification grade.
	 *
	 * @param description the description of this qualification grade
	 */
	public void setDescription(String description);

	/**
	 * Returns the name of this qualification grade.
	 *
	 * @return the name of this qualification grade
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this qualification grade.
	 *
	 * @param name the name of this qualification grade
	 */
	public void setName(String name);

	/**
	 * Returns the deleted of this qualification grade.
	 *
	 * @return the deleted of this qualification grade
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this qualification grade is deleted.
	 *
	 * @return <code>true</code> if this qualification grade is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this qualification grade is deleted.
	 *
	 * @param deleted the deleted of this qualification grade
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this qualification grade.
	 *
	 * @return the status of this qualification grade
	 */
	public int getStatus();

	/**
	 * Sets the status of this qualification grade.
	 *
	 * @param status the status of this qualification grade
	 */
	public void setStatus(int status);

}