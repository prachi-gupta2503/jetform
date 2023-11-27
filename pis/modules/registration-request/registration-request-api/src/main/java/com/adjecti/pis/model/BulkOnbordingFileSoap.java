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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.service.http.BulkOnbordingFileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BulkOnbordingFileSoap implements Serializable {

	public static BulkOnbordingFileSoap toSoapModel(BulkOnbordingFile model) {
		BulkOnbordingFileSoap soapModel = new BulkOnbordingFileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBulkOnbordingFileId(model.getBulkOnbordingFileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileName(model.getFileName());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setTitle(model.getTitle());
		soapModel.setTotalRecords(model.getTotalRecords());
		soapModel.setUnitId(model.getUnitId());

		return soapModel;
	}

	public static BulkOnbordingFileSoap[] toSoapModels(
		BulkOnbordingFile[] models) {

		BulkOnbordingFileSoap[] soapModels =
			new BulkOnbordingFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BulkOnbordingFileSoap[][] toSoapModels(
		BulkOnbordingFile[][] models) {

		BulkOnbordingFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BulkOnbordingFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BulkOnbordingFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BulkOnbordingFileSoap[] toSoapModels(
		List<BulkOnbordingFile> models) {

		List<BulkOnbordingFileSoap> soapModels =
			new ArrayList<BulkOnbordingFileSoap>(models.size());

		for (BulkOnbordingFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BulkOnbordingFileSoap[soapModels.size()]);
	}

	public BulkOnbordingFileSoap() {
	}

	public long getPrimaryKey() {
		return _bulkOnbordingFileId;
	}

	public void setPrimaryKey(long pk) {
		setBulkOnbordingFileId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBulkOnbordingFileId() {
		return _bulkOnbordingFileId;
	}

	public void setBulkOnbordingFileId(long bulkOnbordingFileId) {
		_bulkOnbordingFileId = bulkOnbordingFileId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(Long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Long getTotalRecords() {
		return _totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		_totalRecords = totalRecords;
	}

	public Long getUnitId() {
		return _unitId;
	}

	public void setUnitId(Long unitId) {
		_unitId = unitId;
	}

	private String _uuid;
	private long _bulkOnbordingFileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Long _fileEntryId;
	private String _fileName;
	private String _remarks;
	private String _title;
	private Long _totalRecords;
	private Long _unitId;

}