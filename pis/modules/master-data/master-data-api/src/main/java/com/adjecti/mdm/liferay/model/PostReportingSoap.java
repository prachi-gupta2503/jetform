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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PostReportingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PostReportingSoap implements Serializable {

	public static PostReportingSoap toSoapModel(PostReporting model) {
		PostReportingSoap soapModel = new PostReportingSoap();

		soapModel.setPostReportingId(model.getPostReportingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setReporteePostId(model.getReporteePostId());
		soapModel.setReporterPostId(model.getReporterPostId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PostReportingSoap[] toSoapModels(PostReporting[] models) {
		PostReportingSoap[] soapModels = new PostReportingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostReportingSoap[][] toSoapModels(PostReporting[][] models) {
		PostReportingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostReportingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostReportingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostReportingSoap[] toSoapModels(List<PostReporting> models) {
		List<PostReportingSoap> soapModels = new ArrayList<PostReportingSoap>(
			models.size());

		for (PostReporting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostReportingSoap[soapModels.size()]);
	}

	public PostReportingSoap() {
	}

	public long getPrimaryKey() {
		return _postReportingId;
	}

	public void setPrimaryKey(long pk) {
		setPostReportingId(pk);
	}

	public long getPostReportingId() {
		return _postReportingId;
	}

	public void setPostReportingId(long postReportingId) {
		_postReportingId = postReportingId;
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

	public long getReporteePostId() {
		return _reporteePostId;
	}

	public void setReporteePostId(long reporteePostId) {
		_reporteePostId = reporteePostId;
	}

	public long getReporterPostId() {
		return _reporterPostId;
	}

	public void setReporterPostId(long reporterPostId) {
		_reporterPostId = reporterPostId;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _postReportingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _reporteePostId;
	private long _reporterPostId;
	private boolean _deleted;
	private int _status;

}