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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.mdm.liferay.service.http.PostDelegationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PostDelegationSoap implements Serializable {

	public static PostDelegationSoap toSoapModel(PostDelegation model) {
		PostDelegationSoap soapModel = new PostDelegationSoap();

		soapModel.setPostDelegationId(model.getPostDelegationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDelegationType(model.getDelegationType());
		soapModel.setDelegatedPostId(model.getDelegatedPostId());
		soapModel.setPostId(model.getPostId());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PostDelegationSoap[] toSoapModels(PostDelegation[] models) {
		PostDelegationSoap[] soapModels = new PostDelegationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostDelegationSoap[][] toSoapModels(
		PostDelegation[][] models) {

		PostDelegationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PostDelegationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostDelegationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostDelegationSoap[] toSoapModels(
		List<PostDelegation> models) {

		List<PostDelegationSoap> soapModels = new ArrayList<PostDelegationSoap>(
			models.size());

		for (PostDelegation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostDelegationSoap[soapModels.size()]);
	}

	public PostDelegationSoap() {
	}

	public long getPrimaryKey() {
		return _postDelegationId;
	}

	public void setPrimaryKey(long pk) {
		setPostDelegationId(pk);
	}

	public long getPostDelegationId() {
		return _postDelegationId;
	}

	public void setPostDelegationId(long postDelegationId) {
		_postDelegationId = postDelegationId;
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

	public String getDelegationType() {
		return _delegationType;
	}

	public void setDelegationType(String delegationType) {
		_delegationType = delegationType;
	}

	public long getDelegatedPostId() {
		return _delegatedPostId;
	}

	public void setDelegatedPostId(long delegatedPostId) {
		_delegatedPostId = delegatedPostId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
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

	private long _postDelegationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _delegationType;
	private long _delegatedPostId;
	private long _postId;
	private boolean _deleted;
	private int _status;

}