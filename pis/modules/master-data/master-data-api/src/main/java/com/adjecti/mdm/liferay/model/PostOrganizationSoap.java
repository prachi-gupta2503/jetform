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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PostOrganizationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PostOrganizationSoap implements Serializable {

	public static PostOrganizationSoap toSoapModel(PostOrganization model) {
		PostOrganizationSoap soapModel = new PostOrganizationSoap();

		soapModel.setPostOrganizationId(model.getPostOrganizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPostId(model.getPostId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setPostBox(model.isPostBox());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PostOrganizationSoap[] toSoapModels(
		PostOrganization[] models) {

		PostOrganizationSoap[] soapModels =
			new PostOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostOrganizationSoap[][] toSoapModels(
		PostOrganization[][] models) {

		PostOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PostOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostOrganizationSoap[] toSoapModels(
		List<PostOrganization> models) {

		List<PostOrganizationSoap> soapModels =
			new ArrayList<PostOrganizationSoap>(models.size());

		for (PostOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostOrganizationSoap[soapModels.size()]);
	}

	public PostOrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _postOrganizationId;
	}

	public void setPrimaryKey(long pk) {
		setPostOrganizationId(pk);
	}

	public long getPostOrganizationId() {
		return _postOrganizationId;
	}

	public void setPostOrganizationId(long postOrganizationId) {
		_postOrganizationId = postOrganizationId;
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

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public boolean getPostBox() {
		return _postBox;
	}

	public boolean isPostBox() {
		return _postBox;
	}

	public void setPostBox(boolean postBox) {
		_postBox = postBox;
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

	private long _postOrganizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _postId;
	private long _organizationId;
	private boolean _postBox;
	private boolean _deleted;
	private int _status;

}