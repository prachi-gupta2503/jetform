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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeJoining}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoining
 * @generated
 */
public class EmployeeJoiningWrapper
	extends BaseModelWrapper<EmployeeJoining>
	implements EmployeeJoining, ModelWrapper<EmployeeJoining> {

	public EmployeeJoiningWrapper(EmployeeJoining employeeJoining) {
		super(employeeJoining);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeJoiningId", getEmployeeJoiningId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("aadhaarNo", getAadhaarNo());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("exServiceMan", isExServiceMan());
		attributes.put("panNo", getPanNo());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("peopleId", getPeopleId());
		attributes.put("fullName", getFullName());
		attributes.put("designationId", getDesignationId());
		attributes.put("gradeId", getGradeId());
		attributes.put("payLevelId", getPayLevelId());
		attributes.put("postId", getPostId());
		attributes.put("tradeId", getTradeId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("subOrganizationId", getSubOrganizationId());
		attributes.put("designationClassId", getDesignationClassId());
		attributes.put("designationGroupId", getDesignationGroupId());
		attributes.put("joiningModeId", getJoiningModeId());
		attributes.put("joiningLetterId", getJoiningLetterId());
		attributes.put("gradeModeId", getGradeModeId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("selectionDate", getSelectionDate());
		attributes.put("confirmationDate", getConfirmationDate());
		attributes.put("gradeConfirmationDate", getGradeConfirmationDate());
		attributes.put("govtServiceDate", getGovtServiceDate());
		attributes.put("recruitmentBatch", getRecruitmentBatch());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("emailId", getEmailId());
		attributes.put("postBox", getPostBox());
		attributes.put("dateOfJoining", getDateOfJoining());
		attributes.put(
			"dateOfJoiningOrganization", getDateOfJoiningOrganization());
		attributes.put("rank", getRank());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeJoiningId = (Long)attributes.get("employeeJoiningId");

		if (employeeJoiningId != null) {
			setEmployeeJoiningId(employeeJoiningId);
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

		String aadhaarNo = (String)attributes.get("aadhaarNo");

		if (aadhaarNo != null) {
			setAadhaarNo(aadhaarNo);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Boolean exServiceMan = (Boolean)attributes.get("exServiceMan");

		if (exServiceMan != null) {
			setExServiceMan(exServiceMan);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String personalNo = (String)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		Long peopleId = (Long)attributes.get("peopleId");

		if (peopleId != null) {
			setPeopleId(peopleId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
		}

		Long gradeId = (Long)attributes.get("gradeId");

		if (gradeId != null) {
			setGradeId(gradeId);
		}

		Long payLevelId = (Long)attributes.get("payLevelId");

		if (payLevelId != null) {
			setPayLevelId(payLevelId);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long tradeId = (Long)attributes.get("tradeId");

		if (tradeId != null) {
			setTradeId(tradeId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long subOrganizationId = (Long)attributes.get("subOrganizationId");

		if (subOrganizationId != null) {
			setSubOrganizationId(subOrganizationId);
		}

		Long designationClassId = (Long)attributes.get("designationClassId");

		if (designationClassId != null) {
			setDesignationClassId(designationClassId);
		}

		Long designationGroupId = (Long)attributes.get("designationGroupId");

		if (designationGroupId != null) {
			setDesignationGroupId(designationGroupId);
		}

		Long joiningModeId = (Long)attributes.get("joiningModeId");

		if (joiningModeId != null) {
			setJoiningModeId(joiningModeId);
		}

		Long joiningLetterId = (Long)attributes.get("joiningLetterId");

		if (joiningLetterId != null) {
			setJoiningLetterId(joiningLetterId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Date selectionDate = (Date)attributes.get("selectionDate");

		if (selectionDate != null) {
			setSelectionDate(selectionDate);
		}

		Date confirmationDate = (Date)attributes.get("confirmationDate");

		if (confirmationDate != null) {
			setConfirmationDate(confirmationDate);
		}

		Date gradeConfirmationDate = (Date)attributes.get(
			"gradeConfirmationDate");

		if (gradeConfirmationDate != null) {
			setGradeConfirmationDate(gradeConfirmationDate);
		}

		Date govtServiceDate = (Date)attributes.get("govtServiceDate");

		if (govtServiceDate != null) {
			setGovtServiceDate(govtServiceDate);
		}

		String recruitmentBatch = (String)attributes.get("recruitmentBatch");

		if (recruitmentBatch != null) {
			setRecruitmentBatch(recruitmentBatch);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String postBox = (String)attributes.get("postBox");

		if (postBox != null) {
			setPostBox(postBox);
		}

		Date dateOfJoining = (Date)attributes.get("dateOfJoining");

		if (dateOfJoining != null) {
			setDateOfJoining(dateOfJoining);
		}

		Date dateOfJoiningOrganization = (Date)attributes.get(
			"dateOfJoiningOrganization");

		if (dateOfJoiningOrganization != null) {
			setDateOfJoiningOrganization(dateOfJoiningOrganization);
		}

		Long rank = (Long)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the aadhaar no of this employee joining.
	 *
	 * @return the aadhaar no of this employee joining
	 */
	@Override
	public String getAadhaarNo() {
		return model.getAadhaarNo();
	}

	/**
	 * Returns the company ID of this employee joining.
	 *
	 * @return the company ID of this employee joining
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the confirmation date of this employee joining.
	 *
	 * @return the confirmation date of this employee joining
	 */
	@Override
	public Date getConfirmationDate() {
		return model.getConfirmationDate();
	}

	/**
	 * Returns the create date of this employee joining.
	 *
	 * @return the create date of this employee joining
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of joining of this employee joining.
	 *
	 * @return the date of joining of this employee joining
	 */
	@Override
	public Date getDateOfJoining() {
		return model.getDateOfJoining();
	}

	/**
	 * Returns the date of joining organization of this employee joining.
	 *
	 * @return the date of joining organization of this employee joining
	 */
	@Override
	public Date getDateOfJoiningOrganization() {
		return model.getDateOfJoiningOrganization();
	}

	/**
	 * Returns the designation class ID of this employee joining.
	 *
	 * @return the designation class ID of this employee joining
	 */
	@Override
	public long getDesignationClassId() {
		return model.getDesignationClassId();
	}

	/**
	 * Returns the designation group ID of this employee joining.
	 *
	 * @return the designation group ID of this employee joining
	 */
	@Override
	public long getDesignationGroupId() {
		return model.getDesignationGroupId();
	}

	/**
	 * Returns the designation ID of this employee joining.
	 *
	 * @return the designation ID of this employee joining
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the email address of this employee joining.
	 *
	 * @return the email address of this employee joining
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the email ID of this employee joining.
	 *
	 * @return the email ID of this employee joining
	 */
	@Override
	public String getEmailId() {
		return model.getEmailId();
	}

	/**
	 * Returns the employee ID of this employee joining.
	 *
	 * @return the employee ID of this employee joining
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee joining ID of this employee joining.
	 *
	 * @return the employee joining ID of this employee joining
	 */
	@Override
	public long getEmployeeJoiningId() {
		return model.getEmployeeJoiningId();
	}

	/**
	 * Returns the ex service man of this employee joining.
	 *
	 * @return the ex service man of this employee joining
	 */
	@Override
	public boolean getExServiceMan() {
		return model.getExServiceMan();
	}

	/**
	 * Returns the from date of this employee joining.
	 *
	 * @return the from date of this employee joining
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the full name of this employee joining.
	 *
	 * @return the full name of this employee joining
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the govt service date of this employee joining.
	 *
	 * @return the govt service date of this employee joining
	 */
	@Override
	public Date getGovtServiceDate() {
		return model.getGovtServiceDate();
	}

	/**
	 * Returns the grade confirmation date of this employee joining.
	 *
	 * @return the grade confirmation date of this employee joining
	 */
	@Override
	public Date getGradeConfirmationDate() {
		return model.getGradeConfirmationDate();
	}

	/**
	 * Returns the grade ID of this employee joining.
	 *
	 * @return the grade ID of this employee joining
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee joining.
	 *
	 * @return the grade mode ID of this employee joining
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee joining.
	 *
	 * @return the group ID of this employee joining
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining letter ID of this employee joining.
	 *
	 * @return the joining letter ID of this employee joining
	 */
	@Override
	public long getJoiningLetterId() {
		return model.getJoiningLetterId();
	}

	/**
	 * Returns the joining mode ID of this employee joining.
	 *
	 * @return the joining mode ID of this employee joining
	 */
	@Override
	public long getJoiningModeId() {
		return model.getJoiningModeId();
	}

	/**
	 * Returns the joining process ID of this employee joining.
	 *
	 * @return the joining process ID of this employee joining
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the modified date of this employee joining.
	 *
	 * @return the modified date of this employee joining
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee joining.
	 *
	 * @return the organization ID of this employee joining
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the pan no of this employee joining.
	 *
	 * @return the pan no of this employee joining
	 */
	@Override
	public String getPanNo() {
		return model.getPanNo();
	}

	/**
	 * Returns the pay level ID of this employee joining.
	 *
	 * @return the pay level ID of this employee joining
	 */
	@Override
	public long getPayLevelId() {
		return model.getPayLevelId();
	}

	/**
	 * Returns the people ID of this employee joining.
	 *
	 * @return the people ID of this employee joining
	 */
	@Override
	public long getPeopleId() {
		return model.getPeopleId();
	}

	/**
	 * Returns the personal no of this employee joining.
	 *
	 * @return the personal no of this employee joining
	 */
	@Override
	public String getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the post box of this employee joining.
	 *
	 * @return the post box of this employee joining
	 */
	@Override
	public String getPostBox() {
		return model.getPostBox();
	}

	/**
	 * Returns the post ID of this employee joining.
	 *
	 * @return the post ID of this employee joining
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this employee joining.
	 *
	 * @return the primary key of this employee joining
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank of this employee joining.
	 *
	 * @return the rank of this employee joining
	 */
	@Override
	public long getRank() {
		return model.getRank();
	}

	/**
	 * Returns the recruitment batch of this employee joining.
	 *
	 * @return the recruitment batch of this employee joining
	 */
	@Override
	public String getRecruitmentBatch() {
		return model.getRecruitmentBatch();
	}

	/**
	 * Returns the selection date of this employee joining.
	 *
	 * @return the selection date of this employee joining
	 */
	@Override
	public Date getSelectionDate() {
		return model.getSelectionDate();
	}

	/**
	 * Returns the status of this employee joining.
	 *
	 * @return the status of this employee joining
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the sub organization ID of this employee joining.
	 *
	 * @return the sub organization ID of this employee joining
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the to date of this employee joining.
	 *
	 * @return the to date of this employee joining
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the trade ID of this employee joining.
	 *
	 * @return the trade ID of this employee joining
	 */
	@Override
	public long getTradeId() {
		return model.getTradeId();
	}

	/**
	 * Returns the user ID of this employee joining.
	 *
	 * @return the user ID of this employee joining
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee joining.
	 *
	 * @return the user name of this employee joining
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee joining.
	 *
	 * @return the user uuid of this employee joining
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this employee joining is ex service man.
	 *
	 * @return <code>true</code> if this employee joining is ex service man; <code>false</code> otherwise
	 */
	@Override
	public boolean isExServiceMan() {
		return model.isExServiceMan();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhaar no of this employee joining.
	 *
	 * @param aadhaarNo the aadhaar no of this employee joining
	 */
	@Override
	public void setAadhaarNo(String aadhaarNo) {
		model.setAadhaarNo(aadhaarNo);
	}

	/**
	 * Sets the company ID of this employee joining.
	 *
	 * @param companyId the company ID of this employee joining
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the confirmation date of this employee joining.
	 *
	 * @param confirmationDate the confirmation date of this employee joining
	 */
	@Override
	public void setConfirmationDate(Date confirmationDate) {
		model.setConfirmationDate(confirmationDate);
	}

	/**
	 * Sets the create date of this employee joining.
	 *
	 * @param createDate the create date of this employee joining
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of joining of this employee joining.
	 *
	 * @param dateOfJoining the date of joining of this employee joining
	 */
	@Override
	public void setDateOfJoining(Date dateOfJoining) {
		model.setDateOfJoining(dateOfJoining);
	}

	/**
	 * Sets the date of joining organization of this employee joining.
	 *
	 * @param dateOfJoiningOrganization the date of joining organization of this employee joining
	 */
	@Override
	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		model.setDateOfJoiningOrganization(dateOfJoiningOrganization);
	}

	/**
	 * Sets the designation class ID of this employee joining.
	 *
	 * @param designationClassId the designation class ID of this employee joining
	 */
	@Override
	public void setDesignationClassId(long designationClassId) {
		model.setDesignationClassId(designationClassId);
	}

	/**
	 * Sets the designation group ID of this employee joining.
	 *
	 * @param designationGroupId the designation group ID of this employee joining
	 */
	@Override
	public void setDesignationGroupId(long designationGroupId) {
		model.setDesignationGroupId(designationGroupId);
	}

	/**
	 * Sets the designation ID of this employee joining.
	 *
	 * @param designationId the designation ID of this employee joining
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the email address of this employee joining.
	 *
	 * @param emailAddress the email address of this employee joining
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the email ID of this employee joining.
	 *
	 * @param emailId the email ID of this employee joining
	 */
	@Override
	public void setEmailId(String emailId) {
		model.setEmailId(emailId);
	}

	/**
	 * Sets the employee ID of this employee joining.
	 *
	 * @param employeeId the employee ID of this employee joining
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee joining ID of this employee joining.
	 *
	 * @param employeeJoiningId the employee joining ID of this employee joining
	 */
	@Override
	public void setEmployeeJoiningId(long employeeJoiningId) {
		model.setEmployeeJoiningId(employeeJoiningId);
	}

	/**
	 * Sets whether this employee joining is ex service man.
	 *
	 * @param exServiceMan the ex service man of this employee joining
	 */
	@Override
	public void setExServiceMan(boolean exServiceMan) {
		model.setExServiceMan(exServiceMan);
	}

	/**
	 * Sets the from date of this employee joining.
	 *
	 * @param fromDate the from date of this employee joining
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the full name of this employee joining.
	 *
	 * @param fullName the full name of this employee joining
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the govt service date of this employee joining.
	 *
	 * @param govtServiceDate the govt service date of this employee joining
	 */
	@Override
	public void setGovtServiceDate(Date govtServiceDate) {
		model.setGovtServiceDate(govtServiceDate);
	}

	/**
	 * Sets the grade confirmation date of this employee joining.
	 *
	 * @param gradeConfirmationDate the grade confirmation date of this employee joining
	 */
	@Override
	public void setGradeConfirmationDate(Date gradeConfirmationDate) {
		model.setGradeConfirmationDate(gradeConfirmationDate);
	}

	/**
	 * Sets the grade ID of this employee joining.
	 *
	 * @param gradeId the grade ID of this employee joining
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee joining.
	 *
	 * @param gradeModeId the grade mode ID of this employee joining
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee joining.
	 *
	 * @param groupId the group ID of this employee joining
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining letter ID of this employee joining.
	 *
	 * @param joiningLetterId the joining letter ID of this employee joining
	 */
	@Override
	public void setJoiningLetterId(long joiningLetterId) {
		model.setJoiningLetterId(joiningLetterId);
	}

	/**
	 * Sets the joining mode ID of this employee joining.
	 *
	 * @param joiningModeId the joining mode ID of this employee joining
	 */
	@Override
	public void setJoiningModeId(long joiningModeId) {
		model.setJoiningModeId(joiningModeId);
	}

	/**
	 * Sets the joining process ID of this employee joining.
	 *
	 * @param joiningProcessId the joining process ID of this employee joining
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the modified date of this employee joining.
	 *
	 * @param modifiedDate the modified date of this employee joining
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee joining.
	 *
	 * @param organizationId the organization ID of this employee joining
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the pan no of this employee joining.
	 *
	 * @param panNo the pan no of this employee joining
	 */
	@Override
	public void setPanNo(String panNo) {
		model.setPanNo(panNo);
	}

	/**
	 * Sets the pay level ID of this employee joining.
	 *
	 * @param payLevelId the pay level ID of this employee joining
	 */
	@Override
	public void setPayLevelId(long payLevelId) {
		model.setPayLevelId(payLevelId);
	}

	/**
	 * Sets the people ID of this employee joining.
	 *
	 * @param peopleId the people ID of this employee joining
	 */
	@Override
	public void setPeopleId(long peopleId) {
		model.setPeopleId(peopleId);
	}

	/**
	 * Sets the personal no of this employee joining.
	 *
	 * @param personalNo the personal no of this employee joining
	 */
	@Override
	public void setPersonalNo(String personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the post box of this employee joining.
	 *
	 * @param postBox the post box of this employee joining
	 */
	@Override
	public void setPostBox(String postBox) {
		model.setPostBox(postBox);
	}

	/**
	 * Sets the post ID of this employee joining.
	 *
	 * @param postId the post ID of this employee joining
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this employee joining.
	 *
	 * @param primaryKey the primary key of this employee joining
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank of this employee joining.
	 *
	 * @param rank the rank of this employee joining
	 */
	@Override
	public void setRank(long rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the recruitment batch of this employee joining.
	 *
	 * @param recruitmentBatch the recruitment batch of this employee joining
	 */
	@Override
	public void setRecruitmentBatch(String recruitmentBatch) {
		model.setRecruitmentBatch(recruitmentBatch);
	}

	/**
	 * Sets the selection date of this employee joining.
	 *
	 * @param selectionDate the selection date of this employee joining
	 */
	@Override
	public void setSelectionDate(Date selectionDate) {
		model.setSelectionDate(selectionDate);
	}

	/**
	 * Sets the status of this employee joining.
	 *
	 * @param status the status of this employee joining
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the sub organization ID of this employee joining.
	 *
	 * @param subOrganizationId the sub organization ID of this employee joining
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets the to date of this employee joining.
	 *
	 * @param toDate the to date of this employee joining
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the trade ID of this employee joining.
	 *
	 * @param tradeId the trade ID of this employee joining
	 */
	@Override
	public void setTradeId(long tradeId) {
		model.setTradeId(tradeId);
	}

	/**
	 * Sets the user ID of this employee joining.
	 *
	 * @param userId the user ID of this employee joining
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee joining.
	 *
	 * @param userName the user name of this employee joining
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee joining.
	 *
	 * @param userUuid the user uuid of this employee joining
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EmployeeJoiningWrapper wrap(EmployeeJoining employeeJoining) {
		return new EmployeeJoiningWrapper(employeeJoining);
	}

}