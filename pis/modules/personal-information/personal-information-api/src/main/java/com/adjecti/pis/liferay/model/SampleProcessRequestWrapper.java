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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SampleProcessRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessRequest
 * @generated
 */
public class SampleProcessRequestWrapper
	extends BaseModelWrapper<SampleProcessRequest>
	implements ModelWrapper<SampleProcessRequest>, SampleProcessRequest {

	public SampleProcessRequestWrapper(
		SampleProcessRequest sampleProcessRequest) {

		super(sampleProcessRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sampleProcessRequestId", getSampleProcessRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("deputationOrganization", getDeputationOrganization());
		attributes.put("deputationAddress", getDeputationAddress());
		attributes.put("deputationCity", getDeputationCity());
		attributes.put("deputationState", getDeputationState());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("processFileNo", getProcessFileNo());
		attributes.put("doPart1Content", getDoPart1Content());
		attributes.put("doPart1SumittedDate", getDoPart1SumittedDate());
		attributes.put("doPart1ReviewDate", getDoPart1ReviewDate());
		attributes.put("doPart1Status", getDoPart1Status());
		attributes.put("doPart2Content", getDoPart2Content());
		attributes.put("doPart2SumittedDate", getDoPart2SumittedDate());
		attributes.put("doPart2ReviewDate", getDoPart2ReviewDate());
		attributes.put("doPart2Status", getDoPart2Status());
		attributes.put("requestStatus", getRequestStatus());
		attributes.put("requestCompletedDate", getRequestCompletedDate());
		attributes.put("reviewDate", getReviewDate());
		attributes.put("reviewerUserId", getReviewerUserId());
		attributes.put("approveDate", getApproveDate());
		attributes.put("approverUserId", getApproverUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sampleProcessRequestId = (Long)attributes.get(
			"sampleProcessRequestId");

		if (sampleProcessRequestId != null) {
			setSampleProcessRequestId(sampleProcessRequestId);
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String deputationOrganization = (String)attributes.get(
			"deputationOrganization");

		if (deputationOrganization != null) {
			setDeputationOrganization(deputationOrganization);
		}

		String deputationAddress = (String)attributes.get("deputationAddress");

		if (deputationAddress != null) {
			setDeputationAddress(deputationAddress);
		}

		String deputationCity = (String)attributes.get("deputationCity");

		if (deputationCity != null) {
			setDeputationCity(deputationCity);
		}

		String deputationState = (String)attributes.get("deputationState");

		if (deputationState != null) {
			setDeputationState(deputationState);
		}

		Long processFileId = (Long)attributes.get("processFileId");

		if (processFileId != null) {
			setProcessFileId(processFileId);
		}

		Long processFileNo = (Long)attributes.get("processFileNo");

		if (processFileNo != null) {
			setProcessFileNo(processFileNo);
		}

		String doPart1Content = (String)attributes.get("doPart1Content");

		if (doPart1Content != null) {
			setDoPart1Content(doPart1Content);
		}

		Date doPart1SumittedDate = (Date)attributes.get("doPart1SumittedDate");

		if (doPart1SumittedDate != null) {
			setDoPart1SumittedDate(doPart1SumittedDate);
		}

		Date doPart1ReviewDate = (Date)attributes.get("doPart1ReviewDate");

		if (doPart1ReviewDate != null) {
			setDoPart1ReviewDate(doPart1ReviewDate);
		}

		Long doPart1Status = (Long)attributes.get("doPart1Status");

		if (doPart1Status != null) {
			setDoPart1Status(doPart1Status);
		}

		String doPart2Content = (String)attributes.get("doPart2Content");

		if (doPart2Content != null) {
			setDoPart2Content(doPart2Content);
		}

		Date doPart2SumittedDate = (Date)attributes.get("doPart2SumittedDate");

		if (doPart2SumittedDate != null) {
			setDoPart2SumittedDate(doPart2SumittedDate);
		}

		Date doPart2ReviewDate = (Date)attributes.get("doPart2ReviewDate");

		if (doPart2ReviewDate != null) {
			setDoPart2ReviewDate(doPart2ReviewDate);
		}

		Long doPart2Status = (Long)attributes.get("doPart2Status");

		if (doPart2Status != null) {
			setDoPart2Status(doPart2Status);
		}

		Integer requestStatus = (Integer)attributes.get("requestStatus");

		if (requestStatus != null) {
			setRequestStatus(requestStatus);
		}

		Date requestCompletedDate = (Date)attributes.get(
			"requestCompletedDate");

		if (requestCompletedDate != null) {
			setRequestCompletedDate(requestCompletedDate);
		}

		Date reviewDate = (Date)attributes.get("reviewDate");

		if (reviewDate != null) {
			setReviewDate(reviewDate);
		}

		Long reviewerUserId = (Long)attributes.get("reviewerUserId");

		if (reviewerUserId != null) {
			setReviewerUserId(reviewerUserId);
		}

		Date approveDate = (Date)attributes.get("approveDate");

		if (approveDate != null) {
			setApproveDate(approveDate);
		}

		Long approverUserId = (Long)attributes.get("approverUserId");

		if (approverUserId != null) {
			setApproverUserId(approverUserId);
		}
	}

	/**
	 * Returns the approve date of this sample process request.
	 *
	 * @return the approve date of this sample process request
	 */
	@Override
	public Date getApproveDate() {
		return model.getApproveDate();
	}

	/**
	 * Returns the approver user ID of this sample process request.
	 *
	 * @return the approver user ID of this sample process request
	 */
	@Override
	public long getApproverUserId() {
		return model.getApproverUserId();
	}

	/**
	 * Returns the approver user uuid of this sample process request.
	 *
	 * @return the approver user uuid of this sample process request
	 */
	@Override
	public String getApproverUserUuid() {
		return model.getApproverUserUuid();
	}

	/**
	 * Returns the company ID of this sample process request.
	 *
	 * @return the company ID of this sample process request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sample process request.
	 *
	 * @return the create date of this sample process request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deputation address of this sample process request.
	 *
	 * @return the deputation address of this sample process request
	 */
	@Override
	public String getDeputationAddress() {
		return model.getDeputationAddress();
	}

	/**
	 * Returns the deputation city of this sample process request.
	 *
	 * @return the deputation city of this sample process request
	 */
	@Override
	public String getDeputationCity() {
		return model.getDeputationCity();
	}

	/**
	 * Returns the deputation organization of this sample process request.
	 *
	 * @return the deputation organization of this sample process request
	 */
	@Override
	public String getDeputationOrganization() {
		return model.getDeputationOrganization();
	}

	/**
	 * Returns the deputation state of this sample process request.
	 *
	 * @return the deputation state of this sample process request
	 */
	@Override
	public String getDeputationState() {
		return model.getDeputationState();
	}

	/**
	 * Returns the do part1 content of this sample process request.
	 *
	 * @return the do part1 content of this sample process request
	 */
	@Override
	public String getDoPart1Content() {
		return model.getDoPart1Content();
	}

	/**
	 * Returns the do part1 review date of this sample process request.
	 *
	 * @return the do part1 review date of this sample process request
	 */
	@Override
	public Date getDoPart1ReviewDate() {
		return model.getDoPart1ReviewDate();
	}

	/**
	 * Returns the do part1 status of this sample process request.
	 *
	 * @return the do part1 status of this sample process request
	 */
	@Override
	public long getDoPart1Status() {
		return model.getDoPart1Status();
	}

	/**
	 * Returns the do part1 sumitted date of this sample process request.
	 *
	 * @return the do part1 sumitted date of this sample process request
	 */
	@Override
	public Date getDoPart1SumittedDate() {
		return model.getDoPart1SumittedDate();
	}

	/**
	 * Returns the do part2 content of this sample process request.
	 *
	 * @return the do part2 content of this sample process request
	 */
	@Override
	public String getDoPart2Content() {
		return model.getDoPart2Content();
	}

	/**
	 * Returns the do part2 review date of this sample process request.
	 *
	 * @return the do part2 review date of this sample process request
	 */
	@Override
	public Date getDoPart2ReviewDate() {
		return model.getDoPart2ReviewDate();
	}

	/**
	 * Returns the do part2 status of this sample process request.
	 *
	 * @return the do part2 status of this sample process request
	 */
	@Override
	public long getDoPart2Status() {
		return model.getDoPart2Status();
	}

	/**
	 * Returns the do part2 sumitted date of this sample process request.
	 *
	 * @return the do part2 sumitted date of this sample process request
	 */
	@Override
	public Date getDoPart2SumittedDate() {
		return model.getDoPart2SumittedDate();
	}

	/**
	 * Returns the employee ID of this sample process request.
	 *
	 * @return the employee ID of this sample process request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this sample process request.
	 *
	 * @return the group ID of this sample process request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sample process request.
	 *
	 * @return the modified date of this sample process request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this sample process request.
	 *
	 * @return the primary key of this sample process request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process file ID of this sample process request.
	 *
	 * @return the process file ID of this sample process request
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this sample process request.
	 *
	 * @return the process file no of this sample process request
	 */
	@Override
	public long getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the request completed date of this sample process request.
	 *
	 * @return the request completed date of this sample process request
	 */
	@Override
	public Date getRequestCompletedDate() {
		return model.getRequestCompletedDate();
	}

	/**
	 * Returns the request status of this sample process request.
	 *
	 * @return the request status of this sample process request
	 */
	@Override
	public int getRequestStatus() {
		return model.getRequestStatus();
	}

	/**
	 * Returns the review date of this sample process request.
	 *
	 * @return the review date of this sample process request
	 */
	@Override
	public Date getReviewDate() {
		return model.getReviewDate();
	}

	/**
	 * Returns the reviewer user ID of this sample process request.
	 *
	 * @return the reviewer user ID of this sample process request
	 */
	@Override
	public long getReviewerUserId() {
		return model.getReviewerUserId();
	}

	/**
	 * Returns the reviewer user uuid of this sample process request.
	 *
	 * @return the reviewer user uuid of this sample process request
	 */
	@Override
	public String getReviewerUserUuid() {
		return model.getReviewerUserUuid();
	}

	/**
	 * Returns the sample process request ID of this sample process request.
	 *
	 * @return the sample process request ID of this sample process request
	 */
	@Override
	public long getSampleProcessRequestId() {
		return model.getSampleProcessRequestId();
	}

	/**
	 * Returns the user ID of this sample process request.
	 *
	 * @return the user ID of this sample process request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sample process request.
	 *
	 * @return the user name of this sample process request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sample process request.
	 *
	 * @return the user uuid of this sample process request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sample process request.
	 *
	 * @return the uuid of this sample process request
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
	 * Sets the approve date of this sample process request.
	 *
	 * @param approveDate the approve date of this sample process request
	 */
	@Override
	public void setApproveDate(Date approveDate) {
		model.setApproveDate(approveDate);
	}

	/**
	 * Sets the approver user ID of this sample process request.
	 *
	 * @param approverUserId the approver user ID of this sample process request
	 */
	@Override
	public void setApproverUserId(long approverUserId) {
		model.setApproverUserId(approverUserId);
	}

	/**
	 * Sets the approver user uuid of this sample process request.
	 *
	 * @param approverUserUuid the approver user uuid of this sample process request
	 */
	@Override
	public void setApproverUserUuid(String approverUserUuid) {
		model.setApproverUserUuid(approverUserUuid);
	}

	/**
	 * Sets the company ID of this sample process request.
	 *
	 * @param companyId the company ID of this sample process request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sample process request.
	 *
	 * @param createDate the create date of this sample process request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deputation address of this sample process request.
	 *
	 * @param deputationAddress the deputation address of this sample process request
	 */
	@Override
	public void setDeputationAddress(String deputationAddress) {
		model.setDeputationAddress(deputationAddress);
	}

	/**
	 * Sets the deputation city of this sample process request.
	 *
	 * @param deputationCity the deputation city of this sample process request
	 */
	@Override
	public void setDeputationCity(String deputationCity) {
		model.setDeputationCity(deputationCity);
	}

	/**
	 * Sets the deputation organization of this sample process request.
	 *
	 * @param deputationOrganization the deputation organization of this sample process request
	 */
	@Override
	public void setDeputationOrganization(String deputationOrganization) {
		model.setDeputationOrganization(deputationOrganization);
	}

	/**
	 * Sets the deputation state of this sample process request.
	 *
	 * @param deputationState the deputation state of this sample process request
	 */
	@Override
	public void setDeputationState(String deputationState) {
		model.setDeputationState(deputationState);
	}

	/**
	 * Sets the do part1 content of this sample process request.
	 *
	 * @param doPart1Content the do part1 content of this sample process request
	 */
	@Override
	public void setDoPart1Content(String doPart1Content) {
		model.setDoPart1Content(doPart1Content);
	}

	/**
	 * Sets the do part1 review date of this sample process request.
	 *
	 * @param doPart1ReviewDate the do part1 review date of this sample process request
	 */
	@Override
	public void setDoPart1ReviewDate(Date doPart1ReviewDate) {
		model.setDoPart1ReviewDate(doPart1ReviewDate);
	}

	/**
	 * Sets the do part1 status of this sample process request.
	 *
	 * @param doPart1Status the do part1 status of this sample process request
	 */
	@Override
	public void setDoPart1Status(long doPart1Status) {
		model.setDoPart1Status(doPart1Status);
	}

	/**
	 * Sets the do part1 sumitted date of this sample process request.
	 *
	 * @param doPart1SumittedDate the do part1 sumitted date of this sample process request
	 */
	@Override
	public void setDoPart1SumittedDate(Date doPart1SumittedDate) {
		model.setDoPart1SumittedDate(doPart1SumittedDate);
	}

	/**
	 * Sets the do part2 content of this sample process request.
	 *
	 * @param doPart2Content the do part2 content of this sample process request
	 */
	@Override
	public void setDoPart2Content(String doPart2Content) {
		model.setDoPart2Content(doPart2Content);
	}

	/**
	 * Sets the do part2 review date of this sample process request.
	 *
	 * @param doPart2ReviewDate the do part2 review date of this sample process request
	 */
	@Override
	public void setDoPart2ReviewDate(Date doPart2ReviewDate) {
		model.setDoPart2ReviewDate(doPart2ReviewDate);
	}

	/**
	 * Sets the do part2 status of this sample process request.
	 *
	 * @param doPart2Status the do part2 status of this sample process request
	 */
	@Override
	public void setDoPart2Status(long doPart2Status) {
		model.setDoPart2Status(doPart2Status);
	}

	/**
	 * Sets the do part2 sumitted date of this sample process request.
	 *
	 * @param doPart2SumittedDate the do part2 sumitted date of this sample process request
	 */
	@Override
	public void setDoPart2SumittedDate(Date doPart2SumittedDate) {
		model.setDoPart2SumittedDate(doPart2SumittedDate);
	}

	/**
	 * Sets the employee ID of this sample process request.
	 *
	 * @param employeeId the employee ID of this sample process request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this sample process request.
	 *
	 * @param groupId the group ID of this sample process request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sample process request.
	 *
	 * @param modifiedDate the modified date of this sample process request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this sample process request.
	 *
	 * @param primaryKey the primary key of this sample process request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process file ID of this sample process request.
	 *
	 * @param processFileId the process file ID of this sample process request
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this sample process request.
	 *
	 * @param processFileNo the process file no of this sample process request
	 */
	@Override
	public void setProcessFileNo(long processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the request completed date of this sample process request.
	 *
	 * @param requestCompletedDate the request completed date of this sample process request
	 */
	@Override
	public void setRequestCompletedDate(Date requestCompletedDate) {
		model.setRequestCompletedDate(requestCompletedDate);
	}

	/**
	 * Sets the request status of this sample process request.
	 *
	 * @param requestStatus the request status of this sample process request
	 */
	@Override
	public void setRequestStatus(int requestStatus) {
		model.setRequestStatus(requestStatus);
	}

	/**
	 * Sets the review date of this sample process request.
	 *
	 * @param reviewDate the review date of this sample process request
	 */
	@Override
	public void setReviewDate(Date reviewDate) {
		model.setReviewDate(reviewDate);
	}

	/**
	 * Sets the reviewer user ID of this sample process request.
	 *
	 * @param reviewerUserId the reviewer user ID of this sample process request
	 */
	@Override
	public void setReviewerUserId(long reviewerUserId) {
		model.setReviewerUserId(reviewerUserId);
	}

	/**
	 * Sets the reviewer user uuid of this sample process request.
	 *
	 * @param reviewerUserUuid the reviewer user uuid of this sample process request
	 */
	@Override
	public void setReviewerUserUuid(String reviewerUserUuid) {
		model.setReviewerUserUuid(reviewerUserUuid);
	}

	/**
	 * Sets the sample process request ID of this sample process request.
	 *
	 * @param sampleProcessRequestId the sample process request ID of this sample process request
	 */
	@Override
	public void setSampleProcessRequestId(long sampleProcessRequestId) {
		model.setSampleProcessRequestId(sampleProcessRequestId);
	}

	/**
	 * Sets the user ID of this sample process request.
	 *
	 * @param userId the user ID of this sample process request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sample process request.
	 *
	 * @param userName the user name of this sample process request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sample process request.
	 *
	 * @param userUuid the user uuid of this sample process request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sample process request.
	 *
	 * @param uuid the uuid of this sample process request
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
	protected SampleProcessRequestWrapper wrap(
		SampleProcessRequest sampleProcessRequest) {

		return new SampleProcessRequestWrapper(sampleProcessRequest);
	}

}