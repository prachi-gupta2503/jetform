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

package com.adjecti.pis.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BulkOnbordingFile service. Represents a row in the &quot;OFB_BulkOnbordingFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.adjecti.pis.model.impl.BulkOnbordingFileModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.adjecti.pis.model.impl.BulkOnbordingFileImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFile
 * @generated
 */
@ProviderType
public interface BulkOnbordingFileModel
	extends BaseModel<BulkOnbordingFile>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bulk onbording file model instance should use the {@link BulkOnbordingFile} interface instead.
	 */

	/**
	 * Returns the primary key of this bulk onbording file.
	 *
	 * @return the primary key of this bulk onbording file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bulk onbording file.
	 *
	 * @param primaryKey the primary key of this bulk onbording file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this bulk onbording file.
	 *
	 * @return the uuid of this bulk onbording file
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this bulk onbording file.
	 *
	 * @param uuid the uuid of this bulk onbording file
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the bulk onbording file ID of this bulk onbording file.
	 *
	 * @return the bulk onbording file ID of this bulk onbording file
	 */
	public long getBulkOnbordingFileId();

	/**
	 * Sets the bulk onbording file ID of this bulk onbording file.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID of this bulk onbording file
	 */
	public void setBulkOnbordingFileId(long bulkOnbordingFileId);

	/**
	 * Returns the group ID of this bulk onbording file.
	 *
	 * @return the group ID of this bulk onbording file
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this bulk onbording file.
	 *
	 * @param groupId the group ID of this bulk onbording file
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this bulk onbording file.
	 *
	 * @return the company ID of this bulk onbording file
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this bulk onbording file.
	 *
	 * @param companyId the company ID of this bulk onbording file
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this bulk onbording file.
	 *
	 * @return the user ID of this bulk onbording file
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this bulk onbording file.
	 *
	 * @param userId the user ID of this bulk onbording file
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this bulk onbording file.
	 *
	 * @return the user uuid of this bulk onbording file
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this bulk onbording file.
	 *
	 * @param userUuid the user uuid of this bulk onbording file
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this bulk onbording file.
	 *
	 * @return the user name of this bulk onbording file
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this bulk onbording file.
	 *
	 * @param userName the user name of this bulk onbording file
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this bulk onbording file.
	 *
	 * @return the create date of this bulk onbording file
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this bulk onbording file.
	 *
	 * @param createDate the create date of this bulk onbording file
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this bulk onbording file.
	 *
	 * @return the modified date of this bulk onbording file
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this bulk onbording file.
	 *
	 * @param modifiedDate the modified date of this bulk onbording file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the file entry ID of this bulk onbording file.
	 *
	 * @return the file entry ID of this bulk onbording file
	 */
	public Long getFileEntryId();

	/**
	 * Sets the file entry ID of this bulk onbording file.
	 *
	 * @param fileEntryId the file entry ID of this bulk onbording file
	 */
	public void setFileEntryId(Long fileEntryId);

	/**
	 * Returns the file name of this bulk onbording file.
	 *
	 * @return the file name of this bulk onbording file
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this bulk onbording file.
	 *
	 * @param fileName the file name of this bulk onbording file
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the remarks of this bulk onbording file.
	 *
	 * @return the remarks of this bulk onbording file
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this bulk onbording file.
	 *
	 * @param remarks the remarks of this bulk onbording file
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the title of this bulk onbording file.
	 *
	 * @return the title of this bulk onbording file
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this bulk onbording file.
	 *
	 * @param title the title of this bulk onbording file
	 */
	public void setTitle(String title);

	/**
	 * Returns the total records of this bulk onbording file.
	 *
	 * @return the total records of this bulk onbording file
	 */
	public Long getTotalRecords();

	/**
	 * Sets the total records of this bulk onbording file.
	 *
	 * @param totalRecords the total records of this bulk onbording file
	 */
	public void setTotalRecords(Long totalRecords);

	/**
	 * Returns the unit ID of this bulk onbording file.
	 *
	 * @return the unit ID of this bulk onbording file
	 */
	public Long getUnitId();

	/**
	 * Sets the unit ID of this bulk onbording file.
	 *
	 * @param unitId the unit ID of this bulk onbording file
	 */
	public void setUnitId(Long unitId);

}