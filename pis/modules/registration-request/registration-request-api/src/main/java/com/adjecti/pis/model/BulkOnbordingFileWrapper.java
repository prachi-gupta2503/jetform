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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BulkOnbordingFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFile
 * @generated
 */
public class BulkOnbordingFileWrapper
	extends BaseModelWrapper<BulkOnbordingFile>
	implements BulkOnbordingFile, ModelWrapper<BulkOnbordingFile> {

	public BulkOnbordingFileWrapper(BulkOnbordingFile bulkOnbordingFile) {
		super(bulkOnbordingFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bulkOnbordingFileId", getBulkOnbordingFileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileName", getFileName());
		attributes.put("remarks", getRemarks());
		attributes.put("title", getTitle());
		attributes.put("totalRecords", getTotalRecords());
		attributes.put("unitId", getUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bulkOnbordingFileId = (Long)attributes.get("bulkOnbordingFileId");

		if (bulkOnbordingFileId != null) {
			setBulkOnbordingFileId(bulkOnbordingFileId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long totalRecords = (Long)attributes.get("totalRecords");

		if (totalRecords != null) {
			setTotalRecords(totalRecords);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}
	}

	/**
	 * Returns the bulk onbording file ID of this bulk onbording file.
	 *
	 * @return the bulk onbording file ID of this bulk onbording file
	 */
	@Override
	public long getBulkOnbordingFileId() {
		return model.getBulkOnbordingFileId();
	}

	/**
	 * Returns the company ID of this bulk onbording file.
	 *
	 * @return the company ID of this bulk onbording file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this bulk onbording file.
	 *
	 * @return the create date of this bulk onbording file
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file entry ID of this bulk onbording file.
	 *
	 * @return the file entry ID of this bulk onbording file
	 */
	@Override
	public Long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the file name of this bulk onbording file.
	 *
	 * @return the file name of this bulk onbording file
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	/**
	 * Returns the group ID of this bulk onbording file.
	 *
	 * @return the group ID of this bulk onbording file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this bulk onbording file.
	 *
	 * @return the modified date of this bulk onbording file
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this bulk onbording file.
	 *
	 * @return the primary key of this bulk onbording file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this bulk onbording file.
	 *
	 * @return the remarks of this bulk onbording file
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the title of this bulk onbording file.
	 *
	 * @return the title of this bulk onbording file
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the total records of this bulk onbording file.
	 *
	 * @return the total records of this bulk onbording file
	 */
	@Override
	public Long getTotalRecords() {
		return model.getTotalRecords();
	}

	/**
	 * Returns the unit ID of this bulk onbording file.
	 *
	 * @return the unit ID of this bulk onbording file
	 */
	@Override
	public Long getUnitId() {
		return model.getUnitId();
	}

	/**
	 * Returns the user ID of this bulk onbording file.
	 *
	 * @return the user ID of this bulk onbording file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this bulk onbording file.
	 *
	 * @return the user name of this bulk onbording file
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this bulk onbording file.
	 *
	 * @return the user uuid of this bulk onbording file
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this bulk onbording file.
	 *
	 * @return the uuid of this bulk onbording file
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bulk onbording file ID of this bulk onbording file.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID of this bulk onbording file
	 */
	@Override
	public void setBulkOnbordingFileId(long bulkOnbordingFileId) {
		model.setBulkOnbordingFileId(bulkOnbordingFileId);
	}

	/**
	 * Sets the company ID of this bulk onbording file.
	 *
	 * @param companyId the company ID of this bulk onbording file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this bulk onbording file.
	 *
	 * @param createDate the create date of this bulk onbording file
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file entry ID of this bulk onbording file.
	 *
	 * @param fileEntryId the file entry ID of this bulk onbording file
	 */
	@Override
	public void setFileEntryId(Long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the file name of this bulk onbording file.
	 *
	 * @param fileName the file name of this bulk onbording file
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the group ID of this bulk onbording file.
	 *
	 * @param groupId the group ID of this bulk onbording file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this bulk onbording file.
	 *
	 * @param modifiedDate the modified date of this bulk onbording file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this bulk onbording file.
	 *
	 * @param primaryKey the primary key of this bulk onbording file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this bulk onbording file.
	 *
	 * @param remarks the remarks of this bulk onbording file
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the title of this bulk onbording file.
	 *
	 * @param title the title of this bulk onbording file
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the total records of this bulk onbording file.
	 *
	 * @param totalRecords the total records of this bulk onbording file
	 */
	@Override
	public void setTotalRecords(Long totalRecords) {
		model.setTotalRecords(totalRecords);
	}

	/**
	 * Sets the unit ID of this bulk onbording file.
	 *
	 * @param unitId the unit ID of this bulk onbording file
	 */
	@Override
	public void setUnitId(Long unitId) {
		model.setUnitId(unitId);
	}

	/**
	 * Sets the user ID of this bulk onbording file.
	 *
	 * @param userId the user ID of this bulk onbording file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this bulk onbording file.
	 *
	 * @param userName the user name of this bulk onbording file
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this bulk onbording file.
	 *
	 * @param userUuid the user uuid of this bulk onbording file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this bulk onbording file.
	 *
	 * @param uuid the uuid of this bulk onbording file
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BulkOnbordingFileWrapper wrap(
		BulkOnbordingFile bulkOnbordingFile) {

		return new BulkOnbordingFileWrapper(bulkOnbordingFile);
	}

}