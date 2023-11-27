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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
	extends BaseModelWrapper<Employee>
	implements Employee, ModelWrapper<Employee> {

	public EmployeeWrapper(Employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("state", getState());
		attributes.put("personalNo", getPersonalNo());
		attributes.put("peopleId", getPeopleId());
		attributes.put("emailId", getEmailId());
		attributes.put("designationId", getDesignationId());
		attributes.put("gradeId", getGradeId());
		attributes.put("payLevelId", getPayLevelId());
		attributes.put("postId", getPostId());
		attributes.put("tradeId", getTradeId());
		attributes.put("cadreId", getCadreId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("subOrganizationId", getSubOrganizationId());
		attributes.put("gradeModeId", getGradeModeId());
		attributes.put("designationClassId", getDesignationClassId());
		attributes.put("designationGroupId", getDesignationGroupId());
		attributes.put("postName", getPostName());
		attributes.put("employmentStatus", getEmploymentStatus());
		attributes.put("dateOfJoining", getDateOfJoining());
		attributes.put(
			"dateOfJoiningOrganization", getDateOfJoiningOrganization());
		attributes.put("currentDesignationDate", getCurrentDesignationDate());
		attributes.put("retirementDate", getRetirementDate());
		attributes.put("joiningProcessId", getJoiningProcessId());
		attributes.put("processType", getProcessType());
		attributes.put("loginId", getLoginId());
		attributes.put("bioData", getBioData());
		attributes.put("message", getMessage());
		attributes.put("gpfNps", getGpfNps());
		attributes.put("gpfNpsNo", getGpfNpsNo());
		attributes.put("rank", getRank());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String personalNo = (String)attributes.get("personalNo");

		if (personalNo != null) {
			setPersonalNo(personalNo);
		}

		Long peopleId = (Long)attributes.get("peopleId");

		if (peopleId != null) {
			setPeopleId(peopleId);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
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

		Long cadreId = (Long)attributes.get("cadreId");

		if (cadreId != null) {
			setCadreId(cadreId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long subOrganizationId = (Long)attributes.get("subOrganizationId");

		if (subOrganizationId != null) {
			setSubOrganizationId(subOrganizationId);
		}

		Long gradeModeId = (Long)attributes.get("gradeModeId");

		if (gradeModeId != null) {
			setGradeModeId(gradeModeId);
		}

		Long designationClassId = (Long)attributes.get("designationClassId");

		if (designationClassId != null) {
			setDesignationClassId(designationClassId);
		}

		Long designationGroupId = (Long)attributes.get("designationGroupId");

		if (designationGroupId != null) {
			setDesignationGroupId(designationGroupId);
		}

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}

		Integer employmentStatus = (Integer)attributes.get("employmentStatus");

		if (employmentStatus != null) {
			setEmploymentStatus(employmentStatus);
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

		Date currentDesignationDate = (Date)attributes.get(
			"currentDesignationDate");

		if (currentDesignationDate != null) {
			setCurrentDesignationDate(currentDesignationDate);
		}

		Date retirementDate = (Date)attributes.get("retirementDate");

		if (retirementDate != null) {
			setRetirementDate(retirementDate);
		}

		Long joiningProcessId = (Long)attributes.get("joiningProcessId");

		if (joiningProcessId != null) {
			setJoiningProcessId(joiningProcessId);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String loginId = (String)attributes.get("loginId");

		if (loginId != null) {
			setLoginId(loginId);
		}

		String bioData = (String)attributes.get("bioData");

		if (bioData != null) {
			setBioData(bioData);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String gpfNps = (String)attributes.get("gpfNps");

		if (gpfNps != null) {
			setGpfNps(gpfNps);
		}

		String gpfNpsNo = (String)attributes.get("gpfNpsNo");

		if (gpfNpsNo != null) {
			setGpfNpsNo(gpfNpsNo);
		}

		Integer rank = (Integer)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
		}
	}

	/**
	 * Returns the bio data of this employee.
	 *
	 * @return the bio data of this employee
	 */
	@Override
	public String getBioData() {
		return model.getBioData();
	}

	/**
	 * Returns the cadre ID of this employee.
	 *
	 * @return the cadre ID of this employee
	 */
	@Override
	public long getCadreId() {
		return model.getCadreId();
	}

	/**
	 * Returns the company ID of this employee.
	 *
	 * @return the company ID of this employee
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee.
	 *
	 * @return the create date of this employee
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current designation date of this employee.
	 *
	 * @return the current designation date of this employee
	 */
	@Override
	public Date getCurrentDesignationDate() {
		return model.getCurrentDesignationDate();
	}

	/**
	 * Returns the date of joining of this employee.
	 *
	 * @return the date of joining of this employee
	 */
	@Override
	public Date getDateOfJoining() {
		return model.getDateOfJoining();
	}

	/**
	 * Returns the date of joining organization of this employee.
	 *
	 * @return the date of joining organization of this employee
	 */
	@Override
	public Date getDateOfJoiningOrganization() {
		return model.getDateOfJoiningOrganization();
	}

	/**
	 * Returns the designation class ID of this employee.
	 *
	 * @return the designation class ID of this employee
	 */
	@Override
	public long getDesignationClassId() {
		return model.getDesignationClassId();
	}

	/**
	 * Returns the designation group ID of this employee.
	 *
	 * @return the designation group ID of this employee
	 */
	@Override
	public long getDesignationGroupId() {
		return model.getDesignationGroupId();
	}

	/**
	 * Returns the designation ID of this employee.
	 *
	 * @return the designation ID of this employee
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the email ID of this employee.
	 *
	 * @return the email ID of this employee
	 */
	@Override
	public String getEmailId() {
		return model.getEmailId();
	}

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employment status of this employee.
	 *
	 * @return the employment status of this employee
	 */
	@Override
	public int getEmploymentStatus() {
		return model.getEmploymentStatus();
	}

	@Override
	public String getFullName_En() {
		return model.getFullName_En();
	}

	@Override
	public String getFullName_Hi() {
		return model.getFullName_Hi();
	}

	/**
	 * Returns the gpf nps of this employee.
	 *
	 * @return the gpf nps of this employee
	 */
	@Override
	public String getGpfNps() {
		return model.getGpfNps();
	}

	/**
	 * Returns the gpf nps no of this employee.
	 *
	 * @return the gpf nps no of this employee
	 */
	@Override
	public String getGpfNpsNo() {
		return model.getGpfNpsNo();
	}

	/**
	 * Returns the grade ID of this employee.
	 *
	 * @return the grade ID of this employee
	 */
	@Override
	public long getGradeId() {
		return model.getGradeId();
	}

	/**
	 * Returns the grade mode ID of this employee.
	 *
	 * @return the grade mode ID of this employee
	 */
	@Override
	public long getGradeModeId() {
		return model.getGradeModeId();
	}

	/**
	 * Returns the group ID of this employee.
	 *
	 * @return the group ID of this employee
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining process ID of this employee.
	 *
	 * @return the joining process ID of this employee
	 */
	@Override
	public long getJoiningProcessId() {
		return model.getJoiningProcessId();
	}

	/**
	 * Returns the login ID of this employee.
	 *
	 * @return the login ID of this employee
	 */
	@Override
	public String getLoginId() {
		return model.getLoginId();
	}

	/**
	 * Returns the message of this employee.
	 *
	 * @return the message of this employee
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the modified date of this employee.
	 *
	 * @return the modified date of this employee
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this employee.
	 *
	 * @return the organization ID of this employee
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the pay level ID of this employee.
	 *
	 * @return the pay level ID of this employee
	 */
	@Override
	public long getPayLevelId() {
		return model.getPayLevelId();
	}

	/**
	 * Returns the people ID of this employee.
	 *
	 * @return the people ID of this employee
	 */
	@Override
	public long getPeopleId() {
		return model.getPeopleId();
	}

	/**
	 * Returns the personal no of this employee.
	 *
	 * @return the personal no of this employee
	 */
	@Override
	public String getPersonalNo() {
		return model.getPersonalNo();
	}

	/**
	 * Returns the post ID of this employee.
	 *
	 * @return the post ID of this employee
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the post name of this employee.
	 *
	 * @return the post name of this employee
	 */
	@Override
	public String getPostName() {
		return model.getPostName();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process type of this employee.
	 *
	 * @return the process type of this employee
	 */
	@Override
	public String getProcessType() {
		return model.getProcessType();
	}

	/**
	 * Returns the rank of this employee.
	 *
	 * @return the rank of this employee
	 */
	@Override
	public int getRank() {
		return model.getRank();
	}

	/**
	 * Returns the retirement date of this employee.
	 *
	 * @return the retirement date of this employee
	 */
	@Override
	public Date getRetirementDate() {
		return model.getRetirementDate();
	}

	/**
	 * Returns the state of this employee.
	 *
	 * @return the state of this employee
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the status of this employee.
	 *
	 * @return the status of this employee
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this employee.
	 *
	 * @return the status by user ID of this employee
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this employee.
	 *
	 * @return the status by user name of this employee
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this employee.
	 *
	 * @return the status by user uuid of this employee
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this employee.
	 *
	 * @return the status date of this employee
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the sub organization ID of this employee.
	 *
	 * @return the sub organization ID of this employee
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the trade ID of this employee.
	 *
	 * @return the trade ID of this employee
	 */
	@Override
	public long getTradeId() {
		return model.getTradeId();
	}

	/**
	 * Returns the user ID of this employee.
	 *
	 * @return the user ID of this employee
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee.
	 *
	 * @return the user name of this employee
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee.
	 *
	 * @return the user uuid of this employee
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee.
	 *
	 * @return the uuid of this employee
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee is approved.
	 *
	 * @return <code>true</code> if this employee is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this employee is denied.
	 *
	 * @return <code>true</code> if this employee is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this employee is a draft.
	 *
	 * @return <code>true</code> if this employee is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this employee is expired.
	 *
	 * @return <code>true</code> if this employee is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this employee is inactive.
	 *
	 * @return <code>true</code> if this employee is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this employee is incomplete.
	 *
	 * @return <code>true</code> if this employee is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this employee is pending.
	 *
	 * @return <code>true</code> if this employee is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this employee is scheduled.
	 *
	 * @return <code>true</code> if this employee is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bio data of this employee.
	 *
	 * @param bioData the bio data of this employee
	 */
	@Override
	public void setBioData(String bioData) {
		model.setBioData(bioData);
	}

	/**
	 * Sets the cadre ID of this employee.
	 *
	 * @param cadreId the cadre ID of this employee
	 */
	@Override
	public void setCadreId(long cadreId) {
		model.setCadreId(cadreId);
	}

	/**
	 * Sets the company ID of this employee.
	 *
	 * @param companyId the company ID of this employee
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee.
	 *
	 * @param createDate the create date of this employee
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the current designation date of this employee.
	 *
	 * @param currentDesignationDate the current designation date of this employee
	 */
	@Override
	public void setCurrentDesignationDate(Date currentDesignationDate) {
		model.setCurrentDesignationDate(currentDesignationDate);
	}

	/**
	 * Sets the date of joining of this employee.
	 *
	 * @param dateOfJoining the date of joining of this employee
	 */
	@Override
	public void setDateOfJoining(Date dateOfJoining) {
		model.setDateOfJoining(dateOfJoining);
	}

	/**
	 * Sets the date of joining organization of this employee.
	 *
	 * @param dateOfJoiningOrganization the date of joining organization of this employee
	 */
	@Override
	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		model.setDateOfJoiningOrganization(dateOfJoiningOrganization);
	}

	/**
	 * Sets the designation class ID of this employee.
	 *
	 * @param designationClassId the designation class ID of this employee
	 */
	@Override
	public void setDesignationClassId(long designationClassId) {
		model.setDesignationClassId(designationClassId);
	}

	/**
	 * Sets the designation group ID of this employee.
	 *
	 * @param designationGroupId the designation group ID of this employee
	 */
	@Override
	public void setDesignationGroupId(long designationGroupId) {
		model.setDesignationGroupId(designationGroupId);
	}

	/**
	 * Sets the designation ID of this employee.
	 *
	 * @param designationId the designation ID of this employee
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the email ID of this employee.
	 *
	 * @param emailId the email ID of this employee
	 */
	@Override
	public void setEmailId(String emailId) {
		model.setEmailId(emailId);
	}

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employment status of this employee.
	 *
	 * @param employmentStatus the employment status of this employee
	 */
	@Override
	public void setEmploymentStatus(int employmentStatus) {
		model.setEmploymentStatus(employmentStatus);
	}

	/**
	 * Sets the gpf nps of this employee.
	 *
	 * @param gpfNps the gpf nps of this employee
	 */
	@Override
	public void setGpfNps(String gpfNps) {
		model.setGpfNps(gpfNps);
	}

	/**
	 * Sets the gpf nps no of this employee.
	 *
	 * @param gpfNpsNo the gpf nps no of this employee
	 */
	@Override
	public void setGpfNpsNo(String gpfNpsNo) {
		model.setGpfNpsNo(gpfNpsNo);
	}

	/**
	 * Sets the grade ID of this employee.
	 *
	 * @param gradeId the grade ID of this employee
	 */
	@Override
	public void setGradeId(long gradeId) {
		model.setGradeId(gradeId);
	}

	/**
	 * Sets the grade mode ID of this employee.
	 *
	 * @param gradeModeId the grade mode ID of this employee
	 */
	@Override
	public void setGradeModeId(long gradeModeId) {
		model.setGradeModeId(gradeModeId);
	}

	/**
	 * Sets the group ID of this employee.
	 *
	 * @param groupId the group ID of this employee
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining process ID of this employee.
	 *
	 * @param joiningProcessId the joining process ID of this employee
	 */
	@Override
	public void setJoiningProcessId(long joiningProcessId) {
		model.setJoiningProcessId(joiningProcessId);
	}

	/**
	 * Sets the login ID of this employee.
	 *
	 * @param loginId the login ID of this employee
	 */
	@Override
	public void setLoginId(String loginId) {
		model.setLoginId(loginId);
	}

	/**
	 * Sets the message of this employee.
	 *
	 * @param message the message of this employee
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the modified date of this employee.
	 *
	 * @param modifiedDate the modified date of this employee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this employee.
	 *
	 * @param organizationId the organization ID of this employee
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the pay level ID of this employee.
	 *
	 * @param payLevelId the pay level ID of this employee
	 */
	@Override
	public void setPayLevelId(long payLevelId) {
		model.setPayLevelId(payLevelId);
	}

	/**
	 * Sets the people ID of this employee.
	 *
	 * @param peopleId the people ID of this employee
	 */
	@Override
	public void setPeopleId(long peopleId) {
		model.setPeopleId(peopleId);
	}

	/**
	 * Sets the personal no of this employee.
	 *
	 * @param personalNo the personal no of this employee
	 */
	@Override
	public void setPersonalNo(String personalNo) {
		model.setPersonalNo(personalNo);
	}

	/**
	 * Sets the post ID of this employee.
	 *
	 * @param postId the post ID of this employee
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the post name of this employee.
	 *
	 * @param postName the post name of this employee
	 */
	@Override
	public void setPostName(String postName) {
		model.setPostName(postName);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process type of this employee.
	 *
	 * @param processType the process type of this employee
	 */
	@Override
	public void setProcessType(String processType) {
		model.setProcessType(processType);
	}

	/**
	 * Sets the rank of this employee.
	 *
	 * @param rank the rank of this employee
	 */
	@Override
	public void setRank(int rank) {
		model.setRank(rank);
	}

	/**
	 * Sets the retirement date of this employee.
	 *
	 * @param retirementDate the retirement date of this employee
	 */
	@Override
	public void setRetirementDate(Date retirementDate) {
		model.setRetirementDate(retirementDate);
	}

	/**
	 * Sets the state of this employee.
	 *
	 * @param state the state of this employee
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the status of this employee.
	 *
	 * @param status the status of this employee
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this employee.
	 *
	 * @param statusByUserId the status by user ID of this employee
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this employee.
	 *
	 * @param statusByUserName the status by user name of this employee
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this employee.
	 *
	 * @param statusByUserUuid the status by user uuid of this employee
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this employee.
	 *
	 * @param statusDate the status date of this employee
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the sub organization ID of this employee.
	 *
	 * @param subOrganizationId the sub organization ID of this employee
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets the trade ID of this employee.
	 *
	 * @param tradeId the trade ID of this employee
	 */
	@Override
	public void setTradeId(long tradeId) {
		model.setTradeId(tradeId);
	}

	/**
	 * Sets the user ID of this employee.
	 *
	 * @param userId the user ID of this employee
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee.
	 *
	 * @param userName the user name of this employee
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee.
	 *
	 * @param userUuid the user uuid of this employee
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee.
	 *
	 * @param uuid the uuid of this employee
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
	protected EmployeeWrapper wrap(Employee employee) {
		return new EmployeeWrapper(employee);
	}

}