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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.pis.liferay.service.http.SampleProcessRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SampleProcessRequestSoap implements Serializable {

	public static SampleProcessRequestSoap toSoapModel(
		SampleProcessRequest model) {

		SampleProcessRequestSoap soapModel = new SampleProcessRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSampleProcessRequestId(model.getSampleProcessRequestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDeputationOrganization(model.getDeputationOrganization());
		soapModel.setDeputationAddress(model.getDeputationAddress());
		soapModel.setDeputationCity(model.getDeputationCity());
		soapModel.setDeputationState(model.getDeputationState());
		soapModel.setProcessFileId(model.getProcessFileId());
		soapModel.setProcessFileNo(model.getProcessFileNo());
		soapModel.setDoPart1Content(model.getDoPart1Content());
		soapModel.setDoPart1SumittedDate(model.getDoPart1SumittedDate());
		soapModel.setDoPart1ReviewDate(model.getDoPart1ReviewDate());
		soapModel.setDoPart1Status(model.getDoPart1Status());
		soapModel.setDoPart2Content(model.getDoPart2Content());
		soapModel.setDoPart2SumittedDate(model.getDoPart2SumittedDate());
		soapModel.setDoPart2ReviewDate(model.getDoPart2ReviewDate());
		soapModel.setDoPart2Status(model.getDoPart2Status());
		soapModel.setRequestStatus(model.getRequestStatus());
		soapModel.setRequestCompletedDate(model.getRequestCompletedDate());
		soapModel.setReviewDate(model.getReviewDate());
		soapModel.setReviewerUserId(model.getReviewerUserId());
		soapModel.setApproveDate(model.getApproveDate());
		soapModel.setApproverUserId(model.getApproverUserId());

		return soapModel;
	}

	public static SampleProcessRequestSoap[] toSoapModels(
		SampleProcessRequest[] models) {

		SampleProcessRequestSoap[] soapModels =
			new SampleProcessRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleProcessRequestSoap[][] toSoapModels(
		SampleProcessRequest[][] models) {

		SampleProcessRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SampleProcessRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleProcessRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleProcessRequestSoap[] toSoapModels(
		List<SampleProcessRequest> models) {

		List<SampleProcessRequestSoap> soapModels =
			new ArrayList<SampleProcessRequestSoap>(models.size());

		for (SampleProcessRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SampleProcessRequestSoap[soapModels.size()]);
	}

	public SampleProcessRequestSoap() {
	}

	public long getPrimaryKey() {
		return _sampleProcessRequestId;
	}

	public void setPrimaryKey(long pk) {
		setSampleProcessRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSampleProcessRequestId() {
		return _sampleProcessRequestId;
	}

	public void setSampleProcessRequestId(long sampleProcessRequestId) {
		_sampleProcessRequestId = sampleProcessRequestId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getDeputationOrganization() {
		return _deputationOrganization;
	}

	public void setDeputationOrganization(String deputationOrganization) {
		_deputationOrganization = deputationOrganization;
	}

	public String getDeputationAddress() {
		return _deputationAddress;
	}

	public void setDeputationAddress(String deputationAddress) {
		_deputationAddress = deputationAddress;
	}

	public String getDeputationCity() {
		return _deputationCity;
	}

	public void setDeputationCity(String deputationCity) {
		_deputationCity = deputationCity;
	}

	public String getDeputationState() {
		return _deputationState;
	}

	public void setDeputationState(String deputationState) {
		_deputationState = deputationState;
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

	public String getDoPart1Content() {
		return _doPart1Content;
	}

	public void setDoPart1Content(String doPart1Content) {
		_doPart1Content = doPart1Content;
	}

	public Date getDoPart1SumittedDate() {
		return _doPart1SumittedDate;
	}

	public void setDoPart1SumittedDate(Date doPart1SumittedDate) {
		_doPart1SumittedDate = doPart1SumittedDate;
	}

	public Date getDoPart1ReviewDate() {
		return _doPart1ReviewDate;
	}

	public void setDoPart1ReviewDate(Date doPart1ReviewDate) {
		_doPart1ReviewDate = doPart1ReviewDate;
	}

	public long getDoPart1Status() {
		return _doPart1Status;
	}

	public void setDoPart1Status(long doPart1Status) {
		_doPart1Status = doPart1Status;
	}

	public String getDoPart2Content() {
		return _doPart2Content;
	}

	public void setDoPart2Content(String doPart2Content) {
		_doPart2Content = doPart2Content;
	}

	public Date getDoPart2SumittedDate() {
		return _doPart2SumittedDate;
	}

	public void setDoPart2SumittedDate(Date doPart2SumittedDate) {
		_doPart2SumittedDate = doPart2SumittedDate;
	}

	public Date getDoPart2ReviewDate() {
		return _doPart2ReviewDate;
	}

	public void setDoPart2ReviewDate(Date doPart2ReviewDate) {
		_doPart2ReviewDate = doPart2ReviewDate;
	}

	public long getDoPart2Status() {
		return _doPart2Status;
	}

	public void setDoPart2Status(long doPart2Status) {
		_doPart2Status = doPart2Status;
	}

	public int getRequestStatus() {
		return _requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		_requestStatus = requestStatus;
	}

	public Date getRequestCompletedDate() {
		return _requestCompletedDate;
	}

	public void setRequestCompletedDate(Date requestCompletedDate) {
		_requestCompletedDate = requestCompletedDate;
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
	private long _sampleProcessRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _employeeId;
	private String _deputationOrganization;
	private String _deputationAddress;
	private String _deputationCity;
	private String _deputationState;
	private long _processFileId;
	private long _processFileNo;
	private String _doPart1Content;
	private Date _doPart1SumittedDate;
	private Date _doPart1ReviewDate;
	private long _doPart1Status;
	private String _doPart2Content;
	private Date _doPart2SumittedDate;
	private Date _doPart2ReviewDate;
	private long _doPart2Status;
	private int _requestStatus;
	private Date _requestCompletedDate;
	private Date _reviewDate;
	private long _reviewerUserId;
	private Date _approveDate;
	private long _approverUserId;

}