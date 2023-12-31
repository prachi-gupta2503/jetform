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
 * The base model interface for the TrainingSubject service. Represents a row in the &quot;mdm_TrainingSubject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.mdm.liferay.model.impl.TrainingSubjectModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.mdm.liferay.model.impl.TrainingSubjectImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSubject
 * @generated
 */
@ProviderType
public interface TrainingSubjectModel
	extends BaseModel<TrainingSubject>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a training subject model instance should use the {@link TrainingSubject} interface instead.
	 */

	/**
	 * Returns the primary key of this training subject.
	 *
	 * @return the primary key of this training subject
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this training subject.
	 *
	 * @param primaryKey the primary key of this training subject
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the training subject ID of this training subject.
	 *
	 * @return the training subject ID of this training subject
	 */
	public long getTrainingSubjectId();

	/**
	 * Sets the training subject ID of this training subject.
	 *
	 * @param trainingSubjectId the training subject ID of this training subject
	 */
	public void setTrainingSubjectId(long trainingSubjectId);

	/**
	 * Returns the group ID of this training subject.
	 *
	 * @return the group ID of this training subject
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this training subject.
	 *
	 * @param groupId the group ID of this training subject
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this training subject.
	 *
	 * @return the company ID of this training subject
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this training subject.
	 *
	 * @param companyId the company ID of this training subject
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this training subject.
	 *
	 * @return the user ID of this training subject
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this training subject.
	 *
	 * @param userId the user ID of this training subject
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this training subject.
	 *
	 * @return the user uuid of this training subject
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this training subject.
	 *
	 * @param userUuid the user uuid of this training subject
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this training subject.
	 *
	 * @return the user name of this training subject
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this training subject.
	 *
	 * @param userName the user name of this training subject
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this training subject.
	 *
	 * @return the create date of this training subject
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this training subject.
	 *
	 * @param createDate the create date of this training subject
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this training subject.
	 *
	 * @return the modified date of this training subject
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this training subject.
	 *
	 * @param modifiedDate the modified date of this training subject
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this training subject.
	 *
	 * @return the description of this training subject
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this training subject.
	 *
	 * @param description the description of this training subject
	 */
	public void setDescription(String description);

	/**
	 * Returns the name of this training subject.
	 *
	 * @return the name of this training subject
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this training subject.
	 *
	 * @param name the name of this training subject
	 */
	public void setName(String name);

	/**
	 * Returns the code of this training subject.
	 *
	 * @return the code of this training subject
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this training subject.
	 *
	 * @param code the code of this training subject
	 */
	public void setCode(String code);

	/**
	 * Returns the deleted of this training subject.
	 *
	 * @return the deleted of this training subject
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this training subject is deleted.
	 *
	 * @return <code>true</code> if this training subject is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this training subject is deleted.
	 *
	 * @param deleted the deleted of this training subject
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the status of this training subject.
	 *
	 * @return the status of this training subject
	 */
	public int getStatus();

	/**
	 * Sets the status of this training subject.
	 *
	 * @param status the status of this training subject
	 */
	public void setStatus(int status);

}