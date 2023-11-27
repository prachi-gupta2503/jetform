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
 * This class is a wrapper for {@link SampleProcess}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcess
 * @generated
 */
public class SampleProcessWrapper
	extends BaseModelWrapper<SampleProcess>
	implements ModelWrapper<SampleProcess>, SampleProcess {

	public SampleProcessWrapper(SampleProcess sampleProcess) {
		super(sampleProcess);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sampleProcessId", getSampleProcessId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("processFileId", getProcessFileId());
		attributes.put("processFileNo", getProcessFileNo());
		attributes.put("notingContent", getNotingContent());
		attributes.put("notingSubmittedDate", getNotingSubmittedDate());
		attributes.put("notingApprovedDate", getNotingApprovedDate());
		attributes.put("processStatus", getProcessStatus());
		attributes.put("processCompletedDate", getProcessCompletedDate());
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

		Long sampleProcessId = (Long)attributes.get("sampleProcessId");

		if (sampleProcessId != null) {
			setSampleProcessId(sampleProcessId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long processFileId = (Long)attributes.get("processFileId");

		if (processFileId != null) {
			setProcessFileId(processFileId);
		}

		Long processFileNo = (Long)attributes.get("processFileNo");

		if (processFileNo != null) {
			setProcessFileNo(processFileNo);
		}

		String notingContent = (String)attributes.get("notingContent");

		if (notingContent != null) {
			setNotingContent(notingContent);
		}

		Date notingSubmittedDate = (Date)attributes.get("notingSubmittedDate");

		if (notingSubmittedDate != null) {
			setNotingSubmittedDate(notingSubmittedDate);
		}

		Date notingApprovedDate = (Date)attributes.get("notingApprovedDate");

		if (notingApprovedDate != null) {
			setNotingApprovedDate(notingApprovedDate);
		}

		Integer processStatus = (Integer)attributes.get("processStatus");

		if (processStatus != null) {
			setProcessStatus(processStatus);
		}

		Date processCompletedDate = (Date)attributes.get(
			"processCompletedDate");

		if (processCompletedDate != null) {
			setProcessCompletedDate(processCompletedDate);
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
	 * Returns the approve date of this sample process.
	 *
	 * @return the approve date of this sample process
	 */
	@Override
	public Date getApproveDate() {
		return model.getApproveDate();
	}

	/**
	 * Returns the approver user ID of this sample process.
	 *
	 * @return the approver user ID of this sample process
	 */
	@Override
	public long getApproverUserId() {
		return model.getApproverUserId();
	}

	/**
	 * Returns the approver user uuid of this sample process.
	 *
	 * @return the approver user uuid of this sample process
	 */
	@Override
	public String getApproverUserUuid() {
		return model.getApproverUserUuid();
	}

	/**
	 * Returns the company ID of this sample process.
	 *
	 * @return the company ID of this sample process
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sample process.
	 *
	 * @return the create date of this sample process
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this sample process.
	 *
	 * @return the description of this sample process
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this sample process.
	 *
	 * @return the group ID of this sample process
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sample process.
	 *
	 * @return the modified date of this sample process
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this sample process.
	 *
	 * @return the name of this sample process
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the noting approved date of this sample process.
	 *
	 * @return the noting approved date of this sample process
	 */
	@Override
	public Date getNotingApprovedDate() {
		return model.getNotingApprovedDate();
	}

	/**
	 * Returns the noting content of this sample process.
	 *
	 * @return the noting content of this sample process
	 */
	@Override
	public String getNotingContent() {
		return model.getNotingContent();
	}

	/**
	 * Returns the noting submitted date of this sample process.
	 *
	 * @return the noting submitted date of this sample process
	 */
	@Override
	public Date getNotingSubmittedDate() {
		return model.getNotingSubmittedDate();
	}

	/**
	 * Returns the primary key of this sample process.
	 *
	 * @return the primary key of this sample process
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process completed date of this sample process.
	 *
	 * @return the process completed date of this sample process
	 */
	@Override
	public Date getProcessCompletedDate() {
		return model.getProcessCompletedDate();
	}

	/**
	 * Returns the process file ID of this sample process.
	 *
	 * @return the process file ID of this sample process
	 */
	@Override
	public long getProcessFileId() {
		return model.getProcessFileId();
	}

	/**
	 * Returns the process file no of this sample process.
	 *
	 * @return the process file no of this sample process
	 */
	@Override
	public long getProcessFileNo() {
		return model.getProcessFileNo();
	}

	/**
	 * Returns the process status of this sample process.
	 *
	 * @return the process status of this sample process
	 */
	@Override
	public int getProcessStatus() {
		return model.getProcessStatus();
	}

	/**
	 * Returns the review date of this sample process.
	 *
	 * @return the review date of this sample process
	 */
	@Override
	public Date getReviewDate() {
		return model.getReviewDate();
	}

	/**
	 * Returns the reviewer user ID of this sample process.
	 *
	 * @return the reviewer user ID of this sample process
	 */
	@Override
	public long getReviewerUserId() {
		return model.getReviewerUserId();
	}

	/**
	 * Returns the reviewer user uuid of this sample process.
	 *
	 * @return the reviewer user uuid of this sample process
	 */
	@Override
	public String getReviewerUserUuid() {
		return model.getReviewerUserUuid();
	}

	/**
	 * Returns the sample process ID of this sample process.
	 *
	 * @return the sample process ID of this sample process
	 */
	@Override
	public long getSampleProcessId() {
		return model.getSampleProcessId();
	}

	/**
	 * Returns the user ID of this sample process.
	 *
	 * @return the user ID of this sample process
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sample process.
	 *
	 * @return the user name of this sample process
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sample process.
	 *
	 * @return the user uuid of this sample process
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sample process.
	 *
	 * @return the uuid of this sample process
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
	 * Sets the approve date of this sample process.
	 *
	 * @param approveDate the approve date of this sample process
	 */
	@Override
	public void setApproveDate(Date approveDate) {
		model.setApproveDate(approveDate);
	}

	/**
	 * Sets the approver user ID of this sample process.
	 *
	 * @param approverUserId the approver user ID of this sample process
	 */
	@Override
	public void setApproverUserId(long approverUserId) {
		model.setApproverUserId(approverUserId);
	}

	/**
	 * Sets the approver user uuid of this sample process.
	 *
	 * @param approverUserUuid the approver user uuid of this sample process
	 */
	@Override
	public void setApproverUserUuid(String approverUserUuid) {
		model.setApproverUserUuid(approverUserUuid);
	}

	/**
	 * Sets the company ID of this sample process.
	 *
	 * @param companyId the company ID of this sample process
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sample process.
	 *
	 * @param createDate the create date of this sample process
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this sample process.
	 *
	 * @param description the description of this sample process
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this sample process.
	 *
	 * @param groupId the group ID of this sample process
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sample process.
	 *
	 * @param modifiedDate the modified date of this sample process
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this sample process.
	 *
	 * @param name the name of this sample process
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the noting approved date of this sample process.
	 *
	 * @param notingApprovedDate the noting approved date of this sample process
	 */
	@Override
	public void setNotingApprovedDate(Date notingApprovedDate) {
		model.setNotingApprovedDate(notingApprovedDate);
	}

	/**
	 * Sets the noting content of this sample process.
	 *
	 * @param notingContent the noting content of this sample process
	 */
	@Override
	public void setNotingContent(String notingContent) {
		model.setNotingContent(notingContent);
	}

	/**
	 * Sets the noting submitted date of this sample process.
	 *
	 * @param notingSubmittedDate the noting submitted date of this sample process
	 */
	@Override
	public void setNotingSubmittedDate(Date notingSubmittedDate) {
		model.setNotingSubmittedDate(notingSubmittedDate);
	}

	/**
	 * Sets the primary key of this sample process.
	 *
	 * @param primaryKey the primary key of this sample process
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process completed date of this sample process.
	 *
	 * @param processCompletedDate the process completed date of this sample process
	 */
	@Override
	public void setProcessCompletedDate(Date processCompletedDate) {
		model.setProcessCompletedDate(processCompletedDate);
	}

	/**
	 * Sets the process file ID of this sample process.
	 *
	 * @param processFileId the process file ID of this sample process
	 */
	@Override
	public void setProcessFileId(long processFileId) {
		model.setProcessFileId(processFileId);
	}

	/**
	 * Sets the process file no of this sample process.
	 *
	 * @param processFileNo the process file no of this sample process
	 */
	@Override
	public void setProcessFileNo(long processFileNo) {
		model.setProcessFileNo(processFileNo);
	}

	/**
	 * Sets the process status of this sample process.
	 *
	 * @param processStatus the process status of this sample process
	 */
	@Override
	public void setProcessStatus(int processStatus) {
		model.setProcessStatus(processStatus);
	}

	/**
	 * Sets the review date of this sample process.
	 *
	 * @param reviewDate the review date of this sample process
	 */
	@Override
	public void setReviewDate(Date reviewDate) {
		model.setReviewDate(reviewDate);
	}

	/**
	 * Sets the reviewer user ID of this sample process.
	 *
	 * @param reviewerUserId the reviewer user ID of this sample process
	 */
	@Override
	public void setReviewerUserId(long reviewerUserId) {
		model.setReviewerUserId(reviewerUserId);
	}

	/**
	 * Sets the reviewer user uuid of this sample process.
	 *
	 * @param reviewerUserUuid the reviewer user uuid of this sample process
	 */
	@Override
	public void setReviewerUserUuid(String reviewerUserUuid) {
		model.setReviewerUserUuid(reviewerUserUuid);
	}

	/**
	 * Sets the sample process ID of this sample process.
	 *
	 * @param sampleProcessId the sample process ID of this sample process
	 */
	@Override
	public void setSampleProcessId(long sampleProcessId) {
		model.setSampleProcessId(sampleProcessId);
	}

	/**
	 * Sets the user ID of this sample process.
	 *
	 * @param userId the user ID of this sample process
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sample process.
	 *
	 * @param userName the user name of this sample process
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sample process.
	 *
	 * @param userUuid the user uuid of this sample process
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sample process.
	 *
	 * @param uuid the uuid of this sample process
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
	protected SampleProcessWrapper wrap(SampleProcess sampleProcess) {
		return new SampleProcessWrapper(sampleProcess);
	}

}