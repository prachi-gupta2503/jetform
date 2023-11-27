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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.JoiningProcessServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JoiningProcessSoap implements Serializable {

	public static JoiningProcessSoap toSoapModel(JoiningProcess model) {
		JoiningProcessSoap soapModel = new JoiningProcessSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJoiningProcessId(model.getJoiningProcessId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setReason(model.getReason());
		soapModel.setPersonalNo(model.getPersonalNo());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());
		soapModel.setNotingContent(model.getNotingContent());
		soapModel.setNotingSubmittedDate(model.getNotingSubmittedDate());
		soapModel.setNotingApprovedDate(model.getNotingApprovedDate());
		soapModel.setProcessStatus(model.getProcessStatus());
		soapModel.setProcessCompletedDate(model.getProcessCompletedDate());
		soapModel.setReviewDate(model.getReviewDate());
		soapModel.setReviewerUserId(model.getReviewerUserId());
		soapModel.setApproveDate(model.getApproveDate());
		soapModel.setApproverUserId(model.getApproverUserId());

		return soapModel;
	}

	public static JoiningProcessSoap[] toSoapModels(JoiningProcess[] models) {
		JoiningProcessSoap[] soapModels = new JoiningProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JoiningProcessSoap[][] toSoapModels(
		JoiningProcess[][] models) {

		JoiningProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new JoiningProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JoiningProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JoiningProcessSoap[] toSoapModels(
		List<JoiningProcess> models) {

		List<JoiningProcessSoap> soapModels = new ArrayList<JoiningProcessSoap>(
			models.size());

		for (JoiningProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JoiningProcessSoap[soapModels.size()]);
	}

	public JoiningProcessSoap() {
	}

	public long getPrimaryKey() {
		return _joiningProcessId;
	}

	public void setPrimaryKey(long pk) {
		setJoiningProcessId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJoiningProcessId() {
		return _joiningProcessId;
	}

	public void setJoiningProcessId(long joiningProcessId) {
		_joiningProcessId = joiningProcessId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public long getPersonalNo() {
		return _personalNo;
	}

	public void setPersonalNo(long personalNo) {
		_personalNo = personalNo;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public long getProcessFileId() {
		return _processFileId;
	}

	public void setProcessFileId(long processFileId) {
		_processFileId = processFileId;
	}

	public long getProcessFileNo() {
		return _processFileNo;
	}

	public void setProcessFileNo(long processFileNo) {
		_processFileNo = processFileNo;
	}

	public String getNotingContent() {
		return _notingContent;
	}

	public void setNotingContent(String notingContent) {
		_notingContent = notingContent;
	}

	public Date getNotingSubmittedDate() {
		return _notingSubmittedDate;
	}

	public void setNotingSubmittedDate(Date notingSubmittedDate) {
		_notingSubmittedDate = notingSubmittedDate;
	}

	public Date getNotingApprovedDate() {
		return _notingApprovedDate;
	}

	public void setNotingApprovedDate(Date notingApprovedDate) {
		_notingApprovedDate = notingApprovedDate;
	}

	public int getProcessStatus() {
		return _processStatus;
	}

	public void setProcessStatus(int processStatus) {
		_processStatus = processStatus;
	}

	public Date getProcessCompletedDate() {
		return _processCompletedDate;
	}

	public void setProcessCompletedDate(Date processCompletedDate) {
		_processCompletedDate = processCompletedDate;
	}

	public Date getReviewDate() {
		return _reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		_reviewDate = reviewDate;
	}

	public long getReviewerUserId() {
		return _reviewerUserId;
	}

	public void setReviewerUserId(long reviewerUserId) {
		_reviewerUserId = reviewerUserId;
	}

	public Date getApproveDate() {
		return _approveDate;
	}

	public void setApproveDate(Date approveDate) {
		_approveDate = approveDate;
	}

	public long getApproverUserId() {
		return _approverUserId;
	}

	public void setApproverUserId(long approverUserId) {
		_approverUserId = approverUserId;
	}

	private String _uuid;
	private long _joiningProcessId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _reason;
	private long _personalNo;
	private long _unitId;
	private long _processFileId;
	private long _processFileNo;
	private String _notingContent;
	private Date _notingSubmittedDate;
	private Date _notingApprovedDate;
	private int _processStatus;
	private Date _processCompletedDate;
	private Date _reviewDate;
	private long _reviewerUserId;
	private Date _approveDate;
	private long _approverUserId;

}